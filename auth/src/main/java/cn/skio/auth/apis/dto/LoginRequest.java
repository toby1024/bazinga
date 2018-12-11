package cn.skio.auth.apis.dto;

import lombok.Data;

@Data
public class LoginRequest {

  private String username;
  private String password;
}
