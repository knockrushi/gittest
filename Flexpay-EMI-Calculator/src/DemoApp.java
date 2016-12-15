import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTree;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;

import java.awt.event.KeyEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataListener;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class DemoApp extends JApplet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField amounttextfield;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField monthstextfield;
    private JComboBox combo1;
    private JLabel emilabel,totalamountlabel,totalinterestlabel,lblNewLabel;
    
	/**
	 * Create the applet.
	 */
	@SuppressWarnings("rawtypes")
	public DemoApp() {
		setLocation(-10, 10);
		getContentPane().setMaximumSize(new Dimension(500, 700));
		getContentPane().setLayout(null);
		
		JButton btnPayEmi = new JButton("Calculate EMI");
		btnPayEmi.setName("calemi");
		btnPayEmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount = Integer.parseInt(amounttextfield.getText());
				int months = Integer.parseInt(monthstextfield.getText());
		        String str = combo1.getSelectedItem().toString();
				double rateofintrest=15;
				if(str.equals("ICICI"))
				{
				rateofintrest=13.5;	
				}
				else if(str.equals("HDFC")) 
				{
					rateofintrest=12.5;	

				}
				else if(str.equals("BOI")) 
				{
					rateofintrest=10.5;	
				}
				else if(str.equals("AXIS"))
				{
					rateofintrest=14.5;		
				}
				
	                double emi = calEMI(amount, rateofintrest, months);
	                emilabel.setText("  "+Math.round(emi));
	               
	                double totalInt = Math.round((emi * months) - amount);
	                totalinterestlabel.setText(" "+totalInt);
	               
	                double totalAmt = Math.round((emi * months));
	                totalamountlabel.setText(" "+totalAmt);
			}
		});
		btnPayEmi.setBounds(98, 159, 103, 23);
		getContentPane().add(btnPayEmi);
		
		amounttextfield = new JTextField();
		amounttextfield.setHorizontalAlignment(SwingConstants.TRAILING);
		amounttextfield.setName("amount");
		amounttextfield.setBounds(139, 54, 86, 20);
		getContentPane().add(amounttextfield);
		amounttextfield.setColumns(10);
		
		JLabel lblEnterAmount = new JLabel("Enter Amount");
		lblEnterAmount.setBounds(59, 57, 111, 14);
		getContentPane().add(lblEnterAmount);
		
		JLabel lblChooseBank = new JLabel("Choose Bank");
		lblChooseBank.setBounds(49, 165, 93, -90);
		getContentPane().add(lblChooseBank);
		
	    combo1 = new JComboBox();
	
	    
	    
		combo1.setName("rate");
		combo1.addItem("ICICI");
		combo1.addItem("HDFC");
		combo1.addItem("BOI");
		combo1.addItem("AXIS"); 
		combo1.setBounds(149, 113, 86, 20);
		getContentPane().add(combo1);
		
		
		combo1.addItemListener(new ItemListener(){
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		
		    	double rateofintrest=1;
		    	if(e.getItem()=="ICICI")
				{
				rateofintrest=13.5;	
				lblNewLabel.setText("@ "+rateofintrest+" %");
				
				}
				else if(e.getItem()=="HDFC") 
				{
					rateofintrest=12.5;	
					lblNewLabel.setText("@ "+rateofintrest+" %");


				}
				else if(e.getItem()=="BOI") 
				{
					rateofintrest=10.5;	
					lblNewLabel.setText("@ "+rateofintrest+" %");

				}
				else if(e.getItem()=="AXIS")
				{
					rateofintrest=14.5;		
					lblNewLabel.setText("@ "+rateofintrest+" %");

				}   
		    	
		    	
		    	

		    }

		});
		
	    emilabel = new JLabel("0");
		emilabel.setHorizontalAlignment(SwingConstants.TRAILING);
		emilabel.setName("displayemi");
		emilabel.setBounds(115, 193, 86, 14);
		getContentPane().add(emilabel);
		
		JLabel lblEmi = new JLabel("EMI Per Month");
		lblEmi.setBounds(60, 193, 92, 14);
		getContentPane().add(lblEmi);
		
		JLabel lblMonths = new JLabel("Months");
		lblMonths.setBounds(59, 82, 46, 14);
		getContentPane().add(lblMonths);
		
		monthstextfield = new JTextField();
		monthstextfield.setHorizontalAlignment(SwingConstants.TRAILING);
		monthstextfield.setName("months");
		monthstextfield.setBounds(139, 82, 86, 20);
		getContentPane().add(monthstextfield);
		monthstextfield.setColumns(10);
		
		JLabel lblBankintrestrate = new JLabel("Rate of Intrest");
		lblBankintrestrate.setBounds(59, 119, 103, 14);
		getContentPane().add(lblBankintrestrate);
		
		JLabel lblTotalInterest = new JLabel(" Total Interest");
		lblTotalInterest.setBounds(59, 218, 86, 14);
		getContentPane().add(lblTotalInterest);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(59, 243, 73, 14);
		getContentPane().add(lblTotalAmount);
		
	    totalinterestlabel = new JLabel("0");
		totalinterestlabel.setName("totalinterest");
		totalinterestlabel.setHorizontalAlignment(SwingConstants.TRAILING);
		totalinterestlabel.setBounds(115, 218, 86, 14);
		getContentPane().add(totalinterestlabel);
		
	    totalamountlabel = new JLabel("0");
		totalamountlabel.setName("totalamt");
		totalamountlabel.setHorizontalAlignment(SwingConstants.TRAILING);
		totalamountlabel.setBounds(115, 243, 86, 14);
		getContentPane().add(totalamountlabel);
		
	 lblNewLabel = new JLabel("%");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(159, 132, 80, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblEmiCalculator = new JLabel("EMI CALCULATOR..!");
		lblEmiCalculator.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmiCalculator.setBounds(59, 11, 166, 14);
		getContentPane().add(lblEmiCalculator);


	}
	
	
	
	public double calEMI(int p,double r,int n )
	{
	double emi = 0;	
	 double R = (r / 12) / 100;
     emi = (p * R * (Math.pow((1 + R), n)) / ((Math.pow((1 + R), n)) - 1));	
	return emi;
	}
	
	
	
	
	
}
