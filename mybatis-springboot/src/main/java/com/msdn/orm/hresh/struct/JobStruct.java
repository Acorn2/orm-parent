package com.msdn.orm.hresh.struct;

import com.msdn.orm.hresh.dto.JobDTO;
import com.msdn.orm.hresh.dto.JobQueryPageDTO;
import com.msdn.orm.hresh.model.Job;
import com.msdn.orm.hresh.vo.JobVO;
import java.util.List;
import org.mapstruct.Mapper;

/**
 * 工作转换类
 */
@Mapper(componentModel = "spring")
public interface JobStruct {

  /**
   * Job 转 JobVO
   *
   * @param record
   * @return
   */
  JobVO modelToVO(Job record);

  Job pageDTOToModel(JobQueryPageDTO dto);

  /**
   * List<Job> 转 List<JobVO>
   *
   * @param records
   * @return
   */
  List<JobVO> modelToVO(List<Job> records);

  /**
   * JobVO 转 Job
   *
   * @param record
   * @return
   */
  Job voToModel(JobVO record);

  /**
   * List<JobVO> 转 List<Job>
   *
   * @param records
   * @return
   */
  List<Job> voToModel(List<JobVO> records);

  /**
   * Job 转 JobDTO
   *
   * @param record
   * @return
   */
  JobDTO modelToDTO(Job record);

  /**
   * List<Job> 转 List<JobDTO>
   *
   * @param records
   * @return
   */
  List<JobDTO> modelToDTO(List<Job> records);

  /**
   * JobDTO 转 Job
   *
   * @param record
   * @return
   */
  Job dtoToModel(JobDTO record);

  /**
   * List<JobDTO> 转 List<Job>
   *
   * @param records
   * @return
   */
  List<Job> dtoToModel(List<JobDTO> records);
}