package com.account.asyncio;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;

public interface Reader {
    void read(File file, Consumer<BytesPayload> consumer) throws IOException;
}
