package org.example.Util;


import org.mindrot.jbcrypt.BCrypt;

public class UserServiceUtil {
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
    public static Boolean checkPassword(String plainPassword, String hashPassword) {
        return BCrypt.checkpw(plainPassword,hashPassword);
    }
}
