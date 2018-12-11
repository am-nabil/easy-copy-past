package org.nynl.easycopypast.repository;

import org.hibernate.SessionFactory;
import org.nynl.easycopypast.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByUsername(String username) {
        return sessionFactory.getCurrentSession().get(User.class, username);
    }
}
