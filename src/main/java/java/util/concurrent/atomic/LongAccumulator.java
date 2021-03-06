/***** Lobxxx Translate Finished ******/
/*
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/*
 *
 *
 *
 *
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 * <p>
 *  由Doug Lea在JCP JSR-166专家组成员的帮助下撰写,并发布到公共领域,如http://creativecommons.org/publicdomain/zero/1.0/
 * 
 */

package java.util.concurrent.atomic;
import java.io.Serializable;
import java.util.function.LongBinaryOperator;

/**
 * One or more variables that together maintain a running {@code long}
 * value updated using a supplied function.  When updates (method
 * {@link #accumulate}) are contended across threads, the set of variables
 * may grow dynamically to reduce contention.  Method {@link #get}
 * (or, equivalently, {@link #longValue}) returns the current value
 * across the variables maintaining updates.
 *
 * <p>This class is usually preferable to {@link AtomicLong} when
 * multiple threads update a common value that is used for purposes such
 * as collecting statistics, not for fine-grained synchronization
 * control.  Under low update contention, the two classes have similar
 * characteristics. But under high contention, expected throughput of
 * this class is significantly higher, at the expense of higher space
 * consumption.
 *
 * <p>The order of accumulation within or across threads is not
 * guaranteed and cannot be depended upon, so this class is only
 * applicable to functions for which the order of accumulation does
 * not matter. The supplied accumulator function should be
 * side-effect-free, since it may be re-applied when attempted updates
 * fail due to contention among threads. The function is applied with
 * the current value as its first argument, and the given update as
 * the second argument.  For example, to maintain a running maximum
 * value, you could supply {@code Long::max} along with {@code
 * Long.MIN_VALUE} as the identity.
 *
 * <p>Class {@link LongAdder} provides analogs of the functionality of
 * this class for the common special case of maintaining counts and
 * sums.  The call {@code new LongAdder()} is equivalent to {@code new
 * LongAccumulator((x, y) -> x + y, 0L}.
 *
 * <p>This class extends {@link Number}, but does <em>not</em> define
 * methods such as {@code equals}, {@code hashCode} and {@code
 * compareTo} because instances are expected to be mutated, and so are
 * not useful as collection keys.
 *
 * <p>
 *  一个或多个变量一起使用提供的函数更新运行的{@code long}值。当更新(方法{@link #accumulate})在线程之间竞争时,变量集可以动态增长以减少争用。
 * 方法{@link #get}(或等效地,{@link #longValue})返回保持更新的变量的当前值。
 * 
 *  <p>当多个线程更新用于收集统计信息而不是用于细粒度同步控制的公共值时,此类通常优先于{@link AtomicLong}。在低更新争用下,这两个类具有类似的特性。
 * 但在高争用下,这类的预期吞吐量明显更高,以更高的空间消耗为代价。
 * 
 * <p>线程内部或跨线程的累积顺序不能保证并且不能依赖,因此这个类只适用于累加顺序无关紧要的函数。所提供的累加器函数应该是无副作用的,因为当尝试更新由于线程之间的争用而失败时,它可能被重新应用。
 * 该函数应用当前值作为其第一个参数,给定的更新作为第二个参数。例如,为了保持运行最大值,您可以提供{@code Long :: max}以及{@code Long.MIN_VALUE}作为标识。
 * 
 *  <p>类{@link LongAdder}提供了类的功能类似于常见的特殊情况下维护计数和和。
 * 调用{@code new LongAdder()}相当于{@code new LongAccumulator((x,y) - > x + y,0L}。
 * 
 *  <p>此类扩展了{@link Number},但不会</em>定义诸如{@code equals},{@code hashCode}和{@code compareTo}等方法,因为实例会被改变,因此不
 * 可用作收集键。
 * 
 * 
 * @since 1.8
 * @author Doug Lea
 */
public class LongAccumulator extends Striped64 implements Serializable {
    private static final long serialVersionUID = 7249069246863182397L;

    private final LongBinaryOperator function;
    private final long identity;

    /**
     * Creates a new instance using the given accumulator function
     * and identity element.
     * <p>
     *  使用给定的累加器函数和标识元素创建一个新实例。
     * 
     * 
     * @param accumulatorFunction a side-effect-free function of two arguments
     * @param identity identity (initial value) for the accumulator function
     */
    public LongAccumulator(LongBinaryOperator accumulatorFunction,
                           long identity) {
        this.function = accumulatorFunction;
        base = this.identity = identity;
    }

    /**
     * Updates with the given value.
     *
     * <p>
     *  使用给定值更新。
     * 
     * 
     * @param x the value
     */
    public void accumulate(long x) {
        Cell[] as; long b, v, r; int m; Cell a;
        if ((as = cells) != null ||
            (r = function.applyAsLong(b = base, x)) != b && !casBase(b, r)) {
            boolean uncontended = true;
            if (as == null || (m = as.length - 1) < 0 ||
                (a = as[getProbe() & m]) == null ||
                !(uncontended =
                  (r = function.applyAsLong(v = a.value, x)) == v ||
                  a.cas(v, r)))
                longAccumulate(x, function, uncontended);
        }
    }

    /**
     * Returns the current value.  The returned value is <em>NOT</em>
     * an atomic snapshot; invocation in the absence of concurrent
     * updates returns an accurate result, but concurrent updates that
     * occur while the value is being calculated might not be
     * incorporated.
     *
     * <p>
     *  返回当前值。返回的值是<em> NOT </em>原子快照;在没有并发更新的情况下调用将返回准确的结果,但是在计算值时发生的并发更新可能不会合并。
     * 
     * 
     * @return the current value
     */
    public long get() {
        Cell[] as = cells; Cell a;
        long result = base;
        if (as != null) {
            for (int i = 0; i < as.length; ++i) {
                if ((a = as[i]) != null)
                    result = function.applyAsLong(result, a.value);
            }
        }
        return result;
    }

    /**
     * Resets variables maintaining updates to the identity value.
     * This method may be a useful alternative to creating a new
     * updater, but is only effective if there are no concurrent
     * updates.  Because this method is intrinsically racy, it should
     * only be used when it is known that no threads are concurrently
     * updating.
     * <p>
     * 重置保持对标识值更新的变量。此方法可能是创建新的更新程序的有用的替代方法,但仅在没有并发更新时有效。因为这种方法本质上是有趣的,所以它应该只在已知没有线程同时更新时才使用。
     * 
     */
    public void reset() {
        Cell[] as = cells; Cell a;
        base = identity;
        if (as != null) {
            for (int i = 0; i < as.length; ++i) {
                if ((a = as[i]) != null)
                    a.value = identity;
            }
        }
    }

    /**
     * Equivalent in effect to {@link #get} followed by {@link
     * #reset}. This method may apply for example during quiescent
     * points between multithreaded computations.  If there are
     * updates concurrent with this method, the returned value is
     * <em>not</em> guaranteed to be the final value occurring before
     * the reset.
     *
     * <p>
     *  等同于{@link #get},后跟{@link #reset}。该方法可以应用于例如在多线程计算之间的静止点期间。如果存在与该方法并发的更新,则返回的值</em>不被保证为在复位之前发生的最终值。
     * 
     * 
     * @return the value before reset
     */
    public long getThenReset() {
        Cell[] as = cells; Cell a;
        long result = base;
        base = identity;
        if (as != null) {
            for (int i = 0; i < as.length; ++i) {
                if ((a = as[i]) != null) {
                    long v = a.value;
                    a.value = identity;
                    result = function.applyAsLong(result, v);
                }
            }
        }
        return result;
    }

    /**
     * Returns the String representation of the current value.
     * <p>
     *  返回当前值的字符串表示形式。
     * 
     * 
     * @return the String representation of the current value
     */
    public String toString() {
        return Long.toString(get());
    }

    /**
     * Equivalent to {@link #get}.
     *
     * <p>
     *  相当于{@link #get}。
     * 
     * 
     * @return the current value
     */
    public long longValue() {
        return get();
    }

    /**
     * Returns the {@linkplain #get current value} as an {@code int}
     * after a narrowing primitive conversion.
     * <p>
     *  在缩小的基本转换后,将{@linkplain #get current value}返回为{@code int}。
     * 
     */
    public int intValue() {
        return (int)get();
    }

    /**
     * Returns the {@linkplain #get current value} as a {@code float}
     * after a widening primitive conversion.
     * <p>
     *  在扩展基元转换后,将{@linkplain #get current value}返回为{@code float}。
     * 
     */
    public float floatValue() {
        return (float)get();
    }

    /**
     * Returns the {@linkplain #get current value} as a {@code double}
     * after a widening primitive conversion.
     * <p>
     *  在扩展基元转换后返回{@linkplain #get current value}作为{@code double}。
     * 
     */
    public double doubleValue() {
        return (double)get();
    }

    /**
     * Serialization proxy, used to avoid reference to the non-public
     * Striped64 superclass in serialized forms.
     * <p>
     *  序列化代理,用于避免以序列化形式引用非公开的Striped64超类。
     * 
     * 
     * @serial include
     */
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 7249069246863182397L;

        /**
         * The current value returned by get().
         * <p>
         *  get()返回的当前值。
         * 
         * 
         * @serial
         */
        private final long value;
        /**
         * The function used for updates.
         * <p>
         *  用于更新的函数。
         * 
         * 
         * @serial
         */
        private final LongBinaryOperator function;
        /**
         * The identity value
         * <p>
         *  身份值
         * 
         * 
         * @serial
         */
        private final long identity;

        SerializationProxy(LongAccumulator a) {
            function = a.function;
            identity = a.identity;
            value = a.get();
        }

        /**
         * Returns a {@code LongAccumulator} object with initial state
         * held by this proxy.
         *
         * <p>
         *  返回由此代理持有的初始状态的{@code LongAccumulator}对象。
         * 
         * 
         * @return a {@code LongAccumulator} object with initial state
         * held by this proxy.
         */
        private Object readResolve() {
            LongAccumulator a = new LongAccumulator(function, identity);
            a.base = value;
            return a;
        }
    }

    /**
     * Returns a
     * <a href="../../../../serialized-form.html#java.util.concurrent.atomic.LongAccumulator.SerializationProxy">
     * SerializationProxy</a>
     * representing the state of this instance.
     *
     * <p>
     *  返回a
     * <a href="../../../../serialized-form.html#java.util.concurrent.atomic.LongAccumulator.SerializationProxy">
     *  SerializationProxy </a>表示此实例的状态。
     * 
     * @return a {@link SerializationProxy}
     * representing the state of this instance
     */
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    /**
    /* <p>
    /* 
    /* 
     * @param s the stream
     * @throws java.io.InvalidObjectException always
     */
    private void readObject(java.io.ObjectInputStream s)
        throws java.io.InvalidObjectException {
        throw new java.io.InvalidObjectException("Proxy required");
    }

}
