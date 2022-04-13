package co.edu.usb.repository;

import java.sql.SQLException;
import java.util.List;

import co.edu.usb.DTO.DestinationDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usb.domain.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Integer>{
	
	public List<Destination> findByCodeAndStatus(String code, String status) throws SQLException;

	
	public List<Destination> findByDestinationType_Code (String Code) throws SQLException;
	
	public List<Destination> findByStatus (String status);

	public Destination findByCode (String Code) throws Exception;


}
