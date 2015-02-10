package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

public class Door implements Paintable {
	
	private static final String JSON_SIZE = "size";
	private static final String JSON_NAME = "name";
	private static final String JSON_WIDTH = "width";
	private static final String JSON_HEIGHT = "height";
	private static final String JSON_CASING = "casing";
	private static final String JSON_TRIM = "trim";
	

	private static final String NAME = "door";
	private double size = 0;
	private boolean isPaintable;
	private double width, height;
	private DoorCasing casing;
	private DoorTrim trim;
	
	
	public Door(double width, double height) {
		this.width = width;
		this.height = height;
		this.size = width * height;
		isPaintable = true;
	}
	
	public Door(JSONObject json) throws JSONException {
		width = json.getDouble(JSON_WIDTH);
		height = json.getDouble(JSON_HEIGHT);
		size = json.getDouble(JSON_SIZE);
		if (json.has(JSON_CASING)) {
			casing = new DoorCasing(json.getJSONObject(JSON_CASING));
		}
		if (json.has(JSON_TRIM)) {
			trim = new DoorTrim(json.getJSONObject(JSON_TRIM));
		}
	}
	
	public void setCasing(DoorCasing casing) {
		this.casing = casing;
	}
	
	public DoorCasing getCasing() {
		return casing;
	}

	public void setTrim(DoorTrim trim) {
		this.trim = trim;
	}
	
	public DoorTrim getTrim() {
		return trim;
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
		if (casing != null) {
			json.put(JSON_CASING, casing.toJSON());
		}
		if (trim != null) {
			json.put(JSON_TRIM, trim.toJSON());
		}
		return json;
	}
	
	public String toString() {
		return NAME;
	}


}
