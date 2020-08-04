package mainlibrary;

/**
 * @author Saman Delfani
 * @version 1.0
 * @since 21 Jul 2020 T 01:28:15
 */
public class SOFDemo {
    public static void a() {
        // Buggy line. It will cause method a() to be called infinite number of times.
        a();
    }
    public static void main(String args[]) {
        a();
    }
}
