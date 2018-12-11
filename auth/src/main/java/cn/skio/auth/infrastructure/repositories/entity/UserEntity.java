package cn.skio.auth.infrastructure.repositories.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户entity
 *
 * @author zhangbin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

  private String username;
  private String password;
  private String salt;

}
