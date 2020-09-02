package com.rulerbug.bugutils.Manager;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

public class BugThreadManager {
    private static ThreadPool threadPool;

    public static ThreadPool getInstance() {
        if (threadPool == null) {
            synchronized (BugThreadManager.class) {
                if (threadPool == null) {
                    int CpuCount = Runtime.getRuntime().availableProcessors();
                    CpuCount *= 5;
                    threadPool = new ThreadPool(CpuCount, CpuCount, 1L);
                }
            }
        }
        return threadPool;
    }

    public static class ThreadPool {

        private int corePoolSize;
        private int maximumPoolSize;
        private long keepAliveTime;

        private ThreadPoolExecutor executor;

        // 构造方法
        private ThreadPool(int corePoolSize, int maximumPoolSize,
                           long keepAliveTime) {

            this.corePoolSize = corePoolSize;
            this.maximumPoolSize = maximumPoolSize;
            this.keepAliveTime = keepAliveTime;
        }

        public void execute(Runnable r) {
            if (executor == null) {
                // 新建线程池
                executor = new ThreadPoolExecutor(corePoolSize,
                        maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        Executors.defaultThreadFactory(), new AbortPolicy());
            }

            executor.execute(r);
        }

        public void execute(Runnable r, long delay) {
            if (executor == null) {
                // 新建线程池
                executor = new ThreadPoolExecutor(corePoolSize,
                        maximumPoolSize, keepAliveTime, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        Executors.defaultThreadFactory(), new AbortPolicy());
            }
            Runnable sleepRunnable = new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    executor.execute(r);
                }
            };
            executor.execute(sleepRunnable);
        }

        public void cancel(Runnable r) {
            if (executor != null) {
                executor.getQueue().remove(r);
            }
        }
    }
}
