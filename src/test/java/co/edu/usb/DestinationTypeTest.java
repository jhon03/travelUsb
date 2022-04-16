package co.edu.usb;


import java.sql.SQLException;
import java.util.List;

import co.edu.usb.Service.DestynationTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.usb.domain.DestinationType;
import co.edu.usb.repository.DestinationTypeRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Rollback(false)
class DestinationTypeTest {

	@Autowired
	private DestinationTypeRepository destinationTypeRepository;

	@Autowired
	private DestynationTypeService destynationTypeService;
	
	@Test
	@Transactional
	void findDestinationTypesByCode() {
		
	List<DestinationType> lstDestinationTypeRepository = destinationTypeRepository.findAll();
	
	for(DestinationType dato:lstDestinationTypeRepository) {
		System.out.println(dato.getName());
	}
	}
	@Test
	@Transactional
	void searchDestinationTypeOrderAsc() throws SQLException {

		List<DestinationType> lstDestinationTypes = destinationTypeRepository.findByStatusOrderByCodeAsc("A");

		for (DestinationType typeDestino : lstDestinationTypes) {
			System.out.println(typeDestino.getCode());
		}
	}
	@Test
	@Transactional
	void buscarDestinationTypeCodeAndStatus() throws Exception {

try {
	DestinationType destinationType = destynationTypeService.findByCodeAndStatus("3883", "A");

	System.out.println(destinationType.getName());
}catch(Exception e){

	System.out.println(e.getMessage());
		}


	}


	}


