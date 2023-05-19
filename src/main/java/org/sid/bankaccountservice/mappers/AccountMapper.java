package org.sid.bankaccountservice.mappers;


import org.sid.bankaccountservice.dto.BanckAccountResponseDTO;
import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.entities.BanckAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BanckAccountResponseDTO fromBankAccount(BanckAccount banckAccount) {
        BanckAccountResponseDTO bankAccountRequestDTO = new BanckAccountResponseDTO();
        // transfere les properties de banckAccount vers banAccountRequestDTO
        BeanUtils.copyProperties(banckAccount , bankAccountRequestDTO);
        return bankAccountRequestDTO;
    }
}
