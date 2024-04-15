package fsts.mrurespect.ebankservicerest.web;

import fsts.mrurespect.ebankservicerest.dto.AccountRequestDto;
import fsts.mrurespect.ebankservicerest.dto.AccountResponseDto;
import fsts.mrurespect.ebankservicerest.dto.CustomerRequestDto;
import fsts.mrurespect.ebankservicerest.entity.Account;
import fsts.mrurespect.ebankservicerest.entity.Customer;
import fsts.mrurespect.ebankservicerest.exception.account.AccountNotFoundException;
import fsts.mrurespect.ebankservicerest.exception.customer.CustumerNotFoundException;
import fsts.mrurespect.ebankservicerest.service.AccountService;
import fsts.mrurespect.ebankservicerest.service.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlController {
    private final AccountService accountService;
    private final CustomerService customerService;

    public AccountGraphQlController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @QueryMapping
    public List<Account> accountList() {
        return accountService.getAllAccounts();
    }
    @QueryMapping
    public Account account(@Argument  String  id) throws AccountNotFoundException {
        return accountService.getAccountById(id);
    }

    @MutationMapping
    public AccountResponseDto addAccount(@Argument AccountRequestDto account){
        return accountService.addAccount(account);
    }
    @MutationMapping
    public Account updateAccount(@Argument Account account) throws AccountNotFoundException {
        return accountService.updateAccount(account);
    }
    @MutationMapping
    public boolean deleteAccount(@Argument String id) throws AccountNotFoundException {
        return accountService.deleteAccount(id);
    }

    @QueryMapping
    public List<Customer> customerList() {
        return customerService.getAllCustomers();
    }
    @QueryMapping
    public Customer customer(@Argument  Long  id) throws CustumerNotFoundException {
        return customerService.getCustomerById(id);
    }
    @MutationMapping
    public Customer addCustomer(@Argument CustomerRequestDto customer){
        return customerService.addCustomer(customer);
    }
    @MutationMapping
    public Customer updateCustomer(@Argument Customer customer) throws CustumerNotFoundException {
        return customerService.updateCustomer(customer);
    }
    @MutationMapping
    public boolean deleteCustomer(@Argument String id) throws CustumerNotFoundException {
        return customerService.deleteCustomer(id);
    }
    @MutationMapping
    public Customer addAccountToCustomer(@Argument Long customerId, @Argument String accountId) throws CustumerNotFoundException, AccountNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        Account account = accountService.getAccountById(accountId);
        account.setCustomer(customer);
        customer.getAccounts().add(account);
        customerService.updateCustomer(customer);
        accountService.updateAccount(account);
        return customer;
    }
}
