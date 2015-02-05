package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

public class DoorCasing implements Paintable {

	private static final String JSON_SIZE = "size";
	private static final String JSON_NAME = "name";
	private static final String JSON_WIDTH = "width";
	private static final String JSON_HEIGHT = "height";
	private static final String JSON_DEPTH = "depth";
	

	private static final String NAME = "window casing";
	private double size = 0;
	private boolean isPaintable;
	private double width, height, depth;
	
	public DoorCasing(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.size = (width + (height * 2)) * (depth + 1);
		isPaintable = true;
	}
	
	public DoorCasing(JSONObject json) throws JSONException {
		width = json.getDouble(JSON_WIDTH);
		height = json.getDouble(JSON_HEIGHT);
		depth = json.getDouble(JSON_DEPTH);
		size = json.getDouble(JSON_SIZE);
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
	
	public void setDepth(double d) {
		this.depth = d;
	}
	
	public double getDepth() {
		return depth;
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
		json.put(JSON_DEPTH, getDepth());
		json.put(JSON_SIZE, getSize());		
		return json;
	}
	
	
	public String toString() {
		return NAME;
	}

}
