package com.softuni.movietopia.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import com.softuni.movietopia.model.entities.UserEntity;
import com.softuni.movietopia.model.entities.UserRoleEntity;
import com.softuni.movietopia.model.entities.enums.UserRole;
import com.softuni.movietopia.repository.UserRepository;
import com.softuni.movietopia.repository.UserRoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @BeforeEach
    public void init() {
        UserRoleEntity roleEntity = new UserRoleEntity();
        roleEntity.setRole(UserRole.USER);
        userRoleRepository.save(roleEntity);

        UserEntity userEntity = new UserEntity()
                .setEmail("p@p.p")
                .setUsername("pesho")
                .setFullName("pesho pesho")
                .setPassword("11111")
                .setRoles(List.of(roleEntity));

        userRepository.save(userEntity);
    }

    @AfterEach
    public void tearDown() {
        userRepository.deleteAll();
        userRoleRepository.deleteAll();
    }


    @Test
    void testRegForm () throws Exception {
        mockMvc.
                perform(
                        get("/users/register")).
                andExpect(status().isOk()).
                andExpect(view().name("register"));
    }

    @Test
    public void getLoginReturnLoginPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get( "/users/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("login"));
    }

//    @Test
//    public void loginErrorRedirectBackToLogin() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/users/login-error")
//                .param("email", "qwe@qwe.qwe")
//                .param("password", "111")
//                .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(flash().attributeExists("bad_credentials", "userLoginBindingModel"))
//                .andExpect(redirectedUrl("/users/login"));
//    }
//
//    @Test
//    public void getRegister_ReturnAttributeAndView () throws Exception {
//        mockMvc.perform(get( "/users/register"))
//                .andExpect(model().attributeExists("userRegisterBindingModel"))
//                .andExpect(view().name("register"));
//    }
//
//    @Test
//    public void register_NotMatchingPasswords_ReturnViewRegister() throws Exception {
//        mockMvc.perform(post("/users/register")
//                .param("email", "x@y.z")
//                .param("password", "123")
//                .param("rePassword", "456")
//                .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(redirectedUrl("/users/register"))
//                .andExpect(flash().attribute("notMatch", true));
//    }

    @Test
    void testRegUser() throws Exception {
        userRepository.deleteAll();
        Assertions.assertEquals(0, userRepository.count());

        mockMvc.perform(post("/users/register").
                param("username", "pesho").
                param("fullName", "pesho peshov").
                param("email", "pesho@pesho.bg").
                param("password", "qwerty").
                param("confirmPassword", "qwerty").
                with(csrf()).
                contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andExpect(status().is3xxRedirection());

        Assertions.assertEquals(1, userRepository.count());

        Optional<UserEntity> newUser = userRepository.findByUsername("pesho");

        Assertions.assertTrue(newUser.isPresent());

    }
}