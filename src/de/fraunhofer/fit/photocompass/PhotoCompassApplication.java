package de.fraunhofer.fit.photocompass;

import android.app.Application;
import android.graphics.Color;
import de.fraunhofer.fit.photocompass.model.ApplicationModel;
import de.fraunhofer.fit.photocompass.model.Photos;

public class PhotoCompassApplication extends Application {
	
	// tag for logging
    public static final String LOG_TAG = "PhotoCompass";
    
    // activity constants
    public static final int FINDER_ACTIVITY = 1;
    public static final int MAP_ACTIVITY = 2;
    
    // colors
    public static final String ORANGE = "#ffd300";
    
    public PhotoCompassApplication() {
    	super();
    	
    	// initialize models
    	ApplicationModel.getInstance();
    	Photos.getInstance();
    }
    
    // returns the activity constant for a roll value from the orientation sensor
    public static int getActivityForRoll(float roll) {
    	if ((roll > -135 && roll < -45) || (roll > 45 && roll < 135)) {
    		return FINDER_ACTIVITY;
    	} else {
    		return MAP_ACTIVITY;
    	}
    }
}
