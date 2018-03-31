## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  | 10000000           |   0.016787      |
| Using ReentrantLock     | 10000000           |   0.928373      |
| Syncronized method      | 10000000           |   0.895436      |
| AtomicLong for total    | 10000000           |   0.488693      |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)

1.1) No, it isn't. The total aren't always the same.

1.2) The average runtime is 0.016787.

1.3) The counter total is sometimes not zero because the threads dont't finish at the same time.
	 It isn't the same each time because the threads dont't finish at the same time. If AddTask finish first the total will be positive, and if SubtractTask finish first the total will be negative.
## 2. Implications for Multi-threaded Applications

How might this affect real applications?  
	A banking application can withdraw, deposit with same amount at the same time. Example account have 100 Baht when A and B withdraw 100 Baht and the same time A and B can withdraw 100 Baht.
	
## 3. Counter with ReentrantLock

answer questions 3.1 - 3.4

3.1) Yes, it always zero. The average runtime is 0.928373.

3.2) The results are different from problem 1 because we use thread safe.

3.3) ReetrantLock is lock one thread to working, when it works finish thread will unlock for another thread to wait longest time.
	 It will do only one thread until all thread finished. 
	 
3.4) We write "finally { lock.ubnlock(); }" in the code because if you can add then unlock thread. If you don't write this another that after 
	 thread that error the program will be error.

## 4. Counter with synchronized method

answer question 4

4.1) Yes, it is zero. The average runtime is 0.971276.

4.2) The results are different from problem 1 because we use thread safe.

4.3) Sysnchronized meaning it can execute code only one thread at the time. we use this solution when not much data.

## 5. Counter with AtomicLong

answer question 5
5.1) Because value may be update atomically.

5.2) Because a long value that may be updated atomically. An AtomicLong is used in application s such as atomically incremented sequence 
	 numbers, and cannot be used as a replacement for a Long.

## 6. Analysis of Results

answer question 6

6.1) The fastest is AtomicLong. The slowest is Using ReentrantLock.

6.2) I think we should use ReetrantLock because it’s safer than other ways. This solution works same Syncronized method, but ReetrantLock will give thread that wait longest works first when previous thread finished which it’s fair unlike Syncronized method that will scramble work. For example we have 3 lists, and A = [1, 2, 3], B = [1, 2, 3, 4], C = [1, 2]. The program will select first list and lock when it finishes, so it will unlock current list and let other lists works sort by wait longest. 

## 7. Using Many Threads (optional)
