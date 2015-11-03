package com.vschwarzer.gitresume.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Simple unit test for the REST endpoint used by the AngularJS app
 * Created by Vincent Schwarzer on 03.11.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class GitDataServiceTest {

    private final String user = "VincSch";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private void initAPITest() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Before
    public void setUp() throws Exception {
        initAPITest();
    }

    @Test
    public void testSearchEndpoint() throws Exception {

        mockMvc.perform(
                get("/api/git/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isMethodNotAllowed());

        mockMvc.perform(
                post("/api/git/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(user)
                        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
