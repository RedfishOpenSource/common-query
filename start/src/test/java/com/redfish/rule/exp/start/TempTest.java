package com.redfish.rule.exp.start;


import com.redfish.rule.exp.common.util.util.juc.ThreadPoolBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

public class TempTest {


    @Test
    public void tempTest(){
        ThreadFactory springThreadFactory = new CustomizableThreadFactory("springThread-pool-");


        ExecutorService threadPoolExecutor = ThreadPoolBuilder.create()
                .corePoolSize(3)
                .maximumPoolSize(5)
                .keepAliveTime(5)
                .unit(TimeUnit.HOURS)
                .workQueue( new SynchronousQueue<Runnable>())
                .threadFactory(springThreadFactory)
                .rejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy())
                .build();


    }

}
