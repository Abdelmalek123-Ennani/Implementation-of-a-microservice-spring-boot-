package org.sid.bankaccountservice.web;

import org.sid.bankaccountservice.dto.BanckAccountResponseDTO;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.entities.BanckAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepositoty;
import org.sid.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepositoty bankAccountRepositoty;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepositoty bankAccountRepositoty ,  AccountService accountService) {
        this.bankAccountRepositoty = bankAccountRepositoty;
        this.accountService = accountService;
    };


    @GetMapping("/bankAccounts")
    public List<BanckAccount> bankAccounts() {
        return bankAccountRepositoty.findAll();
    }

    
    @GetMapping("/bankAccounts/{id}")
    public BanckAccount banckAccount(@PathVariable String id) {
        return bankAccountRepositoty.findById(id)
                    .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));
    }


    @PostMapping("/bankAccounts")
    public BanckAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        return accountService.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BanckAccount update(@PathVariable String id, @RequestBody BanckAccount banckAccount) {
        BanckAccount account = bankAccountRepositoty.findById(id)
                    .orElseThrow(() -> new RuntimeException(String.format("Account not found", id)));

                    if(banckAccount.getBalance() != null ) account.setBalance(banckAccount.getBalance());
                    if(banckAccount.getCurrency() != null ) account.setCurrency(banckAccount.getCurrency());
                    if(banckAccount.getType() != null ) account.setType(banckAccount.getType());
                    if(banckAccount.getCreatedAt() != null ) account.setCreatedAt(banckAccount.getCreatedAt());

                    return bankAccountRepositoty.save(account);
    }


    @DeleteMapping("/bancAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepositoty.deleteById(id);
    };







    
}
