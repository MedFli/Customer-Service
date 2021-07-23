package ma.jad.customer.Controller;

import ma.jad.customer.Model.CustomerRequestDto;
import ma.jad.customer.Model.CustomerResponseDto;
import ma.jad.customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customer/{id}")
    public CustomerResponseDto getCustomer(@PathVariable Long id) {

        return customerService.getCustomer(id);
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDto> getAllCustomers() {

        return customerService.listCustomers();
    }

    @PostMapping(path = "/save")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.saveCustomer(customerRequestDto);
    }

    @DeleteMapping(path = "/delete")
    public void delete(CustomerRequestDto customerRequestDto){
         customerService.deleteCustomer(customerRequestDto);
    }
}
