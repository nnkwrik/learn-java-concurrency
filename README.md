# 并发操作合集

这是一个关于并发的系列。以实战为驱动，了解并发编程中的那些骚操作。文中的示例代码和部分解释来源于网络，你可以把这个系列当做一本工具书，想不起来的时候来看一看，顺便star一发也是可以的。

对于并发，我目前也在摸索的过程中，写这个系列的目的主要是为了巩固知识。如果有不对的地方还望大佬们指正！

> 🍤 [🍤  并发操作合集系列 目录](https://nnkwrik.github.io/2018/11/04/20181104-5/)
>
> 🍕 [🍕  并发操作合集系列 源代码](https://github.com/nnkwrik/learn-java-concurrency)

## 大纲

| 章节                                                         | 源码位置                                                     |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [1.线程的生命周期](https://nnkwrik.github.io/2018/11/01/20181030-2/) | [threadlifecycle](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/threadlifecycle) |
| [2.状态转换方法：wait,notify,sleep,join,yield](https://nnkwrik.github.io/2018/11/01/20181031/) | [threadStateMethod](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/threadStateMethod) |
| [3.Synchronized使用指南](https://nnkwrik.github.io/2018/11/01/20181101/) | [synchronizedKeyword](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/synchronizedKeyword) |
| [4.Lcok和Condition](https://nnkwrik.github.io/2018/11/01/20181101-2/) | [lock](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/lock) |
| [5.原子变量和volatile](https://nnkwrik.github.io/2018/11/02/20181102/) | [atomicVolatile](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/atomicVolatile) |
| [6.并发容器：ConcurrentHashMap](https://nnkwrik.github.io/2018/11/02/20181102-2/) | [concurrentMap](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/concurrentColletions/concurrentMap) |
| [7.并发容器：BlockingQueue](https://nnkwrik.github.io/2018/11/04/20181102-3/) | [blockingQueue](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/concurrentColletions/blockingQueue) |
| [8.并发容器：CopyOnWriteArrayList](https://nnkwrik.github.io/2018/11/04/20181104/) | [copyOnWriteArrayList](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/concurrentColletions/copyOnWriteArrayList) |
| [9.并发工具：Semaphore,CountDownLatch,CyclicBarrier](https://nnkwrik.github.io/2018/11/04/20181104-2/) | [concurrentUtils](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/concurrentUtils) |
| [10.Executor和线程池](https://nnkwrik.github.io/2018/11/04/20181104-3/) | [executor](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/executor) |
| [11.ThreadLocal](https://nnkwrik.github.io/2018/11/04/20181104-4/) | [threadLocal](https://github.com/nnkwrik/learn-java-concurrency/tree/master/src/io/github/nnkwrik/threadLocal) |
| 12.Java8：并发流                                             |                                                              |
| 13.Java8：CompletableFuture                                  |                                                              |

## 番外篇

| 章节                            | 源码位置 |
| ------------------------------- | -------- |
| 并发的N种解法：生产者消费者问题 |          |
| 并发的N种解法：哲♂学家进餐      |          |



> 不定期更新...