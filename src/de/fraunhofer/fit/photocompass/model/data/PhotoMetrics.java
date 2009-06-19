package de.fraunhofer.fit.photocompass.model.data;

import de.fraunhofer.fit.photocompass.views.layouts.SimpleAbsoluteLayout;
import de.fraunhofer.fit.photocompass.views.layouts.SimpleAbsoluteLayout.LayoutParams;

/**
 * This class is a custom data type for photo metrics.
 * It is used by views to store the current position and dimension of photo related views.
 */
public final class PhotoMetrics {

	public static final int MINIMIZED_PHOTO_HEIGHT = 30; // height of a minimized photo in the PhotosView 
	public static final int MAPS_MINIMIZED_PHOTO_HEIGHT = 20; // height of a minimized photo in the PhotosOverlay
	
	private int _x;
	private int _y = 0;
	private int _width = 0;
	private int _height = 0;
	private LayoutParams _layoutParams; // layout parameters for SimpleAbsoluteLayout
	private LayoutParams _minimizedLayoutParams; // layout parameters for SimpleAbsoluteLayout

	/**
	 * @param left Left position.
	 */
	public void setLeft(final int left) {
		_x = left;
		_setLayoutParams();
		_setMinimizedLayoutParams();
	}

	/**
	 * @return Left position.
	 */
	public int getLeft() {
		return _x;
	}

	/**
	 * @param top Top position.
	 */
	public void setTop(final int top) {
		_y = top;
		_setLayoutParams();
	}

	/**
	 * @return Top position.
	 */
	public int getTop() {
		return _y;
	}

	/**
	 * @param width
	 */
	public void setWidth(final int width) {
		_width = width;
		_setLayoutParams();
		_setMinimizedLayoutParams();
	}

	/**
	 * @return Width
	 */
	public int getWidth() {
		return _width;
	}

	/**
	 * @param height
	 */
	public void setHeight(final int height) {
		_height = height;
		_setLayoutParams();
	}

	/**
	 * @return Height
	 */
	public int getHeight() {
		return _height;
	}

	/**
	 * @return Right position.
	 */
	public int getRight() {
		return _x + _width;
	}

	/**
	 * @return Bottom position.
	 */
	public int getBottom() {
		return _y + _height;
	}
	
	private void _setLayoutParams() {
		_layoutParams = new LayoutParams(_width, _height, _x, _y);
	}
	
	/**
	 * @return {@link LayoutParams} for an {@link SimpleAbsoluteLayout}.
	 */
	public LayoutParams getLayoutParams() {
		return _layoutParams;
	}
	
	private void _setMinimizedLayoutParams() {
    	// minimized photos are displayed with unchanged width and MINIMIZED_PHOTO_HEIGHT
		_minimizedLayoutParams = new LayoutParams(_width, MINIMIZED_PHOTO_HEIGHT, _x, 0);
	}

	/**
	 * @param availableHeight Height at which bottom the minimized photos should be displayed.
	 * @return {@link LayoutParams} for an {@link SimpleAbsoluteLayout} for a photo in minimized state.
	 */
	public LayoutParams getMinimizedLayoutParams(final int availableHeight) {
		_minimizedLayoutParams.y = availableHeight - MINIMIZED_PHOTO_HEIGHT;
		return _minimizedLayoutParams;
	}
}
