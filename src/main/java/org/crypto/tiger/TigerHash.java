package org.crypto.tiger;

import gnu.crypto.hash.Tiger;

public class TigerHash {

	private final Tiger tiger = new Tiger();

	public byte[] hash(final byte[] text) {
		tiger.reset();
		tiger.update(text, 0, text.length);
		return tiger.digest();
	}
}
