package com.Utilities;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SekuliFunction {
	
	public static String imageName="";
	
	public static String path="";
	
	static Screen screen = new Screen();
	
	Pattern image = new Pattern(path);
	
	public void sekuliAction(String imageName, String Action, String inputForType) {
		
		path = "C:\\SekuliImages\\"+imageName+".PNG";
		
		if (Action.equalsIgnoreCase("Type")) {
			
			try {
				screen.wait(path, 10);
				screen.type(path, inputForType);
			} 
			catch (Exception e) {
				System.out.println("Unable to perform Type action: "+e.getMessage());
			}
		}
		
		else if(Action.equalsIgnoreCase("Click")) {
			
			try {
				screen.wait(path, 10);
				screen.click(path);
			} 
			catch (Exception e) {
				System.out.println("Unable to perform Click action: "+e.getMessage());
			}
			
			
		}
		
	}

}
