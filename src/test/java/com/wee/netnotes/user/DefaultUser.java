package com.wee.netnotes.user;

import com.wee.netnotes.domain.user.User;

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
    public DefaultUser(String name, String password) {
        this.name=name;
        if(nullOrBlank(name)){
            throw new IllegalArgumentException("User name can not be empty");
        }
        this.password=password;
    }

    private boolean nullOrBlank(String name) {
        return name==null||"".equals(name.trim());
    }

}
