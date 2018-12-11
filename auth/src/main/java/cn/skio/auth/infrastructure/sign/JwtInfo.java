package cn.skio.auth.infrastructure.sign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtInfo implements Serializable {
  private Long id;
  private String username;
  private String salt;
}
