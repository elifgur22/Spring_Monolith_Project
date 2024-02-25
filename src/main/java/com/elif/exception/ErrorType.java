package com.elif.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
//Normalde Enum'da değişken tanımlamazdık. Burada değişken tanımladık. Her özelliği bir enumun içerisine verdik. Hata veriyordu ilk yazdığımızda
//Lombok anotasyonu ekledik getter ve allArgsCons
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR(1000,"Kontroller katmanında tanımsız gelen hata oluştu. Lütfen tekrar deneyiniz.",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(1001,"Girilen paratmetreler hatalıdır. Lütfen düzelterek tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_DUPLICATE_DOKTOR_HATASI(1002, "Girilen doktor isminde halihazırda kayıt vardır",HttpStatus.BAD_REQUEST),
    ERROR_DOCTOR_NOT_FOUND(1003, "Girilen doktor isminde bir doktor bulunamadı tekrar deneyiniz.",HttpStatus.BAD_REQUEST),
    ERROR_EMPTY_LIST(1004, "İstenilen liste boştur",HttpStatus.BAD_REQUEST),
    ERROR_DUPLICATE_AUTH(1003, "Girilen username ile kullanıcı mevcuttur lütfen başka bir username ile tekrar deneyiniz.",HttpStatus.BAD_REQUEST);

    int code;
    String message;
    HttpStatus httpStatus;
}
