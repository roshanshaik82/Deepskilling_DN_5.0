# Hands-on 4: Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)

- JPA stands for Java Persistence API.
- It is a Java specification (JSR 338) for managing relational data in Java applications.
- It defines interfaces and standards for Object Relational Mapping (ORM).
- JPA itself does not provide an implementation.
- Hibernate, EclipseLink, and OpenJPA are implementations of JPA.



## Hibernate

- Hibernate is an ORM framework.
- It is one of the most popular implementations of JPA.
- It converts Java objects into database tables automatically.
- Hibernate provides additional features beyond the JPA specification.
- Developers need to manage sessions and transactions manually.

### Hibernate Example

```java
Session session = factory.openSession();
Transaction tx = session.beginTransaction();
session.save(employee);
tx.commit();
session.close();
```



## Spring Data JPA

- Spring Data JPA is a Spring module built on top of JPA.
- It is not a JPA implementation.
- It uses Hibernate (or another JPA provider) internally.
- It reduces boilerplate code by providing ready-made repository interfaces.
- Transaction management is simplified using `@Transactional`.

### Spring Data JPA Example

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {
    employeeRepository.save(employee);
}
```



## Comparison

| Feature | JPA | Hibernate | Spring Data JPA |
|---------|-----|-----------|-----------------|
| Type | Specification | ORM Framework | Spring Module |
| Implementation | No | Yes | No |
| Boilerplate Code | Moderate | High | Very Low |
| Transaction Management | Via Provider | Manual | Automatic using Spring |
| Repository Support | No | No | Yes (`JpaRepository`) |
| Ease of Use | Medium | Medium | Easy |

---

## Conclusion

- **JPA** defines standards for persistence.
- **Hibernate** is an implementation of JPA and provides ORM functionality.
- **Spring Data JPA** simplifies database operations by reducing boilerplate code and using JPA implementations like Hibernate internally.

Spring Data JPA is the preferred choice for modern Spring Boot applications because it is easier to use, requires less code, and provides built-in repository support.