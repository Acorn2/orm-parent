package com.msdn.orm.hresh.dto;

import com.msdn.orm.hresh.common.entity.MbpPage;
import com.msdn.orm.hresh.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentQueryPageDTO extends MbpPage<Student> {

  private String name;

  private String address;
}
