package com.app.mticalc;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.Handler;

public class CustomLocationListener extends Activity implements LocationListener {

	private Context m_context;
	private int m_interval = 3000; // 3 seconds by default, can be changed later
	private Handler m_handler;
	private Runnable m_statusChecker;
	

    public CustomLocationListener(Context context) {
        m_context = context;
    }
	@Override
	public void onLocationChanged(Location loc) {
		// TODO Auto-generated method stub
		
		}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

}
