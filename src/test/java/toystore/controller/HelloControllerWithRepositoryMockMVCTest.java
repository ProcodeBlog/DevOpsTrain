package toystore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import toystore.repository.Person;
import toystore.repository.PersonRepository;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloControllerWithRepository.class)
public class HelloControllerWithRepositoryMockMVCTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private PersonRepository personRepository;

    @Test public void shouldReturnHelloName() throws Exception {
        Person me = new Person("wat", "cha");
        given(personRepository.findByFirstName("wat")).willReturn(Optional.of(me));

        //Action and Assert
        mockMvc.perform(get("/hello/data/wat"))
                .andExpect(jsonPath("$.message").value("Hello wat"))
                .andExpect(status().is2xxSuccessful());
    }
}
