package co.edu.usb;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.edu.usb.domain.Destination;
import co.edu.usb.repository.DestinationRepository;

@SpringBootTest
class DestinationTest {
    
	@Autowired
	private DestinationRepository destinationRepository;
	@Test
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
		void searchDestinationForDestinationType() {
			
			List<Destination> lstDestination = null;
			try {
				
				lstDestination = destinationRepository.findByDestinationType_Code("PLAYA");
				
				for(Destination destination: lstDestination) {
					System.out.println(destination.getCode() + " - "+ destination.getName());
				
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				
			}
		}
			@Test
			void searchDestinationActives() {
				List<Destination> lstDestination = null;
				
				try {
					
					lstDestination = destinationRepository.findByStatus("A");
					for(Destination item:lstDestination) {
						System.out.println(item.getName() + " - "+ item.getCode());
					}
						
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
		
			}
		}
			


