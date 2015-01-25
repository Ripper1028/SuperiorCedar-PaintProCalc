package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

public class Window implements Paintable {

	private static final String JSON_SIZE = "size";
	private static final String JSON_ISPAINTABLE = "isPaintable";
	private static final String JSON_NAME = "name";
	private static final String JSON_WIDTH = "width";
	private static final String JSON_HEIGHT = "height";
	

	private static final String NAME = "window";
	private double size = 0;
	private boolean isPaintable;
	private double width, height;
	
	public Window(double width, double height) {
		this.width = width;
		this.height = height;
		this.size = width * height;
		isPaintable = true;
	}
	
	public Window(JSONObject json) throws JSONException {
		width = json.getDouble(JSON_WIDTH);
		height = json.getDouble(JSON_HEIGHT);
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

	@Override
	public double getSize() {
		return size;
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
		json.put(JSON_SIZE, getSize());		
		json.put(JSON_ISPAINTABLE, isPaintable());
		return json;
	}
	
	public String toString() {
		return NAME;
	}


}
