package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

public class WindowTrim implements Paintable {

	private static final String JSON_SIZE = "size";
	private static final String JSON_ISPAINTABLE = "isPaintable";
	private static final String JSON_NAME = "name";
	private static final String JSON_WIDTH = "width";
	private static final String JSON_HEIGHT = "height";
	private static final String JSON_TRIM = "trimSize";
	

	private static final String NAME = "window trim";
	private double size = 0;
	private boolean isPaintable;
	private double width, height, trimSize;
	
	public WindowTrim(double width, double height, double trimSize) {
		this.width = width + trimSize + .25;
		this.height = height + trimSize + .25;
		this.trimSize = trimSize;
		setSize(this.width, this.height, this.trimSize);		
		isPaintable = true;
	}
	
	
	public WindowTrim(JSONObject json) throws JSONException {
		width = json.getDouble(JSON_WIDTH);
		height = json.getDouble(JSON_HEIGHT);
		trimSize = json.getDouble(JSON_TRIM);
		size = json.getDouble(JSON_SIZE);
		isPaintable = json.getBoolean(JSON_ISPAINTABLE);
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public String getName() {
		return NAME;
	}

	private void setSize(double width2, double height2, double trimSize2) {
		this.size = ((width + height) * 2) * trimSize;		
	}

	@Override
	public double getSize() {
		return size;
	}
	
	public void setDepth(double d) {
		this.trimSize = d;
	}
	
	public double getTrimSize() {
		return trimSize;
	}

	@Override
	public boolean isPaintable() {
		return isPaintable;
	}
	
	public void setIsPaintable(boolean b) {
		isPaintable = b;
	}

	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_NAME, getName());
		json.put(JSON_WIDTH, getWidth());
		json.put(JSON_HEIGHT, getHeight());
		json.put(JSON_TRIM, getTrimSize());
		json.put(JSON_SIZE, getSize());		
		json.put(JSON_ISPAINTABLE, isPaintable());
		return json;
	}
	
	
	public String toString() {
		return NAME;
	}

}
