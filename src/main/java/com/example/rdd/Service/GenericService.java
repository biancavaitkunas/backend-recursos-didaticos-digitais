package com.example.rdd.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public abstract class GenericService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    public T save(T entity) {
        return repository.save(entity);
    }

    public T update(ID id, T entity) {
        final var existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));

        try {
            for (var field : entity.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                final var newValue = field.get(entity);

                if (Objects.nonNull(newValue)) {
                    field.set(existingEntity, newValue);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to update entity fields", e);
        }

        return repository.save(existingEntity);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    private Field findIdField(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(EntityNotFoundException::new);
    }
}
