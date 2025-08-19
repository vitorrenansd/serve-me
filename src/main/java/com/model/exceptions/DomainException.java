package com.model.exceptions;

public class DomainException extends Exception{ 
/* 
    É possivel extender da classe RunTimeException caso não tenha 
    necessidade de tratar a excessão para rodar o código e caso ela venha a ocorrer o código irá quebrar.
*/

    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }
}