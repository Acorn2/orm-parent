package com.msdn.orm.hresh.service;

import com.msdn.orm.hresh.dto.CustomerDTO;
import com.msdn.orm.hresh.dto.CustomerQueryPageDTO;
import com.msdn.orm.hresh.vo.CustomerVO;
import java.util.List;
import org.springframework.data.domain.Page;

public interface CustomerService {

	// 获取父用户分页列表
	Page<CustomerVO> queryPage(CustomerQueryPageDTO dto);

	// 获取父用户列表
	List<CustomerVO> queryList(CustomerDTO dto);

	// 获取父用户详情
	CustomerVO get(Long id);

	// 新增父用户
	CustomerVO add(CustomerDTO dto);

	void batchAdd(CustomerDTO dto);

	// 编辑父用户
	CustomerVO edit(CustomerDTO dto);

	// 删除父用户
	void delete(Long id);
}
