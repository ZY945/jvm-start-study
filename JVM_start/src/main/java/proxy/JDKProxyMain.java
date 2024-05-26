package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dongfeng
 * 2024-03-04 16:42
 */

interface Service{
    void sayHello();
}

class ServiceImpl implements Service{

    @Override
    public void sayHello() {
        System.out.println("hello");
    }
}


class JDKProxy implements InvocationHandler{

    private Object target;
    public JDKProxy(Object target){
        this.target=target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前");
        Object result = method.invoke(target, args);
        System.out.println("代理后");
        return result;
    }
}
public class JDKProxyMain {
    public static void main(String[] args) {
        ServiceImpl service = new ServiceImpl();
        JDKProxy jdkProxy = new JDKProxy(service);
        Service afterProxy = (Service)Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                jdkProxy
        );
        afterProxy.sayHello();
    }
}
