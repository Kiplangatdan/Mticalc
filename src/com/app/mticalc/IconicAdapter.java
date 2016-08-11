package com.app.mticalc;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;






/**
 * Created by Asus on 5/13/2015.
 */
public class IconicAdapter extends CursorAdapter {
    private static final double PI = 3.142;
    private static final double DIVISOR = 40000;


    
    

    @SuppressLint("NewApi")
	public IconicAdapter(Context spinnerClass, Cursor cursor) {
        super(spinnerClass,cursor,0);
    }

    
    
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.listwith_views,viewGroup,false);
    }

    @SuppressWarnings("unused")
	@Override
    public void bindView(View view, Context context, Cursor cursor) {
        DecimalFormat format=new DecimalFormat("#0.0000");
        double BaseArea = (PI * Double.parseDouble(cursor.getString(7)) * Double.parseDouble(cursor.getString(7)) / DIVISOR);
        double volume = BaseArea * Double.parseDouble(cursor.getString(6));
        
        
         TextView treedbh,treeheight,treebasal,treevolume,treeno,plantName,treespecie,date,plotno;
         plantName=(TextView)view.findViewById(R.id.tv_plants_name);
         date=(TextView)view.findViewById(R.id.tv_date);
         treespecie=(TextView)view.findViewById(R.id.tv_tree_species);
         plotno=(TextView)view.findViewById(R.id.tv_plot_no);

        treeno=(TextView)view.findViewById(R.id.tv_tree_no);
        treedbh=(TextView)view.findViewById(R.id.tv_tree_dbh);
        treeheight=(TextView)view.findViewById(R.id.tv_tree_height);
        treebasal=(TextView)view.findViewById(R.id.tv_tree_basal);
        treevolume=(TextView)view.findViewById(R.id.tv_tree_volume);
        plotno.setText(cursor.getString(0));
        plantName.setText(cursor.getString(2));
        date.setText(cursor.getString(3));
        treespecie.setText(cursor.getString(4));
        treeno.setText(cursor.getString(5));
        treedbh.setText(cursor.getString(7));
        treeheight.setText(cursor.getString(6));
        treebasal.setText(String.valueOf(format.format(BaseArea)));
        treevolume.setText(String.valueOf( format.format(volume)));

    }



	



	private String TreeSpecies(String treeSpecies2) {
		// TODO Auto-generated method stub
		return null;
	}



	



	


}

