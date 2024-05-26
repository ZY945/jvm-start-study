package ClassLoaderTest.testFindClass;

import ClassLoaderTest.findClass.FindClassDemo;
import ClassLoaderTest.findClass.User;
import HeapAndStack.HeadOverflow;

/**
 * @author 伍六七
 * @date 2023/9/5 22:05
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        FindClassDemo findClassDemo = new FindClassDemo();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        Class clazz1 = findClassDemo.loadClass(User.class.getName());
        // ClassLoaderTest.ClassLoaderTest2@1b6d3586
        Class clazz2 = findClassDemo.findClass(User.class.getName());
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        Class clazz3 = findClassDemo.findClass(HeadOverflow.class.getName());

        System.out.println(clazz1);
        System.out.println(clazz1.getClassLoader());

        System.out.println(clazz2);
        System.out.println(clazz2.getClassLoader());

        System.out.println(clazz3);
        System.out.println(clazz3.getClassLoader());
    }
}
