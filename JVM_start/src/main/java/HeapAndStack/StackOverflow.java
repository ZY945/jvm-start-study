package HeapAndStack;

/**
 * @author 伍六七
 * @date 2022/10/14 15:54
 */
// 循环递归调用,一直达到jvm的最大深度
public class StackOverflow {
    private static int count;

    public static void count(){
        try {
            count++;
            count();
        } catch (Throwable e) {
            System.out.println("最大深度:"+count);
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        count();
    }
}