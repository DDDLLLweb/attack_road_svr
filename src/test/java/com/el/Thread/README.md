
### java并发包

- CountDownLatch  倒数计时器
    
    ```
       概述:
            一种典型的场景就是火箭发射前，为了确保万无一失，往往还要进行各项设备检查。
        只有等所有检查完毕后，引擎才能点火。这种场景就非常适合使用CountDownLock。
        他可以是点火线程，等所有检查线程完毕后，在执行。
    ```
- CyclicBarrier 循环栅栏
   
    ```
      概述: 
            Cyclic意为循环，也就是说这个计数器可以反复使用，比如我们将计数器设置为10，
        那么一批10个线程后，计数器将会归零，然后接着凑齐下一批是个线程   
      主要接口: public CyclicBarrier(int parties,Runnable barrierAction) {}
        barrierAction: 就是一次计数完成后执行的动作
    ```

- LockSupport 锁支持(解决resume发生在suspend问题)
    
    ```
      能够响应中断，但不抛出异常。
      中断响应的结果是 park()函数返回，可以从Thread.interrupted()得到中断标志
    ```
- ReentrantLock 重入锁
    
    ```
        CAS: 状态表示锁是不是被占用
        等待队列: 如果没有拿到锁，进入等待队列。
        park(): 等待队列中的线程执行挂起
    ```
- 典型案例
    ```text
     线程不安全
        HashMap: 使用Collections.synchronizedMap(new HashMap())变为线程安全
          内部实现 是个 entry 数组, entry (key,value,next), 哈希算法计算key的存放位置
          当发生哈希冲突的时候，next指向链表的下一个节点。
          当冲突发生过多时HashMap类似链表结构
        List: synchronizedList
        Set: synchronizedSet
     线程安全
        ConcurrentHashMap(高并发解决方案) 
         
    ```
    
- NIO 
    什么是NIO?
        NIO是New I/O的简称，与旧式的基于流的I/O方法相比。从名字上看，它表示一个新的I/O标准，
        它是在Java 1.4中被纳入到JDK中，并具有一下特性
    - NIO是基于块(Block)的，它以块为基本单位处理数据。
    - 为所有的原始类型提供(Buffer)缓存支持。
    - 增加通道(Channel)对象，作为新的原始I/O抽象。
    - 支持文件锁和内存映射文件的文件访问接口。
    - 提供了基于Selector的异步网络I/O
    
    缓存区和Buffer:
        在基本的IO操作中所有的操作都是直接以流的形式完成的，而在NIO中所有的操作都要使用缓存区处理
        且所有的读写操作都是通过缓存区完成的。缓存区(Buffer)是一个线性的，有序的数据集，只能容纳某种
        特定的数据类型。
    Buffer中有三个重要的参数: 位置(position),容量(capacity)和上限(limit)
      位置(position): 
        写模式: 当前缓存区的位置，将从position的下一个位置写数据。
        读模式: 当前缓存区读取的位置，将从此位置后，读取数据
      容量(capacity): 
        写模式: 缓存区的总容量上限。
        读模式: 缓存区的总容量上限。
      上限(limit):
        写模式: 缓存区的实际上限，它总小于等于容量。通常情况下和容量相等。  
        读模式: 代表可读取的总容量，和上次写入的数据量相等。
      flip(): 该操作会重置position,通常,将buffer 从写模式转换为读模式时需要执行该方法。
        flip()操作不仅重置了当前的position为0，还将limit设置成当前position的位置。
    通道(Channel): 可以用来读取和写入数据，通道类似于基本IO的输入输出流，但是程序不会直接操作通道，
    所有的内容都是先读到或写入缓存区中，再通过缓存区中取得或写入的，通道和传统流操作不同，传统流操作
    分为输入和输出流，而通道本身是双向操作的，既可以完成输入也可以完成输出。     
    
