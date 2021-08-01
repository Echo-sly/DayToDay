## `什么叫FailFAST机制，有什么影响，怎么解决`

### fail-fast机制是java集合中的一种错误机制。这种机制经常出现在多线程环境下，当前进程会维护一个比较器，即expectedModCpunt，记录已经修改的次数。

### 在进入遍历前，会把实时修改次数modCount赋值给expectedModCount，如果这两个数据不相等则抛出异常ConcurrentModificationException，产生fail-fast事件。

### java.util 中的所有集合类都是fail-fast，而concurrent包中的集合类都是fail_safe