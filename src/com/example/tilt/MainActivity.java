package com.example.tilt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity
{   
	private static myCamera cam = new myCamera();
	private int lightFlag = 0;
	private final int INTENT_REQUEST = 1;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        
        

        final Context context = this;
        Button mButton2 = (Button)findViewById(R.id.buton2);
        mButton2.setOnClickListener(new Button.OnClickListener() {
		    public void onClick(View v) {
		        Intent data = new Intent(context,DisplayColors.class) ;
		        startActivityForResult(data,INTENT_REQUEST);
		    }
		});
		
        Button mButton = (Button)findViewById(R.id.buton);
        mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(lightFlag == 0) {
					cam.flashLightOn(v);
					lightFlag = 1;
				}
				else if(lightFlag == 1){
					cam.flashLightOff(v);
					lightFlag = 0;
	            }
			}
		});
        
        
    }
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
	    // See which child activity is calling us back.
	    switch (requestCode) {
	        case INTENT_REQUEST:
	            if (resultCode == Activity.RESULT_OK){
	                Log.d("MAIN ACTIVITY","am revenit");
	                Toast.makeText(this, "back to life", Toast.LENGTH_SHORT).show();
	            } 
	            break;
	        default:
	            break;
	    }
	}
}