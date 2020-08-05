package mainlibrary;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author Saman Delfani
 * @version 1.0
 * @since 05 Aug 2020 T 01:22:02
 */
public class SamplePasswordHashGenerator {

    public static void main(String[] args) {

        SamplePasswordHashGenerator passwordHashGenerator = new SamplePasswordHashGenerator();

        String plainPassword = "Saman1399@Test";
        String hashPassword = passwordHashGenerator.hashPassword(plainPassword);

        System.out.println(hashPassword);

        System.out.println(passwordHashGenerator.checkPassword(plainPassword, hashPassword));



    }

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    private boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
