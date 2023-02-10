import java.sql.*;
import javax.swing.*;
/*importing libraries */

/**
 * This is a basic admin system for a pseudo client named poised that performs various data storing and
   editing functions
 * @author Qiyam Taj
 * @version 1.4
 */

public class Poised_with_SQL_and_Swing {
    public static void main(String[] args) {
        try {
            /* Connecting to the library_db database, via the jdbc:mysql: channel on localhost */
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/poisepms?allowPublicKeyRetrieval=true&useSSL=false",
                    "otheruser",
                    "swordfish"
            );
            /* Creating a direct line to the database for running queries */
            Statement statement = connection.createStatement();
            String date = String.valueOf(java.time.LocalDate.now());
            /* creating a string for current date */
            /*creating menu */

            /*creating frame */
            JFrame menu = new JFrame();

            /*constructing frame */
            menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menu.setSize(250,380);
            menu.setTitle("Poised");
            menu.setLocationRelativeTo(null);
            menu.setLayout(null);

            /* creating buttons for menu and setting bounds */
            JButton button1 = new JButton("Generate new project");
            button1.setBounds(20, 20,200 , 30);


            JButton button2 = new JButton("Edit the deadline of task");
            button2.setBounds(20, 60,200 , 30);


            JButton button3 = new JButton("Edit total fee");
            button3.setBounds(20, 100,200 , 30);


            JButton button4 = new JButton("Edit project manager details");
            button4.setBounds(20, 140,200 , 30);

            JButton button5 = new JButton("Edit project or finalise");
            button5.setBounds(20, 180,200 , 30);


            JButton button6 = new JButton("Display complete projects");
            button6.setBounds(20, 220,200 , 30);


            JButton button7 = new JButton("Display overdue projects");
            button7.setBounds(20, 260,200 , 30);


            JButton exit = new JButton("Exit");
            exit.setBounds(20, 300,200 , 30);


            /* creating button group in order to prevent user from selecting multiple options at once */
            ButtonGroup bg = new ButtonGroup();
            bg.add(button1);
            bg.add(button2);
            bg.add(button3);
            bg.add(button4);
            bg.add(button5);
            bg.add(button6);
            bg.add(button7);
            bg.add(exit);

            /* adding buttons */
            menu.add(button1);
            menu.add(button2);
            menu.add(button3);
            menu.add(button4);
            menu.add(button5);
            menu.add(button6);
            menu.add(button7);
            menu.add(exit);


            menu.setVisible(true);

            /* adding action listeners as well as functions */
            button1.addActionListener(e -> {
                // initialising new project and role objects
                RoleInfo customer = new RoleInfo();
                RoleInfo architects = new RoleInfo();
                RoleInfo projectMg = new RoleInfo();
                RoleInfo structuralEngineer = new RoleInfo();
                ProjectInfo newProject = new ProjectInfo();

                /* setting customer info */
                customer.setName(JOptionPane.showInputDialog("Enter customer name: "));
                customer.setSurname(JOptionPane.showInputDialog("Enter customer surname: "));
                customer.setRole("Customer");
                customer.setTelNum(JOptionPane.showInputDialog("Please enter customer tell no: "));
                customer.setEmailAddress(JOptionPane.showInputDialog("Please enter email address: "));
                customer.setPhysicalAddress(JOptionPane.showInputDialog("Please enter address: "));

                /* setting architect info */
                architects.setName(JOptionPane.showInputDialog("Enter architects name: "));
                architects.setSurname(JOptionPane.showInputDialog("Enter architects surname: "));
                architects.setRole("Architect");
                architects.setTelNum(JOptionPane.showInputDialog("Please enter architects tell no: "));
                architects.setEmailAddress(JOptionPane.showInputDialog("Please enter email address: "));
                architects.setPhysicalAddress(JOptionPane.showInputDialog("Please enter address: "));

                /* setting projectMg info */
                projectMg.setName(JOptionPane.showInputDialog("Enter Project Manager name: "));
                projectMg.setSurname(JOptionPane.showInputDialog("Enter Project Manager surname: "));
                projectMg.setRole("Project Manager");
                projectMg.setTelNum(JOptionPane.showInputDialog("Please enter Project Manager tell no: "));
                projectMg.setEmailAddress(JOptionPane.showInputDialog("Please enter email address: "));
                projectMg.setPhysicalAddress(JOptionPane.showInputDialog("Please enter address: "));

                /* setting structuralEngineer info */
                structuralEngineer.setName(JOptionPane.showInputDialog("Enter Structural Engineer name: "));
                structuralEngineer.setSurname(JOptionPane.showInputDialog("Enter Structural Engineer surname: "));
                structuralEngineer.setRole("Structural Engineer");
                structuralEngineer.setTelNum(JOptionPane.showInputDialog("Please enter Structural Engineer tell no: "));
                structuralEngineer.setEmailAddress(JOptionPane.showInputDialog("Please enter email address: "));
                structuralEngineer.setPhysicalAddress(JOptionPane.showInputDialog("Please enter address: "));

                /* setting project info */
                newProject.setProjectName(JOptionPane.showInputDialog("Enter project name: "));
                newProject.setProjectNum(JOptionPane.showInputDialog("Enter project num: "));
                newProject.setBuildType(JOptionPane.showInputDialog("Enter building type: "));
                newProject.setProjectAddress(JOptionPane.showInputDialog("Enter project Address: "));
                newProject.setErfNumber(JOptionPane.showInputDialog("Enter ERF number: "));
                newProject.setTotalFee(JOptionPane.showInputDialog("Enter Total Fee: "));
                newProject.setPaidToDate(JOptionPane.showInputDialog("Enter Amount paid to date: "));
                newProject.setDeadline(JOptionPane.showInputDialog("Enter DueDate (YYYY-MM-DD): "));
                newProject.setFinalised(JOptionPane.showInputDialog("Is this project finalised (Yes/No): "));
                newProject.setComplete("No");

                /* creating formatted strings in order to use it to execute update */
                String insert_customer = String.format("""
                        INSERT INTO role_info VALUES ('%s', '%s', '%s', %s,'%s','%s',%s)
                        """,customer.getRole(),customer.getName(),customer.getSurname(),customer.getTelNum(),
                        customer.getEmailAddress(),customer.getPhysicalAddress(),newProject.getProjectNum());

                String insert_architect = String.format("""
                        INSERT INTO role_info VALUES ('%s', '%s', '%s', %s,'%s','%s',%s)
                        """,architects.getRole(),architects.getName(),architects.getSurname(),architects.getTelNum(),
                        architects.getEmailAddress(),architects.getPhysicalAddress(),newProject.getProjectNum());

                String insert_projectMg = String.format("""
                        INSERT INTO role_info VALUES ('%s', '%s', '%s', %s,'%s','%s',%s)
                        """,projectMg.getRole(),projectMg.getName(),projectMg.getSurname(),projectMg.getTelNum(),
                        projectMg.getEmailAddress(),projectMg.getPhysicalAddress(),newProject.getProjectNum());

                String insert_structuralEngineer = String.format("""
                        INSERT INTO role_info VALUES ('%s', '%s', '%s', %s,'%s','%s',%s)
                        """,structuralEngineer.getRole(),structuralEngineer.getName(),
                        structuralEngineer.getSurname(),structuralEngineer.getTelNum(),
                        structuralEngineer.getEmailAddress(),structuralEngineer.getPhysicalAddress(),
                        newProject.getProjectNum());

                String insert_newProject = String.format("""
                        INSERT INTO role_info VALUES ('%s', %s, '%s', '%s','%s',%s,%s,'%s','%s','%s')
                        """,newProject.getProjectName(),newProject.getProjectNum(),newProject.getBuildType(),
                        newProject.getProjectAddress(),newProject.getErfNumber(),newProject.getTotalFee(),
                        newProject.getPaidToDate(),newProject.getDeadline(),newProject.getFinalised(),
                        newProject.getComplete());

                try {
                    statement.executeUpdate(insert_customer);
                    statement.executeUpdate(insert_architect);
                    statement.executeUpdate(insert_projectMg);
                    statement.executeUpdate(insert_structuralEngineer);
                    statement.executeUpdate(insert_newProject);
                    JOptionPane.showMessageDialog(menu, "Information has been added to database!",
                            "Message",JOptionPane.WARNING_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(menu, "Error, data could not be added ", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                }

            });

            button2.addActionListener(e -> {
                /*Getting relevant information to update database*/
                String projectToEdit = JOptionPane.showInputDialog("Enter project num to edit date:");
                String dateChange = JOptionPane.showInputDialog("Enter new deadline (YYYY-MM-DD)");
                /*Creating string to execute update*/
                String updateDate = String.format("""
                        UPDATE project_info SET Deadline = '%s' WHERE Proj_num = %s
                        """,dateChange,projectToEdit);
                /*Executing updating*/
                try {
                    statement.executeUpdate(updateDate);
                    JOptionPane.showMessageDialog(menu, "Information has been added to database!",
                            "Message",JOptionPane.WARNING_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(menu, "Error please try again!",
                            "Warning",JOptionPane.WARNING_MESSAGE);
                }
            });

            button3.addActionListener(e -> {
                /*Getting relevant information to update database*/
                String projectToEdit = JOptionPane.showInputDialog("Enter project num total fee:");
                String totalFeeChange = JOptionPane.showInputDialog("Add updated total fee:");
                /*Creating string to execute update*/
                String updateDate = String.format("""
                        UPDATE project_info SET Deadline = '%s' WHERE Proj_num = %s
                        """,totalFeeChange,projectToEdit);
                /*Executing updating*/
                try {
                    statement.executeUpdate(updateDate);
                    JOptionPane.showMessageDialog(menu, "Information has been added to database!",
                            "Message",JOptionPane.WARNING_MESSAGE);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(menu, "Error please try again!",
                            "Warning",JOptionPane.WARNING_MESSAGE);
                }
            });

            button4.addActionListener(e -> {
               String projMg_name =  JOptionPane.showInputDialog("Enter the NAME of the Project " +
                       "manager you would like to update");
                /*Creating menu to establish what to edit*/
                JFrame projectMgMenu = new JFrame();


                /*constructing frame */
                projectMgMenu.setSize(250,300);
                projectMgMenu.setTitle("Edit menu");
                projectMgMenu.setLocationRelativeTo(null);
                projectMgMenu.setLayout(null);

                /* creating buttons for menu and setting bounds */
                JButton Mg_button1 = new JButton("Name");
                Mg_button1.setBounds(20, 20,200 , 30);


                JButton Mg_button2 = new JButton("Surname");
                Mg_button2.setBounds(20, 60,200 , 30);


                JButton Mg_button3 = new JButton("Telephone number");
                Mg_button3.setBounds(20, 100,200 , 30);


                JButton Mg_button4 = new JButton("Email");
                Mg_button4.setBounds(20, 140,200 , 30);

                JButton Mg_button5 = new JButton("Psychical Address ");
                Mg_button5.setBounds(20, 180,200 , 30);


                JButton Mg_button6 = new JButton("Assigned");
                Mg_button6.setBounds(20, 220,200 , 30);

                /* adding buttons */
                projectMgMenu.add(Mg_button1);
                projectMgMenu.add(Mg_button2);
                projectMgMenu.add(Mg_button3);
                projectMgMenu.add(Mg_button4);
                projectMgMenu.add(Mg_button5);
                projectMgMenu.add(Mg_button6);

                projectMgMenu.setVisible(true);

                /* adding action listeners as well as functions */
                Mg_button1.addActionListener(e1 -> {
                   String edit = JOptionPane.showInputDialog("Please enter the updated name:");
                    /*Creating string to execute update*/
                    String updateDate = String.format("""
                        UPDATE role_info SET Name = '%s' WHERE Name = '%s'
                        """,edit,projMg_name);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(updateDate);
                        JOptionPane.showMessageDialog(projectMgMenu, "Information has been added to database!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectMgMenu, "Error, please make sure the name " +
                                        "entered was correct",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }

                });

                Mg_button2.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated Surname:");
                    /*Creating string to execute update*/
                    String updateDate = String.format("""
                        UPDATE role_info SET Surname = '%s' WHERE Name = '%s'
                        """,edit,projMg_name);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(updateDate);
                        JOptionPane.showMessageDialog(projectMgMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectMgMenu, "Error, please make sure " +
                                        "the name to edit entered was correct",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                Mg_button3.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated Tel num:");
                    /*Creating string to execute update*/
                    String updateDate = String.format("""
                        UPDATE role_info SET Tel_num = '%s' WHERE Name = '%s'
                        """,edit,projMg_name);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(updateDate);
                        JOptionPane.showMessageDialog(projectMgMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectMgMenu, "Error, please make sure " +
                                        "the name to edit entered was correct",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                Mg_button4.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated Email");
                    /*Creating string to execute update*/
                    String updateDate = String.format("""
                        UPDATE role_info SET Email = '%s' WHERE Name = '%s'
                        """,edit,projMg_name);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(updateDate);
                        JOptionPane.showMessageDialog(projectMgMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        ex.printStackTrace();

                    }
                });

                Mg_button5.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated Address:");
                    /*Creating string to execute update*/
                    String updateDate = String.format("""
                        UPDATE role_info SET Physc_add = '%s' WHERE Name = '%s'
                        """,edit,projMg_name);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(updateDate);
                        JOptionPane.showMessageDialog(projectMgMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectMgMenu, "Error, please make sure " +
                                        "the name to edit entered was correct",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                Mg_button6.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated assigned project number:");
                    /*Creating string to execute update*/
                    String updateDate = String.format("""
                        UPDATE role_info SET Assinged_proj = %s WHERE Name = '%s'
                        """,edit,projMg_name);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(updateDate);
                        JOptionPane.showMessageDialog(projectMgMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectMgMenu, "Error, please make sure " +
                                        "the name to edit entered was correct",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });
            });

            button5.addActionListener(e -> {
                String project_num =  JOptionPane.showInputDialog("Enter project number you would like to edit:");
                /*Creating menu to establish what to edit*/
                JFrame projectUpdateMenu = new JFrame();


                /*constructing frame */
                projectUpdateMenu.setSize(250,480);
                projectUpdateMenu.setTitle("Edit menu");
                projectUpdateMenu.setLocationRelativeTo(null);
                projectUpdateMenu.setLayout(null);

                /* creating buttons for menu and setting bounds */
                JButton proj_button1 = new JButton("Project Name");
                proj_button1.setBounds(20, 20,200 , 30);

                JButton proj_button2 = new JButton("Project Number");
                proj_button2.setBounds(20, 60,200 , 30);

                JButton proj_button3 = new JButton("Building Type");
                proj_button3.setBounds(20, 100,200 , 30);

                JButton proj_button4 = new JButton("Project Address");
                proj_button4.setBounds(20, 140,200 , 30);

                JButton proj_button5 = new JButton("ERF Number");
                proj_button5.setBounds(20, 180,200 , 30);

                JButton proj_button6 = new JButton("Total Fee");
                proj_button6.setBounds(20, 220,200 , 30);

                JButton proj_button7 = new JButton("Paid to date");
                proj_button7.setBounds(20, 260,200 , 30);

                JButton proj_button8 = new JButton("Deadline");
                proj_button8.setBounds(20, 300,200 , 30);

                JButton proj_button9 = new JButton("Finalise");
                proj_button9.setBounds(20, 340,200 , 30);

                JButton proj_button10 = new JButton("Mark Complete");
                proj_button10.setBounds(20, 380,200 , 30);

                /* adding buttons */
                projectUpdateMenu.add(proj_button1);
                projectUpdateMenu.add(proj_button2);
                projectUpdateMenu.add(proj_button3);
                projectUpdateMenu.add(proj_button4);
                projectUpdateMenu.add(proj_button5);
                projectUpdateMenu.add(proj_button6);
                projectUpdateMenu.add(proj_button7);
                projectUpdateMenu.add(proj_button8);
                projectUpdateMenu.add(proj_button9);
                projectUpdateMenu.add(proj_button10);

                projectUpdateMenu.setVisible(true);

                /* adding action listeners as well as functions */
                proj_button1.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated project name:");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Proj_name = '%s' WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information has been added to database!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }

                });

                proj_button2.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated project number:");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Proj_num = %s WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                proj_button3.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated Building type:");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Build_type = '%s' WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                proj_button4.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated project address");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Proj_add = '%s' WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        ex.printStackTrace();

                    }
                });

                proj_button5.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated ERF number:");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET ERF_num = '%s' WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                proj_button6.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated total fee:");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Total_fee = %s WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                proj_button7.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated paid to date amount:");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Paid_to_date = %s WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                proj_button8.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Please enter the updated Deadline (YYYY-MM-DD):");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Deadline = '%s' WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });
                proj_button9.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Mark as finalised(Yes/No):");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Finalised = '%s' WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);
                        if(edit.equalsIgnoreCase("yes")){
                            /*Calculating Amount Due*/
                            String amountDue = String.format("""
                            SELECT Total_fee,Paid_to_date,Total_fee - Paid_to_date AS 'Amount Due' FROM project_info
                            WHERE Proj_num = %s
                            """,project_num);
                            /* Fetching project name */


                            ResultSet result1 = statement.executeQuery(amountDue);

                            while(result1.next()){
                                String amount_due = "Amount Due: " + result1.getInt("Amount Due");
                                String invoice = String.format("""
                                        Invoice for Project Number: %s
                                        %s
                                        """,amount_due,project_num);
                                JOptionPane.showMessageDialog(projectUpdateMenu, "Invoice generated!" + "\n" +
                                        invoice,
                                        "Message",JOptionPane.WARNING_MESSAGE);}


                    }

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

                proj_button10.addActionListener(e1 -> {
                    String edit = JOptionPane.showInputDialog("Mark as complete(Yes/No):");
                    /*Creating string to execute update*/
                    String update = String.format("""
                        UPDATE project_info SET Complete = '%s' WHERE Proj_num = %s
                        """,edit,project_num);
                    /*Executing updating*/
                    try {
                        statement.executeUpdate(update);
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Information updated!",
                                "Message",JOptionPane.WARNING_MESSAGE);

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(projectUpdateMenu, "Error, please make sure " +
                                        "project number was correct ",
                                "Alert",JOptionPane.WARNING_MESSAGE);
                    }
                });

            });

            button6.addActionListener(e -> {
                String completeProjectName = null;
                try {

                    /* creating formatted string in order to use it to execute update */
                    String findComplete = """
                                SELECT Proj_name FROM project_info WHERE Complete = 'Yes'
                                 """;


                    ResultSet result = statement.executeQuery(findComplete);
                    while(result.next()){
                        completeProjectName =  result.getString("Proj_name") + "\n";
                    }
                    JOptionPane.showMessageDialog(menu, "Complete projects: "+ completeProjectName,
                            "Message",JOptionPane.WARNING_MESSAGE);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });

            button7.addActionListener(e -> {
                String overdueProjects = null;
                try {

                    /* creating formatted string in order to use it to execute update and find overdue projects*/
                    String findOverdue = """
                            SELECT * FROM project_info
                            WHERE Deadline < NOW()
                            ORDER BY Deadline ASC
                            """;


                    ResultSet result = statement.executeQuery(findOverdue);
                    while(result.next()){
                        overdueProjects =  result.getString("Proj_name") + "\n";
                    }
                    JOptionPane.showMessageDialog(menu, "Overdue projects: "+ overdueProjects,
                            "Message",JOptionPane.WARNING_MESSAGE);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            });

            exit.addActionListener(e -> {
                JOptionPane.showMessageDialog(menu,"Have a wonderful day!");
                System.exit(0);
            });

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

}