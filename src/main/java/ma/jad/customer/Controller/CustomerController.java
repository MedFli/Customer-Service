package ma.jad.customer.Controller;

import ma.jad.customer.Model.CustomerRequestDto;
import ma.jad.customer.Model.CustomerResponseDto;
import ma.jad.customer.Service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    private static final Logger logger = LogManager.getLogger(CustomerController.class);


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customer/{id}")
    public CustomerResponseDto getCustomer(@PathVariable Long id) {
        logger.info("incoming request to get customer by id " + id);
        return customerService.getCustomer(id);

    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDto> getAllCustomers() {
        logger.info("incoming request to get all customers in database");
        return customerService.listCustomers();
    }

    @PostMapping(path = "/save")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto) {
        logger.info("incoming request to save customer with ID" + customerRequestDto.getId());
        return customerService.saveCustomer(customerRequestDto);
    }

    @DeleteMapping(path = "/delete")
    public void delete(CustomerRequestDto customerRequestDto){
         customerService.deleteCustomer(customerRequestDto);
    }
}
