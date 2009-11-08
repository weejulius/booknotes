package com.wee.netnotes.user;

import com.wee.netnotes.domain.user.User;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: wee
 * Date: Nov 8, 2009
 * Time: 11:31:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestUser {

    @Test(expected = IllegalArgumentException.class)
    public void testUnamedUser(){
       User user=new DefaultUser(null,"pass");        
    }

}
