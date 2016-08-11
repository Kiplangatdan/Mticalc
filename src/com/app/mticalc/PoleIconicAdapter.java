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
public class PoleIconicAdapter extends CursorAdapter {
    private static final double PI = 3.142;
    private static final double DIVISOR = 40000;

    @SuppressLint("NewApi")
	public PoleIconicAdapter(Context spinnerClass, Cursor cursor) {
        super(spinnerClass,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

	 return LayoutInflater.from(context).inflate(R.layout.listwith_pole_views,viewGroup,false);
        }

        @Override
		@SuppressWarnings("unused")
    	
        public void bindView(View view, Context context, Cursor cursor) {
            DecimalFormat format=new DecimalFormat("#0.0000");
       
           double Volume = (0.5*((PI * ((Double.parseDouble(cursor.getString(7))) *
        		   ( Double.parseDouble(cursor.getString(7)))))+
            		(PI * ((Double.parseDouble(cursor.getString(8))) *
            				( Double.parseDouble(cursor.getString(8))))))
            		/ DIVISOR)*Double.parseDouble(cursor.getString(6));
            
            TextView poletd,polebd,polelength,volume,poleno,plantName,treespecie,date,plotno;
            plantName=(TextView)view.findViewById(R.id.tv_poleplants_name);
            date=(TextView)view.findViewById(R.id.tv_poledate);
            treespecie=(TextView)view.findViewById(R.id.tv_pole_species);
            plotno=(TextView)view.findViewById(R.id.tv_poleplot_no);
            poleno=(TextView)view.findViewById(R.id.tv_pole_no);
            poletd=(TextView)view.findViewById(R.id.tv_pole_td);
            polebd=(TextView)view.findViewById(R.id.tv_pole_bd);
            polelength=(TextView)view.findViewById(R.id.tv_pole_length);
            volume=(TextView)view.findViewById(R.id.tv_pole_volume);
            plotno.setText(cursor.getString(0));
            plantName.setText(cursor.getString(2));
            date.setText(cursor.getString(3));
            treespecie.setText(cursor.getString(4));
            poleno.setText(cursor.getString(5));
            polelength.setText(cursor.getString(6));
            poletd.setText(cursor.getString(7));
            polebd.setText(cursor.getString(8));
            volume.setText(String.valueOf( format.format(Volume)));

    	
        	}
        }
 

	

