package com.example.aivlemini7springboot.client.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalApiResponse {

  private String timestamp;
  private double latitude;
  private double longitude;
  private int emergencyClass; // CamelCase로 변환됨
  private List<HospitalResponse> recommendedHospitals;
  private String message;
  private List<TreatmentStep> treatmentSteps;
}

