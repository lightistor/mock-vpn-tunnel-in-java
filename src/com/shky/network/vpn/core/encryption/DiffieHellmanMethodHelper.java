
package com.shky.network.vpn.core.encryption;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.KeyAgreement;
import javax.crypto.spec.DHParameterSpec;


public class DiffieHellmanMethodHelper implements EncryptionMethodHelper{
	
	public KeyAgreement keyAgreement;
	
	// Used source from http://docs.oracle.com/javase/1.4.2/docs/guide/security/jce/JCERefGuide.html to help with DHHandshake

	public AlgorithmParameterSpec generateEncryptionMethodParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException {
		AlgorithmParameterGenerator paramGen = AlgorithmParameterGenerator.getInstance("DH");
        paramGen.init(512);
        AlgorithmParameters params = paramGen.generateParameters();
        return params.getParameterSpec(DHParameterSpec.class);
	}

	public KeyPair createKeyPair(AlgorithmParameterSpec encryptionMethodParameters) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        keyPairGenerator.initialize(encryptionMethodParameters);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        setKeyAgreement(KeyAgreement.getInstance("DH"));
        getKeyAgreement().init(keyPair.getPrivate());
        return keyPair;
	}

	public PublicKey getUnencodedPublicKey(byte[] publicKeyEncoded) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, IllegalStateException {
		KeyFactory keyFactory = KeyFactory.getInstance("DH");
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyEncoded);
		return keyFactory.generatePublic(x509EncodedKeySpec);
	}

	public KeyAgreement getKeyAgreement() {
		return keyAgreement;
	}

	public void setKeyAgreement(KeyAgreement keyAgreement) {
		this.keyAgreement = keyAgreement;
	}
	
}
