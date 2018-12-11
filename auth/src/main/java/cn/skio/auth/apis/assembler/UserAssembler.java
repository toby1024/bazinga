package cn.skio.auth.apis.assembler;

import cn.skio.auth.apis.dto.LoginResponse;
import cn.skio.auth.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * @author jason
 */
@Component
public class UserAssembler {

  public LoginResponse toLoginResponse(User user) {
    if (user == null) {
      return null;
    }

    return mapper.map(user, LoginResponse.class);
  }

  protected static final ModelMapper mapper = new ModelMapper();
}
