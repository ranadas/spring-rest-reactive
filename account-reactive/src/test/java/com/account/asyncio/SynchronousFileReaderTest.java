package com.account.asyncio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.function.Consumer;

//https://developer.okta.com/blog/2018/09/21/reactive-programming-with-spring
@Slf4j
@RunWith(SpringRunner.class)
public class SynchronousFileReaderTest {

//    @Value("classpath:resources/input4Test.txt")
//    Resource stateFile;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    public void testSyncFileReading() throws IOException  {
        final Resource fileResource = resourceLoader.getResource("classpath:input4Test.txt");
        Consumer<BytesPayload> consumer = (bytes) -> log.info("bytes available! got {} bytes.", bytes.getLength());

        SynchronousFileReader synchronousFileReader = new SynchronousFileReader();

        synchronousFileReader.read(fileResource.getFile(), consumer);
    }

    @Test
    public void testAsyncFileReading() throws IOException  {
        final Resource fileResource = resourceLoader.getResource("classpath:input4Test.txt");
        Consumer<BytesPayload> consumer = (bytes) -> log.info("bytes available! got {} bytes.", bytes.getLength());

        AsynchronousFileReader  asynchronousFileReader = new AsynchronousFileReader();

        asynchronousFileReader.read(fileResource.getFile(), consumer);
    }

}