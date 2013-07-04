package com.example.tilt;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity
{   
	private static myCamera cam = new myCamera();
	private int lightFlag = 0;
	
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
//
//        SensorManager sensorManager = (SensorManager) this.getSystemService(SENSOR_SERVICE);        
//
//        final SensorEventListener mEventListener = new SensorEventListener() {
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//            }
//
//            public void onSensorChanged(SensorEvent event) {
//                switch (event.sensor.getType()) {
//                	case Sensor.TYPE_ACCELEROMETER:
//                		Random rnd = new Random(); 
//                		int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//                		getWindow().getDecorView().setBackgroundColor(color);
//                        break;
//
//                    case Sensor.TYPE_MAGNETIC_FIELD:
//                        break;
//                }
//            };
//        };
//        setListners(sensorManager, mEventListener); 
        
        Button mButtton = (Button)findViewById(R.id.buton);
//		mButtton.setOnTouchListener(new View.OnTouchListener() {
//			@Override			
//		    public boolean onTouch(View v, MotionEvent event) {
//				if(event.getAction() == MotionEvent.ACTION_DOWN) {
//					cam.flashLightOn(v);
//				}
//				if(event.getAction() == MotionEvent.ACTION_UP){
//					cam.flashLightOff(v);
//	            }
//	            return true;
//		    }
//		});
		
        mButtton.setOnClickListener(new View.OnClickListener() {
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
	
    
    // Register the event listener and sensor type.
//    public void setListners(SensorManager sensorManager, SensorEventListener mEventListener)
//    {
//        sensorManager.registerListener(mEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 
//                SensorManager.SENSOR_DELAY_NORMAL);
//        sensorManager.registerListener(mEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 
//                SensorManager.SENSOR_DELAY_NORMAL);
//    }
}






































//package com.example.tilt;
//
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.os.Bundle;
//import android.app.Activity;
//import android.content.Context;
//import android.view.Menu;
//import android.widget.TextView;
//
//public class MainActivity extends Activity {
//
//	private SensorManager mSensorManager;
//	private Sensor mOrientation;
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//		mSensorManager = registerListener(mEventListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
//		mOrientation = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
//
//	}
//	final SensorEventListener mEventListener = new SensorEventListener() {
//		
//		@Override
//		public void onSensorChanged(SensorEvent event) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void onAccuracyChanged(Sensor sensor, int accuracy) {
//			// TODO Auto-generated method stub
//			TextView t = (TextView)findViewById(R.id.tv);
//			double x = (double) (Math.random()*85);
//			t.setText("" + x);
//			
//		}
//	};
//
////	  @Override
////	  protected void onResume() {
////	    super.onResume();
////	    mSensorManager.registerListener(this, mOrientation, SensorManager.SENSOR_DELAY_NORMAL);
////	  }
////
////	  @Override
////	  protected void onPause() {
////	    super.onPause();
////	    mSensorManager.unregisterListener(this);
////	  }
//
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//}
