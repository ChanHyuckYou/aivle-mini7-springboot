package com.example.aivlemini7springboot.controller;


import com.example.aivlemini7springboot.client.api.FastApiClient;
import com.example.aivlemini7springboot.client.dto.HospitalApiResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@Slf4j
public class IndexController {

  private final FastApiClient fastApiClient;
//  private final LogService logService;

  @GetMapping("/")
  public String index() {
    return "index";
  }


  @GetMapping("/recommend_hospital")
  public ModelAndView recommendHospital(@RequestParam("request") String request,
      @RequestParam("latitude") double latitude,
      @RequestParam("longitude") double longitude) {
    HospitalApiResponse response = null;
    try {
      // FastAPI에서 응답받기
      response = fastApiClient.getHospital(request, latitude, longitude);
    } catch (FeignException e) {
      log.error("Error calling fastApiClient: " + e.getMessage());
      // 에러 처리 (뷰 또는 JSON 메시지 반환)
      ModelAndView errorMv = new ModelAndView("error");
      errorMv.addObject("message", "Failed to fetch hospital data");
      return errorMv;
    }

    // 추천 병원 리스트를 모델에 추가
    ModelAndView mv = new ModelAndView("recommend_hospital");
    mv.addObject("hospitalList", response.getRecommendedHospitals());
    mv.addObject("latitude", response.getLatitude());
    mv.addObject("longitude", response.getLongitude());
    mv.addObject("emergencyClass", response.getEmergencyClass());
    return mv;
  }


}


