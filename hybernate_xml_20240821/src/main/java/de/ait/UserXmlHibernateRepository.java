package de.ait;

import de.ait.entity.User;
import jakarta.persistence.EntityManager;

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
}
