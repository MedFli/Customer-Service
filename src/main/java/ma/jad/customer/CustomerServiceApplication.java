package ma.jad.customer;

import ma.jad.customer.Model.Customer;
import ma.jad.customer.Model.CustomerRequestDto;
import ma.jad.customer.Service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("ma.jad.customer")
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService, RepositoryRestConfiguration config) {
        config.exposeIdsFor(Customer.class);
        return args -> {
            CustomerRequestDto c1 = new CustomerRequestDto(1L, "chiro", "chir@email");
            CustomerRequestDto c2 = new CustomerRequestDto(2L, "jad", "chir@email");
            CustomerRequestDto c3 = new CustomerRequestDto(3L, "amine", "chir@email");
            List<CustomerRequestDto> listResp = new ArrayList<>();
            listResp.add(c1);
            listResp.add(c2);
            listResp.add(c3);
            listResp.forEach(customerService::saveCustomer);
            System.out.println(listResp);
        };
    }
}
