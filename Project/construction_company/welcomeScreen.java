package construction_company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class welcomeScreen{
	JFrame frame = new JFrame("Welcome");
	final JComboBox<String>cb;
	public welcomeScreen()
	{
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,400);
		frame.setLocation(400, 200);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(null);

		JLabel label1 = new JLabel("Welcome to Construction Site");
		label1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,30));
		label1.setBounds(100, 30, 450, 30);
		
		
		JLabel label2 = new JLabel("Login as");
		label2.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
		label2.setBounds(200,100,150,30);
		String[] choices = {"SELECT","Construction Department" , "Manager" , " SuperVisior" , " Worker" , "Client"};
		cb = new JComboBox<String>(choices);
		cb.setBounds(320, 100, 150, 30);
		
		
		JButton btn = new JButton("OK");
		btn.setBounds(260, 160, 100, 30);
		panel1.add(label1);
		panel1.add(label2);
		panel1.add(cb);
		panel1.add(btn);
		frame.add(panel1);
		frame.setVisible(true);
		panel1.setVisible(true);
		Handler h = new Handler();
		btn.addActionListener(h);
	}
	private class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
			if(cb.getSelectedIndex()==0){
				JOptionPane.showMessageDialog(frame, "Please select a role to login..!","Error",0);;
			}
			else{
				new Login(cb.getSelectedIndex());
				frame.dispose();
			}
			
		}
	}
	public static void main(String[] args)
	{
		new welcomeScreen();
	}
	
}