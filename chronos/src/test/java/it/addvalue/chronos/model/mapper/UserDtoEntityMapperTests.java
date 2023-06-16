package it.addvalue.chronos.model.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.addvalue.chronos.ChronosApplication;
import it.addvalue.chronos.model.dto.UserDto;
import it.addvalue.chronos.model.entity.User;

@SpringBootTest(classes = ChronosApplication.class)
public class UserDtoEntityMapperTests {
  @Autowired private UserDtoEntityMapper mapper;

  @Test
  public void dtoToEntityTest() {
    UserDto dto = new UserDto();
    dto.setUserCode("addvalue");
    dto.setLevel(1);
    User entity = mapper.toEntity(dto);

    assertEquals("addvalue", entity.getUserCode());
    assertEquals(1, entity.getLevel());
  }

  @Test
  public void entityToDtoTest() {
    User entity = new User();
    entity.setUserCode("addvalue");
    entity.setLevel(1);
    UserDto dto = mapper.toDto(entity);

    assertEquals("addvalue", dto.getUserCode());
    assertEquals(1, dto.getLevel());
  }
}
