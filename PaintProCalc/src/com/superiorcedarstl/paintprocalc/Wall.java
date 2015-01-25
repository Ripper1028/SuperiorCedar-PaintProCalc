package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

public class Wall implements Paintable {
	
	private static final String JSON_SIZE = "size";
	private static final String JSON_ISPAINTABLE = "isPaintable";
	private static final String JSON_NAME = "name";
	private static final String JSON_LENGTH = "length";
	private static final String JSON_HEIGHT = "height";
	

	private static final String NAME = "wall";
	private double size = 0;
	private boolean isPaintable;
	private double length, height;
	
	public Wall(double length, double height) {
		this.length = length;
		this.height = height;
		this.size = length * height;
		isPaintable = true;
	}
	
	public Wall(JSONObject json) throws JSONException {
		length = json.getDouble(JSON_LENGTH);
		height = json.getDouble(JSON_HEIGHT);
		size = json.getDouble(JSON_SIZE);
		isPaintable = json.getBoolean(JSON_ISPAINTABLE);
	}
	
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
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
		json.put(JSON_LENGTH, getLength());
		json.put(JSON_HEIGHT, getHeight());
		json.put(JSON_SIZE, getSize());		
		json.put(JSON_ISPAINTABLE, isPaintable());
		return json;
	}
	
	public String toString() {
		return NAME;
	}

}
