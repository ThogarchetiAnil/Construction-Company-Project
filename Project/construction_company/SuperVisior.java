package construction_company;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class SuperVisior {
    JFrame frame = new JFrame("Supervisior");
    JMenuItem showdetails, logout, wName, salStatus, bonus;
    JPanel homePanel,showDPanel, wPanel, sPanel, bonusPanel;
    JButton show, wshow, sshow, bshow;
    JTextField sIdText, wIdText, saIdText, bIdText;
    JTable displayTable;
    JScrollPane sp = new JScrollPane();

    Handler h = new Handler();

    SuperVisior() {
        // frame
        setFrame();

        // add menu
        addMenu();

        //Home panel
        homePane();

        // Bonus panel
        bonusPane();

        // show details panel
        showdetails();

        // woker names panel
        wokerNames();

        // salary panel
        salaryPane();

        // adding panels to frame
        addPanels();

        frame.setVisible(true);

        // Adding Action listners to menu items
        addActions();
    }

    void setFrame() {
        frame.setBounds(400, 200, 700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    void addMenu() {
        // menu bar
        JMenuBar menuBar = new JMenuBar();

        // menu
        JMenu display = new JMenu("Display");
        JMenu profile = new JMenu("Profile");
        JMenu home = new JMenu("Home");

        // menu items
        wName = new JMenuItem("WorkersName");
        salStatus = new JMenuItem("Salary Status");
        bonus = new JMenuItem("Show Bonus");
        showdetails = new JMenuItem("Show Details");
        logout = new JMenuItem("LOG OUT");
        logout.setBackground(Color.RED);

        // add menu items to menu
        display.add(wName);
        display.add(bonus);
        display.add(salStatus);
        profile.add(showdetails);
        profile.add(logout);

        // add menu to menu bar
        menuBar.add(home);
        home.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {
                
                homePanel.setVisible(true);
                showDPanel.setVisible(false);
                bonusPanel.setVisible(false);
                wPanel.setVisible(false);
                sPanel.setVisible(false);
                sp.setVisible(false);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
            
        });
        menuBar.add(display);
        menuBar.add(profile);

        // add menu bar to frame
        frame.setJMenuBar(menuBar);
    }

    void homePane(){
        homePanel = new JPanel();
        homePanel.setLayout(null);

        JLabel welc = new JLabel("Welcome");
        welc.setBounds(260, 115, 150, 50);
		welc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        homePanel.add(welc);
    }

    void salaryPane(){
        sPanel = new JPanel();
        sPanel.setLayout(null);

        JLabel saIdLabel = new JLabel("Supervisior Id: ");
        saIdText = new JTextField(10);

        sshow = new JButton("Show");

        saIdLabel.setBounds(215, 20, 100, 50);
        saIdText.setBounds(335, 35, 100, 25);
        sshow.setBounds(285, 80, 90, 25);

        sPanel.add(saIdLabel);
        sPanel.add(saIdText);
        sPanel.add(sshow);

    }

    void showdetails(){
        showDPanel = new JPanel();
        showDPanel.setLayout(null);

        JLabel sIdLabel = new JLabel("Supervisior Id: ");
        sIdText = new JTextField(10);

        show = new JButton("Show");

        sIdLabel.setBounds(215, 20, 100, 50);
        sIdText.setBounds(335, 35, 100, 25);
        show.setBounds(285, 80, 90, 25);

        showDPanel.add(sIdLabel);
        showDPanel.add(sIdText);
        showDPanel.add(show);

    }

    void bonusPane() {
        bonusPanel = new JPanel();
        bonusPanel.setLayout(null);

        JLabel bIdLabel = new JLabel("Supervisior Id: ");
        bIdText = new JTextField(10);
        bshow = new JButton("Show");

        bIdLabel.setBounds(215, 20, 100, 50);
        bIdText.setBounds(335, 35, 100, 25);
        bshow.setBounds(285, 80, 90, 25);

        bonusPanel.add(bIdLabel);
        bonusPanel.add(bIdText);
        bonusPanel.add(bshow);
    }

    void wokerNames(){
        wPanel = new JPanel();
        wPanel.setLayout(null);

        JLabel wIdLabel = new JLabel("Supervisior Id: ");
        wIdText = new JTextField(10);

        wshow = new JButton("Show");

        wIdLabel.setBounds(215, 20, 100, 50);
        wIdText.setBounds(335, 35, 100, 25);
        wshow.setBounds(285, 80, 90, 25);

        wPanel.add(wIdLabel);
        wPanel.add(wIdText);
        wPanel.add(wshow);
    }

    void addPanels(){
        homePanel.setBounds(0, 10, 700, 400);
        frame.add(homePanel);

        wPanel.setBounds(0, 0, 700, 400);
        frame.add(wPanel);
        wPanel.setVisible(false);

        showDPanel.setBounds(0, 0, 700, 400);
        frame.add(showDPanel);
        showDPanel.setVisible(false);

        bonusPanel.setBounds(0, 0, 700, 400);
        frame.add(bonusPanel);
        bonusPanel.setVisible(false);

        sPanel.setBounds(0, 0, 700, 400);
        frame.add(sPanel);
        sPanel.setVisible(false);
    }

    void addActions(){
        wName.addActionListener(h);
        salStatus.addActionListener(h);
        bonus.addActionListener(h);
        showdetails.addActionListener(h);
        logout.addActionListener(h);
    }

    private class Handler implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource()==logout){
                int n = JOptionPane.showConfirmDialog(frame, "Are you sure, Want to Log out?", "Log out",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    new welcomeScreen();
                    frame.dispose();
                }
    	    }
            if(e.getSource()==showdetails) {
                homePanel.setVisible(false);
                showDPanel.setVisible(true);
                bonusPanel.setVisible(false);
                wPanel.setVisible(false);
                sPanel.setVisible(false);
                sp.setVisible(false);
                show.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = sIdText.getText();
                        String sql = "SELECT e_id,e_name,workexp,no_of_workers FROM employee natural join supervisior where e_id=\'"+ id  +"\';";
                        String tname = "employee natural join supervisior";
                        String[] row = { "Id", "Name", "Work exp", "No of Workers" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(id,sql,tname);
                        displayTable = new JTable(data, row);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 175, 700, 200);
                    }

                });

            }
            if (e.getSource() == bonus) {
                homePanel.setVisible(false);
                showDPanel.setVisible(false);
                bonusPanel.setVisible(true);
                wPanel.setVisible(false);
                sPanel.setVisible(false);
                sp.setVisible(false);
                bshow.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = bIdText.getText();
                        String sql = "select bonus from employee natural join supervisior where e_id=\'" + id + "\';";
                        String sql1 = "select salary from employee natural join supervisior where e_id=\'" + id + "\';";
                        dbAcess obj = new dbAcess();
                        if (obj.getAnything(sql1, "salary") != null) {
                            double sal = Double.parseDouble(obj.getAnything(sql1, "salary"));
                            double bonus = Double.parseDouble(obj.getAnything(sql, "bonus"));
                            JOptionPane.showMessageDialog(frame, "Your Bonus is: " + (sal * bonus) / 100, "Bonus", 1);
                        }

                    }

                });
            }
            if (e.getSource() == wName) {
                homePanel.setVisible(false);
                showDPanel.setVisible(false);
                bonusPanel.setVisible(false);
                wPanel.setVisible(true);
                sPanel.setVisible(false);
                sp.setVisible(false);
                wshow.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = wIdText.getText();
                        String sql = "select w_name from worker_names where e_id=\'" + id +"\';";
                        String tname = "worker_names";
                        String[] row = { "Names"};

                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(id,sql,tname);
                        displayTable = new JTable(data, row);
                        JScrollPane sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(230, 175, 200, 200);
                    }

                });
            }
            if (e.getSource() == salStatus) {
                homePanel.setVisible(false);
                showDPanel.setVisible(false);
                bonusPanel.setVisible(false);
                wPanel.setVisible(false);
                sPanel.setVisible(true);
                // sp.setVisible(false);
                frame.remove(sp);
                sshow.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = saIdText.getText();
                        String sql = "select salary from employee natural join supervisior where e_id=\'" + id + "\';";
                        dbAcess obj = new dbAcess();
                        String salary = obj.getAnything(sql,"salary");
                        if(salary!=null)
                            JOptionPane.showMessageDialog(frame, "Your Salary is: " + salary, "Salary", 1); 
                    }

                });
            }
        }
    }

    private class dbAcess{
        Connection c = null;
        Statement s = null;

        dbAcess() {
            
            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/javaproject", "postgres", "rlykodur");
                System.out.println("Opened database successfully");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }

        String[][] showDetails(String id,String sql,String tableName){
            String[][] data = { {} };
            try {
                s = c.createStatement();
                ResultSet rs = s.executeQuery(sql);
                int col = rs.getMetaData().getColumnCount();
                int i = 0;
                while(rs.next()){
                    i++;
                }
                data = new String[i][col];
                i = 0;
                rs = s.executeQuery(sql);
                while (rs.next()) {
                    for (int j = 0; j < col; j++) {
                        data[i][j] = rs.getString(j + 1);
                    }
                    i++;
                }
                return data;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return data;
        }

        String getAnything(String sql,String col){
            String sal="";
            try {
                s = c.createStatement();
                ResultSet rs = s.executeQuery(sql);
                rs.next();
                sal = rs.getString(col);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(frame, "Id not found,Enter valid Id and try again", "Error", 0);
                // e.printStackTrace();
                return null;
            }
            return sal;
        }
    }

}