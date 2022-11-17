package com.msdn.orm.hresh.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.msdn.orm.hresh.dto.UserDTO;
import com.msdn.orm.hresh.dto.UserQueryPageDTO;
import com.msdn.orm.hresh.mapper.UserMapper;
import com.msdn.orm.hresh.model.User;
import com.msdn.orm.hresh.service.UserService;
import com.msdn.orm.hresh.struct.UserStruct;
import com.msdn.orm.hresh.utils.PageUtils;
import com.msdn.orm.hresh.utils.mybatis.ExampleBuilder;
import com.msdn.orm.hresh.vo.UserVO;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserMapper userMapper;
  private final UserStruct userStruct;

  @Override
  public Page<UserVO> queryPage(UserQueryPageDTO dto) {
    PageHelper.startPage(dto.getPageSortInfo().getPageNum(), dto.getPageSortInfo().getPageSize(),
        dto.getPageSortInfo().parseSort());
    List<User> users = ExampleBuilder.create(UserMapper.class)
        .andLike(User::getName, dto.getName() + "%")
        .orderByDesc(User::getName)
        .select();
    Page<User> userPage = (Page<User>) users;
    return PageUtils.convert(userPage, UserVO.class);
  }

  @Override
  public List<UserVO> queryList(UserDTO dto) {
//    List<User> users = ExampleBuilder.create(UserMapper.class)
//        .andLike(User::getName, dto.getName() + "%")
//        .orderByDesc(User::getName)
//        .select();
    List<User> users = userMapper.queryList(dto);
    return userStruct.modelToVO(users);
  }

  @Override
  public UserVO get(Long id) {
    return userStruct.modelToVO(userMapper.selectByPrimaryKey(id));
  }

  @Override
  public int add(UserDTO dto) {
//    if (StringUtils.isBlank(dto.getName())) {
//      BusinessException.validateFailed("userName不能为空");
//    }
    User user = userStruct.dtoToModel(dto);
    return userMapper.insertSelective(user);
  }

  @Override
  public int batchAdd(UserDTO dto) {
    List<User> users = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      User user = User.builder().name("ascii" + i).age(21).address("中国广东").build();
      users.add(user);
    }
    return userMapper.insertList(users);
  }

  @Override
  public int edit(UserDTO dto) {
    return userMapper.updateByPrimaryKeySelective(userStruct.dtoToModel(dto));
  }

  @Override
  public int delete(String id) {
    return userMapper.deleteByPrimaryKey(id);
  }
}
