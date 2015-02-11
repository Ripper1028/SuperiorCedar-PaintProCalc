package com.superiorcedarstl.paintprocalc;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Room implements Paintable {
	
	private static final String JSON_WALLS = "walls";
	private static final String JSON_DOORS = "doors";
	private static final String JSON_INNERWALLS = "innerWalls";
	private static final String JSON_WINDOWS = "windows";
	private static final String JSON_CEILING = "ceiling";
	private static final String JSON_NAME = "name";
	private static final String JSON_TOTALTRIM = "totalTrim";
	private static final String JSON_TOTALWALL = "totalWall";
	
	private Window window;
	private ArrayList<Paintable> walls;
	private ArrayList<Paintable> innerWalls;
	private ArrayList<Paintable> doors;
	private ArrayList<Paintable> windows;
	private Ceiling ceiling;
	private String name;
	private boolean isPaintable;
	private double size;
	private double perimeter;
	private double totalTrim;
	private double totalWall;
	
	public Room(String name) {
		this.name = name;
		walls = new ArrayList<Paintable>();
		innerWalls = new ArrayList<Paintable>();
		doors = new ArrayList<Paintable>();
		windows = new ArrayList<Paintable>();
	}
	
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getSize() {
		return size;
	}

	public void setIsPaintable(boolean b) {
		isPaintable = b;
	}
	@Override
	public boolean isPaintable() {
		return isPaintable;
	}
	
	public Room(JSONObject json) throws JSONException {
		this.name = json.getString(JSON_NAME);
		walls = new ArrayList<Paintable>();
		innerWalls = new ArrayList<Paintable>();
		doors = new ArrayList<Paintable>();
		windows = new ArrayList<Paintable>();
		getWindows(json.getJSONArray(JSON_WINDOWS));
	}

	private void getWindows(JSONArray jsonArray) throws JSONException {
		
		for (int i = 0; i < jsonArray.length(); i++) {
			window = new Window(jsonArray.getJSONObject(i));
		}
		addWindow(window);
		
	}


	@Override
	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_NAME, name);
		json.put(JSON_CEILING, ceiling);
		json.put(JSON_DOORS, paintableJSON(doors));
		json.put(JSON_INNERWALLS, paintableJSON(innerWalls));
		json.put(JSON_WALLS, paintableJSON(walls));
		json.put(JSON_TOTALTRIM, totalTrim);
		json.put(JSON_TOTALWALL, totalWall);
		json.put(JSON_WINDOWS, paintableJSON(windows));
		return json;
	}
	
	private JSONArray paintableJSON(ArrayList<Paintable> array) throws JSONException {
		JSONArray jsonArray = new JSONArray();
		for (Paintable p : array) {
			p.toJSON();
			jsonArray.put(p);
		}
		return jsonArray;
	}
		
	public ArrayList<Paintable> getWalls() {
		return walls;
	}

	public void addWall(Paintable wall) {
		this.walls.add(wall);
	}

	public ArrayList<Paintable> getInnerWalls() {
		return innerWalls;
	}

	public void addInnerWall(Paintable innerWall) {
		this.innerWalls.add(innerWall);
	}

	public ArrayList<Paintable> getDoors() {		
		return doors;
	}

	public void addDoor(Paintable door) {		
		this.doors.add(door);
	}

	public ArrayList<Paintable> getWindows() {
		return windows;
	}

	public void addWindow(Paintable window) {
		this.windows.add(window);
	}

	public Ceiling getCeiling() {
		return ceiling;
	}

	public void setCeiling(Ceiling ceiling) {
		this.ceiling = ceiling;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void addPerimeter(double perimeter) {
		this.perimeter += perimeter;
	}

	public double getTotalTrim() {
		return totalTrim;
	}

	public void addTotalTrim(double totalTrim) {
		this.totalTrim += totalTrim;
	}

	public double getTotalWall() {
		return totalWall;
	}

	public void addTotalWall(double sqInch) {
		this.totalWall += sqInch;
	}
	
	public void minusTotalWall(double sqInch) {
		this.totalWall -= sqInch;
	}

	public void setPaintable(boolean isPaintable) {
		this.isPaintable = isPaintable;
	}

	public void setSize(double size) {
		this.size = size;
	}

}
