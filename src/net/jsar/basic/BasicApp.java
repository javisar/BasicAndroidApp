package net.jsar.basic;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


public class BasicApp extends Activity {
	
    private String state_1 = "";
    private String state_2 = "";
	
	@Override
    protected void onDestroy() {
        super.onDestroy();
	}
	
	@Override
    protected void onCreate(Bundle pSavedInstanceState) {
        super.onCreate(pSavedInstanceState);
        setContentView(R.layout.basic_activity);        
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);   
        
        loadPreferences();
        loadUI();
    }
 
	protected void loadUI() {    
		
        ((Button)findViewById(R.id.state_1)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
            state_1 = ""+(Integer.parseInt(state_1)+1);
            savePreferences();
        	updateUI();
          }
        });
        ((Button)findViewById(R.id.state_2)).setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            
        	state_2 = ""+(Integer.parseInt(state_2)-1);        	
        	savePreferences();
        	updateUI();
          }
        });
        
        updateUI();
	}


    public void onBackPressed()
    {
    	closeApplication();
    }


    private void closeApplication() {
    	AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
        localBuilder.setTitle("Salir");
        localBuilder.setMessage("¿Esta seguro que desea salir?");
        localBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
              System.runFinalizersOnExit(true);
              System.exit(0);
          }
        });
        localBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
          }
        });
        localBuilder.show();
	}

	public boolean onCreateOptionsMenu(Menu paramMenu)
    {
      getMenuInflater().inflate(R.menu.menu_options, paramMenu);
      return true;
    }
    

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {   
      int i = paramMenuItem.getItemId();
      if (i == R.id.reset)
      {
        state_1 = "0";
        state_2 = "0";
        
        savePreferences();
    	updateUI();
        return true;
      }
      else if (i == R.id.exit)
      {
    	//dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_BACK));
    	closeApplication();
        return true;
      }
      else if (i == R.id.clear_preferences)
      {
    	  
    	PrefsHelper.reset(this);
    	savePreferences();
    	return true;
      }
      else if (i == R.id.open_preferences)
      {
    	  Intent it = new Intent((String)null, (Uri)null, this, SettingsActivity.class);
      	  this.startActivity(it);
      	  return true;
      }
      
      return super.onOptionsItemSelected(paramMenuItem);
    }

       
    public void updateUI()
    {     
     
      ((Button)findViewById(R.id.state_1)).setText(""+state_1);
      ((Button)findViewById(R.id.state_2)).setText(""+state_2);
    }
	
    
    protected void loadPreferences() {   	 
        state_1 = PrefsHelper.getState1(this);
        state_2 = PrefsHelper.getState2(this);
    }
    
    protected void savePreferences() {
    	 PrefsHelper.setState1(this, state_1);
         PrefsHelper.setState2(this, state_2);
    }
}
