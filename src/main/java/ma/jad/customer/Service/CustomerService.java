package ma.jad.customer.Service;


import ma.jad.customer.Model.CustomerRequestDto;
import ma.jad.customer.Model.CustomerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomer(Long id);

    List<CustomerResponseDto> listCustomers();

    void deleteCustomer(CustomerRequestDto customerRequestDto);
}
