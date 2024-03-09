
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class LoginSignUp extends javax.swing.JFrame {

    // CONSTRUCTOR
    public LoginSignUp() {
        initComponents();
        username.setBackground(new java.awt.Color(0, 0, 0, 1));
        userLoginPass.setBackground(new java.awt.Color(0, 0, 0, 1));
        userName.setBackground(new java.awt.Color(0, 0, 0, 1));
        pass.setBackground(new java.awt.Color(0, 0, 0, 1));
        userEmail.setBackground(new java.awt.Color(0, 0, 0, 1));
        jPanel3.setVisible(false);
        textsign.setVisible(false);
        iconsign.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textsign = new javax.swing.JLabel();
        iconlogin = new javax.swing.JLabel();
        textlogin = new javax.swing.JLabel();
        iconsign = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        userLoginPass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        disable1 = new javax.swing.JLabel();
        show1 = new javax.swing.JLabel();
        signUpBtn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        userEmail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textsign.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textsign.setForeground(new java.awt.Color(21, 135, 108));
        textsign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textsign.setText("Hello, Friend! Join us today.");
        jPanel1.add(textsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 500, -1));

        iconlogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login-f.png"))); // NOI18N
        jPanel1.add(iconlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 390, 350));

        textlogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        textlogin.setForeground(new java.awt.Color(21, 135, 108));
        textlogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textlogin.setText("Welcome Back!");
        jPanel1.add(textlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 500, -1));

        iconsign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Signup.png"))); // NOI18N
        jPanel1.add(iconsign, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 360, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 520));

        jPanel2.setBackground(new java.awt.Color(21, 135, 108));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 40, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Login");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 420, 41));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 420, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 341, -1));

        username.setFont(username.getFont().deriveFont(username.getFont().getSize()+2f));
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setBorder(null);
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 240, 30));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("_________________________________________");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 290, 39));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 40, 39));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(199, 226, 255));
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 341, -1));

        userLoginPass.setFont(userLoginPass.getFont().deriveFont(userLoginPass.getFont().getSize()+2f));
        userLoginPass.setForeground(new java.awt.Color(255, 255, 255));
        userLoginPass.setBorder(null);
        userLoginPass.setCaretColor(new java.awt.Color(255, 255, 255));
        userLoginPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLoginPassActionPerformed(evt);
            }
        });
        jPanel2.add(userLoginPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 240, 30));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("_________________________________________");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 290, 40));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jPanel2.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 40, 40));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 40, 40));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(199, 226, 255));
        jCheckBox1.setText("Remember Password");
        jCheckBox1.setOpaque(false);
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(199, 226, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Forget Password?");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 121, 27));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(21, 135, 108));
        jButton1.setText("LOGIN");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 341, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Sign Up");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 122, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(199, 226, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Don't have an account?");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 213, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 460, 520));

        jPanel3.setBackground(new java.awt.Color(21, 135, 108));
        jPanel3.setPreferredSize(new java.awt.Dimension(460, 520));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("X");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 40, 29));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Sign Up");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 420, 41));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Join Us Now!");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 420, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(199, 226, 255));
        jLabel17.setText("Username");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 341, -1));

        userName.setFont(userName.getFont().deriveFont(userName.getFont().getSize()+2f));
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setBorder(null);
        jPanel3.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, 30));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("_________________________________________");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 290, 39));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_20px_1.png"))); // NOI18N
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 40, 39));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(199, 226, 255));
        jLabel20.setText("Password");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 341, -1));

        pass.setFont(pass.getFont().deriveFont(pass.getFont().getSize()+2f));
        pass.setForeground(new java.awt.Color(255, 255, 255));
        pass.setBorder(null);
        pass.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 240, 30));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("_________________________________________");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 290, 40));

        disable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_invisible_20px_1.png"))); // NOI18N
        disable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disable1MouseClicked(evt);
            }
        });
        jPanel3.add(disable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 40, 40));

        show1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_eye_20px_1.png"))); // NOI18N
        show1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show1MouseClicked(evt);
            }
        });
        jPanel3.add(show1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 40, 40));

        signUpBtn.setBackground(new java.awt.Color(255, 255, 255));
        signUpBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signUpBtn.setForeground(new java.awt.Color(21, 135, 108));
        signUpBtn.setText("SIGNUP");
        signUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        jPanel3.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 341, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Log-in");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 122, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(199, 226, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Already have an account?");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 213, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(199, 226, 255));
        jLabel22.setText("Email");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 340, -1));

        userEmail.setFont(userEmail.getFont().deriveFont(userEmail.getFont().getSize()+2f));
        userEmail.setForeground(new java.awt.Color(255, 255, 255));
        userEmail.setBorder(null);
        userEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userEmailActionPerformed(evt);
            }
        });
        jPanel3.add(userEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 240, 30));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("_________________________________________");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 290, 40));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mail-fill.png"))); // NOI18N
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 40, 39));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 460, 520));

        setSize(new java.awt.Dimension(960, 520));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    // Hide Pass for LoginSignUp page.
    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        userLoginPass.setEchoChar((char) 0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);

    }//GEN-LAST:event_disableMouseClicked

    // Show pass for LoginSignUp page.
    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        userLoginPass.setEchoChar((char) 8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);

    }//GEN-LAST:event_showMouseClicked

    // Transition
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    // Login page to sign-in page
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        jPanel3.setVisible(true);
        jPanel2.setVisible(false);
        textsign.setVisible(true);
        textlogin.setVisible(false);
        iconsign.setVisible(true);
        iconlogin.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    // Cross button for LoginSignUp page.
    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    // Hide Pass for sign-up page.
    private void disable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disable1MouseClicked
        // TODO add your handling code here:
        pass.setEchoChar((char) 0);

        disable1.setVisible(false);
        disable1.setEnabled(false);
        show1.setEnabled(true);
        show1.setEnabled(true);
    }//GEN-LAST:event_disable1MouseClicked

    // Show Pass for sign-up page.
    private void show1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show1MouseClicked
        // TODO add your handling code here:
        pass.setEchoChar((char) 8226);
        disable1.setVisible(true);
        disable1.setEnabled(true);
        show1.setEnabled(false);
        show1.setEnabled(false);
    }//GEN-LAST:event_show1MouseClicked

    // Sign-up page to LoginSignUp page.
    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
        jPanel2.setVisible(true);
        jPanel3.setVisible(false);
        textsign.setVisible(false);
        textlogin.setVisible(true);
        iconlogin.setVisible(true);
        iconsign.setVisible(false);
    }//GEN-LAST:event_jLabel23MouseClicked

    // Login Button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ResultSet rs;
        String nam = username.getText();
        String pass = userLoginPass.getText();

        if (username.getText().equals("") || userLoginPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Alert", 1);
        }

        try {
            DB_Connection login = new DB_Connection();
            rs = login.userLogin(username.getText(), userLoginPass.getText());
            if (rs.next()) {
                homeDashboard admin = new homeDashboard();
                admin.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Alert", 1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Sign-Up Button
    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        String regexMail = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
        String mail = userEmail.getText();
        
        Pattern p = Pattern.compile(regexMail);
        Matcher m = p.matcher(mail);
        boolean b = m.matches();
        if(!b){
            JOptionPane.showMessageDialog(this, "Invalid email", "Alert", 1);
            
        }else{
            
        try {
            if (userName.getText().isEmpty() || userEmail.getText().isEmpty() || pass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all the fields");
            } else {
                DB_Connection db = new DB_Connection();
                db.userSignUp(userName.getText(), userEmail.getText(), pass.getText());
                JOptionPane.showMessageDialog(this, "You are registered");
                jPanel3.setVisible(false);
                jPanel2.setVisible(true);
                textsign.setVisible(false);
                textlogin.setVisible(true);
                iconlogin.setVisible(true);
                iconsign.setVisible(false);

            }
        } catch (SQLException ex) {
            Logger.getLogger(homeDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }//GEN-LAST:event_signUpBtnActionPerformed

    private void userLoginPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLoginPassActionPerformed
        // TODO add your handling code here:
        jButton1.doClick();
    }//GEN-LAST:event_userLoginPassActionPerformed

    private void userEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userEmailActionPerformed
        // TODO add your handling code here:
        signUpBtn.doClick();
    }//GEN-LAST:event_userEmailActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

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
            java.util.logging.Logger.getLogger(LoginSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel disable;
    private javax.swing.JLabel disable1;
    private javax.swing.JLabel iconlogin;
    private javax.swing.JLabel iconsign;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel show;
    private javax.swing.JLabel show1;
    private javax.swing.JButton signUpBtn;
    private javax.swing.JLabel textlogin;
    private javax.swing.JLabel textsign;
    private javax.swing.JTextField userEmail;
    private javax.swing.JPasswordField userLoginPass;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
