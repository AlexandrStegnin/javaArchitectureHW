package ru.stegnin.javaArchitectureHW.HW4;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

    private Long id;

    private String name;

    private int points;

}
