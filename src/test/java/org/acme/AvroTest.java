package org.acme;

import org.junit.jupiter.api.Test;
import org.whatever.SomeObject;

public class AvroTest {
    @Test
    public void test() {
        // failes like org.apache.avro.AvroRuntimeException: java.lang.ClassCastException: class org.whatever.SomeChild cannot be cast to class org.whatever.SomeChild (org.whatever.SomeChild is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @73bd779a; org.whatever.SomeChild is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @1f838397)
        SomeObject.newBuilder().build();
    }
}
