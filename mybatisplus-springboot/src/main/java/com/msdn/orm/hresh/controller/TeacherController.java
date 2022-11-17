package com.msdn.orm.hresh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msdn.orm.hresh.common.entity.PageResult;
import com.msdn.orm.hresh.common.entity.Result;
import com.msdn.orm.hresh.common.validator.ValidateGroup.Add;
import com.msdn.orm.hresh.dto.TeacherDTO;
import com.msdn.orm.hresh.dto.TeacherQueryPageDTO;
import com.msdn.orm.hresh.service.TeacherService;
import com.msdn.orm.hresh.vo.TeacherVO;
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
@Tag(name = "教师")
@RequestMapping("/teachers")
public class TeacherController {

  @Autowired
  private TeacherService teacherService;

  @GetMapping("/queryPage")
  @Operation(description = "获取教师分页列表")
  public Result<PageResult<TeacherVO>> queryPage(@RequestBody TeacherQueryPageDTO dto) {
    IPage<TeacherVO> teacherVOPage = teacherService.queryPage(dto);
    return Result.ok(PageResult.ok(teacherVOPage));
  }

  @GetMapping
  @Operation(description = "获取教师列表")
  public Result<List<TeacherVO>> queryList(@RequestBody TeacherDTO dto) {
    List<TeacherVO> teacherVOList = teacherService.queryList(dto);
    return Result.ok(teacherVOList);
  }

  @GetMapping("/{id}")
  @Operation(description = "获取教师详情")
  public Result<TeacherVO> get(@PathVariable("id") Long id) {
    TeacherVO teacherVO = teacherService.get(id);
    return Result.ok(teacherVO);
  }

  @PostMapping
  @Operation(description = "新增教师")
  public Result<Object> add(@Validated(Add.class) @RequestBody TeacherDTO dto) {
    boolean flag = teacherService.add(dto);
    if (!flag) {
      return Result.failed();
    }
    return Result.ok();
  }

  @PostMapping("/batch")
  @Operation(description = "批量新增教师")
  public Result<Object> batchAdd(@RequestBody TeacherDTO dto) {
    boolean flag = teacherService.batchAdd(dto);
    if (!flag) {
      return Result.failed();
    }
    return Result.ok();
  }

  @PutMapping
  @Operation(description = "编辑教师")
  public Result<Object> edit(@RequestBody TeacherDTO dto) {
    boolean flag = teacherService.edit(dto);
    if (!flag) {
      return Result.failed();
    }
    return Result.ok();
  }

  @DeleteMapping
  @Operation(description = "删除教师")
  public Result<Object> delete(@RequestParam String id) {
    boolean flag = teacherService.delete(id);
    if (!flag) {
      return Result.failed();
    }
    return Result.ok();
  }
}
