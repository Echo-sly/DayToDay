###`可重入锁如何避免死锁`
- 1.响应中断：在 `synchronized` 中如果有一个线程尝试获取一把锁，其结果是要么获取
  锁继续执行，要么保持等待。而`ReentrantLock` 还
  提供了可响应中断的可能，即在等待锁的过程中，线程可以根据需要取消对锁的请求
- 2.可轮询锁：通过`boolean tryLock()`获取锁，如果有可用锁，则获取该锁并返回 `true` 。若无可用锁，则立即返回`false`。
- 3.定时锁：通过`boolean try(long time,TimeUtil unit)`获取定时锁。如果在给定的时间内获得了可用锁，且当前线程未被中断，则获取该锁并返回`true`
.如果在给定的时间内获取不到可用锁，将禁用当前线程。