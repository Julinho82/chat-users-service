package com.dh.fullstack.users.service.model.repositories;

import com.dh.fullstack.users.service.model.domain.Company;
import com.dh.fullstack.users.service.model.domain.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Santiago Mamani
 */
public interface ContractRepository extends JpaRepository<Contract,Long> {

}
