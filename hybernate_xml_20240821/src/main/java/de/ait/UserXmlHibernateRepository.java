package de.ait;

import de.ait.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UserXmlHibernateRepository {
    private final HibernateConfiguration hibernateConfiguration;
    private final EntityManager entityManager;

    public UserXmlHibernateRepository(HibernateConfiguration hibernateConfiguration) {
        this.hibernateConfiguration = hibernateConfiguration;
        entityManager = hibernateConfiguration.getEntityManager();
    }

    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    public User create(User user) {

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error creating user" + user,e);
        }
    }
}
