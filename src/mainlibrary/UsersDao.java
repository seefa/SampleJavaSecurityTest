/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Objects;

/**
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

            if (status) {

                int failedCount = rs.getInt("FailedCount");
                Date lockedUntilDateTime = rs.getDate("LockedUntilDateTime");

                // check user is locked for specific counter and time
                Calendar lockedUntilDateTimeFormatted = null;
                boolean bypassIfDurationPassed = false;
                Calendar now = Calendar.getInstance();

                if(Objects.nonNull(lockedUntilDateTime)) {
                    lockedUntilDateTimeFormatted = Calendar.getInstance();
                    lockedUntilDateTimeFormatted.setTimeInMillis(lockedUntilDateTime.getTime());

                    if(lockedUntilDateTimeFormatted.getTime().before(now.getTime())){
                        bypassIfDurationPassed = true;
                    }
                }

                if(bypassIfDurationPassed ||
                        (failedCount < 3 &&
                                (Objects.isNull(lockedUntilDateTimeFormatted) ||
                                        lockedUntilDateTimeFormatted.getTime().before(now.getTime())
                                )
                        )
                ) {

                    // Checking User's Hash password
                    boolean result = UsersDao.checkPassword(password, rs.getString("UserPass"));

                    if (result) {
                        updateUserLockedStatus(name, 0, null);
                        return result;
                    } else {
                        // Add failed counter in here:

                        Calendar cal = Calendar.getInstance();
                        if (lockedUntilDateTime != null) {
                            cal.setTime(lockedUntilDateTime);
                        }

                        if (failedCount >= 3) {
                            cal.add(Calendar.DATE, 1);
                        }
                        failedCount = failedCount + 1;
                        updateUserLockedStatus(name, failedCount, new Date(cal.getTimeInMillis()));

                    }
                }
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

    public static int updateUserLockedStatus(String username, int counter, Date lockedDate) {
        int status = 0;
        try {

            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("update Users set FailedCount =?, LockedUntilDateTime=? where UserName=?");
            ps.setInt(1, counter);
            ps.setDate(2, lockedDate);
            ps.setString(3, username);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;

    }


    public static boolean CheckIfAlready(String UserName) {
        boolean status = false;
        try {
            Connection con = DB.getConnection();
            String select = "select * from Users where UserName= '" + UserName + "'";
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
            ps.setString(1, UsersDao.hashPassword(UserPass));
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

    private static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    private static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

}
