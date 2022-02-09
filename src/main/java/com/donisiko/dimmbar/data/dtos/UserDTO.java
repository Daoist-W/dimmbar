package com.donisiko.dimmbar.data.dtos;

import com.donisiko.dimmbar.data.support.Position;
import lombok.Data;

@Data
public class UserDTO {
    Long id;
    String name;
    String username;
    Position position;
}
