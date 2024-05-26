/**
 * 1.java的引用类型
 * 强软弱徐
 * 2.引用队列 （ReferenceQueue）
 * jvm配置: -Xmx25m -Xms25m -XX:-UseCompressedOops -XX:+PrintGCDetails
 * 强:gc不会回收,除非自己清理强引用(=null)
 * 软:gc时如果内存不足,会回收软引用指向的对象(适合用在缓存技术上)
 * 弱:gc时就会回收弱引用指向的对象
 * 虚:主要用来跟踪对象被垃圾回收的活动,虚引用必须和引用队列一起使用,虚引用的get是返回null
 * @author dongfeng
 * 2024-02-23 18:32
 */
package reference;