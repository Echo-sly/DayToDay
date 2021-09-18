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

