package com.yoke.controller;

import com.yoke.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest extends BaseTest {
    @Autowired
    private HomeController homeController;

    @Test
    public void testHome() throws Exception {
        MockMvc mock = standaloneSetup(homeController).build();
        mock.perform(get("/"))
                .andExpect(view().name("home"));
    }
}
