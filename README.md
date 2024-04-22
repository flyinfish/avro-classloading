# avro-classloading

project reproduces quarkus classloading issue within avro. project was generated using latest `quarkus create app avro-classloading`.

## reproduce
```
git clone https://github.com/flyinfish/avro-classloading.git
cd avro-classloading
quarkus test
```

all there is is a generated avro-class with its child beeing instiantiated by builder.
failure does hit in "pure-mode" [AvroTest.java](src%2Ftest%2Fjava%2Forg%2Facme%2FAvroTest.java) while same class annotated with `@QuarkusTest` works just fine see
[AvroQuarkusTest.java](src%2Ftest%2Fjava%2Forg%2Facme%2FAvroQuarkusTest.java)

## issue
```
2024-04-22 14:50:42,055 ERROR [io.qua.test] (Test runner thread) ==================== TEST REPORT #1 ==================== [Error Occurred After Shutdown]
2024-04-22 14:50:42,055 ERROR [io.qua.test] (Test runner thread) Test AvroTest#test() failed 
 [Error Occurred After Shutdown]: org.apache.avro.AvroRuntimeException: java.lang.ClassCastException: class org.whatever.SomeChild cannot be cast to class org.whatever.SomeChild (org.whatever.SomeChild is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @38ef445; org.whatever.SomeChild is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @574b3da)
        at org.whatever.SomeObject$Builder.build(SomeObject.java:307)
        at org.acme.AvroTest.test(AvroTest.java:10)
Caused by: java.lang.ClassCastException: class org.whatever.SomeChild cannot be cast to class org.whatever.SomeChild (org.whatever.SomeChild is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @38ef445; org.whatever.SomeChild is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @574b3da)
        at org.whatever.SomeObject$Builder.build(SomeObject.java:301)
        ... 1 more
```
