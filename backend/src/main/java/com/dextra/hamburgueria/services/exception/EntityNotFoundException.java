package com.dextra.hamburgueria.services.exception;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 5573572785382419086L;

    public EntityNotFoundException(String msg){
        super(msg);
    }

}
