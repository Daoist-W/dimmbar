package com.donisiko.dimmbar.data.entities;

import com.donisiko.dimmbar.data.support.Position;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    Long id;

    @NotNull
    String forename;

    @NotNull
    String surname;

    @NotNull
    String username;

    @NotNull
    Integer password;

    @NotNull
    Position position;


}
