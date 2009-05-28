package de.fraunhofer.fit.photocompass.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import de.fraunhofer.fit.photocompass.PhotoCompassApplication;

public class PhotoBorderView extends View {

	private int _width = 0;
	private int _height = 0;
	private Paint _paint;
	
	private boolean _minimized = false;
	
	public PhotoBorderView(Context context) {
		super(context);
		_paint = new Paint();
		_paint.setColor(Color.parseColor(PhotoCompassApplication.ORANGE)); 
		_paint.setStrokeWidth(2f);
	}
	
//	public void setDistance(float distance) {
//		_paint.setAlpha(distance);
//	}
	
    @Override 
    protected void onDraw(Canvas canvas) {
    	canvas.drawLine(0, 0, _width, 0, _paint); 
    	canvas.drawLine(_width, 0, _width, _height, _paint); 
    	canvas.drawLine(_width, _height, 0, _height, _paint); 
    	canvas.drawLine(0, _height, 0, 0, _paint); 
    }
    
    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
		_width = params.width;
		_height = params.height;
        super.setLayoutParams(params);
    }
	
	public void setMinimized(boolean value) {
		_minimized = value;
	}
	
	public boolean isMinimized() {
		return _minimized;
	}
}
