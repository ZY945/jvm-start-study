package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.sql.Ref;

/**
 *
 * -Xmx25m -Xms25m -XX:-UseCompressedOops
 * @author dongfeng
 * 2024-02-23 15:35
 */
public class _02_WeakReference_Queue {
    public static void main(String[] args) throws InterruptedException {
        String str = "hello";
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();

        WeakReference<String> weakReference = new WeakReference<>(str, referenceQueue);
        System.out.println("现在的引用 " + weakReference.get());
        System.out.println("现在的引用队列 " + referenceQueue.poll());

        str = null; //去掉强引用,就剩弱引用了
        System.gc();
        System.out.println("GC之后--------------- ");
        System.out.println("现在的引用 " + weakReference.get());
        System.out.println("现在的引用队列 " + referenceQueue.poll()); //poll()方法是有延迟的
    }
}
