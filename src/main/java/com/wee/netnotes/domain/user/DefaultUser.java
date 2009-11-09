package com.wee.netnotes.domain.user;

/**
 * Created by IntelliJ IDEA.
 * User: wee
 * Date: Nov 8, 2009
 * Time: 11:43:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultUser implements User {
    private String name;
    private String password;

    public DefaultUser(final String name, final String password) {
        this.name = name;
        UserValidator.validateName(name);
        this.password = password;
        UserValidator.validatePassword(password);
    }


    @Override
    public String password() {
        return password;
    }

    @Override
    public String name() {
        return name;
    }
}
