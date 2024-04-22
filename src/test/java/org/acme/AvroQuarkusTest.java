package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.whatever.SomeObject;

@QuarkusTest
public class AvroQuarkusTest {
    @Test
    public void test() {
        // works just fine
        SomeObject.newBuilder().build();
    }
}
