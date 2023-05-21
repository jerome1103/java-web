package tw.jerome.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.jerome.domain.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{}