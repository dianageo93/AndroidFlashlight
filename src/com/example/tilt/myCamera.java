package com.example.tilt;

import java.util.Random;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.*;
import android.hardware.Camera;
import android.graphics.Color;
import android.hardware.Camera.Parameters;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class myCamera {
	public static Camera cam = null; // has to be static, otherwise onDestroy() destroys it
	
	public void flashLightOn(View view) {

	    try {
	        /*if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))*/ {
	            cam = Camera.open();
	            Parameters p = cam.getParameters();
	            p.setFlashMode(Parameters.FLASH_MODE_TORCH);
	            cam.setParameters(p);
	            cam.startPreview();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
//	        Toast.makeText(getBaseContext(), "Exception flashLightOn()",
//	                Toast.LENGTH_SHORT).show();
	    }
	}


	public void flashLightOff(View view) {
	    try {
	        /*if (getPackageManager().hasSystemFeature(
	                PackageManager.FEATURE_CAMERA_FLASH))*/ {
	            cam.stopPreview();
	            cam.release();
	            cam = null;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
//	        Toast.makeText(getBaseContext(), "Exception flashLightOff",
//	                Toast.LENGTH_SHORT).show();
	    }
	}
	}
