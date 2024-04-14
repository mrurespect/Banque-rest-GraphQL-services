package fsts.mrurespect.ebankservicerest.mapper;

import fsts.mrurespect.ebankservicerest.dto.CustomerRequestDto;
import fsts.mrurespect.ebankservicerest.entity.Customer;
import org.springframework.beans.BeanUtils;

public class CustomerMapper {
    public static Customer toCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer= new Customer();
        BeanUtils.copyProperties(customerRequestDto, customer);
        return customer;
    }
}
