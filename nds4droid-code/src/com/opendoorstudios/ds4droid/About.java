package com.opendoorstudios.ds4droid;

import android.app.Activity;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class About extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.about);
		
		final TextView textVersion = (TextView)findViewById(R.id.about_versionstring);
		
		final StringBuilder build = new StringBuilder();
		
		String family, library;
		
		DeSmuME.load();
		
		switch(DeSmuME.getCPUFamily()) {
		case 1: family = "ARM"; break;
		case 2: family = "x86"; break;
		default: family = "unknown"; break;
		}
		
		switch(DeSmuME.getCPUType()) {
		case DeSmuME.CPUTYPE_COMPAT: library = "compat"; break;
		case DeSmuME.CPUTYPE_V7: library = "v7"; break;
		case DeSmuME.CPUTYPE_NEON: library = "neon"; break;
		default: library = "unknown";
		}
		
		int version = 0;
		try {
			version = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		build.append(getString(R.string.app_name)).append(" ").append(version).append(
						" ").append(family).append("/").append(library);
		
		textVersion.setText(build.toString());
	}

}
