package com.anLA.flybird;
import com.anLA.flybird.R.id;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	ImageButton play;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setMenu();
	}
	
	private void setMenu(){
		setContentView(R.layout.activity_main);
		play = (ImageButton) findViewById(id.play);
		play.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		MySurfaceView mySurfaceView = new MySurfaceView(this);
		setContentView(mySurfaceView);
		mySurfaceView.setMainActivity(this);
		
	}
	
	

    
}
