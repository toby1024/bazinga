package cn.skio.auth.application;

import cn.skio.auth.apis.dto.LoginResponse;
import cn.skio.auth.domain.User;
import cn.skio.auth.infrastructure.sign.JWTUtil;
import org.springframework.stereotype.Component;

/**
 * @author jason
 */
@Component
public class LoginResponseFactory {

  public LoginResponse create(boolean loginState, String message){
   return LoginResponse.builder().loginSuccess(loginState).message(message).build();
  }

  public LoginResponse create(User user) {
    return LoginResponse.builder().token(JWTUtil.sign(user)).loginSuccess(true).message("success").build();
  }
}
