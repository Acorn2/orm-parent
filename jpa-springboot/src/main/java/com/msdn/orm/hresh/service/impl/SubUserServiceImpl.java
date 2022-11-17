package com.msdn.orm.hresh.service.impl;

import com.msdn.orm.hresh.dto.SubUserDTO;
import com.msdn.orm.hresh.dto.SubUserQueryPageDTO;
import com.msdn.orm.hresh.model.SubUser;
import com.msdn.orm.hresh.repository.SubUserRepository;
import com.msdn.orm.hresh.service.SubUserService;
import com.msdn.orm.hresh.struct.SubUserStruct;
import com.msdn.orm.hresh.utils.jpa.SpecificationBuilder;
import com.msdn.orm.hresh.vo.SubUserVO;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubUserServiceImpl implements SubUserService {

  private final SubUserRepository subUserRepository;
  private final SubUserStruct subUserStruct;

  @Override
  public Page<SubUserVO> queryPage(SubUserQueryPageDTO dto) {
    Pageable pageable = SpecificationBuilder.getPageable(dto.getPageSortInfo());
    Page<SubUser> subUserPage = subUserRepository.findAll(pageable);
    return subUserPage.map(subUser -> subUserStruct.modelToVO(subUser));
  }

  @Override
  public List<SubUserVO> queryList(SubUserDTO dto) {
    List<SubUser> subUsers = SpecificationBuilder.create(SubUserRepository.class)
        .select();
    return subUserStruct.modelToVO(subUsers);
  }

  @Override
  public SubUserVO get(Long id) {
    Optional<SubUser> subUserOptional = subUserRepository.findById(id);
    if (subUserOptional.isPresent()) {
      return subUserStruct.modelToVO(subUserOptional.get());
    }
    return null;
  }

  @Override
  public SubUserVO add(SubUserDTO dto) {
    SubUser subUser = subUserRepository.save(subUserStruct.dtoToModel(dto));
    return subUserStruct.modelToVO(subUser);
  }

  @Override
  public SubUserVO edit(SubUserDTO dto) {
    SubUser subUser = subUserRepository.save(subUserStruct.dtoToModel(dto));
    return subUserStruct.modelToVO(subUser);
  }

  @Override
  public void delete(Long id) {
    subUserRepository.deleteById(id);
  }
}