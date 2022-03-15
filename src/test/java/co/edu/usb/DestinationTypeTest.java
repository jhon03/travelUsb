package co.edu.usb;


import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.usb.domain.DestinationType;
import co.edu.usb.repository.DestinationTypeRepository;


@SpringBootTest
class DestinationTypeTest {

	@Autowired
	private DestinationTypeRepository destinationTypeRepository; 
	
	@Test
	void findDestinationTypesByCode() {
		
	List<DestinationType> lstDestinationTypeRepository = destinationTypeRepository.findAll();
	
	for(DestinationType dato:lstDestinationTypeRepository) {
		System.out.println(dato.getName());
	}
	}
	@Test
	void searchDestinationTypeOrderAsc() throws SQLException {
		
		List<DestinationType> lstDestinationTypes = destinationTypeRepository.findByStatusOrderByCodeAsc("A");
		
		for(DestinationType typeDestino: lstDestinationTypes) {
			System.out.println(typeDestino.getCode());
		}
	}
	}


