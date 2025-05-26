package com.invmanage.inventory.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {

    private MessageType messageType;

    private String ofStatic;

    public String prepareError(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(messageType.getMessage());
        if(ofStatic != null){
            stringBuilder.append(" : "+ ofStatic);
        }
        return stringBuilder.toString();
    }
}
