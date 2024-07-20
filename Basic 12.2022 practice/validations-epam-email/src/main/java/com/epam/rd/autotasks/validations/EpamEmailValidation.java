package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9+_.-]+@epam\\.com$");

        Matcher matcher = EMAIL_PATTERN.matcher(email);
        if (!matcher.matches()) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2 || !parts[1].equals("epam.com")) {
            return false;
        }

        String localPart = parts[0];
        String[] nameParts = localPart.split("_");
        if (nameParts.length != 2) {
            return false;
        }

        return nameParts[0].length() != 0 && nameParts[1].length() != 0;


    }
}