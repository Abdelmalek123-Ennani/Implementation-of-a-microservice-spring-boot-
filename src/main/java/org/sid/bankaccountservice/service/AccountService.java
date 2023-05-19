package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BanckAccountResponseDTO;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;

public interface AccountService {
     BanckAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);
}
