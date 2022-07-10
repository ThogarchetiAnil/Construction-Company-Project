package construction_company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Manager {
    JFrame mFrame = new JFrame("Manager");
    JPanel homepanel, showdpanel, cwpanel, spanel, upanel, npanel;
    JMenuItem mi0, mi1, mi2, mi3, mi4, showdetails, logout;
    JMenu display, update, profile;
    JButton show, cshow, nshow, s_show, ushow, percent;
    JTextField stext, ctext, ntext, satext, utext, per, house;
    JTable table;
    JScrollPane sp = new JScrollPane();
    Handler h = new Handler();

    Manager() {
        // frame
        setFrame();
        // add menu
        addMenu();
        // home panel
        homepane();
        // show details panel
        Show_Details();
        // current project panel
        Current_working_project();
        // no of projects panel
        NO_of_projects();
        // salary panel
        salaryPane();
        // project status panel
        Update_Project_Status();

        addPanels();
        mFrame.setVisible(true);
        // Adding Action listners to menu items
        addActions();
    }

    void setFrame() {
        mFrame.setBounds(400, 200, 700, 400);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mFrame.setLayout(null);
    }

    void addMenu() {
        // menu bar
        JMenuBar menu = new JMenuBar();
        JMenu home = new JMenu("Home");
        // menu
        display = new JMenu("Display");
        update = new JMenu("Update");
        profile = new JMenu("Profile");

        // menu items
        mi0 = new JMenuItem("Current_working_project");
        mi1 = new JMenuItem("NO_of_Projects");
        mi2 = new JMenuItem("Salary_Status");
        mi3 = new JMenuItem("Update_Project_Status");

        showdetails = new JMenuItem("Show_Details");
        logout = new JMenuItem("LOGOUT");
        logout.setBackground(Color.RED);

        // add menu items to menu
        display.add(mi0);
        display.add(mi1);
        display.add(mi2);

        update.add(mi3);
        profile.add(showdetails);
        profile.add(logout);

        // add menu to menu bar
        // add menu to menu bar
        menu.add(home);
        home.addMenuListener(new MenuListener() {

            @Override
            public void menuSelected(MenuEvent e) {

                homepanel.setVisible(true);
                showdpanel.setVisible(false);
                cwpanel.setVisible(false);
                spanel.setVisible(false);
                upanel.setVisible(false);
                npanel.setVisible(false);
                sp.setVisible(false);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }

        });
        menu.add(display);
        menu.add(update);
        menu.add(profile);

        // add menu bar to frame
        mFrame.setJMenuBar(menu);
    }

    void homepane() {
        homepanel = new JPanel();
        homepanel.setLayout(null);

        JLabel welc = new JLabel("Welcome");
        welc.setBounds(260, 115, 150, 50);
        welc.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        homepanel.add(welc);
    }

    void Current_working_project() {
        cwpanel = new JPanel();
        cwpanel.setLayout(null);

        JLabel cwlabel = new JLabel("Manager Id:");
        ctext = new JTextField(10);

        cshow = new JButton("show");

        cwlabel.setBounds(215, 20, 100, 50);
        ctext.setBounds(335, 35, 100, 25);
        cshow.setBounds(285, 80, 90, 25);

        cwpanel.add(cwlabel);
        cwpanel.add(ctext);
        cwpanel.add(cshow);
    }

    void NO_of_projects() {
        npanel = new JPanel();
        npanel.setLayout(null);

        JLabel nlabel = new JLabel("Manager Id:");
        ntext = new JTextField(10);

        nshow = new JButton("show");

        nlabel.setBounds(215, 20, 100, 50);
        ntext.setBounds(335, 35, 100, 25);
        nshow.setBounds(285, 80, 90, 25);

        npanel.add(nlabel);
        npanel.add(ntext);
        npanel.add(nshow);
    }

    void salaryPane() {
        spanel = new JPanel();
        spanel.setLayout(null);

        JLabel saIdLabel = new JLabel("Manager Id: ");
        satext = new JTextField(10);

        s_show = new JButton("Show");

        saIdLabel.setBounds(215, 20, 100, 50);
        satext.setBounds(335, 35, 100, 25);
        s_show.setBounds(285, 80, 90, 25);

        spanel.add(saIdLabel);
        spanel.add(satext);
        spanel.add(s_show);

    }

    void Update_Project_Status() {
        upanel = new JPanel();
        upanel.setLayout(null);

        JLabel uLabel = new JLabel("House_no: ");
        utext = new JTextField(10);

        JLabel new_percentage = new JLabel("new proj_status:");
        per = new JTextField(10);

        ushow = new JButton("Show");
        // percent = new JButton("New Percentage");
        uLabel.setBounds(80, 20, 100, 50);
        new_percentage.setBounds(400, 20, 100, 50);
        utext.setBounds(170, 35, 100, 25);
        per.setBounds(530, 35, 100, 25);
        ushow.setBounds(285, 80, 90, 25);
        // percent.setBounds(385, 180, 150, 125);

        upanel.add(uLabel);
        upanel.add(utext);
        upanel.add(ushow);
        upanel.add(new_percentage);
        upanel.add(per);
        // upanel.add(percent);
    }

    void Show_Details() {
        showdpanel = new JPanel();
        showdpanel.setLayout(null);

        JLabel sIdLabel = new JLabel("Manager Id: ");
        stext = new JTextField(10);

        show = new JButton("Show");

        sIdLabel.setBounds(215, 20, 100, 50);
        stext.setBounds(335, 35, 100, 25);
        show.setBounds(285, 80, 90, 25);

        showdpanel.add(sIdLabel);
        showdpanel.add(stext);
        showdpanel.add(show);
    }

    void addPanels() {
        homepanel.setBounds(0, 10, 700, 400);
        mFrame.add(homepanel);

        showdpanel.setBounds(0, 0, 700, 400);
        mFrame.add(showdpanel);
        showdpanel.setVisible(false);

        cwpanel.setBounds(0, 0, 700, 400);
        mFrame.add(cwpanel);
        cwpanel.setVisible(false);

        spanel.setBounds(0, 0, 700, 400);
        mFrame.add(spanel);
        spanel.setVisible(false);

        upanel.setBounds(0, 0, 700, 400);
        mFrame.add(upanel);
        upanel.setVisible(false);

        npanel.setBounds(0, 0, 700, 400);
        mFrame.add(npanel);
        npanel.setVisible(false);

    }

    void addActions() {
        mi0.addActionListener(h);
        mi1.addActionListener(h);
        mi2.addActionListener(h);
        mi3.addActionListener(h);
        showdetails.addActionListener(h);
        logout.addActionListener(h);
    }

    private class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == logout) {
                int n = JOptionPane.showConfirmDialog(mFrame, "Are you sure, Want to Log out?", "Log out",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    new welcomeScreen();
                    mFrame.dispose();
                }
            }
            if (evt.getSource() == showdetails) {
                homepanel.setVisible(false);
                showdpanel.setVisible(true);
                cwpanel.setVisible(false);
                spanel.setVisible(false);
                upanel.setVisible(false);
                npanel.setVisible(false);
                sp.setVisible(false);
                show.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String id = stext.getText();
                        String sql = "SELECT e_id,e_name,workexp,no_of_proj_assg,current_proj,project_designs FROM employee natural join manager where e_id=\'"
                                + id + "\';";
                        String tname = "employee natural join manager";
                        String[] row = { "Id", "Name", "Work Exp", "No of proj", "Current Project", "Project_design" };
                        daccess obj = new daccess();
                        String[][] data = obj.showdetails(id, sql, tname);
                        table = new JTable(data, row);
                        sp = new JScrollPane(table);
                        sp.setSize(table.getWidth(), table.getHeight());
                        mFrame.add(sp);
                        sp.setBounds(0, 175, 700, 200);
                    }

                });
            }
            if (evt.getSource() == mi0) {
                homepanel.setVisible(false);
                showdpanel.setVisible(false);
                cwpanel.setVisible(true);
                spanel.setVisible(false);
                upanel.setVisible(false);
                npanel.setVisible(false);
                sp.setVisible(false);
                cshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String id = ctext.getText();
                        String sql = " SELECT current_proj from employee natural join manager where e_id=\'" + id
                                + "\';";
                        String tname = "manager";
                        String[] row = { "Current working project" };
                        daccess obj = new daccess();
                        String[][] data = obj.showdetails(id, sql, tname);
                        table = new JTable(data, row);
                        sp = new JScrollPane(table);
                        sp.setSize(table.getWidth(), table.getHeight());
                        mFrame.add(sp);
                        sp.setBounds(0, 175, 700, 200);

                    }

                });
            }

            if (evt.getSource() == mi1) {
                homepanel.setVisible(false);
                showdpanel.setVisible(false);
                cwpanel.setVisible(false);
                spanel.setVisible(false);
                upanel.setVisible(false);
                npanel.setVisible(true);
                sp.setVisible(false);
                nshow.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String id = ntext.getText();
                        String sql = "SELECT no_of_proj_assg from employee natural join manager where e_id=\'" + id
                                + "\';";
                        String tname = "manager";
                        String[] row = { "No of projects assigned" };
                        daccess obj = new daccess();
                        String[][] data = obj.showdetails(id, sql, tname);
                        table = new JTable(data, row);
                        sp = new JScrollPane(table);
                        sp.setSize(table.getWidth(), table.getHeight());
                        mFrame.add(sp);
                        sp.setBounds(0, 175, 700, 200);
                    }
                });

            }

            if (evt.getSource() == mi2) {
                homepanel.setVisible(false);
                showdpanel.setVisible(false);
                cwpanel.setVisible(false);
                spanel.setVisible(true);
                upanel.setVisible(false);
                npanel.setVisible(false);
                sp.setVisible(false);
                s_show.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String id = satext.getText();
                        String sql = "SELECT salary from employee natural join manager where e_id=\'" + id + "\';";
                        daccess obj = new daccess();
                        String salary = obj.getSalary(sql);
                        if (salary != null)
                            JOptionPane.showMessageDialog(mFrame, "Your Salary is: " + salary, "Salary", 1);
                    }

                });

            }

            if (evt.getSource() == mi3) {
                homepanel.setVisible(false);
                showdpanel.setVisible(false);
                cwpanel.setVisible(false);
                spanel.setVisible(false);
                upanel.setVisible(true);
                npanel.setVisible(false);
                sp.setVisible(false);
                ushow.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {

                        String id = utext.getText();
                        String newval = per.getText();
                        float val = Float.parseFloat(newval);
                        String sql = "UPDATE constructs SET project_status='" + val + "' WHERE house_no='" + id + "' ";
                        daccess obj = new daccess();
                        obj.update_data(sql);

                        JOptionPane.showMessageDialog(mFrame, "Updated Successfully");

                    }
                });

            }

        }

    }

    public class daccess {
        Connection connect = null;
        Statement state = null;
        PreparedStatement ps = null;

        daccess() {
            System.out.println("Opened database successfully");
            try {
                Class.forName("org.postgresql.Driver");
                connect = DriverManager.getConnection("jdbc:postgresql://localhost:5433/javaproject", "postgres",
                        "rlykodur");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
        }

        String[][] showdetails(String id, String sql, String tableName) {
            String[][] data = { {} };
            try {
                state = connect.createStatement();
                int i = 0;
                ResultSet rs = state.executeQuery(sql);
                while (rs.next()) {
                    i++;
                }
                int col = rs.getMetaData().getColumnCount();
                data = new String[i][col];
                i = 0;
                rs = state.executeQuery(sql);
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

        String getSalary(String sql) {
            String sal = "";
            try {
                state = connect.createStatement();
                ResultSet rs = state.executeQuery(sql);
                rs.next();
                sal = rs.getString("salary");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(mFrame, "Id not found,Enter valid Id and try again", "Error", 0);
                return null;
            }
            return sal;
        }

        boolean update_data(String sql) {
            try {
                state = connect.createStatement();
                state.executeQuery(sql);

            } catch (SQLException e) {
                return false;
            }
            return true;

        }
    }


}