package co.edu.usb.controller;

import co.edu.usb.DTO.DestinationTypeDTO;
import co.edu.usb.Service.DestynationTypeService;
import co.edu.usb.domain.DestinationType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
@RequestMapping("/api/destinationType")
//@Slf4j
public class DestinationTypeRestController {

    @Autowired
    private DestynationTypeService destynationTypeService;

    @GetMapping("/findByCodeAndStatus")
    public ResponseEntity<?> findByCodeAndStatus(@RequestParam("code")String code, @RequestParam("status") String status)
    {

        try {
            DestinationType destinationType = destynationTypeService.findByCodeAndStatus(code, status);

            //DestinationTypeDTO destinationTypeDTO = new DestinationTypeDTO();
           // destinationTypeDTO.setName(destinationType.getName());

          //destinationType.setName(destinationType.getName());

           // int a = 1/0;
            return ResponseEntity.ok().body(destinationType);

        } catch (Exception e) {

            //errores controlados
            //log.error(e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }
}