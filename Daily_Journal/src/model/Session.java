package model;

public class Session {
    private static String id_user;
    private static String username;

    public static void set_id_user(String id_user) {
        Session.id_user = id_user;
    }

    public static String get_id_user() {
        return id_user;
    }

    public static void set_username(String username) {
        Session.username = username;
    }

    public static String get_username() {
        return username;
    }
}
