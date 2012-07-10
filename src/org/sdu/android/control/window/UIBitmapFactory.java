/**
 * 
 */
package org.sdu.android.control.window;

import org.sdu.android.util.graphicsUtil.SImage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;

/**
 * @author shadow
 *
 */
public class UIBitmapFactory {

	public static SImage creatImage(int width,int height,Paint paint){
		if(paint==null){
		paint=new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setShader(getShader());
		}
		Bitmap bitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		SImage image = new SImage(bitmap);
		final Canvas canvas = new Canvas(image.getBitmap());
		Rect r1=new Rect(0,0,width,height);
		canvas.drawRect(r1,  paint);
		return image;
	}
	
	public static Shader getShader(){
		return new SweepGradient(0, 200, new int[] {
				Color.BLACK,
                Color.WHITE,
                Color.BLACK}, null);
		}
}
