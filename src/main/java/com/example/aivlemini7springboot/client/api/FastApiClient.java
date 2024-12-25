package com.example.aivlemini7springboot.client.api;


import com.example.aivlemini7springboot.client.dto.HospitalApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "fastApiClient", url = "${hospital.api.host}")
public interface FastApiClient {

  @GetMapping("/hospital_by_module")
  HospitalApiResponse getHospital(@RequestParam("request") String request,
      @RequestParam("latitude") double latitude,
      @RequestParam("longitude") double longitude);
}
