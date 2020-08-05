package mainlibrary;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Validator;

import javax.swing.*;
import java.awt.*;

/**
 * @author Saman Delfani
 * @version 1.0
 * @since 06 Aug 2020 T 03:07:51
 */
class LoginUIComponentUtility extends javax.swing.JFrame {

    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;

    void loginComponentUIPanel(String pageTitle) {

        javax.swing.JPanel loginPanel = new javax.swing.JPanel();
        javax.swing.JLabel passwordLabel = new javax.swing.JLabel();
        javax.swing.JLabel userLabel = new javax.swing.JLabel();
        javax.swing.JButton loginButton = new javax.swing.JButton();
        javax.swing.JButton backButton = new javax.swing.JButton();
        javax.swing.JLabel pageLabel = new javax.swing.JLabel();

        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        passwordLabel.setFont(new java.awt.Font("FreeSans", Font.BOLD, 20)); // NOI18N
        passwordLabel.setText("Password");

        username.setToolTipText("");

        userLabel.setFont(new java.awt.Font("FreeSans", Font.BOLD, 20)); // NOI18N
        userLabel.setText("Username");

        pageLabel.setFont(new java.awt.Font("Ubuntu", Font.BOLD, 24)); // NOI18N
        pageLabel.setText(pageTitle);

        loginButton.setText("Login");
        loginButton.addActionListener(this::jButton1ActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginLayout);

        loginLayout.setHorizontalGroup(
                loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLayout.createSequentialGroup()
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(loginLayout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addComponent(passwordLabel)
                                                .addGap(18, 18, 18)
                                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(username)
                                                        .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))
                                        .addGroup(loginLayout.createSequentialGroup()
                                                .addGap(279, 279, 279)
                                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(loginLayout.createSequentialGroup()
                                                .addGap(238, 238, 238)
                                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(118, Short.MAX_VALUE))
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(loginLayout.createSequentialGroup()
                                        .addGap(92, 92, 92)
                                        .addComponent(userLabel)
                                        .addContainerGap(485, Short.MAX_VALUE))));

        loginLayout.setVerticalGroup(
                loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(loginLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(143, Short.MAX_VALUE))
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(loginLayout.createSequentialGroup()
                                        .addGap(143, 143, 143)
                                        .addComponent(userLabel)
                                        .addContainerGap(397, Short.MAX_VALUE))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(296, 296, 296)
                                                .addComponent(pageLabel)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(pageLabel)
                                .addGap(18, 18, 18)
                                .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();


    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String usernameParam= username.getText();
        String Pass = String.valueOf(password.getPassword());

        Validator validator = ESAPI.validator();
        boolean validUserName = validator.isValidInput("Username", usernameParam, "Username", 32, false);
        boolean validUserPassword = validator.isValidInput("Password", Pass, "Password", 32, false);


        System.out.println(usernameParam + " " + Pass);
        if (validUserName && validUserPassword && UsersDao.validate(usernameParam, Pass)) {
            this.dispose();
            UserLoginSuccess.main(new String[]{usernameParam, Pass});

        } else {
            JOptionPane.showMessageDialog(LoginUIComponentUtility.this, "Sorry, Username or Password Error", "Login Error!", JOptionPane.ERROR_MESSAGE);
            username.setText("");
            password.setText("");
        }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MainLibrary.main(new String[]{});
    }

}
