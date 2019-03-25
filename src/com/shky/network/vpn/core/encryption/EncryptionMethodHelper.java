package com.shky.network.vpn.core.encryption;

import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

public interface EncryptionMethodHelper {

    AlgorithmParameterSpec generateEncryptionMethodParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException;
    KeyPair createKeyPair(AlgorithmParameterSpec encryptionMethodParameters) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException;
    PublicKey getUnencodedPublicKey(byte[] publicKeyEncoded) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalStateException;

}
