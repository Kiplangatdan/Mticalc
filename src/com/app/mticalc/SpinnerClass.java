package com.app.mticalc;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.mticalc.db.DatabaseHandler;



public class SpinnerClass extends Activity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    Spinner spinner;
    ListView listView;
    DatabaseHandler db;
    private AlertDialog.Builder build;
    private String plantName;
    int myprice;
    double cost;
	private String usage;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final View v = getLayoutInflater().inflate(R.layout.spinner_list, null);
        v.setKeepScreenOn(true);
        setContentView(v);
        spinner = (Spinner) findViewById(R.id.spinnerlist);
        listView = (ListView) findViewById(R.id.list);
        spinner.setOnItemSelectedListener(this);
        build=new AlertDialog.Builder(this);
        plantName=this.getIntent().getStringExtra("plantName");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        db=new DatabaseHandler(this);
        Cursor cursor;
        switch (position) {
            case 0:
                cursor=db.getPlantationDetails();
                listView.setAdapter(new PlantIconicAdapter(this,cursor));
                
                listView.setOnItemClickListener(this);
                break;

            case 1:
                cursor=db.getTreeDetails();
                listView.setAdapter(new IconicAdapter(this,cursor));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        final TextView treedbh,treeheight,treebasal,treevolume,treespecies,plantationName,plotno;
                        plantationName=(TextView)view.findViewById(R.id.tv_plants_name);
                        treespecies=(TextView)view.findViewById(R.id.tv_tree_species);
                        plotno=(TextView)view.findViewById(R.id.tv_plot_no);
                        treedbh=(TextView)view.findViewById(R.id.tv_tree_dbh);
                        treeheight=(TextView)view.findViewById(R.id.tv_tree_height);
                        treebasal=(TextView)view.findViewById(R.id.tv_tree_basal);
                        treevolume=(TextView)view.findViewById(R.id.tv_tree_volume);
                        
                        
                        if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                        	if(treedbh.getText().toString().equals("20"))
                        		myprice=1975;
                        	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                            	if(treedbh.getText().toString().equals("21"))
                            		myprice=1994;
                            	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                	if(treedbh.getText().toString().equals("22"))
                                		myprice=2009;
                                	
                                	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                    	if(treedbh.getText().toString().equals("23"))
                                    		myprice=2026;
                                    	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                        	if(treedbh.getText().toString().equals("24"))
                                        		myprice=2043;
                                        	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                            	if(treedbh.getText().toString().equals("25"))
                                            		myprice=2062;
                                            	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                	if(treedbh.getText().toString().equals("26"))
                                                		myprice=2077;
                               	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                    	if(treedbh.getText().toString().equals("27"))
                                                    		myprice=2089;
                                if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                            	if(treedbh.getText().toString().equals("28"))
                                                        		myprice=2101;
                                            if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                            	if(treedbh.getText().toString().equals("29"))
                                                            		myprice=2114;
                                                            	
                                                            	
                                                            	
                                                            	
                                       if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                             if(treedbh.getText().toString().equals("30"))
                                                                 		myprice=2129;
                                           if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                               	if(treedbh.getText().toString().equals("31"))
                                                           myprice=2142;
                                          if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                            	if(treedbh.getText().toString().equals("32"))
                                                             myprice=2154;
                                                                         	
                                             	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                        if(treedbh.getText().toString().equals("33"))
                                                                             		myprice=2165;
                                                       if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                 	if(treedbh.getText().toString().equals("34"))
                                                                    myprice=2175;
                                                         if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                 	if(treedbh.getText().toString().equals("35"))
                                                                          myprice=2185;
                                           if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                         if(treedbh.getText().toString().equals("36"))
                                                                              myprice=2196;
                                                       if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                            if(treedbh.getText().toString().equals("37"))
                                                                               	myprice=2206;
                                          if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                 if(treedbh.getText().toString().equals("38"))
                                                                                 		myprice=2215;
                                                                 if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                	if(treedbh.getText().toString().equals("39"))
                                                                                                     		myprice=2224;
                                                                	
                                                                  	
                                                                    if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                          if(treedbh.getText().toString().equals("40"))
                                                                                              		myprice=2233;
                                                                        if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                            	if(treedbh.getText().toString().equals("41"))
                                                                                        myprice=2242;
                                                                       if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                         	if(treedbh.getText().toString().equals("42"))
                                                                                          myprice=2249;
                                                                                                      	
                                                                          	if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                                     if(treedbh.getText().toString().equals("43"))
                                                                                                          		myprice=2257;
                                                                                    if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                              	if(treedbh.getText().toString().equals("44"))
                                                                                                 myprice=2265;
                                                                                      if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                              	if(treedbh.getText().toString().equals("45"))
                                                                                                       myprice=2273;
                                                                        if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                                      if(treedbh.getText().toString().equals("46"))
                                                                                                           myprice=2280;
                                                                                    if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                                         if(treedbh.getText().toString().equals("47"))
                                                                                                            	myprice=2287;
                                                                       if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                                              if(treedbh.getText().toString().equals("48"))
                                                                                                              		myprice=2294;
                                                                                              if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                                             	if(treedbh.getText().toString().equals("49"))
                                                                                                                                  		myprice=2301;   
                                                                                             	 if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                                                                                                  	if(treedbh.getText().toString().equals("50"))
                                                                                                                                       		myprice=2306;    
                                                                                             	 }
                                                                                              }
                                                                                              }
                                                                       }
                                                                                    }
                                                                        }
                                                                                      }
                                                                                    }
                                                                          	}
                                                                       }
                                                                        }
                                                                	
                                                                	
                                                                 }
                                                                 }
                                          }
                                                       }
                                                         }
                                                       }
                                                       }
                                                                         	}
                                                                     	}
                                                                 	}
                                                        	}
                                                        	}
                                                    	}
                                                	}
                                            	}
                                                	
                                    	}
                                	}
                            	}
                        	
                        }
                        }
                        else
                                     
                        
                        if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                        	if(treedbh.getText().toString().equals("20"))
                        		myprice=1975;
                        	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                            	if(treedbh.getText().toString().equals("21"))
                            		myprice=1994;
                            	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                	if(treedbh.getText().toString().equals("22"))
                                		myprice=2009;
                                	
                                	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                    	if(treedbh.getText().toString().equals("23"))
                                    		myprice=2026;
                                    	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                        	if(treedbh.getText().toString().equals("24"))
                                        		myprice=2043;
                                        	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                            	if(treedbh.getText().toString().equals("25"))
                                            		myprice=2062;
                                            	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                	if(treedbh.getText().toString().equals("26"))
                                                		myprice=2077;
                               	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                    	if(treedbh.getText().toString().equals("27"))
                                                    		myprice=2089;
                                if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                            	if(treedbh.getText().toString().equals("28"))
                                                        		myprice=2101;
                                            if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                            	if(treedbh.getText().toString().equals("29"))
                                                            		myprice=2114;
                                                       	
                                       if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                             if(treedbh.getText().toString().equals("30"))
                                                                 		myprice=2129;
                                           if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                               	if(treedbh.getText().toString().equals("31"))
                                                           myprice=2142;
                                          if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                            	if(treedbh.getText().toString().equals("32"))
                                                             myprice=2154;
                                                                         	
                                             	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                        if(treedbh.getText().toString().equals("33"))
                                                                             		myprice=2165;
                                                       if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                 	if(treedbh.getText().toString().equals("34"))
                                                                    myprice=2175;
                                                         if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                 	if(treedbh.getText().toString().equals("35"))
                                                                          myprice=2185;
                                           if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                         if(treedbh.getText().toString().equals("36"))
                                                                              myprice=2196;
                                                       if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                            if(treedbh.getText().toString().equals("37"))
                                                                               	myprice=2206;
                                          if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                 if(treedbh.getText().toString().equals("38"))
                                                                                 		myprice=2215;
                                                                 if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                	if(treedbh.getText().toString().equals("39"))
                                                                                                     		myprice=2224;
                                                                	
                                                                  	
                                                                    if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                          if(treedbh.getText().toString().equals("40"))
                                                                                              		myprice=2233;
                                                                        if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                            	if(treedbh.getText().toString().equals("41"))
                                                                                        myprice=2242;
                                                                       if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                         	if(treedbh.getText().toString().equals("42"))
                                                                                          myprice=2249;
                                                                                                      	
                                                                          	if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                                     if(treedbh.getText().toString().equals("43"))
                                                                                                          		myprice=2257;
                                                                                    if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                              	if(treedbh.getText().toString().equals("44"))
                                                                                                 myprice=2265;
                                                                                      if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                              	if(treedbh.getText().toString().equals("45"))
                                                                                                       myprice=2273;
                                                                        if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                                      if(treedbh.getText().toString().equals("46"))
                                                                                                           myprice=2280;
                                                                                    if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                                         if(treedbh.getText().toString().equals("47"))
                                                                                                            	myprice=2287;
                                                                       if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                                              if(treedbh.getText().toString().equals("48"))
                                                                                                              		myprice=2294;
                                                                                              if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                                             	if(treedbh.getText().toString().equals("49"))
                                                                                                                                  		myprice=2301;   
                                                                                             	 if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                                                                                                  	if(treedbh.getText().toString().equals("50"))
                                                                                                                                       		myprice=2306;    
                                                                                             	 }
                                                                                              }
                                                                                              }
                                                                       }
                                                                                    }
                                                                        }
                                                                                      }
                                                                                    }
                                                                          	}
                                                                       }
                                                                        }
                                                                	
                                                                	
                                                                 }
                                                                 }
                                          }
                                                       }
                                                         }
                                                       }
                                                       }
                                                                         	}
                                                                     	}
                                                                 	}
                                                        	}
                                                        	}
                                                    	}
                                                	}
                                            	}
                                                	
                                    	}
                                	}
                            	}
                        	
                        }
                        }else
                        
                        
                        
                        
                        
                        
                        if (treespecies.getText().toString().equals("Pinus patula")){
                        	if(treedbh.getText().toString().equals("20"))
                        		myprice=2222;
                        	if (treespecies.getText().toString().equals("Pinus patula")){
                            	if(treedbh.getText().toString().equals("21"))
                            		myprice=2243;
                            	if (treespecies.getText().toString().equals("Pinus patula")){
                                	if(treedbh.getText().toString().equals("22"))
                                		myprice=2260;
                                	
                                	if (treespecies.getText().toString().equals("Pinus patula")){
                                    	if(treedbh.getText().toString().equals("23"))
                                    		myprice=2279;
                                    	if (treespecies.getText().toString().equals("Pinus patula")){
                                        	if(treedbh.getText().toString().equals("24"))
                                        		myprice=2298;
                                        	if (treespecies.getText().toString().equals("Pinus patula")){
                                            	if(treedbh.getText().toString().equals("25"))
                                            		myprice=2320;
                                            	if (treespecies.getText().toString().equals("Pinus patula")){
                                                	if(treedbh.getText().toString().equals("26"))
                                                		myprice=2337;
                               	if (treespecies.getText().toString().equals("Pinus patula")){
                                                    	if(treedbh.getText().toString().equals("27"))
                                                    		myprice=2350;
                                if (treespecies.getText().toString().equals("Pinus patula")){
                                            	if(treedbh.getText().toString().equals("28"))
                                                        		myprice=2364;
                                            if (treespecies.getText().toString().equals("Pinus patula")){
                                                            	if(treedbh.getText().toString().equals("29"))
                                                            		myprice=2380;
                                                       	
                                       if (treespecies.getText().toString().equals("Pinus patula")){
                                             if(treedbh.getText().toString().equals("30"))
                                                                 		myprice=2395;
                                           if (treespecies.getText().toString().equals("Pinus patula")){
                                               	if(treedbh.getText().toString().equals("31"))
                                                           myprice=2410;
                                          if (treespecies.getText().toString().equals("Pinus patula")){
                                            	if(treedbh.getText().toString().equals("32"))
                                                             myprice=2423;
                                                                         	
                                             	if (treespecies.getText().toString().equals("Pinus patula")){
                                                        if(treedbh.getText().toString().equals("33"))
                                                                             		myprice=2435;
                                                       if (treespecies.getText().toString().equals("Pinus patula")){
                                                 	if(treedbh.getText().toString().equals("34"))
                                                                    myprice=2447;
                                                         if (treespecies.getText().toString().equals("Pinus patula")){
                                                 	if(treedbh.getText().toString().equals("35"))
                                                                          myprice=2459;
                                           if (treespecies.getText().toString().equals("Pinus patula")){
                                                         if(treedbh.getText().toString().equals("36"))
                                                                              myprice=2471;
                                                       if (treespecies.getText().toString().equals("Pinus patula")){
                                                            if(treedbh.getText().toString().equals("37"))
                                                                               	myprice=2481;
                                          if (treespecies.getText().toString().equals("Pinus patula")){
                                                                 if(treedbh.getText().toString().equals("38"))
                                                                                 		myprice=2492;
                                                                 if (treespecies.getText().toString().equals("Pinus patula")){
                                                                	if(treedbh.getText().toString().equals("39"))
                                                                                                     		myprice=2502;
                                                                	
                                                                  	
                                                                    if (treespecies.getText().toString().equals("Pinus patula")){
                                                                          if(treedbh.getText().toString().equals("40"))
                                                                                              		myprice=2512;
                                                                        if (treespecies.getText().toString().equals("Pinus patula")){
                                                                            	if(treedbh.getText().toString().equals("41"))
                                                                                        myprice=2522;
                                                                       if (treespecies.getText().toString().equals("Pinus patula")){
                                                                         	if(treedbh.getText().toString().equals("42"))
                                                                                          myprice=2530;
                                                                                                      	
                                                                          	if (treespecies.getText().toString().equals("Pinus patula")){
                                                                                     if(treedbh.getText().toString().equals("43"))
                                                                                                          		myprice=2539;
                                                                                    if (treespecies.getText().toString().equals("Pinus patula")){
                                                                              	if(treedbh.getText().toString().equals("44"))
                                                                                                 myprice=2548;
                                                                                      if (treespecies.getText().toString().equals("Pinus patula")){
                                                                              	if(treedbh.getText().toString().equals("45"))
                                                                                                       myprice=2558;
                                                                        if (treespecies.getText().toString().equals("Pinus patula")){
                                                                                      if(treedbh.getText().toString().equals("46"))
                                                                                                           myprice=2565;
                                                                                    if (treespecies.getText().toString().equals("Pinus patula")){
                                                                                         if(treedbh.getText().toString().equals("47"))
                                                                                                            	myprice=2573;
                                                                       if (treespecies.getText().toString().equals("Pinus patula")){
                                                                                              if(treedbh.getText().toString().equals("48"))
                                                                                                              		myprice=2581;
                                                                                              if (treespecies.getText().toString().equals("Pinus patula")){
                                                                                             	if(treedbh.getText().toString().equals("49"))
                                                                                                                                  		myprice=2588;   
                                                                                             	 if (treespecies.getText().toString().equals("Pinus patula")){
                                                                                                  	if(treedbh.getText().toString().equals("50"))
                                                                                                                                       		myprice=2595;    
                                                                                             	 }
                                                                                              }
                                                                                              }
                                                                       }
                                                                                    }
                                                                        }
                                                                                      }
                                                                                    }
                                                                          	}
                                                                       }
                                                                        }
                                                                	
                                                                	
                                                                 }
                                                                 }
                                          }
                                                       }
                                                         }
                                                       }
                                                       }
                                                                         	}
                                                                     	}
                                                                 	}
                                                        	}
                                                        	}
                                                    	}
                                                	}
                                            	}
                                                	
                                    	}
                                	}
                            	}
                        	
                        }
                        }else
                        
                        
                        
                          if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                        	if(treedbh.getText().toString().equals("15"))
                        		myprice=2375;
                        	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                            	if(treedbh.getText().toString().equals("16"))
                            		myprice=2375;
                            	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                	if(treedbh.getText().toString().equals("17"))
                                		myprice=2398;
                                	
                                	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                    	if(treedbh.getText().toString().equals("18"))
                                    		myprice=2421;
                                    	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                        	if(treedbh.getText().toString().equals("19"))
                                        		myprice=2444;
                                        	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                            	if(treedbh.getText().toString().equals("20"))
                                            		myprice=2468;
                                            	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                	if(treedbh.getText().toString().equals("21"))
                                                		myprice=2468;
                               	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                    	if(treedbh.getText().toString().equals("22"))
                                                    		myprice=2511;
                                if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                            	if(treedbh.getText().toString().equals("23"))
                                                        		myprice=2532;
                                            if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                            	if(treedbh.getText().toString().equals("24"))
                                                            		myprice=2553;
                                           
                                       if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                             if(treedbh.getText().toString().equals("25"))
                                                                 		myprice=2572;
                                           if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                               	if(treedbh.getText().toString().equals("26"))
                                                           myprice=2596;
                                          if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                            	if(treedbh.getText().toString().equals("27"))
                                                             myprice=2611;
                                                                         	
                                             	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                        if(treedbh.getText().toString().equals("28"))
                                                                             		myprice=2627;
                                                       if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                 	if(treedbh.getText().toString().equals("29"))
                                                                    myprice=2644;
                                                         if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                 	if(treedbh.getText().toString().equals("30"))
                                                                          myprice=2661;
                                           if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                         if(treedbh.getText().toString().equals("31"))
                                                                              myprice=2678;
                                                       if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                            if(treedbh.getText().toString().equals("32"))
                                                                               	myprice=2692;
                                          if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                 if(treedbh.getText().toString().equals("33"))
                                                                                 		myprice=2706;
                                                                 if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                	if(treedbh.getText().toString().equals("34"))
                                                                                                     		myprice=2719;
                                                                	
                                                                  	
                                                                    if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                          if(treedbh.getText().toString().equals("35"))
                                                                                              		myprice=2732;
                                                                        if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                            	if(treedbh.getText().toString().equals("36"))
                                                                                        myprice=2745;
                                                                       if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                         	if(treedbh.getText().toString().equals("37"))
                                                                                          myprice=2757;
                                                                                                      	
                                                                          	if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                     if(treedbh.getText().toString().equals("38"))
                                                                                                          		myprice=2769;
                                                                                    if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                              	if(treedbh.getText().toString().equals("39"))
                                                                                                 myprice=2780;
                                                                                      if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                              	if(treedbh.getText().toString().equals("40"))
                                                                                                       myprice=2791;
                                                                        if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                      if(treedbh.getText().toString().equals("41"))
                                                                                                           myprice=2802;
                                                                                    if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                         if(treedbh.getText().toString().equals("42"))
                                                                                                            	myprice=2811;
                                                                       if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                              if(treedbh.getText().toString().equals("43"))
                                                                                                              		myprice=2821;
                                                                                              if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                             	if(treedbh.getText().toString().equals("44"))
                                                                                                                                  		myprice=2831;   
                                                                                             	 if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                                  	if(treedbh.getText().toString().equals("45"))
                                                                                                                                       		myprice=2842;    
                                                                                                  	
                                                                                                    if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                                        if(treedbh.getText().toString().equals("46"))
                                                                                                                             myprice=2850;
                                                                                                      if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                                           if(treedbh.getText().toString().equals("47"))
                                                                                                                              	myprice=2859;
                                                                                         if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                                                if(treedbh.getText().toString().equals("48"))
                                                                                                                                		myprice=2867;
                                                                                                                if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                                               	if(treedbh.getText().toString().equals("49"))
                                                                                                                                                    		myprice=2876;   
                                                                                                               	 if (treespecies.getText().toString().equals("Cupressus lucitanica")){
                                                                                                                    	if(treedbh.getText().toString().equals("50"))
                                                                                                                                                         		myprice=2883; 
                                                                                                               	 }
                                                                                                               	 }
                                                                                                                }
                                                                                         }
                                                                                                      }
                                                                                                  	
                                                                                             	 }
                                                                                              }
                                                                                              }
                                                                       }
                                                                                    }
                                                                        }
                                                                                      }
                                                                                    }
                                                                          	}
                                                                       }
                                                                        }
                                                                	
                                                                	
                                                                 }
                                                                 }
                                          }
                                                       }
                                                         }
                                                       }
                                                       }
                                                                         	}
                                                                     	}
                                                                 	}
                                                        	}
                                                        	}
                                                    	}
                                                	}
                                            	}
                                                	
                                    	}
                                	}
                            	}
                        	
                        }
                        }
                        else
                   if (treespecies.getText().toString().equals("Grevillea robusta")){
                          if(treedbh.getText().toString().equals("20"))
                            		myprice=2114;
                  if (treespecies.getText().toString().equals("Grevillea robusta")){
                       if(treedbh.getText().toString().equals("21"))
                               myprice=2114;
                     if (treespecies.getText().toString().equals("Grevillea robusta")){
                          if(treedbh.getText().toString().equals("22"))
                                myprice=2114;
                                    	
                          if (treespecies.getText().toString().equals("Grevillea robusta")){
                                        	if(treedbh.getText().toString().equals("23"))
                                        		myprice=2114;
                                        	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                            	if(treedbh.getText().toString().equals("24"))
                                            		myprice=2114;
                                            	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                	if(treedbh.getText().toString().equals("25"))
                                                		myprice=2461;
                                                	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                    	if(treedbh.getText().toString().equals("26"))
                                                    		myprice=2461;
                                                    	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                        	if(treedbh.getText().toString().equals("27"))
                                                        		myprice=2461;
                                                        	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                            	if(treedbh.getText().toString().equals("28"))
                                                            		myprice=2461;
                                                            	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                	if(treedbh.getText().toString().equals("29"))
                                                                		myprice=2461;
                                                                	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                    	if(treedbh.getText().toString().equals("30"))
                                                                    		myprice=2461;
                                                                    	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                        	if(treedbh.getText().toString().equals("31"))
                                                                        		myprice=2461;
                                                                        	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                            	if(treedbh.getText().toString().equals("32"))
                                                                            		myprice=2840;
                                                                            	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                	if(treedbh.getText().toString().equals("33"))
                                                                                		myprice=2840;
                                                                                	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                    	if(treedbh.getText().toString().equals("34"))
                                                                                    		myprice=2840;
                                                                                    	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                        	if(treedbh.getText().toString().equals("35"))
                                                                                        		myprice=2840;
                                                                                        	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                            	if(treedbh.getText().toString().equals("36"))
                                                                                            		myprice=2840;
                                                                                            	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                	if(treedbh.getText().toString().equals("37"))
                                                                                                		myprice=2840;
                                                                                                	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                    	if(treedbh.getText().toString().equals("38"))
                                                                                                    		myprice=2840;
                                                                                                    	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                        	if(treedbh.getText().toString().equals("39"))
                                                                                                        		myprice=2840;    
                                                                                                        	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                            	if(treedbh.getText().toString().equals("40"))
                                                                                                            		myprice=3555;
                                                                                                            	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                                	if(treedbh.getText().toString().equals("41"))
                                                                                                                		myprice=3555;
                                                                                                                	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                                    	if(treedbh.getText().toString().equals("42"))
                                                                                                                    		myprice=3555;
                                                                                                                    	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                                        	if(treedbh.getText().toString().equals("43"))
                                                                                                                        		myprice=3555;
                                                                                                                        	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                                            	if(treedbh.getText().toString().equals("44"))
                                                                                                                            		myprice=3555;
                                                                                                                            	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                                                	if(treedbh.getText().toString().equals("45"))
                                                                                                                                		myprice=3555;
                                                                                                                                	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                                                                                                    	if(treedbh.getText().toString().equals("46"))
                                                                                                                                    		myprice=3555;        
                                                                                                                                    	if (treespecies.getText().toString().equals("Grevillea robusta")){
    if(treedbh.getText().toString().equals("47"))
                                                                                                                                        		myprice=3555;     
 if (treespecies.getText().toString().equals("Grevillea robusta")){
    if(treedbh.getText().toString().equals("48"))
                myprice=3972;
 if (treespecies.getText().toString().equals("Grevillea robusta")){
   if(treedbh.getText().toString().equals("49"))
                myprice=3972;
  if (treespecies.getText().toString().equals("Grevillea robusta")){
           if(treedbh.getText().toString().equals("50"))
                   myprice=3972;
  if (treespecies.getText().toString().equals("Grevillea robusta")){
     if(treedbh.getText().toString().equals("51"))
                       myprice=3972;
                                                                	
                                                                	
                                                                	
                                                                	
                                           if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                 if(treedbh.getText().toString().equals("52"))
                                                                     		myprice=3972;
                                               if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                   	if(treedbh.getText().toString().equals("53"))
                                                               myprice=3972;
                                              if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                	if(treedbh.getText().toString().equals("54"))
                                                                 myprice=3972;
                                                                             	
                                                 	if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                            if(treedbh.getText().toString().equals("55"))
                                                                                 		myprice=3972;
                                                           if (treespecies.getText().toString().equals("Grevillea robusta")){
                                                     	if(treedbh.getText().toString().equals("56"))
                                                                        myprice=4311;
                                                           }
                                                           }
                                                 	}
                                              }
                                               }
                                           }
                                                                                                 	 }
                                                                                                  }
                                                                                                  }
                                                                           }
                                                                                        }
                                                                            }
                                                                                          }
                                                                                        }
                                                                              	}
                                                                           }
                                                                            }
                                                                    	
                                                                    	
                                                                     }
                                                                     }
                                              }
                                                           }
                                                             }
                                                           }
                                                           }
                                                                             	}
                                                                         	}
                                                                     	}
               }
                                                            	}
                                                        	}
                                                    	}
                                                	}
                                                    	
                                        	}
                                    	}
                                	}
                            	
                            }
                            }
                            else
                        {
                        	myprice=0;
                        		
                        }
                        
                       
                        
                        
                        build.setTitle("Tree Details");
                        build.setMessage(
                                "Dbh                    \t"+treedbh.getText().toString()+
                                "\nHeight               \t"+treeheight.getText().toString()+
                                "\nBasal                \t"+treebasal.getText().toString()+
                                "\nVolume               \t"+treevolume.getText().toString());

                        build.setPositiveButton("Estimate Value",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                            	
                            	double finalprice;
                    	    	double vol = Double.parseDouble(treevolume.getText().toString());
                    	    	
                    	    	finalprice=myprice*vol;
                    	    	
                                Intent inte=new Intent(SpinnerClass.this,Cost.class);
                                inte.putExtra("plotno",plotno.getText().toString());
                                inte.putExtra("plantationname",plantationName.getText().toString());
                                inte.putExtra("treespecies",treespecies.getText().toString());
                                inte.putExtra("treedbh",treedbh.getText().toString());
                                inte.putExtra("treeheight",treeheight.getText().toString());
                                inte.putExtra("treebasal",treebasal.getText().toString());
                                inte.putExtra("treevolume",treevolume.getText().toString());
                                inte.putExtra("myprice", myprice);
                                inte.putExtra("finalprice", finalprice);
                                
                                startActivity(inte);

                            }
                        });                       //build.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                           // @Override
                           //public void onClick(DialogInterface dialogInterface, int i) {

                           // }
                       // });
                        build.show();
                   }
                });

              break;
            case 2:
                cursor=db.getPoleDetails();
                listView.setAdapter(new PoleIconicAdapter(this,cursor));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        final TextView poletd,polebd,polelength,polevolume,treespecies,plantationName,plotno;
                        plantationName=(TextView)view.findViewById(R.id.tv_poleplants_name);
                        treespecies=(TextView)view.findViewById(R.id.tv_pole_species);
                        plotno=(TextView)view.findViewById(R.id.tv_poleplot_no);
                        poletd=(TextView)view.findViewById(R.id.tv_pole_td);
                        polebd=(TextView)view.findViewById(R.id.tv_pole_bd);
                        polelength=(TextView)view.findViewById(R.id.tv_pole_length);
                        polevolume=(TextView)view.findViewById(R.id.tv_pole_volume);
                       
                        
         if (treespecies.getText().toString().equals("Eucalyptus saligna")){
                  if(polelength.getText().toString().equals("10"))
                              myprice=2500;
         if (treespecies.getText().toString().equals("Eucalyptus saligna")){
        	 if(polelength.getText().toString().equals("11"))
                             myprice=3000;
         if (treespecies.getText().toString().equals("Eucalyptus saligna")){
        	 if(polelength.getText().toString().equals("12"))
                              myprice=3000;
                                	
          if (treespecies.getText().toString().equals("Eucalyptus saligna")){
        	  if(polelength.getText().toString().equals("14"))
                             myprice=4000;
          
                                      }
                                       }
                                }
                                            }
         else
        	 if (treespecies.getText().toString().equals("Eucalyptus grandis")){
                 if(polelength.getText().toString().equals("10"))
                             myprice=2500;
        if (treespecies.getText().toString().equals("Eucalyptus grandis")){
       	 if(polelength.getText().toString().equals("11"))
                            myprice=3000;
        if (treespecies.getText().toString().equals("Eucalyptus grandis")){
       	 if(polelength.getText().toString().equals("12"))
                             myprice=3000;
                               	
         if (treespecies.getText().toString().equals("Eucalyptus grandis")){
       	  if(polelength.getText().toString().equals("14"))
                            myprice=4000;
         
                                     }
                                      }
                               }
                                           }
                           
         
                        else
                        {
                        	myprice=0;
                        		
                        }
                        
                       
                        
                        
                        build.setTitle("Pole Details");
                        build.setMessage(
                                "Td                        \t"+poletd.getText().toString()+
                                "\nBd                      \t\t"+polebd.getText().toString()+
                                "\nLength                   "+polelength.getText().toString()+
                                "\nVolume                  "+polevolume.getText().toString());

                        build.setPositiveButton("Estimate Value",new DialogInterface.OnClickListener() {
                            @Override
 public void onClick(DialogInterface dialogInterface, int i){
                            	
                            	double finalprice;
                    	    	double vol = Double.parseDouble(polevolume.getText().toString());
                    	    	
                    	    	finalprice=myprice*vol;
                    	    	
                                Intent inte=new Intent(SpinnerClass.this,Pole_Cost.class);
                                inte.putExtra("plotno",plotno.getText().toString());
                                inte.putExtra("plantationname",plantationName.getText().toString());
                                inte.putExtra("treespecies",treespecies.getText().toString());
                                inte.putExtra("poletd",poletd.getText().toString());
                                inte.putExtra("polebd",polebd.getText().toString());
                                inte.putExtra("polelength",polelength.getText().toString());
                                inte.putExtra("polevolume",polevolume.getText().toString());
                                inte.putExtra("myprice", myprice);
                                inte.putExtra("finalprice", finalprice);
                                
                                startActivity(inte);

                            }
                        });                       //build.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                           // @Override
                           //public void onClick(DialogInterface dialogInterface, int i) {

                           // }
                       // });
                        build.show();
                   }
                });

              break;
           default:


        }
   }
   

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    	
         Cursor treedbh = db.SumPlantColumnsDbh(i+ 1);
         Cursor treeheight=db.SumPlantColumnsHeight(i+ 1);
         Cursor poletd = db.SumPlantColumnsTd(i+ 1);
         Cursor polebd = db.SumPlantColumnsBd(i+ 1);
         Cursor polelength=db.SumPlantColumnsLength(i+ 1);
         Cursor cursor=db.getPlantationDetails(i+1);
         cursor.moveToFirst();
         treedbh.moveToFirst();
         treeheight.moveToFirst();
         poletd.moveToFirst();
         polebd.moveToFirst();
         polelength.moveToFirst();
        long plots=db.getPlotCount(i+1);
        long sum_height=treeheight.getLong(0);
        long sum_dbh = treedbh.getLong(0);
        long sum_length=polelength.getLong(0);
        long sum_td= poletd.getLong(0);
        long sum_bd=  polebd.getLong(0);
        long rows = db.counttreeRows(i+1);
        long rows1 = db.countpoleRows(i+1);
       
    usage=cursor.getString(7);
     ///  int lastInsert= Integer.parseInt(cursor.getString(0));
      if(usage.equals("Poles")){
    	  
    	  DecimalFormat format=new DecimalFormat();
          build.setTitle("Plantation Summary");
          build.setMessage(""
                  + "No of Plots                       \t\t"+plots+"\n"
                  + "No of Poles                         \t"+rows1+"\n"
                  + "Total td                        \t\t\t"+sum_td+"\n"
                  + "Total bd                          \t\t"+sum_bd+"\n"
                  + "Average td                        \t\t"+format.format((double)(sum_td)/(double)(rows1))+"\n"
                  + "Average bd                          \t"+format.format((double)(sum_bd)/(double)(rows1))+"\n"
                  + "Total Length                        \t"+format.format((double)(sum_length))+"\n"
                  + "Average Length                \t\t"+format.format((double)(sum_length)/(double)(rows1))+"\n"
                 

         );
          build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            //  @Override
             @Override
			public void onClick(DialogInterface dialogInterface, int i) {

            	
              }
          });
          build.show();
      
            }
      else {
    	  cursor.moveToNext();
          DecimalFormat format=new DecimalFormat();
          build.setTitle("Plantation Summary");
          build.setMessage(""
                  + "No of plots                    \t\t"+ plots +"\n"
                  + "No of Trees                    \t\t"+ rows +"\n"
                  + "Total dbh                      \t\t"+ sum_dbh +"\n"
                  + "Average dbh                    \t"+format.format ((double)(sum_dbh)/(double)(rows) )+"\n"
                  + "Total Height                   \t"+format.format((double)(sum_height))+"\n"
                  + "Average Height                 \t"+ format.format((double) (sum_height) / (double) (rows)) +"\n"

         );
          build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            //  @Override
             @Override
			public void onClick(DialogInterface dialogInterface, int i) {


              }
          });
          build.show();
        }

    }

    private class PlantIconicAdapter extends CursorAdapter {
        @SuppressLint("NewApi") public PlantIconicAdapter(Context spinnerClass, Cursor cursor) {
            super(spinnerClass,cursor,0);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(R.layout.plant_layout,parent,false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
           TextView plantname,no,plantcord,treespeci,date,category;
            no=(TextView)view.findViewById(R.id.owner);
            plantname=(TextView)view.findViewById(R.id.plant_name);
            date=(TextView)view.findViewById(R.id.tdate);
            treespeci=(TextView)view.findViewById(R.id.plant_species);
            category=(TextView)view.findViewById(R.id.plant_category);
            plantcord=(TextView)view.findViewById(R.id.plant_cord);
            
            no.setText(cursor.getString(0));
            plantname.setText(cursor.getString(1));
            date.setText(cursor.getString(6));
            treespeci.setText(cursor.getString(3));
            category.setText(cursor.getString(7));
            plantcord.setText(cursor.getString(4)+","+cursor.getString(5));
           

        }
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

@Override
public void onBackPressed() {
    super.onBackPressed();
    startActivity(new Intent (SpinnerClass.this, HomeActivity.class));
    finish();
}

}




