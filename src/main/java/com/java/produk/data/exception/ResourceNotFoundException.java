package com.java.produk.data.exception;

public class ResourceNotFoundException  extends RuntimeException{
    private static final long serialVersionUID = 8720716765345933158L;

    private final String msg;

    public static ResourceNotFoundException create(String msg) {
        return new ResourceNotFoundException(msg);
    }

    public ResourceNotFoundException(String msg) {
        super();
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
