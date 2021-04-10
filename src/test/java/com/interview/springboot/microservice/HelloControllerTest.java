package com.interview.springboot.microservice;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.interview.springboot.microservice.controller.SpringBootRestController;
import com.interview.springboot.microservice.model.BankFinance;


@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private SpringBootRestController springBootRestController;

	@Test
	public void getVersion() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/bank/info/version").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
				//andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void getAllData() throws Exception {
		String uri = "/bank/getAllData";
		mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void getBankData() throws Exception {
		BankFinance bf = new BankFinance();
		bf.setFirstName("Rakesh");
		bf.setId(1);
		given(springBootRestController.getBankDataById(bf.getId())).willReturn(bf);

		mvc.perform(MockMvcRequestBuilders.get("/bank/getData/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("firstName", is(bf.getFirstName())));
		// .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void deleteBankData() throws Exception {
		String uri = "/bank/delete/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		/*
		 * String content = mvcResult.getResponse().getContentAsString();
		 * assertEquals(content, "Product is deleted successsfully");
		 */
	}
}