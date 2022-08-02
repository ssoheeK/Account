package com.example.account.dto;

import com.example.account.domain.Account;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Long userId;
    private String accountNumber;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    // 기본적인 생성자를 만들어서 쓰는 것도 괜찮지만
    // dto가 entity를 통해 만들어지는 경우가 많기 때문에,
    // entity를 가지고 dto로 변환을 할 수 있게 static한 메소드를 만들어줌
    // 장점 : 가독성이 좋고, 데이터가 안전하게 이동 가능
   public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .userId(account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
