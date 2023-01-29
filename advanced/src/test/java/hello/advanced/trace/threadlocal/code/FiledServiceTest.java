package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FiledServiceTest {

    private final FiledService filedService = new FiledService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = () -> {
            filedService.logic("userA");
        };
        Runnable userB = () -> {
            filedService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadA.setName("thread-B");

        threadA.start();
//        sleep(2000); // 동시성 문제 발생 x
        sleep(100); // 동시성 발생
        threadB.start();

        sleep(3000); // 메인 스레드 종료 대기
        log.info("main exit");


    }
    public void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
