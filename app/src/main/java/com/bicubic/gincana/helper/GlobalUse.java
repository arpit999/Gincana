package com.bicubic.gincana.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by admin on 06-Dec-16.
 */

public class GlobalUse {

    public static RequestBody toRequestBody (String value) {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body ;

    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public static boolean isPasswordValidMethod(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[$@$!%*#?&])[A-Za-z\\\\d$@$!%*#?&]{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }


    public static final String SPECIAL_CHARACTERS = "!@#$%^&*()~`-=_+[]{}|:\";',./<>?";
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final int MAX_PASSWORD_LENGTH = 20;

    public static boolean isAcceptablePassword(String password) {
       /* if (TextUtils.isEmpty(s)) {
            System.out.println("empty string.");
            return false;
        }*/
        password = password.trim();
        int len = password.length();
        if(len < MIN_PASSWORD_LENGTH || len > MAX_PASSWORD_LENGTH) {
            System.out.println("wrong size, it must have at least 8 characters and less than 20.");
            return false;
        }
        char[] aC = password.toCharArray();
        for(char c : aC) {
            if (Character.isUpperCase(c)) {
                System.out.println(c + " is uppercase.");
            } else
            if (Character.isLowerCase(c)) {
                System.out.println(c + " is lowercase.");
            } else
            if (Character.isDigit(c)) {
                System.out.println(c + " is digit.");
            } else
            if (SPECIAL_CHARACTERS.indexOf(String.valueOf(c)) >= 0) {
                System.out.println(c + " is valid symbol.");
            } else {
                System.out.println(c + " is an invalid character in the password.");
                return false;
            }
        }
        return true;
    }

}
