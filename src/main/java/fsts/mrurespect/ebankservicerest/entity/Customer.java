package fsts.mrurespect.ebankservicerest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data  @AllArgsConstructor @Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Account> accounts ;

    public Customer() {
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
    }
}
