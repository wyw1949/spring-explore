package com.yoke.controller;

import com.yoke.BaseTest;
import com.yoke.model.Spitter;
import com.yoke.repository.SpitterRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SpitterControllerTest extends BaseTest {

    @Test
    public void showRegisterFormTest() throws Exception {
        MockMvc mock = MockMvcBuilders.standaloneSetup(new SpitterController()).build();
        mock.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

}
