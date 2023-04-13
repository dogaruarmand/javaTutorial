package com.endava.database.repository;

import com.endava.database.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PeopleRepositoryTests {

    private Connection connection;
    private PeopleRepository repo;

    @BeforeEach
    void setUp() throws SQLException {
        connection = DriverManager.getConnection("jdbc:h2:~/peopletest".replace("~", System.getProperty("user.home")));
        connection.setAutoCommit(false); // it will not affect rows in db
        repo = new PeopleRepository(connection);
    }

    @AfterEach
    void tearDown() throws SQLException {
        if (connection != null){
            connection.close();
        }
    }

    @Test
    public void canSaveOnePerson() throws SQLException {
        Person john = new Person("John", "Smith", ZonedDateTime.of(1980, 11, 15, 15, 15, 0, 0, ZoneId.of("+3")));
        Person savedPerson = repo.save(john);
        assertThat(savedPerson.getId()).isGreaterThan(0);
    }

    @Test
    public void canSaveTwoPeople() {
        Person john = new Person("John", "Smith", ZonedDateTime.of(1980, 11, 15, 15, 15, 0, 0, ZoneId.of("+3")));
        Person bobby = new Person("Bobby", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3")));
        Person savedPerson1 = repo.save(john);
        Person savedPerson2 = repo.save(bobby);
        assertThat(savedPerson1.getId()).isNotEqualTo(savedPerson2.getId());
    }

    @Test
    public void canFindPersonById() {
        Person savedPerson = repo.save(new Person("test", "jackson", ZonedDateTime.now()));
        Person foundPerson = repo.findById(savedPerson.getId()).get();
        assertThat(foundPerson).isEqualTo(savedPerson);
    }

    @Test
    public void canFindAll() {
        repo.save(new Person("John", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John1", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John2", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John3", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John4", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John5", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John6", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John7", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("John8", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));

        List<Person> people = repo.findAll();
        assertThat(people.size()).isGreaterThanOrEqualTo(10);
    }

    @Test
    public void testPersonIdNotFound() {
        Optional<Person> foundPerson = repo.findById(-1L);
        assertThat(foundPerson).isEmpty();
    }

    @Test
    public void canGetCount() {
        long startCount = repo.count();
        repo.save(new Person("Bob", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        repo.save(new Person("Bob2", "Smith", ZonedDateTime.of(1982, 9, 15, 15, 13, 0, 0, ZoneId.of("+3"))));
        long endCount = repo.count();
        assertThat(endCount).isEqualTo(startCount + 2);
    }


    @Test
    public void canDelete() {
        Person savedPerson = new Person("John", "Smith", ZonedDateTime.of(1980, 11, 15, 15, 15, 0, 0, ZoneId.of("+3")));
        repo.save(savedPerson);
        long startCount = repo.count();
        repo.delete(savedPerson);
        long endCount = repo.count();
        assertThat(endCount).isEqualTo(startCount - 1);
    }

    @Test
    public void canDeleteMultiplePeople() {
        Person p1 = repo.save(new Person("John11", "Smith", ZonedDateTime.of(1980, 11, 15, 15, 15, 0, 0, ZoneId.of("+3"))));
        Person p2 = repo.save(new Person("John22", "Smith", ZonedDateTime.of(1980, 11, 15, 15, 15, 0, 0, ZoneId.of("+3"))));
        long startCount = repo.count();
        repo.delete(p1, p2);
        long endCount = repo.count();
        assertThat(endCount).isEqualTo(startCount - 2);
    }

    @Test
    public void canUpdate() {
        Person savedPerson = repo.save(new Person("John11", "Smith", ZonedDateTime.of(1980, 11, 15, 15, 15, 0, 0, ZoneId.of("+3"))));
        Person p1 = repo.findById(savedPerson.getId()).get();
        Person foundP = repo.findById(savedPerson.getId()).get();

        savedPerson.setSalary(new BigDecimal("73000.34"));
        repo.update(savedPerson);

        Person p2 = repo.findById(savedPerson.getId()).get();

        assertThat(p2.getSalary()).isNotEqualTo(p1.getSalary());
    }

    @Test
    public void loadData() {
        Files.llines(Path.of())
    }
}
