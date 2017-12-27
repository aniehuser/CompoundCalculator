package chem.controller;

import chem.view.TestFrame;

public class BaseController {
	private TestFrame frame;
	
	public void start(){
		frame = new TestFrame(this);
	}
	
	
	
	
	
}
