package com.anLA.flybird;

import android.graphics.Bitmap;

public class Tree {
    private int w,h;
    private int x,y;
    private Bitmap[] bms2;
	public Tree(int w, int h, int x, int y) {
		super();
		this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
	}
	public Tree() {
		// TODO Auto-generated constructor stub
	}
	public Tree(Bitmap[] bms2) {
		this.bms2 = bms2;
		Bitmap bitmap = bms2[0];
		w = bitmap.getWidth();
		h = bitmap.getHeight();
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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	
	
}
