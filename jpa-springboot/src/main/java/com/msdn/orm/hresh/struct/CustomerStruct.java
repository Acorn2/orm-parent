package com.msdn.orm.hresh.struct;

import com.msdn.orm.hresh.dto.CustomerDTO;
import com.msdn.orm.hresh.model.Customer;
import com.msdn.orm.hresh.vo.CustomerVO;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
  * 父用户转换类
  */
@Mapper(componentModel = "spring")
public interface CustomerStruct {

    @Mapping(source = "subUsers",target = "subUserVOS")
    CustomerVO modelToVO(Customer record);

    @Mapping(source = "subUsers",target = "subUserVOS")
    List<CustomerVO> modelToVO(List<Customer> records);

    Customer voToModel(CustomerVO record);

    List<Customer> voToModel(List<CustomerVO> records);

    CustomerDTO modelToDTO(Customer record);

    List<CustomerDTO> modelToDTO(List<Customer> records);

    Customer dtoToModel(CustomerDTO record);

    List<Customer> dtoToModel(List<CustomerDTO> records);
}