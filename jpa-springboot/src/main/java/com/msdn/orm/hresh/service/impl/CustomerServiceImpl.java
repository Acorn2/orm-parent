package com.msdn.orm.hresh.service.impl;

import com.msdn.orm.hresh.dto.CustomerDTO;
import com.msdn.orm.hresh.dto.CustomerQueryPageDTO;
import com.msdn.orm.hresh.model.Customer;
import com.msdn.orm.hresh.repository.CustomerRepository;
import com.msdn.orm.hresh.service.CustomerService;
import com.msdn.orm.hresh.struct.CustomerStruct;
import com.msdn.orm.hresh.utils.jpa.SpecificationBuilder;
import com.msdn.orm.hresh.vo.CustomerVO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;
  private final CustomerStruct customerStruct;

  @Override
  public Page<CustomerVO> queryPage(CustomerQueryPageDTO dto) {
    Pageable pageable = SpecificationBuilder.getPageable(dto.getPageSortInfo());
    Page<Customer> customerPage = SpecificationBuilder.create(CustomerRepository.class)
        .andLike(Customer::getName, dto.getName() + "%")
        .select(pageable);
//    Page<Customer> customerPage = customerRepository.findAll(pageable);
    return customerPage.map(customer -> customerStruct.modelToVO(customer));
  }

  @Override
  public List<CustomerVO> queryList(CustomerDTO dto) {
    List<Customer> customers = SpecificationBuilder.create(CustomerRepository.class)
        .andLike(Customer::getName, dto.getName() + "%")
//        .leftJoin(Customer::getSubUsers)
        .leftJoinAndOnEqualTo(Customer::getSubUsers,"name","a1")
        .select();
    return customerStruct.modelToVO(customers);
  }

  @Override
  public CustomerVO get(Long id) {
    Optional<Customer> customerOptional = customerRepository.findById(id);
    if (customerOptional.isPresent()) {
      return customerStruct.modelToVO(customerOptional.get());
    }
    return null;
  }

  @Transactional
  @Override
  public CustomerVO add(CustomerDTO dto) {
//    if (StringUtils.isBlank(dto.getName())) {
//      BusinessException.validateFailed("userName不能为空");
//    }
    Customer customer = customerRepository.save(customerStruct.dtoToModel(dto));
    return customerStruct.modelToVO(customer);
  }

  @Override
  public void batchAdd(CustomerDTO dto) {
    List<Customer> customers = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      Customer customer = new Customer();
      customer.setName(dto.getName() + i);
      customer.setAge(dto.getAge());
      customer.setAddress(dto.getAddress());

      customers.add(customer);
    }
    customerRepository.saveAll(customers);
  }

  @Transactional
  @Override
  public CustomerVO edit(CustomerDTO dto) {
    // 通过自定义修改方法的方式来达到修改数据，先修改再查询，version没有工作，修改时间也不变
//    customerRepository.updateByName(dto.getName(), dto.getAge());
//    return customerStruct.modelToVO(customerRepository.findByName(dto.getName()));

    // 先查询，再修改,这种方式才会触发乐观锁，即where条件中有version条件，更新操作verison+1，修改时间也会变化
    Customer customer = customerRepository.findByName(dto.getName());
    customer.setAge(dto.getAge());
    customerRepository.save(customer);
    return customerStruct.modelToVO(customer);
  }

  @Override
  public void delete(Long id) {
    customerRepository.deleteById(id);
  }
}