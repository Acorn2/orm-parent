package com.msdn.orm.hresh.service;

import com.msdn.orm.hresh.dto.StudentDTO;
import com.msdn.orm.hresh.dto.StudentQueryPageDTO;
import com.msdn.orm.hresh.vo.StudentVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface StudentService {

  // 获取学生分页列表
  IPage<StudentVO> queryPage(StudentQueryPageDTO dto);

  // 获取学生列表
  List<StudentVO> queryList(StudentDTO dto);

  // 获取学生详情
  StudentVO get(Long id);

  // 新增学生
  Boolean add(StudentDTO dto);

  // 编辑学生
  Boolean edit(StudentDTO dto);

  // 删除学生
  Boolean delete(String id);
}
