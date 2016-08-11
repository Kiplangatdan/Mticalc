package com.app.mticalc.db;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

@SuppressLint("NewApi")
public class DatabaseHandler extends SQLiteOpenHelper{
	
	// Database Version
	private static final int DATABASE_VERSION = 1;
	// Database Name
	private static final String DATABASE_NAME = "Mst.db";
	// Employee table name
    private static  final String TABLE_PLOT_DETAILS="PLOT_DETAILS";
	private static final String TABLE_TREE_DETAIL = "TREE_DETAILS";
	private static final String TABLE_POLE_DETAIL = "POLE_DETAILS";

	private static  final String TABLE_PLANT_DETAILS="PLANT_DETAILS";
    private static final String TABLE_USER ="USER";
    private  ContentValues values;
    private SQLiteDatabase db;

    String CREATE_TREE_TABLE = "CREATE TABLE " + TABLE_TREE_DETAIL + "("
            + DbColumns.TreeDetails.TreeId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DbColumns.TreeDetails.TreeNo + " TEXT,"
            + DbColumns.TreeDetails.Plot_id+" INTEGER NOT NULL CONSTRAINT " + DbColumns.PlotDetails.plot_id+"  REFERENCES "+TABLE_PLOT_DETAILS+"("+DbColumns.PlotDetails.plot_id+") ON DELETE CASCADE, "
            + DbColumns.TreeDetails.Plant_id+ " INTEGER NOT NULL CONSTRAINT " +DbColumns.PlantDetails.plant_id+ " REFERENCES " + TABLE_PLANT_DETAILS+"("+DbColumns.PlantDetails.plant_id +") ON DELETE CASCADE, "
            + DbColumns.TreeDetails.Height + " REAL,"
            + DbColumns.TreeDetails.TreeDbh + " REAL"
            
            + ")";

    String CREATE_POLE_TABLE = "CREATE TABLE " + TABLE_POLE_DETAIL + "("
            + DbColumns.PoleDetails.PoleId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DbColumns.PoleDetails.PoleNo + " TEXT,"
            + DbColumns.PoleDetails.Plot_id+" INTEGER NOT NULL CONSTRAINT " + DbColumns.PlotDetails.plot_id+"  REFERENCES "+TABLE_PLOT_DETAILS+"("+DbColumns.PlotDetails.plot_id+") ON DELETE CASCADE, "
            + DbColumns.PoleDetails.Plant_id+ " INTEGER NOT NULL CONSTRAINT " +DbColumns.PlantDetails.plant_id+ " REFERENCES " + TABLE_PLANT_DETAILS+"("+DbColumns.PlantDetails.plant_id +") ON DELETE CASCADE, "
            + DbColumns.PoleDetails.Length + " REAL,"
            + DbColumns.PoleDetails.PoleTd + " REAL,"
            + DbColumns.PoleDetails.PoleBd + " REAL"
            + ")";

    
    
    String CREATE_TREE_USER = "CREATE TABLE "+ TABLE_USER +"("+DbColumns.UserDetails.user_id +" INTEGER PRIMARY KEY AUTOINCREMENT,"
            +DbColumns.UserDetails.user_name+" TEXT)";

    //create a table for plot
    String CREATE_PLOT_TABLE=" CREATE TABLE "+ TABLE_PLOT_DETAILS + "("
        +DbColumns.PlotDetails.plot_id+" INTEGER PRIMARY KEY AUTOINCREMENT,"
        +DbColumns.PlotDetails.plant_id+" INTEGER NOT NULL CONSTRAINT "+ DbColumns.PlantDetails.plant_id
            +" REFERENCES "+TABLE_PLANT_DETAILS +
            "("+DbColumns.PlantDetails.plant_id+") ON DELETE CASCADE,"
        + DbColumns.PlotDetails.plot_no+ " TEXT "
         +")"  ;




    String CREATE_PLANT_TABLE = "CREATE TABLE " + TABLE_PLANT_DETAILS + "("
            + DbColumns.PlantDetails.user_id
            + " INTEGER NOT NULL CONSTRAINT "+DbColumns.UserDetails.user_id+" REFERENCES "+TABLE_USER+"("+DbColumns.UserDetails.user_id+") ON DELETE CASCADE, "
            + DbColumns.PlantDetails.plant_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + DbColumns.PlantDetails.PlantName + " TEXT,"
            + DbColumns.PlantDetails.OwnerName + " TEXT,"
            + DbColumns.PlantDetails.TreeSpecies + " TEXT NOT NULL,"
            + DbColumns.PlantDetails.Area + " REAL,"
            + DbColumns.PlantDetails.Spacing + " TEXT,"
            + DbColumns.PlantDetails.Date + " DATETIME,"
            + DbColumns.PlantDetails.Latitude + " TEXT,"
            + DbColumns.PlantDetails.Longitude + " TEXT,"
            +  DbColumns.PlantDetails.usage + " TEXT" 
            + ")";


    public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PLANT_TABLE);
		db.execSQL(CREATE_TREE_TABLE);
		db.execSQL(CREATE_POLE_TABLE);
		Log.d("Table", "Table"+CREATE_POLE_TABLE+"created");
       db.execSQL(CREATE_PLOT_TABLE);
       Log.d("Table", "Table"+CREATE_PLOT_TABLE+"created");
        db.execSQL(CREATE_TREE_USER);

        db.execSQL("PRAGMA foreign_keys=ON;");
		//db.close();

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_TREE_DETAIL);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_POLE_DETAIL);		
       db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLOT_DETAILS);
		// Create tables again
		onCreate(db);

	}

	// Adding new user
	public int addTreeDetails(MtiCalcDetails tree)
	{
		db = this.getWritableDatabase();
		values = new ContentValues();
		values.put(DbColumns.TreeDetails.TreeNo, tree.getTreeNo());
        values.put(DbColumns.TreeDetails.Plot_id,tree.getPlotId1());
        values.put(DbColumns.TreeDetails.Plant_id,tree.getPlantId1());
        values.put(DbColumns.TreeDetails.Height,tree.getTreeHeight());
        values.put(DbColumns.TreeDetails.TreeDbh, tree.getTreedbh());
        
        		// Inserting Row
		int id = (int) db.insert(TABLE_TREE_DETAIL, null, values);
		db.close(); // Closing database connection
		return id;
	}
	
	public int addPoleDetails(MtiCalcDetails pole)
	{
		db = this.getWritableDatabase();
		values = new ContentValues();
		values.put(DbColumns.PoleDetails.PoleNo, pole.getPoleNo());
        values.put(DbColumns.PoleDetails.Plot_id,pole.getPlotId());
        values.put(DbColumns.PoleDetails.Plant_id,pole.getPlantId());
        values.put(DbColumns.PoleDetails.Length,pole.getPoleLength());
        values.put(DbColumns.PoleDetails.PoleTd, pole.getPoletd());
        values.put(DbColumns.PoleDetails.PoleBd, pole.getPolebd());
        		// Inserting Row
		int id = (int) db.insert(TABLE_POLE_DETAIL, null, values);
		db.close(); // Closing database connection
		return id;
	}
    public long insertuser(String ownerName){
        long result;
        db=this.getWritableDatabase();
        values=new ContentValues();
        values.put(DbColumns.UserDetails.user_name,ownerName);
        result=db.insert(TABLE_USER,null,values);
db.close();
        return result;
    }

    //insert plot detail
    public long addPlotDetails(MtiCalcDetails plot){
        db=this.getWritableDatabase();
       values=new ContentValues();
        values.put(DbColumns.PlotDetails.plant_id, plot.getPlot_plant_id());
        values.put(DbColumns.PlotDetails.plot_no,plot.getPlot_plot_no());
        return  db.insert(TABLE_PLOT_DETAILS,null,values);
    }



//insert plantation details
    public long addPlantDetails(MtiCalcDetails plot) {
        long id;
        db = this.getWritableDatabase();
       values = new ContentValues();
        values.put(DbColumns.PlantDetails.user_id,plot.getUserid());
        values.put(DbColumns.PlantDetails.PlantName, plot.getPlotname());
        values.put(DbColumns.PlantDetails.OwnerName, plot.getOwnername());
        values.put(DbColumns.PlantDetails.TreeSpecies, plot.getTreespecies());
        values.put(DbColumns.PlantDetails.Area, plot.getArea());
        values.put(DbColumns.PlantDetails.Spacing, plot.getSpacing());
        values.put(DbColumns.PlantDetails.Date,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        values.put(DbColumns.PlantDetails.Latitude, plot.getLatitude());
        values.put(DbColumns.PlantDetails.Longitude, plot.getLongitude());
        values.put(DbColumns.PlantDetails.usage, plot.getUsage());



        id = db.insert(TABLE_PLANT_DETAILS, null, values);
        db.close();
        return id;
    }

	//updating a existing user

    /*
    *@param
     * string id
      * the plot id
    * */
//get the data of all tree with a given id
	public  Cursor getTreeDetails() {

        db = this.getReadableDatabase();
        String query="select "
        		+TABLE_TREE_DETAIL+"."+DbColumns.TreeDetails.Plot_id+","
                +TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.plant_id+","
                +TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.PlantName+ ","+
                 TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.Date+","+
                 TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.TreeSpecies+","
                +TABLE_TREE_DETAIL  +"."+DbColumns.TreeDetails.TreeNo +","
                +TABLE_TREE_DETAIL+"."+DbColumns.TreeDetails.Height +","
                +TABLE_TREE_DETAIL+"."+DbColumns.TreeDetails.TreeDbh +
               
                
                " FROM "+TABLE_TREE_DETAIL+" INNER JOIN "
                +TABLE_PLANT_DETAILS +  " ON "+TABLE_TREE_DETAIL+
                "."+(DbColumns.TreeDetails.Plant_id)+"="
                +TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.plant_id
                +" ORDER BY "+ TABLE_TREE_DETAIL +"."+ DbColumns.TreeDetails.TreeId+" DESC";


        return db.rawQuery(query,null);

	}

	public  Cursor getPoleDetails() {

        db = this.getReadableDatabase();
        String query="select "
        		+TABLE_POLE_DETAIL+"."+DbColumns.PoleDetails.Plot_id+","
                +TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.plant_id+","
                +TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.PlantName+ ","+
                 TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.Date+","+
                 TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.TreeSpecies+","
                +TABLE_POLE_DETAIL  +"."+DbColumns.PoleDetails.PoleNo +","
                +TABLE_POLE_DETAIL+"."+DbColumns.PoleDetails.PoleTd +","
                +TABLE_POLE_DETAIL+"."+DbColumns.PoleDetails.PoleBd +","
                +TABLE_POLE_DETAIL+"."+DbColumns.PoleDetails.Length +
                
                
                
                " FROM "+TABLE_POLE_DETAIL+" INNER JOIN "
                +TABLE_PLANT_DETAILS +  " ON "+TABLE_POLE_DETAIL+
                "."+(DbColumns.PoleDetails.Plant_id)+"="
                +TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.plant_id
                +" ORDER BY "+ TABLE_POLE_DETAIL +"."+ DbColumns.PoleDetails.PoleId+" DESC";


        return db.rawQuery(query,null);

	}





    public void delete() {
        SQLiteDatabase db=this.getWritableDatabase();
        String whereClause = DbColumns.TreeDetails.Plot_id + "=" +DbColumns.PlantDetails.plant_id;
        db.delete(TABLE_TREE_DETAIL,whereClause,null);

    }
   


    @SuppressLint("NewApi")
	@Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

///get the tree data with a given tree id


    //sum of all data entered in a particular plot
    public Cursor SumPlantColumnsDbh(int i) {
        db=this.getWritableDatabase();
                String select="SELECT sum("+DbColumns.TreeDetails.TreeDbh+") AS "+DbColumns.TreeDetails.TreeDbh+
                " FROM "+TABLE_TREE_DETAIL+" WHERE "+(DbColumns.TreeDetails.Plant_id)+"="+i;
        return db.rawQuery(select,null);
    }
    public Cursor SumPlantColumnsTd(int i) {
        db=this.getWritableDatabase();
                String select="SELECT sum("+DbColumns.PoleDetails.PoleTd+") AS "+DbColumns.PoleDetails.PoleTd+
                " FROM "+TABLE_POLE_DETAIL+" WHERE "+(DbColumns.PoleDetails.Plant_id)+"="+i;
        return db.rawQuery(select,null);
    }
    public Cursor SumPlantColumnsBd(int i) {
        db=this.getWritableDatabase();
                String select="SELECT sum("+DbColumns.PoleDetails.PoleBd+") AS "+DbColumns.PoleDetails.PoleBd+
                " FROM "+TABLE_POLE_DETAIL+" WHERE "+(DbColumns.PoleDetails.Plant_id)+"="+i;
        return db.rawQuery(select,null);
    }
    public Cursor SumPlantColumnsHeight(int i) {
        db=this.getWritableDatabase();
        String select="SELECT sum("+DbColumns.TreeDetails.Height+") AS "+DbColumns.TreeDetails.TreeDbh+
                " FROM "+TABLE_TREE_DETAIL+
                " WHERE "+(DbColumns.TreeDetails.Plant_id)+"="+i;
        return db.rawQuery(select,null);
    }
    public Cursor SumPlantColumnsLength(int i) {
        db=this.getWritableDatabase();
        String select="SELECT sum("+DbColumns.PoleDetails.Length+") AS "+DbColumns.PoleDetails.PoleTd+
                " FROM "+TABLE_POLE_DETAIL+
                " WHERE "+(DbColumns.PoleDetails.Plant_id)+"="+i;
        return db.rawQuery(select,null);
    }
//count the no of tree entered for a given plantation
    public long counttreeRows(int i) {
        db=this.getWritableDatabase();
        String count=TABLE_TREE_DETAIL+
                " WHERE "+(DbColumns.TreeDetails.Plant_id)+"="+i;
        return DatabaseUtils.queryNumEntries(db,count);
    }
    public long countpoleRows(int i) {
        db=this.getWritableDatabase();
        String count=TABLE_POLE_DETAIL+
                " WHERE "+(DbColumns.PoleDetails.Plant_id)+"="+i;
        return DatabaseUtils.queryNumEntries(db,count);
    }


    public Cursor getPlantationDetails() {
        db=this.getWritableDatabase();
        String[] columns={DbColumns.PlantDetails.plant_id, DbColumns.PlantDetails.PlantName,
                DbColumns.PlantDetails.OwnerName,DbColumns.PlantDetails.TreeSpecies,
                DbColumns.PlantDetails.Latitude,DbColumns.PlantDetails.Longitude, 
                DbColumns.PlantDetails.Date,DbColumns.PlantDetails.usage};

        
        Cursor cursor=db.query(TABLE_PLANT_DETAILS,columns,null,null,null,null,null);
        return cursor;
    }

    public long getPlotCount(int i) {
        db=this.getWritableDatabase();
        String count=TABLE_PLOT_DETAILS+" WHERE "
                +(DbColumns.PlotDetails.plant_id)+"="+i;
        return DatabaseUtils.queryNumEntries(db,count);

    }

    public Cursor getAllPlotDetails() {
        db=this.getWritableDatabase();
        String select="SELECT "+ DbColumns.PlotDetails.plot_id+","+DbColumns.PlotDetails.plot_no
                +","+DbColumns.PlantDetails.PlantName
                + " FROM "+TABLE_PLANT_DETAILS +" INNER JOIN "
                +TABLE_PLOT_DETAILS +" ON " +TABLE_PLOT_DETAILS+"." +
                ""+DbColumns.PlotDetails.plant_id+"=" +
                ""+TABLE_PLANT_DETAILS+"."+DbColumns.PlantDetails.plant_id+" " +
                "INNER JOIN "+TABLE_TREE_DETAIL +" ON "+
                TABLE_TREE_DETAIL+"."+DbColumns.TreeDetails.Plot_id+"="+TABLE_PLOT_DETAILS+"."+DbColumns.PlotDetails.plot_id;
        
        return db.rawQuery(select,null);
        
    }
    public Cursor getPlantationDetails(int i) {
        db=this.getWritableDatabase();
        String[] columns={DbColumns.PlantDetails.plant_id, DbColumns.PlantDetails.PlantName,
                DbColumns.PlantDetails.OwnerName,DbColumns.PlantDetails.TreeSpecies,
                DbColumns.PlantDetails.Latitude,DbColumns.PlantDetails.Longitude,
                DbColumns.PlantDetails.Date,DbColumns.PlantDetails.usage};

String whereClause=DbColumns.PlantDetails.plant_id+"="+i;
        Cursor cursor=db.query(TABLE_PLANT_DETAILS,columns,whereClause,null,null,null,null);

        return cursor;
    }
    
    
    public Cursor SumPlotColumnsDbh(int i) {
        db=this.getWritableDatabase();
        String select="SELECT sum("+DbColumns.TreeDetails.TreeDbh+") AS "+DbColumns.TreeDetails.TreeDbh+
                " FROM "+TABLE_TREE_DETAIL+" INNER JOIN "+TABLE_PLOT_DETAILS +  " ON "+TABLE_TREE_DETAIL+
                "."+(DbColumns.TreeDetails.Plot_id)+"="
                +TABLE_PLOT_DETAILS+"."+DbColumns.PlotDetails.plot_id+"="+i;
        return db.rawQuery(select,null);
    }
    public Cursor SumPlotColumnsTd(int i) {
        db=this.getWritableDatabase();
        String select="SELECT sum("+DbColumns.PoleDetails.PoleTd+") AS "+DbColumns.PoleDetails.PoleTd+
                " FROM "+TABLE_POLE_DETAIL+" INNER JOIN "+TABLE_PLOT_DETAILS +  " ON "+TABLE_POLE_DETAIL+
                "."+(DbColumns.PoleDetails.Plot_id)+"="
                +TABLE_PLOT_DETAILS+"."+DbColumns.PlotDetails.plot_id+"="+i;
        return db.rawQuery(select,null);
    }
    public Cursor SumPlotColumnsBd(int i) {
        db=this.getWritableDatabase();
        String select="SELECT sum("+DbColumns.PoleDetails.PoleBd+") AS "+DbColumns.PoleDetails.PoleBd+
                " FROM "+TABLE_POLE_DETAIL+" INNER JOIN "+TABLE_PLOT_DETAILS +  " ON "+TABLE_POLE_DETAIL+
                "."+(DbColumns.PoleDetails.Plot_id)+"="
                +TABLE_PLOT_DETAILS+"."+DbColumns.PlotDetails.plot_id+"="+i;
        return db.rawQuery(select,null);
    }

    public Cursor SumPlotColumnsHeight(int i) {
        db=this.getWritableDatabase();
        String select="SELECT sum("+DbColumns.TreeDetails.Height+") AS "+DbColumns.TreeDetails.Height+
                " FROM "+TABLE_TREE_DETAIL+" INNER JOIN "+TABLE_PLOT_DETAILS +  " ON "+TABLE_TREE_DETAIL+
                "."+(DbColumns.TreeDetails.Plot_id)+"="
                +TABLE_PLOT_DETAILS+"."+DbColumns.PlotDetails.plot_id+"="+i;
        return db.rawQuery(select,null);
    }
    public Cursor SumPlotColumnsLength(int i) {
        db=this.getWritableDatabase();
        String select="SELECT sum("+DbColumns.PoleDetails.Length+") AS "+DbColumns.PoleDetails.Length+
                " FROM "+TABLE_POLE_DETAIL+" INNER JOIN "+TABLE_PLOT_DETAILS +  " ON "+TABLE_POLE_DETAIL+
                "."+(DbColumns.PoleDetails.Plot_id)+"="
                +TABLE_PLOT_DETAILS+"."+DbColumns.PlotDetails.plot_id+"="+i;
        return db.rawQuery(select,null);
    }

    public Cursor getAllTreeDetails() {
           db=this.getWritableDatabase();

            return  db.rawQuery("SELECT "+DbColumns.TreeDetails.TreeId+"," +
                    ""+DbColumns.TreeDetails.TreeDbh +","+DbColumns.TreeDetails.Height+" FROM "+TABLE_TREE_DETAIL+" ORDER BY "+DbColumns.TreeDetails.TreeId+" DESC",null);
    }
    public Cursor getAllPoleDetails() {
        db=this.getWritableDatabase();

         return  db.rawQuery("SELECT "+DbColumns.PoleDetails.PoleId+"," +
                 ""+DbColumns.PoleDetails.PoleTd +","+DbColumns.PoleDetails.PoleBd +","+DbColumns.PoleDetails.Length+" FROM "+TABLE_POLE_DETAIL+" ORDER BY "+DbColumns.PoleDetails.PoleId+" DESC",null);
 }
}

