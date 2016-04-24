package csust.anla.flybird;

import android.graphics.Bitmap;
/**
 * ¹Ü×Ó
 * @author U-anLA
 *
 */
public class Pipe {
	float x;
	private int y;
	private int w,h;
	Bitmap bitmap;
	
	
	public Pipe(int x, int y, int w, int h) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public Pipe(Bitmap bitmap){
		this.bitmap = bitmap;
		this.w = bitmap.getWidth();
		this.h = bitmap.getHeight();
	}
	
	public Pipe() {
		// TODO Auto-generated constructor stub
	}


	public float getX() {
		return x;
	}
	public void setX(float d) {
		this.x = d;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	

}
