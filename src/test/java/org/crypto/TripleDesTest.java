package org.crypto;

import lombok.val;
import org.crypto.des.TripleDes;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleDesTest {

    private final TripleDes tripleDes = new TripleDes("AABB09182736CCDD", "82CCAABB073619DD", "B093AAB6CCD1827D");

    @Test
    public void testEncryptDecrypt() {
        val word = "1F3456ABCD1325D6";
        val encryptionResult = tripleDes.encrypt(word);
        val decryptionResult = tripleDes.decrypt(encryptionResult);
        assertEquals(word, decryptionResult.toUpperCase());
    }
}
