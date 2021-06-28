/**
 * EXPath Cryptographic Module
 * Java Library providing an EXPath Cryptographic Module
 * Copyright (C) 2015 Kuberam
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package ro.kuberam.libs.java.crypto.digest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import org.junit.Test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;

public class HmacStringWithSha384Test {

    @Test
    public void hmacStringWithSha384() throws Exception {
        final String input = "Short string for tests.";
        try (final InputStream secretKeyIs = getClass().getResourceAsStream("../rsa-private-key.key")) {

            final String result = Hmac.hmac(input.getBytes(UTF_8), IOUtils.toByteArray(secretKeyIs),
                    "HMAC-SHA-384", "base64");

            assertEquals("I89ANhNIxCc44IsbpfT+v9bClNTat7zlG3NWNy95M4X+1KYF6Njadcpzyocqsbik", result);
        }
    }

    @Test
    public void hmacStringWithSha384_inputStream() throws Exception {
        final String input = "Short string for tests.";
        try (final InputStream is = new ByteArrayInputStream(input.getBytes(UTF_8));
             final InputStream secretKeyIs = getClass().getResourceAsStream("../rsa-private-key.key")) {

            final String result = Hmac.hmac(is, IOUtils.toByteArray(secretKeyIs),
                    "HMAC-SHA-384", "base64");

            assertEquals("I89ANhNIxCc44IsbpfT+v9bClNTat7zlG3NWNy95M4X+1KYF6Njadcpzyocqsbik", result);
        }
    }
}
