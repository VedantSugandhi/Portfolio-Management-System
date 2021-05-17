package com.cognizant.portfoliomanagement.WebPortal;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.portfolio.webportal.controller.WebPortalController;

@SpringBootTest
class WebPortalApplicationTest {

	@Autowired
    private WebPortalController controller;

    @Autowired
    private MockMvc mvc;
    
    @Test
    void contextLoads() {
        assertNotNull(controller);
    }
    
    @Test
    void testGetLogout() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/logout"))
         .andExpect(status().isOk());

    }
    
    @Test
    void testGetLogin() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/"))
         .andExpect(status().isOk());

    }
        
    @Test
    void testGetHomePage() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/Home"))
         .andExpect(status().isOk());

    }
}
