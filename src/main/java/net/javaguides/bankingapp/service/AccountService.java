package net.javaguides.bankingapp.service;

import net.javaguides.bankingapp.dto.Accountdto;
import net.javaguides.bankingapp.entity.Account;

import java.util.List;

public interface AccountService {

    Accountdto createAccount(Accountdto accountdto);

    Accountdto getAccountById(Long id);

    Accountdto deposit(Long id, double amount);

    Accountdto withdraw(Long id, double amount);

    List<Accountdto>getAllAccounts();

    void deleteAccount(Long id);

}
