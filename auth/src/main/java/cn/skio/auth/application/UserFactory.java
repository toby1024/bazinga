package cn.skio.auth.application;

import cn.skio.auth.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

  protected static final ModelMapper mapper = new ModelMapper();

  public User create(Long id, String username, String password, String salt) {
    return User.builder().id(id).username(username).password(password).salt(salt).build();
  }
}
