package com.example.aivlemini7springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class NaverApiController {

  @Value("${naver.api.client-id}")
  private String clientId;

  @Value("${naver.api.client-secret}")
  private String clientSecret;

  @GetMapping("/proxy/directions")
  public ResponseEntity<String> getDirections(@RequestParam String start,
      @RequestParam String goal) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
    headers.set("X-NCP-APIGW-API-KEY", clientSecret);

    String url =
        "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving?start=" + start + "&goal="
            + goal;

    HttpEntity<String> entity = new HttpEntity<>(headers);

    try {
      ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity,
          String.class);
      return ResponseEntity.ok(response.getBody());
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error: " + e.getMessage());
    }
  }
}
