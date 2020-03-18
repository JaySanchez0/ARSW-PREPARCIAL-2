package com.airfinder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.airfinder.http.HttpConnectionService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;
/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppTest {
   @Autowired
   private MockMvc mock;
   @Autowired
   private HttpConnectionService con;
   @Test
   public void shouldBeGetGoodByURL() {
	  try {
		mock.perform(get("/airports/Berlin")).andExpect(status().is2xxSuccessful());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   @Test
   public void shouldBeGetText() {
	   assertTrue(con.getAirports("Berlin")!=null && con.getAirports("Berlin").length()>2);
   }
}
