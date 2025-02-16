package com.example.rdd.Service;

import com.example.rdd.Domain.AppUser.AppUserResponseDTO;
import com.example.rdd.Domain.AppUserCollaborationType.AppUserCollaborationType;
import com.example.rdd.Domain.CollaborationType.CollaborationType;
import com.example.rdd.Repository.AppUserCollaborationTypeRepository;
import com.example.rdd.Service.Generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserCollaborationTypeService extends GenericService<AppUserCollaborationType, Long> {

    @Autowired
    private AppUserCollaborationTypeRepository repository;

    public List<AppUserResponseDTO> getUsersByCollaboration(CollaborationType collaborationType) {
        final var response = repository.findAppUserByCollaborationType(collaborationType);
        final var users = response.stream().map(AppUserCollaborationType::getUser).toList();

        return users.stream().map(user -> AppUserResponseDTO.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getUsername())
                .build()).toList();
    }
}
