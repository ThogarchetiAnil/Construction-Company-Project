package construction_company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

class ConstructionDept {
    JFrame frame = new JFrame("Construction Department");

    JMenuItem showdetails, logout;
    JPanel homepanel, managerNamesPanel, supervisiorNamesPanel, workerNamesPanel, clientNamesPanel, siteDetailsPanel,
            updateSalaryPanel, showDetailsPanel;
    JButton managerNamesshow, supervisiorNamesshow, workerNamesshow, clientNamesshow, siteDetailsshow, updateSalaryshow,
            showDetailsshow;
    JTextField managerNamesText, supervisiorNamesText, workerNamesText, clientNamesText, siteDetailsText,
            updateSalaryText, showDetailsText, updateSalaryText1;
    JTable displayTable;
    Handler h = new Handler();
    JMenuItem managerNames, supervisiorNames, workerNames, clientNames, siteDetails, updateSalary;
    JScrollPane sp = new JScrollPane();

    JMenuItem showDetails;
    JMenuItem logOut;

    ConstructionDept() {
        // add menu
        addmenu();

        // frame
        setFrame();

        homepane();

        manager();
        supervisior();
        client();
        worker();
        siteDetails();
        showDetails();
        update();
        addPanels();
        addActions();

    }

    void setFrame() {
        frame.setBounds(400, 200, 700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    void addmenu() {
        // create main frame

        // create menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu home = new JMenu("Home");

        // create menu
        JMenu display = new JMenu("Display");
        JMenu edit = new JMenu("Update");

        JMenu profile = new JMenu("Profile");

        // create menu items
        managerNames = new JMenuItem("Manager Names");
        supervisiorNames = new JMenuItem("Supervisior Names");
        workerNames = new JMenuItem("Worker Names");
        clientNames = new JMenuItem("Client Names");
        siteDetails = new JMenuItem("Site Details");
        showDetails = new JMenuItem("Show Details");
        updateSalary = new JMenuItem("Update Salary");
        logOut = new JMenuItem("Log out");
        logOut.setBackground(Color.RED);

        // adding menu items to menu
        display.add(managerNames);
        display.add(supervisiorNames);
        display.add(workerNames);
        display.add(clientNames);
        display.add(siteDetails);

        edit.add(updateSalary);

        profile.add(showDetails);
        profile.add(logOut);

        // adding menu to menu bar
        menuBar.add(home);
        home.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {

                homepanel.setVisible(true);
                managerNamesPanel.setVisible(false);
                supervisiorNamesPanel.setVisible(false);
                workerNamesPanel.setVisible(false);
                clientNamesPanel.setVisible(false);
                siteDetailsPanel.setVisible(false);
                updateSalaryPanel.setVisible(false);
                showDetailsPanel.setVisible(false);
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
        menuBar.add(edit);

        menuBar.add(profile);

        // adding menu bar to main frame
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

        logOut.addActionListener(h);

    }

    void homepane() {
        homepanel = new JPanel();
        homepanel.setLayout(null);

        JLabel welc = new JLabel("Welcome");
        welc.setBounds(260, 115, 150, 50);
        welc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        homepanel.add(welc);
    }

    void manager() {
        managerNamesPanel = new JPanel();
        managerNamesPanel.setLayout(null);
        managerNamesPanel.setBackground(Color.LIGHT_GRAY);
        JLabel managerNamesLabel = new JLabel("for manager names click the button");
        managerNamesText = new JTextField(10);
        managerNamesshow = new JButton("Show");

        managerNamesLabel.setBounds(215, 20, 200, 50);
        // managerNamesText.setBounds(335, 35, 100, 25);
        managerNamesshow.setBounds(285, 80, 90, 25);

        managerNamesPanel.add(managerNamesLabel);
        // managerNamesPanel.add(managerNamesText);
        managerNamesPanel.add(managerNamesshow);

    }

    void supervisior() {
        supervisiorNamesPanel = new JPanel();
        supervisiorNamesPanel.setLayout(null);
        supervisiorNamesPanel.setBackground(Color.LIGHT_GRAY);
        JLabel supervisiorNamesLabel = new JLabel("for supervisor names click the icon");
        supervisiorNamesText = new JTextField(10);
        supervisiorNamesshow = new JButton("Show ");

        supervisiorNamesLabel.setBounds(215, 20, 200, 50);
        // supervisiorNamesText.setBounds(335, 35, 100, 25);
        supervisiorNamesshow.setBounds(285, 80, 90, 25);

        supervisiorNamesPanel.add(supervisiorNamesLabel);
        // supervisiorNamesPanel.add( supervisiorNamesText);
        supervisiorNamesPanel.add(supervisiorNamesshow);

    }

    void client() {
        clientNamesPanel = new JPanel();
        clientNamesPanel.setLayout(null);
        clientNamesPanel.setBackground(Color.LIGHT_GRAY);
        JLabel clientNamesLabel = new JLabel("for client names click the button");
        // clientNamesText=new JTextField(10);
        clientNamesshow = new JButton("Show");

        clientNamesLabel.setBounds(215, 20, 200, 50);
        clientNamesshow.setBounds(285, 80, 90, 25);

        clientNamesPanel.add(clientNamesLabel);
        // clientNamesPanel.add( clientNamesText);
        clientNamesPanel.add(clientNamesshow);

    }

    void worker() {
        workerNamesPanel = new JPanel();
        workerNamesPanel.setLayout(null);
        workerNamesPanel.setBackground(Color.LIGHT_GRAY);
        JLabel workerNamesLabel = new JLabel("for worker names click the button");
        workerNamesText = new JTextField(10);
        workerNamesshow = new JButton("Show");

        workerNamesLabel.setBounds(215, 20, 200, 50);
        // workerNamesText.setBounds(335, 35, 100, 25);
        workerNamesshow.setBounds(285, 80, 90, 25);

        workerNamesPanel.add(workerNamesLabel);
        // workerNamesPanel.add( workerNamesText);
        workerNamesPanel.add(workerNamesshow);

    }

    void siteDetails() {
        siteDetailsPanel = new JPanel();
        siteDetailsPanel.setLayout(null);
        siteDetailsPanel.setBackground(Color.LIGHT_GRAY);
        JLabel siteDetailsLabel = new JLabel("SiteDetails Id : ");
        siteDetailsText = new JTextField(10);
        siteDetailsshow = new JButton("Show");

        siteDetailsLabel.setBounds(215, 20, 100, 50);
        siteDetailsText.setBounds(335, 35, 100, 25);
        siteDetailsshow.setBounds(285, 80, 90, 25);

        siteDetailsPanel.add(siteDetailsLabel);
        siteDetailsPanel.add(siteDetailsText);
        siteDetailsPanel.add(siteDetailsshow);

    }

    void showDetails() {
        showDetailsPanel = new JPanel();
        showDetailsPanel.setLayout(null);
        showDetailsPanel.setBackground(Color.LIGHT_GRAY);
        JLabel showDetailsLabel = new JLabel("Enter Id : ");

        showDetailsText = new JTextField(10);
        // JTextField showDetailsText1 = new JTextField(10);
        showDetailsshow = new JButton("Show");

        showDetailsLabel.setBounds(215, 20, 100, 50);

        showDetailsText.setBounds(335, 35, 100, 25);

        showDetailsshow.setBounds(285, 100, 90, 25);

        showDetailsPanel.add(showDetailsLabel);

        showDetailsPanel.add(showDetailsText);

        showDetailsPanel.add(showDetailsshow);

    }

    void update() {
        updateSalaryPanel = new JPanel();
        updateSalaryPanel.setLayout(null);
        updateSalaryPanel.setBackground(Color.LIGHT_GRAY);
        JLabel updateSalaryLabel = new JLabel("Enter Id : ");
        JLabel updateSalaryLabel1 = new JLabel("Update salary : ");
        updateSalaryText = new JTextField(10);
        updateSalaryText1 = new JTextField(10);
        updateSalaryText = new JTextField(10);
        updateSalaryshow = new JButton("Show");

        updateSalaryLabel.setBounds(215, 20, 100, 50);
        updateSalaryLabel1.setBounds(215, 50, 100, 50);
        updateSalaryText.setBounds(335, 35, 100, 25);
        updateSalaryText1.setBounds(335, 65, 100, 25);
        updateSalaryshow.setBounds(285, 100, 90, 25);

        updateSalaryPanel.add(updateSalaryLabel);
        updateSalaryPanel.add(updateSalaryLabel1);
        updateSalaryPanel.add(updateSalaryText);
        updateSalaryPanel.add(updateSalaryText1);
        updateSalaryPanel.add(updateSalaryshow);

    }

    void addPanels() {
        homepanel.setBounds(0, 10, 700, 400);
        frame.add(homepanel);

        siteDetailsPanel.setBounds(0, 0, 700, 400);
        frame.add(siteDetailsPanel);
        siteDetailsPanel.setVisible(false);

        workerNamesPanel.setBounds(0, 0, 700, 400);
        frame.add(workerNamesPanel);
        workerNamesPanel.setVisible(false);

        clientNamesPanel.setBounds(0, 0, 700, 400);
        frame.add(clientNamesPanel);
        clientNamesPanel.setVisible(false);

        supervisiorNamesPanel.setBounds(0, 0, 700, 400);
        frame.add(supervisiorNamesPanel);
        supervisiorNamesPanel.setVisible(false);

        managerNamesPanel.setBounds(0, 0, 700, 400);
        frame.add(managerNamesPanel);
        managerNamesPanel.setVisible(false);

        showDetailsPanel.setBounds(0, 0, 700, 400);
        frame.add(showDetailsPanel);
        showDetailsPanel.setVisible(false);

        updateSalaryPanel.setBounds(0, 0, 700, 400);
        frame.add(updateSalaryPanel);
        updateSalaryPanel.setVisible(false);
    }

    void addActions() {
        siteDetails.addActionListener(h);
        workerNames.addActionListener(h);
        clientNames.addActionListener(h);
        supervisiorNames.addActionListener(h);
        managerNames.addActionListener(h);
        showDetails.addActionListener(h);
        updateSalary.addActionListener(h);

    }

    private class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logOut) {
                int n = JOptionPane.showConfirmDialog(frame, "Are you sure, Want to Log out?", "Log out",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    new welcomeScreen();
                    frame.dispose();
                }
            } else if (e.getSource() == siteDetails) {
                homepanel.setVisible(false);
                showDetailsPanel.setVisible(false);
                siteDetailsPanel.setVisible(true);
                workerNamesPanel.setVisible(false);
                clientNamesPanel.setVisible(false);
                supervisiorNamesPanel.setVisible(false);
                managerNamesPanel.setVisible(false);
                updateSalaryPanel.setVisible(false);
                siteDetailsshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = siteDetailsText.getText();
                        String sql = "SELECT site_id,area_in_sqft,address, pincode  from site_info where site_id=\'"
                                + id + "\';";
                        String tname = "site_info";
                        String[] row = { "s_id", "area_in_sqft", "address", " pincode " };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(id, sql, tname);
                        displayTable = new JTable(data, row);
                        displayTable.setBackground(Color.green);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });
            } else if (e.getSource() == clientNames) {
                homepanel.setVisible(false);
                showDetailsPanel.setVisible(false);
                siteDetailsPanel.setVisible(false);
                workerNamesPanel.setVisible(false);
                clientNamesPanel.setVisible(true);
                supervisiorNamesPanel.setVisible(false);
                managerNamesPanel.setVisible(false);
                updateSalaryPanel.setVisible(false);
                clientNamesshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String sql = "SELECT c_id,c_name from  client";
                        String tname = "client";
                        String[] row = { "c_id", "c_name" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(sql, tname);
                        displayTable = new JTable(data, row);
                        displayTable.setBackground(Color.green);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });

            } else if (e.getSource() == managerNames) {
                homepanel.setVisible(false);
                showDetailsPanel.setVisible(false);
                siteDetailsPanel.setVisible(false);
                workerNamesPanel.setVisible(false);
                clientNamesPanel.setVisible(false);
                supervisiorNamesPanel.setVisible(false);
                managerNamesPanel.setVisible(true);
                updateSalaryPanel.setVisible(false);
                managerNamesshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String sql = "SELECT e_id,e_name from  employee where profession='manager'";
                        String tname = "client";
                        String[] row = { "e_id", "e_name" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(sql, tname);
                        displayTable = new JTable(data, row);
                        displayTable.setBackground(Color.green);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });

            } else if (e.getSource() == supervisiorNames) {
                homepanel.setVisible(false);
                showDetailsPanel.setVisible(false);
                siteDetailsPanel.setVisible(false);
                workerNamesPanel.setVisible(false);
                clientNamesPanel.setVisible(false);
                supervisiorNamesPanel.setVisible(true);
                managerNamesPanel.setVisible(false);
                updateSalaryPanel.setVisible(false);
                supervisiorNamesshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String sql = "SELECT e_id,e_name from  employee where profession='supervisior'";
                        String tname = "client";
                        String[] row = { "e_id", "e_name" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(sql, tname);
                        displayTable = new JTable(data, row);
                        displayTable.setBackground(Color.green);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });

            } else if (e.getSource() == workerNames) {
                homepanel.setVisible(false);
                showDetailsPanel.setVisible(false);
                siteDetailsPanel.setVisible(false);
                workerNamesPanel.setVisible(true);
                clientNamesPanel.setVisible(false);
                supervisiorNamesPanel.setVisible(false);
                managerNamesPanel.setVisible(false);
                updateSalaryPanel.setVisible(false);

                workerNamesshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String sql = "SELECT e_id,e_name from  employee where profession='worker'";
                        String tname = "client";
                        String[] row = { "e_id", "e_name" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(sql, tname);
                        displayTable = new JTable(data, row);
                        displayTable.setBackground(Color.green);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });

            } else if (e.getSource() == showDetails) {
                homepanel.setVisible(false);
                showDetailsPanel.setVisible(true);
                siteDetailsPanel.setVisible(false);
                workerNamesPanel.setVisible(false);
                clientNamesPanel.setVisible(false);
                supervisiorNamesPanel.setVisible(false);
                managerNamesPanel.setVisible(false);
                updateSalaryPanel.setVisible(false);

                showDetailsshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = showDetailsText.getText();

                        String sql = "select * from  construction_dept where head_id=\'" + id + "\';";
                        String tname = "construction_dept";
                        String[] row = { "head_id", "head_name", "phone_no" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(id, sql, tname);
                        displayTable = new JTable(data, row);
                        displayTable.setBackground(Color.green);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });
            } else if (e.getSource() == updateSalary) {
                homepanel.setVisible(false);
                updateSalaryPanel.setVisible(true);
                siteDetailsPanel.setVisible(false);
                workerNamesPanel.setVisible(false);
                clientNamesPanel.setVisible(false);
                supervisiorNamesPanel.setVisible(false);
                managerNamesPanel.setVisible(false);
                showDetailsPanel.setVisible(false);

                updateSalaryshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = updateSalaryText.getText();
                        String id1 = updateSalaryText1.getText();
                        float val = Float.parseFloat(id1);
                        // String sql ="update employee set salary=\'"+id1+"\' where e_id=\'"+id+"\';";
                        String sql = "UPDATE employee SET salary='" + val + "' WHERE e_id='" + id + "' ";

                        dbAcess obj = new dbAcess();
                        obj.update_data(sql);
                        JOptionPane.showMessageDialog(frame, "Updated Successfully");

                    }
                });
            }

        }

    }

    public static void main(String[] args) {
        new ConstructionDept();
    }

    private class dbAcess {
        Connection c = null;
        Statement s = null;

        dbAcess() {
            System.out.println("Opened database successfully");

            try {
                Class.forName("org.postgresql.Driver");
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5433/javaproject", "postgres",
                        "rlykodur");
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
                while (rs.next()) {
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
            }
            return data;
        }

        boolean update_data(String sql) {
            try {
                s = c.createStatement();
                s.executeQuery(sql);

            } catch (SQLException e) {
                return false;
            }
            return true;

        }

        String[][] showDetails(String sql, String tableName) {
            String[][] data = { {} };
            try {
                s = c.createStatement();
                ResultSet rs = s.executeQuery(sql);
                int i = 0;
                while (rs.next()) {
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
            }
            return data;
        }
    }
}