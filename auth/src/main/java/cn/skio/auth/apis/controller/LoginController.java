package cn.skio.auth.apis.controller;

import cn.skio.auth.apis.dto.LoginRequest;
import cn.skio.auth.apis.dto.LoginResponse;
import cn.skio.auth.application.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author jason
 */
@RestController
@EnableEurekaClient
@RequestMapping("/login")
@Slf4j
public class LoginController {

  @PostMapping
  public LoginResponse login(@RequestBody LoginRequest loginRequest){
    log.debug("login parameter is: " + loginRequest.getUsername() + "; " + loginRequest.getPassword());
    LoginResponse loginResponse = loginService.login(loginRequest);
    if(loginResponse != null){
      return loginResponse;
    }else{
      return null;
    }
  }

  @GetMapping
  public String index(){
    return "index";
  }

  @Autowired
  private LoginService loginService;

}
