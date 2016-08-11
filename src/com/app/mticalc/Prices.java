package com.app.mticalc;

import android.content.pm.ActivityInfo;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

 public class Prices extends Activity {

 @Override
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    //Teurastetaan otsikkopalkki pois:
    //requestWindowFeature(Window.FEATURE_NO_TITLE);
    //Teurastetaan status-palkki pois (full screen):
   // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    final View v = getLayoutInflater().inflate(R.layout.price, null);
    v.setKeepScreenOn(true);
    setContentView(v);  
    
    TableLayout lTableLayout;
    for(int i=0;i<10;i++){
    TableRow tr1 = new TableRow(this);
    tr1.setPadding(0, 5, 0, 0);
  
    TextView tv11 = new TextView(this);
    tv11.setPadding(2, 0, 0, 0);
    tv11.setTextSize(12);
    tr1.addView(tv11,android.view.ViewGroup.LayoutParams.WRAP_CONTENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT);


    TableRow tr2 = new TableRow(this);
    tr2.setPadding(0, 5, 0, 0);
   
    TextView tv12 = new TextView(this);
    tv12.setPadding(2, 0, 0, 0);
    tv12.setTextSize(12);
    tr2.addView(tv12,android.view.ViewGroup.LayoutParams.WRAP_CONTENT,android.view.ViewGroup.LayoutParams.WRAP_CONTENT);

    }
    }

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





