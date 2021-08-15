##`tryLock lock和lockInterruptibly区别`
- tryLock：若有可用锁，则获取该锁并返回`true`，否则返
回false，不会有延迟或等待；`tryLock`还可以增加时间限制，如果超过了指定的时间还没获得锁，则返回false。
- lock：若有可用锁，则获取该锁并返回true，否则会一直
等待直到获取可用锁。
- lockInterruptibly：在锁中断是会抛出异常，`lock`不会。