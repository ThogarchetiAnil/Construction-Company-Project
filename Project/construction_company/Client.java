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

public class Client {
    JFrame frame = new JFrame("Client");
    JMenuItem showdetails, logout;
    JPanel homepanel, verficationPanel, profilePanel, financialPanel, show_detailsPanel;
    JButton profileshow, financialshow, verficationshow, show_detailsshow;
    JTextField profileText, financialText, verficationText, show_detailsText;
    JTable displayTable;
    Handler h = new Handler();
    JMenuItem m1, m2, m3;
    JScrollPane sp = new JScrollPane();

    Client() {
        // frame
        setFrame();

        // home panel
        homepane();

        // add menu
        addmenu();

        // house verfication
        houseverfication();

        // profile status
        profile_status();

        show_details();

        financial();

        frame.setVisible(true);

        addPanels();

        addActions();
        // add actions

    }

    void setFrame() {
        frame.setBounds(400, 200, 700, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
    }

    void addmenu() {

        JMenuBar menu1 = new JMenuBar();
        JMenu show = new JMenu("Display");
        JMenu home = new JMenu("Home");
        JMenu profile1 = new JMenu("Profile");

        m1 = new JMenuItem("Current Project Status");
        m2 = new JMenuItem("House Verification");
        m3 = new JMenuItem("Financial Support");

        showdetails = new JMenuItem("Show Details");
        logout = new JMenuItem("LOG OUT");
        logout.setBackground(Color.RED);

        show.add(m2);
        show.add(m1);
        show.add(m3);
        profile1.add(showdetails);
        profile1.add(logout);

        menu1.add(home);
        home.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {

                homepanel.setVisible(true);
                verficationPanel.setVisible(false);
                profilePanel.setVisible(false);
                financialPanel.setVisible(false);
                show_detailsPanel.setVisible(false);
                sp.setVisible(false);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }

        });
        menu1.add(show);
        menu1.add(profile1);

        frame.setJMenuBar(menu1);
        frame.setVisible(true);

    }

    void homepane() {
        homepanel = new JPanel();
        homepanel.setLayout(null);

        JLabel welc = new JLabel("Welcome");
        welc.setBounds(260, 115, 150, 50);
        welc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        homepanel.add(welc);
    }

    void houseverfication() {
        verficationPanel = new JPanel();
        verficationPanel.setLayout(null);
        verficationPanel.setBackground(Color.LIGHT_GRAY);
        JLabel verficationLabel = new JLabel("Client Id : ");
        verficationText = new JTextField(10);
        verficationshow = new JButton("Show");

        verficationLabel.setBounds(215, 20, 100, 50);
        verficationText.setBounds(335, 35, 100, 25);
        verficationshow.setBounds(285, 80, 90, 25);

        verficationPanel.add(verficationLabel);
        verficationPanel.add(verficationText);
        verficationPanel.add(verficationshow);

    }

    void profile_status() {
        profilePanel = new JPanel();
        profilePanel.setLayout(null);
        profilePanel.setBackground(Color.GRAY);
        JLabel profileLabel = new JLabel("Client Id : ");
        profileText = new JTextField(10);
        profileshow = new JButton("Show");

        profileLabel.setBounds(215, 20, 100, 50);
        profileText.setBounds(335, 35, 100, 25);
        profileshow.setBounds(285, 80, 90, 25);

        profilePanel.add(profileLabel);
        profilePanel.add(profileText);
        profilePanel.add(profileshow);

    }

    void financial() {
        financialPanel = new JPanel();
        financialPanel.setLayout(null);
        financialPanel.setBackground(Color.blue);

        JLabel financialLabel = new JLabel("Client Id : ");
        financialText = new JTextField(10);
        financialshow = new JButton("Show");

        financialLabel.setBounds(215, 20, 100, 50);
        financialText.setBounds(335, 35, 100, 25);
        financialshow.setBounds(285, 80, 90, 25);

        financialPanel.add(financialLabel);
        financialPanel.add(financialText);
        financialPanel.add(financialshow);

    }

    void show_details() {
        show_detailsPanel = new JPanel();
        show_detailsPanel.setLayout(null);
        show_detailsPanel.setBackground(Color.cyan);
        JLabel show_detailsLabel = new JLabel("Client Id : ");
        show_detailsText = new JTextField(10);
        show_detailsshow = new JButton("Show");

        show_detailsLabel.setBounds(215, 20, 100, 50);
        show_detailsText.setBounds(335, 35, 100, 25);
        show_detailsshow.setBounds(285, 80, 90, 25);

        show_detailsPanel.add(show_detailsLabel);
        show_detailsPanel.add(show_detailsText);
        show_detailsPanel.add(show_detailsshow);

    }

    void addPanels() {
        homepanel.setBounds(0, 10, 700, 400);
        frame.add(homepanel);

        show_detailsPanel.setBounds(0, 0, 700, 400);
        frame.add(show_detailsPanel);
        show_detailsPanel.setVisible(false);

        financialPanel.setBounds(0, 0, 700, 400);
        frame.add(financialPanel);
        financialPanel.setVisible(false);

        profilePanel.setBounds(0, 0, 700, 400);
        frame.add(profilePanel);
        profilePanel.setVisible(false);

        verficationPanel.setBounds(0, 0, 700, 400);
        frame.add(verficationPanel);
        verficationPanel.setVisible(false);
    }

    void addActions() {
        m1.addActionListener(h);
        m2.addActionListener(h);
        m3.addActionListener(h);
        showdetails.addActionListener(h);
        logout.addActionListener(h);
    }

    private class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logout) {
                int n = JOptionPane.showConfirmDialog(frame, "Are you sure, Want to Log out?", "Log out",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    new welcomeScreen();
                    frame.dispose();
                }
            }
            // house verfication
            else if (e.getSource() == m2) {
                homepanel.setVisible(false);
                show_detailsPanel.setVisible(false);
                financialPanel.setVisible(false);
                profilePanel.setVisible(false);
                verficationPanel.setVisible(true);
                verficationshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = verficationText.getText();
                        String sql = "SELECT c_id,c_name,address,house_verification from client where c_id=\'" + id
                                + "\';";
                        String tname = "client";
                        String[] row = { "c_id", "c_name", "address", "house_verification" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(id, sql, tname);
                        displayTable = new JTable(data, row);
                        displayTable.setBackground(Color.LIGHT_GRAY);
                        sp = new JScrollPane(displayTable);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });

            } else if (e.getSource() == showdetails) {
                homepanel.setVisible(false);
                show_detailsPanel.setVisible(true);
                financialPanel.setVisible(false);
                profilePanel.setVisible(false);
                verficationPanel.setVisible(false);
                show_detailsshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = show_detailsText.getText();
                        String sql = "SELECT c_id,c_name,address,phone_no from client where c_id=\'" + id + "\';";
                        String tname = "client";
                        String[] row = { "c_id", "c_name", "address", "phone_no" };
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

            }
            // financial
            else if (e.getSource() == m3) {
                homepanel.setVisible(false);
                show_detailsPanel.setVisible(false);
                financialPanel.setVisible(true);
                profilePanel.setVisible(false);
                verficationPanel.setVisible(false);
                financialshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = financialText.getText();
                        String sql = "SELECT c_id,c_name,financial_support from client where c_id=\'" + id + "\';";
                        String tname = "client";
                        String[] row = { "c_id", "c_name", "financial_support" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(id, sql, tname);
                        displayTable = new JTable(data, row);
                        sp = new JScrollPane(displayTable);
                        displayTable.setBackground(Color.green);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });

            }

            // project sta
            else if (e.getSource() == m1) {
                homepanel.setVisible(false);
                show_detailsPanel.setVisible(false);
                financialPanel.setVisible(false);
                profilePanel.setVisible(true);
                verficationPanel.setVisible(false);
                profileshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = profileText.getText();
                        String sql = "SELECT c_id,house_no,project_status from constructs where c_id=\'" + id + "\';";
                        String tname = "constructs";
                        String[] row = { "c_id", "house_NO", "project_Status" };
                        dbAcess obj = new dbAcess();
                        String[][] data = obj.showDetails(id, sql, tname);
                        displayTable = new JTable(data, row);
                        sp = new JScrollPane(displayTable);
                        displayTable.setBackground(Color.yellow);
                        sp.setSize(displayTable.getWidth(), displayTable.getHeight());
                        frame.add(sp);
                        sp.setBounds(0, 190, 700, 200);
                    }
                });

            }
        }
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

    }
}