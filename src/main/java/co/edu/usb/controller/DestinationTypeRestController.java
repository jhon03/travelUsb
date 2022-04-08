package co.edu.usb.controller;

import co.edu.usb.DTO.DestinationTypeDTO;
import co.edu.usb.Service.DestynationTypeService;
import co.edu.usb.domain.DestinationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
@RequestMapping("/api/destinationType")
public class DestinationTypeRestController {

    @Autowired
    private DestynationTypeService destynationTypeService;

    @GetMapping("/findByCodeAndStatus")
    public ResponseEntity<?> findByCodeAndStatus(String Code, String Status) {

        try {
            DestinationType destinationType = destynationTypeService.findByCodeAndStatus("PLAYA", "A");

            DestinationTypeDTO destinationTypeDTO = new DestinationTypeDTO();
            destinationTypeDTO.setName(destinationType.getName());

            return ResponseEntity.ok().body(destinationTypeDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }
}