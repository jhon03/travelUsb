package co.edu.usb.Mapper;

import co.edu.usb.DTO.CustomerDTO;
import co.edu.usb.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {


    @Mapping(source = "identificationType.name", target = "nameIdentificationType")
    @Mapping(source = "identificationType.code", target = "codeIdentificationType")
    @Mapping(source = "identificationTYpe.idTiid", target = "idTiid")
    public CustomerDTO customerToCustomerDTO(Customer customer);
}
