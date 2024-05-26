package ClassLoaderTest.findClass;

import ClassLoaderTest.loadClass.Order;
import HeapAndStack.HeadOverflow;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * 打破双亲委派测试——不重写loadClass(String className)方法
 **/
public class FindClassDemo extends ClassLoader {
    /**
     * 将打破双亲委派逻辑写到这里
     **/
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = readClassBytes(name.replace('.', '/'));
        return defineClass(name, data, 0, data.length);
    }

    //读取Class文件到byte[]
    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;

        String rootPath = this.getClass().getResource("/").getPath();
        File file = new File(rootPath + name + ".class");
        if (!file.exists()) {
            throw new ClassNotFoundException(name);
        }

        try {
            inputStream = Files.newInputStream(file.toPath());
            outputStream = new ByteArrayOutputStream();

            int size = 0;
            byte[] buffer = new byte[1024];

            while ((size = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, size);
            }

            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }

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