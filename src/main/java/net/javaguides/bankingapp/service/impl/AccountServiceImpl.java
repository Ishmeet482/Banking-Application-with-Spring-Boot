package net.javaguides.bankingapp.service.impl;

import net.javaguides.bankingapp.dto.Accountdto;
import net.javaguides.bankingapp.entity.Account;
import net.javaguides.bankingapp.mapper.AccountMapper;
import net.javaguides.bankingapp.repository.AccountRepository;
import net.javaguides.bankingapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto createAccount(Accountdto accountdto) {
        Account account= AccountMapper.mapToAccount(accountdto);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountdto(savedAccount);
    }

    @Override
    public Accountdto getAccountById(Long id) {

      Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountdto(account);
    }

    @Override
    public Accountdto deposit(Long id, double amount) {

        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountdto(savedAccount);
    }

    @Override
    public Accountdto withdraw(Long id, double amount) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

        if(account.getBalance()< amount){
            throw new RuntimeException("Insufficient amount");
        }
        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount =accountRepository.save(account);


        return AccountMapper.mapToAccountdto(savedAccount);
    }

    @Override
    public List<Accountdto> getAllAccounts() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountdto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

        accountRepository.deleteById(id);


    }
}
