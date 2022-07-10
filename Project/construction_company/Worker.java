package construction_company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Worker {
    JFrame frame = new JFrame("Worker");
    JMenuItem showdetails,logout,skills,workHrs,salStatus,bonus;
    JPanel homePanel,skillPanel,workHrPanel, salPanel,shPanel,bonusPanel;
    JTextField skIdText, wIdText, saIdText,shIdText,bIdText;
    JButton sshow,skshow,wshow,shshow,bshow;
    JTable displayTable;
    JScrollPane sp = new JScrollPane();


    Handler h = new Handler();

    Worker(){
        //frame
        setFrame();

        //create menu bar
        addMenu();

        //home Panel
        homePane();

        //skill panel
        addSkill();

        //Bonus panel
        bonusPane();

        //work hrs panel
        workHrPane();

        //salary panel
        salaryPane();

        //show details panel
        showDetailsPane();

        //add panels to frame
        addPanels();

        frame.setVisible(true);

        //add action listners
        addActions();
        
    }

    void setFrame() {
        frame.setBounds(400, 200, 700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    void addMenu(){
        JMenuBar menuBar = new JMenuBar();

        // menu
        JMenu home = new JMenu("Home");
        JMenu display = new JMenu("Display");
        JMenu profile1 = new JMenu("Profile");

        // menu items
        skills = new JMenuItem("Skills");
        bonus = new JMenuItem("Show Bonus");
        workHrs = new JMenuItem("TotalWorkHours");
        salStatus = new JMenuItem("Salary Status");
        showdetails = new JMenuItem("Show Details");
        logout = new JMenuItem("LOG OUT");
        logout.setBackground(Color.RED);

        // add menu items
        display.add(skills);
        display.add(bonus);
        display.add(workHrs);
        display.add(salStatus);
        profile1.add(showdetails);
        profile1.add(logout);

        // add menu to menu bar
        menuBar.add(home);
        home.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {

                homePanel.setVisible(true);
                shPanel.setVisible(false);
                bonusPanel.setVisible(false);
                workHrPanel.setVisible(false);
                salPanel.setVisible(false);
                skillPanel.setVisible(false);
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
        menuBar.add(profile1);

        // add menu bar to frame
        frame.setJMenuBar(menuBar);
    }
    
    void homePane() {
        homePanel = new JPanel();
        homePanel.setLayout(null);

        JLabel welc = new JLabel("Welcome");
        welc.setBounds(260, 115, 150, 50);
        welc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        homePanel.add(welc);
    }

    void addSkill(){
        skillPanel = new JPanel();
        skillPanel.setLayout(null);

        JLabel skIdLabel = new JLabel("Worker Id: ");
        skIdText = new JTextField(10);
        skshow = new JButton("Show");

        skIdLabel.setBounds(215, 20, 100, 50);
        skIdText.setBounds(335, 35, 100, 25);
        skshow.setBounds(285, 80, 90, 25);

        skillPanel.add(skIdLabel);
        skillPanel.add(skIdText);
        skillPanel.add(skshow);

    }

    void bonusPane(){
        bonusPanel = new JPanel();
        bonusPanel.setLayout(null);

        JLabel bIdLabel = new JLabel("Worker Id: ");
        bIdText = new JTextField(10);
        bshow = new JButton("Show");

        bIdLabel.setBounds(215, 20, 100, 50);
        bIdText.setBounds(335, 35, 100, 25);
        bshow.setBounds(285, 80, 90, 25);

        bonusPanel.add(bIdLabel);
        bonusPanel.add(bIdText);
        bonusPanel.add(bshow);
    }

    void workHrPane(){
        workHrPanel = new JPanel();
        workHrPanel.setLayout(null);

        JLabel wIdLabel = new JLabel("Worker Id: ");
        wIdText = new JTextField(10);
        wshow = new JButton("Show");

        wIdLabel.setBounds(215, 20, 100, 50);
        wIdText.setBounds(335, 35, 100, 25);
        wshow.setBounds(285, 80, 90, 25);

        workHrPanel.add(wIdLabel);
        workHrPanel.add(wIdText);
        workHrPanel.add(wshow);
    }

    void salaryPane(){
        salPanel = new JPanel();
        salPanel.setLayout(null);

        JLabel saIdLabel = new JLabel("Worker Id: ");
        saIdText = new JTextField(10);

        sshow = new JButton("Show");

        saIdLabel.setBounds(215, 20, 100, 50);
        saIdText.setBounds(335, 35, 100, 25);
        sshow.setBounds(285, 80, 90, 25);

        salPanel.add(saIdLabel);
        salPanel.add(saIdText);
        salPanel.add(sshow);
    }

    void showDetailsPane(){
        shPanel = new JPanel();
        shPanel.setLayout(null);
        JLabel shIdLabel = new JLabel("Worker Id: ");
        shIdText = new JTextField(10);

        shshow = new JButton("Show");

        shIdLabel.setBounds(215, 20, 100, 50);
        shIdText.setBounds(335, 35, 100, 25);
        shshow.setBounds(285, 80, 90, 25);

        shPanel.add(shIdLabel);
        shPanel.add(shIdText);
        shPanel.add(shshow);
    }

    void addPanels() {
        homePanel.setBounds(0, 10, 700, 400);
        frame.add(homePanel);

        shPanel.setBounds(0, 0, 700, 400);
        frame.add(shPanel);
        shPanel.setVisible(false);

        bonusPanel.setBounds(0, 0, 700, 400);
        frame.add(bonusPanel);
        bonusPanel.setVisible(false);

        skillPanel.setBounds(0, 0, 700, 400);
        frame.add(skillPanel);
        skillPanel.setVisible(false);

        workHrPanel.setBounds(0, 0, 700, 400);
        frame.add(workHrPanel);
        workHrPanel.setVisible(false);

        salPanel.setBounds(0, 0, 700, 400);
        frame.add(salPanel);
        salPanel.setVisible(false);
    }

    void addActions(){
        logout.addActionListener(h);
        skills.addActionListener(h);
        bonus.addActionListener(h);
        workHrs.addActionListener(h);
        salStatus.addActionListener(h);
        showdetails.addActionListener(h);

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
                shPanel.setVisible(true);
                bonusPanel.setVisible(false);
                workHrPanel.setVisible(false);
                skillPanel.setVisible(false);
                salPanel.setVisible(false);
                sp.setVisible(false);
                shshow.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = shIdText.getText();
                        String sql = "SELECT e_id,e_name,workexp,job_assigned FROM employee natural join worker where e_id=\'"
                                + id + "\';";
                        String tname = "employee natural join supervisior";
                        dbAcess obj = new dbAcess();
                        String[] row = { "Id", "Name", "Work exp", "Job Assigned" };
                        String[][] data = obj.showDetails(id, sql, tname);
                            displayTable = new JTable(data, row);
                            sp = new JScrollPane(displayTable);
                            sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                            frame.add(sp);
                            sp.setBounds(0, 175, 700, 200);
                    }

                });
            }
            if (e.getSource() == salStatus) {
                homePanel.setVisible(false);
                shPanel.setVisible(false);
                bonusPanel.setVisible(false);
                workHrPanel.setVisible(false);
                skillPanel.setVisible(false);
                salPanel.setVisible(true);
                sp.setVisible(false);
                sshow.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = saIdText.getText();
                        String sql = "select salary from employee natural join worker where e_id=\'" + id + "\';";
                        dbAcess obj = new dbAcess();
                        String salary = obj.getAnything(sql,"salary");
                        if(salary!=null)
                            JOptionPane.showMessageDialog(frame, "Your Salary is: " + salary, "Salary", 1);

                    }

                });
            }
            if(e.getSource()==bonus){
                homePanel.setVisible(false);
                shPanel.setVisible(false);
                bonusPanel.setVisible(true);
                workHrPanel.setVisible(false);
                skillPanel.setVisible(false);
                salPanel.setVisible(false);
                sp.setVisible(false);
                bshow.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = bIdText.getText();
                        String sql = "select bonus from employee natural join worker where e_id=\'" + id + "\';";
                        String sql1 = "select salary from employee natural join worker where e_id=\'" + id + "\';";
                        dbAcess obj = new dbAcess();
                        if(obj.getAnything(sql1, "salary")!=null){
                            double sal = Double.parseDouble(obj.getAnything(sql1, "salary"));
                            double bonus = Double.parseDouble(obj.getAnything(sql, "bonus"));
                            JOptionPane.showMessageDialog(frame, "Your Bonus is: " + (sal*bonus)/100, "Bonus", 1);
                        }
                    }

                });
            }
            if(e.getSource()==skills){
                homePanel.setVisible(false);
                shPanel.setVisible(false);
                bonusPanel.setVisible(false);
                workHrPanel.setVisible(false);
                skillPanel.setVisible(true);
                salPanel.setVisible(false);
                sp.setVisible(false);
                skshow.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = skIdText.getText();
                        String sql = "select skills from employee natural join worker where e_id=\'" + id + "\';";
                        dbAcess obj = new dbAcess();
                        String skill = obj.getAnything(sql,"skills");
                        if(skill!=null){
                            JOptionPane.showMessageDialog(frame, "Your Skills are: " + skill, "Skill", 1);
                        }
                        

                    }

                });
            }
            if(e.getSource()==workHrs){
                homePanel.setVisible(false);
                shPanel.setVisible(false);
                bonusPanel.setVisible(false);
                workHrPanel.setVisible(true);
                skillPanel.setVisible(false);
                salPanel.setVisible(false);
                sp.setVisible(false);
                wshow.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = wIdText.getText();
                        String sql = "select work_hrs from employee natural join worker where e_id=\'" + id + "\';";
                        dbAcess obj = new dbAcess();
                        String wkhr = obj.getAnything(sql,"work_hrs");
                        if(wkhr!=null)
                            JOptionPane.showMessageDialog(frame, "Total Work hours are: " + wkhr, "Work hours", 1);

                    }

                });
            }
            
        }
    }
    
    private class dbAcess {
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

        String[][] showDetails(String id, String sql, String tableName) {
            String[][] data = { {} };
            try {
                s = c.createStatement();
                ResultSet rs = s.executeQuery(sql);
                int i = 0;
                while(rs.next()){
                    i++;
                }
                rs = s.executeQuery(sql);
                int col = rs.getMetaData().getColumnCount();
                data = new String[i][col];
                i = 0;
                while (rs.next()) {
                    for (int j = 0; j < col; j++) {
                        data[i][j] = rs.getString(j + 1);
                    }
                    i++;
                }
                return data;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

        String getAnything(String sql,String col) {
            String sal = "";
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
