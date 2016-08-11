package com.app.mticalc;

import com.app.mticalc.Main;
import com.app.mticalc.SpinnerClass;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * This is a simple activity that demonstrates the dashboard user interface
 * pattern.
 * 
 */

public class HomeActivity extends MainActivity {
	private String TAREYOUSURE;
	private String TYES, TNO;
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.saved_data:
                startActivity(new Intent(this, SpinnerClass.class));
                break;
        }
        {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
        case R.id.instruction:
        startActivity(new Intent(this, Instructions.class));
        break;
        }
        {
        	super.onOptionsItemSelected(item);
            switch(item.getItemId()){
            case R.id.price_reference:
            startActivity(new Intent(this, Prices.class));
            break;
        }
        return true;
    }
        }
	}
        
  

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;


    }
	/**
	 * onCreate - called when the activity is first created. Called when the
	 * activity is first created. This is where you should do all of your normal
	 * static set up: create views, bind data to lists, etc. This method also
	 * provides you with a Bundle containing the activity's previously frozen
	 * state, if there was one.
	 * 
	 * Always followed by onStart().
	 * 
	 */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// Teurastetaan otsikkopalkki pois:
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		// Teurastetaan status-palkki pois (full screen):
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				//WindowManager.LayoutParams.FLAG_FULLSCREEN);
		final View v = getLayoutInflater()
				.inflate(R.layout.activity_home, null);
		v.setKeepScreenOn(true);
		setContentView(v);
		setUpViews();
	}

	private void setUpViews() {
		// TODO Auto-generated method stub
		final Resources res = this.getResources();
		TAREYOUSURE = res.getString(R.string.dialog_question);
		TYES = res.getString(R.string.dialog_yes);
		TNO = res.getString(R.string.dialog_no);
	}

	/**
	 * onDestroy The final call you receive before your activity is destroyed.
	 * This can happen either because the activity is finishing (someone called
	 * finish() on it, or because the system is temporarily destroying this
	 * instance of the activity to save space. You can distinguish between these
	 * two scenarios with the isFinishing() method.
	 * 
	 */

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	/**
	 * onPause Called when the system is about to start resuming a previous
	 * activity. This is typically used to commit unsaved changes to persistent
	 * data, stop animations and other things that may be consuming CPU, etc.
	 * Implementations of this method must be very quick because the next
	 * activity will not be resumed until this method returns. Followed by
	 * either onResume() if the activity returns back to the front, or onStop()
	 * if it becomes invisible to the user.
	 * 
	 */

	@Override
	protected void onPause() {
		super.onPause();
	}

	/**
	 * onRestart Called after your activity has been stopped, prior to it being
	 * started again. Always followed by onStart().
	 * 
	 */

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	/**
	 * onResume Called when the activity will start interacting with the user.
	 * At this point your activity is at the top of the activity stack, with
	 * user input going to it. Always followed by onPause().
	 * 
	 */

	@Override
	protected void onResume() {
		super.onResume();
	}

	/**
	 * onStart Called when the activity is becoming visible to the user.
	 * Followed by onResume() if the activity comes to the foreground, or
	 * onStop() if it becomes hidden.
	 * 
	 */

	@Override
	protected void onStart() {
		super.onStart();
	}

	/**
	 * onStop Called when the activity is no longer visible to the user because
	 * another activity has been resumed and is covering this one. This may
	 * happen either because a new activity is being started, an existing one is
	 * being brought in front of this one, or this one is being destroyed.
	 * 
	 * Followed by either onRestart() if this activity is coming back to
	 * interact with the user, or onDestroy() if this activity is going away.
	 */

	@Override
	protected void onStop() {
		super.onStop();
	}

	/**
 */
	// Click Methods
	public void onClickFeature(View v) {
		int id = v.getId();
		//sound.play(click, 1, 1, 1, 0, 1f);
		switch (id) {
		case R.id.home_btn_start:
			startActivity(new Intent(getApplicationContext(), Main.class));
			break;
		case R.id.home_btn_credit:
			startActivity(new Intent(getApplicationContext(), Credits.class));
			break;
		case R.id.home_btn_score:
		   startActivity(new Intent(getApplicationContext(), About.class));
			break;
		case R.id.home_btn_exit:
		   showDialog(QUIT);
			break;
		default:
			break;
		}
	}
	
   @Override
   protected Dialog onCreateDialog(final int id) {
      AlertDialog.Builder dlgAlert;
      dlgAlert = new AlertDialog.Builder(this);
      if (id == QUIT) {
         dlgAlert.setMessage(TAREYOUSURE);
         dlgAlert.setPositiveButton(TYES,
               new DialogInterface.OnClickListener() {
            @Override
			public void onClick(final DialogInterface dialog,
                  final int id) {
              // sound.play(click, 1, 1, 1, 0, 1f);
               setResult(-1);
               finish();
               System.exit(0);
            }
         });
         dlgAlert.setNegativeButton(TNO, new DialogInterface.OnClickListener() {
            @Override
			public void onClick(final DialogInterface dialog, final int id) {
              // sound.play(click, 1, 1, 1, 0, 1f);
            }
         });
         dlgAlert.setCancelable(false);
      }
      return dlgAlert.create();
   }

   @Override
   public boolean onKeyDown(final int keyCode, final KeyEvent msg) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {
      //   sound.play(click, 1, 1, 1, 0, 0.5f);
         showDialog(QUIT);
         return true;
      } 
      else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
       //  audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
       //  sound.play(click, 1, 1, 1, 0, 0.75f);
         return true;
      }
      else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
        // audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
        // sound.play(click, 1, 1, 1, 0, 1.25f);
         return true;
      } else
         return super.onKeyDown(keyCode, msg);
   }
} // end class