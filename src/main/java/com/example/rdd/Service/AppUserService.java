package com.example.rdd.Service;

import com.example.rdd.Domain.AppUser.AppUser;
import com.example.rdd.Repository.AppUserCollaborationTypeRepository;
import com.example.rdd.Repository.AppUserRepository;
import com.example.rdd.Service.Generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AppUserService extends GenericService<AppUser, Long> {

    @Autowired
    AppUserRepository repository;

    @Autowired
    AppUserCollaborationTypeRepository appUserCollaborationTypeRepository;

    @Autowired
    CollaborationTypeService collaborationTypeService;

//    public void changeUserCredentials(final ChangeCredentialsRequest request) {
//        final var user = repository.findById(request.appUser().getId()).orElseThrow();
//        user.toBuilder().role(request.appUser().getRole()).build();
//    }
//
//    private void changeCollaborations(final AppUser appUser, final List<CollaborationType> collaborationTypes) {
////        final var excludedCollaborations = getCurrentCollaborationTypes(appUser).stream()
//
//        collaborationTypes.forEach(collaborationType -> {
//            final var collaboration = collaborationTypeService.findById(collaborationType.getId()).orElseThrow();
//            appUserCollaborationTypeRepository.save(AppUserCollaborationType.builder()
//                    .collaborationType(collaboration)
//                    .user(appUser)
//                    .build());
//        });
//    }
//
//    private List<CollaborationType> getCurrentCollaborationTypes(AppUser appUser) {
//        return appUserCollaborationTypeRepository.findAppUserCollaborationTypesByUser(appUser)
//                .stream()
//                .map(AppUserCollaborationType::getCollaborationType)
//                .toList();
//    }
}
