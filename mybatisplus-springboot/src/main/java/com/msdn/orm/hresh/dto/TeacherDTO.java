package com.msdn.orm.hresh.dto;

import com.msdn.orm.hresh.common.validator.ValidateGroup.Add;
import com.msdn.orm.hresh.common.validator.ValidateGroup.Edit;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

  @Schema(name = "")
  @NotBlank(groups = {Add.class})
  private String name;

  @Schema(name = "")
  private Integer age;

  @Schema(name = "")
  @NotBlank(groups = {Edit.class})
  private String address;
}
