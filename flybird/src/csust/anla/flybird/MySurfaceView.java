package csust.anla.flybird;

import android.content.Context;
import android.graphics.PixelFormat;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * 画板
 * @author U-anLA
 *
 */
public class MySurfaceView extends SurfaceView implements Callback {

	private MainActivity mainActivity;
	MyThread painter;
	SurfaceHolder holder;
	

	public MySurfaceView(Context context) {
		super(context);
		holder = this.getHolder();
		holder.addCallback(this);

	}

	public MainActivity getMainActivity() {
		return mainActivity;
	}
	public void setMainActivity(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		painter =new  MyThread(holder,this.getWidth(),this.getHeight(),this.getContext());
		painter.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		
	}
	
	public boolean onTouchEvent(MotionEvent event){
		if(painter.gameStatues == 0){
			//游戏正常运行，点击屏幕，小鸟会跳起来
			birdJump(event);
		}else if(painter.gameStatues == 2){
			
		}
		return true;
	}

	private void birdJump(MotionEvent event) {
		int action = event.getAction();        //获得用户点击屏幕的动作
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			float y = event.getY();
			jump(y);
			break;

		default:
			break;
		}
	}

	private void jump(float y) {
		painter.bird.setVy(-this.getHeight() / 53);    //后面的那个数越大，就跳的越低，越小就跳的越高
		
	}
}
