package com.app.mticalc.db;

import android.provider.BaseColumns;

/**
 * Created by Asus on 5/4/2015.
 */
public final class DbColumns {
    private DbColumns()
    {
        //to prevent a instantion by objects created
    }

    //class for tree details
    public static abstract class TreeDetails implements BaseColumns{



        private TreeDetails(){
            //to prevent instantion
        }
        public static final String Plant_id="plantationid";
        public static final String TreeId = "_id";
        public static final String TreeNo = "Treeno";
        public static final String Height="Height";
        public static final String TreeDbh ="treedbh";
        public static final String Plot_id="plotid";
    }
    
    
    public static abstract class PoleDetails implements BaseColumns{



        private PoleDetails(){
            //to prevent instantion
        }
        public static final String Plant_id="plantationid";
        public static final String PoleId = "_id";
        public static final String PoleNo = "Poleno";
        public static final String Length = "Length";
        public static final String PoleTd = "poletd";
        public static final String PoleBd = "polebd";
        public static final String Plot_id= "plotid";
    }
    
   
    public static abstract class PlantDetails implements BaseColumns {


        public static final String user_id="user_id";

        private PlantDetails(){
            //make it private to prevent instantion
        }
        public static final String TreeSpecies="Treespecie";
        public static final String OwnerName="OwnerName";
        public static final String PlantName="plotname";
        public static final String Area="Area";
        public static final String Date = "Date";
        public static final String Latitude="Latitude";
        public static final  String Longitude="Longitude";
        public static final String Spacing = "spacing";
        public static final String plant_id = "_id";
        public static final String usage = "usage";
        
        

                

    }

    public class UserDetails {
        public static final String user_name="user_name";
        public static final String user_id="user_id";
    }
    public   abstract  class PlotDetails implements  BaseColumns{
        protected PlotDetails() {
        }
        public static final String plant_id = "plantid";//foreign key in plot table

        public static final String plot_id = "_id";//primary key
        public static final String plot_no = "PlotNo";//primary key
    }

}
