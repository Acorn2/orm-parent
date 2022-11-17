package com.msdn.orm.hresh.struct;

import com.msdn.orm.hresh.dto.StudentDTO;
import com.msdn.orm.hresh.model.Student;
import com.msdn.orm.hresh.vo.StudentVO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * 学生转换类
 */
@Mapper(componentModel = "spring")
public interface StudentStruct {

  StudentVO modelToVO(Student record);

  List<StudentVO> modelToVO(List<Student> records);

  Student voToModel(StudentVO record);

  List<Student> voToModel(List<StudentVO> records);

  StudentDTO modelToDTO(Student record);

  List<StudentDTO> modelToDTO(List<Student> records);

  Student dtoToModel(StudentDTO record);

  List<Student> dtoToModel(List<StudentDTO> records);
}