package net.javaguides.bankingapp.mapper;

import net.javaguides.bankingapp.dto.Accountdto;
import net.javaguides.bankingapp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(Accountdto accountdto){
        Account account=new Account(
                accountdto.getId(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );

        return account;
    }

    public static Accountdto mapToAccountdto(Account account){
        Accountdto accountdto=new Accountdto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountdto;

    }
}
