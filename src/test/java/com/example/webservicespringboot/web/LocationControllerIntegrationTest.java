package com.example.webservicespringboot.web;

// import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import com.example.webservicespringboot.entity.Location;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LocationControllerIntegrationTest {
  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void getAllLocations() {
    String url = "http://localhost:" + port + "/locations/";
    this.restTemplate = new TestRestTemplate("admin", "password");
    ResponseEntity<List> response = this.restTemplate.getForEntity(url, List.class);
    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
  }

  @Test
  public void getLocationByValidId() {
    String url = "http://localhost:" + port + "/locations/1";
    this.restTemplate = new TestRestTemplate("admin", "password");
    ResponseEntity<Location> response = this.restTemplate.getForEntity(url, Location.class);
    assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
  }

  @Test
  public void getLocationByInvalidId() {
    String url = "http://localhost:" + port + "/locations/123";
    this.restTemplate = new TestRestTemplate("admin", "password");
    ResponseEntity<Location> response = this.restTemplate.getForEntity(url, Location.class);
    assertThat(response.getStatusCode(), equalTo(HttpStatus.INTERNAL_SERVER_ERROR));
  }
}