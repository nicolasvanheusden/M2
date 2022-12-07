package fr.uge.jee.hibernate.votes.repository;

import fr.uge.jee.hibernate.utils.PersistenceUtils;
import fr.uge.jee.hibernate.votes.model.User;
import fr.uge.jee.hibernate.votes.model.Video;

import javax.persistence.EntityManagerFactory;
import java.util.Objects;
import java.util.Optional;

public class UserRepository {

    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    /**
     * Create a user with the given information
     * @param name the user's name
     * @return the id of the newly created user
     */
    public long create(String name) {
        return PersistenceUtils.inTransaction((em) -> {
            var user = new User(name);
            em.persist(user);
            return user.getId();
        });
    }

    /**
     * Remove the user with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */
    public boolean delete(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var user = em.find(User.class, id);
            if (user == null) {
                return false;
            }
            em.remove(user);
            return true;
        });
    }


    /**
     * Retrieve the user with the given id
     * @param id
     * @return the user wrapped in an {@link Optional}
     */
    public Optional<User> get(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var user = em.find(User.class, id);
            return user == null ? Optional.empty() : Optional.of(user);
        });
    }



}
