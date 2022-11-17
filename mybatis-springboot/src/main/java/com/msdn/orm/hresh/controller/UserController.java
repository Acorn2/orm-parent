package com.msdn.orm.hresh.controller;

import com.github.pagehelper.Page;
import com.msdn.orm.hresh.common.entity.PageResult;
import com.msdn.orm.hresh.common.entity.Result;
import com.msdn.orm.hresh.common.validator.ValidateGroup.Add;
import com.msdn.orm.hresh.common.validator.ValidateGroup.Edit;
import com.msdn.orm.hresh.dto.UserDTO;
import com.msdn.orm.hresh.dto.UserQueryPageDTO;
import com.msdn.orm.hresh.service.UserService;
import com.msdn.orm.hresh.vo.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@Tag(name = "用户")
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/queryPage")
  @Operation(description = "获取用户分页列表")
  public Result<PageResult<UserVO>> queryPage(
      @RequestBody UserQueryPageDTO dto) {
    Page<UserVO> userVOPage = userService.queryPage(dto);
    return Result.ok(PageResult.ok(userVOPage));
  }

  @GetMapping
  @Operation(description = "获取用户列表")
  public Result<List<UserVO>> queryList(@RequestBody UserDTO dto) {
    List<UserVO> userVOList = userService.queryList(dto);
    return Result.ok(userVOList);
  }

  @GetMapping("/{id}")
  @Operation(description = "获取用户详情")
  public Result<UserVO> get(@PathVariable("id") Long id) {
    UserVO userVO = userService.get(id);
    return Result.ok(userVO);
  }

  @PostMapping
  @Operation(description = "新增用户")
  public Result<Object> add(@Validated(Add.class) @RequestBody UserDTO dto) {
    int count = userService.add(dto);
    if (count < 1) {
      return Result.failed();
    }
    return Result.ok();
  }

  @PostMapping("/batch")
  @Operation(description = "新增用户")
  public Result<Object> batchAdd(@RequestBody UserDTO dto) {
    int count = userService.batchAdd(dto);
    if (count < 1) {
      return Result.failed();
    }
    return Result.ok();
  }

  @PutMapping
  @Operation(description = "编辑用户")
  public Result<Object> edit(@Validated(Edit.class) @RequestBody UserDTO dto) {
    int count = userService.edit(dto);
    if (count < 1) {
      return Result.failed();
    }
    return Result.ok();
  }

  @DeleteMapping
  @Operation(description = "删除用户")
  public Result<Object> delete(@RequestParam String id) {
    int count = userService.delete(id);
    if (count < 1) {
      return Result.failed();
    }
    return Result.ok();
  }
}
