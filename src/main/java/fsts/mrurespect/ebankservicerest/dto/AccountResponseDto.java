package fsts.mrurespect.ebankservicerest.dto;

import fsts.mrurespect.ebankservicerest.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AccountResponseDto {
    private  String id ;
    private Date createDate;
    private String currency;
    private AccountType accountType ;
    private Double balance;
}
