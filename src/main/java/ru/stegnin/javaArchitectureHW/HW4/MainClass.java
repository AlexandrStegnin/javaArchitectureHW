package ru.stegnin.javaArchitectureHW.HW4;


import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

public class MainClass {
    private static Logger LOG = Logger.getLogger(MainClass.class.getName());

    public static void main(String[] args) {

        final IdentityMapUtility identityMapUtility = new IdentityMapUtility();

        final UserDataMapperImpl mapper = new UserDataMapperImpl();

        Student student = new Student(1L, "Alex", 10);
        mapper.insert(student);
        IdentityMapUtility.addStudent(student);

        LOG.info("Student " + student + " inserted successfully");

        Optional<Student> studentFounded = identityMapUtility.getStudent(1L);
        if (Objects.equals(null, studentFounded)) {
            studentFounded = mapper.find(1L);
        }

        LOG.info("Student " + studentFounded + " found");

        student = new Student(student.getId(), "Alex Updated", 5);

        mapper.update(student);
        IdentityMapUtility.addStudent(student);

        LOG.info("Student " + student + " updated");
        LOG.info("Student " + student + " is going to be deleted");
        LOG.info(String.format("Students BEFORE DELETE in LIST (DB) = %d, in identityMap = %d",
                mapper.getStudentsCount(), identityMapUtility.getStudentsCount()));
        mapper.delete(student);
        IdentityMapUtility.deleteStudent(student);

        LOG.info(String.format("Students AFTER DELETE in LIST (DB) = %d, in identityMap = %d",
                mapper.getStudentsCount(), identityMapUtility.getStudentsCount()));

    }
}
