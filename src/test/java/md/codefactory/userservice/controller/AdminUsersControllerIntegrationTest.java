package md.codefactory.userservice.controller;

import md.codefactory.userservice.mapping.UserMapper;
import md.codefactory.userservice.repository.UsersRepository;
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

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Sql(value = {"/sql-scripts/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class AdminUsersControllerIntegrationTest {

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
    public void should_find_all_users() throws Exception {
        //user with Role ADMIN
        this.mockMvc.perform(get("/api/admin/users/{username}", "dmitry1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        //user with Role USER
        this.mockMvc.perform(get("/api/admin/users/{username}", "vsea2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("errorMessage", is("Not enought rights !")));

    }

    @Test
    public void should_delete_user() throws Exception {

        this.mockMvc.perform(delete("/api/admin/users/{id}", 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}