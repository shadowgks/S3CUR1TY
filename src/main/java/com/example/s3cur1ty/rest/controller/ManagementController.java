package com.example.s3cur1ty.rest.controller;

import com.example.s3cur1ty.model.enums.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/management")
@RequiredArgsConstructor
public class ManagementController {

//    @PreAuthorize("hasAnyAuthority('PERMISSION_ROLE:ALL', 'PERMISSION_ROLE:CREATE')")
    @PreAuthorize("hasAnyAuthority('PERMISSION_MANAGEMENT:ALL', 'PERMISSION_MANAGEMENT:CREATE')")
    @PostMapping("/create")
    public ResponseEntity<?> create(){
        return new ResponseEntity<>("create management", HttpStatus.CREATED);
    }
    @PreAuthorize("hasAnyAuthority('PERMISSION_MANAGEMENT:ALL', 'PERMISSION_MANAGEMENT:UPDATE')")
    @PutMapping("/update")
    public ResponseEntity<?> update(){
        return new ResponseEntity<>("update management", HttpStatus.OK);
    }
    @PreAuthorize("hasAnyAuthority('PERMISSION_MANAGEMENT:ALL', 'PERMISSION_MANAGEMENT:READ')")
    @GetMapping
    public ResponseEntity<?> read(){
        return new ResponseEntity<>("read management", HttpStatus.OK);
    }
    @PreAuthorize("hasAnyAuthority('PERMISSION_MANAGEMENT:ALL', 'PERMISSION_MANAGEMENT:DELETE')")
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(){
        return new ResponseEntity<>("delete management", HttpStatus.NO_CONTENT);
    }
}
