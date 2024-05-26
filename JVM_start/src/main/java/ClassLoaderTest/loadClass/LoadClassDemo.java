package ClassLoaderTest.loadClass;

import ClassLoaderTest.findClass.User;

import java.io.*;

/**
 * 打破双亲委派测试——重写loadClass(String className)方法
 **/
public class LoadClassDemo extends ClassLoader {

    /**
     * 重写loadClass必须设置java.xxx的执行父类加载器
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("java.")) {
            return getParent().loadClass(name);
        } else {
            byte[] data = readClassBytes(name.replace('.', '/'));
            return defineClass(name, data, 0, data.length);
        }
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
            inputStream = new FileInputStream(file);
            outputStream = new ByteArrayOutputStream();

            int size = 0;
            byte[] buffer = new byte[1024];

            while ((size = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, size);
            }

            return outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
        LoadClassDemo classLoaderTest = new LoadClassDemo();
        Class<?> clazz = classLoaderTest.loadClass(User.class.getName());
        System.out.println(clazz);
        // 重写loadClass,打破双亲委托机制
        // ClassLoaderTest.loadClass.LoadClassDemo@1b6d3586
        System.out.println(clazz.getClassLoader());
        Class<?> userClass = User.class;
        System.out.println(userClass);
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(userClass.getClassLoader());
    }

}