package com.example.rdd.Controller;

import com.example.rdd.Domain.AccessType.AccessType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("access_type")
public class AccessTypeController extends GenericController<AccessType, Long>{

//    @Autowired
//    private AccessTypeRepository repository;
//
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    @PostMapping
//    public void insert(@RequestBody AccessType accessType) {
//        repository.save(accessType);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<AccessType> update(@PathVariable Long id, @RequestBody AccessType accessType) {
//        final var access = repository.findById(id);
//        accessType.setId(id);
//        repository.save(accessType);
//        return access.isPresent() ? ResponseEntity.ok(accessType) : ResponseEntity.badRequest().build();
//    }
//
//    @GetMapping
//    public List<AccessType> getAll() {
//        return repository.findAll();
//    }
}
