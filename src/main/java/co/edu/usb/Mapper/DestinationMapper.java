package co.edu.usb.Mapper;

import co.edu.usb.DTO.DestinationDTO;
import co.edu.usb.domain.Destination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DestinationMapper {

    @Mapping(source = "destinationType.name", target = "nameDestinationType")
    @Mapping(source = "destinationType.code", target = "CodeDestinationType" )
    @Mapping(source = "destinationType", target = "idTyde")
    public DestinationDTO destinationToDestinationDTO(Destination destination);
}
