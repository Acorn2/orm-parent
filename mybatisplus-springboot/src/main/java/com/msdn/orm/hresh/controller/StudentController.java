package com.msdn.orm.hresh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.msdn.orm.hresh.common.entity.PageResult;
import com.msdn.orm.hresh.common.entity.Result;
import com.msdn.orm.hresh.dto.StudentDTO;
import com.msdn.orm.hresh.dto.StudentQueryPageDTO;
import com.msdn.orm.hresh.service.StudentService;
import com.msdn.orm.hresh.vo.StudentVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@Tag(name = "学生")
@RequestMapping("/students")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping("/queryPage")
  @Operation(description = "获取学生分页列表")
  public Result<PageResult<StudentVO>> queryPage(@RequestBody StudentQueryPageDTO dto) {
    IPage<StudentVO> studentVOPage = studentService.queryPage(dto);
    return Result.ok(PageResult.ok(studentVOPage));
  }

  @GetMapping
  @Operation(description = "获取学生列表")
  public Result<List<StudentVO>> queryList(@RequestBody StudentDTO dto) {
    List<StudentVO> studentVOList = studentService.queryList(dto);
    return Result.ok(studentVOList);
  }

  @GetMapping("/{id}")
  @Operation(description = "获取学生详情")
  public Result<StudentVO> get(@PathVariable("id") Long id) {
    StudentVO studentVO = studentService.get(id);
    return Result.ok(studentVO);
  }

  @PostMapping
  @Operation(description = "新增学生")
  public Result<Object> add(@RequestBody StudentDTO dto) {
    boolean flag = studentService.add(dto);
    if (!flag) {
      return Result.failed();
    }
    return Result.ok();
  }

  @PutMapping
  @Operation(description = "编辑学生")
  public Result<Object> edit(@RequestBody StudentDTO dto) {
    boolean flag = studentService.edit(dto);
    if (!flag) {
      return Result.failed();
    }
    return Result.ok();
  }

  @DeleteMapping
  @Operation(description = "删除学生")
  public Result<Object> delete(@RequestParam String id) {
    boolean flag = studentService.delete(id);
    if (!flag) {
      return Result.failed();
    }
    return Result.ok();
  }
}
