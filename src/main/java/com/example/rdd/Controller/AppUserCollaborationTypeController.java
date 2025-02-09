package com.example.rdd.Controller;

import com.example.rdd.Domain.AppUser.AppUserResponseDTO;
import com.example.rdd.Domain.AppUserCollaborationType.AppUserCollaborationType;
import com.example.rdd.Domain.CollaborationType.CollaborationType;
import com.example.rdd.Domain.Platform.Platform;
import com.example.rdd.Domain.PlatformSubfilter.PlatformSubfilter;
import com.example.rdd.Domain.Subfilter.Subfilter;
import com.example.rdd.Service.AppUserCollaborationTypeService;
import com.example.rdd.Service.PlatformSubfilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user_collaboration")
public class AppUserCollaborationTypeController extends GenericController<AppUserCollaborationType, Long> {

    @Autowired
    private AppUserCollaborationTypeService service;

    @GetMapping("dto/{id}")
    public ResponseEntity<List<AppUserResponseDTO>> getUsersByCollaboration(@PathVariable CollaborationType collaborationType) {
        return new ResponseEntity<>(service.getUsersByCollaboration(collaborationType), HttpStatus.OK);
    }
}
