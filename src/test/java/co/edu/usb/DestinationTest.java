package co.edu.usb;



import java.util.Date;
import java.util.List;

import co.edu.usb.DTO.DestinationDTO;
import co.edu.usb.Service.DestynationService;

import co.edu.usb.Utils.Constantes;
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

			List<Destination> destination = destynationService.findByCodeAndStatus("PLAYA", Constantes.Activo);
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

			lstDestination = destynationService.findByDestinationType_Code("PLAYA");

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

			lstDestination = destynationService.findByStatus(Constantes.Activo);
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

			destinationDTO.setCode("ARM");
			destinationDTO.setName("ARMENIA");
			destinationDTO.setDescription("TIERRA DE CAFE");
			destinationDTO.setLand("S");
			destinationDTO.setAir("N");
			destinationDTO.setSea("N");
			destinationDTO.setDateCreated(new Date());


			destinationDTO.setCreatorUser("JHONH");
			//destinationDTO.setModifierUser("CESARL");

			destinationDTO.setStatus("A");

			//destinationDTO.setCodeDestinationType("PLAYA");
			//destinationDTO.setNameDestinationType("PLAYA Y MAR");
			destinationDTO.setCodeDestinationType("CULTU");
			destinationDTO.setNameDestinationType("CULTURAL");


			destynationService.guardarDestination(destinationDTO);

			System.out.println("destino creado sactisfactoriamente");
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}
		@Test
	    @Transactional
	   void updateDestino() {

			DestinationDTO destination = null;


			try {
				DestinationDTO destinationDTO = new DestinationDTO();

				destinationDTO.setIdDest(9);
				destinationDTO.setCode("PUT");
				destinationDTO.setName("PUTUMAYO");
				destinationDTO.setDescription("AIRE PUROooo");
				destinationDTO.setLand("S");
				destinationDTO.setAir("N");
				destinationDTO.setSea("N");
                destinationDTO.setDateCreated(new Date());
				destinationDTO.setDateModified(new Date());

				destinationDTO.setCreatorUser("JHONH");
                destinationDTO.setModifierUser("JHONH");
				destinationDTO.setStatus(Constantes.Activo);

				destinationDTO.setCodeDestinationType("BOSQU");
				destinationDTO.setNameDestinationType("NATURALEZA, BOSQUE Y AIRE");

				destynationService.updateDestination(destinationDTO);
				System.out.println("Update Destination");

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
        @Test
	    @Transactional
		void destinationDelete() {


			try {

				destynationService.DestinationDelete(13);
                 System.out.println("Destino eliminado sactisfactoriamente");
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}
		}
		@Test
	    @Transactional
	void searchDestinationForId() {

			try {
				destination = destynationService.findById(9);

				System.out.println(destination.getName());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		@Test
		@Transactional
		void buscarPorCode() {

		Destination destination1 = null;
			try {
				destination = destynationService.findByCode("PUT");
				System.out.println(destination.getName());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
            @Test
			@Transactional
			void buscarPorId(){
				try {
					destination = destynationService.findById(6);
					System.out.println("El destino que se encontro es: " + destination.getName());
				}catch (Exception e){
					System.out.println(e.getMessage());
				}
		}
	}



			


