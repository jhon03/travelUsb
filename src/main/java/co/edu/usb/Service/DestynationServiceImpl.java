package co.edu.usb.Service;

import co.edu.usb.DTO.DestinationDTO;
import co.edu.usb.domain.Destination;
import co.edu.usb.domain.DestinationType;
import co.edu.usb.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Scope("singleton")
@Service
public class DestynationServiceImpl implements DestynationService {

    @Autowired
    private DestynationTypeService destynationTypeService;

    @Autowired
    private DestinationRepository destinationRepository;

  

    @Override
    public Destination guardarDestination(DestinationDTO destinationDTO) throws Exception {

        Destination destination = null;
        DestinationType destinationType = null;

        Destination destinoDB = findByCode(destinationDTO.getCode().trim());
        if (destinoDB != null) {
            throw new Exception("Ya existe un destino con este codigo.");
        }

        // crear el destino
        destination = new Destination();

        destination.setCode(destinationDTO.getCode());
        destination.setName(destinationDTO.getName());
        destination.setDescription(destinationDTO.getDescription());
        destination.setLand(destinationDTO.getLand());
        destination.setAir(destinationDTO.getAir());
        destination.setSea(destinationDTO.getSea());
        destination.setDateCreated(destinationDTO.getDateCreated());
        destination.setDateModified(destinationDTO.getDateModified());
        destination.setCreatorUser(destinationDTO.getCreatorUser());
        destination.setModifierUser(destinationDTO.getModifierUser());
        destination.setStatus(destinationDTO.getStatus());

        destinationType = destynationTypeService.findByCodeAndStatus(destinationDTO.getCodeDestinationType(), destinationDTO.getStatus());
        if(destinationType == null) {
            throw new Exception("El tipo destino " + destinationDTO.getCodeDestinationType() + " No existe");
        }

        destination.setDestinationType(destinationType);

        destinationRepository.save(destination);

        return destination;
    }

    @Override
    public Destination findByCode(String Code) throws Exception {
        Destination destination = destinationRepository.findByCode(Code);
        return destination;
    }

    @Override
    public Destination updateDestination(DestinationDTO destinationDTO) throws Exception {

        Destination destination = null;
        DestinationType destinationType = null;
        destination = findById(destinationDTO.getIdDest());

        destination.setCode(destinationDTO.getCode());
        destination.setName(destinationDTO.getName());
        destination.setDescription(destinationDTO.getDescription());
        destination.setLand(destinationDTO.getLand());
        destination.setAir(destinationDTO.getAir());
        destination.setSea(destinationDTO.getSea());
        destination.setDateCreated(destinationDTO.getDateCreated());
        destination.setDateModified(destinationDTO.getDateModified());
        destination.setCreatorUser(destinationDTO.getCreatorUser());
        destination.setModifierUser(destinationDTO.getModifierUser());
        destination.setStatus(destinationDTO.getStatus());

        destinationType = destynationTypeService.findByCodeAndStatus(destinationDTO.getCodeDestinationType(), destinationDTO.getStatus());
        if(destinationType == null) {
            throw new Exception("El tipo destino " + destinationDTO.getCodeDestinationType() + " No existe");
        }

        destination.setDestinationType(destinationType);
        destinationRepository.save(destination);

        return destination;
    }

    @Override
    public Destination findById(Integer idDest) throws Exception {

        if (idDest == null) {
            throw new Exception("Debe ingresar un id de destino");

        }

        if (!destinationRepository.findById(idDest).isPresent()) {
            throw new Exception("El destino con id:  " + idDest + "no existe");
        }
        return destinationRepository.findById(idDest).get();
    }


}


