package dao;

import model.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoimp implements UserDao {

    private final EntityManager entityManager;
@Autowired
    public UserDaoimp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Transactional
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
}

    @Override
    public void removeUserById(long id) {
    User user = entityManager.find(User.class,id);
    entityManager.remove(user);
    }
}
