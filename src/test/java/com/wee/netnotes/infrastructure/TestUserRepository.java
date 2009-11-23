package com.wee.netnotes.infrastructure;

import org.junit.Before;
import org.junit.Test;

import com.wee.netnotes.domain.user.User;
import com.wee.netnotes.domain.user.UserRepositoryException;
import com.wee.netnotes.domain.user.Users;
import com.wee.netnotes.infrastructure.persistence.UserRepostiry;
import com.wee.netnotes.infrastructure.persistence.hibernate.UserRepostiryHN;

/**
 * Created by IntelliJ IDEA. User: wee Date: Nov 16, 2009 Time: 9:38:19 PM To
 * change this template use File | Settings | File Templates.
 */
public class TestUserRepository {
    private UserRepostiry userRepository;

    @Before
    public void setup() {
        userRepository = new UserRepostiryHN();
    }

    @Test
    public void testStoreValidUsers() {
        String[][] usersST = { { "weejud", "password" },
                { "obamar", "iamobarmar" } };
        testStoreUsersWithNameAndPassword(usersST);
    }

    private void testStoreUsersWithNameAndPassword(String[][] usersST) {
        for (String[] userST : usersST) {
            testStoreUserWithNameAndPassword(userST);
        }
    }

    private void testStoreUserWithNameAndPassword(String[] userST) {
        User user = Users.registry(userST[0], userST[1]);
        userRepository.store(user);
    }

    @Test(expected = UserRepositoryException.class)
    public void testStoreExistUser() {
        String[] user = { "weejud", "password" };
        String[][] users = { user, user };

        testStoreUsersWithNameAndPassword(users);
    }
}
