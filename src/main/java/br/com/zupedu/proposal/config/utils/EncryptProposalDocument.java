package br.com.zupedu.proposal.config.utils;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public abstract class EncryptProposalDocument {

    private static TextEncryptor encryptor = Encryptors.queryableText("document", "2dbed9bb675c0da5");

    public static String genereteHash(String str) {
        return encryptor.encrypt(str);
    }

    public static String decodeHash(String str) {
        return encryptor.decrypt(str);
    }
}
