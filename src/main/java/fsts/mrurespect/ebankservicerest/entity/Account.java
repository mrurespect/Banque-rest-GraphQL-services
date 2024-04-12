package fsts.mrurespect.ebankservicerest.entity;

import fsts.mrurespect.ebankservicerest.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Account {
    @Id
    private  String id ;
    private Date createDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType ;
    private Double balance;
}
