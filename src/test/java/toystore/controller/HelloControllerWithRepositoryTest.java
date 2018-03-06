package toystore.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import toystore.domain.Hello;
import toystore.repository.Person;
import toystore.repository.PersonRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
public class HelloControllerWithRepositoryTest {

    HelloControllerWithRepository controllerWithRepository;

    @Mock
    PersonRepository personRepository;

    @Before
    public  void init(){
        initMocks(this);
        this.controllerWithRepository = new HelloControllerWithRepository(personRepository);
    }

    @Test
    public void shouldReturnHelloName() {
        Person me = new Person("wat", "cha");
        given(personRepository.findByFirstName("wat")).willReturn(Optional.of(me));

        //Action
        Hello hello = this.controllerWithRepository.sayHi("wat");

        //Assert
        assertEquals("Hello wat", hello.getMessage());
    }
}