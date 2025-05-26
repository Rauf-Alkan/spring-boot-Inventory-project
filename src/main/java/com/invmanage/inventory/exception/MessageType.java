package com.invmanage.inventory.exception;

import lombok.Getter;

@Getter
public enum MessageType {


    NO_RECORD_EXIST("1001", "kayıt bulunamadı"),
    NO_CATEGORY_FOUND("2002", "kategori bulunamadı"),
    GENERAL_EXCEPTION("9009", "genel hata");


    private String code;
    private String message;


    MessageType(String code, String message){
        this.code = code;
        this.message = message;
    }
}
