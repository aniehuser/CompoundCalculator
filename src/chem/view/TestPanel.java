package chem.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import chem.controller.BaseController;
import chem.model.CompoundParamContainer;
import chem.model.InputHandler;

//import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TestPanel extends JPanel{
	private BaseController controller;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnCalculate;
	private JLabel lblCompoundMolarMass;
	private JFormattedTextField formattedTextField;
	
	public TestPanel(BaseController controller){
		this.controller = controller;
		SetPanelLayout();
		SetComponents();
		SetListeners();
		
	}
	
	private void SetPanelLayout(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{246, 144, 0, 132, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}
	
	private void SetComponents(){
		lblNewLabel = new JLabel("Input Compound Formula");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		
		btnCalculate = new JButton("Calculate");
		
		GridBagConstraints gbc_btnCalculate = new GridBagConstraints();
		gbc_btnCalculate.anchor = GridBagConstraints.WEST;
		gbc_btnCalculate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalculate.gridx = 2;
		gbc_btnCalculate.gridy = 1;
		add(btnCalculate, gbc_btnCalculate);
		
		lblCompoundMolarMass = new JLabel("Compound Molar Mass");
		GridBagConstraints gbc_lblCompoundMolarMass = new GridBagConstraints();
		gbc_lblCompoundMolarMass.anchor = GridBagConstraints.EAST;
		gbc_lblCompoundMolarMass.insets = new Insets(0, 0, 0, 5);
		gbc_lblCompoundMolarMass.gridx = 0;
		gbc_lblCompoundMolarMass.gridy = 2;
		add(lblCompoundMolarMass, gbc_lblCompoundMolarMass);
		lblCompoundMolarMass.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		
		formattedTextField = new JFormattedTextField();
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.fill = GridBagConstraints.BOTH;
		gbc_formattedTextField.insets = new Insets(0, 0, 0, 5);
		gbc_formattedTextField.gridx = 1;
		gbc_formattedTextField.gridy = 2;
		add(formattedTextField, gbc_formattedTextField);
	}
	
	private void SetListeners(){
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				CompoundParamContainer input = new CompoundParamContainer();
				input.setName(textField.getText());
				if(!InputHandler.getCompound(input)){
					formattedTextField.setText("Invalid Input");
					return;
				}
				
				formattedTextField.setText(String.valueOf(input.getMass()));
				
			}
		});
	}
	
}
