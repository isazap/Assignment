package nl.isaza.rabo.assignment.utils;

import org.apache.commons.validator.routines.UrlValidator;

public class Validators {
    /**
     * Checks if a given string is a valid URL
     *
     * @param url the url string to check
     * @return true if it is valid
     */
    private static boolean isValidURL(String url) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        return (urlValidator.isValid(url));
    }
}
