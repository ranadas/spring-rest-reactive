package com.account.asyncio;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BytesPayload {
    private final byte[] bytes;
    private final int length;

    public static BytesPayload from(byte[] bytes, int len) {
        return new BytesPayload(bytes, len);
    }
}
