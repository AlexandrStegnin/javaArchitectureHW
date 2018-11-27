package ru.stegnin.javaArchitectureHW.HW4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDataMapperImpl implements UserDataMapper {

    private List<Student> students = new ArrayList<>();

    @Override
    public Optional<Student> find(Long id) {
        for (Student u : students) {
            if (u.getId().equals(id)) return Optional.of(u);
        }
        return Optional.empty();
    }

    @Override
    public void insert(Student student) throws DataMapperException {
        if (!students.contains(student)) {
            students.add(student);
        } else {
            throw new DataMapperException("Student [" + student.getName() + "] already exists!");
        }
    }

    @Override
    public void update(Student student) {
        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                students.remove(s);
                students.add(student);
            } else {
                throw new DataMapperException("Student [" + student.getName() + "] not found!");
            }
        }
    }

    @Override
    public void delete(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        } else {
            throw new DataMapperException("Student [" + student.getName() + "] not found!");
        }
    }

    public int getStudentsCount() {
        return students.size();
    }
}
