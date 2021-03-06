package graphicalUserInterface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import customers.UserClass;

public class LoginScreen extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static UserClass currentUser;
	
	private JLabel usernameLbl = new JLabel("Username: ");
	private JTextField usernameTxt = new JTextField();
	private JLabel passwordLbl = new JLabel("Password: ");
	private JPasswordField passwordTxt = new JPasswordField();
	private JButton signInBtn = new JButton("Sign In");
	public JButton resetBtn = new JButton("Reset");
	
	Font font = new Font("Verdana", Font.BOLD, 12);
	Dimension mediumDimension = new Dimension(150,30);
	Dimension buttonDimension = new Dimension(100,30);
	
	private String getUserName() {
		return usernameTxt.getText();
	}
	
	private void setUserName(String userName) {
		usernameTxt.setText(userName);
	}
	
	private void setPassword(String password) {
		passwordTxt.setText(password);
	}
	private String getPassword(){
		String password = new String(passwordTxt.getPassword());
		return password;
	}
	
	public LoginScreen(){
		super("FlexBox Login");
		//Setting gridbag constraints for left and right components
		GridBagConstraints leftSide = new GridBagConstraints();
		leftSide.anchor = GridBagConstraints.WEST;
		GridBagConstraints rightSide = new GridBagConstraints();
		rightSide.ipadx = GridBagConstraints.HORIZONTAL;
		rightSide.gridwidth = GridBagConstraints.REMAINDER;
		
		this.setLayout(new GridBagLayout());
		
		//Dimensions properties
		usernameLbl.setFont(font);
		usernameTxt.setFont(font);
		usernameTxt.setPreferredSize(mediumDimension);
		passwordLbl.setFont(font);
		passwordTxt.setFont(font);
		passwordTxt.setPreferredSize(mediumDimension);
		signInBtn.setPreferredSize(buttonDimension);
		resetBtn.setPreferredSize(buttonDimension);
		
		signInBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		
		this.add(usernameLbl, leftSide);
		this.add(usernameTxt, rightSide);
		this.add(passwordLbl, leftSide);
		this.add(passwordTxt, rightSide);
		this.add(signInBtn, leftSide);
		this.add(resetBtn, rightSide);
		this.setPreferredSize(new Dimension(300,200));
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
		this.setLocationRelativeTo(null);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == signInBtn){
			
			if((getUserName().equals("")) &&(getPassword().equals(""))){
				
				JOptionPane.showMessageDialog(super.getParent(), "Please enter valid credentials!");
			
			}else if(getUserName().equals("")){
			
				JOptionPane.showMessageDialog(super.getParent(), "Please enter a valid username!");
			
			}else if(getPassword().equals("")){
			
				JOptionPane.showMessageDialog(super.getParent(), "Please enter a valid password!");
		
			}else{
				currentUser = new UserClass();
				ArrayList<Object> list = new ArrayList<Object>();
				list.add(getUserName());
				list.add(getPassword());
				
				if(currentUser.searchForUser(list) == null){
	
					JOptionPane.showMessageDialog(super.getParent(), "Invalid credentials, please try again!",
							"Invalid Credentials", JOptionPane.ERROR_MESSAGE);
				}else{
					MainScreen ms = new MainScreen();
					ms.currentUser = currentUser.searchForUser(list);
					this.setVisible(false);
					ms.userNameLbl.setText(" " + ms.currentUser.getUsername());
					ms.userNameLbl.setVisible(true);
				}
			}
			
		}else if(e.getSource() == resetBtn){
			setUserName("");
			setPassword("");
		}
	}
	
	
	
}
