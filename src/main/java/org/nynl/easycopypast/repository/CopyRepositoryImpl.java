package org.nynl.easycopypast.repository;

import org.nynl.easycopypast.model.Copy;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("copyRepository")
@Transactional
public class CopyRepositoryImpl implements CopyRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Copy> getCopies() {
        return sessionFactory.getCurrentSession().createQuery("from Copy").list();
    }
}
