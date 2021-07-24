package ma.jad.customer.Mappers;

import ma.jad.customer.Model.Customer;
import ma.jad.customer.Model.CustomerRequestDto;
import ma.jad.customer.Model.CustomerResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    //interface implemented
    CustomerResponseDto mapCustomerToResponse(Customer customer);
    Customer mapCustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}
