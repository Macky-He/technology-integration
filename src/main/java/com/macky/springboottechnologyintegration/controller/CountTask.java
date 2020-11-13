package com.macky.springboottechnologyintegration.controller;

import java.util.concurrent.*;

/**
 * @Title class CountTash
 * @Description: TODO
 * @Author Macky
 * @Date 2020/11/13
 */
public class CountTask extends RecursiveTask<Integer> {

    /**
     * 阈值
     */
    private static final int THRESHOLD = 2;
    private int start;
    private int end;
    public CountTask(int start , int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;

        final boolean canComplate = (end - start) <= THRESHOLD;
        if (canComplate){
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        }else{
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle +1,end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 获取执行结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            // 合并执行结果
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,4);

        Future<Integer> result = forkJoinPool.submit(countTask);
        System.out.println(result.get());
    }
}
