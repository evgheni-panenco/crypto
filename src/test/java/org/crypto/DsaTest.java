package org.crypto;

import static org.junit.Assert.assertTrue;

import org.crypto.dss.DSA;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import lombok.SneakyThrows;
import lombok.val;

@RunWith(JUnitParamsRunner.class)
public class DsaTest {

	@Test
	@SneakyThrows
	@Parameters({ "Hello world!", "So important document", "Haha nice :D" })
	public void testDsa(final String message) {
		val keyPair = DSA.buildKeyPair();

		val signedMessage = DSA.sign(keyPair.getPrivate(), message.getBytes());

		val isSignatureValid = DSA.verify(keyPair.getPublic(), message.getBytes(), signedMessage);

		assertTrue(isSignatureValid);
	}
}
