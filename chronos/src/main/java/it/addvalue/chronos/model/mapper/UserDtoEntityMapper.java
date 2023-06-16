package it.addvalue.chronos.model.mapper;

import org.springframework.stereotype.Component;

import it.addvalue.chronos.model.dto.UserDto;
import it.addvalue.chronos.model.entity.User;

@Component
public class UserDtoEntityMapper implements IDtoEntityBidirectionalMapper<UserDto, User> {

  @Override
  public UserDto toDto(User entity) {
    UserDto userDto = new UserDto();
    userDto.setUserCode(entity.getUserCode());
    userDto.setLevel(entity.getLevel());
    return userDto;
  }

  @Override
  public User toEntity(UserDto dto) {
    User entity = new User();
    entity.setUserCode(dto.getUserCode());
    entity.setLevel(dto.getLevel());
    return entity;
  }
}
