package co.edu.usb;




import java.sql.SQLException;
import java.util.List;


import co.edu.usb.Service.IdentificationTypeService;
import co.edu.usb.Utils.Constantes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usb.domain.IdentificationType;
import co.edu.usb.repository.IdentificationTypeRepository;

@SpringBootTest
@Rollback(false)
class IdentificationTypeTest {

	@Autowired
	private IdentificationTypeRepository identificationTypeRepository;

	@Autowired
	private IdentificationTypeService identificationTypeService;
	
	
	@Test
	@Transactional
    void searchforIdentificationTypesByStatusOrderAsc()  throws Exception{
		
		try {
			
			List<IdentificationType> lstIdentificationTypeRepos = identificationTypeService.findByStatusOrderByCodeAsc("AA");
			
			for(IdentificationType tiid:lstIdentificationTypeRepos) {
				System.out.println(tiid.getCode());
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
		@Test
		@Transactional
		void searchIdentificationTypeForCodeAndStatus() throws Exception {
			
		try {
			IdentificationType identificationType = identificationTypeService.findByCodeAndStatus("CC", Constantes.Activo);
		
            System.out.println(identificationType.getName());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
				
	
		}
}
