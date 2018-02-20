package com.work.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.work.controller.ResultResource;

import static org.hamcrest.CoreMatchers.*;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CalculatorControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetAdditionTwoArguments() throws Exception {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/addition/2/3",
				ResultResource.class);
		assertThat(resultResource.getResult(), equalTo(5));
	}

	@Test
	public void testGetAdditionThreeArguments() throws Exception {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/addition/2/3/1",
				ResultResource.class);
		assertThat(resultResource.getResult(), equalTo(6));
	}

	@Test
	public void testGetSubtractionTwoArguments() throws Exception {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/subtraction/2/3",
				ResultResource.class);
		assertThat(resultResource.getResult(), equalTo(-1));
	}

	@Test
	public void testGetSubtractionThreeArguments() throws Exception {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/subtraction/2/3/1",
				ResultResource.class);
		assertThat(resultResource.getResult(), equalTo(-2));
	}

	@Test
	public void testGetMultiplicationTwoArguments() throws Exception {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/multiplication/2/3",
				ResultResource.class);
		assertThat(resultResource.getResult(), equalTo(6));
	}

	@Test
	public void testGetMultiplicationThreeArguments() throws Exception {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/multiplication/2/3/2",
				ResultResource.class);
		assertThat(resultResource.getResult(), equalTo(12));
	}

	@Test
	public void testGetDivision() throws Exception {
		ResultResource resultResource = this.restTemplate.getForObject(getPath() + "/division/6/3",
				ResultResource.class);
		assertThat(resultResource.getResult(), equalTo(2));
	}

	@Test
	public void testGetDivisionByZeroNotFound() throws Exception {
		ResponseEntity<String> response = restTemplate.getForEntity(getPath() + "/division/2/0", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.NOT_FOUND));
	}

	private String getPath() {
		return "http://localhost:" + port;
	}
}
