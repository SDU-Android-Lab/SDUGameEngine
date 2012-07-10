package org.sdu.android.util.graphicsUtil;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

//TODO 记录存储部分要用SQLite实现

/**
 * 图的读取保存
 * 
 * @author yes_coffee
 * 
 */
public class GraphicsRestore {
	/**
	 * 我自己补充的为了完成所谓的本地加载
	 */
	private static ClassLoader classLoader;

	/**
	 * 为了弥补原有的类参数,原样移植过来
	 */
	final static public int DEFAULT_MAX_CACHE_SIZE = 20;

	/**
	 * 有序化的一組SImage
	 */
	final static private Map<String, SImage> LAZYIMAGES = Collections
			.synchronizedMap(new HashMap<String, SImage>(DEFAULT_MAX_CACHE_SIZE));
	/**
	 * 位图的一种格式，16位有透明度
	 */
	final static public BitmapFactory.Options ARGB4444OPTIONS = new BitmapFactory.Options();

	/**
	 * 位图的一种格式，32位有透明度
	 */
	final static public BitmapFactory.Options ARGB8888OPTIONS = new BitmapFactory.Options();

	/**
	 * 位图的一种格式，16位无透明度
	 */
	final static public BitmapFactory.Options RGB565OPTIONS = new BitmapFactory.Options();
	
	/**
	 * 用于构造文件格式
	 */
	final static String LSIGN = "\\";
	
	/**
	 * 用于构造文件格式
	 */
	final static String RSIGN = "/";

	/**
	 * 用于构造报错提示格式
	 */
	final static String LERROR = "File not found. ( "; 
	
	/**
	 * 用于构造报错提示格式
	 */
	final static String RERROR = ")"; 
	
	static {
		ARGB8888OPTIONS.inDither = false;
		// dither抖动（true时抖动）density密度
		ARGB8888OPTIONS.inPreferredConfig = Bitmap.Config.ARGB_8888;
		// 根据所指定的选项方式的设置来设置
		ARGB4444OPTIONS.inDither = false;
		ARGB4444OPTIONS.inPreferredConfig = Bitmap.Config.ARGB_4444;
		RGB565OPTIONS.inDither = false;
		RGB565OPTIONS.inPreferredConfig = Bitmap.Config.RGB_565;

		try {
			final String FIELDNAME = "inPurgeable";

			BitmapFactory.Options.class.getField(FIELDNAME).set(
					ARGB8888OPTIONS, true);
			BitmapFactory.Options.class.getField(FIELDNAME).set(
					ARGB4444OPTIONS, true);
			BitmapFactory.Options.class.getField(FIELDNAME).set(RGB565OPTIONS,
					true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加载标准位图文件
	 * 
	 * @param in
	 *            输入流
	 * @param transparency
	 *            透明度
	 * @return bitmap
	 */
	final static public Bitmap loadBitmap(InputStream in, boolean transparency) {
		return BitmapFactory.decodeStream(in, null,
				transparency ? ARGB4444OPTIONS : RGB565OPTIONS);
		// 对数据流进行分析以载入透明度选项为ARGB4444或RGB565的bitmap
	}

	/**
	 * 加载标准位图文件
	 * 
	 * @param resName
	 *            资源名
	 * @param transparency
	 *            透明度
	 * @return bitmap
	 * @throws IOException IO读入问题
	 */
	final static public Bitmap loadBitmap(String resName, boolean transparency) throws IOException {
			return BitmapFactory.decodeStream(GraphicsRestore
					.openResource(resName), null,
					transparency ? ARGB4444OPTIONS : RGB565OPTIONS);
		// 对数据流（用资源定位获取）进行分析以载入透明度选项为ARGB4444或RGB565的bitmap
	}

	/**
	 * 以指定大小加载指定的位图文件
	 * 
	 * @param resName
	 *            资源名
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @return bitmap
	 * @throws IOException IO读入问题
	 */
	final static public Bitmap loadScaleBitmap(String resName, int width,
			int height) throws IOException {

		final BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;

		BitmapFactory.decodeStream(GraphicsRestore.openResource(resName), null,
				opts);

		final int scaleWidth = (int) Math.floor((double) opts.outWidth / width);
		// Math.floor(x) -- 返回小于等于数字参数的最大整数
		final int scaleHeight = (int) Math.floor((double) opts.outHeight
				/ height);

		opts.inJustDecodeBounds = false;
		opts.inSampleSize = Math.min(scaleWidth, scaleHeight);

		return BitmapFactory.decodeStream(
				GraphicsRestore.openResource(resName), null, opts);

	}

	/**
	 * 以指定大小加载指定的SImage文件
	 * 
 * @param resName
	 *            资源名
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @return SImage
	 * @throws IOException IO读入问题
	 */
	final static public SImage loadScaleImage(String resName, int width,
			int height) throws IOException{
		return new SImage(loadScaleBitmap(resName, width, height));
	}

	/**
	 * 加载SImage
	 *
	 * @param in 输入流
	 * @param transparency 透明度
	 * @return SImage
	 */
	final static public SImage loadImage(InputStream in, boolean transparency) {
		return new SImage(BitmapFactory.decodeStream(in, null,
				transparency ? ARGB4444OPTIONS : RGB565OPTIONS));
	}

	/**
	 * 以ARGB8888格式加载SImage
	 * 
	 * @param in 输入流
	 * @return SImage
	 */
	final static public SImage load8888Image(InputStream in) {
		return new SImage(BitmapFactory.decodeStream(in, null, ARGB8888OPTIONS));
	}

	/**
	 * 以ARGB8888格式加载SImage
	 * 
	 * @param fileName 文件名
	 * @return SImage
	 * @throws IOException IO读入问题
	 */
	final static public SImage load8888Image(String fileName) throws IOException {
			return new SImage(BitmapFactory.decodeStream(GraphicsRestore
					.openResource(fileName), null, ARGB8888OPTIONS));
	}

	/** 
	 * 加载SImage
	 *  
	 * @param buffer 缓冲
	 * @param transparency 透明度
	 * @return SImage
	 */
	final static public SImage loadImage(byte[] buffer, boolean transparency) {
		return new SImage(BitmapFactory.decodeByteArray(buffer, 0,
				buffer.length, transparency ? ARGB4444OPTIONS : RGB565OPTIONS));
	}

	/**
	 * 加载SImage
	 * 
	 * @param imageData 图像数据
	 * @param imageOffset 图像数据偏移
	 * @param imageLength 图像数据长度
	 * @param transparency 透明度
	 * @return SImage
	 */
	final static public SImage loadImage(byte[] imageData, int imageOffset,
			int imageLength, boolean transparency) {
		return new SImage(BitmapFactory.decodeByteArray(imageData, imageOffset,
				imageLength, transparency ? ARGB4444OPTIONS : RGB565OPTIONS));
	}

	/**
	 * 加载SImage 带缓冲的加载方式，利用MAP缓冲
	 * 
	 * @param innerFileName Map中内部文件名
	 * @param transparency 透明度
	 * @return SImage
	 */
	final static public SImage loadImage(final String innerFileName,
			boolean transparency) {
		if (innerFileName == null) {
			return null;}
		if (LAZYIMAGES.size() > DEFAULT_MAX_CACHE_SIZE) {
			LAZYIMAGES.clear();
			System.gc();}
		final String keyName = replaceIgnoreCase(innerFileName, LSIGN, RSIGN);
		SImage image = (SImage) LAZYIMAGES.get(keyName);
		InputStream in = null;
		if (image != null && !image.isClose()) {
			return image;
		} else {
			in = GraphicsRestore.openResource(innerFileName);
				image = loadImage(in, transparency);
				LAZYIMAGES.remove(keyName);
				LAZYIMAGES.put(keyName, image);
		}
		try {
			if (in != null) {in.close();in = null;}
			} catch (IOException e) {System.gc();}
		if (image == null) {
			throw new RuntimeException(
					(LERROR + innerFileName + RERROR).intern());
		}
		return image;
	}

	/**
	 * 加载SImage无透明度
	 * 
	 * @param innerFileName Map中内部文件名
	 * @return SImage
	 */
	final static public SImage loadImage(final String innerFileName) {
		return GraphicsRestore. loadNotCacheImage(innerFileName, false);
	}

	/**
	 * 不匹配大小写的过滤指定字符串
	 * 
	 * @param line 字符串
	 * @param oldString 要替换的字符
	 * @param newString 替换为字符
	 * @return 替换后的字符串
	 */
	public static final String replaceIgnoreCase(String line, String oldString,
			String newString) {
		if (line == null){
			return null;}
		final String lcLine = line.toLowerCase();
		final String lcOldString = oldString.toLowerCase();
		int i = 0;
		i = lcLine.indexOf(lcOldString, i);
		if (i >= 0) {
			i = lcLine.indexOf(lcOldString, i);
			final char[] line2 = line.toCharArray();
			final char[] newString2 = newString.toCharArray();
			final int oLength = oldString.length();
			final StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j;
			i = lcLine.indexOf(lcOldString, i);
			for (j = i; i > 0; j = i) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				i = lcLine.indexOf(lcOldString, i);
			}

			buf.append(line2, j, line2.length - j);
			return buf.toString();
		} else {
			return line;
		}
	}
	
	/**
	 * 加载SImage 不带缓冲的加载方式
	 * 
	 * @param innerFileName Map中内部文件名
	 * @param transparency 透明度
	 * @return SImage
	 */
	final static public SImage loadNotCacheImage(final String innerFileName,
			boolean transparency) {
		if (innerFileName == null) {
			return null;
		}
		final String innerName = replaceIgnoreCase(innerFileName, LSIGN, RSIGN);
		InputStream in = null;
		in = GraphicsRestore.openResource(innerName);
		final SImage sImageResult = loadImage(in, transparency);
		if (in != null) {
			try {
				in.close();
				in = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sImageResult;
	}
	
	/**
	 * 加载SImage 不带缓冲的加载方式
	 * 
	 * @param innerFileName Map中内部文件名
	 * @return SImage
	 */
	final static public SImage loadNotCacheImage(final String innerFileName) {
		return GraphicsRestore.loadNotCacheImage(innerFileName, false);
	}

	/**
	 * 加载网络中图像
	 * 
	 * @param string url地址
	 * @param transparency 透明度
	 * @return SImage
	 */
	public static SImage loadWebImage(String string, boolean transparency) {
		SImage img = null;
		try {
			final URL url = new URL(string);
			final HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("GET");
			http.connect();
			final InputStream is = http.getInputStream();
			img = GraphicsRestore.loadImage(is, transparency);
			if (img.getWidth() == 0 || img.getHeight() == 0) {
				img = null;
			}
			is.close();
		} catch (IOException e) {
			throw new RuntimeException((LERROR + string + RERROR)
					.intern());
		}
		return img;
	}

	/**
	 * 获得一组序号连续的图片
	 * 
	 * @param fileName 文件名
	 * @param range (指定图片范围，如("1-2")) 要求格式如前，图片组本身的格式为filenamei.XXX其中i为序号
	 * @param transparency 透明度 
	 * @return SImage[]
	 */
	public static SImage[] loadSequenceImages(String fileName, String range,
			boolean transparency) {
		int start_range = -1;
		int end_range = -1;
		int images_count = 1;
		final int minusIndex = range.indexOf('-');
		if ((minusIndex > 0) && (minusIndex < (range.length() - 1))) {
			start_range = Integer.parseInt(range.substring(0,minusIndex));
			end_range = Integer.parseInt(range.substring(minusIndex + 1));
			if (start_range < end_range) {
				images_count = end_range - start_range + 1;
			}
		}
		final SImage[] images = new SImage[images_count];
		for (int i = 0; i < images_count; i++) {
			String imageName = fileName;
			if (images_count > 1) {
				final int dotIndex = fileName.lastIndexOf('.');
				if (dotIndex >= 0) {
					imageName = fileName.substring(0, dotIndex) 
					+ (start_range + i) + fileName.substring(dotIndex);
				}
			}
			images[i] = GraphicsRestore.loadImage(imageName, transparency);
		}
		return images;
	}

	// TODO 此处尚未完成存储部分，先重新构造一个存储类，然后在开始完善
	/*	
	 * 
	 *  
	 *  *//**
	 * 加载本地存储环境中图片资源
	 * 
	 * @param recordStore
	 *            //J2ME下的永久存储，类似数据库，但功能比数据库要弱得多。
	 * @param resourceName
	 * @return
	 */
	/*
	 * static public SImage loadAsPNG(String recordStore, String resourceName) {
	 * RecordStore imagesRS = null; SImage img = null; try { imagesRS =
	 * RecordStore.openRecordStore(recordStore,
	 * true);//打开名字叫recordStore的RS若不存在则新建 RecordEnumeration re =
	 * imagesRS.enumerateRecords(null, null, true); int numRecs =
	 * re.numRecords();
	 * 
	 * for (int i = 1; i < numRecs; i++) { int recId = re.nextRecordId(); byte[]
	 * rec = imagesRS.getRecord(recId); ByteArrayInputStream bin = new
	 * ByteArrayInputStream(rec); DataInputStream din = new
	 * DataInputStream(bin); String name = din.readUTF();
	 * 
	 * if (name.equals(resourceName) == false) { continue; } int width =
	 * din.readInt(); int height = din.readInt(); din.readLong(); int length =
	 * din.readInt();
	 * 
	 * int[] rawImg = new int[width * height];
	 * 
	 * for (i = 0; i < length; i++) { rawImg[i] = din.readInt(); } img =
	 * SImage.createRGBImage(rawImg, width, height, false); din.close();
	 * bin.close(); } } catch (InvalidRecordIDException ignore) {
	 * 
	 * } catch (Exception e) {
	 * 
	 * } finally { try {
	 * 
	 * if (imagesRS != null) imagesRS.closeRecordStore(); } catch (Exception
	 * ignore) {
	 * 
	 * } } return img; }
	 *//**
	 * 将图像保存到本地存储环境中
	 * 
	 * @param recordStore
	 * @param resourceName
	 * @param image
	 * @return
	 */
	/*
	 * public static int saveAsPNG(String recordStore, String resourceName,
	 * SImage image) { RecordStore imagesRS = null;
	 * 
	 * if (resourceName == null) { return -1; }
	 * 
	 * try { int[] buffer = image.getPixels(); imagesRS =
	 * RecordStore.openRecordStore(recordStore, true);
	 * 
	 * ByteArrayOutputStream bout = new ByteArrayOutputStream();
	 * DataOutputStream dout = new DataOutputStream(bout);
	 * 
	 * dout.writeUTF(resourceName); dout.writeInt(image.getWidth());
	 * dout.writeInt(image.getHeight());
	 * dout.writeLong(System.currentTimeMillis()); dout.writeInt(buffer.length);
	 * 
	 * for (int i = 0; i < buffer.length; i++) { dout.writeInt(buffer[i]); }
	 * dout.flush(); dout.close(); byte[] data = bout.toByteArray(); return
	 * imagesRS.addRecord(data, 0, data.length); } catch (Exception e) { throw
	 * new RuntimeException("Save the image [" + resourceName +
	 * "] to RecordStore [" + recordStore + "] failed!"); } finally { try { if
	 * (imagesRS != null) imagesRS.closeRecordStore(); } catch (Exception
	 * ignore) { } }
	 * 
	 * }
	 */
	
	/**
	 * 将指定图像保存为PNG格式
	 * 
	 * @param bitmap 位图
	 * @param fileName 文件名 
	 * @return boolean
	 * @throws FileNotFoundException 文件未找到
	 */
	public static boolean saveAsPNG(Bitmap bitmap, String fileName)
			throws FileNotFoundException {
		return bitmap.compress(Bitmap.CompressFormat.PNG, 1,
				new FileOutputStream(fileName));
	}

	/**
	 * 将指定图像保存为PNG格式
	 * 
	 * @param image 图片
	 * @param fileName 文件名
	 * @return boolean
	 * @throws FileNotFoundException 文件未找到
	 */
	public static boolean saveAsPNG(SImage image, String fileName)
			throws FileNotFoundException {
		return image.getBitmap().compress(Bitmap.CompressFormat.PNG, 1,
				new FileOutputStream(fileName));
	}

	/**
	 * 生成Bitmap文件的hash序列
	 * 
	 * @param bitmap 位图
	 * @return int 
	 */
	public static int hashBitmap(Bitmap bitmap) {
		int hash_result = 0;
		final int yiwei = 7;
		final int pixelYu = 20;//pixel域
		final int pixelWBili = 50;//pixel域
		final int pixelHBili = 100;//pixel域
		final int w = bitmap.getWidth();
		final int h = bitmap.getHeight();
		hash_result = (hash_result << yiwei) ^ h;
		hash_result = (hash_result << yiwei) ^ w;
		for (int pixel = 0; pixel < pixelYu; ++pixel) {
			final int x = (pixel * pixelWBili) % w;
			final int y = (pixel * pixelHBili) % h;
			hash_result = (hash_result << yiwei) ^ bitmap.getPixel(x, y);
		}
		return hash_result;
	}

	/**
	 * 清空缓存
	 */
	public static void destroy() {
		LAZYIMAGES.clear();
	}

	/**
	 * 打开当前类加载器下的资源文件
	 * 
	 * @param resName 资源名
	 * @return InputStream
	 * 是否要try catch?????
	 */
	private static InputStream openResource(String resName){
		classLoader = GraphicsRestore.class.getClassLoader();
		BufferedInputStream in = null;
		in = new BufferedInputStream(classLoader.getResourceAsStream(resName));
		return in;
	}
}
