package fsts.mrurespect.ebankservicerest.exception.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CustomerErrorResponce {
    private int status;
    private String message;
    private long timeStamp;
}
