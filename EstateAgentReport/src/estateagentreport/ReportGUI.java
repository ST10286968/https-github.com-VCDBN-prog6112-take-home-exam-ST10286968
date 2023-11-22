
package estateagentreport;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;

 interface IEstateAgent {
    double calculateCommission(String propertyPrice, String agentCommission);
    boolean validateData(Data dataToValidate);
}


abstract class EstateAgent implements IEstateAgent {

    @Override
    public double calculateCommission(String propertyPrice, String agentCommission) {
        double price = Double.parseDouble(propertyPrice);
        double commissionPercentage = Double.parseDouble(agentCommission);

        return (price * commissionPercentage) / 100.0;
    }
//(Farrell, 2019)
    
    @Override
    public boolean validateData(Data dataToValidate) {
        return isNotEmpty(dataToValidate.getLocation())
                && isNotEmpty(dataToValidate.getName())
                && isPropertyPriceValid(dataToValidate.getPropertyPrice())
                && isCommissionPercentageValid(dataToValidate.getCommissionPercentage());
    }
//(Farrell, 2019)
    
    private boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
    
    //(Farrell, 2019)

    //method that checks the PropertyPrice if its 0 or below and tells the user to enter a valid price 
    private boolean isPropertyPriceValid(String propertyPrice) {
        try {
            double price = Double.parseDouble(propertyPrice);
            return price > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
//method that checks if the  commission percentage is 0 or smaller  
    private boolean isCommissionPercentageValid(String commissionPercentage) {
        try {
            double percentage = Double.parseDouble(commissionPercentage);
            return percentage > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

 //abstract class containing all the data 
abstract class Data {
    private String location;
    private String name;
    private String propertyPrice;
    private String commissionPercentage;

//getters 
    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    // Constructors, getters, and setters
    // Assume you have appropriate constructor, getters, and setters for this class
    public String getCommissionPercentage() {
        return commissionPercentage;
    }
//setters 
    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public void setCommissionPercentage(String commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public Data(String location, String name) {
        this.location = location;
        this.name = name;
    }
}

/**
 *
 * @author ibrah
 */
public class ReportGUI extends javax.swing.JFrame {

    /**
     * Creates new form ReportGUI
     */
    
    public ReportGUI() {
        initComponents();
    }

    
    private void processReport(String name, int price, double percentage){
      try {
          // report created  that print when the user clicks on process report 
            String displayReport = "AGENT LOCATION: " + LocationCombo.getSelectedItem() + "\n"
                    + "ESTATE AGENT NAME: " + name + "\n"
                    + "PROPERTY PRICE: R " + price + "\n"
                    + "COMMISSION PERCENTAGE: " + percentage + "%\n"
                    + "CALCULATED COMMISSION: R " + (price * percentage / 100.0) + "\n"
                    +"*********************************************************";

            // Display the report in the text area
            ReportArea.setText(displayReport);
            
         //(Farrell, 2019)

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //method that creates a Report.txt file which will store all the info once the user clicks "Save Report" and sends out an error message if an error occurs 
    private void saveReportToFile(String report) {
        try {
            String fileName = "Report.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(report);
            writer.close();
            JOptionPane.showMessageDialog(this, "Report saved to " + fileName, "Save Report", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving report to file", "Error", JOptionPane.ERROR_MESSAGE);
      
        //(Farrell, 2019)
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ReportArea = new javax.swing.JTextArea();
        LocationCombo = new javax.swing.JComboBox<>();
        AgentName = new javax.swing.JTextField();
        PropertyPrice = new javax.swing.JTextField();
        CommissionPercentage = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        ExitMenu = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();
        ProcessReport = new javax.swing.JMenu();
        Process = new javax.swing.JMenuItem();
        Clear = new javax.swing.JMenuItem();
        SaveReport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Estate Agent Report"); // NOI18N

        jLabel1.setText("AGENT LOCATION:");

        jLabel2.setText("ESTATE AGENT NAME:");

        jLabel3.setText("PROPERTY PRICE:");

        jLabel4.setText("COMMISSION PERCENTAGE:");

        jLabel5.setText("ESTATE AGENT REPORT:");

        ReportArea.setColumns(20);
        ReportArea.setRows(5);
        jScrollPane1.setViewportView(ReportArea);

        LocationCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cape Town", "Durban", "Pretoria" }));
        LocationCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocationComboActionPerformed(evt);
            }
        });

        AgentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgentNameActionPerformed(evt);
            }
        });

        PropertyPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropertyPriceActionPerformed(evt);
            }
        });

        CommissionPercentage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CommissionPercentageActionPerformed(evt);
            }
        });

        ExitMenu.setText("File");

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        ExitMenu.add(Exit);

        jMenuBar1.add(ExitMenu);

        ProcessReport.setText("Tools");

        Process.setText("Process Report");
        Process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessActionPerformed(evt);
            }
        });
        ProcessReport.add(Process);

        Clear.setText("Clear");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        ProcessReport.add(Clear);

        SaveReport.setText("Save Report");
        SaveReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveReportActionPerformed(evt);
            }
        });
        ProcessReport.add(SaveReport);

        jMenuBar1.add(ProcessReport);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LocationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(AgentName, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addComponent(PropertyPrice)
                                .addComponent(CommissionPercentage)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LocationCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PropertyPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CommissionPercentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Estate Agent Report\n");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessActionPerformed
        // TODO add your handling code here:
        processReport(AgentName.getText(), Integer.parseInt(PropertyPrice.getText()), Integer.parseInt(CommissionPercentage.getText()));
    }//GEN-LAST:event_ProcessActionPerformed

    //this method is in action when the user clicks on the clear option on the menu bar 
    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
         LocationCombo.setSelectedIndex(0);
        AgentName.setText("");
        PropertyPrice.setText("");
        CommissionPercentage.setText("");
        ReportArea.setText("");
    }//GEN-LAST:event_ClearActionPerformed

    //this method is used when the user clicks on the Exit option in the menu bar 
    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    //Retrives and stores the method 
    private void LocationComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocationComboActionPerformed
        // TODO add your handling code here:
        String selectedLocation = LocationCombo.getSelectedItem().toString();
        System.out.println(selectedLocation);
        
    }//GEN-LAST:event_LocationComboActionPerformed

    //Retrives and Stores the Agent name 
    private void AgentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgentNameActionPerformed
        // TODO add your handling code here:
        String name = AgentName.getText();
        
        if(name.contains("")){
            JOptionPane.showMessageDialog(AgentName, "Please enter a name", name, HEIGHT);
        }
    }//GEN-LAST:event_AgentNameActionPerformed

    //Retrives and Stores the price 
    private void PropertyPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropertyPriceActionPerformed
        // TODO add your handling code here:
    int price = Integer.parseInt(PropertyPrice.getText());
    }//GEN-LAST:event_PropertyPriceActionPerformed

    //Retrives and Stroes the commission percentage entered by the user 
    private void CommissionPercentageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CommissionPercentageActionPerformed
        // TODO add your handling code here:
       
            double percentage = Double.parseDouble(CommissionPercentage.getText());
            
    }//GEN-LAST:event_CommissionPercentageActionPerformed

    //Save the report to the file created in the begining of the code "Report.txt"
    private void SaveReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveReportActionPerformed
        // TODO add your handling code here:
        String report = ReportArea.getText();

        // Save the report to a file
        saveReportToFile(report);
    }//GEN-LAST:event_SaveReportActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AgentName;
    private javax.swing.JMenuItem Clear;
    private javax.swing.JTextField CommissionPercentage;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu ExitMenu;
    private javax.swing.JComboBox<String> LocationCombo;
    private javax.swing.JMenuItem Process;
    private javax.swing.JMenu ProcessReport;
    private javax.swing.JTextField PropertyPrice;
    private javax.swing.JTextArea ReportArea;
    private javax.swing.JMenuItem SaveReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

/*
Reference:

Farrell, J. (2019) Java Programming (Version 9) [Computer program]

Bala, R. (2011) StackOverflow() [Computer Program] 
Available at https://stackoverflow.com/questions/5118701/how-to-create-a-gui-in-java
(Accessed 22 November 2023).

PROG6112 adapted from by Fatima Sheik (PROG workshop video on teams)

*/


