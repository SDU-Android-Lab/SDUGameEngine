package org.sdu.android.util.graphicsUtil;

import java.io.InputStream;

import org.sdu.android.SystemData;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;

/**
 * ͼ�İ�װ��
 * 
 * @author yes_coffee
 * 
 */
public class SImage {

		/**
		 * λͼ
		 */
		private Bitmap bitmap;

		/**
		 * ��
		 */
		private int width;
		
		/**
		 * ��
		 */
		private int height;

		/**
		 * �Ƿ�ر�
		 */
		private boolean close;

		/**
		 * ���� SImage
		 * @param in ������
		 * @param transparency ͸����
		 * @return SImage
		 */
		public static SImage createImage(InputStream in, boolean transparency) {
			return GraphicsRestore.loadImage(in, transparency);
		}

		/**
		 * ���� SImage
		 * @param buffer �ֽ���
		 * @return SImage
		 */
		public static SImage createImage(byte[] buffer) {
			return GraphicsRestore.loadImage(buffer, true);
		}

		/**
		 * ���� SImage
		 * @param buffer �ֽ���
		 * @param transparency ͸����
		 * @return SImage
		 */
		public static SImage createImage(byte[] buffer, boolean transparency) {
			return GraphicsRestore.loadImage(buffer, transparency);
		}

		/**
		 * ���� SImage
		 * @param width ��
		 * @param height ��
		 * @param transparency ͸����
		 * @return SImage
		 */
		public static SImage createImage(int width, int height, boolean transparency) {
			return new SImage(width, height, transparency);
		}

		/**
		 * ���� SImage
		 * @param width ��
		 * @param height ��
		 * @return SImage
		 */
		public static SImage createImage(int width, int height) {
			return new SImage(width, height, false);
		}

		/**
		 * ���� SImage
		 * @param width ��
		 * @param height ��
		 * @param config ���÷�ʽ
		 * @return SImage
		 */
		public static SImage createImage(int width, int height, Config config) {
			return new SImage(width, height, config);
		}

		/**
		 * ���� SImage
		 * @param imageData Image����
		 * @param imageOffset Image����ƫ��
		 * @param imageLength Image����
		 * @param transparency ͸����
		 * @return SImage
		 */
		public static SImage createImage(byte[] imageData, int imageOffset,
				int imageLength, boolean transparency) {
			return GraphicsRestore.loadImage(imageData, imageOffset, imageLength,
					transparency);
		}

		/**
		 * ���� SImage
		 * @param imageData Image����
		 * @param imageOffset Image����ƫ��
		 * @param imageLength Image����
		 * @return SImage
		 */
		public static SImage createImage(byte[] imageData, int imageOffset,
				int imageLength) {
			return GraphicsRestore.loadImage(imageData, imageOffset, imageLength,
					false);
		}

		/**
		 * ���� SImage
		 * @param fileName �ļ���
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
		 * ���� SImage
		 * @param resName ��Դ�ļ���
		 * @return SImage
		 */
		public static SImage createImage(int resName) {
			final Bitmap bitmap = BitmapFactory.decodeResource(
					SystemData.getCurrentActivity().getResources(), resName);
			return new SImage(bitmap);
		}
		
		/**
		 * ��ָ�����ؼ�������SImage�ļ�
		 * 
		 * @param rgb ARGB����
		 * @param width ��
		 * @param height ��
		 * @param processAlpha ARGB��λ�Ƿ���ԣ����Ƿ�͸�� 
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
		 * ����ָ��������SImage
		 * 
		 * @param count ����
		 * @param w ��
		 * @param h ��
		 * @param transparency ͸����
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
		 * ����ָ��������SImage
		 * 
		 * @param count ����
		 * @param w ��
		 * @param h ��
		 * @param config ����
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
		 * ����һ��SImage
		 * @param width ��
		 * @param height ��
		 */
		public SImage(int width, int height) {
			this(width, height, false);
		}

		/**
		 * ����һ��SImage(true:ARGB4444��false:RGB565)
		 * 
		 * @param width ��
		 * @param height ��
		 * @param transparency ͸����
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
		 * ����һ��SImage
		 * @param width ��
		 * @param height ��
		 * @param config ����
		 */
		public SImage(int width, int height, Config config) {
			this.width = width;
			this.height = height;
			this.bitmap = Bitmap.createBitmap(width, height, config);
		}

		/**
		 * ����һ��SImage
		 * @param img SImage
		 */
		public SImage(SImage img) {
			this(img.getBitmap());
		}

		/**
		 * ����һ��SImage
		 * @param bitmap λͼ
		 */
		public SImage(Bitmap bitmap) {
			setBitmap(bitmap);
		}

		/**
		 * ����λͼ
		 * @param bitmap λͼ
		 */
		public void setBitmap(Bitmap bitmap) {
			this.width = bitmap.getWidth();
			this.height = bitmap.getHeight();
			this.bitmap = bitmap;
		}

		/**
		 * �õ�������Ϣ
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
		 * ��¡����
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
		 * �õ�λͼ
		 * @return Bitmap
		 */
		public Bitmap getBitmap() {
			return bitmap;
		}

		/**
		 * �õ�ͼ��
		 * @return int
		 */
		public int getWidth() {
			return bitmap.getWidth();
		}

		/**
		 * �õ�ͼ��
		 * @return int
		 */
		public int getHeight() {
			return bitmap.getHeight();
		}

		/**
		 * �õ�ͼ������
		 * @return int[]
		 */
		public int[] getPixels() {
			final int[] pixels = new int[width * height];
			bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
			return pixels;
		}

		/**
		 * ��ȡλͼ���صĸ�����Ϣ
		 * @param pixels ������
		 * @return int[]
		 */
		public int[] getPixels(int[] pixels) {
			bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
			return pixels;
		}

		/**
		 * ��ȡλͼ���صĸ�����Ϣ
		 * @param x ���X
		 * @param y ���Y
		 * @param w ��
		 * @param h ��
		 * @return int[]
		 */
		public int[] getPixels(int x, int y, int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.getPixels(pixels, 0, w, x, y, w, h);
			return pixels;
		}

		/**
		 * ��ȡλͼ���صĸ�����Ϣ
		 * @param offset ƫ��
		 * @param stride ����
		 * @param x ���X
		 * @param y ���Y
		 * @param w ��
		 * @param h ��
		 * @return int[]
		 */
		public int[] getPixels(int offset, int stride, int x, int y, int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.getPixels(pixels, offset, stride, x, y, w, h);
			return pixels;
		}

		/**
		 * ����������
		 * @param pixels ������
		 * @param w ��
		 * @param h ��
		 */
		public void setPixels(int[] pixels, int w, int h) {
			bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
		}

		/**
		 * ����������
		 * @param offset ƫ��
		 * @param stride ����
		 * @param x ���X
		 * @param y ���Y
		 * @param w ��
		 * @param h ��
		 */
		public void setPixels(int offset, int stride, int x, int y,
				int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.setPixels(pixels, offset, stride, x, y, w, h);
		}

		/**
		 * ���ò�����������
		 * @param pixels ������
		 * @param x ���X
		 * @param y ���Y
		 * @param w ��
		 * @param h ��
		 * @return pixels
		 */
		public int[] setPixels(int[] pixels, int x, int y, int w, int h) {
			bitmap.setPixels(pixels, 0, w, x, y, w, h);
			return pixels;
		}

		/**
		 * ��ȡĳ�������ֵ
		 * @param x X����
		 * @param y Y����
		 * @return pixelֵ
		 */
		public int getPixel(int x, int y) {
			return bitmap.getPixel(x, y);
		}

		/**
		 * �õ�λͼRGB
		 * @param offset ƫ��
		 * @param stride ����
		 * @param x ���X
		 * @param y ���Y
		 * @param w ��
		 * @param h ��
		 * @return pixels
		 */
		public int[] getRGB(int offset, int stride, int x, int y,
				int w, int h) {
			final int[] pixels = new int[w * h];
			bitmap.getPixels(pixels, offset, stride, x, y, w, h);
			return pixels;
		}

		/**
		 * �õ����ص�RGB
		 * @param x X����
		 * @param y Y����
		 * @return pixelֵ
		 */
		public int getRGB(int x, int y) {
			return bitmap.getPixel(x, y);
		}

		/**
		 * �������ص�����
		 * @param rgb RGB
		 * @param x X����
		 * @param y Y����
		 */
		public void setPixel(int rgb, int x, int y) {
			bitmap.setPixel(x, y, rgb);
		}

		/**
		 * �������ص�RGB
		 * @param rgb RGB
		 * @param x X����
		 * @param y Y����
		 */
		public void setRGB(int rgb, int x, int y) {
			bitmap.setPixel(x, y, rgb);
		}

		/**
		 * ����ͼ��Ϊָ����С
		 * 
		 * @param w ��
		 * @param h ��
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
		 * ����SImage��hash����
		 * @return int
		 */
		public int hashCode() {
			return GraphicsRestore.hashBitmap(bitmap);
		}

		/**
		 * �ж���ǰSImage�Ƿ��ѱ��ر�
		 * 
		 * @return boolean
		 */
		public boolean isClose() {
			return close || bitmap == null
					|| (bitmap != null ? bitmap.isRecycled() : false);
		}

		/**
		 * ��Դ�ͷ�
		 * 
		 */
		public void dispose() {
			close = true;
			bitmap.recycle();
			bitmap = null;
		}
}
