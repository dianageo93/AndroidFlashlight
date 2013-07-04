package com.example.tilt;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.View;

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
	    }
	}
	}
