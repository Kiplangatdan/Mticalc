package com.app.mticalc;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.provider.Settings;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.app.mticalc.db.DatabaseHandler;
import com.app.mticalc.db.MtiCalcDetails;


public class Main extends Activity implements OnClickListener, OnTouchListener, android.widget.RadioGroup.OnCheckedChangeListener{
    private static final String REQUESTING_LOCATION_UPDATES_KEY = "Updatelocation";
    private static final String LOCATION_KEY = "location_key";
    private int lastInsert;
    private AlertDialog.Builder builder;
    
    
    private RadioButton Timber;
    private RadioButton Poles;


   
    private RadioGroup Radios;
    private String mLatitude = null; 
    private String mLongitude=null;
    private String mDate;
    private boolean empty = true;
    private String Date;
    private String tree_species, plot_no;
    private RelativeLayout layout;
    private Button addTrees;
    private LinearLayout layout3;
    public boolean userDB = false;
    public boolean mtiDB = false;
    private String android_id;
    private TextView mticalc2;
    private float isGPS;
    public AudioManager audio;
    public SoundPool sound;
    public int click;
    private Spinner  treespecies;
    private EditText ownername, woodlotname,area, treespacing;
    String owner_name, woodlot_name;
    double coverage;
    String treeSpacing;




    private boolean mRequestingLocationUpdates = false;
    MtiCalcDetails details;
    DatabaseHandler db;
    private Location mLastLocation;
    private LocationManager manager;
    private int ownerlastinsert;
    private Resources res=null;
	private String usage;
	private String[] pole=new String[]{"Select species","Eucalyptus saligna",
		    "Eucalyptus grandis"};
	private String[] timber=new String[]{"Select species",
    "Eucalyptus saligna",
    "Eucalyptus grandis",
    "Pinus patula",
    "Cupressus lucitanica",
    "Grevillea robusta"};
	private ArrayAdapter<String> adapter;
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        android_id = Secure.getString(this.getContentResolver(), Secure.ANDROID_ID);
        final View v = getLayoutInflater().inflate(R.layout.activity_mai, null);
        v.setKeepScreenOn(true);
        setContentView(v);
        res=this.getResources();
      builder=new AlertDialog.Builder(this);
      setupElements();
      Typeface type2 = Typeface.createFromAsset(getAssets(), "GROBOLD.ttf");
      mticalc2.setTypeface(type2);
     

          db = new DatabaseHandler(this);

          if(checkLocationSettings()){//
          }
          else{
              builder.setMessage("Enable location settings to continue!!!");
             // builder.setTitle("");
              builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                 startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                  }
              });
              builder.show();
          }
          adapter=new ArrayAdapter<String>(this,  android.R.layout.simple_spinner_dropdown_item, timber);
  		treespecies.setAdapter(adapter);
Radios.setOnCheckedChangeListener(this);;
          treespecies.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                  if (i == 0) {
                      empty = true;
                  } else
                      tree_species = adapterView.getItemAtPosition(i).toString();
                  

              }

              @Override
              public void onNothingSelected(AdapterView<?> adapterView) {

              }
          });
          addTrees.setOnClickListener(this);
          //addTrees.setOnTouchListener(this);



    }

     private boolean checkLocationSettings() {
        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
            return true;
        else
            return false;//should be false
    }

    private void updateFromUIState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Update the value of mRequestingLocationUpdates from the Bundle, and
            // make sure that the Start Updates and Stop Updates buttons are
            // correctly enabled or disabled.
            if (savedInstanceState.keySet().contains(REQUESTING_LOCATION_UPDATES_KEY)) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean(
                        REQUESTING_LOCATION_UPDATES_KEY);

            }

            // Update the value of mCurrentLocation from the Bundle and update the
            // UI to show the correct latitude and longitude.
            if (savedInstanceState.keySet().contains(LOCATION_KEY)) {
                // Since LOCATION_KEY was found in the Bundle, we can be sure that
                // mCurrentLocationis not null.
                mLastLocation= savedInstanceState.getParcelable(LOCATION_KEY);
            }


        }
    }
    public Location getLocation(){
       

        manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        List<String> providers=manager.getAllProviders();

        for(String provider:providers) {
            if (provider == null)
                continue;
            else
                mLastLocation = manager.getLastKnownLocation(provider);
            if(mLastLocation!=null)
                break;
        }

        return mLastLocation;
    }

    private void setupElements() {
        // TODO Auto-generated method stub
        layout3 = (LinearLayout) findViewById(R.id.seondlayout);
        layout = (RelativeLayout) findViewById(R.id.mainlayout);
        mticalc2 = (TextView) findViewById(R.id.mticalc2);
        woodlotname = (EditText) findViewById(R.id.woodlotName);

        ownername = (EditText) findViewById(R.id.ownername);
       
        area = (EditText) findViewById(R.id.woodlotarea);
        treespecies = (Spinner) findViewById(R.id.treeSpecies);
        treespacing = (EditText) findViewById(R.id.treespacing);
        addTrees = (Button) findViewById(R.id.addtreesbut);
        Radios = (RadioGroup)findViewById(R.id.trees);
        Timber = (RadioButton)findViewById(R.id.radio0);//radio0
        Poles = (RadioButton)findViewById(R.id.radio1);//radio1
        
    }
    private void updateValuesFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Update the value of mRequestingLocationUpdates from the Bundle, and
            // make sure that the Start Updates and Stop Updates buttons are
            // correctly enabled or disabled.
            if (savedInstanceState.keySet().contains(REQUESTING_LOCATION_UPDATES_KEY)) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean(
                        REQUESTING_LOCATION_UPDATES_KEY);
                ;
            }

            // Update the value of mCurrentLocation from the Bundle and update the
            // UI to show the correct latitude and longitude.
            if (savedInstanceState.keySet().contains(LOCATION_KEY)) {
                // Since LOCATION_KEY was found in the Bundle, we can be sure that
                // mCurrentLocationis not null.
                mLastLocation = savedInstanceState.getParcelable(LOCATION_KEY);
            }

            // Update the value of mLastUpdateTime from the Bundle and update the UI.

        }
    }
    
    @Override
    public void onResume() {
        super.onResume();
//if(mGoogleApiClient.isConnected()&&mRequestingLocationUpdates){
  //  stopLocationUpdates();
//}

    }

    @Override
    protected void onPause() {
        super.onPause();
        



    }
    protected void stopLocationUpdates() {
//        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);

}
    @Override
    protected void onDestroy() {
        super.onDestroy();
      
    }

    @Override
	public void onClick(View v) {
        switch (v.getId()) {

            case R.id.addtreesbut:

                if(treespecies.getSelectedItem().equals("Select species")){

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                   // builder.setTitle("Problem");
                    builder.setMessage("You have to select the species!")
                            // Set the action buttons
                            .setPositiveButton("Understood", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    //  Your code when user clicked on OK
                                    //  You can write the code  to save the selected item here
                                    // Therefore store data in db as well as clear all fields
                                	dialog.dismiss();

                                }
                            });

                    AlertDialog dialog = builder.create();//AlertDialog dialog; create like this outside onClick
                    dialog.show();
                }
                
            	 if(TextUtils.isEmpty(woodlotname.getText().toString())){
            	        woodlotname.setError("Enter Plantion name");
            	        
            	 }
            	 if(TextUtils.isEmpty(ownername.getText().toString())){
         	        ownername.setError("Enter Ownername");
         	        
            	 }
            	 if(TextUtils.isEmpty(area.getText().toString())){
          	        area.setError("Enter Area in metres square");
          	        
            	 }
            	 if(TextUtils.isEmpty(treespacing.getText().toString())){
          	        treespacing.setError("Enter Tree Spacing");
          	        
            	 }
            	 
            	 else{
            	
                gatherDataFromFields();

            	}
                if (!fieldsEmpty()) {
                    ownerlastinsert = (int) db.insertuser(owner_name);
                    Log.d("OwnerInsert", String.valueOf(ownerlastinsert));
                    details = new MtiCalcDetails(ownerlastinsert,woodlotname.getText().toString(),plot_no, tree_species,coverage, treeSpacing,
                            mLatitude,mLongitude,mDate,usage);
                    this.lastInsert = (int) db.addPlantDetails(details);

                    if (lastInsert > 0) {
                       // builder.setTitle("Success");
                        builder.setMessage("Your plantation details have been saved successfully");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                addTrees.setBackgroundResource(R.drawable.addtreesbut);
                                Intent intent = new Intent();
                               intent.putExtra("lastInsert", lastInsert);
                               // intent.putExtra("plotName",woodlot_name);
                                intent.putExtra("plotName",woodlotname.getText().toString());
                                
                                if(Timber.isChecked()){//Activity for timber
                                intent.setClassName("com.app.mticalc", "com.app.mticalc.TreeDetails");
                                startActivity(intent);
                                
                            }else if(Poles.isChecked()){//Activity for poles
                            	intent.setClassName("com.app.mticalc", "com.app.mticalc.TreeDetails_Poles");
                                startActivity(intent);
                            }
                            }
                        });
                        
                        builder.show();

                    }

                }
        }
    }





    private boolean fieldsEmpty() {
       	int pos =treespecies.getSelectedItemPosition();
        if(treespecies.getSelectedItem().equals(""))
        {
            return  true;
        }
        else
            return  false;

    }
@Override
	public void onBackPressed() {
		this.finish();
        System.exit(0);
	}
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		int action = event.getAction();
		if(action == MotionEvent.ACTION_DOWN)
		{
		if(v.getId() == R.id.addtreesbut)
		{
			addTrees.setBackgroundResource(R.drawable.addtreesbut_pressed);
			// gather data for adding to database from fields
		}
		}
		if(action == MotionEvent.ACTION_UP)
		{



		}
			return true;
	}

	private void gatherDataFromFields() {
		 String lat = "0";
		 //String mlat = String.valueOf(getLocation().getLongitude());
		owner_name=ownername.getText().toString();
        woodlot_name=woodlotname.getText().toString();
        coverage= Double.parseDouble(area.getText().toString());
        treeSpacing= treespacing.getText().toString();
        if(Timber.isChecked()){
        	usage = "Timber";
        }else if(Poles.isChecked()){
        	usage = "Poles";
        }
        if (mLatitude!=null){
         mLatitude=String.valueOf(getLocation().getLatitude());
        }else{
        	mLatitude=String.valueOf(lat);
        	
        }
        if(mLongitude!=null){
        	mLongitude=String.valueOf(getLocation().getLongitude());
        }else{
        	mLongitude=String.valueOf(lat);
        }
        

	}




    private void updateUI() {
        mLatitude= String.valueOf(mLastLocation.getLatitude());
        mLongitude= String.valueOf(mLastLocation.getLongitude());

    }

    
    @Override
	protected void onRestart() {
		super.onRestart();
	}
    
    @Override
    protected void onStart() {
        super.onStart();
        ///mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        
       // if(mGoogleApiClient.isConnected())
           //mGoogleApiClient.disconnect();
    }

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
	switch(checkedId){
	case R.id.radio0:		
		adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, timber);
		treespecies.setAdapter(adapter);
		break;
	case R.id.radio1:
	adapter=new ArrayAdapter<String>(this,  android.R.layout.simple_spinner_dropdown_item,  pole);
		treespecies.setAdapter(adapter);
		}
		
	}



}
