## jconsole--图像化界面
```shell
jconsole
```
## jps--查看java进程的pid
```shell
jps
```
```text
2212
24084 Test
17912 RemoteMavenServer36
18552 Jps
24296
20508 Launcher
```
## jstat--查看gc内存占用情况
jstat -gcutil pid 间隔时间
```shell
jstat -gcutil 24084 1000
```
```text
 S0     S1     E      O      M     CCS    YGC     YGCT     FGC    FGCT     CGC    CGCT       GCT
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
  0.00   0.00  60.00   0.00      -      -      0     0.000     0     0.000     0     0.000     0.000
```
## jstack
## jmap
```shell
jhsdb jmap --heap --pid 24084
```
```text
Attaching to process ID 24084, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 17.0.8+9-LTS-jvmci-23.0-b14

using thread-local object allocation.
Garbage-First (G1) GC with 13 thread(s)

Heap Configuration:
   MinHeapFreeRatio         = 40
   MaxHeapFreeRatio         = 70
   MaxHeapSize              = 10485760 (10.0MB)
   NewSize                  = 1363144 (1.2999954223632812MB)
   MaxNewSize               = 6291456 (6.0MB)
   OldSize                  = 5452592 (5.1999969482421875MB)
   NewRatio                 = 2
   SurvivorRatio            = 8
   MetaspaceSize            = 22020096 (21.0MB)
   CompressedClassSpaceSize = 1073741824 (1024.0MB)
   MaxMetaspaceSize         = 17592186044415 MB
   G1HeapRegionSize         = 1048576 (1.0MB)

Heap Usage:
G1 Heap:
   regions  = 10
   capacity = 10485760 (10.0MB)
   used     = 3145728 (3.0MB)
   free     = 7340032 (7.0MB)
   30.0% used
G1 Young Generation:
Eden Space:
   regions  = 3
   capacity = 5242880 (5.0MB)
   used     = 3145728 (3.0MB)
   free     = 2097152 (2.0MB)
   60.0% used
Survivor Space:
   regions  = 0
   capacity = 0 (0.0MB)
   used     = 0 (0.0MB)
   free     = 0 (0.0MB)
   0.0% used
G1 Old Generation:
   regions  = 0
   capacity = 5242880 (5.0MB)
   used     = 0 (0.0MB)
   free     = 5242880 (5.0MB)
   0.0% used
```