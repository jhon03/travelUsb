package co.edu.usb.Service;

import co.edu.usb.Utils.Constantes;
import co.edu.usb.Utils.Utilities;
import co.edu.usb.domain.IdentificationType;
import co.edu.usb.repository.IdentificationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Scope("singleton")
@Service
public class IdentificationTypeServiceImpl implements IdentificationTypeService{


    @Autowired
    private IdentificationTypeRepository identificationTypeRepository;

    @Override
    public List<IdentificationType> findByStatusOrderByCodeAsc(String status) throws Exception {

        if(Utilities.isStringLenght(status, Constantes.TamanoEstado))
        {
            throw new Exception("Solo puede ingresar A o I");
        }


       List<IdentificationType> lstIdentificationType = identificationTypeRepository.findByStatusOrderByCodeAsc(status);
       if(lstIdentificationType.isEmpty())
       {
           throw new Exception("No hay tipos de identificacion activos");
       }
        return lstIdentificationType;
    }

    @Override
    public IdentificationType findByCodeAndStatus(String code, String Status) throws Exception{

        if(code == null   || code.trim().equals("") && Status == null   || Status.trim().equals(""))
        {
            throw new Exception("Debe ingresar un código y un estado");
        }

        if (Utilities.isStringLenght(Status, Constantes.TamanoEstado))
        {
            throw new Exception("Solo debe Ingresar A o I");
        }
        if (!Utilities.isStringInteger(Status)   || !Utilities.isStringInteger(code))
        {
            throw new Exception("No se admiten números ");
        }
        if(code.trim().length()>5)
        {
            throw new Exception("No existen códigos de más de 5 caracteres");
        }
        IdentificationType identificationType = identificationTypeRepository.findByCodeAndStatus(code, Status);
        if(identificationType == null)
        {
            throw new Exception("No existente tipos de identificacion para el código ingresado");
        }
        return identificationType;
    }
}
