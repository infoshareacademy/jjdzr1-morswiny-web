package com.isa.morswiny.usersDao;

import com.isa.morswiny.eventsDao.Dao;
import com.isa.morswiny.model.Event;
import com.isa.morswiny.users.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public User getUser(Integer id) {
        return entityManager.find(User.class, id);
    }

    public List<User> getAll() {
        Query all = entityManager.createQuery("FROM User");
        return (List<User>) all.getResultList();
    }

    public User getByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class);
        return query.setParameter("email", email).getSingleResult();
    }

    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    public User update(Integer id, User user) {

        User userFound = entityManager.find(User.class, id);
        userFound.setEmail(user.getEmail());
        userFound.setLogin(user.getLogin());
        userFound.setName(user.getName());
        userFound.setSurname(user.getSurname());
        user.setUserType(user.getUserType());
        return userFound;
    }
}
