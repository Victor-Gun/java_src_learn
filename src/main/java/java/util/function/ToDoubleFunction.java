/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
package java.util.function;

/**
 * Represents a function that produces a double-valued result.  This is the
 * {@code double}-producing primitive specialization for {@link Function}.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #applyAsDouble(Object)}.
 *
 * <p>
 *  表示产生双值结果的函数。这是{@link Function}的{@code double}生成原语专业化。
 * 
 *  <p>这是一个<a href="package-summary.html">功能介面</a>,其功能方法是{@link #applyAsDouble(Object)}。
 * 
 * 
 * @param <T> the type of the input to the function
 *
 * @see Function
 * @since 1.8
 */
@FunctionalInterface
public interface ToDoubleFunction<T> {

    /**
     * Applies this function to the given argument.
     *
     * <p>
     * 
     * @param value the function argument
     * @return the function result
     */
    double applyAsDouble(T value);
}
