package co.edu.usb.Service;

import co.edu.usb.domain.DestinationType;
import co.edu.usb.repository.DestinationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Scope("singleton")
@Service
public class DestynationTypeServiceImpl  implements DestynationTypeService{

    @Autowired
    private DestinationTypeRepository destinationTypeRepository;

    @Override
    public DestinationType findByCodeAndStatus(String Code, String Status) throws Exception {

        //DestinationType destinationType = null;
       DestinationType destinationType = destinationTypeRepository.findByCodeAndStatus(Code, Status);
        return destinationType;
    }
}

