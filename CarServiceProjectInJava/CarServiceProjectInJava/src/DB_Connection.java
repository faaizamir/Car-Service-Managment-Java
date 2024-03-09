
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_Connection {

    Connection con;
    Statement st;
    ResultSet rs;
    
    // Constructor for DB Connectivity
    DB_Connection() throws SQLException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/carService", "root", "");
            st = con.createStatement();
            System.out.println(" Database Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Sign-up Method
    public void userSignUp(String username, String userEmail, String userPass) {
        String sql = "INSERT INTO usersignup(userName, userEmail, userPass) VALUES ('" + username + "','" + userEmail + "','" + userPass + "')";
        try {
            st.executeUpdate(sql);

        } catch (Exception e) {
            System.out.print(e);
        }

    }

    // Login Method
    public ResultSet userLogin(String userLog, String userPassword) {
        String pass = "SELECT * FROM `usersignup` WHERE `userName`='" + userLog + "' and `userPass`='" + userPassword + "'";

        try {
            rs = st.executeQuery(pass);
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }
    
    //Adding Vehicle Data to Database
    public void vehicleData(String name, String cnic, String owner,String model) {
        try {
            String sql = "INSERT INTO `vehicledetails`(`vehicleNum`, `CNIC`, `OwnerName`, `vehicleModel`) VALUES ('"+name+"','"+cnic+"','"+owner+"','"+model+"')";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Adding Customer data.
    public void custManager(String name, String email, String addres) {
        try {
            String sql = "INSERT INTO `customermanage`(`custName`, `custAddress`, `custEmail`, `custDate`) VALUES ('" + name + "','" + addres + "','" + email + "','[value-4]')";
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Getting Customer Data from database
    public ResultSet geCustomer() {
        try {
            String sql = "SELECT * FROM `customermanage`";
            rs = st.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    // Deleting Customer from database
    public void DeletecustManager(String name, String email, String addres) {
        try {
            String sql = "DELETE FROM `customermanage` WHERE custName = '" + name + "'";
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Record is deleted!");
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void setVisible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public static void main(String[] args){
        try {
            DB_Connection db = new DB_Connection();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
