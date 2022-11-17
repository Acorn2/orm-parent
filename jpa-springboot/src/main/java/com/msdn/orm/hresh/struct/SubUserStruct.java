package com.msdn.orm.hresh.struct;

import com.msdn.orm.hresh.model.SubUser;
import com.msdn.orm.hresh.dto.SubUserDTO;
import com.msdn.orm.hresh.vo.SubUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

/**
  * 子用户转换类
  */
@Mapper(componentModel = "spring")
public interface SubUserStruct {

    SubUserVO modelToVO(SubUser record);

    List<SubUserVO> modelToVO(List<SubUser> records);

    SubUser voToModel(SubUserVO record);

    List<SubUser> voToModel(List<SubUserVO> records);

    SubUserDTO modelToDTO(SubUser record);

    List<SubUserDTO> modelToDTO(List<SubUser> records);

    SubUser dtoToModel(SubUserDTO record);

    List<SubUser> dtoToModel(List<SubUserDTO> records);
}