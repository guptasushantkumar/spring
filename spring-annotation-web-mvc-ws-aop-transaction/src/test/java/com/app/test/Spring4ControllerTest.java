package com.app.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.app.config.AppConfiguration;
import com.app.config.HbaseConfiguration;
import com.app.config.HibernateConfiguration;
import com.app.controller.DefaultController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfiguration.class,
		HbaseConfiguration.class, HibernateConfiguration.class })
@WebAppConfiguration
public class Spring4ControllerTest {

	@Autowired
	private DefaultController defaultController;

	@Test
	@Ignore
	public void testControllerJSONResponse() throws Exception {

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(
				this.defaultController).build();
		mockMvc.perform(
				get("/springjson").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.string("{\"id\":23,\"firstname\":\"meghna\",\"lastname\":\"Naidu\"}"));

	}

	@Test
	public void testControllerRedirection() throws Exception {

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(
				this.defaultController).build();
		ResultMatcher msg = MockMvcResultMatchers.model().attribute("greeting",
				"Hello World from Spring 4 MVC");
		ResultMatcher redirect = MockMvcResultMatchers.forwardedUrl("welcome");
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(msg)
				.andExpect(redirect);

	}
}
