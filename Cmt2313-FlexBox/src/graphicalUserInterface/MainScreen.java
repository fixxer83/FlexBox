package graphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import customers.UserClass;

public class MainScreen extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1230180812170805850L;
	
	//Secondary function screens
	LoginScreen loginScr;
	UserScreen userScr = new UserScreen();
	ProductScreen productScr = new ProductScreen();
	
	public static UserClass currentUser = new UserClass();
	
	//ToolBar place holder
	JPanel productSelectionPanel = new JPanel();
	JPanel userPanel = new JPanel();
	JToolBar toolBar = new JToolBar();
	
	//Components
	static JButton productBtn = new JButton(new ImageIcon("flexBoxIcons/boxIcon2.png"));
	static JButton customerOptBtn = new JButton(new ImageIcon("flexBoxIcons/userOptIcon2.png"));
	static JButton logOutBtn = new JButton(new ImageIcon("flexBoxIcons/logInOutIcon2.png"));
	static JButton exitBtn = new JButton(new ImageIcon("flexBoxIcons/exitIcon2.png"));
	static JLabel loggedInAsLbl = new JLabel("Logged in as:");
	static JLabel userNameLbl = new JLabel();
	Font font = new Font("Verdana", Font.BOLD, 12);
	
	public MainScreen(){
		super("FlexBox");
		//toolbar properties
		productBtn.addActionListener(this);
		toolBar.add(productBtn);
		customerOptBtn.addActionListener(this);
		toolBar.add(customerOptBtn);
		logOutBtn.addActionListener(this);
		toolBar.add(logOutBtn);
		exitBtn.addActionListener(this);
		toolBar.add(exitBtn);
		toolBar.add(Box.createRigidArea(new Dimension(60,0)));
		loggedInAsLbl.setFont(font);
		toolBar.add(loggedInAsLbl, BorderLayout.CENTER);
		userNameLbl.setFont(font);
		toolBar.add(userNameLbl);
		
		this.getContentPane().add(toolBar,BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
		this.setMinimumSize(new Dimension(800,600));
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		productSelectionPanel.setLayout(new BorderLayout());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == customerOptBtn){
			
			customerOptBtn.setEnabled(false);
			productBtn.setEnabled(true);
			this.remove(productSelectionPanel);
			userScr.addUsers(userPanel);
			
			userPanel.setMinimumSize(new Dimension(400, 300));
			
			this.add(userPanel);
			userPanel.updateUI();
			this.pack();
			
		}else if(e.getSource() == productBtn){
			
			productBtn.setEnabled(false);
			customerOptBtn.setEnabled(true);
			
			this.remove(userPanel);
						
			productScr.addProducts(productSelectionPanel);
			
			productSelectionPanel.setMinimumSize(new Dimension(400, 300));
			
			this.add(productSelectionPanel);
			productSelectionPanel.updateUI();
			this.pack();
			
		}else if(e.getSource() == logOutBtn){
			//Re-Login
			UserClass userClass = new UserClass();
	
			LoginScreen loginScr = new LoginScreen();
			
			this.dispose();

		}else if(e.getSource() == exitBtn){
			System.exit(0);
		}
	}
	
	/**
	 * Method to enable all buttons
	 */
	public static void enableButtons(){
		logOutBtn.setEnabled(true);
		productBtn.setEnabled(true);
		customerOptBtn.setEnabled(true);
		exitBtn.setEnabled(true);
	}
	
	/**
	 * Method to disable all buttons
	 * excluding the button passed as
	 * a parameter
	 */
	public void disableButtons(JButton button){
		logOutBtn.setEnabled(false);
		productBtn.setEnabled(false);
		customerOptBtn.setEnabled(false);
		exitBtn.setEnabled(false);
		button.setEnabled(true);
	}
	
	
}
