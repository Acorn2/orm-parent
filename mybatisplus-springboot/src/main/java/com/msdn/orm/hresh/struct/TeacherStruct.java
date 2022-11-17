package com.msdn.orm.hresh.struct;

import com.msdn.orm.hresh.dto.TeacherDTO;
import com.msdn.orm.hresh.model.Teacher;
import com.msdn.orm.hresh.vo.TeacherVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * 教师转换类
 */
@Mapper(componentModel = "spring")
public interface TeacherStruct {

  @Mapping(source = "students",target = "studentVOS")
  TeacherVO modelToVO(Teacher record);

  @Mapping(source = "students",target = "studentVOS")
  List<TeacherVO> modelToVO(List<Teacher> records);

  TeacherDTO modelToDTO(Teacher record);

  List<TeacherDTO> modelToDTO(List<Teacher> records);

  Teacher dtoToModel(TeacherDTO record);

  List<Teacher> dtoToModel(List<TeacherDTO> records);
}