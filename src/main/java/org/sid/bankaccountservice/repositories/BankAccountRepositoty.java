package org.sid.bankaccountservice.repositories;

import org.sid.bankaccountservice.entities.BanckAccount;
import org.sid.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepositoty extends JpaRepository<BanckAccount , String> {
    @RestResource(path = "/byType")
    List<BanckAccount> findByType(@Param("t") AccountType type);
    // http://localhost:8081/banckAccounts/search/byType?t=CURRENT_TYPE
}
