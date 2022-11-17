package com.msdn.orm.hresh.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.msdn.orm.hresh.common.mybatisPlus.model.CoreBase;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


/**
 * 学生
 *
 * @author hresh
 * @since 2022-09-21 11:15:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("student")
@Schema(name = "student对象", description = "学生")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Student extends CoreBase {

  private static final long serialVersionUID = 1L;

  @TableField("name")
  @Schema(name = "")
  private String name;

  @TableField("teacher_id")
  @Schema(name = "")
  private String teacherId;

  @TableField("address")
  @Schema(name = "")
  private String address;
}
