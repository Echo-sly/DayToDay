# Redis入门

## 1.Redis是什么

![image-20210912202842397](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210912202842397.png)

Redis：Remote Dictionary Server（远程字典服务器）

是完全开源免费的，用C语言编写的，遵守BSD协议，是一个高性能的（Key/Value）分布式内存数据库，基于内存运行，并支持持久化的NoSQL数据库，是当前最热门的NoSQL数据库之一，也被人们称为数据结构服务器

Redis与其他key-value缓存产品有以下三个特点

- Redis支持数据的持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用。
- Redis不仅仅支持简单的Key-Value类型的数据，同时还提供了list、set、zset、hash等数据结构的存储。
- Redis支持数据的备份，即master-slave模式的数据备份

### 2.redis能干嘛

- 内存存储和持久化：redis支持异步将内存中的数据写到硬盘上，同时不影响继续服务。
- 取最新N个数据的操作，如：可以将最新的10条评论的ID放在Redis 的List集合里面。
- 发布、订阅消息系统
- 地图信息分析
- 定时器、计数器

.......

### 3.特性

- 数据类型、基本操作和配置文件
- 持久化和复制、RDB、AOF
- 事务的控制

.......

```
# 测试：100个并发连接，100000个请求，检测host为localhost 端口为6379的redis服务器性能
redis-benchmark -h localhost -p 6379 -c 100 -n 100000
......
Summary:

  throughput summary: 93545.37 requests per second
  latency summary (msec):
          avg       min       p50       p95       p99       max
        0.605     0.152     0.535     1.015     1.591     4.231
```



### 4.安装

略

### 5.基本数据库常识

- 默认16个数据库，类似数组下标开始，初始默认使用零号库（redis.conf 里面的默认配置）

- Select命令切换数据库 Eg：select 7

- Dbsize查看当前数据库的Key数量

- Flushdb：清空当前库

- Flushall：清空全部的库

  #### 为什么redis是单线程：

  - 官方表示，因为Redis 是基于内存的操作，CPU不是Redis 的瓶颈，Redis的瓶颈最有可能是机器内存的大小或者网络带宽，既然单线程容易实现，而且CPU不会成为瓶颈，那就顺理成章地采用单线程的方案了。
  - 单线程是指网络请求模块使用了一个线程（所以不需考虑并发安全性），即一个线程处理所有网络请求，其他模块仍用了多个线程。

  #### 为什么说redis能够快速执行：

  > (1) 绝大部分请求是纯粹的内存操作（非常快速）

  > (2) 采用单线程,避免了不必要的上下文切换和竞争条件

  > (3) 非阻塞IO - IO多路复用，Redis采用epoll做为I/O多路复用技术的实现，再加上Redis自身的事件处理模型将epoll中的连接，读写，关闭都转换为了时间，不在I/O上浪费过多的时间。

### 6.八大数据类型：

#### 1.String

- Redis使用自己的简单动态字符串（simple dynamic string,SDS）的抽象类型。Redis中，默认以SDS作为自己的字符串表示。只用在一些字符串不可能出现变化的地方使用C字符串
- SDS的定义如下：

```c
struct sdshdr {    
  // 用于记录buf数组中使用的字节的数目
  // 和SDS存储的字符串的长度相等  
	int len;    
  // 用于记录buf数组中没有使用的字节的数目   
	int free;    
  // 字节数组，用于储存字符串
	char buf[];   //buf的大小等于len+free+1，其中多余的1个字节是用来存储’\0’的。
};
```

- SDS除了用来保存数据库中的字符串之外，SDS还被用作缓冲区（buffer），如AOF模块中的AOF缓冲区，以及客户端状态中的输入缓冲区

- 使用SDS而不是用c语言的String的好处：

- 1. **常数复杂度获取字符串长度**

  - C语言中，字符串只是简单的字符的数组，当使用strlen获取字符串长度的时候，内部其实是直接顺序遍历数据的内容，找到对应的‘\0’对应的字符，从而计算出字符串的长度。即O(n)
  - SDS:只需要访问SDS的len属性就能得到字符串的长度，复杂度为O(1).

  2. **杜绝缓冲区溢出**

  - Redis是C语言编写的，并没有方便的数据类型来进行内存的分配和释放（C++ STL String），必须手动进行内存分配和释放。
  - 对于字符串的拼接、复制等操作，C语言开发者必须确保目标字符串的空间足够大，不然会出现溢出的情况。

  API内部第一步会检测字符串的大小是否满足。

  1.如果空间已经满足要求，那么就行C语言一样操作即可，如果不满足，则拓展buff的空间

  2.之后再进行操作。每次操作之后，len和free的值会做相应的修改。

  ```
  扩展buf空间策略：
  修改之后总长度len<1MB:总空间为2*len+1;
  修改之后总长度len>=1MB:总空间为len+1MB+1
  换句话说，预分配的空间上限是1MB，尽量为len。
  ```

  **3.减少修改字符串时带来的内存重分配次数**

  Redis主要通过一下两种策略来处理内存问题。

  （1）字符串长度增加操作时，进行空间预分配

  （2）字符串长度减少操作时，惰性空间释放

  ​		解释：**当执行字符串长度缩短的操作的时候，SDS并不直接重新分配多出来的字节，而是修改len和free的值（len相应减小，free相应增大，buff的空间大小不变化）**，避免内存重分配。SDS也提供直接释放未使用空间的API，在需要的时候，也能真正的释放掉多余的空间

  **4.二进制安全**

  C字符串除了末尾之外不能出现空字符，否则会被程序认为是字符串的结尾。这就使得C字符串只能存储文本数据，而不能保存图像，音频等二进制数据。

  使用SDS就不需要依赖控制符，而是用len来指定存储数据的大小，所有的SDS API都会以处理二进制的方式来处理SDS的buf的数据。程序不会对buf的数据做任何限制、过滤或假设，数据写入的时候是什么，读取的时候依然不变。

  **5.兼容部分C字符库函数**

  SDS的buf的定义（字符串末尾为‘\0’）和C字符串完全相同，因此很多C的字符串的操作都是适用SDS->buf的。比如当buf里面存的是文本字符串的时候，大多数通过调用C语言的函数就可以。

  ![image-20210912215655607](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210912215655607.png)

#### 2.List

- 版本3.2之前

  Redis 列表list 使用两种数据结构作为底层实现：

  ![img](https://pic1.zhimg.com/80/v2-fc0b50320a00c514683b5c1b60f45e10_720w.jpg)

  - **压缩列表：ziplist**

  - **双向列表：linkedlist**

    双向链表占用的内存比压缩列表要多，所以当创建新的列表键时，列表会优先考虑使用压缩列表，并且在有需要的时候，才从压缩列表实现转换到双向链表实现。

    **压缩列表转化成双向链表条件：**

    创建新列表时 redis 默认使用 redis_encoding_ziplist 编码，当下一任意一个条件被满足时，列表会被转换成 redis_encoding_linkedlist 编码：

    - 试图往列表里添加一个字符串值，且这个字符串长度超过 server.list_max_ziplist_value（默认值时64）
    - ziplist 包含的节点超过 server.list_max_ziplist_entries(默认值为512)

  - **双向列表linkedlist**

    当链表entry数据超过512、或单个value 长度超过64，底层就会转化成linkedlist编码；linkedlist是标准的双向链表，Node节点包含prev和next指针，可以进行双向遍历；还保存了head和tail两个指针，因此，对链表的表头和表尾进行插入的复杂度都为O（1）------这是高效实现Lpush、RPOP、RPOPLPUSH等命令的关键

##### **压缩列表ziplist **

    Redis官方对于Ziplist的定义是（出自ziplist.c的文件头部注释）：
    
    ```
    /* The ziplist is a specially encoded dually linked list that is designed
     * to be very memory efficient. It stores both strings and integer values,
     * where integers are encoded as actual integers instead of a series of
     * characters. It allows push and pop operations on either side of the list
     * in O(1) time. However, because every operation requires a reallocation of
     * the memory used by the ziplist, the actual complexity is related to the
     * amount of memory used by the ziplist.
     *
    ```
    
    ziplist 是由一系列特殊编码的内存块构成的列表（像内存连续的数组、但每个元素长度不同），一个ziplist 可以包含多个节点（entry）。
    
    ziplist 将表中每一项存放在前后连续的地址空间内，每一项因占用的空间不同，而采用变长编码。
    
    当元素个数较少时，Redis 用 ziplist 来存储数据，当元素个数超过某个值时，链表键中会把ziplist 转化为 linkedlist，字典键中会把 ziplist 转化为 hashtable。由于内存时连续分配的，所以遍历时间很快。
    
    ![img](https://hunter-image.oss-cn-beijing.aliyuncs.com/redis/ziplist/Redis%E5%8E%8B%E7%BC%A9%E5%88%97%E8%A1%A8%E7%BB%93%E6%9E%84.png)

  - Redis 压缩列表节点的构成：

  - ![img](https://hunter-image.oss-cn-beijing.aliyuncs.com/redis/ziplist/%E5%8E%8B%E7%BC%A9%E5%88%97%E8%A1%A8%E8%8A%82%E7%82%B9.png)

    

    节点的 previous_entry_length属性以字节为单位,记录了压缩列表中前一个节点的长度。 previous_entry_length属性的长度可以是1字节或者5字节。

    - 如果前一节点的长度小于254字节,那么 previous_entry_length属性的长度为1字节，前一节点的长度就保存在这一个字节里面。
    - 如果前一节点的长度大于等于254字节,那么 previous_entry_length属性的长度为5字节:其中属性的第一字节会被设置为0xFE(十进制值254),而之后的四个字节则用于保存前一节点的长度.

      节点的encoding属性记录了节点的content属性所保存数据的类型以及长度。

    - 一字节、两字节或者五字节长,值的最高位为00、01或者10的是字节数组编码这种编码表示节点的 content属性保存着字节数组,数组的长度由编码除去最高两位之后的其他位记录。
    - 一字节长,值的最高位以11开头的是整数编码:这种编码表示节点的content属性保存着整数值,整数值的类型和长度由编码除去最高两位之后的其他位记录。

      节点的content属性负责保存节点的值,节点值可以是一个字节数组或者整数,值的类型和长度由节点的encoding属性决定。

##### **QuickList（快表）**

- quicklist 实际上是 ziplist 和 linkedlist 的混合体，它将linkedlist 按段切分，每一段使用ziplist来紧凑存储，多个ziplist 之间使用双向指针串接起来。

- ![img](https://hunter-image.oss-cn-beijing.aliyuncs.com/redis/quicklist/QuickList.png)

```c
typedef struct quicklistNode {
    struct quicklistNode *prev; //上一个node节点
    struct quicklistNode *next; //下一个node
    unsigned char *zl;            //保存的数据 压缩前ziplist 压缩后压缩的数据
    unsigned int sz;             /* ziplist size in bytes */
    unsigned int count : 16;     /* count of items in ziplist */
    unsigned int encoding : 2;   /* RAW==1 or LZF==2 */
    unsigned int container : 2;  /* NONE==1 or ZIPLIST==2 */
    unsigned int recompress : 1; /* was this node previous compressed? */
    unsigned int attempted_compress : 1; /* node can't compress; too small */
    unsigned int extra : 10; /* more bits to steal for future usage */
} quicklistNode;
```

- prev: 指向链表前一个节点的指针。
- next: 指向链表后一个节点的指针。
- zl: 数据指针。如果当前节点的数据没有压缩，那么它指向一个ziplist结构；否则，它指向一个quicklistLZF结构。
- sz: 表示zl指向的ziplist的总大小（包括`zlbytes`, `zltail`, `zllen`, `zlend`和各个数据项）。需要注意的是：如果ziplist被压缩了，那么这个sz的值仍然是压缩前的ziplist大小。
- count: 表示ziplist里面包含的数据项个数。这个字段只有16bit。稍后我们会一起计算一下这16bit是否够用。
- encoding: 表示ziplist是否压缩了（以及用了哪个压缩算法）。目前只有两种取值：2表示被压缩了（而且用的是LZF压缩算法），1表示没有压缩。
- container: 是一个预留字段。本来设计是用来表明一个quicklist节点下面是直接存数据，还是使用ziplist存数据，或者用其它的结构来存数据（用作一个数据容器，所以叫container）。但是，在目前的实现中，这个值是一个固定的值2，表示使用ziplist作为数据容器。
- recompress: 当我们使用类似lindex这样的命令查看了某一项本来压缩的数据时，需要把数据暂时解压，这时就设置recompress=1做一个标记，等有机会再把数据重新压缩。
- attempted_compress: 这个值只对Redis的自动化测试程序有用。我们不用管它。
- extra: 其它扩展字段。目前Redis的实现里也没用上。

#### 3.Hash

- Redis 当中的hash类似于java当中的HashMap，但也存在着很多的区别。在Redis当中，hash有两种底层实现方式。
  - 当数据量较小的时候，采用zipList作业hash的底层实现。
  - 另一种方式就是使用字典（**dict**）的方式来实现的。

##### 字典（disc）

- dict的结构

```c
typedf struct dict{
    dictType *type;//和特定类型键值对相关的函数；
    void *privdata;//上述特定函数的可选参数；
    dictht ht[2];//两张hash表 
    int rehashidx;//rehash索引，字典没有进行rehash时，此值为-1
    unsigned long iterators; //正在迭代的迭代器数量
}dict;

```

- type 是一个指向 dict.h/dictType 结构的指针，保存了一系列用于操作特定类型键值对的函数；
- privdata 保存了需要传给上述特定函数的可选参数；
- ht[2] 两个hash表，使用两个hash表的作用之后会说明。
- rehashidx 用于标记rehash的进度，若当前这个值为-1，则表示字典没有在执行rehash操作。
- Iterators 记录正在迭代的迭代器的数量。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201208211414684.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2dvbmdzZW5saW4zNDE=,size_16,color_FFFFFF,t_70)

- 哈希表ditcht的结构：

```c
typedf struct dictht{
    dictEntry **table;//存储数据的数组 二维
    unsigned long size;//数组的大小
    unsigned long sizemask;//哈希表的大小的掩码，用于计算索引值，总是等于size-1
    unsigned long used; 哈希表中中元素个数
}dictht;

```

- table 是一个二维数组，第一维度数组表示hash表的槽位，第二个维度是每一个槽对应的链表。因为是采用拉链法来解决冲突的，所以存在相同槽位的数据，会以链表的形式连接在一起。
- size 表示数组的大小，也就是槽位的数量。
- sizemask 哈希表的大小的掩码，用于计算索引值。
- used 记录hash表中实际存放元素的个数。

- 真正的存储结构dictEntry

```c
typedf struct dictEntry{
    void *key;//键
    union{
        void val;
        unit64_t u64;
        int64_t s64;
        double d;
    }v;//值
    struct dictEntry *next；//指向下一个节点的指针
}dictEntry;

```

key表示键，v表示值

next是指向下一个结点的指针，因为这里的hash表是通过拉链法来解决冲突的。

**SipHash**

##### 渐进式reHash：

dict中ht[]中有两个hash表，我们第一次存储数据的时候时，ht[0]会创建一个最小为4的hash表，一旦ht[0]中的size和used相等，则在dict中会在ht[1]船舰一个size*2大小的hash表，此时不会直接将ht[0]中的数据cp进ht[0]中，执行的是渐进性的rehash，即在以后的操作（find，set，get等）中慢慢的copy进去，以后新添加的元素回添加进ht[0],因此在ht[1]被占满的时候定能确保ht[0]中的所有的数据全部copy到ht[1]中

##### **hash洪水：**

我们知道，在常用的数据结构里，有些数据结构的“平均运行时间”和“最差运行时间”差得很多，比如哈希表。hash的最差运行时间是O（n2）的，所以我们在知道hash算法的时候，能构造大量的具有一样hash值的算法进行攻击。

解决方法：带密钥的hash函数 动态的hash函数

#### 4.Set

Redis 的set集合类似于 Java 语言里面的 HashSet，它内部的键值对是无序的唯一的。它的内部实现相当于一个特殊的字典，字典中所有的 value 都是一个值NULL。

当集合中最后一个元素移除之后，数据结构自动删除，内存被回收。

set结构是字典的衍生结构，而且它具有去重的功能，能够保证每个key只出现一次。

整数数组（INTSET）和哈希表两种实现方式

![img](https://pics5.baidu.com/feed/c8ea15ce36d3d5399a3cbc37336c7657342ab037.png?token=5654c1380a6893deece3c3fa47400d07)

#### 5.sorted set

![Redis跳跃表](https://hunter-image.oss-cn-beijing.aliyuncs.com/redis/skiplist/Redis%E8%B7%B3%E8%B7%83%E8%A1%A8.png)



排名问题：Redis在skiplist的forward指针上进行了优化，给每一个forward指针都增加了span属性，span是跨度的意思，表示从前一个结点沿当前层的forward指针跳到当前这个节点中间会跳过多少个节点。这样当我们要计算一个元素的排名时，只需要将搜索路径上的经过的所有节点的跨度span值进行叠加就可以算出元素的最总rank值

#### 6.hyperloglog

- Hyperloglog提供不精确的去重计数方案，标准误差是0.81％。、
- 

#### 7. bitmap

- bitmap就是通过最小的单位bit来进行0或者1的设置，表示某个元素对应的值或者状态。
- 一个bit的值，或者是0，或者是1；也就是说一个bit能存储的最多信息是2。

bitmap的优势、限制

- 优势
  1.基于最小的单位bit进行存储，所以非常省空间。
  2.设置时候时间复杂度O(1)、读取时候时间复杂度O(n)，操作是非常快的。
  3.二进制数据的存储，进行相关计算的时候非常快。
  4.方便扩容

- 限制
  redis中bit映射被限制在512MB之内，所以最大是2^32位。建议每个key的位数都控制下，因为读取时候时间复杂度O(n)，越大的串读的时间花销越多。

### 7.Redis管道(pipeline)

- redis是一种基于客户端-服务端模型以及请求/响应协议的TCP服务。
- redis客户端执行一条命令分4个过程。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210111233328537.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxOTkzMjA2,size_16,color_FFFFFF,t_70)

- Redis管道介绍：
- Redis 管道技术可以在服务器未响应时，客户端可以继续向服务器发送请求，并最终一次性读取所有服务器的响应。
- 简单来说就是管道中的命令是没有关系的，他们只是像管道一样流水发给服务器，而不是串行执行。
- PIPELINING 是一种几十年来广泛使用的技术，例如许多pop3协议已经实现支持这个功能，大大加快了服务器下载新邮件的过程。
- 在一个管道中执行的N个命令，是不具有原子性的，不会像MYSQL事务一样要么同时成功，要么同时失败。

### 8.Redis事务

- 单个 Redis 命令的执行是原子性的，但 Redis 没有在事务上增加任何维持原子性的机制，所以 Redis 事务的执行并不是原子性的。

- 事务可以理解为一个打包的批量执行脚本，但批量指令并非原子化的操作，中间某条指令的失败不会导致前面已做指令的回滚，也不会造成后续的指令不做。

### 9.Redis发布订阅（类似于MQ）

- Redis发布订阅（pub/sub）是一种消息通信模式：发送者（pub）发送消息，订阅者（sub）接收消息。
- Redis客户端可以订阅任意数量的频道。
- ![img](https://www.runoob.com/wp-content/uploads/2014/11/pubsub1.png)

![img](https://www.runoob.com/wp-content/uploads/2014/11/pubsub2.png)

### 10.Redis集群数据复制原理：

- Redis提供了复制功能，可以实现在主数据库(Master)中的数据更新后，自动将更新的数据同步到从数据库(Slave)。一个数据库可以拥有多个从数据库，而一个从数据库只能拥有一个主数据库。

- 

![image-20210923002043589](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210923002043589.png)

### 11.Redis集群

- Redis有三种集群模式：主从模式、哨兵模式(Sentinel)、集群模式(Cluster)

  ### 主从模式

  - 主从模式市三种模式中最简单的，在主从复制中，数据库分为两类：主数据库（master）和从数据库(slave).

  - 主数据库可以进行读写操作，当读写操作导致数据变化时会自动将数据同步给从数据库。

  - 从数据库一般都是只读的,并且接受主数据库同步过来的数据。

  - 一个master可以拥有多少slave，但是一个slave只能对应一个master。

  - slave挂了不影响其他的slave的读和master的读和写，重新启动后会将数据从master同步过来。

  - master挂了以后，不影响slave的读，但redis 不再提供写服务，master重启后redis将重新对外提供写服务。

  - master挂了以后，不会在slave节点中重新选一个master

  - **缺点：**

    **从上面可以看出，master节点在主从模式中唯一，若master挂掉，则redis无法对外提供写服务。**

  ### 哨兵模式(Sentinel）

- 主从模式的弊端就是不具备高可用性，当master挂掉以后，Redis将不能再对外提供写入操作，因此sentinel应运而生。

- sentinel中文含义为哨兵，顾名思义，它的作用就是监控redis集群的运行状况

- sentinel模式是建立在主从模式的基础上的，如果只有一个Redis 节点，sentinel没有任何意义。

- 当master挂了以后，sentinel会在slave中选择一个做为master，并修改他们的配置文件，其他slave的配置文件也会被修改，比如slaveof属性会指向新的master。

- 当master重新启动之后，它将不在是master而是作为slave接受新的master的同步数据

- sentinel也是一个进程有挂掉的可能，所以sentinel也会启动多个形成一个sentinel集群。

- 多sentinel配置的时候，sentinel之间也会自动监控。

- 一个sentinel或sentinel集群可以管理多个主从Redis，多个sentinel也可以监控同一个redis

- sentinel最好不要和Redis部署在同一台机器，不然Redis的服务器挂了以后，sentinel也挂了

  ### 集群模式（Cluster）

  - sentinel模式基本可以满足一般的生产需求，具有高可用性。但是当数据量过大到一台服务器存放不下的情况时，主从模式或sentinel模式就不能满足需求了，这个时候需要对存储的数据进行分片，将数据存储到多个Redis实例中。Cluster模式的出现就是为了解决单机Redis容量有限的问题，将Redis的数据根据一定的规则分配到多台机器。
  - cluster可以说是sentinel和主从模式的结合体，通过cluster可以实现主从和master重选功能，所以如果配置两个副本三个分片的话，就需要六个Redis实例。因为Redis的数据是根据一定规则分配到cluster的不同机器的，当数据量过大时，可以新增机器进行扩容。
  - 特点：
  - 多个redis节点网络互联，数据共享
  - 所有的节点都是一主一从（也可以时一主多从），其中从不提供服务，仅作为备用。
  - 不支持同时处理多个key(如meset/mget)，因为redis需要把key均匀分布在各个节点上，并发量很高的情况下同时创建key-value会降低性能并导致不可预测的行为。
  - 支持在线增加、删除节点。
  - 客户端可以连接任何一个主节点进行读写

