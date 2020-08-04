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
        System.out.println(passwordHashGenerator.hashPassword("sami1234"));

    }

    private String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    private boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
