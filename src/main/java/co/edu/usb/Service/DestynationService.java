package co.edu.usb.Service;

import co.edu.usb.DTO.DestinationDTO;
import co.edu.usb.domain.Destination;

public interface DestynationService {

   public Destination guardarDestination (DestinationDTO destinationDTO) throws Exception;

   public  Destination findByCode (String Code) throws Exception;

   public Destination updateDestination (DestinationDTO destinationDTO) throws  Exception;

   public  Destination findById(Integer idDest) throws Exception;
}
