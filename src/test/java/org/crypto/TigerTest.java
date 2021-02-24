package org.crypto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.codec.binary.Hex;
import org.crypto.tiger.TigerHash;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class TigerTest {

	private final TigerHash tiger = new TigerHash();

	@Test
	@Parameters({ // http://www.unit-conversion.info/texttools/tiger/
          "d         | dc0d78b5168ee22a2649bcc08fced0451c40d838362da0e4",
			    "qwe       | 8274c43762cfc35f0f93da9069b10647a3a8778f49aa0483",
			    "qwerty    | 00722492524aaac42f4119227927f12f51847b37d400e819",
			    "hello     | 2cfd7f6f336288a7f2741b9bf874388a54026639cadb7bf2",
			    "tigerhash | d0c68fa66bf126fd0fa5c468a9f0908e38818293524fb648" })
	public void testTiger(final String text, final String hashedHex) {
		assertEquals(Hex.encodeHexString(tiger.hash(text.getBytes())), hashedHex);
	}
}
