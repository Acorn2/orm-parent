package com.msdn.orm.hresh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msdn.orm.hresh.dto.TeacherDTO;
import com.msdn.orm.hresh.model.Teacher;
import com.msdn.orm.hresh.vo.TeacherVO;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherMapper extends BaseMapper<Teacher> {

  List<Teacher> queryList(TeacherDTO dto);
}
