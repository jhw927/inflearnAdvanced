package hello.advanced.trace.helloTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloTraceV1Test {

    @Test
    void begin_end(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.end(status);

    }
    @Test
    void begin_exception(){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus status = traceV1.begin("hello");
        traceV1.exception(status, new IllegalAccessException());
    }

}