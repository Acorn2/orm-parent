package com.msdn.orm.hresh.mapper;

import com.msdn.orm.hresh.common.mybatis.ListMapper;
import com.msdn.orm.hresh.dto.UserDTO;
import com.msdn.orm.hresh.model.User;
import java.util.List;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User>, ListMapper<User,Long> {

  List<User> queryList(UserDTO userDTO);
}
