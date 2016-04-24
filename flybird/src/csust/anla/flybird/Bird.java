package csust.anla.flybird;

import android.graphics.Bitmap;
/**
 * ÄñÀà
 * 
 * @author U-anLA
 *
 */
public class Bird {

	private float x,y;
	private float w,h;
	private float vx,vy;
	Bitmap[] bms;
	Bitmap bitmap;
	int index;
	long startTime = System.currentTimeMillis();
	
	public Bird() {
		super();
	}


	public Bird(Bitmap[] bms) {
		// TODO Auto-generated constructor stub
		this.bms = bms;
		Bitmap bitmap = bms[0];
		this.w = bitmap.getWidth();
		this.h = bitmap.getHeight();
	}
    
	public void exchangeBitmaps(long time){
		bitmap = bms[index];
		if(System.currentTimeMillis() - startTime >= time){
			index++;
			if(index >=bms.length){
				index = 0;
			}
			startTime = System.currentTimeMillis();
		}
	}

	public float getX() {
		return x;
	}


	public void setX(float x) {
		this.x = x;
	}


	public float getY() {
		return y;
	}


	public void setY(float y) {
		this.y = y;
	}


	public float getW() {
		return w;
	}


	public void setW(float w) {
		this.w = w;
	}


	public float getH() {
		return h;
	}


	public void setH(float h) {
		this.h = h;
	}


	public float getVx() {
		return vx;
	}


	public void setVx(float vx) {
		this.vx = vx;
	}


	public float getVy() {
		return vy;
	}


	public void setVy(float vy) {
		this.vy = vy;
	}


	public Bitmap[] getBms() {
		return bms;
	}


	public void setBms(Bitmap[] bms) {
		this.bms = bms;
	}


	public Bitmap getBitmap() {
		return bitmap;
	}


	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	
	
	
}
