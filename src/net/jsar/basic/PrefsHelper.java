package net.jsar.basic;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PrefsHelper
{

	public static final String NAME_PREFERENCES = "CreeperCounterPreferences";
	public static final String NAME_CONFIG = "CreeperCounterConfig";
	
	
  public static final String state_1 = "state_1";
  public static final String state_2 = "state_2";
    
  public static String getState1(Context paramContext) {
    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_1, "0");
  }

  public static void setState1(Context paramContext, String paramString) {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
    localEditor.putString(state_1, paramString);
    localEditor.commit();
  }

  public static String getState2(Context paramContext) {
	    return paramContext.getSharedPreferences(NAME_PREFERENCES, 0).getString(state_2, "0");
	  }

	  public static void setState2(Context paramContext, String paramString) {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(NAME_PREFERENCES, 0).edit();
	    localEditor.putString(state_2, paramString);
	    localEditor.commit();
	  }

	public static void reset(Context context) {
    	Editor editor = context.getSharedPreferences(NAME_PREFERENCES, Context.MODE_PRIVATE).edit();
    	editor.clear();
    	editor.commit();

	}
  
}