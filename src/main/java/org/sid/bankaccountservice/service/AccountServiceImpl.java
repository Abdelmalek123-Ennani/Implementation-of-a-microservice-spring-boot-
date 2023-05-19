package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BanckAccountResponseDTO;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.entities.BanckAccount;
import org.sid.bankaccountservice.mappers.AccountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // !! of spring

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BankAccountRepositoty bankAccountRepositoty;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BanckAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BanckAccount banckAccount = BanckAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();

        BanckAccount savedBankAccount =  bankAccountRepositoty.save(banckAccount);
        BanckAccountResponseDTO banckAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);

        return banckAccountResponseDTO;
    }
}
