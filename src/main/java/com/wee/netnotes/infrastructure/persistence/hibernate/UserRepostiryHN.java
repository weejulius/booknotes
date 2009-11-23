package com.wee.netnotes.infrastructure.persistence.hibernate;


import com.wee.netnotes.domain.user.User;
import com.wee.netnotes.infrastructure.persistence.UserRepostiry;

public class UserRepostiryHN extends AbstractRepositoryHN implements UserRepostiry {

    @Override
    public void store(User user) {
        if (existent(user)) {
            throw new ExistentUserRepositoryException();
        }

    }

    private boolean existent(User user) {
        User foundUser=find(user.name());
        return foundUser!=null;
    }

    public User find(String name) {       
        return (User)createQuery("SELECT user.name from User user where user.name:=name")
        .setParameter("name",name)
        .getSingleResult();
    }

}
