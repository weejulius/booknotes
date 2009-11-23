/**
 * 
 */
package com.wee.netnotes.infrastructure.persistence;

import com.wee.netnotes.domain.user.User;

/**
 * @author Julius.Yu
 * 
 */
public interface UserRepostiry {

    void store(User user);

    User find(String name);

}
