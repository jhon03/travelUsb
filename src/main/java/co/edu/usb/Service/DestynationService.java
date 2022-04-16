package co.edu.usb.Service;

import co.edu.usb.DTO.DestinationDTO;
import co.edu.usb.domain.Destination;

import java.sql.SQLException;
import java.util.List;

public interface DestynationService {


   public Destination guardarDestination (DestinationDTO destinationDTO) throws Exception;


   public  Destination findByCode (String Code) throws Exception;


   public Destination updateDestination (DestinationDTO destinationDTO) throws  Exception;

   public  Destination findById(Integer idDest) throws Exception;

   public void DestinationDelete (Integer IdDest) throws Exception;

   public List<Destination> findByCodeAndStatus(String code, String status) throws Exception;

   public List<Destination> findByDestinationType_Code (String Code) throws Exception;

   public List<Destination> findByStatus (String status) throws Exception;




}
