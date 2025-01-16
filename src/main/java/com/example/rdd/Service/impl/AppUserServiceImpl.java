//package com.example.rdd.Service.impl;
//
//import com.example.rdd.Domain.AppUser.AppUser;
//import com.example.rdd.Repository.AppUserRepository;
//import com.example.rdd.Service.AppUserService;
//import com.example.rdd.Service.exceptions.IntegrityViolation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.Optional;
//
//@Service
//public class AppUserServiceImpl implements AppUserService {
//
////    @Autowired
////    AppUserRepository repository;
////
////    @Override
////    public AppUser insertUser(final AppUser user) {
////        return repository.save(user);
////    }
////
////    @Override
////    public List<AppUser> listAll() {
////        return repository.findAll();
////    }
////
////    @Override
////    public AppUser findById(final Long id) {
////        return null;
////    }
////
////    @Override
////    public AppUser updateUser(final AppUser user) {
////        return null;
////    }
////
////    @Override
////    public void deleteUser(final Long id) {
////        repository.delete(findById(id));
////    }
////
////    private void findByEmail(AppUser obj) {
////        final AppUser busca = repository.findByEmail(obj.getEmail()).orElse(null);
////        if (busca != null && !busca.getId().equals(obj.getId())) {
////            throw new IntegrityViolation("Email %s já existe".formatted(obj.getEmail()));
////        }
////
////		Optional<AppUser> user = repository.findByEmail(obj.getEmail());
////		if (user.isPresent() && !Objects.equals(user.get().getId(), obj.getId())) {
////			throw new IntegrityViolation("Email %s já existe".formatted(obj.getEmail()));
////		}
////    }
//
//}
