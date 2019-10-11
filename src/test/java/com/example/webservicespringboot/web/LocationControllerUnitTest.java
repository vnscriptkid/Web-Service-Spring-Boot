package com.example.webservicespringboot.web;

import com.example.webservicespringboot.service.LocationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;;

@RunWith(SpringRunner.class)
@WebMvcTest(LocationController.class)
public class LocationControllerUnitTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  LocationService locationService;

  @Test
  public void callApiWithoutAuthInfo() throws Exception {
    mockMvc.perform(get("/locations")).andExpect(status().is(401));
    verify(locationService, times(0)).retrieveLocations();

  }

  @Test
  public void getAllLocations() throws Exception {
    String rawBasicAuth = "admin:password";
    String encodedBasicAuth = Base64.getEncoder().withoutPadding().encodeToString(rawBasicAuth.getBytes());

    mockMvc.perform(get("/locations").header("Authorization", "Basic " + encodedBasicAuth + "="))
        .andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(content().json("[]"));

    verify(locationService, times(1)).retrieveLocations();
  }
}