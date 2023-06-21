package it.addvalue.chronos.repository;

import org.springframework.stereotype.Repository;

import it.addvalue.chronos.model.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {
    sus;
}
