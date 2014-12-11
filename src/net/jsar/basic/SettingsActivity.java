package net.jsar.basic;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SettingsActivity extends PreferenceActivity {

	//private Preference chkMergePending;
  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		addPreferencesFromResource(R.xml.preferences);
		
		/*
	    this.chkMergePending = findPreference("setting_merge_pending");		
	    this.chkMergePending.setDefaultValue(PrefsHelper.getMergePending(this));
	    this.chkMergePending.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener()
	    {
			@Override
			public boolean onPreferenceChange(Preference pref, Object newValue) {
				PrefsHelper.setMergePending(SettingsActivity.this, (Boolean) newValue);
				return true;
			}	     
	      });
	    
	    Preference chooseServers = (Preference)findPreference("settings_servers");
	    chooseServers.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {			
			@Override
			public boolean onPreferenceClick(Preference arg0) {
				Intent it = new Intent((String)null, (Uri)null, SettingsActivity.this, ServerActivity.class);
				SettingsActivity.this.startActivity(it);
				return true;
			}
		});
	    */
	}
	
}
