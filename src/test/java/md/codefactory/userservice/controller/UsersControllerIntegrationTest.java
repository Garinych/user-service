package md.codefactory.userservice.controller;

import md.codefactory.userservice.domain.User;
import md.codefactory.userservice.mapping.UserMapper;
import md.codefactory.userservice.mapping.dto.NewUserDto;
import md.codefactory.userservice.mapping.dto.UpdateUserDto;
import md.codefactory.userservice.repository.UsersRepository;
import md.codefactory.userservice.util.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Sql(value = {"/sql-scripts/data.sql"})
public class UsersControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UsersRepository usersRepository;

    private MockMvc mockMvc;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void should_save_new_user() throws Exception {
        User newUser = new User();
        newUser.setFirstName("Vasea");
        newUser.setLastName("Gliuck");
        newUser.setEmail("vasea.g@gmail.com");
        newUser.setPhoneNumber("069332211");
        newUser.setUsername("vasea.gliuck");
        newUser.setPassword("vasea123");

        NewUserDto newUserDto = userMapper.userToNewUserDto(newUser);

        this.mockMvc.perform(post("/api/users")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectAsBytes(newUserDto)))
                .andExpect(status().isCreated());
    }

    @Test
    public void should_show_user_profile() throws Exception {

        this.mockMvc.perform(get("/api/users/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/api/users/{id}", -1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("errorMessage", is("User with id = -1 not found!")));

    }

    @Test
    public void should_update_user_profile() throws Exception {

        UpdateUserDto updatedUser = new UpdateUserDto();
        updatedUser.setFirstName("Vasea");
        updatedUser.setLastName("Gliuc");
        updatedUser.setEmail("vsea@codefactory.com");
        updatedUser.setPhoneNumber("069545452");
        updatedUser.setUsername("vsea2");
        updatedUser.setPassword("jora123");

        this.mockMvc.perform(put("/api/users/{id}", 2)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectAsBytes(updatedUser)))
                .andExpect(status().isOk());

        this.mockMvc.perform(put("/api/users/{id}", 3)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.objectAsBytes(updatedUser)))
                .andExpect(status().isConflict());

    }

}