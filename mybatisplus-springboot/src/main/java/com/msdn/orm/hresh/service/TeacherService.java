package com.msdn.orm.hresh.service;

import com.msdn.orm.hresh.dto.TeacherDTO;
import com.msdn.orm.hresh.dto.TeacherQueryPageDTO;
import com.msdn.orm.hresh.vo.TeacherVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface TeacherService {

	// 获取教师分页列表
	IPage<TeacherVO> queryPage(TeacherQueryPageDTO dto);

	// 获取教师列表
	List<TeacherVO> queryList(TeacherDTO dto);

	// 获取教师详情
	TeacherVO get(Long id);

	// 新增教师
	Boolean add(TeacherDTO dto);

	Boolean batchAdd(TeacherDTO dto);

	// 编辑教师
	Boolean edit(TeacherDTO dto);

	// 删除教师
	Boolean delete(String id);
}
