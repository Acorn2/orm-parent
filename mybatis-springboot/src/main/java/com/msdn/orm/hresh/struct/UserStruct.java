package com.msdn.orm.hresh.struct;

import com.msdn.orm.hresh.dto.UserDTO;
import com.msdn.orm.hresh.model.User;
import com.msdn.orm.hresh.vo.UserVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
  * 用户转换类
  */
@Mapper(componentModel = "spring")
public interface UserStruct {

    @Mapping(target = "jobVOS",source = "jobs")
    UserVO modelToVO(User record);

    @Mapping(target = "jobVOS",source = "jobs")
    List<UserVO> modelToVO(List<User> records);

    User voToModel(UserVO record);

    List<User> voToModel(List<UserVO> records);

    UserDTO modelToDTO(User record);

    List<UserDTO> modelToDTO(List<User> records);

    User dtoToModel(UserDTO record);

    List<User> dtoToModel(List<UserDTO> records);
}