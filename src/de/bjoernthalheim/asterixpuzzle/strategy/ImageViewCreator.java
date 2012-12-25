package de.bjoernthalheim.asterixpuzzle.strategy;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewCreator {

	/**
	 * Factory Method.
	 * 
	 * @return {@link ImageView} which can be included.
	 */
	public ImageView createImageView() {
		ImageView product = new ImageView();
		// @formatter:off
		includeImageInImageView	(product);
		scaleImageView			(product);
		rotateImage				(product);
		// @formatter:on
		return product;
	}

	private String fileName;

	public ImageViewCreator setFileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	private double height;

	public ImageViewCreator setHeight(double height) {
		this.height = height;
		return this;
	}

	private boolean keepRatioWhenResizing = true;

	public ImageViewCreator setKeepRatioWhenResizing(boolean keepRatioWhenResizing) {
		this.keepRatioWhenResizing = keepRatioWhenResizing;
		return this;
	}
	
	private long rotation = 0;

	public ImageViewCreator setRotate(long rotation) {
		this.rotation = rotation;
		return this;
	}

	private ImageView includeImageInImageView(ImageView imageView) {
		Image image = new Image(fileName);
		imageView.setImage(image);
		return imageView;
	}

	private ImageView scaleImageView(ImageView image) {
		image.setFitHeight(height);
		image.setPreserveRatio(keepRatioWhenResizing);
		return image;
	}

	private ImageView rotateImage(ImageView image) {
		image.setRotate(this.rotation);
		return image;
	}
}
