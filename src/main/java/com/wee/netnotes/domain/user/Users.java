package com.wee.netnotes.domain.user;

/**
 * Created by IntelliJ IDEA.
 * User: wee
 * Date: Nov 9, 2009
 * Time: 9:07:25 AM
 * To change this template use File | Settings | File Templates.
 */
public final class Users {
    protected Users() {
        throw new UnsupportedOperationException();
    }

    public static User registry(final String name, final String password) {
        return new DefaultUser(name, password);
    }
}
