package com.msdn.orm.hresh.service;

import com.github.pagehelper.Page;
import com.msdn.orm.hresh.dto.JobDTO;
import com.msdn.orm.hresh.dto.JobQueryPageDTO;
import com.msdn.orm.hresh.vo.JobVO;

import java.util.List;

public interface JobService {

	// 获取工作分页列表
	Page<JobVO> queryPage(JobQueryPageDTO dto);

	// 获取工作列表
	List<JobVO> queryList(JobDTO dto);

	// 获取工作详情
	JobVO get(Long id);

	// 新增工作
	int add(JobDTO dto);

	// 编辑工作
	int edit(JobDTO dto);

	// 删除工作
	int delete(String id);
}
