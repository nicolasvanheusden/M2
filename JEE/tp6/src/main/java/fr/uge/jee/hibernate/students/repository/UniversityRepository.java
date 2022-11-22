package fr.uge.jee.hibernate.students.repository;

import fr.uge.jee.hibernate.students.model.University;
import fr.uge.jee.hibernate.utils.PersistenceUtils;

import javax.persistence.EntityManagerFactory;

public class UniversityRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();


    /**
     * Create a university with the given information
     * @param name university's name
     * @return the id of the newly created employee
     */
    public long create(String name) {
        return PersistenceUtils.inTransaction((em) -> {
            var university = new University(name);
            em.persist(university);
            return university.getId();
        });
    }

    /**
     * Remove the university with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */
    public boolean delete(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var university = em.find(University.class, id);
            if (university == null) {
                return false;
            }
            em.remove(university);
            return true;
        });
    }
}
