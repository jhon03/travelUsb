package co.edu.usb;



import java.util.Date;
import java.util.List;

import co.edu.usb.DTO.DestinationDTO;
import co.edu.usb.Service.DestynationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usb.domain.Destination;
import co.edu.usb.repository.DestinationRepository;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Rollback(false)
class DestinationTest {


	@Autowired
	private DestinationRepository destinationRepository;

	@Autowired
	private DestynationService destynationService;

	@Test
	@Transactional
	void searchDestinationForCodeAndStatus() {

		try {

			List<Destination> destination = destinationRepository.findByCodeAndStatus("BOSQU", "A");
			for (Destination item : destination) {
				System.out.println(item.getName());
			}

		} catch (Exception e) {
			// TODO: handle exception

			System.out.println(e.getMessage());
		}
	}

	@Test
	@Transactional
	void searchDestinationForDestinationType() {

		List<Destination> lstDestination = null;
		try {

			lstDestination = destinationRepository.findByDestinationType_Code("PLAYA");

			for (Destination destination : lstDestination) {
				System.out.println(destination.getCode() + " - " + destination.getName());

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
	}

	@Test
    @Transactional
	void searchDestinationActives() {
		List<Destination> lstDestination = null;

		try {

			lstDestination = destinationRepository.findByStatus("A");
			for (Destination item : lstDestination) {
				System.out.println(item.getName() + " - " + item.getCode());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Transactional
     void debeGuardarUnDestino() {

		try {
			DestinationDTO destinationDTO = new DestinationDTO();

			destinationDTO.setCode("AMZ");
			destinationDTO.setName("AMAZONAS");
			destinationDTO.setDescription("NATURALEZA A OTRO NIVEL");
			destinationDTO.setLand("S");
			destinationDTO.setAir("N");
			destinationDTO.setSea("N");
			destinationDTO.setDateCreated(new Date());

			destinationDTO.setCreatorUser("JHONH");

			destinationDTO.setStatus("A");

			destinationDTO.setCodeDestinationType("BOSQU");
			destinationDTO.setNameDestinationType("DESIERTO Y SOL");

			destynationService.guardarDestination(destinationDTO);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
		@Test
	    @Transactional
	   void updateDestino(){

		}
	}



			


