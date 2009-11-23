package com.wee.netnotes.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: wee
 * Date: Nov 8, 2009
 * Time: 11:43:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class DefaultUser implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;   
    private  String name;
    private  String password;
    

    public DefaultUser(final String name, final String password) {
        this.name = name;
        UserValidator.validateName(name);
        this.password = password;
        UserValidator.validatePassword(password);
    }


    @Override
    public final String password() {
        return password;
    }

    @Override
    public final String name() {
        return name;
    }
}
