package com.java.produk.data.support;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.function.Function;

public class BcryptWrapper {
    private final int logRounds;

    public BcryptWrapper(int logRounds) {
        this.logRounds = logRounds;
    }

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(this.logRounds));
    }

    public boolean verifyHash(String password, String hash, Function<String, Boolean> update) {
        return BCrypt.checkpw(password, hash);
    }
}
