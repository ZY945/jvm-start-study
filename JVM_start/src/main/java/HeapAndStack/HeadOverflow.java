package HeapAndStack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 伍六七
 * @date 2022/10/14 15:54
 */
// 介绍:执行该段代码需要大于10m内存空间
public class HeadOverflow {
    public static void main(String[] args) {
        List<Object> listObj = new ArrayList<Object>();
        for(int i=0; i<10; i++){
            Byte[] bytes = new Byte[1*1024*1024];
            listObj.add(bytes);
        }
        System.out.println("添加success");
    }
}

// 设置该程序的jvm参数信息
//-Xms1m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
//        初始堆内存和最大可以堆内存 Gc详细日志信息