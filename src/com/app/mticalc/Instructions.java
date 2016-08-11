package com.app.mticalc;


import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class Instructions extends MainActivity{
   
   private Resources res=null;

   /** Called when the activity is first created. */
   @Override
   public void onCreate(final Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
      //Teurastetaan otsikkopalkki pois:
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      //Teurastetaan status-palkki pois (full screen):
      getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
      final View v = getLayoutInflater().inflate(R.layout.instructions, null);
      v.setKeepScreenOn(true);
      setContentView(v);  
          
   }

   @Override
   public boolean onKeyDown(final int keyCode, final KeyEvent msg) {
      if (keyCode == KeyEvent.KEYCODE_BACK) {
         sound.play(click, 1, 1, 1, 0, 0.5f);
         finish();
         return true;
      } 
      else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
         audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
         sound.play(click, 1, 1, 1, 0, 0.75f);
         return true;
      }
      else if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
         audio.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
         sound.play(click, 1, 1, 1, 0, 1.25f);
         return true;
      } else
      return true;
   }
   @Override
   public boolean onKeyUp(final int keyCode, final KeyEvent msg) {
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







