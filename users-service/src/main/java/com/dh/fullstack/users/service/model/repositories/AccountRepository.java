package com.dh.fullstack.users.service.model.repositories;

import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author Santiago Mamani
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

//    Optional<Account> findByEmailAndState(String email, AccountState state);

    List<Account> findAllByStateOrderByEmailAsc(AccountState state);
//
//    @Query("select item from Account item where item.email = ?1 and item.state = ?2")
//    Optional<Account> findAccount(String email, AccountState state);

    @Query("select item from Account item where item.email = :email and item.state = :state")
    Optional<Account> findAccount(@Param("email") String email, @Param("state") AccountState state);
}
