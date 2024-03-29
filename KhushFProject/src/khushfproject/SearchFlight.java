package khushfproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class SearchFlight extends javax.swing.JFrame {

     Connection con;
    Statement smt;
    ResultSet rs;
    //public Object obj1,obj2,obj3,obj4,obj5,obj6;
    DateFormat formatter;
    Date dt,dt7;
    SimpleDateFormat sdf;
    LoginForm alllog;
    String origin=null;
    String target=null;
    String fclass=null;
    String sql=null;
    String strdtver1=null;
    String strdtver3=null;
    String search = "";
    public SearchFlight(LoginForm log1) {
        alllog=log1;
        log1.setVisible(false);
        initComponents();
        this.setLocationRelativeTo(null);
        try
        {
            Class .forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KhushFProject","root","");
        }
        catch(Exception e)
        {
         System.out.println(e.getMessage());
        }
        
    }

    private SearchFlight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Book Antiqua", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(200, 17, 27));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Khush Airlines Ltd.");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 320, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 0));
        jLabel7.setText("--->");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 30, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 0));
        jLabel8.setText("Class:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 40, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALL", "Business", "Executive", "Economy" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 110, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 0));
        jLabel10.setText("Origin:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select City", "Ahmedabad", "Chennai", "Delhi", "Jaipur", "Kolkata", "Mumbai", "Kerala" }));
        jPanel3.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, -1));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select City", "Ahmedabad", "Chennai", "Delhi", "Jaipur", "Kolkata", "Mumbai", "Kerala" }));
        jPanel3.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 170, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 0));
        jLabel11.setText("Destination:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 90, -1));

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(102, 102, 0));
        jCheckBox1.setText("Also show next 7 days schedule");
        jPanel3.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filght Name", "Departure Time", "BC Seats Available", "XC Seats Available", "EC Seats Available"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 770, 220));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("Please login for booking process...Click here for Login Window");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 771, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 443, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void checkSevenDay()
    {
        if(jCheckBox1.isSelected())
        {
            sql="SELECT a.flightno,a.bcsavailable,a.xcsavailable,a.ecsavailable,b.deptime FROM "
                    + "scheduledflights a,flights b WHERE a.flightno IN (SELECT flightno FROM flights WHERE aircrafttypeID IN "
                    + "(SELECT aircraft.aircrafttypeID FROM aircraft WHERE aircrafttypeID IN "
                    + "(SELECT aircrafttypeID FROM sector, flights WHERE source LIKE '"+ origin
                    + "' AND destination LIKE '" + target + "' AND sector.sectorID = flights.sectorID))) "
                    + "' AND '"+strdtver3+"' AND a.flightno=b.flightno ORDER BY a.flightTime";   
        }
        else
        {
            sql="SELECT  a.flightno,a.flightdate,a.bcsavailable,a.xcsavailable,a.ecsavailable,b.deptime FROM scheduledflights a,flights b WHERE a.flightno IN"
                + " (SELECT flightno FROM flights WHERE aircrafttypeID IN "
                + "(SELECT aircraft.aircrafttypeID FROM aircraft WHERE aircrafttypeID IN "
                + "(SELECT aircrafttypeID FROM sector,flights WHERE source LIKE '"+ origin 
                + "' AND destination LIKE '" + target + "' AND sector.sectorID=flights.sectorID) "+search
                + ")) AND a.flightno=b.flightno";
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final Object[] columnNames=new String[] {"Flight Name","Departure Time","BC Seats Available","XC Seats Available","EC Seats Available"};
        DefaultTableModel dtm=new DefaultTableModel(columnNames,0);
        origin=jComboBox3.getSelectedItem().toString();
        target=jComboBox4.getSelectedItem().toString();
        fclass=jComboBox1.getSelectedItem().toString();
        /**************************************
        //Seven days flight calendar processing
        **************************************/
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt7);
        cal.add(Calendar.DATE, 7);
        dt7 = cal.getTime();
       

        /***************************
        //ALL Class Processing
        ***************************/
        if(fclass.equals("ALL"))
        {
            try
            {
                smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                checkSevenDay();
                rs = smt.executeQuery(sql);
                int i = 0;
                boolean empty=true;
                String var1="", var2="", var3="", var4="", var5="";
                while(rs.next())
                {
                    empty=false;
                    var1=rs.getString(1);
                    strdtver1=(String) sdf.format(rs.getDate(2));
                    var2=Integer.toString(rs.getInt(3));
                    var3=Integer.toString(rs.getInt(4));
                    var4=Integer.toString(rs.getInt(5));
                    var5=rs.getString(6);
                    dtm.addRow(new Vector());
                    dtm.setValueAt(strdtver1, i, 0);
                    dtm.setValueAt(var1, i, 1);
                    dtm.setValueAt(var5, i, 2);
                    dtm.setValueAt(var2, i, 3);
                    dtm.setValueAt(var3, i, 4);
                    dtm.setValueAt(var4, i, 5);
                    i++;
                }
                if(empty)
                {
                    dtm.addRow(new Vector());
                  
               
                    dtm.setValueAt("No Flights", i, 1);
                    dtm.setValueAt("No Flights", i, 2);
                    dtm.setValueAt("0", i, 3);
                    dtm.setValueAt("0", i, 4);
                    dtm.setValueAt("0", i, 5);
                }
                jTable1.setModel(dtm);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        /***************************
        //Business Class Processing
        ****************************/
        if(fclass.equals("Business"))
        {
            search="AND bseats>0";
            try
            {
                smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                checkSevenDay();
                rs = smt.executeQuery(sql);
                int i = 0;
                boolean empty=true;
                String var1="", var2="", var3="", var4="", var5="";
                while(rs.next())
                {
                    empty=false;
                    var1=rs.getString(1);
                    strdtver1=(String) sdf.format(rs.getDate(2));
                    var2=Integer.toString(rs.getInt(3));
                    var3=Integer.toString(rs.getInt(4));
                    var4=Integer.toString(rs.getInt(5));
                    var5=rs.getString(6);
                    dtm.addRow(new Vector());
                    dtm.setValueAt(strdtver1, i, 0);
                    dtm.setValueAt(var1, i, 1);
                    dtm.setValueAt(var5, i, 2);
                    dtm.setValueAt(var2, i, 3);
                    dtm.setValueAt(var3, i, 4);
                    dtm.setValueAt(var4, i, 5);
                    i++;

                }
                if(empty)
                {
                    dtm.addRow(new Vector());
                 
                 
                    dtm.setValueAt("No Flights", i, 1);
                    dtm.setValueAt("No Flights", i, 2);
                    dtm.setValueAt("0", i, 3);
                    dtm.setValueAt("0", i, 4);
                    dtm.setValueAt("0", i, 5);
                }
                jTable1.setModel(dtm);
                TableColumnModel m=jTable1.getColumnModel();
                TableColumn col=m.getColumn(4);
                TableColumn col1=m.getColumn(5);
                m.removeColumn(col);
                m.removeColumn(col1);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
        /***************************
        //Executive Class Processing
        ****************************/
        if(fclass.equals("Executive"))
        {
            search="AND xseats>0";
            try
            {
                smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                checkSevenDay();
                rs = smt.executeQuery(sql);
                int i = 0;
                boolean empty=true;
                String var1="", var2="", var3="", var4="", var5="";
                while(rs.next())
                {
                    empty=false;
                    var1=rs.getString(1);
                    strdtver1=(String) sdf.format(rs.getDate(2));
                    var2=Integer.toString(rs.getInt(3));
                    var3=Integer.toString(rs.getInt(4));
                    var4=Integer.toString(rs.getInt(5));
                    var5=rs.getString(6);
                    dtm.addRow(new Vector());
                    dtm.setValueAt(strdtver1, i, 0);
                    dtm.setValueAt(var1, i, 1);
                    dtm.setValueAt(var5, i, 2);
                    dtm.setValueAt(var2, i, 3);
                    dtm.setValueAt(var3, i, 4);
                    dtm.setValueAt(var4, i, 5);
                    i++;
                }
                if(empty)
                {
                    dtm.addRow(new Vector());
               
                  
                    dtm.setValueAt("No Flights", i, 1);
                    dtm.setValueAt("No Flights", i, 2);
                    dtm.setValueAt("0", i, 3);
                    dtm.setValueAt("0", i, 4);
                    dtm.setValueAt("0", i, 5);
                }
                jTable1.setModel(dtm);
                TableColumnModel m=jTable1.getColumnModel();
                TableColumn col=m.getColumn(3);
                TableColumn col1=m.getColumn(5);
                m.removeColumn(col);
                m.removeColumn(col1);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }

        /***************************
        //Economy Class Processing
        ****************************/
        if(fclass.equals("Economy"))
        {
            search="AND eseats>0";
            try
            {
                smt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                checkSevenDay();
                rs = smt.executeQuery(sql);
                int i = 0;
                boolean empty=true;
                String var1="", var2="", var3="", var4="", var5="";
                while(rs.next())
                {
                    empty=false;
                    var1=rs.getString(1);
                    strdtver1=(String) sdf.format(rs.getDate(2));
                    var2=Integer.toString(rs.getInt(3));
                    var3=Integer.toString(rs.getInt(4));
                    var4=Integer.toString(rs.getInt(5));
                    var5=rs.getString(6);
                    dtm.addRow(new Vector());
                    dtm.setValueAt(strdtver1, i, 0);
                    dtm.setValueAt(var1, i, 1);
                    dtm.setValueAt(var5, i, 2);
                    dtm.setValueAt(var2, i, 3);
                    dtm.setValueAt(var3, i, 4);
                    dtm.setValueAt(var4, i, 5);
                    i++;
                }
                if(empty)
                {
                    dtm.addRow(new Vector());
                ;
                
                    dtm.setValueAt("No Flights", i, 1);
                    dtm.setValueAt("No Flights", i, 2);
                    dtm.setValueAt("0", i, 3);
                    dtm.setValueAt("0", i, 4);
                    dtm.setValueAt("0", i, 5);
                }
                jTable1.setModel(dtm);
                TableColumnModel m=jTable1.getColumnModel();
                TableColumn col=m.getColumn(3);
                TableColumn col1=m.getColumn(4);
                m.removeColumn(col);
                m.removeColumn(col1);
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        /*int rno=jTable1.getSelectedRow();
        obj1 = GetData(jTable1, rno, 0);
        obj2 = GetData(jTable1, rno, 1);
        obj3 = GetData(jTable1, rno, 2);
        obj4 = GetData(jTable1, rno, 3);*/
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        alllog.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(SearchFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchFlight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
