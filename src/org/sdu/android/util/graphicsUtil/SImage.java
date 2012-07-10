package org.sdu.android.util.graphicsUtil;

import java.io.InputStream;

import org.sdu.android.SystemData;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;

/**
 * 图的包装类
 * 
 * @author yes_coffee
 * 
 */
public class SImage {

		/**
		 * 位图
		 */
		private Bitmap bitmap;

		/**
		 * 宽
		 */
		private int width;
		
		/**
		 * 高
		 */
		private int height;

		/**
		 * 是否关闭
		 */
		private boolean close;

		/**
		 * 创建 SImage
		 * @param in 输入流
		 * @param transparency 透明度
		 * @return SImage
		 */
		public static SImage createImage(InputStream in, boolean transparency) {
			return GraphicsRestore.loadImage(in, transparency);
		}

		/**
		 * 创建 SImage
		 * @param buffer 字节流
		 * @return SImage
		 */
		public static SImage createImage(byte[] buffer) {
			return GraphicsRestore.loadImage(buffer, true);
		}

		/**
		 * 创建 SImage
		 * @param buffer 字节流
		 * @param transparency 透明度
		 * @return SImage
		 */
		public static SImage createImage(byte[] buffer, boolean transparency) {
			return GraphicsRestore.loadImage(buffer, transparency);
		}

		/**
		 * 创建 SImage
		 * @param width 宽
		 * @param height 高
		 * @param transparency 透明度
		 * @return SImage
		 */
		public static SImage createImage(int width, int height, boolean transparency) {
			return new SImage(width, height, transparency);
		}

		/**
		 * 创建 SImage
		 * @param width 宽
		 * @param height 高
		 * @return SImage
		 */
		public static SImage createImage(int width, int height) {
			return new SImage(width, height, false);
		}

		/**
		 * 创建 SImage
		 * @param width 宽
		 * @param height 高
		 * @param config 设置方式
		 * @return SImage
		 */
		public static SImage createImage(int width, int height, Config config) {
			return new SImage(width, height, config);
		}

		/**
		 * 创建 SImage
		 * @param imageData Image数据
		 * @param imageOffset Image数据偏移
		 * @param imageLength Image长度
		 * @param transparency 透明度
		 * @return SImage
		 */
		public static SImage createImage(byte[] imageData, int imageOffset,
				int imageLength, boolean transparency) {
			return GraphicsRestore.loadImage(imageData, imageOffset, imageLength,
					transparency);
		}

		/**
		 * 创建 SImage
		 * @param imageData Image数据
		 * @param imageOffset Image数据偏移
		 * @param imageLength Image长度
		 * @return SImage
		 */
		public static SImage createImage(byte[] imageData, int imageOffset,
				int imageLength) {
			return GraphicsRestore.loadImage(imageData, imageOffset, imageLength,
					false);
		}

		/**
		 * 创建 SImage
		 * @param fileName 文件名
		 * @return SImage
		 */
		public static SImage createImage(String fileName) {
			String res;
			if (fileName.startsWith("/")) {
				res = fileName.substring(1);
			} else {
				res = fileName;
			}
			return GraphicsRestore.loadImage(res);
		}

		/**
		 * 创建 SImage
		 * @param resName 资源文件名
		 * @return SImage
		 */
		public static SImage createImage(int resName) {
			final Bitmap bitmap = BitmapFactory.decodeResource(
					SystemData.getCurrentActivity().getResources(), resName);
			return new SImage(bitmap);
		}
		
		/**
		 * 以指定像素集合生成SImage文件
		 * 
		 * @param rgb ARGB设置
		 * @param width 宽
		 * @param height 高
		 * @param processAlpha ARGB高位是否忽略，即是否透明 
		 * @return SImage
		 */
		public static final SImage createRGBImage(int[] rgb, int width, int height,
				boolean processAlpha) {
			Bitmap bitmap = null;
			try {
				Bitmap.Config config;
				if (processAlpha) {
					config = Bitmap.Config.ARGB_4444;
				} else {
					config = Bitmap.Config.RGB_565;
				}
				bitmap = Bitmap.createBitmap(rgb, width, height, config);
			} catch (RuntimeException e) {
				System.gc();
				Bitmap.Config config;
				if (processAlpha) {
					config = Bitmap.Config.ARGB_4444;
				} else {
					config = Bitmap.Config.RGB_565;
				}
				bitmap = Bitmap.createBitmap(rgb, width, height, config);
			}
			return new SImage(bitmap);
		}

		/**
		 * 创建指定数量的SImage
		 * 
		 * @param count 数量
		 * @param w 宽
		 * @param h 高
		 * @param transparency 透明度
		 * @return SImage[]
		 */
		public static SImage[] createImage(int count, int w, int h,
				boolean transparency) {
			final SImage[] image = new SImage[count];
			for (int i = 0; i < image.length; i++) {
				image[i] = new SImage(w, h, transparency);
			}
			return image;
		}

		/**
		 * 创建指定数量的SImage
		 * 
		 * @param count 数量
		 * @param w 宽
		 * @param h 高
		 * @param config 设置
		 * @return SImage[]
		 */
		public static SImage[] createImage(int count, int w, int h, Config config) {
			final SImage[] image = new SImage[count];
			for (int i = 0; i < image.length; i++) {
				image[i] = new SImage(w, h, config);
			}
			return image;
		}

		/**
		 * 构建一个SImage
		 * @param width 宽
		 * @param height 高
		 */
		public SImage(int width, int height) {
			this(width, height, false);
		}

		/**
		 * 构建一个SImage(true:ARGB4444或false:RGB565)
		 * 
		 * @param width 宽
		 * @param height 高
		 * @param transparency 透明度
		 */
		public SImage(int width, int height, boolean transparency) {
			try {
				System.gc();
				this.width = width;
				this.height = height;
				if (transparency) {
					this.bitmap = Bitmap.createBitmap(width, height,
							Bitmap.Config.ARGB_4444);
				} else {
					this.bitmap = Bitmap.createBitmap(width, height,
							Bitmap.Config.RGB_565);
				}
			} catch (RuntimeException e) {
				try {
					System.gc();
					this.width = width;
					this.height = height;
					this.bitmap = Bitmap.createBitmap(width, height,
							Bitmap.Config.RGB_565);
				} catch (RuntimeException ex) {
					ex.printStackTrace();
				}
			}
		}

		/**
		 * 构建一个SImage
		 * @param width 宽
		 * @param height 高
		 * @param config 设置
		 */
		public SImage(int width, int height, Config config) {
			this.width = width;
			this.height = height;
			this.bitmap = Bitmap.createBitmap(width, height, config);
		}

		/**
		 * 构建一个SImage
		 * @param img SImage
		 */
		public SImage(SImage img) {
			this(img.getBitmap());
		}

		/**
		 * 构建一个SImage
		 * @param bitmap 位图
		 */
		public SImage(Bitmap bitmap) {
			setBitmap(bitmap);
		}

		/**
		 * 设置位图
		 * @param bitmap 位图
		 */
		public void setBitmap(Bitmap bitmap) {
			this.width = bitmap.getWidth();
			this.height = bitmap.getHeight();
			this.bitmap = bitmap;
		}

		/**
		 * 得到配置信息
		 * @return Config
		 */
		public Config getConfig() {
			final Config config = bitmap.getConfig();
			if (config == null) {
				return Config.ARGB_8888;
			}
			return config;
		}

		/**
		 * 克隆方法
		 * @return SImage
		 */
		@Override
		public SImage clone() {
			try {
				super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return new SImage(bitmap);
		}

		/**
		 * 得到位图
		 * @return Bitmap
		 */
		public Bitmap getBitmap() {
			return bitmap;
		}

		/**
		 * 得到图宽
		 * @return int
		 */
		public int getWidth() {
			return bitmap.getWidth();
		}

		/**
		 * 得到图高
		 * @return int
		 */
		public int getHeight() {
			return bitmap.getHeight();
		}

		/**
		 * 得到图像素组
		 * @return int[]
		 */
		public int[] getPixels() {
			final int[] pixels = new int[width * height];
			bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
			return pixels;
		}

		/**
		 * 获取位图像素的复制信息
		 * @param pixels 像素组
		 * @return int[]
		 */
		public int[] getPixels(int[] pixels) {
			bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
			return pixels;
		}

		/**
		 * 获取位图像素的复制信息
		 * @param x 起点X
		 * @param y 起点Y
		 * @param w 宽
		 * @param h 高
		 * @return int[]
		 */
		public int[] getPixels(int x, int y, int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.getPixels(pixels, 0, w, x, y, w, h);
			return pixels;
		}

		/**
		 * 获取位图像素的复制信息
		 * @param offset 偏移
		 * @param stride 幅度
		 * @param x 起点X
		 * @param y 起点Y
		 * @param w 宽
		 * @param h 高
		 * @return int[]
		 */
		public int[] getPixels(int offset, int stride, int x, int y, int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.getPixels(pixels, offset, stride, x, y, w, h);
			return pixels;
		}

		/**
		 * 设置像素组
		 * @param pixels 像素组
		 * @param w 宽
		 * @param h 高
		 */
		public void setPixels(int[] pixels, int w, int h) {
			bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
		}

		/**
		 * 设置像素组
		 * @param offset 偏移
		 * @param stride 幅度
		 * @param x 起点X
		 * @param y 起点Y
		 * @param w 宽
		 * @param h 高
		 */
		public void setPixels(int offset, int stride, int x, int y,
				int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.setPixels(pixels, offset, stride, x, y, w, h);
		}

		/**
		 * 设置并返回像素组
		 * @param pixels 像素组
		 * @param x 起点X
		 * @param y 起点Y
		 * @param w 宽
		 * @param h 高
		 * @return pixels
		 */
		public int[] setPixels(int[] pixels, int x, int y, int w, int h) {
			bitmap.setPixels(pixels, 0, w, x, y, w, h);
			return pixels;
		}

		/**
		 * 获取某点的像素值
		 * @param x X坐标
		 * @param y Y坐标
		 * @return pixel值
		 */
		public int getPixel(int x, int y) {
			return bitmap.getPixel(x, y);
		}

		/**
		 * 得到位图RGB
		 * @param offset 偏移
		 * @param stride 幅度
		 * @param x 起点X
		 * @param y 起点Y
		 * @param w 宽
		 * @param h 高
		 * @return pixels
		 */
		public int[] getRGB(int offset, int stride, int x, int y,
				int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.getPixels(pixels, offset, stride, x, y, w, h);
			return pixels;
		}

		/**
		 * 得到像素点RGB
		 * @param x X坐标
		 * @param y Y坐标
		 * @return pixel值
		 */
		public int getRGB(int x, int y) {
			return bitmap.getPixel(x, y);
		}

		/**
		 * 设置像素点像素
		 * @param rgb RGB
		 * @param x X坐标
		 * @param y Y坐标
		 */
		public void setPixel(int rgb, int x, int y) {
			bitmap.setPixel(x, y, rgb);
		}

		/**
		 * 设置像素点RGB
		 * @param rgb RGB
		 * @param x X坐标
		 * @param y Y坐标
		 */
		public void setRGB(int rgb, int x, int y) {
			bitmap.setPixel(x, y, rgb);
		}

		/**
		 * 扩充图像为指定大小
		 * 
		 * @param w 宽
		 * @param h 高
		 * @return SImage
		 */
		public SImage scaledInstance(int w, int h) {
			final int width = getWidth();
			final int height = getHeight();
			if (width == w && height == h) {
				return this;
			}
			final Bitmap resizedBitmap = Bitmap.createScaledBitmap(bitmap, w, h, true);
			return new SImage(resizedBitmap);
		}

		/**
		 * 返回SImage的hash序列
		 * @return int
		 */
		public int hashCode() {
			return GraphicsRestore.hashBitmap(bitmap);
		}

		/**
		 * 判定当前SImage是否已被关闭
		 * 
		 * @return boolean
		 */
		public boolean isClose() {
			return close || bitmap == null
					|| (bitmap != null ? bitmap.isRecycled() : false);
		}

		/**
		 * 资源释放
		 * 
		 */
		public void dispose() {
			close = true;
			bitmap.recycle();
			bitmap = null;
		}
}
