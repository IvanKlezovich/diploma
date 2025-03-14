package com.example.diploma.repository;

import com.example.diploma.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  @Modifying
  @Query(value = "update users set is_blocked = not is_blocked where id = :blockUserId",
      nativeQuery = true)
  void blockUser(UUID blockUserId);

  @Modifying
  @Query(nativeQuery = true,
      value = "update user"
          + "set role = :name"
          + "where id = :userId")
  void changeRole(@Param("userId") UUID userId,
      @Param("name") String name);
}
