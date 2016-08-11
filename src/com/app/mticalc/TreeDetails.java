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


public class TreeDetails extends Activity implements View.OnClickListener {
	
	
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
    private static  final int TREE_MAX=10;
    private int tree = 1;
    DatabaseHandler db;
    MtiCalcDetails details;
    Button  treenext,plotInsert;
    EditText treeno,treeheight,treedbh,sample;
    String tree_no,tree_height,tree_dbh,tree_species;
    AlertDialog.Builder build;
    int count=1;
    int lastins;
    private long plotlastInsert;
    private boolean clicked=false;
    private String plantname;
    private TextView tree_naming;
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
        final View v = getLayoutInflater().inflate(R.layout.activity_tree_survey_form, null);
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
        treenext.setOnClickListener(this);
        plotInsert.setOnClickListener(this) ;
        treeno.setEnabled(false);
        treeheight.setEnabled(false);
        treedbh.setEnabled(false);
        sample.setEnabled(false);
//setUpTypeFaces();
    }
/*public void setUpTypeFaces(){
    Typeface type=Typeface.createFromAsset(getAssets(),"GROBOLD.ttf") ;
    tree_naming.setTypeface(type);
    }*/
    public void setupElements(){
        tree_naming=(TextView)findViewById(R.id.textView);
       plotInsert=(Button)findViewById(R.id.btn_insert);
        treeno=(EditText)findViewById(R.id.tree_no);
        treeheight=(EditText)findViewById(R.id.tree_height);
        treedbh=(EditText)findViewById(R.id.tree_dbh);
        treenext=(Button)findViewById(R.id.next_tree_button);
        sample=(EditText)findViewById(R.id.edit_sample);
        treeheight.setFilters(new InputFilter[]{ new Validate("1", "80")});
        treedbh.setFilters(new InputFilter[]{ new Validate("1", "50")});
        
    }

    @Override
    public void onClick(final View view) {
switch (view.getId()) {
    case R.id.next_tree_button:
        //treeno.setText(++count);
    	if(TextUtils.isEmpty(treeheight.getText().toString())){
	        treeheight.setError("Enter Treeheight value");
          
        }
    	if(TextUtils.isEmpty(treedbh.getText().toString())){
	        treedbh.setError("Enter Treedbh value");
	    
    	}
        if(plotInsert.isEnabled())
        {
           // build.setTitle("No Plot Added");
            build.setMessage("Press add plot button to add a plot");
            build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    treeheight.setText("");
                    treedbh.setText("");
                    sample.setText("");
                    treeno.setText("Tree no. "+count);
                    sample.setEnabled(false);
                    treeheight.setEnabled(false);
                    treedbh.setEnabled(false);
                    sample.setEnabled(false);
                    treeno.setEnabled(false);
                }                    // treenext.setVisibility(View.VISIBLE);

            });
            build.show();
        }
        else {
            sample.setEnabled(false);
            //test if the count is exceeded
            if (greaterTreeSample()) {
               // build.setTitle("Wrong Sample");
                build.setMessage("Tree sample cannot be less than 0 or greater than 10");
                build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    	treeheight.setText("");
                        treedbh.setText("");
                        sample.setText("");
                        treeno.setText("");
                        sample.setEnabled(false);
                        treeheight.setEnabled(false);
                        treedbh.setEnabled(false);
                        plotInsert.setEnabled(true);
                        tree_naming.setText("Tree Measurements for " + plantname + " Plot " + plot);
                        treeno.setEnabled(false);
                    }                    // treenext.setVisibility(View.VISIBLE);

                });
                build.show();
            } else

            if (count >= Integer.parseInt(sample.getText().toString())) {
                gatherDetails();
                if (!fieldsEmpty()) {
                    double BaseArea;
                    double volume;
                    BaseArea = (PI * Double.parseDouble(tree_dbh) * Double.parseDouble(tree_dbh)) / DIVISOR;
                    volume = (BaseArea) * Double.parseDouble(tree_height);
                    build.setTitle("Result of tree " + count);
                    build.setMessage("Basal area  \t\t" +format.format(BaseArea) + "square metres"
                    		     + "\nVolume      \t\t" + format.format(volume) +  "cubic metres");
                    build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            details = new MtiCalcDetails(tree_no,
                                    (int) plotlastInsert, lastins, Double.parseDouble(tree_height),
                                    Double.parseDouble(tree_dbh));
                            
                            db.addTreeDetails(details);
                            

                           build.setTitle("");
                           build.setMessage("You have finished entering details for plot "+ plot +", Do you want to add another plot?");
                           build.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        	                       
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //CALCULATE AVERAGE FOR ALL TREE
                                    gatherDetails();
                                    count = 1;
                                    treeheight.setText("");
                                    treedbh.setText("");
                                    sample.setText("");
                                    treeno.setText("");
                                    sample.setEnabled(false);
                                    treeheight.setEnabled(false);
                                    treedbh.setEnabled(false);
                                    plotInsert.setEnabled(true);
                                    tree_naming.setText("Tree Measurements for " + plantname + " Plot " + plot);
                                    treeno.setEnabled(false);
                                    
                                   
                                    //start activity to read calculate the formulas

                                }
                            });
                            build.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Log.e("peter",plantname);
                                    Intent inte = new Intent(TreeDetails.this, SpinnerClass.class);
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
                            treeheight.setText("");
                            treedbh.setText("");
                           
                            sample.setEnabled(false);

                        }
                    });
                    build.show();

                } else {
                    
                }


            } else {
                gatherDetails();
                if (!fieldsEmpty()) {
                    double BaseArea;
                    double volume;
                  final String BaseAre;
                    final String volum;
                    BaseArea = (PI * Double.parseDouble(tree_dbh) * Double.parseDouble(tree_dbh)) / DIVISOR;
                    volume = BaseArea * Double.parseDouble(tree_height);
                    BaseAre= format.format(BaseArea);
                    volum=format.format(volume);
                    build.setTitle("Result of Tree No\t\t"+count);
                    build.setMessage("Basal area  \t\t" +format.format(BaseArea) + "square metres"
               		     + "\nVolume      \t\t" + format.format(volume) +  "cubic metres");
                    build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            details = new MtiCalcDetails(tree_no,
                                    (int) plotlastInsert, lastins, Double.parseDouble(tree_height),
                                    Double.parseDouble(tree_dbh));
                            db.addTreeDetails(details);
                            treeheight.setText("");
                            treedbh.setText("");
                            
                            sample.setEnabled(false);
                           count += 1;
                           treeno.setText(String.valueOf("Tree no. "+count));
                                         }                    // treenext.setVisibility(View.VISIBLE);
                        
                    });
                    
                   
                       
                    
                    

                            build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.e("peter",plantname);
                            Intent inte = new Intent(TreeDetails.this, SpinnerClass.class);
                            inte.putExtra("plantName",plantname);
                            startActivity(inte);
                            count = 1;
                            ;

                        }
                    });
                    build.show();

                } else {
                    
                }

            }
        }
    break;

    
   

			// get prompts.xml view
			
		
	
    	
    case R.id.btn_insert:
        plot+= 1;
        tree_naming.setText("Tree measurement for "+plantname+" Plot "+plot);
        details=new MtiCalcDetails(lastins,"Plot "+plot);
         plotlastInsert= (int) db.addPlotDetails(details);
        plotInsert.setEnabled(false);
        treeheight.setEnabled(true);
        treedbh.setEnabled(true);
        sample.setEnabled(true);
        
        
        //btn = (Button) findViewById(R.id.button);
		editTextMainScreen = (EditText) findViewById(R.id.edit_sample);
		
        LayoutInflater layoutInflater = LayoutInflater.from(context);
		
		View promptView = layoutInflater.inflate(R.layout.prompts, null);

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
								treeno.setText(String.valueOf("Tree no. "+count));
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
    	if(treeheight.equals("")||tree_dbh.equals("")){
    	return true;
    	}
        else
            return false;
    }

    public void gatherDetails(){
      tree_no=treeno.getText().toString();
        tree_height=treeheight.getText().toString();
        tree_dbh=treedbh.getText().toString();


    }
    public boolean greaterTreeSample(){
        if(Integer.parseInt(sample.getText().toString())>TREE_MAX||Integer.parseInt(sample.getText().toString())==0){
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
       finish();
    }
}



