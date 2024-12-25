package com.example.aivlemini7springboot.client.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalResponse {

  private String name;
  private String address;
  private String tel1;
  private String tel3;
  private double latitude;
  private double longitude;
  private String distance;
  private String estimatedArrivalTime;
}
