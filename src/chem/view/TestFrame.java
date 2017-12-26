package chem.view;

import javax.swing.JFrame;

import chem.controller.BaseController;

public class TestFrame extends  JFrame {
	private TestPanel basePanel;
	
	public TestFrame(BaseController controller){
		basePanel = new TestPanel(controller);
		setupFrame();
	}
	
	private void setupFrame(){
		this.setContentPane(basePanel);
		this.setSize(400,150);
		this.setVisible(true);
	}
}
