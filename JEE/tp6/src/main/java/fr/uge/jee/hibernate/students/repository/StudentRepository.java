package fr.uge.jee.hibernate.students.repository;

import fr.uge.jee.hibernate.employees.Employee;
import fr.uge.jee.hibernate.students.model.*;
import fr.uge.jee.hibernate.utils.PersistenceUtils;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class StudentRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();
    private final CommentRepository commentRepository = new CommentRepository();


    public StudentRepository() {
    }


    /**
     * Create a Student
     * @param
     * @return the id of the newly created employee
     */
    public long create(Student student) {
        return PersistenceUtils.inTransaction((em) -> {
            em.persist(student);
            return student.getId();
        });
    }

    /**
     * Remove the student with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */
    public boolean delete(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var student = em.find(Student.class, id);
            if (student == null) {
                return false;
            }
            em.remove(student);
            return true;
        });
    }

    /**
     * add a lecture to a Student
     * @param studentId
     * @param lectureId
     */
    public boolean addLecture(long studentId, long lectureId) {
        return PersistenceUtils.inTransaction((em) -> {
            var student = em.find(Student.class, studentId);
            if (student == null) {
                return false;
            }
            var lecture = em.find(Lecture.class, lectureId);
            if (lecture == null) {
                return false;
            }
            student.addLecture(lecture);
            return true;
        });
    }

    /**
     * update Student's university
     * @param studentId
     * @param universityId
     */
    public boolean updateUniversity(long studentId, long universityId) {
        return PersistenceUtils.inTransaction((em) -> {
            var student = em.find(Student.class, studentId);
            if (student == null) {
                return false;
            }
            var university = em.find(University.class, universityId);
            if (university == null) {
                return false;
            }
            student.setUniversity(university);
            return true;
        });
    }


    /**
     * update Student's address
     * @param studentId
     * @param address new address
     */
    public boolean updateAddress(long studentId, Address address) {
        Objects.requireNonNull(address);
        return PersistenceUtils.inTransaction((em) -> {
            var student = em.find(Student.class, studentId);
            if (student == null) {
                return false;
            }
            student.setAddress(address);
            return true;
        });
    }



    /**
     * Remove a Student's comment
     * @param studentId
     * @param commentId
     * @return true if the removal was successful
     */
    public boolean removeComment(long studentId, long commentId) {
        return PersistenceUtils.inTransaction((em) -> {
            var student = em.find(Student.class, studentId);
            if (student == null) {
                return false;
            }
            var comment = em.find(Comment.class, commentId);
            if (comment == null) {
                return false;
            }

            student.removeComment(comment);
            em.remove(comment);
            return true;
        });
    }

    /**
     * Remove a Student's comment
     * @param studentId
     * @param comment the comment
     * @return commentId if the adding was successful
     */
    public long addComment(long studentId, String message) {
        var commentId = commentRepository.create(message);
        return PersistenceUtils.inTransaction((em) -> {
            var student = em.find(Student.class, studentId);
            if (student == null) {
                return null;
            }
            var comment = em.find(Comment.class, commentId);
            student.addComment(comment);
            return comment.getId();
        });
    }


    public Set<Lecture> getLectureFromStudent(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var q = "SELECT s FROM Student s left join fetch s.lectures where s.id=:id";
            var query = em.createQuery(q, Student.class);
            query.setParameter("id",id);
            return query.getSingleResult().getLectures();

        });
    }







}
