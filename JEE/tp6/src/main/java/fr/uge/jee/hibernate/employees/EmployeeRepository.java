package fr.uge.jee.hibernate.employees;

import fr.uge.jee.hibernate.utils.PersistenceUtils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository {

    private final EntityManagerFactory entityManagerFactory = PersistenceUtils.getEntityManagerFactory();


    /**
     * Create an employee with the given information
     * @param firstName
     * @param lastName
     * @param salary
     * @return the id of the newly created employee
     */
    public long create(String firstName, String lastName, int salary) {
        return PersistenceUtils.inTransaction((em) -> {
            var employee = new Employee(firstName,lastName, salary);
            em.persist(employee);
            return employee.getId();
        });
    }

    /**
     * Remove the employee with the given id from the DB
     * @param id
     * @return true if the removal was successful
     */
    public boolean delete(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var employee = em.find(Employee.class, id);
            if (employee == null) {
                return false;
            }
            em.remove(employee);
            return true;
        });
    }

    /**
     * Update the salary of the employee with the given id
     * @param id
     * @param salary
     * @return true if the removal was successful
     */
    public boolean update(long id, int salary) {
        return PersistenceUtils.inTransaction((em) -> {
            var employee = em.find(Employee.class, id);
            if (employee == null) {
                return false;
            }
            employee.setSalary(salary);
            return true;
        });
    }

    /**
     * Retrieve the employee with the given id
     * @param id
     * @return the employee wrapped in an {@link Optional}
     */
    public Optional<Employee> get(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var employee = em.find(Employee.class, id);
            return employee == null ? Optional.empty() : Optional.of(employee);
        });
    }

    /**
     * Return the list of the employee in the DB
     */
    public List<Employee> getAll() {
        return PersistenceUtils.inTransaction((em) -> {
            var request = "SELECT DISTINCT e from Employee e";
            TypedQuery<Employee> query = em.createQuery(request ,Employee.class);
            return query.getResultList();
        });

    }

    /**
     * Update the salary of the employee with the given id
     * add 10% to the original salary
     * add 100€ if salary < 1000€
     * @param id
     */
    public boolean updateSalary(long id) {
        return PersistenceUtils.inTransaction((em) -> {
            var employee = em.find(Employee.class, id);
            if (employee == null) {
                return false;
            }
            var salary = employee.getSalary();
            if (salary < 1000) {
                salary+=100;
            } else {
                salary *= 1.1;
            }
            employee.setSalary(salary);
            return true;
        });
    }

    /**
     * Return the list of the employee in the DB
     * @param firstName
     */
    public List<Employee> getAllByFirstName(String firstName) {
        return PersistenceUtils.inTransaction((em) -> {
            var request = "SELECT DISTINCT e from Employee e WHERE e.firstName= :firstName";
            TypedQuery<Employee> query = em.createQuery(request ,Employee.class);
            query.setParameter("firstName",firstName);
            return query.getResultList();
        });
    }


}
