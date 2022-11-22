package fr.uge.jee.hibernate.students.repository;

import fr.uge.jee.hibernate.employees.Employee;
import fr.uge.jee.hibernate.students.model.*;
import fr.uge.jee.hibernate.utils.PersistenceUtils;

import javax.persistence.EntityManagerFactory;

public class StudentRepository {
    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();


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
     * @param addressId
     */
    public boolean updateAddress(long studentId, long addressId) {
        return PersistenceUtils.inTransaction((em) -> {
            var student = em.find(Student.class, studentId);
            if (student == null) {
                return false;
            }
            var address = em.find(Address.class, addressId);
            if (address == null) {
                return false;
            }
            student.setAddress(address);
            return true;
        });
    }



    /**
     * Remove a Student's comment
     * @param studentId
     * @param studentId
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














}
