package ma.jad.customer.Service;

import ma.jad.customer.Mappers.CustomerMapper;
import ma.jad.customer.Model.Customer;
import ma.jad.customer.Model.CustomerRequestDto;
import ma.jad.customer.Model.CustomerResponseDto;
import ma.jad.customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerServiceImp(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto) {
        Customer cust = customerMapper.mapCustomerRequestDtoToCustomer(customerRequestDto);
        Customer custResponse = customerRepository.save(cust);
        return customerMapper.mapCustomerToResponse(custResponse);
    }

    @Override
    public CustomerResponseDto getCustomer(Long id) {
        Customer returnedCust = customerRepository.findById(id).get();
        return customerMapper.mapCustomerToResponse(returnedCust);
    }

    @Override
    public List<CustomerResponseDto> listCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(customerMapper::mapCustomerToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.mapCustomerRequestDtoToCustomer(customerRequestDto);
        Long customerID = customer.getId();
        if (customerID != null){
            customerRepository.findById(customerID);

            customerRepository.delete(customer);
        }

    }
}
