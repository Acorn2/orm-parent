package com.msdn.orm.hresh.service.impl;

import static com.github.pagehelper.page.PageMethod.startPage;

import com.github.pagehelper.Page;
import com.msdn.orm.hresh.dto.JobDTO;
import com.msdn.orm.hresh.dto.JobQueryPageDTO;
import com.msdn.orm.hresh.mapper.JobMapper;
import com.msdn.orm.hresh.model.Job;
import com.msdn.orm.hresh.service.JobService;
import com.msdn.orm.hresh.struct.JobStruct;
import com.msdn.orm.hresh.utils.PageUtils;
import com.msdn.orm.hresh.vo.JobVO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

  private final JobMapper jobMapper;
  private final JobStruct jobStruct;

  @Override
  public Page<JobVO> queryPage(JobQueryPageDTO dto) {
    Job job = jobStruct.pageDTOToModel(dto);
    startPage(dto.getPageSortInfo().getPageNum(), dto.getPageSortInfo().getPageSize(),
        dto.getPageSortInfo().parseSort());
    Page<Job> jobPage = (Page<Job>) jobMapper.select(job);
    return PageUtils.convert(jobPage, JobVO.class);
  }

  @Override
  public List<JobVO> queryList(JobDTO dto) {
    Job job = jobStruct.dtoToModel(dto);
    return jobStruct.modelToVO(jobMapper.select(job));
  }

  @Override
  public JobVO get(Long id) {
    return jobStruct.modelToVO(jobMapper.selectByPrimaryKey(id));
  }

  @Override
  public int add(JobDTO dto) {
    return jobMapper.insertSelective(jobStruct.dtoToModel(dto));
  }

  @Override
  public int edit(JobDTO dto) {
    return jobMapper.updateByPrimaryKeySelective(jobStruct.dtoToModel(dto));
  }

  @Override
  public int delete(String id) {
    return jobMapper.deleteByPrimaryKey(id);
  }
}