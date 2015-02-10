package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

/*
 *  The wall makes up the room, and the dimensions of the room will be used to calculate the ceiling. 
 *  The wall holds the baseboard, chair molding and crown molding because they will be directly 
 *  reflected with the wall length.                                                                  */

public class Wall implements Paintable {
	
	private static final String JSON_SIZE = "size";
	private static final String JSON_NAME = "name";
	private static final String JSON_LENGTH = "length";
	private static final String JSON_HEIGHT = "height";
	private static final String JSON_BASE = "base";
	private static final String JSON_CHAIR = "chair";
	private static final String JSON_CROWN = "crowm";
	

	private static final String NAME = "wall";
	private double size = 0;
	private boolean isPaintable;
	private double length, height;
	private BaseBoard baseBoard;
	private ChairMolding chairMolding;
	private CrownMolding crownMolding;
	
	
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
		if (json.has(JSON_BASE)) {
			baseBoard = new BaseBoard(json.getJSONObject(JSON_BASE));
		}
		if (json.has(JSON_CHAIR)) {
			chairMolding = new ChairMolding(json.getJSONObject(JSON_CHAIR));
		}
		if (json.has(JSON_CROWN)) {
			crownMolding = new CrownMolding(json.getJSONObject(JSON_CROWN));
		}
		isPaintable = true;
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
		if (baseBoard != null) {
			json.put(JSON_BASE, baseBoard.toJSON());
		}
		if (chairMolding != null) {
			json.put(JSON_CHAIR, chairMolding.toJSON());
		}
		if (crownMolding != null) {
			json.put(JSON_CROWN, crownMolding.toJSON());
		}
		return json;
	}
	
	public BaseBoard getBaseBoard() {
		return baseBoard;
	}

	public void setBaseBoard(BaseBoard baseBoard) {
		this.baseBoard = baseBoard;
	}

	public ChairMolding getChairMolding() {
		return chairMolding;
	}

	public void setChairMolding(ChairMolding chairMolding) {
		this.chairMolding = chairMolding;
	}

	public CrownMolding getCrownMolding() {
		return crownMolding;
	}

	public void setCrownMolding(CrownMolding crownMolding) {
		this.crownMolding = crownMolding;
	}

	public String toString() {
		return NAME;
	}

}
