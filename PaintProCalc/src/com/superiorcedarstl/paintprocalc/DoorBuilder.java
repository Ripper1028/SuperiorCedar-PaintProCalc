package com.superiorcedarstl.paintprocalc;

public class DoorBuilder {
	
	private Door door;
	private DoorCasing doorCasing;
	private DoorTrim doorTrim;
	
	public DoorBuilder(double width, double height, double trim, double casing) {
		door = new Door(width, height);
		if (trim > 0) {
			doorTrim = new DoorTrim(width, height, trim);
			door.setTrim(doorTrim);
		}
		if (casing > 0) {
			doorCasing = new DoorCasing(width, height, casing);
			door.setCasing(doorCasing);
		}
	}

}
