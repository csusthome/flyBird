package com.anLA.flybird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class MyThread extends Thread {
	SurfaceHolder holder;
	boolean bStart;
	MySurfaceView mySurfaceView;
	int w, h;
	int gameStaues;
	Paint paint;
	Bitmap[] bms, bms2;
	Bird bird;

	//Bird[] birds;
	Tree[] trees;

	public MyThread(SurfaceHolder holder, MySurfaceView mySurfaceView, int w,
			int h, Context context) {
		super();
		this.holder = holder;
		this.mySurfaceView = mySurfaceView;
		this.w = w;
		this.h = h;
		bStart = true;
		gameStaues = 1;
		paint = new Paint();
		paint.setColor(Color.BLACK);

		// birds = new Bird[];
		trees = new Tree[2];

		int[] res = new int[] { R.drawable.bird1_0, R.drawable.bird1_1,
				R.drawable.bird1_2 };
		int[] res2 = new int[] { R.drawable.pipe_down, R.drawable.pipe_up };

		bms = new Bitmap[res.length];
		bms = new Bitmap[res2.length];

		for (int i = 0; i < res.length; i++) {
			Bitmap bitmap = BitmapFactory.decodeResource(
					context.getResources(), res[i]);
			bitmap = Bitmap.createScaledBitmap(bitmap, w / 20, w / 11, false);
			bms[i] = bitmap;
		}

		for (int i = 0; i < res2.length; i++) {
			Bitmap bitmap = BitmapFactory.decodeResource(
					context.getResources(), res2[i]);
			bitmap = Bitmap.createScaledBitmap(bitmap, w / 20, w / 11, false);
			bms2[i] = bitmap;
		}

		init();

	}

	private void init() {
		bStart = true;
		Bird bird1 = new Bird(bms);
		bird1.setX(w / 8);
		bird1.setY(h / 8);
		bird = bird1;
		for(int i=0;i<trees.length;i++){
		Tree tree1 = new Tree(bms2);
		tree1.setX(w);
		tree1.setY(h / 8);
		trees[i] = tree1;
		}

	}

	public void run() {
		super.run();
		while (bStart) {
			Canvas canvas = null;
			try {
				canvas = holder.lockCanvas();
				if (canvas != null) {
					switch (gameStaues) {
					case 0:
						this.drawPlayView(canvas);
						break;
					case 1:
						drawBufferView(canvas);
						break;
					case 2:
						// 用来画游戏结束的界面
						drawOverView(canvas);
						break;

					default:
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				if (canvas != null) {
					holder.unlockCanvasAndPost(canvas);
				}
			}
		}
	}

	private void drawOverView(Canvas canvas) {
		// TODO Auto-generated method stub

	}

	private void drawBufferView(Canvas canvas) {
		// TODO Auto-generated method stub

	}

	private void drawPlayView(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawColor(Color.WHITE);
		String name = "CSUST-anLA";

		float myNameWidth = paint.measureText(name);
		float myNameHeight = paint.descent() - paint.ascent();
		paint.setTextSize(20);
		canvas.drawText(name, (w - myNameWidth) / 2, h
				- (h / 10 - myNameHeight) / 2 - paint.descent(), paint);
		
		bird.exchangeBitmap(20);
		bird.setVy(bird.getVy() + h/800f);
		bird.setY(bird.getY() + bird.getVy());
		
		
		
		
		

	}

}
