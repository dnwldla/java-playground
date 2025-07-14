package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Future의 문제점과 CompleteableFuture의 필요성을 알아본다
 */
public class FutureBlockingMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 1. Callable 작업 제출 (3초 걸림)
        Future<String> future = executor.submit(() -> {
            System.out.println("작업 시작");
            Thread.sleep(30000); // 시간이 오래 걸리는 작업
            return "작업 완료";
        });

        // 2. 메인 스레드는 결과를 기다림
        System.out.println("main: 결과 기다리는 중...");
        String result = future.get(); //get 호출까지 기다려야 함
        System.out.println("main: 결과 = " + result);

        executor.shutdown();
    }
}
