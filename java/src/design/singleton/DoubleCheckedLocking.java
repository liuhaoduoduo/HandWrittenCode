/**
 * 用“双重检查锁定”模式实现单例模式
 * 双重检查锁定是一种软件设计模式，用于减少并发系统中竞争和同步的开销。它首先验证锁定条件，只有通过验证后才进行加锁逻辑和再次验证条件。
 */
package design.singleton;

public class DoubleCheckedLocking {
    // 此处必须加volatile关键字来阻止后续运行时JIT对其进行“指令重排”
    private static volatile DoubleCheckedLocking doubleCheckedLocking;

    // 私有化构造函数，否则的话，单例就没有意义了。
    private DoubleCheckedLocking() {
    }

    // 单例模式的关键方法，获取对象实例
    public static DoubleCheckedLocking getInstance() {
        // 第一重检查
        if (doubleCheckedLocking != null) {
            return doubleCheckedLocking;
        }
        // 符合锁定条件后尝试锁定
        synchronized (DoubleCheckedLocking.class) {
            // 第二重检查
            if (doubleCheckedLocking == null) {
                doubleCheckedLocking = new DoubleCheckedLocking();
            }
            return doubleCheckedLocking;
        }
    }
}
