import java.awt.Color;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class homeDashboard extends javax.swing.JFrame {
    String currentColor = "jPanel_dashboard";
  
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    Statement st=null;
    
    public homeDashboard() {
        
        initComponents();
        customer();
        showVehicleData();
        serviceDetail();
        repairingData();
        cleaningVehicle();
        CustomersPanel.setVisible(false);
        CleanPanel.setVisible(false);
        ServicePanel.setVisible(false);
        VehiclesPanel.setVisible(false);
        RepairingPanel.setVisible(false);
        CreditsPanel.setVisible(false);
        Template.setVisible(false);
        searchBox.setBackground(new java.awt.Color(0,0,0,1));
        serachBox.setBackground(new java.awt.Color(0,0,0,1));
        serchBox.setBackground(new java.awt.Color(0,0,0,1));
        searchBox1.setBackground(new java.awt.Color(0,0,0,1));
        searchBox2.setBackground(new java.awt.Color(0,0,0,1));
        
    }
    public void customer(){
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
        String sql = "SELECT * FROM `customermanage`";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        DefaultTableModel tb = (DefaultTableModel) custTableData.getModel();
        tb.setRowCount(0);

        while (rs.next()) {
            Vector v = new Vector();
            v.add(rs.getString("custName"));
            v.add(rs.getString("custEmail"));
            v.add(rs.getString("custContact"));
            v.add(rs.getString("custAddress"));

            tb.addRow(v);
        }

    } catch (SQLException ex) {
        Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void showVehicleData(){
        
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
        String sql="SELECT * FROM vehicledetails";
      pst=con.prepareStatement(sql);
      rs=pst.executeQuery();
      
  DefaultTableModel tb=(DefaultTableModel)vehicleDetailTable.getModel();
          tb.setRowCount(0);
 while(rs.next()){
         Vector v = new Vector();
         v.add(rs.getString(1));
         v.add(rs.getString(2));    
         v.add(rs.getString(3));
         v.add(rs.getString(4));
         v.add(rs.getString(5));
         v.add(rs.getString(6));
          
                     
tb.addRow(v);         
     }

    } catch (SQLException ex) {
      
                  JOptionPane.showMessageDialog(null, ex);
    }
  
    }
    public void serviceDetail(){
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            String sql="SELECT * FROM `addtoservice`";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            DefaultTableModel tb=(DefaultTableModel)serviceDetails.getModel();
            tb.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                
                
                
                tb.addRow(v);
                
                
                
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
     
 
    }
    public void repairingData(){
                 try {
                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
                DefaultTableModel tb=(DefaultTableModel)repairingTable.getModel();
                tb.setRowCount(0);

              String sql="SELECT * FROM `repairing`";
              

              pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
             while(rs.next()){
                 Vector v = new Vector();
                 v.add(rs.getString(1));
              v.add(rs.getString(2));
              v.add(rs.getString(3));
              v.add(rs.getString(4));
                      
              tb.addRow(v);
                 
             
             
             
             }
             
             
             
         } catch (SQLException ex) {
             Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    public void cleaningVehicle(){
        
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
        String sql="SELECT * FROM `cleaning`";
      pst=con.prepareStatement(sql);
      rs=pst.executeQuery();
      
  DefaultTableModel tb=(DefaultTableModel)cleaningTable.getModel();
          tb.setRowCount(0);
 while(rs.next()){
              Vector v = new Vector();
             v.add(rs.getString(1));
         v.add(rs.getString(2));    
         v.add(rs.getString(3));
          v.add(rs.getString(4));
                    
tb.addRow(v);         
     }

    } catch (SQLException ex) {
      
                  JOptionPane.showMessageDialog(null, ex);
    }
  

    }
    
    //SEARCH METHOD FOR CUSTOMERS
    public ResultSet CustomerSearch(String name){
    try {
        String query="SELECT * FROM `customermanage` WHERE custName='"+name+"'";
        Statement st;
        st=con.createStatement();
        rs=st.executeQuery(query);
    } catch (SQLException ex) {
        Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
    }
    
    // SEARCH METHOD FOR VEHICLES
   public ResultSet VehicleSearch(String name) {
    try {
        String query = "SELECT * FROM vehicledetails WHERE OwnerName=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        rs = pst.executeQuery();
    } catch (SQLException ex) {
        Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
}
    
   // SEARCH METHOD FOR SERVICES
    public ResultSet ServiceSearch(String name){
    try {
        String qury="SELECT * FROM `addtoservice` WHERE owner='"+name+"'";
        Statement st;
        st=con.createStatement();
        rs=st.executeQuery(qury);
    } catch (SQLException ex) {
        Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
    }
   
   // SEARCH METHOD FOR REPAIRING
    public ResultSet RepairSearch(int num){
    try {
        String qury="SELECT * FROM `repairing` WHERE VehicleNum='"+num+"'";
        Statement st;
        st=con.createStatement();
        rs=st.executeQuery(qury);
    } catch (SQLException ex) {
        Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;

    }
    
   // SEARCH METHOD FOR CLEANING
   public ResultSet CleanSearch(String name){
    try {
        String qury="SELECT * FROM `cleaning` WHERE ownerName='"+name+"'";
        Statement st;
        st=con.createStatement();
        rs=st.executeQuery(qury);
        
//        rs=st.executeQuery(sql)
    } catch (SQLException ex) {
        Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;

    
    
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        DashboardPanel = new javax.swing.JPanel();
        LogoutLabel = new javax.swing.JLabel();
        CustLabel = new javax.swing.JLabel();
        VehicleLabel = new javax.swing.JLabel();
        ServiceLabel = new javax.swing.JLabel();
        RepairLabel = new javax.swing.JLabel();
        CleanLabel = new javax.swing.JLabel();
        CreditLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        WelcomePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Template = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        CustomersPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        custCont = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        custAdd = new javax.swing.JTextArea();
        custAddData = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        CustNameLabel = new javax.swing.JLabel();
        custName = new javax.swing.JTextField();
        CustEmailLabel = new javax.swing.JLabel();
        custEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        searchBox = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        custTableData = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        VehiclesPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ownerName = new javax.swing.JTextField();
        vehicleComb = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        vehicleModel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ownerNic = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        updateBtn1 = new javax.swing.JButton();
        deleteBtn1 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        addVehicle = new javax.swing.JButton();
        VehicleNum = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        VehicleID = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        searchBtn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vehicleDetailTable = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        serachBox = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        ServicePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        ownerName1 = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        deleteBtn2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        serviceType = new javax.swing.JComboBox<>();
        serviceId = new javax.swing.JTextField();
        clearAll = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        vehicleNum = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        vehModel = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        serchBox = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        serviceDetails = new javax.swing.JTable();
        searchBtn2 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        RepairingPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        address = new javax.swing.JTextArea();
        jLabel30 = new javax.swing.JLabel();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        AddBtn = new javax.swing.JButton();
        ownerName2 = new javax.swing.JTextField();
        updateBtn2 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        clearAll1 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        deleteBtn3 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        vehicleNo = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        searchBox1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        repairingTable = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        CleanPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        owner = new javax.swing.JTextField();
        contact1 = new javax.swing.JTextField();
        vehicleNumb = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        serviceType1 = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        updateBtn3 = new javax.swing.JButton();
        deleteBtn4 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        searchBox2 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        cleaningTable = new javax.swing.JTable();
        searchBtn3 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        CreditsPanel = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/border-f.png"))); // NOI18N

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/border-f.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DashboardPanel.setBackground(new java.awt.Color(21, 135, 102));
        DashboardPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(21, 135, 108)));
        DashboardPanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        DashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoutLabel.setBackground(new java.awt.Color(255, 255, 255));
        LogoutLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LogoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        LogoutLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LogoutLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logout.png"))); // NOI18N
        LogoutLabel.setText("Logout");
        LogoutLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 23, 0, 0));
        LogoutLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutLabel.setIconTextGap(15);
        LogoutLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutLabelMouseClicked(evt);
            }
        });
        DashboardPanel.add(LogoutLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 220, 40));

        CustLabel.setBackground(new java.awt.Color(21, 102, 80));
        CustLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CustLabel.setForeground(new java.awt.Color(255, 255, 255));
        CustLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CustLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer.png"))); // NOI18N
        CustLabel.setText("Customers");
        CustLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        CustLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CustLabel.setDoubleBuffered(true);
        CustLabel.setIconTextGap(15);
        CustLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CustLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CustLabelMouseExited(evt);
            }
        });
        DashboardPanel.add(CustLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 40));

        VehicleLabel.setBackground(new java.awt.Color(255, 255, 255));
        VehicleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        VehicleLabel.setForeground(new java.awt.Color(255, 255, 255));
        VehicleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        VehicleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/car.png"))); // NOI18N
        VehicleLabel.setText("Vehicles");
        VehicleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        VehicleLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        VehicleLabel.setIconTextGap(15);
        VehicleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VehicleLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VehicleLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VehicleLabelMouseExited(evt);
            }
        });
        DashboardPanel.add(VehicleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 220, 40));

        ServiceLabel.setBackground(new java.awt.Color(255, 255, 255));
        ServiceLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ServiceLabel.setForeground(new java.awt.Color(255, 255, 255));
        ServiceLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ServiceLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/customer-service.png"))); // NOI18N
        ServiceLabel.setText("Add to Service");
        ServiceLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        ServiceLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ServiceLabel.setIconTextGap(15);
        ServiceLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ServiceLabelMouseClicked(evt);
            }
        });
        DashboardPanel.add(ServiceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, 40));

        RepairLabel.setBackground(new java.awt.Color(255, 255, 255));
        RepairLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RepairLabel.setForeground(new java.awt.Color(255, 255, 255));
        RepairLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RepairLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/support.png"))); // NOI18N
        RepairLabel.setText("Repairing");
        RepairLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        RepairLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RepairLabel.setIconTextGap(15);
        RepairLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RepairLabelMouseClicked(evt);
            }
        });
        DashboardPanel.add(RepairLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 220, 40));

        CleanLabel.setBackground(new java.awt.Color(255, 255, 255));
        CleanLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CleanLabel.setForeground(new java.awt.Color(255, 255, 255));
        CleanLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CleanLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/car-wash.png"))); // NOI18N
        CleanLabel.setText("Cleaning");
        CleanLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        CleanLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CleanLabel.setIconTextGap(15);
        CleanLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CleanLabelMouseClicked(evt);
            }
        });
        DashboardPanel.add(CleanLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 220, 40));

        CreditLabel.setBackground(new java.awt.Color(255, 255, 255));
        CreditLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CreditLabel.setForeground(new java.awt.Color(255, 255, 255));
        CreditLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CreditLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/programming-code-signs.png"))); // NOI18N
        CreditLabel.setText("Credits");
        CreditLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 0));
        CreditLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CreditLabel.setIconTextGap(15);
        CreditLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreditLabelMouseClicked(evt);
            }
        });
        DashboardPanel.add(CreditLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 220, 40));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myimgmains/logo.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        DashboardPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 110));

        jLabel1.setBackground(new java.awt.Color(21, 105, 105));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(21, 120, 90));
        jLabel1.setText("_______________________");
        DashboardPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, -1));

        getContentPane().add(DashboardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 786));

        WelcomePanel.setBackground(new java.awt.Color(255, 255, 255));
        WelcomePanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        WelcomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 2, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        WelcomePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 11, -1, 54));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dash2.png"))); // NOI18N
        WelcomePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 820, 470));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(21, 135, 108));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("We'll keep your engine purring, so you can keep on cruising.");
        WelcomePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 520, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(21, 135, 108));
        jLabel6.setText("WELCOME TO CAR SERVICES!");
        WelcomePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel49.setBackground(new java.awt.Color(0, 0, 0));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("X");
        jLabel49.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });
        WelcomePanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 60, 50));

        getContentPane().add(WelcomePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -1, 1150, 790));

        Template.setBackground(new java.awt.Color(21, 100, 100));
        Template.setMaximumSize(new java.awt.Dimension(1366, 786));
        Template.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(30, 112, 85));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Template.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 790));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Template.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 630, 790));

        getContentPane().add(Template, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 1150, 786));

        CustomersPanel.setBackground(new java.awt.Color(21, 100, 100));
        CustomersPanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        CustomersPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(30, 112, 85));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(custCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 200, 42));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 154, 34));

        custAdd.setColumns(20);
        custAdd.setRows(5);
        jScrollPane1.setViewportView(custAdd);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 200, -1));

        custAddData.setBackground(new java.awt.Color(255, 255, 255));
        custAddData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        custAddData.setForeground(new java.awt.Color(21, 135, 102));
        custAddData.setText("Add");
        custAddData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        custAddData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custAddDataActionPerformed(evt);
            }
        });
        jPanel1.add(custAddData, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 390, 42));

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(21, 135, 102));
        deleteBtn.setText("Delete");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 200, 40));

        updateBtn.setBackground(new java.awt.Color(255, 255, 255));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(21, 135, 102));
        updateBtn.setText("Edit");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 170, 42));

        CustNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        CustNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        CustNameLabel.setText("Name:");
        jPanel1.add(CustNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 154, 34));
        jPanel1.add(custName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 202, 43));

        CustEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        CustEmailLabel.setForeground(new java.awt.Color(255, 255, 255));
        CustEmailLabel.setText("Email:");
        jPanel1.add(CustEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 154, 34));
        jPanel1.add(custEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 200, 45));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contact:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 154, 34));

        CustomersPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 790));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myimgmains/customer-1.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 310, 620, 360));

        searchBtn.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass.png"))); // NOI18N
        searchBtn.setBorder(null);
        searchBtn.setBorderPainted(false);
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.setOpaque(false);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        jPanel2.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 40, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Customer Name:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 154, 34));

        searchBox.setBorder(null);
        jPanel2.add(searchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, 30));

        custTableData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        custTableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Contact", "Address"
            }
        ));
        custTableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custTableDataMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(custTableData);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 540, 186));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(21, 100, 108));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("____________");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel5.setOpaque(true);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 570, 40));

        CustomersPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 630, 790));

        getContentPane().add(CustomersPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 1150, 786));

        VehiclesPanel.setBackground(new java.awt.Color(21, 100, 100));
        VehiclesPanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        VehiclesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(30, 112, 85));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 200, 34));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Owner NIC:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 34));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Date:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 89, 34));
        jPanel5.add(ownerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 200, 34));

        vehicleComb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cleaning", "Tyre Cahnging", "Spare parts" }));
        jPanel5.add(vehicleComb, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 200, 34));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Owner Name:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 34));
        jPanel5.add(vehicleModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 200, 34));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Vehicle Model:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, 34));
        jPanel5.add(ownerNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 200, 34));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Fuel Type:");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, 34));

        updateBtn1.setBackground(new java.awt.Color(255, 255, 255));
        updateBtn1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn1.setForeground(new java.awt.Color(21, 135, 102));
        updateBtn1.setText("Update");
        updateBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn1ActionPerformed(evt);
            }
        });
        jPanel5.add(updateBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 643, 180, 40));

        deleteBtn1.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn1.setForeground(new java.awt.Color(21, 135, 102));
        deleteBtn1.setText("Delete");
        deleteBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn1ActionPerformed(evt);
            }
        });
        jPanel5.add(deleteBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 643, 180, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Vehicle Number:");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 154, 34));

        addVehicle.setBackground(new java.awt.Color(255, 255, 255));
        addVehicle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addVehicle.setForeground(new java.awt.Color(21, 135, 102));
        addVehicle.setText("Add");
        addVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVehicleActionPerformed(evt);
            }
        });
        jPanel5.add(addVehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 583, 380, 40));

        VehicleNum.setBackground(new java.awt.Color(240, 240, 240));
        jPanel5.add(VehicleNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 200, 34));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(30, 112, 85));
        jLabel29.setText("Vehicle ID:");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 154, 34));

        VehicleID.setEditable(false);
        VehicleID.setBackground(new java.awt.Color(30, 112, 85));
        VehicleID.setForeground(new java.awt.Color(30, 112, 85));
        VehicleID.setBorder(null);
        jPanel5.add(VehicleID, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 200, 34));

        VehiclesPanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 790));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myimgmains/vehicle-small.png"))); // NOI18N
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 400, 620, 332));

        searchBtn1.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchBtn1.setForeground(new java.awt.Color(240, 240, 240));
        searchBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass.png"))); // NOI18N
        searchBtn1.setBorder(null);
        searchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn1ActionPerformed(evt);
            }
        });
        jPanel6.add(searchBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 40, 40));

        vehicleDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Vehicle Num", "Owner NIC", "Owner Name", "Vehicle Model", "Fuel Type"
            }
        ));
        vehicleDetailTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vehicleDetailTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(vehicleDetailTable);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 200, 530, 229));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Owner Name:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 154, 34));

        serachBox.setBackground(new java.awt.Color(240, 240, 240));
        serachBox.setBorder(null);
        jPanel6.add(serachBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 215, 34));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(21, 100, 108));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("____________");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel15.setOpaque(true);
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 570, 40));

        VehiclesPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 630, 790));

        getContentPane().add(VehiclesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 1150, 786));

        ServicePanel.setBackground(new java.awt.Color(21, 100, 100));
        ServicePanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        ServicePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(30, 112, 85));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ownerName1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(ownerName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 171, 36));

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(21, 135, 102));
        addBtn.setText("Add to Service");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel7.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 533, 380, 40));

        deleteBtn2.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn2.setForeground(new java.awt.Color(21, 135, 102));
        deleteBtn2.setText("Delete");
        deleteBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn2ActionPerformed(evt);
            }
        });
        jPanel7.add(deleteBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 583, 180, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Service ID:");
        jPanel7.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 122, 36));

        serviceType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serviceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fuel Change", "Spare parts" }));
        jPanel7.add(serviceType, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 171, 36));

        serviceId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(serviceId, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 171, 36));

        clearAll.setBackground(new java.awt.Color(255, 255, 255));
        clearAll.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clearAll.setForeground(new java.awt.Color(21, 135, 102));
        clearAll.setText("Clear Alll");
        clearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAllActionPerformed(evt);
            }
        });
        jPanel7.add(clearAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 583, 170, 40));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Vehicle Number:");
        jPanel7.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 181, 36));

        vehicleNum.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(vehicleNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 171, 36));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Model:");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 122, 36));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Owner Name:");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, 36));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Service Type:");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 144, 36));

        vehModel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel7.add(vehModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 171, 36));

        ServicePanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 790));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setText("Owner Name:");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 122, 36));

        serchBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        serchBox.setBorder(null);
        jPanel8.add(serchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 221, 40));

        serviceDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Service Id", "Vehicle", "Model", "Name", "Service Type"
            }
        ));
        serviceDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceDetailsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(serviceDetails);

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 540, 241));

        searchBtn2.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchBtn2.setForeground(new java.awt.Color(240, 240, 240));
        searchBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass.png"))); // NOI18N
        searchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn2ActionPerformed(evt);
            }
        });
        jPanel8.add(searchBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 40, 40));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myimgmains/Fuel-small.png"))); // NOI18N
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 571, 283));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(21, 100, 108));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel28.setText("____________");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel28.setOpaque(true);
        jPanel8.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 570, 40));

        ServicePanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 630, 790));

        getContentPane().add(ServicePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 1150, 786));

        RepairingPanel.setBackground(new java.awt.Color(21, 100, 100));
        RepairingPanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        RepairingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(30, 112, 85));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        address.setColumns(20);
        address.setRows(5);
        jScrollPane5.setViewportView(address);

        jPanel9.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 270, 90));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Date:");
        jPanel9.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 131, 39));
        jPanel9.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 270, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Owner Name:");
        jPanel9.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 130, 41));

        AddBtn.setBackground(new java.awt.Color(255, 255, 255));
        AddBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AddBtn.setForeground(new java.awt.Color(21, 135, 108));
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel9.add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 200, 44));

        ownerName2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel9.add(ownerName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 270, 40));

        updateBtn2.setBackground(new java.awt.Color(255, 255, 255));
        updateBtn2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn2.setForeground(new java.awt.Color(21, 135, 108));
        updateBtn2.setText("Update");
        updateBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn2ActionPerformed(evt);
            }
        });
        jPanel9.add(updateBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 210, 44));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Vehicle No:");
        jPanel9.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 131, 39));

        clearAll1.setBackground(new java.awt.Color(255, 255, 255));
        clearAll1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clearAll1.setForeground(new java.awt.Color(21, 135, 108));
        clearAll1.setText("Clear All");
        clearAll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearAll1ActionPerformed(evt);
            }
        });
        jPanel9.add(clearAll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 210, 44));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Contact No:");
        jPanel9.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 131, 39));

        deleteBtn3.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn3.setForeground(new java.awt.Color(21, 135, 108));
        deleteBtn3.setText("Delete");
        deleteBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn3ActionPerformed(evt);
            }
        });
        jPanel9.add(deleteBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 590, 200, 44));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Address:");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 131, 39));

        vehicleNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel9.add(vehicleNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 270, 40));

        contact.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel9.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 270, 40));

        RepairingPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 790));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(240, 240, 240));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 40, 40));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setText("Vehicle Number:");
        jPanel10.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 146, 40));

        searchBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchBox1.setBorder(null);
        jPanel10.add(searchBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 40));

        repairingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Owner", "vehicle Number", "Contact No.", "Address"
            }
        ));
        repairingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repairingTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(repairingTable);

        jPanel10.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 550, 242));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myimgmains/crash-small.png"))); // NOI18N
        jPanel10.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 410, 582, 261));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(21, 100, 108));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel37.setText("____________");
        jLabel37.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel37.setOpaque(true);
        jPanel10.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 570, 40));

        RepairingPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 630, 790));

        getContentPane().add(RepairingPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 1150, 786));

        CleanPanel.setBackground(new java.awt.Color(21, 100, 100));
        CleanPanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        CleanPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(30, 112, 85));
        jPanel11.setForeground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Vehicle Num:");
        jPanel11.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Contact No:");
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        owner.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel11.add(owner, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 188, 42));

        contact1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel11.add(contact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 188, 42));

        vehicleNumb.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel11.add(vehicleNumb, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 188, 42));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Service Type:");
        jPanel11.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        serviceType1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        serviceType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cleaning", "Booking" }));
        jPanel11.add(serviceType1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 188, 38));

        addButton.setBackground(new java.awt.Color(255, 255, 255));
        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setForeground(new java.awt.Color(21, 135, 108));
        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel11.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 180, 40));

        updateBtn3.setBackground(new java.awt.Color(255, 255, 255));
        updateBtn3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        updateBtn3.setForeground(new java.awt.Color(21, 135, 108));
        updateBtn3.setText("Update");
        updateBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn3ActionPerformed(evt);
            }
        });
        jPanel11.add(updateBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 190, 40));

        deleteBtn4.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        deleteBtn4.setForeground(new java.awt.Color(21, 135, 108));
        deleteBtn4.setText("Delete");
        deleteBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn4ActionPerformed(evt);
            }
        });
        jPanel11.add(deleteBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, 190, 40));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Owner Name:");
        jPanel11.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(21, 135, 108));
        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 180, 40));

        CleanPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 790));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel42.setText("Owner Name:");
        jPanel12.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 66));

        searchBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchBox2.setBorder(null);
        jPanel12.add(searchBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 220, 40));

        cleaningTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Owner Name", "Vehicle Model", "Contact", "Service Type"
            }
        ));
        cleaningTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cleaningTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(cleaningTable);

        jPanel12.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 551, 203));

        searchBtn3.setBackground(new java.awt.Color(255, 255, 255));
        searchBtn3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchBtn3.setForeground(new java.awt.Color(240, 240, 240));
        searchBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/magnifying-glass.png"))); // NOI18N
        searchBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtn3ActionPerformed(evt);
            }
        });
        jPanel12.add(searchBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 50, 50));

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/myimgmains/Car-wash-small-final.png"))); // NOI18N
        jPanel12.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 550, 325));

        jLabel44.setBackground(new java.awt.Color(255, 255, 255));
        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(21, 100, 108));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("____________");
        jLabel44.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel44.setOpaque(true);
        jPanel12.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 570, 40));

        CleanPanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 630, 790));

        getContentPane().add(CleanPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 1150, 786));

        CreditsPanel.setBackground(new java.awt.Color(0, 0, 0));
        CreditsPanel.setMaximumSize(new java.awt.Dimension(1366, 786));
        CreditsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Castellar", 0, 30)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Sir Irfan ali kandhro");
        CreditsPanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 710, -1, -1));

        jLabel51.setFont(new java.awt.Font("Gabriola", 1, 45)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(28, 221, 95));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Designed and Developed By:");
        CreditsPanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 210, 470, -1));

        jLabel52.setFont(new java.awt.Font("Gabriola", 0, 36)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(28, 221, 95));
        jLabel52.setText("Requested By:");
        CreditsPanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 660, -1, -1));

        jLabel50.setFont(new java.awt.Font("Castellar", 0, 30)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Faaiz Amir  - CSC-23S-275");
        CreditsPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 480, -1));

        jLabel53.setFont(new java.awt.Font("Castellar", 0, 30)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("Imtiaz khan Jadoon  - CSC-23S-297");
        CreditsPanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 640, -1));

        jLabel54.setFont(new java.awt.Font("Castellar", 0, 30)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Imsil nadeem - CSC-23S-267");
        CreditsPanel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 480, -1));

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg.jpg"))); // NOI18N
        CreditsPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 790));

        getContentPane().add(CreditsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 0, 1150, 786));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//    ------------------------------ BUTTONS ----------------------------------    
    
        // LOG-OUT BUTTON
    private void LogoutLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutLabelMouseClicked

        LoginSignUp logout = new LoginSignUp();
        logout.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_LogoutLabelMouseClicked

        // CUSTOMER BUTTON
    private void CustLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustLabelMouseClicked
        // TODO add your handling code here:
          
         currentColor = "jPanel_dashboard";
       CustLabel.setBackground(new java.awt.Color(65,204,173));

        CustomersPanel.setVisible(true);
//        CustomersPanel.setVisible(false);
        CleanPanel.setVisible(false);
        ServicePanel.setVisible(false);
        VehiclesPanel.setVisible(false);
        RepairingPanel.setVisible(false);
        CreditsPanel.setVisible(false);
        WelcomePanel.setVisible(false);
        
         CustLabel.setOpaque(true);
         CustLabel.setBackground(Color.decode("#155A3C"));
         
         LogoutLabel.setOpaque(false);
         LogoutLabel.setBackground(null);
         
         VehicleLabel.setOpaque(false);
         VehicleLabel.setBackground(null);
         
         ServiceLabel.setOpaque(false);
         ServiceLabel.setBackground(null);
         
         RepairLabel.setOpaque(false);
         RepairLabel.setBackground(null);
         
         CleanLabel.setOpaque(false);
         CleanLabel.setBackground(null);
         
         CreditLabel.setOpaque(false);
         CreditLabel.setBackground(null);
         
         WelcomePanel.setVisible(false);
         CustomersPanel.setVisible(true);
    }//GEN-LAST:event_CustLabelMouseClicked

        // VEHICLE BUTTON
    private void VehicleLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VehicleLabelMouseClicked

        // TODO add your handling code here:
      currentColor = "jPanel_dashboard";
       VehicleLabel.setBackground(new java.awt.Color(65,204,173));


        VehiclesPanel.setVisible(true);
        CustomersPanel.setVisible(false);
        CleanPanel.setVisible(false);
        ServicePanel.setVisible(false);
//        VehiclesPanel.setVisible(false);
        RepairingPanel.setVisible(false);
        CreditsPanel.setVisible(false);
        WelcomePanel.setVisible(false);
        
         VehicleLabel.setOpaque(true);
         VehicleLabel.setBackground(Color.decode("#155A3C"));
        
         LogoutLabel.setOpaque(false);
         LogoutLabel.setBackground(null);
         
         
         CustLabel.setOpaque(false);
         CustLabel.setBackground(null);
         
         ServiceLabel.setOpaque(false);
         ServiceLabel.setBackground(null);
         
         RepairLabel.setOpaque(false);
         RepairLabel.setBackground(null);
         
         CleanLabel.setOpaque(false);
         CleanLabel.setBackground(null);
         
         CreditLabel.setOpaque(false);
         CreditLabel.setBackground(null);
    }//GEN-LAST:event_VehicleLabelMouseClicked

        // SERVICE BUTTON
    private void ServiceLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServiceLabelMouseClicked
        // TODO add your handling code here:
        WelcomePanel.setVisible(false);
        ServicePanel.setVisible(true);
        CustomersPanel.setVisible(false);
        CleanPanel.setVisible(false);
//        ServicePanel.setVisible(false);
        VehiclesPanel.setVisible(false);
        RepairingPanel.setVisible(false);
        CreditsPanel.setVisible(false);
        
        ServiceLabel.setOpaque(true);
        ServiceLabel.setBackground(Color.decode("#155A3C"));
        
         LogoutLabel.setOpaque(false);
         LogoutLabel.setBackground(null);
         
         CustLabel.setOpaque(false);
         CustLabel.setBackground(null);
         
         VehicleLabel.setOpaque(false);
         VehicleLabel.setBackground(null);
         
         RepairLabel.setOpaque(false);
         RepairLabel.setBackground(null);
         
         CleanLabel.setOpaque(false);
         CleanLabel.setBackground(null);
         
         CreditLabel.setOpaque(false);
         CreditLabel.setBackground(null);
    }//GEN-LAST:event_ServiceLabelMouseClicked

        // REPAIR BUTTON
    private void RepairLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RepairLabelMouseClicked
        // TODO add your handling code here:
        WelcomePanel.setVisible(false);
        RepairingPanel.setVisible(true);
        CustomersPanel.setVisible(false);
        CleanPanel.setVisible(false);
        ServicePanel.setVisible(false);
        VehiclesPanel.setVisible(false);
//        RepairingPanel.setVisible(false);
        CreditsPanel.setVisible(false);
        
        RepairLabel.setOpaque(true);
        RepairLabel.setBackground(Color.decode("#155A3C"));
        
         LogoutLabel.setOpaque(false);
         LogoutLabel.setBackground(null);
         
         CustLabel.setOpaque(false);
         CustLabel.setBackground(null);
         
         VehicleLabel.setOpaque(false);
         VehicleLabel.setBackground(null);
         
         ServiceLabel.setOpaque(false);
         ServiceLabel.setBackground(null);
         
         CleanLabel.setOpaque(false);
         CleanLabel.setBackground(null);
         
         CreditLabel.setOpaque(false);
         CreditLabel.setBackground(null);
    }//GEN-LAST:event_RepairLabelMouseClicked

        // CLEAN BUTTON
    private void CleanLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CleanLabelMouseClicked
        // TODO add your handling code here:
        WelcomePanel.setVisible(false);
        CleanPanel.setVisible(true);
        CustomersPanel.setVisible(false);
//        CleanPanel.setVisible(false);
        ServicePanel.setVisible(false);
        VehiclesPanel.setVisible(false);
        RepairingPanel.setVisible(false);
        CreditsPanel.setVisible(false);
        
        CleanLabel.setOpaque(true);
        CleanLabel.setBackground(Color.decode("#155A3C"));
        
         LogoutLabel.setOpaque(false);
         LogoutLabel.setBackground(null);
         
         CustLabel.setOpaque(false);
         CustLabel.setBackground(null);
         
         VehicleLabel.setOpaque(false);
         VehicleLabel.setBackground(null);
         
         ServiceLabel.setOpaque(false);
         ServiceLabel.setBackground(null);
         
         RepairLabel.setOpaque(false);
         RepairLabel.setBackground(null);
         
         
         CreditLabel.setOpaque(false);
         CreditLabel.setBackground(null);
    }//GEN-LAST:event_CleanLabelMouseClicked

        // CREDIT BUTTON
    private void CreditLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreditLabelMouseClicked
        // TODO add your handling code here:
        WelcomePanel.setVisible(false);
        CreditsPanel.setVisible(true);
        CustomersPanel.setVisible(false);
        CleanPanel.setVisible(false);
        ServicePanel.setVisible(false);
        VehiclesPanel.setVisible(false);
        RepairingPanel.setVisible(false);
//        CreditsPanel.setVisible(false);
        
        CreditLabel.setOpaque(true);
        CreditLabel.setBackground(Color.decode("#155A3C"));
        
         LogoutLabel.setOpaque(false);
         LogoutLabel.setBackground(null);
         
         CustLabel.setOpaque(false);
         CustLabel.setBackground(null);
         
         VehicleLabel.setOpaque(false);
         VehicleLabel.setBackground(null);
         
         ServiceLabel.setOpaque(false);
         ServiceLabel.setBackground(null);
         
         RepairLabel.setOpaque(false);
         RepairLabel.setBackground(null);
         
         CleanLabel.setOpaque(false);
         CleanLabel.setBackground(null);
         
//         CreditLabel.setOpaque(false);
//         CreditLabel.setBackground(null);
    }//GEN-LAST:event_CreditLabelMouseClicked

        // LOGO
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        WelcomePanel.setVisible(true);
        CustomersPanel.setVisible(false);
        CleanPanel.setVisible(false);
        ServicePanel.setVisible(false);
        VehiclesPanel.setVisible(false);
        RepairingPanel.setVisible(false);
        CreditsPanel.setVisible(false);
        
        
        VehicleLabel.setOpaque(false);
         VehicleLabel.setBackground(null);
        
         LogoutLabel.setOpaque(false);
         LogoutLabel.setBackground(null);
         
         
         CustLabel.setOpaque(false);
         CustLabel.setBackground(null);
         
         ServiceLabel.setOpaque(false);
         ServiceLabel.setBackground(null);
         
         RepairLabel.setOpaque(false);
         RepairLabel.setBackground(null);
         
         CleanLabel.setOpaque(false);
         CleanLabel.setBackground(null);
         
         CreditLabel.setOpaque(false);
         CreditLabel.setBackground(null);
    }//GEN-LAST:event_jLabel2MouseClicked

    
//    ------------------------------ CUSTOMER SECTION ----------------------------------
    
    
        // ADD BUTTON FOR CUSTOMER PANEL
    private void custAddDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custAddDataActionPerformed
    
        
        
        if(custName.getText().equals("")||custEmail.getText().equals("")||custCont.getText().equals("")||custAdd.getText().equals("")){
                   JOptionPane.showMessageDialog(this, "Please fill all the fields", "Alert", 1);
            }
        else{ try {
            Connection con = DbConnection.myConnection();
            String sql = "INSERT INTO `customermanage` (`custName`, `custEmail`, `custContact`, `custAddress`) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, custName.getText());
            pst.setString(2, custEmail.getText());
            pst.setString(3, custCont.getText());
            pst.setString(4, custAdd.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Added");

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        customer();
        
        }
        
        
    }//GEN-LAST:event_custAddDataActionPerformed

        // DELETE BUTTON FOR CUSTOMER PANEL
    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try {
            // TODO add your handling code here:
            String sql="DELETE FROM `customermanage` WHERE custName=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, custName.getText());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        customer();

    }//GEN-LAST:event_deleteBtnActionPerformed

        // UPDATE BUTTON FOR CUSTOMER PANEL
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        try {

            // TODO add your handling code here:
            Connection con=DbConnection.myConnection();
            String sql="UPDATE `customermanage` SET `custAddress`=?,`custEmail`=?,`custContact`=? WHERE `custName`=?";
            PreparedStatement pst=con.prepareStatement(sql);
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            pst=con.prepareStatement(sql);
            pst.setString(4,custName.getText());
            pst.setString(2,custEmail.getText());
            pst.setString(3,custCont.getText());
            pst.setString(1,custAdd.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data update succcessfull");

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        customer();

    }//GEN-LAST:event_updateBtnActionPerformed

        // SEARCH BUTTON FOR CUSTOMER PANEL
    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        homeDashboard vs=new homeDashboard();
        rs=vs.CustomerSearch(searchBox.getText());
        DefaultTableModel tb=(DefaultTableModel)custTableData.getModel();
        tb.setRowCount(0);
        try {
            while(rs.next()){
                String VehicleSearch[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                tb.addRow(VehicleSearch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchBtnActionPerformed

        // TABLE FOR CUSTOMER DATA
    private void custTableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custTableDataMouseClicked

        DefaultTableModel tb = (DefaultTableModel) custTableData.getModel();

        int selectedRow = custTableData.getSelectedRow();
        custName.setText(tb.getValueAt(selectedRow, 0).toString());
        custEmail.setText(tb.getValueAt(selectedRow, 1).toString());
        custCont.setText(tb.getValueAt(selectedRow, 2).toString());
        custAdd.setText(tb.getValueAt(selectedRow, 3).toString());
    }//GEN-LAST:event_custTableDataMouseClicked

    
//    ------------------------------ VEHICLE SECTION ----------------------------------  
  
    
        // UPDATE BUTTON FOR VEHICLE PANEL
    private void updateBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn1ActionPerformed
        try {
            String sql="UPDATE `vehicledetails` SET `VehicleNumber`=?,`CNIC`=?,`OwnerName`=?,`vehicleModel`=?,`FuelType`=? WHERE `VehicleId`=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            pst=con.prepareStatement(sql);

            
            pst.setString(6, VehicleID.getText());
            pst.setString(1, VehicleNum.getText());
            pst.setString(2, ownerNic.getText());
            pst.setString(3, ownerName.getText());
            pst.setString(4, vehicleModel.getText());
            pst.setString(5, (String)vehicleComb.getSelectedItem());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated Successfully");

            showVehicleData();
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateBtn1ActionPerformed

        // DELETE BUTTON FOR VEHICLE PANEL
    private void deleteBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn1ActionPerformed
        try {
            String sql="DELETE FROM `vehicledetails` WHERE VehicleId=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, VehicleID.getText());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        showVehicleData();

    }//GEN-LAST:event_deleteBtn1ActionPerformed

        // ADD BUTTON FOR VEHICLE PANEL
    private void addVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVehicleActionPerformed
         
        
      if(VehicleNum.getText().equals("")||ownerNic.getText().equals("")||ownerName.getText().equals("")||vehicleModel.getText().equals("")){
                   JOptionPane.showMessageDialog(this, "Please fill all the fields", "Alert", 1);
            }
      else{
      
           try {
            String sql="INSERT INTO vehicledetails"+"(vehicleNumber, CNIC, OwnerName, vehicleModel,FuelType)"+"VALUES (?,?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            pst=con.prepareStatement(sql);
            pst.setString(1,VehicleNum.getText() );
            pst.setString(2,ownerNic.getText() );
            pst.setString(3,ownerName.getText() );
            pst.setString(4,vehicleModel.getText() );
            pst.setString(5, (String)vehicleComb.getSelectedItem());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Data Added Succesfully");

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        showVehicleData();
      }
//      try {
//            String sql="INSERT INTO vehicledetails"+"(vehicleNumber, CNIC, OwnerName, vehicleModel,FuelType)"+"VALUES (?,?,?,?,?)";
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
//            pst=con.prepareStatement(sql);
//            pst.setString(1,VehicleNum.getText() );
//            pst.setString(2,ownerNic.getText() );
//            pst.setString(3,ownerName.getText() );
//            pst.setString(4,vehicleModel.getText() );
//            pst.setString(5, (String)vehicleComb.getSelectedItem());
//
//            pst.executeUpdate();
//            JOptionPane.showMessageDialog(rootPane, "Data Added Succesfully");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        showVehicleData();
    }//GEN-LAST:event_addVehicleActionPerformed

        // SEARCH BUTTON FOR VEHICLE PANEL
    private void searchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn1ActionPerformed

        homeDashboard vs=new homeDashboard();
        rs=vs.VehicleSearch(serachBox.getText());
        DefaultTableModel tb=(DefaultTableModel)vehicleDetailTable.getModel();
        tb.setRowCount(0);
        try {
            while(rs.next()){
                String VehicleSearch[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)};
                tb.addRow(VehicleSearch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchBtn1ActionPerformed

        // TABLE FOR VEHICLE DATA
    private void vehicleDetailTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vehicleDetailTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tb=(DefaultTableModel) vehicleDetailTable.getModel();
        int st  = vehicleDetailTable.getSelectedRow();

        VehicleID.setText(vehicleDetailTable.getValueAt(st,0).toString());
        VehicleNum.setText(vehicleDetailTable.getValueAt(st,1).toString());
        ownerNic.setText(vehicleDetailTable.getValueAt(st,2).toString());
        ownerName.setText(vehicleDetailTable.getValueAt(st,3).toString());
        vehicleModel.setText(vehicleDetailTable.getValueAt(st,4).toString());
        vehicleComb.setSelectedItem(vehicleDetailTable.getValueAt(st,5).toString());

    }//GEN-LAST:event_vehicleDetailTableMouseClicked

    
//    ------------------------------ SERVICE SECTION ----------------------------------  
    
    
        // ADD BUTTON FOR SERVICE PANEL
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
     
        
        if(serviceId.getText().equals("")||vehicleNum.getText().equals("")||vehModel.getText().equals("")||ownerName1.getText().equals("")){
                   JOptionPane.showMessageDialog(this, "Please fill all the fields", "Alert", 1);
            } 
        else{   
          try {

            if(serviceId.getText().equals("")||vehicleNum.getText().equals("")||vehModel.getText().equals("")||ownerName1.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Fill All Field");

            }else{
                String sql="INSERT INTO `addtoservice`"+"(`id`, `vehicleNum`, `vehicleModel`, `owner`, `ServiceType`)"+" VALUES (?,?,?,?,?)";
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
                pst=con.prepareStatement(sql);
                pst.setString(1,serviceId.getText() );
                pst.setString(2,vehicleNum.getText() );
                pst.setString(3,vehModel.getText() );
                pst.setString(4,ownerName1.getText() );
                pst.setString(5, (String)serviceType.getSelectedItem());

                pst.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Data Added Succesfully");
            }

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        serviceDetail();
        }
      
    }//GEN-LAST:event_addBtnActionPerformed

        // DELETE BUTTON FOR SERVICE PANEL
    private void deleteBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn2ActionPerformed
        // TODO add your handling code here:
        try {
            if(serviceId.getText().equals("")||vehicleNum.getText().equals("")||vehModel.getText().equals("")||ownerName1.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Please Fill All Field");

            }else{
                String sql="DELETE FROM `addtoservice` WHERE id=?";
                pst=con.prepareStatement(sql);
                pst.setString(1, serviceId.getText());
                pst.executeUpdate();

            }

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        serviceDetail();

    }//GEN-LAST:event_deleteBtn2ActionPerformed

        // CLEAR BUTTON FOR SERVICE PANEL
    private void clearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAllActionPerformed
        // TODO add your handling code here:
        serviceId.setText("");
        vehicleNum.setText("");
        vehModel.setText("");
        ownerName1.setText("");
        serviceType.setSelectedItem("");
    }//GEN-LAST:event_clearAllActionPerformed

        // TABLE FOR SERVICE DATA
    private void serviceDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceDetailsMouseClicked
        // TODO add your handling code here:

        DefaultTableModel tb=(DefaultTableModel) serviceDetails.getModel();
        int st  = serviceDetails.getSelectedRow();

        serviceId.setText(serviceDetails.getValueAt(st,0).toString());
        vehicleNum.setText(serviceDetails.getValueAt(st,1).toString());
        vehModel.setText(serviceDetails.getValueAt(st,2).toString());
        ownerName1.setText(serviceDetails.getValueAt(st,3).toString());
        //            vehicleModel.setText(.getValueAt(st,4).toString());
        serviceType.setSelectedItem(serviceDetails.getValueAt(st,4).toString());
    }//GEN-LAST:event_serviceDetailsMouseClicked

        // SEARCH BUTTON FOR SERVICE PANEL
    private void searchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn2ActionPerformed
        // TODO add your handling code here:
        homeDashboard search=new homeDashboard();
        rs=search.ServiceSearch(serchBox.getText());
        DefaultTableModel tb=(DefaultTableModel)serviceDetails.getModel();
        tb.setRowCount(0);
        try {
            while(rs.next()){
                String serviceSearch[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)};
                tb.addRow(serviceSearch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_searchBtn2ActionPerformed

    
//    ------------------------------ REPAIRING SECTION ----------------------------------  
    
        // ADD BUTTON FOR REPAIRING PANEL
    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed

     if(ownerName2.getText().equals("")||vehicleNo.getText().equals("")||contact.getText().equals("")||address.getText().equals("")){
                   JOptionPane.showMessageDialog(this, "Please fill all the fields", "Alert", 1);
            } 
        else{  
     
          try {

            String sql="INSERT INTO `repairing`(`Name`, `VehicleNum`, `Contact`, `Address`) VALUES (?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            pst=con.prepareStatement(sql);
            pst.setString(1, ownerName2.getText());
            pst.setString(2, vehicleNo.getText());
            pst.setString(3, contact.getText());
            pst.setString(4, address.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Added");

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        repairingData();
     
     }

    }//GEN-LAST:event_AddBtnActionPerformed

        // UPDATE BUTTON FOR REPAIRING PANEL
    private void updateBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn2ActionPerformed
        try {

            String sql="UPDATE `repairing` SET `VehicleNum`=?,`Contact`=?,`Address`=? WHERE `Name`=?";

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            pst=con.prepareStatement(sql);
            pst.setString(4,ownerName2.getText());
            pst.setString(1,vehicleNo.getText());
            pst.setString(2,contact.getText());
            pst.setString(3,address.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data update succcessfull");

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        repairingData();

    }//GEN-LAST:event_updateBtn2ActionPerformed

        // CLEAR BUTTON FOR REPAIRING PANEL
    private void clearAll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearAll1ActionPerformed
        // TODO add your handling code here:
        ownerName2.setText("");
        vehicleNo.setText("");
        contact.setText("");
        address.setText("");
        //        Stringdate.setDate("");

    }//GEN-LAST:event_clearAll1ActionPerformed

        // DELETE BUTTON FOR REPAIRING PANEL
    private void deleteBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn3ActionPerformed
        // TODO add your handling code here:

        try {
            // TODO add your handling code here:
            String sql="DELETE FROM `repairing` WHERE Name=?";
            pst=con.prepareStatement(sql);
            pst.setString  (1, ownerName2.getText());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        repairingData();

    }//GEN-LAST:event_deleteBtn3ActionPerformed

        // SEARCH BUTTON FOR REPAIRING PANEL
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        homeDashboard repair=new homeDashboard();
        rs=repair.RepairSearch(Integer.parseInt(searchBox1.getText()));
        
        DefaultTableModel tb=(DefaultTableModel)repairingTable.getModel();
        tb.setRowCount(0);
        try {
            while(rs.next()){
                String VehicleSearch[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                tb.addRow(VehicleSearch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

        // TABLE FOR REPAIRING DATA
    private void repairingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repairingTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel tb=(DefaultTableModel)repairingTable.getModel();
        //             tb.setRowCount(0);
        int SelectedRows=repairingTable.getSelectedRow();

        ownerName2.setText(repairingTable.getValueAt(SelectedRows,0).toString());

        vehicleNo.setText(repairingTable.getValueAt(SelectedRows, 1).toString());

        contact.setText(repairingTable.getValueAt(SelectedRows, 2).toString());

        address.setText(repairingTable.getValueAt(SelectedRows, 3).toString());

    }//GEN-LAST:event_repairingTableMouseClicked

    
//    ------------------------------ CLEANING SECTION ---------------------------------- 
    
    
        // ADD BUTTON FOR CLEANING PANEL
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
 if(ownerName.getText().equals("")||vehicleNo.getText().equals("")||contact.getText().equals("")||serviceType1.getSelectedItem().equals("")){
                   JOptionPane.showMessageDialog(this, "Please fill all the fields", "Alert", 1);
            } 
        else{  
        
        try {
            String sql="INSERT INTO `cleaning`(`ownerName`, `vehicleNo`, `contact`, `serviceTpe`) VALUES (?,?,?,?)";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            pst=con.prepareStatement(sql);
            pst.setString(1,owner.getText() );
            pst.setString(2,vehicleNumb.getText() );
            pst.setString(3,contact1.getText() );
            pst.setString(4, (String)serviceType1.getSelectedItem());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Data Added Succesfully");

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        cleaningVehicle();
 }
    }//GEN-LAST:event_addButtonActionPerformed

        // UPDATE BUTTON FOR CLEANING PANEL
    private void updateBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn3ActionPerformed

        try {
            String sql = "UPDATE `cleaning` SET vehicleNo=?, contact=?, serviceTpe=? WHERE ownerName=?";
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            pst = con.prepareStatement(sql);

            pst.setString(1, vehicleNumb.getText());
            pst.setString(2, contact1.getText());
            pst.setString(3, (String) serviceType1.getSelectedItem());
            pst.setString(4, owner.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated Successfully");

            cleaningVehicle();
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_updateBtn3ActionPerformed

        // DELETE BUTTON FOR CLEANING PANEL
    private void deleteBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn4ActionPerformed

        try {
            // TODO add your handling code here:
            String sql="DELETE FROM `cleaning` WHERE ownerName =?";
            pst=con.prepareStatement(sql);
            pst.setString(1, owner.getText());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        cleaningVehicle();

    }//GEN-LAST:event_deleteBtn4ActionPerformed

        // CLEAR BUTTON FOR CLEANING PANEL
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        owner.setText("");
        vehicleNumb.setText("");
        contact1.setText("");
        serviceType1.setSelectedItem("");
    }//GEN-LAST:event_jButton7ActionPerformed

        // TABLE FOR CLEANING DATA
    private void cleaningTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cleaningTableMouseClicked
        DefaultTableModel tb=(DefaultTableModel) cleaningTable.getModel();
        int st  = cleaningTable.getSelectedRow();

        owner.setText(cleaningTable.getValueAt(st,0).toString());
        vehicleNumb.setText(cleaningTable.getValueAt(st,1).toString());
        contact1.setText(cleaningTable.getValueAt(st,2).toString());
        //            ownerName.setText(cleaningTable.getValueAt(st,3).toString());
        serviceType1.setSelectedItem(cleaningTable.getValueAt(st,3).toString());

    }//GEN-LAST:event_cleaningTableMouseClicked

        // SEARCH BUTTON FOR CLEANING PANEL
    private void searchBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtn3ActionPerformed
        // TODO add your handling code here:
        homeDashboard clean=new homeDashboard();
        rs=clean.CleanSearch(searchBox2.getText());

        DefaultTableModel tb=(DefaultTableModel)cleaningTable.getModel();
        tb.setRowCount(0);
        try {
            while(rs.next()){
                String Search[]={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
                tb.addRow(Search);
            }
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBtn3ActionPerformed

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel49MouseClicked

    private void CustLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustLabelMouseEntered
        // TODO add your handling code here:
                // TODO add your handling code here:
       CustLabel.setBackground(new java.awt.Color(65,204,173));

    }//GEN-LAST:event_CustLabelMouseEntered

    private void CustLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustLabelMouseExited
        // TODO add your handling code here:
               // TODO add your handling code here:
    if(!"CustLabel".equals(currentColor)){
         CustLabel.setBackground(Color.decode("#155A3C"));
    };

    }//GEN-LAST:event_CustLabelMouseExited

    private void VehicleLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VehicleLabelMouseEntered
        // TODO add your handling code here:

  VehicleLabel.setBackground(new java.awt.Color(65,204,173));
    }//GEN-LAST:event_VehicleLabelMouseEntered

    private void VehicleLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VehicleLabelMouseExited
        // TODO add your handling code here:


  if(!"VehicleLabel".equals(currentColor)){
         VehicleLabel.setBackground(Color.decode("#155A3C"));
    }//GEN-LAST:event_VehicleLabelMouseExited
    }
    
        
        // MAIN METHOD
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
            java.util.logging.Logger.getLogger(homeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homeDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel CleanLabel;
    private javax.swing.JPanel CleanPanel;
    private javax.swing.JLabel CreditLabel;
    private javax.swing.JPanel CreditsPanel;
    private javax.swing.JLabel CustEmailLabel;
    private javax.swing.JLabel CustLabel;
    private javax.swing.JLabel CustNameLabel;
    private javax.swing.JPanel CustomersPanel;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JLabel LogoutLabel;
    private javax.swing.JLabel RepairLabel;
    private javax.swing.JPanel RepairingPanel;
    private javax.swing.JLabel ServiceLabel;
    private javax.swing.JPanel ServicePanel;
    private javax.swing.JPanel Template;
    private javax.swing.JTextField VehicleID;
    private javax.swing.JLabel VehicleLabel;
    private javax.swing.JTextField VehicleNum;
    private javax.swing.JPanel VehiclesPanel;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addVehicle;
    private javax.swing.JTextArea address;
    private javax.swing.JTable cleaningTable;
    private javax.swing.JButton clearAll;
    private javax.swing.JButton clearAll1;
    private javax.swing.JTextField contact;
    private javax.swing.JTextField contact1;
    private javax.swing.JTextArea custAdd;
    private javax.swing.JButton custAddData;
    private javax.swing.JTextField custCont;
    private javax.swing.JTextField custEmail;
    private javax.swing.JTextField custName;
    private javax.swing.JTable custTableData;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn1;
    private javax.swing.JButton deleteBtn2;
    private javax.swing.JButton deleteBtn3;
    private javax.swing.JButton deleteBtn4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField owner;
    private javax.swing.JTextField ownerName;
    private javax.swing.JTextField ownerName1;
    private javax.swing.JTextField ownerName2;
    private javax.swing.JTextField ownerNic;
    private javax.swing.JTable repairingTable;
    private javax.swing.JTextField searchBox;
    private javax.swing.JTextField searchBox1;
    private javax.swing.JTextField searchBox2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchBtn1;
    private javax.swing.JButton searchBtn2;
    private javax.swing.JButton searchBtn3;
    private javax.swing.JTextField serachBox;
    private javax.swing.JTextField serchBox;
    private javax.swing.JTable serviceDetails;
    private javax.swing.JTextField serviceId;
    private javax.swing.JComboBox<String> serviceType;
    private javax.swing.JComboBox<String> serviceType1;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn1;
    private javax.swing.JButton updateBtn2;
    private javax.swing.JButton updateBtn3;
    private javax.swing.JTextField vehModel;
    private javax.swing.JComboBox<String> vehicleComb;
    private javax.swing.JTable vehicleDetailTable;
    private javax.swing.JTextField vehicleModel;
    private javax.swing.JTextField vehicleNo;
    private javax.swing.JTextField vehicleNum;
    private javax.swing.JTextField vehicleNumb;
    // End of variables declaration//GEN-END:variables
}
