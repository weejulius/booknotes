package com.wee.netnotes.domain.user;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: wee
 * Date: Nov 9, 2009
 * Time: 9:55:32 PM
 * To change this template use File | Settings | File Templates.
 */
public final class UserValidator {
    protected UserValidator() {
        throw new UnsupportedOperationException();
    }

    public static void validateName(final String name) {
        validateIllegalCharacter(name, "^[0-9a-zA-Z~][0-9a-zA-Z.]{2,19}+");
    }

    private static void validateIllegalCharacter(final String str, final String regexp) {
        if (str == null || !Pattern.matches(regexp, str)) {
            throw new IllegalArgumentException(str + " has illegal character");
        }
    }

    public static void validatePassword(final String password) {
        validateIllegalCharacter(password, "[0-9a-zA-Z]{6,30}+");
    }
}
