package com.msdn.orm.hresh.model;

import com.msdn.orm.hresh.common.mybatis.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 用户
 *
 * @author hresh
 * @since 2022-09-15 19:22:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "user")
@Schema(name = "user对象", description = "用户")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class User extends BaseEntity {

  @Schema(name = "")
  @Column(name = "name")
  private String name;

  @Schema(name = "")
  @Column(name = "age")
  private Integer age;

  @Schema(name = "")
  @Column(name = "address")
  private String address;

  private List<Job> jobs;
}
