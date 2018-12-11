package cn.skio.auth.apis.controller;

import cn.skio.auth.AuthApplication;
import cn.skio.auth.apis.dto.LoginRequest;
import cn.skio.auth.apis.dto.LoginResponse;
import cn.skio.auth.application.LoginResponseFactory;
import cn.skio.auth.application.LoginService;
import cn.skio.auth.infrastructure.sign.JWTUtil;
import cn.skio.auth.infrastructure.sign.JwtInfo;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.configuration.injection.MockInjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthApplication.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner
public class LoginControllerTest {

  @Before
  public void setUp() {
    loginRequest = new LoginRequest();
  }

  @Test
  public void should_auth_failed() throws Exception {
//    LoginResponse loginFailedResponse = loginResponseFactory.create(false,"failed");
//    Mockito.when(loginService.login(loginRequest)).thenReturn(loginFailedResponse);

    mvc.perform(post("/login")
        .content(JSON.toJSONString(loginRequest))
        .contentType(MediaType.APPLICATION_JSON)
    ).andExpect(status().isOk());
  }

  public void should_auth_success_and_return_token(){
    loginRequest.setUsername("test");
    loginRequest.setPassword("test");

    JwtInfo jwtInfo = new JwtInfo(1L,"test","salt");

    Mockito.when(JWTUtil.verify(token,jwtInfo)).thenReturn(true);

  }

  @Mock
  private LoginService loginService;
  @Autowired
  private LoginResponseFactory loginResponseFactory;
  @Autowired
  private MockMvc mvc;

  private LoginRequest loginRequest;
  private static final String token = "token";
}