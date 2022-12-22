package com.msdn.orm.hresh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msdn.orm.hresh.dto.TeacherDTO;
import com.msdn.orm.hresh.dto.TeacherQueryPageDTO;
import com.msdn.orm.hresh.mapper.TeacherMapper;
import com.msdn.orm.hresh.model.Teacher;
import com.msdn.orm.hresh.service.TeacherService;
import com.msdn.orm.hresh.struct.TeacherStruct;
import com.msdn.orm.hresh.vo.TeacherVO;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements
    TeacherService {

  private final TeacherMapper teacherMapper;
  private final TeacherStruct teacherStruct;

  @Override
  public IPage<TeacherVO> queryPage(TeacherQueryPageDTO dto) {
    IPage<TeacherVO> teacherPage = this.lambdaQuery().page(dto)
        .convert(teacher -> teacherStruct.modelToVO(teacher));
    return teacherPage;
  }

  @Override
  public List<TeacherVO> queryList(TeacherDTO dto) {
//    List<Teacher> teachers = this.lambdaQuery().list();

//    List<Teacher> teachers = this.lambdaQuery().like(Teacher::getName, dto.getName())
//        .orderByDesc(Teacher::getName).list();

    List<Teacher> teachers = teacherMapper.queryList(dto);
    return teacherStruct.modelToVO(teachers);
//    List<Teacher> teachers = teacherMapper.queryList(dto);
//    return teacherStruct.modelToVO(teachers);
  }

  @Override
  public TeacherVO get(Long id) {
    return teacherStruct.modelToVO(this.getById(id));
  }

  @Override
  public Boolean add(TeacherDTO dto) {
//    if (StringUtils.isBlank(dto.getName())) {
//      BusinessException.validateFailed("name 不能为空");
//    }
    return this.save(teacherStruct.dtoToModel(dto));
  }

  @Override
  public Boolean batchAdd(TeacherDTO dto) {
    List<Teacher> teachers = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      Teacher teacher = Teacher.builder().name(dto.getName() + i).age(46).address(dto.getAddress())
          .build();
      teachers.add(teacher);
    }
    return this.saveBatch(teachers);
  }

  @Override
  public Boolean edit(TeacherDTO dto) {
    return this.updateById(teacherStruct.dtoToModel(dto));
  }

  @Override
  public Boolean delete(String id) {
    return this.removeById(id);
  }
}
