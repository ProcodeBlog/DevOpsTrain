package toystore.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void shouldFoundPerson() {
        Person me = new Person("wat", "cha");
        personRepository.save(me);

        //Act
        Optional<Person> person = personRepository.findByFirstName("wat");

        //Assert
        assertEquals("wat", person.get().getFirstName());
        assertEquals("cha", person.get().getLastName());
    }
}