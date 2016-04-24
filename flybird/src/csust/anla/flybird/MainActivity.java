package csust.anla.flybird;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;

/**
 * 主界面的activity
 * @author U-anLA
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	ImageButton ibutton;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this,MusicServer.class);  
       
        startService(intent);  
		manu();
	}

	public void manu() {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		ibutton = (ImageButton) findViewById(R.id.play);
		ibutton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		startGameView();

	}

	public void startGameView() {
		MySurfaceView mySurfaceView = new MySurfaceView(this);

		setContentView(mySurfaceView);
		mySurfaceView.setMainActivity(this);
//		 mySurfaceView.setBackgroundResource(R.drawable.bg_night);
////		 mySurfaceView.setBackgroundDrawable(background)
	}
	
	@Override
	protected void onStop() {
        super.onStop();  
        Intent intent = new Intent(MainActivity.this,MusicServer.class);  
        stopService(intent);  
	}
}
