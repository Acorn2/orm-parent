package com.msdn.orm.hresh.model;

import com.msdn.orm.hresh.common.entity.BaseDomain;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * 父用户
 *
 * @author hresh
 * @since 2022-09-22 21:58:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "customer")
@Schema(name = "customer对象", description = "父用户")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@SQLDelete(sql = "update customer set del_flag =1 where id = ?")
@Where(clause = "del_flag=0")
public class Customer extends BaseDomain {

  private static final long serialVersionUID = 1L;

  @Schema(name = "")
  @Column(name = "name")
  private String name;

  @Schema(name = "")
  @Column(name = "age")
  private Integer age;

  @Schema(name = "")
  @Column(name = "address")
  private String address;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "customer_id")
  private List<SubUser> subUsers;
}
