package com.wee.netnotes.domain.user;

import com.wee.netnotes.domain.user.User;

/**
 * Created by IntelliJ IDEA.
 * User: wee
 * Date: Nov 9, 2009
 * Time: 9:07:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class Users {
    public static User registry(String name, String password) {
        return new DefaultUser(name,password);
    }
}
