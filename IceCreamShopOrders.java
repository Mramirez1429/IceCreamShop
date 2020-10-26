package snippet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class IceCreamShopOrders extends JFrame
{
	
	private JPanel coneChoice;
	private JPanel scoopChoice;
	private JPanel buttonCalc;
	private JRadioButton cup;
	private JRadioButton cone;
	private JRadioButton waffleCone;
	private JLabel vanilla;
	private JLabel chocolate;
	
	private JTextField numVanilla;
	private JTextField numChocolate;
	private JButton calc;
	
	private final int WINDOW_WIDTH = 360;
	private final int WINDOW_LENGTH = 200;
	
	public IceCreamShopOrders()
	{
		setTitle("Ice Cream Shop Order Application");
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		setLayout(new BorderLayout(5,10));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		buttonCalc = new JPanel();
		calc = new JButton("Calculate Ice Cream Cost");
		calc.addActionListener(new Calculate());
		buttonCalc.add(calc);
		buildPanel();
		
		add(coneChoice,BorderLayout.WEST);
		add(scoopChoice, BorderLayout.CENTER);
		add(buttonCalc, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void buildPanel()
	{
		coneChoice = new JPanel(new GridLayout(3,1));
		coneChoice.setBorder(BorderFactory.createTitledBorder("Cone Choice"));
		cup = new JRadioButton("CUP");
		cone = new JRadioButton("CONE");
		waffleCone = new JRadioButton("WAFFLE CONE");
		ButtonGroup group1 = new ButtonGroup();
		group1.add(cup);
		group1.add(cone);
		group1.add(waffleCone);
		coneChoice.add(cup);
		coneChoice.add(cone);
		coneChoice.add(waffleCone);
		
		scoopChoice = new JPanel(new GridLayout(4,1));
		scoopChoice.setBorder(BorderFactory.createTitledBorder("Scoop Choice"));
		vanilla = new JLabel("Enter Number of vanilla scoops:");
		chocolate = new JLabel("Enter number of chocolate scoops:");
		numVanilla = new JTextField(4);
		numChocolate =  new JTextField(4);
		scoopChoice.add(vanilla);
		scoopChoice.add(numVanilla);
		scoopChoice.add(chocolate);
		scoopChoice.add(numChocolate);
		
	}
	private class Calculate implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			int numVan;
			int numChoc;
			double coneCost = 0;
			String type = null;
			if(numVanilla.equals(""))
			{
				numVan = 0;
			}
			numVan = Integer.parseInt(numVanilla.getText());
			if (numChocolate.equals(""));
			{
				numChoc = 0;
			}
			numChoc = Integer.parseInt(numChocolate.getText());
			
			if(cup.isSelected())
			{
				type = "cup";
				coneCost = 1;
			}
			else if(cone.isSelected())
			{
				type = "Cone";
				coneCost = 1.25;
			}
			else if(waffleCone.isSelected())
			{ 
				type = "waffle cone";
				coneCost = 2.50;
			}
			
			int numVanilla = numVan * 1;
			double numChocolate = numChoc * 1.25;
			double total = numVanilla + numChocolate + coneCost;
			String str = String.format("Your order for the %s:\nVanilla Scoops: %d\nChocolate Scoops: %s\n\nTotal Cost: $%.2f", 
					type, numVan, numChoc, total);
			JOptionPane.showMessageDialog(null, str);
		}
	}
	
	public static void main(String [] args)
	{
		new IceCreamShopOrders();
	}
	
		
}
