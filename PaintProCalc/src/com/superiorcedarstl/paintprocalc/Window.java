package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * The window is holds both the casing and the trim. The casing is the piece that fills in the 
 * gap from window unit out to the trim, and of course the trim is the trim around the unit on the wall.*/

public class Window implements Paintable {

	private static final String JSON_SIZE = "size";
	private static final String JSON_NAME = "name";
	private static final String JSON_WIDTH = "width";
	private static final String JSON_HEIGHT = "height";
	private static final String JSON_CASING = "casing";
	private static final String JSON_TRIM = "trim";
	

	private static final String NAME = "window";
	private double size = 0;
	private boolean isPaintable;
	private double width, height;
	private WindowCasing casing;
	private WindowTrim trim;
	
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
		if (json.has(JSON_CASING)) {
			casing = new WindowCasing(json.getJSONObject(JSON_CASING));
		}
		if (json.has(JSON_TRIM)) {
			trim = new WindowTrim(json.getJSONObject(JSON_TRIM));
		}
	}
	
	public WindowCasing getCasing() {
		return casing;
	}

	public void setCasing(WindowCasing casing) {
		this.casing = casing;
	}

	public WindowTrim getTrim() {
		return trim;
	}

	public void setTrim(WindowTrim trim) {
		this.trim = trim;
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
		if (trim != null) {
			json.put(JSON_TRIM, trim.toJSON());
		}
		if (casing != null) {
			json.put(JSON_CASING, casing.toJSON());
		}
		return json;
	}
	
	public String toString() {
		return NAME;
	}


}
