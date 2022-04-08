package co.edu.usb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usb.domain.DestinationType;

public interface DestinationTypeRepository extends JpaRepository<DestinationType, Integer>{

	
	public List<DestinationType> findByStatusOrderByCodeAsc (String status) throws SQLException;

	public DestinationType findByCodeAndStatus (String Code, String Status) throws Exception;
}
