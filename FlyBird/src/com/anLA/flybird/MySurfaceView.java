package com.anLA.flybird;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements Callback {
    
	private MainActivity mainActivity = new MainActivity();
	private SurfaceHolder holder ;
	private MyThread painter;
	
	public MySurfaceView(Context context) {
		super(context);
		holder = this.getHolder();
		holder.addCallback(this);
		this.setBackgroundResource(R.drawable.bg_night);
		
	}
	
	
	
	
	
	
	
	
	

	public MainActivity getMainActivity() {
		return mainActivity;
	}

	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}
	
	
	
	
	

	public SurfaceHolder getSurfaceHolder() {
		return holder;
	}

	public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
		this.holder = surfaceHolder;
	}

	public MyThread getPainter() {
		return painter;
	}

	public void setPainter(MyThread painter) {
		this.painter = painter;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}
	

}
