package cn.skio.auth.infrastructure.repositories.entity;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseEntity {
  private Long id;
  private Date createdAt;
  private Date updatedAt;
}
