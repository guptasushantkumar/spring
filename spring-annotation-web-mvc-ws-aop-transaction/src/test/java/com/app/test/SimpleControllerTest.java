package com.app.test;

import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.app.controller.DefaultController;

public class SimpleControllerTest {

	@Test
	public void testControllerJSONResponse() throws Exception {

		standaloneSetup(new DefaultController())
				.build()
				.perform(
						get("/springjson").accept(
								MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("{\"id\":23,\"firstname\":\"meghna\",\"lastname\":\"Naidu\"}"));

	}
}
