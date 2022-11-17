package com.msdn.orm.hresh.controller;

import com.msdn.orm.hresh.common.entity.PageResult;
import com.msdn.orm.hresh.common.entity.Result;
import com.msdn.orm.hresh.dto.SubUserDTO;
import com.msdn.orm.hresh.dto.SubUserQueryPageDTO;
import com.msdn.orm.hresh.service.SubUserService;
import com.msdn.orm.hresh.vo.SubUserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
@Tag(name = "子用户")
@RequestMapping("/subUsers")
public class SubUserController {

    @Autowired
    private SubUserService subUserService;

    @GetMapping(value = "/queryPage")
    @Operation(description = "获取子用户分页列表")
    public Result<PageResult<SubUserVO>> queryPage(@RequestBody SubUserQueryPageDTO dto) {
        Page<SubUserVO> subUserVOPage = subUserService.queryPage(dto);
        return Result.ok(PageResult.ok(subUserVOPage));
    }

    @GetMapping
    @Operation(description = "获取子用户列表")
    public Result<List<SubUserVO>> queryList(@RequestBody SubUserDTO dto) {
        List<SubUserVO> subUserVOList = subUserService.queryList(dto);
        return Result.ok(subUserVOList);
    }

    @GetMapping("/{id}")
    @Operation(description = "获取子用户详情")
    public Result<SubUserVO> get(@PathVariable("id") Long id) {
        SubUserVO subUserVO = subUserService.get(id);
        return Result.ok(subUserVO);
    }

    @PostMapping
    @Operation(description = "新增子用户")
    public Result<SubUserVO> add(@RequestBody SubUserDTO dto) {
        SubUserVO subUserVO = subUserService.add(dto);
        return Result.ok(subUserVO);
    }

    @PutMapping
    @Operation(description = "编辑子用户")
    public Result<SubUserVO> edit(@RequestBody SubUserDTO dto) {
        SubUserVO subUserVO = subUserService.edit(dto);
        return Result.ok(subUserVO);
    }

    @DeleteMapping
    @Operation(description = "删除子用户")
    public Result<Object> delete(@RequestParam Long id) {
       subUserService.delete(id);
        return Result.ok();
    }
}