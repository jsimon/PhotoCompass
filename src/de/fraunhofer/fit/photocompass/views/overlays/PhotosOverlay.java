package de.fraunhofer.fit.photocompass.views.overlays;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

import de.fraunhofer.fit.photocompass.PhotoCompassApplication;
import de.fraunhofer.fit.photocompass.model.Photos;
import de.fraunhofer.fit.photocompass.model.data.Photo;

public final class PhotosOverlay extends ItemizedOverlay<OverlayItem> {

	private ArrayList<OverlayItem> _items = new ArrayList<OverlayItem>();
	
	private ArrayList<Integer> _photos = new ArrayList<Integer>(); // resourceIds of the currently used photos
	   															   // sorted from farthest to nearest

    private Photos _photosModel;
	
	public PhotosOverlay() {
        super(null);
        
        _photosModel = Photos.getInstance();
	}
	
	public void addPhotos(final ArrayList<Integer> newPhotos, final boolean doRedraw) {
        Log.d(PhotoCompassApplication.LOG_TAG, "PhotosOverlay: addPhotos");
		
	}
	
	public void removePhotos(final ArrayList<Integer> oldPhotos, final boolean doRedraw) {
        Log.d(PhotoCompassApplication.LOG_TAG, "PhotosOverlay: removePhotos");
		
	}

	/**
	 * @return The photos currently used by the overlay.
	 */
	public ArrayList<Integer> getPhotos() {
		return _photos;
	}
	
	public void updatePositions(final boolean doRedraw) {
        Log.d(PhotoCompassApplication.LOG_TAG, "PhotosOverlay: updatePositions");
		
	}
	
//	public void addOverlay(final OverlayItem overlay) {
//		_items.add(overlay);
//	    populate();
//	}

    @Override
    public void draw(final Canvas canvas, final MapView mapView, final boolean shadow) {
    	super.draw(canvas, mapView, shadow);

		Projection projection = mapView.getProjection();
		GeoPoint photoLocation;
		Point point = new Point();
		Bitmap bitmap;
		for (int resourceId : _photos) {

			Photo photo = _photosModel.getPhoto(resourceId);
			
			photoLocation = new GeoPoint((int)(photo.getLat() * 1E6), (int)(photo.getLng() * 1E6));
			projection.toPixels(photoLocation, point);

            bitmap = BitmapFactory.decodeResource(mapView.getResources(), resourceId);
            canvas.drawBitmap(bitmap, point.x - bitmap.getWidth() / 2, point.y - bitmap.getHeight() * 2/3, new Paint());
            bitmap.recycle();
        }
    }
	
	@Override
	protected OverlayItem createItem(final int i) {
		return _items.get(i);
	}
	
	@Override
	public int size() {
		return _items.size();
	}
}
