package com.elif.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    @NotBlank(message = "username cannot be blank")
    @Size(min = 3, max = 64, message = "username must be between 3 and 64 characters")
    String username;
    @Size(min = 8, max = 64, message = "password must have at least 8 characters")
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!*?.]).{8,64}$",
    message="En az 1 büyük harf, en az bir küçük harf en az bir rakam ve [!*?.] karakterlerinden birini kullanmalısınız.")
    String password;
    String repassword;

}
