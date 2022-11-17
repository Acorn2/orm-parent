package com.msdn.orm.hresh.dto;

import com.msdn.orm.hresh.common.validator.EnumValidator;
import com.msdn.orm.hresh.common.validator.ValidateGroup.Add;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.sql.Update;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

  @NotBlank(groups = {Add.class})
  @Schema(name = "")
  private String name;

  @EnumValidator(value = {"18", "20", "24"}, message = "age只能指定为18、20和24，其他值不合法")
  @Schema(name = "")
  private Integer age;

  @NotBlank(groups = {Update.class})
  @Schema(name = "")
  private String address;

}
