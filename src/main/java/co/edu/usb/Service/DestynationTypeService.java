package co.edu.usb.Service;

import co.edu.usb.domain.DestinationType;

public interface DestynationTypeService {

    public DestinationType findByCodeAndStatus (String Code, String Status) throws Exception;

}
