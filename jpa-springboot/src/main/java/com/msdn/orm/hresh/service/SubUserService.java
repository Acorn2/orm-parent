package com.msdn.orm.hresh.service;

import org.springframework.data.domain.Page;
import com.msdn.orm.hresh.dto.SubUserDTO;
import com.msdn.orm.hresh.dto.SubUserQueryPageDTO;
import com.msdn.orm.hresh.vo.SubUserVO;

import java.util.List;

public interface SubUserService {

	// 获取子用户分页列表
	Page<SubUserVO> queryPage(SubUserQueryPageDTO dto);

	// 获取子用户列表
	List<SubUserVO> queryList(SubUserDTO dto);

	// 获取子用户详情
	SubUserVO get(Long id);

	// 新增子用户
	SubUserVO add(SubUserDTO dto);

	// 编辑子用户
	SubUserVO edit(SubUserDTO dto);

	// 删除子用户
	void delete(Long id);
}
