package ru.stegnin.javaArchitectureHW.HW1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity implements Serializable {

    private String login;

    private String password;
}
