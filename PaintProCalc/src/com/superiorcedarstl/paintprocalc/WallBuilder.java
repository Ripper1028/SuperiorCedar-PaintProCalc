package com.superiorcedarstl.paintprocalc;

public class WallBuilder {
	
	private Wall wall;
	private BaseBoard baseBoard;
	private ChairMolding chairMolding;
	private CrownMolding crownMolding;
	
	public Wall buildWall(double length, double height, double base, double chair, double crown) {
		wall = new Wall(length, height);
		if (base > 0) {
			baseBoard = new BaseBoard(length, base);
			wall.setBaseBoard(baseBoard);
		}
		if (chair > 0) {
			chairMolding = new ChairMolding(length, chair);
			wall.setChairMolding(chairMolding);
		}
		if (crown > 0) {
			crownMolding = new CrownMolding(length, crown);
			wall.setCrownMolding(crownMolding);
		}		
		
		return wall;
	}

}
