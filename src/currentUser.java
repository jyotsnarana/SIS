/**
 * current user
 * using current userclass to keep current user
  * @author parisanikzad
 */
public class currentUser {
    public static String type;
    public static String name;
    public static int id;

    public currentUser(String type, String name, int id) {
        this.type = type;
        this.name = name;
        this.id = id;
    }

//    public static getcurrentUserId() {
//        return this.id;
//    }
}
