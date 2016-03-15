package com.anLA.flybird;

import android.graphics.Bitmap;

public class Bird {

	private float x;
	private float y;
	private float vy,vx;
	private int width;
	private int height;
	int index;
	long startTime;

	Bitmap bitmap;
	Bitmap[] bms;

	public Bird(int x, int y, int vy, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.vy = vy;
		this.width = width;
		this.height = height;
	}

	public Bird(Bitmap[] bms) {
		this.bms = bms;
		bitmap = bms[0];
		this.width = bitmap.getWidth();
		this.height = bitmap.getHeight();
	}

	public void exchangeBitmap(long time) {
		Bitmap bitmap = bms[index];
		if (System.currentTimeMillis() - startTime >= time) {
			index++;
			if (index >= bms.length) {
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

	public float getVy() {
		return vy;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
