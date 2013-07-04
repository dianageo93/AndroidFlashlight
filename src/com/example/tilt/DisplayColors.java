package com.example.tilt;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class DisplayColors extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lights);
        RelativeLayout display = (RelativeLayout)findViewById(R.id.relative_layoutDisplayColors);
        display.setOnTouchListener(new View.OnTouchListener() {  
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                //gesture detector to detect swipe
            	Intent intent = new Intent();
            	setResult(Activity.RESULT_OK, intent);
                finish();
                return true; //always return true to consume event
            }
        });
        
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
	    SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);        
	    final SensorEventListener mEventListener = new SensorEventListener() {
	        public void onAccuracyChanged(Sensor sensor, int accuracy) {
	        }
	
	        public void onSensorChanged(SensorEvent event) {
	            switch (event.sensor.getType()) {
	            	case Sensor.TYPE_ACCELEROMETER:
	            		Random rnd = new Random(); 
	            		int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
	            		getWindow().getDecorView().setBackgroundColor(color);
	                    break;
	
	                case Sensor.TYPE_MAGNETIC_FIELD:
	                    break;
	            }
	        };
	    };
	    setListners(sensorManager, mEventListener); 
        
    }
	
     //Register the event listener and sensor type.
	  public void setListners(SensorManager sensorManager, SensorEventListener mEventListener)
	  {
	      sensorManager.registerListener(mEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
	              SensorManager.SENSOR_DELAY_NORMAL);
	      sensorManager.registerListener(mEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
	              SensorManager.SENSOR_DELAY_NORMAL);
	  }
	
}