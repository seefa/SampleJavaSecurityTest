/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

/**
 *
 * @author bikash
 */
public class UsersDao {

    public static boolean validate(String name, String password) {
        boolean status = false;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = DB.getConnection();
            String select = "select * from Users where UserName= '" + name + "'";
            Statement selectStatement = con.createStatement();
            rs = selectStatement.executeQuery(select);
            status = rs.next();

            if(status) {
                // Checking User's Hash password
                return UsersDao.checkPassword(password, rs.getString("UserPass"));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return false;
    }




    private static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }




    public static boolean CheckIfAlready(String UserName) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            String select = "select * from Users where UserName= '" + UserName +"'";
            Statement selectStatement = con.createStatement();
            ResultSet rs = selectStatement.executeQuery(select);
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

    public static int AddUser(String User, String UserPass, String UserEmail, String Date) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        int status = 0;
        try {

            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into Users(UserPass,RegDate,UserName,Email) values(?,?,?,?)");
            ps.setString(1, UserPass);
            ps.setString(2, Date);
            ps.setString(3, User);
            ps.setString(4, UserEmail);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }

}
