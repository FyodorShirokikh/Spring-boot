package com.example.springboot.repository;

import com.example.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository{
    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteById(Long id) {
        User tempUser = entityManager.find(User.class, id);
        entityManager.remove(tempUser);
    }
    @Override
    public void edit(Long id, User user) {
        User tempUser = entityManager.find(User.class, id);
        tempUser.setId(user.getId());
        tempUser.setName(user.getName());
        tempUser.setLastname(user.getLastname());
        tempUser.setAge(user.getAge());
        entityManager.merge(tempUser);
    }
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User").getResultList();
    }
}
