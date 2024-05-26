package jconsole;

/**
 * 1.jps
 * 16468 Test
 * 24328 Launcher
 * 2.jconsole
 * 3.jstat 查看内容
 * 4.jstack 查看线程
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            System.out.println("123");
        }
    }
}
