package com.superiorcedarstl.paintprocalc;

public class WindowBuilder {
	
	private Window window;
	private WindowTrim windowTrim;
	private WindowCasing windowCasing;

	
	
	public Window buildWindow(double width, double height,
			double trim, double casing) {
		window = new Window(width, height);
		
		if (trim > 0) {
			windowTrim = new WindowTrim(width, height, trim);
			window.setTrim(windowTrim);
		}
		
		if (casing > 0) {
			windowCasing = new WindowCasing(width, height, casing);
			window.setCasing(windowCasing);
		}
		
		return window;
	}

	

}
