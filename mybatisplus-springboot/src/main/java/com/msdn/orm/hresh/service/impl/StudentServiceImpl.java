package com.msdn.orm.hresh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msdn.orm.hresh.dto.StudentDTO;
import com.msdn.orm.hresh.dto.StudentQueryPageDTO;
import com.msdn.orm.hresh.mapper.StudentMapper;
import com.msdn.orm.hresh.model.Student;
import com.msdn.orm.hresh.service.StudentService;
import com.msdn.orm.hresh.struct.StudentStruct;
import com.msdn.orm.hresh.vo.StudentVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements
    StudentService {

  private final StudentStruct studentStruct;

  @Override
  public IPage<StudentVO> queryPage(StudentQueryPageDTO dto) {
    IPage<StudentVO> studentVOIPage = this.lambdaQuery().page(dto)
        .convert(student -> studentStruct.modelToVO(student));
    return studentVOIPage;
  }

  @Override
  public List<StudentVO> queryList(StudentDTO dto) {
    List<Student> students = this.lambdaQuery().like(Student::getName, dto.getName()).list();
    return studentStruct.modelToVO(students);
  }

  @Override
  public StudentVO get(Long id) {
    return studentStruct.modelToVO(this.getById(id));
  }

  @Override
  public Boolean add(StudentDTO dto) {
    return this.save(studentStruct.dtoToModel(dto));
  }

  @Override
  public Boolean edit(StudentDTO dto) {
    return this.updateById(studentStruct.dtoToModel(dto));
  }

  @Override
  public Boolean delete(String id) {
    return this.removeById(id);
  }
}
