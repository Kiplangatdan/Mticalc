package com.app.mticalc;

import com.app.mticalc.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;

public class IntroSplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// Teurastetaan otsikkopalkki pois:
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//Teurastetaan status-palkki pois (full screen):
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		final View v = getLayoutInflater()
				.inflate(R.layout.activity_home, null);
		v.setKeepScreenOn(true);
		setContentView(v);
		setUpViews();
		
		
		setContentView(R.layout.activity_intro_splash);
		RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
		TextView mticalc = (TextView) findViewById(R.id.mticalc);
		TextView mticalc2 = (TextView) findViewById(R.id.mticalc2);
		//TextView mticalc3 = (TextView) findViewById(R.id.mticalc3);
		Typeface type2 = Typeface.createFromAsset(getAssets(),"GROBOLD.ttf"); 
		mticalc.setTypeface(type2);
		mticalc2.setTypeface(type2);
		//mticalc3.setTypeface(type2);
		Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.my_tween_anim);
		myAnim.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				Animation myAnim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.my_tween_anim2);
				ImageView promoterlogo = (ImageView) findViewById(R.id.promoter_logo);
				promoterlogo.startAnimation(myAnim2);
				myAnim2.setAnimationListener(new AnimationListener(){
					@Override
					public void onAnimationEnd(Animation animation) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						intent.setClassName("com.app.mticalc", "com.app.mticalc.HomeActivity");
						startActivity(intent);
                        finish();
					}

					@Override
					public void onAnimationRepeat(Animation animation) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onAnimationStart(Animation animation) {
						// TODO Auto-generated method stub
						
					}
				});
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}

		});
		mticalc.startAnimation(myAnim);
		mticalc2.startAnimation(myAnim);
		//mticalc3.startAnimation(myAnim);
	}

	private void setUpViews() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_intro_splash, menu);
		return true;
	}




@Override
public void onResume() {
    super.onResume();

}

@Override
protected void onPause() {
    super.onPause();
    
}
@Override
protected void onRestart() {
	super.onRestart();
}

@Override
protected void onStart() {
    super.onStart();
   
}

@Override
protected void onStop() {
    super.onStop();
   
}



}








