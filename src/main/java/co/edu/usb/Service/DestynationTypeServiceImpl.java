package co.edu.usb.Service;

import co.edu.usb.Utils.Constantes;
import co.edu.usb.Utils.Utilities;
import co.edu.usb.domain.DestinationType;
import co.edu.usb.repository.DestinationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Scope("singleton")
@Service
public class DestynationTypeServiceImpl  implements DestynationTypeService{

	DestinationType destinationType = null;
    @Autowired
    private DestinationTypeRepository destinationTypeRepository;

	@Override
	public DestinationType findByCodeAndStatus(String code, String status) throws Exception {
		// TODO Auto-generated method stub
		

		if(code == null || code.trim().equals("") )
		{
			throw new Exception("Debe ingresar un codigo  del tipo destino");
		}
		if(!Utilities.isStringInteger(code) ){

			throw new Exception("Solo puede ingresar letras");
		}
		if(!Utilities.isStringInteger(status))
		{
			throw new Exception("Debe ingresar solo A o I en este campo");
		}

		if(status == null  || status.trim().equals("")){
			throw new Exception("Debe ingresar estado válido del tipo destino");
		}
		/*
		if(Utilities.isStringLenght(destinationType.getStatus(),Constantes.TamanoEstado))
		{
			throw new Exception("Solo puede ingresar A(activo) o I(inactivo)");
		}*/

			DestinationType destinationType = destinationTypeRepository.findByCodeAndStatus(code, status);
	        return destinationType;
	}

	@Override
	public List<DestinationType> findByStatusOrderByCodeAsc(String status) throws SQLException {

		List<DestinationType> lstDestinationTypes = destinationTypeRepository.findByStatusOrderByCodeAsc(status);
		return lstDestinationTypes;
	}


}




