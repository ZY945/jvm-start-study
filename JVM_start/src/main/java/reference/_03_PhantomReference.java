package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * -Xmx25m -Xms25m -XX:-UseCompressedOops
 *
 * @author dongfeng
 * 2024-02-23 15:28
 */
public class _03_PhantomReference {

    public static void main(String[] args) {
        ReferenceQueue<MyObject> referenceQueue = new ReferenceQueue<>();
        MyObject myObject = new MyObject("Example Object");
        PhantomReference<MyObject> phantomReference = new PhantomReference<>(myObject, referenceQueue);

        myObject = null; // 将对象置为null，使其成为垃圾回收的候选对象
        System.gc();
        // 检查引用队列，判断对象是否即将被回收
        Reference<? extends MyObject> polledReference = referenceQueue.poll();
        if (polledReference != null) {
            System.out.println("Object will be garbage collected: " + polledReference.get().getName());
        } else {
            System.out.println("Object has not been enqueued for garbage collection");
        }
    }
}

class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}