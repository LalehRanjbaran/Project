package finalProject;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class frame3 extends JFrame {

	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 900;
	private static final int CHART_WIDTH = 400;
	private static final int CHART_HEIGHT = 400;
	private JLabel companyOffer;
	private JLabel NameOfCompany;
	private JTextField Result;
	private JTextField nameCo;
	private JTextField offer;
	private JButton addButton;
	private JButton removeButton;
	private JButton resultButton;
	private ChartComponent chart;
	 company myCompany;
	LinkedList laleh = new LinkedList();

	/**
	 * make a new frame
	 */
	public frame3() {

		chart = new ChartComponent();
		chart.setPreferredSize(new Dimension(CHART_WIDTH, CHART_HEIGHT));
		chart.setFont(new Font("Candra",Font.BOLD,20));
		chart.setBounds(5, 230, 900, 600);
		createTextFields();
		createButtons();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	
	}

	/**
	 * create all text fields
	 */
	private void createTextFields() {
		final int LABEL_FIELD_WIDTH = 20;
		NameOfCompany = new JLabel("Name:");
		NameOfCompany.setFont(new Font("Candra",Font.BOLD,20));
		NameOfCompany.setBounds(5, 10, 250, 40);
		nameCo = new JTextField(LABEL_FIELD_WIDTH);
		nameCo.setBounds(157, 10, 250, 40);		
		nameCo.setToolTipText("Enter name of company in here");
		nameCo.setFont(new Font("Candra",Font.BOLD,20));
		final int VALUE_FIELD_WIDTH = 10;
		companyOffer = new JLabel("Offer:");
		companyOffer.setFont(new Font("Candra",Font.BOLD,20));
		companyOffer.setBounds(450, 10, 100, 40);
		offer = new JTextField(VALUE_FIELD_WIDTH);
		offer.setToolTipText("Enter a number for offer");
		offer.setFont(new Font("Candra",Font.BOLD,20));
		offer.setBounds(550, 10, 250, 40);
		Result = new JTextField(VALUE_FIELD_WIDTH);
		Result.setToolTipText("By clicking Rusult button, the result will be showed up");
		Result.setFont(new Font("Candra",Font.BOLD,20));
		Result.setBounds(350, 700, 300, 40);
	}
	/**
	 *  create buttons
	 */
	public void createButtons() {
		addButton = new JButton("Add");
		addButton.setToolTipText("Enter both name and offer then push add");
		addButton.setBounds(350, 100, 250, 40);
		addButton.setFont(new Font("Candra",Font.BOLD,20));
		addButton.addActionListener(new AddBarListener());
		removeButton = new JButton("Remove last");
		removeButton.setFont(new Font("Candra",Font.BOLD,20));
		removeButton.setBounds(350, 170, 250, 40);
		removeButton.addActionListener(new RemoveBarListener());
		resultButton = new JButton("Result");
		resultButton.setBounds(150, 700, 150, 40);
		resultButton.setFont(new Font("Candra",Font.BOLD,20));
		resultButton.addActionListener(new AddResultListner());
	}

	/**
	 * add company to chart
	 *
	 */
	class AddBarListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			try {
				myCompany = new company();
				String label = nameCo.getText();
				double value = Double.parseDouble(offer.getText());
				myCompany.setCompanyName(label);
				myCompany.setSuggestedCost(value);
				laleh.sortInsert(myCompany);
				String co = myCompany.toString();
				chart.append(co);
				nameCo.setText("");
				offer.setText("");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "enter a number as a the company offer" + e.getMessage());
			}
		}
	}
	/**
	 * add event to Add button
	 *
	 */

	class AddResultListner implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				Result.setText(laleh.findWinner(laleh).toString());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "List is: " + e.getMessage());
			}
		}
	}
	/**
	 * add event to Remove Last button
	 *
	 */
	class RemoveBarListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				laleh.deletLast();
			    laleh.displaylist();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "" + e.getMessage());
			}
			chart.removeLast();
		}
	}

	/**
	 * create Panel
	 */
	public void createPanel() {
	    JPanel panel = new JPanel(null);
	   	panel.add(NameOfCompany);
	    panel.add(nameCo);
		panel.add(companyOffer);
		panel.add(offer);
		panel.add(addButton);
		panel.add(removeButton);		
		panel.add(resultButton);
		panel.add(Result);
		panel.add(chart);
		add(panel);
	}
}
