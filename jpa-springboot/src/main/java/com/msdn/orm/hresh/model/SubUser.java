package com.msdn.orm.hresh.model;

import com.msdn.orm.hresh.common.entity.BaseDomain;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 子用户
 *
 * @author hresh
 * @since 2022-09-22 21:58:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "subUser")
@Schema(name = "subUser对象", description = "子用户")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class SubUser extends BaseDomain {

  private static final long serialVersionUID = 1L;

  @Schema(name = "")
  @Column(name = "name")
  private String name;

//  @Schema(name = "")
//  @Column(name = "customer_id")
//  private String customerId;

  @Schema(name = "")
  @Column(name = "address")
  private String address;

  @ManyToOne
  @JoinColumn
  private Customer customer;
}
