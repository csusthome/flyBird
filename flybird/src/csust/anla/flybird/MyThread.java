package csust.anla.flybird;

import android.content.Context;
import android.graphics.AvoidXfermode.Mode;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Vibrator;
import android.view.SurfaceHolder;

public class MyThread extends Thread {
	SurfaceHolder holder;
	private boolean isStart;
	int gameStatues;
	int w, h;
	Context context;
	Pipe[] pipes1 = new Pipe[2]; // ����pipe������
	Pipe[] pipes2 = new Pipe[2]; // ����pipe�����������ǵڶ���pipe

	Bitmap btPipeUp, btBack, btBack1, btPipeDown; // btBack�������õ���С��ͼƬ��btBack1�Ǹı��Ĵ�ͼƬ
													// btΪ���ӵ�ͼƬ
	Bitmap btGameover;
	Bitmap[] bms;
	Paint paint;

	Matrix matrix;

	Bird bird;
    long overTime;
    private Vibrator vibrator;
    
	public MyThread(SurfaceHolder holder, int w, int h, Context context) {
		super();
		this.holder = holder; // �õ�mysurfaceView�ľ����ͨ����������canvas���Ϳ�����������
		isStart = true;
		gameStatues = 0;
		this.w = w;
		this.h = h;
		this.context = context;

		paint = new Paint();
		
		vibrator = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);

		// pipe.setX((3 / 2) * w);
		matrix = new Matrix();

		paint.setColor(Color.BLACK);
		int res = R.drawable.pipe_down;
		btPipeUp = BitmapFactory.decodeResource(this.context.getResources(),
				res);

		int res1 = R.drawable.pipe_up;
		btPipeDown = BitmapFactory.decodeResource(this.context.getResources(),
				res1);
		
		int res2 = R.drawable.text_game_over;
		btGameover = BitmapFactory.decodeResource(this.context.getResources(),
				res2);
		
		int back = R.drawable.bg_night;
		btBack = BitmapFactory
				.decodeResource(this.context.getResources(), back);

		float biBackWidth = (float) w / (btBack.getWidth()); // �������ſ��ϵ��
		float biBackHeight = (float) h / (btBack.getHeight()); // �������Ÿߵ�ϵ��
		matrix.postScale(biBackWidth, biBackHeight); // �Ѿ�������ϵ������ö�����
		// ͨ�����ţ������һ������Ļ��Сһ����ͼƬ
		btBack1 = Bitmap.createBitmap(btBack, 0, 0, btBack.getWidth(),
				btBack.getHeight(), matrix, true);

		for (int i = 0; i < pipes1.length; i++) {

			if (i == 0)
				pipes1[i] = new Pipe(btPipeUp);
			else
				pipes1[i] = new Pipe(btPipeDown);
		}

		for (int i = 0; i < pipes2.length; i++) {

			if (i == 0)
				pipes2[i] = new Pipe(btPipeUp);
			else
				pipes2[i] = new Pipe(btPipeDown);
		}


	

		int[] bres = new int[] { R.drawable.bird0_0, R.drawable.bird0_1,
				R.drawable.bird0_2 };
		bms = new Bitmap[bres.length];

		for (int i = 0; i < bres.length; i++) {
			bms[i] = BitmapFactory.decodeResource(this.context.getResources(),
					bres[i]);
		}

		

		init();
	}

	public void init() {
		for (int j = 0; j < pipes1.length; j++) {
			pipes1[j].setX(w * 2); // ��һ��pipe
			pipes2[j].setX(w * 5 / 2); // �ڶ���pipe
			if (j == 0) {
				pipes1[j].setY(0);
				pipes2[j].setY(0);
			} else {
				pipes1[j].setY(h - btPipeUp.getHeight() + h * 2 / 10);
				pipes2[j].setY(h - btPipeDown.getHeight() + h * 2 / 10);
			}
		}

		bird = new Bird(bms);
		bird.setX(w * 2 / 10);
		bird.setY(0);
	}
	public void run() {
		super.run();
		while (isStart) {
			Canvas canvas = null;
			try {
				canvas = holder.lockCanvas();
				switch (gameStatues) {
				case 0:
					drawPlayView(canvas);
					break;
				case 1:
					drawBufferView(canvas);
					break;
				case 2:
					drawOverView(canvas);
					break;

				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (canvas != null)
				holder.unlockCanvasAndPost(canvas);

		}
	}

	private void drawOverView(Canvas canvas) {
		canvas.drawBitmap(btGameover, (w - btGameover.getWidth())/2, (h-btGameover.getHeight())/2, paint);
		isStart = false;
//        try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	private void drawBufferView(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawBitmap(btBack1, 0, 0, paint);        //������ҲҪ��һ������ͼ��
        if(System.currentTimeMillis() - overTime >= 100){
        	gameStatues = 2;                         //�������ѹ���ʣ�µľ��ǻ��ƽ���ʱ��ͼ����
        	
        }else{
        	canvas.drawBitmap(bird.getBitmap(), bird.getX(), bird.getY(), paint);
        	
    		for (int i = 0; i < pipes1.length; i++) {
    			pipes1[i].setX(pipes1[i].getX() - 1.2f);

    			if (pipes1[i].getX() + (pipes1[i].getW()) <= 0) {
    				pipes1[i].setX(w);

    			}

    			pipes2[i].setX(pipes2[i].getX() - 1.2f);

    			if (pipes2[i].getX() + (pipes2[i].getW()) <= 0) {
    				pipes2[i].setX(w);

    			}
    			canvas.drawBitmap(pipes1[i].getBitmap(), pipes1[i].getX(),
    					pipes1[i].getY(), paint);

    			canvas.drawBitmap(pipes2[i].getBitmap(), pipes2[i].getX(),
    					pipes2[i].getY(), paint);
    		}
        }
	}

	private void drawPlayView(Canvas canvas) {

		canvas.drawBitmap(btBack1, 0, 0, paint); // ��mysurfaceView��һ�ű���ͼƬ

		String myName = "CSUST-anLA";
		float myNameWidth = paint.measureText(myName);
		float myNameHeight = paint.descent() - paint.ascent();
		paint.setTextSize(15);
		canvas.drawText(myName, (w - myNameWidth) / 2, h
				- (h / 10 - myNameHeight) / 2 - paint.descent(), paint);

		for (int i = 0; i < pipes1.length; i++) {
			pipes1[i].setX(pipes1[i].getX() - 1.2f);

			if (pipes1[i].getX() + (pipes1[i].getW()) <= 0) {
				pipes1[i].setX(w);

			}

			pipes2[i].setX(pipes2[i].getX() - 1.2f);

			if (pipes2[i].getX() + (pipes2[i].getW()) <= 0) {
				pipes2[i].setX(w);

			}
			canvas.drawBitmap(pipes1[i].getBitmap(), pipes1[i].getX(),
					pipes1[i].getY(), paint);

			canvas.drawBitmap(pipes2[i].getBitmap(), pipes2[i].getX(),
					pipes2[i].getY(), paint);
		}

		bird.exchangeBitmaps(20);
		bird.setVy(bird.getVy() + h / 800f); // ����С����y����ļ��ٶ�Ϊh/800f
		bird.setY(bird.getY() + bird.getVy()); // ����С���y���꣬����vy�Ϳ��Դճ��ٶ�

		canvas.drawBitmap(bird.getBitmap(), bird.getX(), bird.getY(), paint);
		for (int i = 0; i < pipes1.length; i++) {
			if (this.isBirdHitPipe(bird, pipes1[i])) {
				gameStatues = 1;
				overTime = System.currentTimeMillis();
				vibrator.vibrate(100);
				break;
				
			}
			if (this.isBirdHitPipe(bird, pipes2[i])) {
				gameStatues = 1;
				overTime = System.currentTimeMillis();
				vibrator.vibrate(100);
				break;
			}
		}
	}

	private boolean isBirdHitPipe(Bird bird, Pipe pipe) {
		Rect rect_bird = new Rect();
		Rect rect_pipe = new Rect();

		rect_bird.left = (int) bird.getX();
		rect_bird.right = (int) (rect_bird.left + bird.getW());
		rect_bird.top = (int) bird.getY();
		rect_bird.bottom = (int) (rect_bird.top + bird.getH());

		rect_pipe.left = (int) pipe.getX();
		rect_pipe.right = pipe.getW() + rect_pipe.left;
		rect_pipe.top = pipe.getY()+5;
		rect_pipe.bottom = pipe.getY() + pipe.getH()-5;

		if (rect_bird.intersect(rect_pipe)) {
			return true;
		}
		return false;
	}

}
