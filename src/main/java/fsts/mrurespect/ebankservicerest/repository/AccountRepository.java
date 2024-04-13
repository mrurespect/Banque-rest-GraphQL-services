package fsts.mrurespect.ebankservicerest.repository;


import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, String> {
    @RestResource
    List<Account> findByAccountType(AccountType accountType);
}
