package com.msdn.orm.hresh.controller;

import com.github.pagehelper.Page;
import com.msdn.orm.hresh.common.entity.PageResult;
import com.msdn.orm.hresh.common.entity.Result;
import com.msdn.orm.hresh.dto.JobDTO;
import com.msdn.orm.hresh.dto.JobQueryPageDTO;
import com.msdn.orm.hresh.service.JobService;
import com.msdn.orm.hresh.vo.JobVO;
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
@Tag(name = "工作")
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "/queryPage")
    @Operation(description = "获取工作分页列表")
    public Result<PageResult<JobVO>> queryPage(@RequestBody JobQueryPageDTO dto) {
        Page<JobVO> jobVOPage = jobService.queryPage(dto);
        return Result.ok(PageResult.ok(jobVOPage));
    }

    @GetMapping
    @Operation(description = "获取工作列表")
    public Result<List<JobVO>> queryList(@RequestBody JobDTO dto) {
        List<JobVO> jobVOList = jobService.queryList(dto);
        return Result.ok(jobVOList);
    }

    @GetMapping("/{id}")
    @Operation(description = "获取工作详情")
    public Result<JobVO> get(@PathVariable("id") Long id) {
        JobVO jobVO = jobService.get(id);
        return Result.ok(jobVO);
    }

    @PostMapping
    @Operation(description = "新增工作")
    public Result<Object> add(@RequestBody JobDTO dto) {
        int count = jobService.add(dto);
        if (count < 1) {
            return Result.failed();
        }
        return Result.ok();
    }

    @PutMapping
    @Operation(description = "编辑工作")
    public Result<Object> edit(@RequestBody JobDTO dto) {
        int count = jobService.edit(dto);
        if (count < 1) {
            return Result.failed();
        }
        return Result.ok();
    }

    @DeleteMapping
    @Operation(description = "删除工作")
    public Result<Object> delete(@RequestParam String id) {
        int count = jobService.delete(id);
        if (count < 1) {
            return Result.failed();
        }
        return Result.ok();
    }
}
