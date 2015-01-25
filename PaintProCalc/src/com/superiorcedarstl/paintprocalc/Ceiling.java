package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

public class Ceiling implements Paintable {

	private static final String JSON_SIZE = "size";
	private static final String JSON_ISPAINTABLE = "isPaintable";
	private static final String JSON_NAME = "name";
	

	private static final String NAME = "ceiling";
	private double size = 0;
	private boolean isPaintable;
	
	public Ceiling(double s) {
		this.size = s;
		isPaintable = true;
	}
	
	public Ceiling(JSONObject json) throws JSONException {
		size = json.getDouble(JSON_SIZE);
		isPaintable = json.getBoolean(JSON_ISPAINTABLE);
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
		json.put(JSON_SIZE, getSize());		
		json.put(JSON_ISPAINTABLE, isPaintable());
		return json;
	}
	
	public String toString() {
		return NAME;
	}

}
