package com.shop.datahandlers.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    public static boolean validateEmail(String email) {
        String patternString = ".+@.+?\\..+";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
}