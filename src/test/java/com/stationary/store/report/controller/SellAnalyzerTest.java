package com.stationary.store.report.controller;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.annotation.PostConstruct;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SellAnalyzerTest {
	@LocalServerPort
	private int port;

	private String uri;

	@PostConstruct
	public void init() {
		uri = "http://localhost:" + port;
	}

	@Test
	public void getHighestSellingItemSuccess() {
		given().when().get(uri + "/store/api/highestSellingItem/2023-01-01").then().log().all().assertThat()
				.statusCode(200);
	}
	
	@Test
	public void getHighestSellingItemNotFound() {
		given().when().get(uri + "/store/api/highestSellingItem/2023-01-08").then().log().all().assertThat()
				.statusCode(404);
	}

	@Test
	public void getHighestProfitItemSuccess() {
		given().when().get(uri + "/store/api/highestProfitItem/2023-01-01").then().log().all().assertThat()
				.statusCode(200);
	}
	
	@Test
	public void getHighestProfitItemFailure() {
		given().when().get(uri + "/store/api/highestProfitItem/2023-01-08").then().log().all().assertThat()
				.statusCode(404);
	}
	
	
}
