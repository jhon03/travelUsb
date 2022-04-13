package co.edu.usb;



import java.util.Date;
import java.util.List;

import co.edu.usb.DTO.DestinationDTO;
import co.edu.usb.Service.DestynationService;

import co.edu.usb.Utilities.Constantes;
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

   Destination destination = null;
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

			destinationDTO.setCode("MEX");
			destinationDTO.setName("MEXICO");
			destinationDTO.setDescription("PLAYA, CULTURA Y BRISA");
			destinationDTO.setLand("N");
			destinationDTO.setAir("S");
			destinationDTO.setSea("N");
			destinationDTO.setDateCreated(new Date());


			destinationDTO.setCreatorUser("JHONH");
			destinationDTO.setModifierUser("CESARL");

			destinationDTO.setStatus(Constantes.Activo);

			destinationDTO.setCodeDestinationType("PLAYA");
			destinationDTO.setNameDestinationType("PLAYA Y MAR");

			destynationService.guardarDestination(destinationDTO);

			System.out.println("destino creado sactisfactoriamente");
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
		@Test
	    @Transactional
	   void updateDestino() {

			Destination destination = null;


			try {
				DestinationDTO destinationDTO = new DestinationDTO();

				destinationDTO.setIdDest(7);
				destinationDTO.setCode("ARM");
				destinationDTO.setName("ARMENIA");
				destinationDTO.setDescription("PURE NATURE");
				destinationDTO.setLand("SS");
				destinationDTO.setAir("N");
				destinationDTO.setSea("N");
				destinationDTO.setDateCreated(new Date());
				destinationDTO.setDateModified(new Date());
				destinationDTO.setCreatorUser("JHONH");
                destinationDTO.setModifierUser("JHONH");
				destinationDTO.setStatus("A");

				destinationDTO.setCodeDestinationType("BOSQU");
				destinationDTO.setNameDestinationType("NATURALEZA, BOSQUE Y AIRE");

				destynationService.updateDestination(destinationDTO);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
        @Test
	    @Transactional
		void destinationDelete() {


			try {

				destynationService.DestinationDelete(10);

			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		@Test
	    @Transactional
	void searchDestinationForId() {

			try {
				destination = destynationService.findById(6);

				System.out.println(destination.getName());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		@Test
		@Transactional
		void buscarPorCode(){
			try {
				destination = destynationService.findByCode(" ");
				System.out.println(destination.getName());
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
	}



			


