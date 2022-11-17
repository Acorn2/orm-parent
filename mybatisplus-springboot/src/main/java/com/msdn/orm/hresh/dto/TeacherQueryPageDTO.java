package com.msdn.orm.hresh.dto;

import com.msdn.orm.hresh.common.entity.MbpPage;
import com.msdn.orm.hresh.model.Teacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherQueryPageDTO extends MbpPage<Teacher> {

  private String name;
}
