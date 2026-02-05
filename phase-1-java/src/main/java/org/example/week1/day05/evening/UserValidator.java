package org.example.week1.day05.evening;

import java.util.regex.Pattern;

public class UserValidator {
    private static final Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    private static final Pattern phoneNumberPattern = Pattern.compile("^[6-9].\\d{9}$");
    private static final Pattern passPattern = Pattern.compile("^(?=.*\\d){8,}$"); //min 8 chars and atleast 1 digit

    public static String validateEmail(String email) {
        if(email == null || email.isEmpty()) {
            return "Email cannot be empty";
        }
        if(!emailPattern.matcher(email).matches()) {
            return "Invalid Email";
        }
        return null;
    }

    public static String validatePhone(String phone) {
        if(phone == null || phone.isEmpty()) {
            return "Phone number cannot be empty";
        }
        if(!phoneNumberPattern.matcher(phone).matches()) {
            return "Invalid Phone";
        }
        return null;
    }

    public static String validatePass(String pass) {
        if(pass == null || pass.isEmpty()) {
            return "Password cannot be empty";
        }
        if(!passPattern.matcher(pass).matches()) {
            return "Invalid Password";
        }
        return null;
    }

}
