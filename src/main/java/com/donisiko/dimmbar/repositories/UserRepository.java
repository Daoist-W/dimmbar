package com.donisiko.dimmbar.repositories;

import com.donisiko.dimmbar.data.entities.User;
import com.donisiko.dimmbar.data.support.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // SELECT * from User where forename = '[forename]';
    public List<User> findUserByForename(String forename);

    // SELECT * from User where position = '[position]';
    public List<User> findUserByPosition(Position position);


}
