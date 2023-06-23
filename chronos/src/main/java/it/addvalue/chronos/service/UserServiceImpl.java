package it.addvalue.chronos.service;

import java.util.List;
import java.util.Optional;

import it.addvalue.chronos.core.exception.EsecuzioneErrataException;
import it.addvalue.chronos.model.dto.UserDto;
import it.addvalue.chronos.model.mapper.UserDtoEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.addvalue.chronos.repository.IUserRepository;

@Service
public class UserServiceImpl implements ICrudSerice<User, String> {
  private static final String TABLE_NAME = "TB_UTENTI";
  protected static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired protected IUserRepository repository;
  @Autowired protected UserDtoEntityMapper mapper;

  @Override
  public List<User> findAll() {
    logger.debug("The method findAll has been invoked for the table {}", TABLE_NAME);
    return repository.findAll();
  }

  @Override
  public Optional<User> findById(String id) {
    logger.debug(
        "The method findById has been invoked for the table {}, with parameter id = {}",
        TABLE_NAME,
        id);
    return repository.findById(id);
  }

  @Override
  public User create(User model) {
    logger.debug(
        "The method create has been invoked for the table {}, with parameter model = {}",
        TABLE_NAME,
        model);
    return repository.save(model);
  }

  @Override
  public it.addvalue.chronos.model.entity. update(User model) {
    logger.debug(
        "The method update has been invoked for the table {}, with parameter model = {}",
        TABLE_NAME,
        model);
    return repository.save(model);
  }

  @Override
  public void delete(User model) {
    logger.debug(
        "The method delete has been invoked for the table {}, with parameter model = {}",
        TABLE_NAME,
        model);
    repository.delete(model);
  }

  public List<UserDto> getListaUtenti(User user) throws EsecuzioneErrataException {
    Optional<User> utente = repository.findById(user.getUserCode());
    if (utente.isPresent()) {
      int livello = utente.get().getLevel();
      if (livello > 5) {
        return mapper.toDtos(repository.ciao1(user.getUserCode()));
      } else {
        return mapper.toDtos(repository.ciao2());
      }
    } else {
      throw new EsecuzioneErrataException("utente non trovato");
    }
  }
}
