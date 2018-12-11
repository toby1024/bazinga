package cn.skio.auth.infrastructure.repositories;

import cn.skio.auth.domain.User;
import cn.skio.auth.infrastructure.repositories.entity.UserEntity;
import cn.skio.auth.infrastructure.repositories.persistence.UserDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jason
 */
@Component
public class UserRepository {

  public User findByUsername(String username) {
    UserEntity userEntity = userDao.findByUsername(username);
    if (userEntity != null) {
      return mapper.map(userEntity, User.class);
    } else {
      return null;
    }
  }



  protected static final ModelMapper mapper = new ModelMapper();

  @Autowired
  private UserDao userDao;
}
