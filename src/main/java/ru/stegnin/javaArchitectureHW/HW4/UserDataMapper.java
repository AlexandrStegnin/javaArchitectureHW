package ru.stegnin.javaArchitectureHW.HW4;

import java.util.Optional;

public interface UserDataMapper {

    Optional<Student> find(Long id);

    void insert(Student student) throws DataMapperException;

    void update(Student student) throws DataMapperException;

    void delete(Student student) throws DataMapperException;

}
