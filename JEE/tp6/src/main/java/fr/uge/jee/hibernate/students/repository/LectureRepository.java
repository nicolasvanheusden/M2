package fr.uge.jee.hibernate.students.repository;

import fr.uge.jee.hibernate.students.model.Lecture;
import fr.uge.jee.hibernate.students.model.Student;
import fr.uge.jee.hibernate.utils.PersistenceUtils;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class LectureRepository {

    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();

    /**
     * Create a lecture with the given information
     * @param name university's name
     * @return the id of the newly created employee
     */
    public long create(String name) {
        return PersistenceUtils.inTransaction((em) -> {
            var lecture = new Lecture(name);
            em.persist(lecture);
            return lecture.getId();
        });
    }

    /**
     * Remove the lecture with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */
    public boolean delete(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var lecture = em.find(Lecture.class, id);
            if (lecture == null) {
                return false;
            }
            em.remove(lecture);
            return true;
        });
    }

    public List<Student> getStudentsFromLecture(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var q = "SELECT s FROM Student s left join fetch s.lectures where :id in (select l.id from s.lectures l)";
            var query = em.createQuery(q,Student.class);
            query.setParameter("id",id);
            return query.getResultList();
        });
    }
}
