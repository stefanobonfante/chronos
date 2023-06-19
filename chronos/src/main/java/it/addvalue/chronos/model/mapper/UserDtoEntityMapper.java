package it.addvalue.chronos.model.mapper;

import org.springframework.stereotype.Component;

import it.addvalue.chronos.model.dto.UserDto;
import it.addvalue.chronos.model.entity.User;

@Component
public class UserDtoEntityMapper implements IDtoEntityBidirectionalMapper<UserDto, User> {

    @Override
    public UserDto toDto(User entity) {
        UserDto dto = new UserDto();
        dto.setUserCode(entity.getUserCode());
        dto.setLevel(entity.getLevel());
        return dto;
    }

    @Override
    public User toEntity(UserDto dto) {
        User entity = new User();
        entity.setUserCode(dto.getUserCode());
        entity.setLevel(dto.getLevel());
        return entity;
    }
}
