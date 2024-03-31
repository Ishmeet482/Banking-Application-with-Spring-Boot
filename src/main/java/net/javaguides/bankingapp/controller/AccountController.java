package net.javaguides.bankingapp.controller;

import net.javaguides.bankingapp.dto.Accountdto;
import net.javaguides.bankingapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add account REST API
    @PostMapping
    public ResponseEntity<Accountdto>addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);
    }

    //Get account restapi
    @GetMapping("/{id}")
    public ResponseEntity<Accountdto> getAccountbyId(@PathVariable Long id){
        Accountdto accountdto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountdto);
    }

    //deposit restapi
    @PutMapping("/{id}/deposit")
    public ResponseEntity<Accountdto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
        Double amount= request.get("amount");

        Accountdto accountdto=accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountdto);

    }

    //withdraw restapi
    @PutMapping("/{id}/withdraw")

    public ResponseEntity<Accountdto>withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request){

        double amount=request.get("amount");
        Accountdto accountdto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountdto);
    }

    //get all account rest api
    @GetMapping
    public ResponseEntity<List<Accountdto>>getAllaccounts(){

        List<Accountdto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    //delete account rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
