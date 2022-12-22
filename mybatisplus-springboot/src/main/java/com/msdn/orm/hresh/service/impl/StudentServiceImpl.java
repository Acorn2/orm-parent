package com.msdn.orm.hresh.service.impl;

import cn.hutool.core.util.StrUtil;
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
    IPage<StudentVO> studentVOIPage = this.lambdaQuery().and(t -> {
      t.like(StrUtil.isNotBlank(dto.getName()), Student::getName, "%" + dto.getName() + "%")
          .or()
          .like(StrUtil.isNotBlank(dto.getName()), Student::getAddress, "%" + dto.getName() + "%");
    }).page(dto)
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
    Student student = studentStruct.dtoToModel(dto);
    boolean save = this.save(student);
    System.out.println(student.getId());
    return save;
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
