package ru.stegnin.javaArchitectureHW.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public abstract class AbstractEntity {

    @NotNull
    private String id = UUID.randomUUID().toString();

    @NotNull
    private LocalDate created = LocalDate.now();

    @NotNull
    private LocalDate updated = LocalDate.now();

}
