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

//TODO ��¼�洢����Ҫ��SQLiteʵ��

/**
 * ͼ�Ķ�ȡ����
 * 
 * @author yes_coffee
 * 
 */
public class GraphicsRestore {
	/**
	 * ���Լ������Ϊ�������ν�ı��ؼ���
	 */
	private static ClassLoader classLoader;

	/**
	 * Ϊ���ֲ�ԭ�е������,ԭ����ֲ����
	 */
	final static public int DEFAULT_MAX_CACHE_SIZE = 20;

	/**
	 * ���򻯵�һ�MSImage
	 */
	final static private Map<String, SImage> LAZYIMAGES = Collections
			.synchronizedMap(new HashMap<String, SImage>(DEFAULT_MAX_CACHE_SIZE));
	/**
	 * λͼ��һ�ָ�ʽ��16λ��͸����
	 */
	final static public BitmapFactory.Options ARGB4444OPTIONS = new BitmapFactory.Options();

	/**
	 * λͼ��һ�ָ�ʽ��32λ��͸����
	 */
	final static public BitmapFactory.Options ARGB8888OPTIONS = new BitmapFactory.Options();

	/**
	 * λͼ��һ�ָ�ʽ��16λ��͸����
	 */
	final static public BitmapFactory.Options RGB565OPTIONS = new BitmapFactory.Options();
	
	/**
	 * ���ڹ����ļ���ʽ
	 */
	final static String LSIGN = "\\";
	
	/**
	 * ���ڹ����ļ���ʽ
	 */
	final static String RSIGN = "/";

	/**
	 * ���ڹ��챨����ʾ��ʽ
	 */
	final static String LERROR = "File not found. ( "; 
	
	/**
	 * ���ڹ��챨����ʾ��ʽ
	 */
	final static String RERROR = ")"; 
	
	static {
		ARGB8888OPTIONS.inDither = false;
		// dither������trueʱ������density�ܶ�
		ARGB8888OPTIONS.inPreferredConfig = Bitmap.Config.ARGB_8888;
		// ������ָ����ѡ�ʽ������������
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
	 * ���ر�׼λͼ�ļ�
	 * 
	 * @param in
	 *            ������
	 * @param transparency
	 *            ͸����
	 * @return bitmap
	 */
	final static public Bitmap loadBitmap(InputStream in, boolean transparency) {
		return BitmapFactory.decodeStream(in, null,
				transparency ? ARGB4444OPTIONS : RGB565OPTIONS);
		// �����������з���������͸����ѡ��ΪARGB4444��RGB565��bitmap
	}

	/**
	 * ���ر�׼λͼ�ļ�
	 * 
	 * @param resName
	 *            ��Դ��
	 * @param transparency
	 *            ͸����
	 * @return bitmap
	 * @throws IOException IO��������
	 */
	final static public Bitmap loadBitmap(String resName, boolean transparency) throws IOException {
			return BitmapFactory.decodeStream(GraphicsRestore
					.openResource(resName), null,
					transparency ? ARGB4444OPTIONS : RGB565OPTIONS);
		// ��������������Դ��λ��ȡ�����з���������͸����ѡ��ΪARGB4444��RGB565��bitmap
	}

	/**
	 * ��ָ����С����ָ����λͼ�ļ�
	 * 
	 * @param resName
	 *            ��Դ��
	 * @param width
	 *            ��
	 * @param height
	 *            ��
	 * @return bitmap
	 * @throws IOException IO��������
	 */
	final static public Bitmap loadScaleBitmap(String resName, int width,
			int height) throws IOException {

		final BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inJustDecodeBounds = true;

		BitmapFactory.decodeStream(GraphicsRestore.openResource(resName), null,
				opts);

		final int scaleWidth = (int) Math.floor((double) opts.outWidth / width);
		// Math.floor(x) -- ����С�ڵ������ֲ������������
		final int scaleHeight = (int) Math.floor((double) opts.outHeight
				/ height);

		opts.inJustDecodeBounds = false;
		opts.inSampleSize = Math.min(scaleWidth, scaleHeight);

		return BitmapFactory.decodeStream(
				GraphicsRestore.openResource(resName), null, opts);

	}

	/**
	 * ��ָ����С����ָ����SImage�ļ�
	 * 
 * @param resName
	 *            ��Դ��
	 * @param width
	 *            ��
	 * @param height
	 *            ��
	 * @return SImage
	 * @throws IOException IO��������
	 */
	final static public SImage loadScaleImage(String resName, int width,
			int height) throws IOException{
		return new SImage(loadScaleBitmap(resName, width, height));
	}

	/**
	 * ����SImage
	 *
	 * @param in ������
	 * @param transparency ͸����
	 * @return SImage
	 */
	final static public SImage loadImage(InputStream in, boolean transparency) {
		return new SImage(BitmapFactory.decodeStream(in, null,
				transparency ? ARGB4444OPTIONS : RGB565OPTIONS));
	}

	/**
	 * ��ARGB8888��ʽ����SImage
	 * 
	 * @param in ������
	 * @return SImage
	 */
	final static public SImage load8888Image(InputStream in) {
		return new SImage(BitmapFactory.decodeStream(in, null, ARGB8888OPTIONS));
	}

	/**
	 * ��ARGB8888��ʽ����SImage
	 * 
	 * @param fileName �ļ���
	 * @return SImage
	 * @throws IOException IO��������
	 */
	final static public SImage load8888Image(String fileName) throws IOException {
			return new SImage(BitmapFactory.decodeStream(GraphicsRestore
					.openResource(fileName), null, ARGB8888OPTIONS));
	}

	/** 
	 * ����SImage
	 *  
	 * @param buffer ����
	 * @param transparency ͸����
	 * @return SImage
	 */
	final static public SImage loadImage(byte[] buffer, boolean transparency) {
		return new SImage(BitmapFactory.decodeByteArray(buffer, 0,
				buffer.length, transparency ? ARGB4444OPTIONS : RGB565OPTIONS));
	}

	/**
	 * ����SImage
	 * 
	 * @param imageData ͼ������
	 * @param imageOffset ͼ������ƫ��
	 * @param imageLength ͼ�����ݳ���
	 * @param transparency ͸����
	 * @return SImage
	 */
	final static public SImage loadImage(byte[] imageData, int imageOffset,
			int imageLength, boolean transparency) {
		return new SImage(BitmapFactory.decodeByteArray(imageData, imageOffset,
				imageLength, transparency ? ARGB4444OPTIONS : RGB565OPTIONS));
	}

	/**
	 * ����SImage ������ļ��ط�ʽ������MAP����
	 * 
	 * @param innerFileName Map���ڲ��ļ���
	 * @param transparency ͸����
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
	 * ����SImage��͸����
	 * 
	 * @param innerFileName Map���ڲ��ļ���
	 * @return SImage
	 */
	final static public SImage loadImage(final String innerFileName) {
		return GraphicsRestore. loadNotCacheImage(innerFileName, false);
	}

	/**
	 * ��ƥ���Сд�Ĺ���ָ���ַ���
	 * 
	 * @param line �ַ���
	 * @param oldString Ҫ�滻���ַ�
	 * @param newString �滻Ϊ�ַ�
	 * @return �滻����ַ���
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
	 * ����SImage ��������ļ��ط�ʽ
	 * 
	 * @param innerFileName Map���ڲ��ļ���
	 * @param transparency ͸����
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
	 * ����SImage ��������ļ��ط�ʽ
	 * 
	 * @param innerFileName Map���ڲ��ļ���
	 * @return SImage
	 */
	final static public SImage loadNotCacheImage(final String innerFileName) {
		return GraphicsRestore.loadNotCacheImage(innerFileName, false);
	}

	/**
	 * ����������ͼ��
	 * 
	 * @param string url��ַ
	 * @param transparency ͸����
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
	 * ���һ�����������ͼƬ
	 * 
	 * @param fileName �ļ���
	 * @param range (ָ��ͼƬ��Χ����("1-2")) Ҫ���ʽ��ǰ��ͼƬ�鱾��ĸ�ʽΪfilenamei.XXX����iΪ���
	 * @param transparency ͸���� 
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

	// TODO �˴���δ��ɴ洢���֣������¹���һ���洢�࣬Ȼ���ڿ�ʼ����
	/*	
	 * 
	 *  
	 *  *//**
	 * ���ر��ش洢������ͼƬ��Դ
	 * 
	 * @param recordStore
	 *            //J2ME�µ����ô洢���������ݿ⣬�����ܱ����ݿ�Ҫ���öࡣ
	 * @param resourceName
	 * @return
	 */
	/*
	 * static public SImage loadAsPNG(String recordStore, String resourceName) {
	 * RecordStore imagesRS = null; SImage img = null; try { imagesRS =
	 * RecordStore.openRecordStore(recordStore,
	 * true);//�����ֽ�recordStore��RS�����������½� RecordEnumeration re =
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
	 * ��ͼ�񱣴浽���ش洢������
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
	 * ��ָ��ͼ�񱣴�ΪPNG��ʽ
	 * 
	 * @param bitmap λͼ
	 * @param fileName �ļ��� 
	 * @return boolean
	 * @throws FileNotFoundException �ļ�δ�ҵ�
	 */
	public static boolean saveAsPNG(Bitmap bitmap, String fileName)
			throws FileNotFoundException {
		return bitmap.compress(Bitmap.CompressFormat.PNG, 1,
				new FileOutputStream(fileName));
	}

	/**
	 * ��ָ��ͼ�񱣴�ΪPNG��ʽ
	 * 
	 * @param image ͼƬ
	 * @param fileName �ļ���
	 * @return boolean
	 * @throws FileNotFoundException �ļ�δ�ҵ�
	 */
	public static boolean saveAsPNG(SImage image, String fileName)
			throws FileNotFoundException {
		return image.getBitmap().compress(Bitmap.CompressFormat.PNG, 1,
				new FileOutputStream(fileName));
	}

	/**
	 * ����Bitmap�ļ���hash����
	 * 
	 * @param bitmap λͼ
	 * @return int 
	 */
	public static int hashBitmap(Bitmap bitmap) {
		int hash_result = 0;
		final int yiwei = 7;
		final int pixelYu = 20;//pixel��
		final int pixelWBili = 50;//pixel��
		final int pixelHBili = 100;//pixel��
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
	 * ��ջ���
	 */
	public static void destroy() {
		LAZYIMAGES.clear();
	}

	/**
	 * �򿪵�ǰ��������µ���Դ�ļ�
	 * 
	 * @param resName ��Դ��
	 * @return InputStream
	 * �Ƿ�Ҫtry catch?????
	 */
	private static InputStream openResource(String resName){
		classLoader = GraphicsRestore.class.getClassLoader();
		BufferedInputStream in = null;
		in = new BufferedInputStream(classLoader.getResourceAsStream(resName));
		return in;
	}
}
