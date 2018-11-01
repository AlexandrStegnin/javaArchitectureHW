package ru.stegnin.javaArchitectureHW.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User extends AbstractEntity implements Serializable {

    private String login;

    private String password;
}
