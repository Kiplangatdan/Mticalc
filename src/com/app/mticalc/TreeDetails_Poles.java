package com.app.mticalc;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.mticalc.db.DatabaseHandler;
import com.app.mticalc.db.MtiCalcDetails;

/**
 * Created by Asus on 5/10/2015.
 */
public class TreeDetails_Poles extends Activity implements View.OnClickListener {
	
	
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
    
    //variable declaration
    private static  final double PI=3.142;
    private static final double DIVISOR = 40000;
    private static  final int POLE_MAX=10;
    private int pole = 1;
    DatabaseHandler db;
    MtiCalcDetails details;
    Button  polenext,plotInsert;
    EditText poleno,polelength,poletd,polebd,sample;
    String pole_no,pole_length,pole_td,pole_bd,tree_species;
    AlertDialog.Builder build;
    int count=1;
    int lastins;
    private long plotlastInsert;
    private boolean clicked=false;
    private String plantname;
    private TextView pole_naming;
   private DecimalFormat format;
    private int plot=0;
    //prompt box
    private Button btn;
	private EditText editTextMainScreen;
	final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final View v = getLayoutInflater().inflate(R.layout.activity_pole_survey_form, null);
        v.setKeepScreenOn(true);
        setContentView(v);  
        setupElements();
        format=new DecimalFormat("#0.0000");
        Bundle extra=getIntent().getExtras();
        lastins= this.getIntent().getIntExtra("lastInsert",1);
        plantname=extra.getString("plotName");
        build=new AlertDialog.Builder(this);
        Log.d("LastInaserte",String.valueOf(lastins));
        db=new DatabaseHandler(this);
        polenext.setOnClickListener(this);
        plotInsert.setOnClickListener(this) ;
        poleno.setEnabled(false);
        polelength.setEnabled(false);
        poletd.setEnabled(false);
        polebd.setEnabled(false);
        sample.setEnabled(false);
//setUpTypeFaces();
    }
/*public void setUpTypeFaces(){
    Typeface type=Typeface.createFromAsset(getAssets(),"GROBOLD.ttf") ;
    tree_naming.setTypeface(type);
    }*/
    public void setupElements(){
        pole_naming=(TextView)findViewById(R.id.textView);
       plotInsert=(Button)findViewById(R.id.btn_insert);
        poleno=(EditText)findViewById(R.id.pole_no);
        polelength=(EditText)findViewById(R.id.pole_length);
        poletd=(EditText)findViewById(R.id.pole_td);
        polebd=(EditText)findViewById(R.id.pole_bd);
        polenext=(Button)findViewById(R.id.next_pole_button);
        sample=(EditText)findViewById(R.id.edit_sample);
        polelength.setFilters(new InputFilter[]{ new Validate("1", "14")});
        poletd.setFilters(new InputFilter[]{ new Validate("1", "20")});
        polebd.setFilters(new InputFilter[]{ new Validate("1", "27")});
    }

    @Override
    public void onClick(final View view) {
switch (view.getId()) {
    case R.id.next_pole_button:
        //treeno.setText(++count);
    	if(TextUtils.isEmpty(polelength.getText().toString())){
	        polelength.setError("Enter Length value");
           
        }
    	if(TextUtils.isEmpty(poletd.getText().toString())){
	        poletd.setError("Enter Top Diameter value");
	        
    	
        }
    	if(TextUtils.isEmpty(polebd.getText().toString())){
	        polebd.setError("Enter Bottom Diameter value");
    	}
        if(plotInsert.isEnabled())
        {
           // build.setTitle("No Plot Added");
            build.setMessage("Press add plot button to add a plot");
            build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    polelength.setText("");
                    poletd.setText("");
                    polebd.setText("");
                    sample.setText("");
                    poleno.setText("Pole no. "+count);
                    sample.setEnabled(false);
                    polelength.setEnabled(false);
                    poletd.setEnabled(false);
                    polebd.setEnabled(false);
                    sample.setEnabled(false);
                    poleno.setEnabled(false);
                }                    // treenext.setVisibility(View.VISIBLE);

            });
            build.show();
        }
        else {
            sample.setEnabled(false);
            //test if the count is exceeded
            if (greaterPoleSample()) {
               // build.setTitle("Wrong Sample");
                build.setMessage("Pole sample cannot be less than 0 or greater than 10");
                build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    	polelength.setText("");
                        poletd.setText("");
                        polebd.setText("");
                        sample.setText("");
                        poleno.setText("");
                        sample.setEnabled(false);
                        polelength.setEnabled(false);
                        poletd.setEnabled(false);
                        polebd.setEnabled(false);
                        plotInsert.setEnabled(true);
                        pole_naming.setText("Pole Measurements for " + plantname + ", Plot " + plot);
                        poleno.setEnabled(false);
                    }                    // treenext.setVisibility(View.VISIBLE);

                });
                build.show();
            } else

            if (count >= Integer.parseInt(sample.getText().toString())) {
                gatherDetails();
                if (!fieldsEmpty()) {
                    
                    double Volume;
                    Volume = (0.5*(PI * ((Double.parseDouble(pole_td)) *( Double.parseDouble(pole_td)))+
                    		(PI * ((Double.parseDouble(pole_bd)) *( Double.parseDouble(pole_bd)))))
                    		/ DIVISOR)*Double.parseDouble(pole_length);
                   
                    build.setTitle("Result of Pole " + count);
                    build.setMessage("Volume:  \t\t" +format.format(Volume) +  "cubic metres"
                    		     );
                    build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            details = new MtiCalcDetails(pole_no,
                                    (int) plotlastInsert, lastins, Double.parseDouble(pole_length),
                                    Double.parseDouble(pole_td),Double.parseDouble(pole_bd));
                            
                            db.addPoleDetails(details);
                            

                           build.setTitle("");
                           build.setMessage("You have finished entering details for plot "+ plot +", Do you want to add another plot?");
                           build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        	                       
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //CALCULATE AVERAGE FOR ALL TREE
                                    gatherDetails();
                                    count = 1;
                                    polelength.setText("");
                                    poletd.setText("");
                                    polebd.setText("");
                                    sample.setText("");
                                    poleno.setText("");
                                    sample.setEnabled(false);
                                    polelength.setEnabled(false);
                                    poletd.setEnabled(false);
                                    polebd.setEnabled(false);
                                    plotInsert.setEnabled(true);
                                    pole_naming.setText("Poles Measurements for " + plantname + ", Plot " + plot);
                                    poleno.setEnabled(false);
                                    
                                   
                                    //start activity to read calculate the formulas

                                }
                            });
                            build.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Log.e("peter",plantname);
                                    Intent inte = new Intent(TreeDetails_Poles.this, SpinnerClass.class);
                                    inte.putExtra("plantName",plantname);
                                    startActivity(inte);
                                    count = 1;
                                    ;
                                }
                            });
                            build.show();
                        }                    // treenext.setVisibility(View.VISIBLE);
                        
                       

                    });

                    build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            polelength.setText("");
                            poletd.setText("");
                            polebd.setText("");
                           
                            sample.setEnabled(false);

                        }
                    });
                    build.show();

                } else {
                    
                }


            } else {
                gatherDetails();
                if (!fieldsEmpty()) {
                    
                	double Volume;
                    Volume = (0.5*(PI * ((Double.parseDouble(pole_td)) *( Double.parseDouble(pole_td)))+
                    		(PI * ((Double.parseDouble(pole_bd)) *( Double.parseDouble(pole_bd)))))
                    		/ DIVISOR)*Double.parseDouble(pole_length);
                   
                    build.setTitle("Result of Pole " + count);
                    build.setMessage("Volume:  \t\t" +format.format(Volume) +  "cubic metres"
                    		     );                 
                   
                    build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            details = new MtiCalcDetails(pole_no,
                                    (int) plotlastInsert, lastins,Double.parseDouble(pole_length),
                                    Double.parseDouble(pole_td),Double.parseDouble(pole_bd));
                            db.addPoleDetails(details);
                            polelength.setText("");
                            poletd.setText("");
                            polebd.setText("");
                            
                            sample.setEnabled(false);
                           count += 1;
                           poleno.setText(String.valueOf("Pole no. "+count));
                                         }                    // treenext.setVisibility(View.VISIBLE);
                        
                    });
                    
                   
                       
                    
                    

                            build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                         //   Log.e("peter",plantname);
                            Intent inte = new Intent(TreeDetails_Poles.this, SpinnerClass.class);
                            inte.putExtra("plantName",plantname);
                            startActivity(inte);
                            count = 1;
                            ;

                        }
                    });
                    build.show();

                                 
                }

            }
        }
    break;

    
   

			// get prompts.xml view
			
		
	
    	
    case R.id.btn_insert:
        plot+= 1;
        pole_naming.setText("Pole Measurement for "+plantname+", Plot "+plot);
        details=new MtiCalcDetails(lastins,"Plot "+plot);
        plotlastInsert= (int) db.addPlotDetails(details);
        plotInsert.setEnabled(false);
        polelength.setEnabled(true);
        poletd.setEnabled(true);
        polebd.setEnabled(true);
        sample.setEnabled(true);
        
        
        //btn = (Button) findViewById(R.id.button);
		editTextMainScreen = (EditText) findViewById(R.id.edit_sample);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
		
		View promptView = layoutInflater.inflate(R.layout.prompts_poles, null);

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		// set prompts.xml to be the layout file of the alertdialog builder
		alertDialogBuilder.setView(promptView);

		final EditText input = (EditText) promptView.findViewById(R.id.userInput);
		input.setFilters(new InputFilter[]{new Validate("1", "10")});

		// setup a dialog window
		alertDialogBuilder
				.setCancelable(false)
				.setPositiveButton("Add", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int id) {
								// get user input and set it to result
								editTextMainScreen.setText(input.getText());
								poleno.setText(String.valueOf("Pole no. "+count));
							}
						})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,	int id) {
								dialog.cancel();
							}
						});

		// create an alert dialog
		AlertDialog alertD = alertDialogBuilder.create();

		alertD.show();

}
    }

    private boolean fieldsEmpty() {
        if(polelength.equals("")||pole_td.equals("")||pole_bd.equals("")){
    	
    	return true;
        }
        else
            return false;
    }

    public void gatherDetails(){
      pole_no=poleno.getText().toString();
        pole_length=polelength.getText().toString();
        pole_td=poletd.getText().toString();
        pole_bd=polebd.getText().toString();


    }
    public boolean greaterPoleSample(){
        if(Integer.parseInt(sample.getText().toString())>POLE_MAX||Integer.parseInt(sample.getText().toString())==0){
            return true;
        }
        else
            return  false;
    }

    @Override
    protected void onPause() {
        super.onPause();
       
        //this.plot;
    }
    @Override
	protected void onRestart() {
		super.onRestart();
	}
    @Override
    protected void onStop() {
        super.onStop();
       
    }
}



