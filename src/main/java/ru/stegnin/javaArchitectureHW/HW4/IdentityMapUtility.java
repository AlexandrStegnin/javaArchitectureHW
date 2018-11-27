package ru.stegnin.javaArchitectureHW.HW4;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class IdentityMapUtility {

    private static Map<Long, Student> studentsMap = new HashMap<>();

    public static void addStudent(Student student) {
        studentsMap.merge(student.getId(), student, (oldStudent, newStudent) -> newStudent);
    }

    public Optional<Student> getStudent(Long id) {
        return Optional.ofNullable(studentsMap.getOrDefault(id, null));
    }

    public Optional<Student> getStudent(long id) {
        return getStudent(new Long(id));
    }

    public static void deleteStudent(Student student) {
        studentsMap.remove(student.getId());
    }

    public int getStudentsCount() {
        return studentsMap.size();
    }
}
