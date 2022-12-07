package fr.uge.jee.hibernate;

import fr.uge.jee.hibernate.students.model.Address;
import fr.uge.jee.hibernate.students.model.Lecture;
import fr.uge.jee.hibernate.students.model.Student;
import fr.uge.jee.hibernate.students.repository.CommentRepository;
import fr.uge.jee.hibernate.students.repository.LectureRepository;
import fr.uge.jee.hibernate.students.repository.StudentRepository;
import fr.uge.jee.hibernate.students.repository.UniversityRepository;

import java.util.Collections;

public class Application {

    public static void main(String[] args) {
        /*
        var repository = new EmployeeRepository();

        repository.create("Bob", "Moran", 500);
        repository.create("Bob", "Dylan", 600);
        repository.create("Lisa", "Simpson", 100);
        repository.create("Marge", "Simpson", 1000);
        repository.create("Homer", "Simpson", 450);

        repository.delete(3L);
        repository.update(5L, 550);

        repository.updateSalary(1L);
        repository.updateSalary(3L);
        repository.updateSalary(5L);

        System.out.println(repository.getAll());

        System.out.println(repository.getAllByFirstName("Bob"));*/

        var studentRepository = new StudentRepository();
        var universityRepository = new UniversityRepository();
        var lectureRepository = new LectureRepository();
        var commentRepository = new CommentRepository();

        // Addresses initialization
        var addressOne = new Address("10 address of Steve");
        var addressTwo = new Address("20 address of Shatox");

        // Lectures initialization
        var lectureOne = new Lecture("Back-end");
        var lectureTwo = new Lecture("Front-end");

        // Students initialization
        var studentOne = new Student("Steve", "Chen", addressOne, null, Collections.emptyList(), Collections.emptySet());
        var studentTwo = new Student("Shatox", "Chen", addressTwo, null, Collections.emptyList(), Collections.emptySet());

        // Universities creation in DB
        var universityOneId = universityRepository.create("Gustave Eiffel");
        var universityTwoId = universityRepository.create("ESIPE");

        // Lecture creation in DB
        var lectureOneId = lectureRepository.create("Back-end");
        var lectureTwoId = lectureRepository.create("Front-end");

        // Student creation in DB
        var studentOneId = studentRepository.create(studentOne);
        var studentTwoId = studentRepository.create(studentTwo);

        // University deletion in DB
        universityRepository.delete(universityOneId);

        // Lecture deletion in DB
        lectureRepository.delete(lectureTwoId);

        // Add lecture for one student
        studentRepository.addLecture(studentOneId, lectureOneId);
        studentRepository.addLecture(studentTwoId, lectureOneId);

        // Update student university
        studentRepository.updateUniversity(studentTwoId, universityTwoId);

        // Update student address
        var newAddress = new Address("50 Second address");
        studentRepository.updateAddress(studentOneId, newAddress);

        // Add comment for one student
        var commentOneId = studentRepository.addComment(studentOneId, "This is a new commentary for Steve");
        var commentTwoId = studentRepository.addComment(studentTwoId, "This is a new commentary for Shatox");

        // Delete comment for one student
        studentRepository.removeComment(studentOneId, commentOneId);

        // Get students for a lecture
        lectureRepository.getStudentsFromLecture(lectureOneId).forEach(student -> System.out.println(student.getId()));

        // Get lectures for a student
        System.out.println(studentRepository.getLectureFromStudent(studentTwoId));


    }
}
