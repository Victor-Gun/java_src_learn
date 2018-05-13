/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 1995, 2006, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA;

/**
 * This exception is raised if communication is lost while an operation
 * is in progress, after the request was sent by the client, but before
 * the reply from the server has been returned to the client.<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 * <P>
 * See the section <A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">meaning
 * of minor codes</A> to see the minor codes for this exception.
 *
 * <p>
 *  如果在客户端发送请求之后,但在服务器的回复已经返回到客户端之前,在操作正在进行时,如果通信丢失,则会引发此异常。<P>它包含一个次要代码,有关导致异常的详细信息,以及完成状态。
 * 它还可以包含描述异常的字符串。
 * <P>
 *  请参阅<A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">次要代码</A>的部分以查看此例
 * 外的次要代码。
 * 
 * 
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">meaning of
 * minor codes</A>
 * @since       JDK1.2
 */

public final class COMM_FAILURE extends SystemException {

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with
     * a default minor code of 0 and a completion state of COMPLETED_NO.
     * <p>
     *  构造具有默认次要代码0和完成状态COMPLETED_NO的<code> COMM_FAILURE </code>异常。
     * 
     */
    public COMM_FAILURE() {
        this("");
    }

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with the specified detail
     * message, a minor code of 0, and a completion state of COMPLETED_NO.
     *
     * <p>
     *  构造具有指定详细消息的<code> COMM_FAILURE </code>异常,次要代码为0,完成状态为COMPLETED_NO。
     * 
     * 
     * @param s the <code>String</code> containing a detail message describing
     *          this exception
     */
    public COMM_FAILURE(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with the specified
     * minor code and completion status.
     * <p>
     *  构造具有指定的次要代码和完成状态的<code> COMM_FAILURE </code>异常。
     * 
     * 
     * @param minor the minor code
     * @param completed the completion status, which must be one of
     *                  <code>COMPLETED_YES</code>, <code>COMPLETED_NO</code>, or
     *                  <code>COMPLETED_MAYBE</code>.
     */
    public COMM_FAILURE(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with the specified detail
     * message, minor code, and completion status.
     * A detail message is a String that describes this particular exception.
     * <p>
     *  构造具有指定详细消息,次要代码和完成状态的<code> COMM_FAILURE </code>异常。详细消息是描述此特殊异常的字符串。
     * 
     * @param s the String containing a detail message
     * @param minor the minor code
     * @param completed the completion status, which must be one of
     *                  <code>COMPLETED_YES</code>, <code>COMPLETED_NO</code>, or
     *                  <code>COMPLETED_MAYBE</code>.
     */
    public COMM_FAILURE(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
