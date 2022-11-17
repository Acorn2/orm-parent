package com.msdn.orm.hresh.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.msdn.orm.hresh.common.mybatisPlus.model.CoreBase;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


/**
 * 教师
 *
 * @author hresh
 * @since 2022-09-21 11:15:58
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("teacher")
@Schema(name = "teacher对象", description = "教师")
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Teacher extends CoreBase {

  private static final long serialVersionUID = 1L;

  @TableField("name")
  @Schema(name = "")
  private String name;

  @TableField("age")
  @Schema(name = "")
  private Integer age;

  @TableField("address")
  @Schema(name = "")
  private String address;

  // 数据库表中不存在的字段，需要忽略掉
  @TableField(exist = false)
  private List<Student> students;
}
