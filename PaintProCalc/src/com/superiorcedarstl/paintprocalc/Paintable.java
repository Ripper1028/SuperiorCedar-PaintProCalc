package com.superiorcedarstl.paintprocalc;

import org.json.JSONException;
import org.json.JSONObject;

public interface Paintable {
	
	
	public String getName();
	
	public double getSize();
	
	public boolean isPaintable();
	
	public JSONObject toJSON() throws JSONException;
	
	public String toString();

}
