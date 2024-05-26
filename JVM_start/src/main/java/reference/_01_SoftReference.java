package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.sql.Ref;

/**
 * 软引用,gc&&内存不足时,会进行回收对象
 * 设置较小的jvm堆和较大的对象,来模拟内存不足
 * -Xmx25m -Xms25m -XX:-UseCompressedOops -XX:+PrintGCDetails
 * @author dongfeng
 * 2024-02-23 12:29
 */
public class _01_SoftReference {
    public static void main(String[] args) {
        // 强引用
        byte[] strongRef = new byte[1024 * 1024 * 15]; // 15MB
        // 软引用
        SoftReference<byte[]> softReference = new SoftReference<>(strongRef);
        // 获取软引用的对象
        System.out.println("Before Clear StrongReference:" + softReference.get());


        // 清理强引用,这时只留下软引用
        // 如果注释下面,也就是不清理强引用,那么运行一定会报错 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        // 侧面看出强引用并不会被垃圾回收
        strongRef = null;
        System.out.println("Before Out of memory:" + softReference.get());
        // 尝试分配一个较大的对象，导致内存不足
        byte[] largeObject = new byte[1024 * 1024 * 15]; // 15MB

        System.out.println("After Out of memory:" + softReference.get());

        // 注意:这里只是模拟,实际中jvm会自动触发gc(在内存不足时已经被gc了),我们不需要手动触发)
        System.gc();


        System.out.println("After GC:" + softReference.get());

        // Before GC:[B@776ec8df
        // After GC:null
    }
}
