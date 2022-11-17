package com.msdn.orm.hresh.controller;

import com.msdn.orm.hresh.common.entity.PageResult;
import com.msdn.orm.hresh.common.entity.Result;
import com.msdn.orm.hresh.common.validator.ValidateGroup.Add;
import com.msdn.orm.hresh.dto.CustomerDTO;
import com.msdn.orm.hresh.dto.CustomerQueryPageDTO;
import com.msdn.orm.hresh.service.CustomerService;
import com.msdn.orm.hresh.vo.CustomerVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "父用户")
@RequestMapping("/customers")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping(value = "/queryPage")
  @Operation(description = "获取父用户分页列表")
  public Result<PageResult<CustomerVO>> queryPage(@RequestBody CustomerQueryPageDTO dto) {
    Page<CustomerVO> customerVOPage = customerService.queryPage(dto);
    return Result.ok(PageResult.ok(customerVOPage));
  }

  @GetMapping
  @Operation(description = "获取父用户列表")
  public Result<List<CustomerVO>> queryList(@RequestBody CustomerDTO dto) {
    List<CustomerVO> customerVOList = customerService.queryList(dto);
    return Result.ok(customerVOList);
  }

  @GetMapping("/{id}")
  @Operation(description = "获取父用户详情")
  public Result<CustomerVO> get(@PathVariable("id") Long id) {
    CustomerVO customerVO = customerService.get(id);
    return Result.ok(customerVO);
  }

  @PostMapping
  @Operation(description = "新增父用户")
  public Result<CustomerVO> add(@Validated(Add.class) @RequestBody CustomerDTO dto) {
    CustomerVO customerVO = customerService.add(dto);
    return Result.ok(customerVO);
  }

  @PostMapping("/batchAdd")
  @Operation(description = "新增父用户")
  public Result<Object> batchAdd(@RequestBody CustomerDTO dto) {
    customerService.batchAdd(dto);
    return Result.ok();
  }

  @PutMapping
  @Operation(description = "编辑父用户")
  public Result<CustomerVO> edit(@RequestBody CustomerDTO dto) {
    CustomerVO customerVO = customerService.edit(dto);
    return Result.ok(customerVO);
  }

  @DeleteMapping
  @Operation(description = "删除父用户")
  public Result<Object> delete(@RequestParam Long id) {
    customerService.delete(id);
    return Result.ok();
  }
}