package cn.skio.auth.application;


import cn.skio.auth.apis.assembler.UserAssembler;
import cn.skio.auth.apis.dto.LoginRequest;
import cn.skio.auth.apis.dto.LoginResponse;
import cn.skio.auth.domain.User;
import cn.skio.auth.infrastructure.repositories.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * login user
 *
 * @author zhangbin
 */
@Service
public class LoginService {

  /**
   * user login
   *
   * @param loginRequest
   * @return User
   */
  public LoginResponse login(LoginRequest loginRequest) {
    if(StringUtils.isEmpty(loginRequest.getUsername()) || StringUtils.isEmpty(loginRequest.getPassword())){
      return loginResponseFactory.create(false, "login parameter invalid");
    }

    User user = userRepository.findByUsername(loginRequest.getUsername());
    if (user == null) {
      return loginResponseFactory.create(false, "user not exists");
    }

    if(BCrypt.checkpw(loginRequest.getPassword(), user.getPassword())){
      return loginResponseFactory.create(user);
    }

    return loginResponseFactory.create(false, "wrong password");
  }

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private LoginResponseFactory loginResponseFactory;

}
