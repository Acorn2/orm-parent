package com.msdn.orm.hresh.model;

import com.msdn.orm.hresh.common.mybatis.model.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 工作
 *
 * @author hresh
 * @since 2022-09-15 19:22:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "job")
@Schema(name = "job对象", description = "工作")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Job extends BaseEntity {

  private static final long serialVersionUID = 1L;

  @Schema(name = "")
  @Column(name = "name")
  private String name;

  @Schema(name = "")
  @Column(name = "user_id")
  private Long userId;

  @Schema(name = "")
  @Column(name = "address")
  private String address;
}
