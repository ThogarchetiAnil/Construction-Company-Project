package construction_company;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;

public class Login {
    JFrame loginFrame;
    JLabel id;
    JLabel pass;

    int s;

    JTextField userTextField;
    JPasswordField passwordField;
    JButton loginButton;
    JButton resetButton;
    JCheckBox showPassword;

    Login(int sel){
        s = sel;
        //create frame
        loginFrame = new JFrame("Login Page");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setBounds(400, 200, 700, 400);

        //create panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //id components
        id = new JLabel("ID");
        userTextField = new JTextField(10);

        //password compnents
        pass = new JLabel("Password");
        passwordField = new JPasswordField(10);

        //buttons
        loginButton = new JButton("LOGIN");
        resetButton = new JButton("RESET");
        showPassword = new JCheckBox("Show Password");

        //setting bounds for components
        id.setBounds(200, 70, 100, 30);
        pass.setBounds(200, 130, 100, 30);
        userTextField.setBounds(300, 70, 150, 30);
        passwordField.setBounds(300, 130, 150, 30);
        showPassword.setBounds(300, 160, 150, 30);
        loginButton.setBounds(200, 210, 100, 30);
        resetButton.setBounds(350, 210, 100, 30);

        //adding components to panel
        panel.add(id);
        panel.add(userTextField);
        panel.add(pass);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(resetButton);
        panel.add(showPassword);

        //adding panel to frame
        loginFrame.add(panel);
        loginFrame.setVisible(true);

        //adding action listners for buttons
        Handler h = new Handler();
        loginButton.addActionListener(h);
        resetButton.addActionListener(h);
        showPassword.addActionListener(h);
    }

    private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==loginButton) {
                String userText;
                String pwdText;
                userText = userTextField.getText();
                pwdText = passwordField.getText();
                
                //use function to verify password 
                if(verifyPassword(userText,pwdText)){
                    JOptionPane.showMessageDialog(loginFrame,"Login Successful","Success", 1);
                    switch(s){
                        case 1:
                            new ConstructionDept();
                            break;
                        case 2:
                            new Manager();
                            break;
                        case 3:
                            new SuperVisior();
                            break;
                        case 4:
                            new Worker();
                            break;
                        case 5:
                            new Client();
                            break;
                    }
                    //to close login window after successful login.
                    loginFrame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password","Error", 0);
                }
            }
            if (e.getSource() == resetButton) {
                userTextField.setText("");
                passwordField.setText("");
            }
            if(e.getSource()==showPassword){
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } 
                else {
                    passwordField.setEchoChar('*');
                }
            }
			
		}

    }
    boolean verifyPassword(String id,String pass){
        if(pass.equals("head123") || pass.equals("manager123") || 
            pass.equals("supervisior123")|| pass.equals("worker123")|| pass.equals("client123")){
            return true;
        }
        return false;
    }

}
