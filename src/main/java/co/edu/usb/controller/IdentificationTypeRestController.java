package co.edu.usb.controller;

import co.edu.usb.Service.IdentificationTypeService;
import co.edu.usb.domain.IdentificationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;
import java.util.List;

@RestController
@RequestMapping("/api/IdentificationType")
public class IdentificationTypeRestController {

    @Autowired
    private IdentificationTypeService identificationTypeService;

    @GetMapping("/findByStatusOrderByCodeAsc")
    public ResponseEntity<?> findByStatusOrderByCodeAsc(@RequestParam("Status") String Status) {
        try {
           List <IdentificationType>  lstidentificationType = identificationTypeService.findByStatusOrderByCodeAsc(Status);

            return ResponseEntity.ok().body(lstidentificationType);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
