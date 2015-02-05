package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * Chair molding is the small strip of molding that is found normally in a room with tables
 * and chairs(Duh) and is about a third of the way up the wall. It is meant to save the walls
 * from the chairs scaring the plaster/sheet rock                                             */

public class ChairMolding implements Paintable {

	private static final String JSON_SIZE = "size";
	private static final String JSON_NAME = "name";
	private static final String JSON_WIDTH = "width";
	private static final String JSON_TRIM = "trimSize";
	

	private static final String NAME = "chair molding";
	private double size = 0;
	private boolean isPaintable;
	private double width, trimSize;
	
	
	public ChairMolding(double width, double trimSize) {
		this.width = width;
		this.trimSize = trimSize;
		this.size = this.width * trimSize;
		isPaintable = true;
	}
	
	
	public ChairMolding(JSONObject json) throws JSONException {
		width = json.getDouble(JSON_WIDTH);
		trimSize = json.getDouble(JSON_TRIM);
		size = json.getDouble(JSON_SIZE);
		isPaintable = true;
	}
	
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
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
		json.put(JSON_TRIM, getTrimSize());
		json.put(JSON_SIZE, getSize());		
		return json;
	}
	
	
	public String toString() {
		return NAME;
	}

}
