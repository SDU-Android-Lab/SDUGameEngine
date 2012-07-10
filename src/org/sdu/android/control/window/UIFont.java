package org.sdu.android.control.window;

import java.util.HashMap;

import org.sdu.android.SystemData;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.Typeface;


public class UIFont {

	public static final int LEFT = 1;

	public static final int RIGHT = 2;

	public static final int CENTER = 3;

	public static final int JUSTIFY = 4;

	final static public int FACE_SYSTEM = 0;

	final static public int FACE_MONOSPACE = 32;

	final static public int FACE_PROPORTIONAL = 64;

	final static public int FONT_STATIC_TEXT = 0;

	final static public int FONT_INPUT_TEXT = 1;

	final static public int SIZE_SMALL = 8;

	final static public int SIZE_LARGE = 16;

	final static public int SIZE_MEDIUM = 0;

	final static public int STYLE_PLAIN = 0;

	final static public int STYLE_BOLD = 1;

	final static public int STYLE_ITALIC = 2;

	final static public int STYLE_UNDERLINED = 4;

	final private static String tmp = "H";

	final private static HashMap<String, Object> fonts = new HashMap<String, Object>(
			100);

	final private Rect rect = new Rect();

	private Paint typefacePaint;

	private FontMetrics fontMetrics;

	private int fontSize;

	public static UIFont getDefaultFont() {
		return UIFont.getFont("Monospaced", 0, 12);
	}

	public static UIFont getFont(int size) {
		return UIFont.getFont("Monospaced", 0, size);
	}

	public static UIFont getFont(String familyName, int size) {
		return getFont(familyName, 0, size);
	}

	public static UIFont getFont(String familyName, int style, int size) {
		String name = (familyName + style + size).toLowerCase();
		Object o = fonts.get(name);
		if (o == null) {
			if (familyName != null) {
				if (familyName.equalsIgnoreCase("Serif")
						|| familyName.equalsIgnoreCase("TimesRoman")) {
					familyName = "serif";
				} else if (familyName.equalsIgnoreCase("SansSerif")
						|| familyName.equalsIgnoreCase("Helvetica")) {
					familyName = "sans-serif";
				} else if (familyName.equalsIgnoreCase("Monospaced")
						|| familyName.equalsIgnoreCase("Courier")
						|| familyName.equalsIgnoreCase("Dialog")) {
					familyName = "monospace";
				}
			}
			Typeface face = Typeface.create(familyName, style);
			Paint paint = new Paint();
			paint.setFlags(Paint.ANTI_ALIAS_FLAG);
			paint.setTypeface(face);
			fonts.put(name, o = new UIFont(paint, size));
		}
		return (UIFont) o;
	}

	public static UIFont getFromAssetFont(String path, int style, int fontSize) {
		return new UIFont(Typeface.DEFAULT, path, fontSize);
	}

	public static UIFont getFont(int face, int style, int fontSize) {
		UIFont font = new UIFont(fontSize);
		return getFont(font, face, style, fontSize);
	}

	public static UIFont getFont(UIFont font, int face, int style, int fontSize) {
		int paintFlags = 0;
		int typefaceStyle = Typeface.NORMAL;
		Typeface base;
		switch (face) {
		case FACE_MONOSPACE:
			base = Typeface.MONOSPACE;
			break;
		case FACE_SYSTEM:
			base = Typeface.DEFAULT;
			break;
		case FACE_PROPORTIONAL:
			base = Typeface.SANS_SERIF;
			break;
		default:
			throw new IllegalArgumentException("unknown font " + face);
		}
		if ((style & STYLE_BOLD) != 0) {
			typefaceStyle |= Typeface.BOLD;
		}
		if ((style & STYLE_ITALIC) != 0) {
			typefaceStyle |= Typeface.ITALIC;
		}
		if ((style & STYLE_UNDERLINED) != 0) {
			paintFlags |= Paint.UNDERLINE_TEXT_FLAG;
		}
		Typeface typeface = Typeface.create(base, typefaceStyle);
		Paint paint = new Paint(paintFlags);
		paint.setTypeface(typeface);
		font.setTypefacePaint(paint);
		return font;
	}

	private static Paint createPaint(Typeface typeface) {
		Paint paint = new Paint();
		paint.setTypeface(typeface);
		return paint;
	}

	private UIFont(int fontSize) {
		this.fontSize = fontSize;
	}

	private UIFont(Typeface typeface, int fontSize) {
		this(createPaint(typeface), fontSize);
	}

	private UIFont(Paint typefacePaint, int fontSize) {
		this.fontSize = fontSize;
		this.setTypefacePaint(typefacePaint);
	}

	private UIFont(Typeface typeface, String path, int fontSize) {
		this(createPaint(typeface), path, fontSize);
	}

	private UIFont(Paint typefacePaint, String path, int fontSize) {
		Typeface face = Typeface.createFromAsset(SystemData.getCurrentActivity().getAssets(), path);
		this.fontSize = fontSize;
		this.typefacePaint.setTypeface(face);
		this.setTypefacePaint(typefacePaint);
	}

	public float getScale() {
		int fontSize = this.getSize();
		float scale;
		if (fontSize == UIFont.SIZE_LARGE) {
			scale = 1.5F;
		} else if (fontSize == UIFont.SIZE_SMALL) {
			scale = 0.8F;
		} else {
			scale = 1;
		}
		return scale;
	}

	public Paint getTypefacePaint() {
		return this.typefacePaint;
	}

	public float getAscent() {
		return typefacePaint.ascent();
	}

	public float getDescent() {
		return typefacePaint.descent();
	}

	public float getLeading() {
		return (typefacePaint.getFontMetrics().leading + 2) * 2;
	}

	public void setTypefacePaint(Paint typefacePaint) {
		this.typefacePaint = typefacePaint;
		this.fontMetrics = typefacePaint.getFontMetrics();
		this.typefacePaint.setTextSize(getSize());
	}

	public int getBaselinePosition() {
		return Math.round(-this.typefacePaint.ascent() * getSize());
	}

	public int getFace() {
		return FACE_SYSTEM;
	}

	public FontMetrics getFontMetrics() {
		return fontMetrics;
	}

	public int getLineHeight() {
		return (int) Math.ceil(Math.abs(fontMetrics.ascent)
				+ Math.abs(fontMetrics.descent));
	}

	public int getStyle() {
		int style = STYLE_PLAIN;
		Typeface typeface = this.typefacePaint.getTypeface();
		if (typeface.isBold()) {
			style |= STYLE_BOLD;
		}
		if (typeface.isItalic()) {
			style |= STYLE_ITALIC;
		}
		if (this.typefacePaint.isUnderlineText()) {
			style |= STYLE_UNDERLINED;
		}
		return style;
	}

	public boolean isBold() {
		return this.typefacePaint.getTypeface().isBold();
	}

	public boolean isItalic() {
		return this.typefacePaint.getTypeface().isItalic();
	}

	public boolean isPlain() {
		return this.getStyle() == STYLE_PLAIN;
	}

	public String getFontName() {
		return "Monospaced";
	}

	public int getSize() {
		return this.fontSize;
	}

	public boolean isUnderlined() {
		return this.typefacePaint.isUnderlineText();
	}

	public int charWidth(char ch) {
		char[] chars = Character.toChars(ch);
		int w = (int) typefacePaint.measureText(chars, 0, 1);
		return w;
	}

	public int stringWidth(String str) {
		return (int) typefacePaint.measureText(str);
	}

	public int subStringWidth(String str, int offset, int len) {
		return stringWidth(str.substring(offset, len));
	}

	public int getHeight() {
		return typefacePaint.getFontMetricsInt(typefacePaint
				.getFontMetricsInt());
	}

	public int getTextHeight() {
		return (int) (getTextBounds(tmp).height() * 2);
	}

	public Rect getTextBounds(String text) {
		typefacePaint.getTextBounds(text, 0, text.length(), rect);
		return rect;
	}

}
