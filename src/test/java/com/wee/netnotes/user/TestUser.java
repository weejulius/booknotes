package com.wee.netnotes.user;

import com.wee.netnotes.domain.user.Users;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 * User: wee
 * Date: Nov 8, 2009
 * Time: 11:31:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestUser {
    private static final String PASSWORD = "password";
    private static final String NAME = "name";

    @Test
    public void testRegistryIllegalNameUser() {
        Users.registry("weejud", PASSWORD);
        Users.registry("123456", PASSWORD);
        Users.registry("wee123454", PASSWORD);
        Users.registry("wee.123454", PASSWORD);
        Users.registry("WEE.123454", PASSWORD);
        Users.registry("~wee.123454", PASSWORD);
        testIllegalName("wee~.123454", "~ is in the wrong position");
        testIllegalName("abc ccc", "space is illegal");
        testIllegalName("abc^ccc", "^ is illegal");
        testIllegalName("abc*z12", "* is illegal");
        testIllegalName("aa","aa:length is too short");
        testIllegalName("aaaawwwww1232131232131231312313121212","name is too long");
        testIllegalName("","name can not be space");
        testIllegalName("  ","name can not be spaces");
        testIllegalName(null,"name can not be null");

    }

    @Test
    public void testRegistryIllegalPasswordUser(){
        Users.registry(NAME,"aabbaa");
        Users.registry(NAME,"1234556");
        Users.registry(NAME,"123453WERsfsdfwerw23432ewer");
        testIllegalPassword("AA","password is too short");
        testIllegalPassword("WEE123124131232131231231231232113121312113123","password is too long");
        testIllegalPassword("1abcsdf~sdfds","~ is illegal character");
        testIllegalPassword("lacsfd sdfdsf","space is illegal character");
        testIllegalPassword(null,"null is not allowed.");
        testIllegalPassword("","empty is not allowed");
        testIllegalPassword("  ","spaces is not allowed");
        
    }

    private void testIllegalName(String name, String message) {
        testIllegalString(name,PASSWORD,message);
    }

    private void testIllegalPassword(String password,String message){
        testIllegalString(NAME,password,message);
    }

    private void testIllegalString(String name,String password, String message) {
        try {
            Users.registry(name, password);
            fail(message);
        } catch (IllegalArgumentException e) {

        }
    }


}
