package org.nynl.easycopypast.repository;

import javassist.NotFoundException;
import org.nynl.easycopypast.model.Copy;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;

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

    @Override
    public void updateOrInsertCopy(String username, String content, String machine_ip){
        try {
            getCopiesByUsername(username);
            updateCopy(username, content, machine_ip);
        } catch (NotFoundException e) {
            createNewCopy(username, content, machine_ip);
        }

    }

    private void updateCopy(String username, String content, String machine_ip) {
        Query query = sessionFactory.getCurrentSession().createQuery("update Copy set content = :content, machine_ip = :machine_ip where username = :username");
        query.setParameter("content", content);
        query.setParameter("machine_ip", machine_ip);
        query.setParameter("username", username);
        query.executeUpdate();
    }

    private void createNewCopy(String username, String content, String machine_ip) {
        Copy newCopy = new Copy();
        newCopy.setMachineIP(machine_ip);
        newCopy.setContent(content);
        newCopy.setUserId(username);
        sessionFactory.getCurrentSession().save(newCopy);
    }

    private List<Copy> getCopiesByUsername(String username) throws NotFoundException {
        List<Copy> list = sessionFactory.getCurrentSession().createQuery("from Copy where username = :username").setParameter("username", username).list();
        if(list != null && !list.isEmpty()){
            return list;
        } else {
            throw new NotFoundException("No copy found for username : "+username);
        }

    }

    @Override
    public Copy paste(String username) {
        try {
            List<Copy> list = getCopiesByUsername(username);
            return list.get(0);
        } catch (NotFoundException e) {
            return null;
        }
    }
}
