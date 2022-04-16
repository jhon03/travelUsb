package co.edu.usb.Service;

import co.edu.usb.Utils.Utilities;
import co.edu.usb.domain.DestinationType;
import co.edu.usb.repository.DestinationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Scope("singleton")
@Service
public class DestynationTypeServiceImpl  implements DestynationTypeService{

	DestinationType destinationType = null;
    @Autowired
    private DestinationTypeRepository destinationTypeRepository;

	@Override
	public DestinationType findByCodeAndStatus(String Code, String Status) throws Exception {
		// TODO Auto-generated method stub
		

		if(Code ==null || Code.trim().equals("") )
		{
			throw new Exception("Debe ingresar un codigo  del tipo destino");
		}
		if(!Utilities.isStringInteger(Code) ){

			throw new Exception("Solo puede ingresar letras");
		}
		if(!Utilities.isStringInteger(Status))
		{
			throw new Exception("Debe ingresar solo A o I en este campo");
		}

		if(Status == null  || Status.trim().equals("")){
			throw new Exception("Debe ingresar estado válido del tipo destino");
		}
		/*
		if(Utilities.isStringLenght(destinationType.getStatus(),Constantes.TamanoEstado))
		{
			throw new Exception("Solo puede ingresar A(activo) o I(inactivo)");
		}*/

			DestinationType destinationType = destinationTypeRepository.findByCodeAndStatus(Code, Status);
	        return destinationType;
	}

    }


