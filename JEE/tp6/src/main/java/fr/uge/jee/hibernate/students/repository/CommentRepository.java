package fr.uge.jee.hibernate.students.repository;

import fr.uge.jee.hibernate.students.model.Comment;
import fr.uge.jee.hibernate.students.model.University;
import fr.uge.jee.hibernate.utils.PersistenceUtils;

import javax.persistence.EntityManagerFactory;

public class CommentRepository {

    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    /**
     * Create a comment with the given information
     * @param message comment message
     * @return the id of the newly created employee
     */
    public long create(String message) {
        return PersistenceUtils.inTransaction((em) -> {
            var comment = new Comment(message);
            em.persist(comment);
            return comment.getId();
        });
    }

    /**
     * Remove the comment with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */
    public boolean delete(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var comment = em.find(University.class, id);
            if (comment == null) {
                return false;
            }
            em.remove(comment);
            return true;
        });
    }
}
