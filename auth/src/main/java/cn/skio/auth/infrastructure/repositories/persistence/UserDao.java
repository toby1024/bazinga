package cn.skio.auth.infrastructure.repositories.persistence;

import cn.skio.auth.infrastructure.repositories.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * user infrastructure
 *
 * @author zhangbin
 */
@Mapper
@Repository
public interface UserDao {

  /**
   * find user
   * @param username username
   * @return user
   */
  UserEntity findByUsername(String username);
}
