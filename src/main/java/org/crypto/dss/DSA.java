package org.crypto.dss;

import java.security.*;

import lombok.SneakyThrows;
import lombok.val;

public class DSA {

	@SneakyThrows
	public static KeyPair buildKeyPair() {
		val keyGenerator = KeyPairGenerator.getInstance("DSA");
		keyGenerator.initialize(1024);
		return keyGenerator.genKeyPair();
	}

	@SneakyThrows
	public static byte[] sign(PrivateKey privateKey, byte[] message) {
		val signAlgorithm = Signature.getInstance("DSA");

		signAlgorithm.initSign(privateKey);
		signAlgorithm.update(message);

		return signAlgorithm.sign();
	}

	@SneakyThrows
	public static boolean verify(PublicKey publicKey, byte[] message, byte[] signature) {
		val verifyAlgorithm = Signature.getInstance("DSA");

		verifyAlgorithm.initVerify(publicKey);
		verifyAlgorithm.update(message);

		return verifyAlgorithm.verify(signature);
	}
}
