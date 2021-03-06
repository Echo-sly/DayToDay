## 1.Mysql几种数据引擎的特点

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190524175654936.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM3ODc1NTg1,size_16,color_FFFFFF,t_70)

①**MyISAM存储引擎**
MyISAM基于ISAM存储引擎，并对其进行扩展。它是在Web、数据仓储和其他应用环境下最常使用的存储引擎之一。MyISAM拥有较高的插入、查询速度，但不支持事物。

②**InnoDB存储引擎**
InnoDB是事务型数据库的首选引擎，支持事务安全表（ACID），支持行锁定和外键，上图也看到了，InnoDB是默认的MySQL引擎。

③**MEMORY存储引擎**
MEMORY存储引擎将表中的数据存储到内存中，未查询和引用其他表数据提供快速访问。

## 2.创建索引的几种原则

1、 对于查询频率高的字段创建索引；

2、 对排序、分组、联合查询频率高的字段创建索引；

3、 索引的数目不宜太多

4、若在实际中，需要将多个列设置索引时，可以采用多列索引

5、选择唯一性索引

6、尽量使用数据量少的索引

7、尽量使用前缀来索引

8、删除不再使用或者很少使用的索引

## 3.存储过程优化

1，尽量利用一些sql语句来替代一些小循环，例如聚合函数，求平均函数等。

2，不再按照算法描述，以致将一条长达100多个字段的纪录分90次来更新，而是采用拼凑语句，将更新语句在循环中拼凑后，再统一更新。

3，使用确定的schema, 在使用表，函数，存储过程等等时，最好加上确定的schema，这样可以使sqlserver直接找到对应目标，避免去计划缓存中搜索，而且搜索会导致编译锁定，最终影响性能。如select ＊ from dbo.a比select * from a要好。

4，自定义存储过程不要以_sp开头。因为以_sp开头的存储过程默认为系统存储过程，所以首先会去master库中去找，然后再在当前数据库中找。

5，使用sp_executesql替代exec. sp_executesql可以使用参数化，从而可以重用执行计划。而exec就是纯拼sql语句。

6，中间结果存放于临时表，加索引。

7，少使用游标。sql是个集合语言，对于集合运算具有较高性能。而cursors是过程运算。比如对一个100万行的数据进行查询。游标需要读表100万次，而不使用

游标则只需要少量几次读取。

8，事务越短越好。sqlserver支持并发操作。如果事务过多过长，或者隔离级别过高，都会造成并发操作的阻塞，死锁。导致查询极慢，cpu占用率极地。

9，使用try-catch处理错误异常。

10，查找语句尽量不要放在循环内。

## 4.数据库三大范式

- 第一范式（1NF）

  1.每一列属性都是不可再分的属性值，确保每一列的原子性

  2.两列的属性相近或相似或一样，尽量合并属性一样的列，确保不产生冗余数据

- 第二范式（2NF）

  第二范式（2NF）是在第一范式（1NF）的基础上建立起来的，即满足第二范式（2NF）必须先满足第一范式（1NF）。第二范式（2NF）要求数据库表中的每个实例或行必须可以被惟一地区分。为实现区分通常需要为表加上一个列，以存储各个实例的惟一标识。这个惟一属性列被称为主键

- 第三范式(3NF)

  数据不能存在传递关系，即每个属性都跟主键有直接关系而不是间接关系。像：a-->b-->c  属性之间含有这样的关系，是不符合第三范式的。

## 5.数据库锁

- 乐观锁：乐观锁在读数据时，认为别人不会去写所读的数据；悲观锁刚好相反，觉得自己在读数据时，别人可能刚好在写自己刚读的数据时，态度比较保守。时间戳在操作数据时不加锁，而是通过时间戳来控制并发出现的问题。

- 悲观锁：指在其修改某条数据时，不允许别人读取该数据，直到自己的整个事务都提交并释放锁，其他用户才能访问该数据，悲观锁又分为排他锁（写）和共享锁（读）。

- 时间戳：时间戳指在数据库表中额外加一个时间戳列TimeStamp。每次读取数据时，都把时间戳也读出来，在更新数据时把时间戳加一，在提交之前跟数据库的该资源比较一次，如果比数据库的值大，就运行保存，否则不允许保存。

## 6.数据库锁

- 行级锁：行级锁指对某行数据加锁，是一种排他锁，防止其他事务修改此行。在执行一下数据库操作时，数据库会自动应用行级锁。使用COMMIT或ROLLBACK语句释放锁。
- 表级锁：指对当前操作的整张锁加锁，它的实现简单，资源消耗少，被大部分存储引擎支持。最常使用的MyIASM与InnoDB都支持表级锁定。表级锁定分为表共享读锁（共享锁）与表独占写锁（排他锁）。
- 页级锁：页级锁的锁定粒度介于行级锁和表级锁之间。表级锁的加锁速度快，但冲突多，行级冲突少，但加锁速度慢。页级锁在二者之间做了平衡，一次锁定相邻的一组记录。

## 7.两阶段提交和三阶段提交

- 两阶段提交协议(2PC)可以保证数据的强一致性，许多分布式关系型数据管理系统采用此协议来完成分布式事务。他是协调所有分布式原子事务的参与者，并决定提交或取消（回滚）的分布式算法。同时也是解决一致性问题的一致性算法。
- 在两阶段提交协议中，系统一般包含两类机器（节点）：一类为协调者，通常一个系统中只有一个。
