package reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 弱引用,gc时,会进行回收对象(注意,)
 * 可以结合队列使用，当被回收后，就进去于之关联的队列中。
 * -Xmx25m -Xms25m -XX:-UseCompressedOops
 * @author dongfeng
 * 2024-02-23 15:03
 */
public class _02_WeakReference {
    public static void main(String[] args) throws InterruptedException {
        // 1.创建引用
        // 强引用
        byte[] strongRef = new byte[1024 * 1024 * 15]; // 15MB
        // 弱引用(可以传入弱引用队列)
        WeakReference<byte[]> weakReference = new WeakReference<>(strongRef);
        // 获取弱引用的对象
        System.out.println("Before Clear StrongReference:" + weakReference.get());



        // 2.清理强引用,这时只留下弱引用
        // 这里因为弱引用是gc时一定回收,不管内存是否充足,如果不清理强引用,最后
        strongRef = null;
        System.out.println("Before GC:" + weakReference.get());

        // 这里不分配较大的对象，模拟内存充足
        // 强制回收(只是通知垃圾回收,并不一定马上执行)
        System.gc();

        System.out.println("After GC:" + weakReference.get());
        // Before GC:[B@776ec8df
        // After GC:null
    }

}
