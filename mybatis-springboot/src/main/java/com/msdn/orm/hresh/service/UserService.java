package com.msdn.orm.hresh.service;

import com.github.pagehelper.Page;
import com.msdn.orm.hresh.dto.UserDTO;
import com.msdn.orm.hresh.dto.UserQueryPageDTO;
import com.msdn.orm.hresh.vo.UserVO;
import java.util.List;

public interface UserService {

	// 获取用户分页列表
	Page<UserVO> queryPage(UserQueryPageDTO dto);

	// 获取用户列表
	List<UserVO> queryList(UserDTO dto);

	// 获取用户详情
	UserVO get(Long id);

	// 新增用户
	int add(UserDTO dto);

	//批量新增
	int batchAdd(UserDTO dto);

	// 编辑用户
	int edit(UserDTO dto);

	// 删除用户
	int delete(String id);
}
