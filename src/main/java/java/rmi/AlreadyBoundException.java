/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 1996, 1998, Oracle and/or its affiliates. All rights reserved.
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
package java.rmi;

/**
 * An <code>AlreadyBoundException</code> is thrown if an attempt
 * is made to bind an object in the registry to a name that already
 * has an associated binding.
 *
 * <p>
 *  如果尝试将注册表中的对象绑定到已经具有关联绑定的名称,则会抛出<code> AlreadyBoundException </code>。
 * 
 * 
 * @since   JDK1.1
 * @author  Ann Wollrath
 * @author  Roger Riggs
 * @see     java.rmi.Naming#bind(String, java.rmi.Remote)
 * @see     java.rmi.registry.Registry#bind(String, java.rmi.Remote)
 */
public class AlreadyBoundException extends java.lang.Exception {

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = 9218657361741657110L;

    /**
     * Constructs an <code>AlreadyBoundException</code> with no
     * specified detail message.
     * <p>
     *  构造一个没有指定详细消息的<code> AlreadyBoundException </code>。
     * 
     * 
     * @since JDK1.1
     */
    public AlreadyBoundException() {
        super();
    }

    /**
     * Constructs an <code>AlreadyBoundException</code> with the specified
     * detail message.
     *
     * <p>
     *  用指定的详细消息构造一个<code> AlreadyBoundException </code>。
     * 
     * @param s the detail message
     * @since JDK1.1
     */
    public AlreadyBoundException(String s) {
        super(s);
    }
}
