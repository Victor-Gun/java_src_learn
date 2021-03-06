/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security.cert;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.security.Provider;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the {@code CertificateFactory} class.
 * All the abstract methods in this class must be implemented by each
 * cryptographic service provider who wishes to supply the implementation
 * of a certificate factory for a particular certificate type, e.g., X.509.
 *
 * <p>Certificate factories are used to generate certificate, certification path
 * ({@code CertPath}) and certificate revocation list (CRL) objects from
 * their encodings.
 *
 * <p>A certificate factory for X.509 must return certificates that are an
 * instance of {@code java.security.cert.X509Certificate}, and CRLs
 * that are an instance of {@code java.security.cert.X509CRL}.
 *
 * <p>
 *  此类为{@code CertificateFactory}类定义了<i>服务提供程序接口</i>(<b> SPI </b>)。
 * 该类中的所有抽象方法必须由希望为特定证书类型(例如X.509)提供证书工厂的实现的每个加密服务提供者来实现。
 * 
 *  <p>证书工厂用于从其编码中生成证书,证书路径({@code CertPath})和证书吊销列表(CRL)对象。
 * 
 *  <p> X.509的证书工厂必须返回作为{@code java.security.cert.X509Certificate}的实例的证书和作为{@code java.security.cert.X509CRL}
 * 的实例的CRL。
 * 
 * 
 * @author Hemma Prafullchandra
 * @author Jan Luehe
 * @author Sean Mullan
 *
 *
 * @see CertificateFactory
 * @see Certificate
 * @see X509Certificate
 * @see CertPath
 * @see CRL
 * @see X509CRL
 *
 * @since 1.2
 */

public abstract class CertificateFactorySpi {

    /**
     * Generates a certificate object and initializes it with
     * the data read from the input stream {@code inStream}.
     *
     * <p>In order to take advantage of the specialized certificate format
     * supported by this certificate factory,
     * the returned certificate object can be typecast to the corresponding
     * certificate class. For example, if this certificate
     * factory implements X.509 certificates, the returned certificate object
     * can be typecast to the {@code X509Certificate} class.
     *
     * <p>In the case of a certificate factory for X.509 certificates, the
     * certificate provided in {@code inStream} must be DER-encoded and
     * may be supplied in binary or printable (Base64) encoding. If the
     * certificate is provided in Base64 encoding, it must be bounded at
     * the beginning by -----BEGIN CERTIFICATE-----, and must be bounded at
     * the end by -----END CERTIFICATE-----.
     *
     * <p>Note that if the given input stream does not support
     * {@link java.io.InputStream#mark(int) mark} and
     * {@link java.io.InputStream#reset() reset}, this method will
     * consume the entire input stream. Otherwise, each call to this
     * method consumes one certificate and the read position of the input stream
     * is positioned to the next available byte after the inherent
     * end-of-certificate marker. If the data in the
     * input stream does not contain an inherent end-of-certificate marker (other
     * than EOF) and there is trailing data after the certificate is parsed, a
     * {@code CertificateException} is thrown.
     *
     * <p>
     *  生成证书对象,并使用从输入流{@code inStream}读取的数据进行初始化。
     * 
     *  <p>为了利用此证书工厂支持的专门的证书格式,返回的证书对象可以类型转换到相应的证书类。
     * 例如,如果此证书工厂实现X.509证书,则返回的证书对象可以类型转换为{@code X509Certificate}类。
     * 
     * <p>对于X.509证书的证书工厂,{@code inStream}中提供的证书必须是DER编码的,并且可以以二进制或可打印(Base64)编码提供。
     * 如果证书以Base64编码提供,则必须在开始时由----- BEGIN CERTIFICATE -----进行限制,并且必须在末尾通过----- END CERTIFICATE ----- 。
     * 
     *  <p>请注意,如果给定的输入流不支持{@link java.io.InputStream#mark(int)mark}和{@link java.io.InputStream#reset()reset}
     * ,此方法将使用整个输入流。
     * 否则,每次调用此方法都会消耗一个证书,并且输入流的读取位置将位于固有的证书结束标记之后的下一个可用字节。
     * 如果输入流中的数据不包含固有的证书结束标记(除了EOF),并且在解析证书后存在结尾数据,则会抛出{@code CertificateException}。
     * 
     * 
     * @param inStream an input stream with the certificate data.
     *
     * @return a certificate object initialized with the data
     * from the input stream.
     *
     * @exception CertificateException on parsing errors.
     */
    public abstract Certificate engineGenerateCertificate(InputStream inStream)
        throws CertificateException;

    /**
     * Generates a {@code CertPath} object and initializes it with
     * the data read from the {@code InputStream} inStream. The data
     * is assumed to be in the default encoding.
     *
     * <p> This method was added to version 1.4 of the Java 2 Platform
     * Standard Edition. In order to maintain backwards compatibility with
     * existing service providers, this method cannot be {@code abstract}
     * and by default throws an {@code UnsupportedOperationException}.
     *
     * <p>
     *  生成{@code CertPath}对象,并使用从{@code InputStream} inStream读取的数据进行初始化。数据假定为采用默认编码。
     * 
     *  <p>此方法已添加到Java 2平台标准版的1.4版中。
     * 为了保持与现有服务提供程序的向后兼容性,此方法不能是{@code abstract},默认情况下会抛出{@code UnsupportedOperationException}。
     * 
     * 
     * @param inStream an {@code InputStream} containing the data
     * @return a {@code CertPath} initialized with the data from the
     *   {@code InputStream}
     * @exception CertificateException if an exception occurs while decoding
     * @exception UnsupportedOperationException if the method is not supported
     * @since 1.4
     */
    public CertPath engineGenerateCertPath(InputStream inStream)
        throws CertificateException
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Generates a {@code CertPath} object and initializes it with
     * the data read from the {@code InputStream} inStream. The data
     * is assumed to be in the specified encoding.
     *
     * <p> This method was added to version 1.4 of the Java 2 Platform
     * Standard Edition. In order to maintain backwards compatibility with
     * existing service providers, this method cannot be {@code abstract}
     * and by default throws an {@code UnsupportedOperationException}.
     *
     * <p>
     * 生成{@code CertPath}对象,并使用从{@code InputStream} inStream读取的数据进行初始化。数据假定为指定的编码。
     * 
     *  <p>此方法已添加到Java 2平台标准版的1.4版中。
     * 为了保持与现有服务提供程序的向后兼容性,此方法不能是{@code abstract},默认情况下会抛出{@code UnsupportedOperationException}。
     * 
     * 
     * @param inStream an {@code InputStream} containing the data
     * @param encoding the encoding used for the data
     * @return a {@code CertPath} initialized with the data from the
     *   {@code InputStream}
     * @exception CertificateException if an exception occurs while decoding or
     *   the encoding requested is not supported
     * @exception UnsupportedOperationException if the method is not supported
     * @since 1.4
     */
    public CertPath engineGenerateCertPath(InputStream inStream,
        String encoding) throws CertificateException
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Generates a {@code CertPath} object and initializes it with
     * a {@code List} of {@code Certificate}s.
     * <p>
     * The certificates supplied must be of a type supported by the
     * {@code CertificateFactory}. They will be copied out of the supplied
     * {@code List} object.
     *
     * <p> This method was added to version 1.4 of the Java 2 Platform
     * Standard Edition. In order to maintain backwards compatibility with
     * existing service providers, this method cannot be {@code abstract}
     * and by default throws an {@code UnsupportedOperationException}.
     *
     * <p>
     *  生成{@code CertPath}对象,并使用{@code Certificate}的{@code List}对其进行初始化。
     * <p>
     *  所提供的证书必须是{@code CertificateFactory}支持的类型。它们将从提供的{@code List}对象中复制。
     * 
     *  <p>此方法已添加到Java 2平台标准版的1.4版中。
     * 为了保持与现有服务提供程序的向后兼容性,此方法不能是{@code abstract},默认情况下会抛出{@code UnsupportedOperationException}。
     * 
     * 
     * @param certificates a {@code List} of {@code Certificate}s
     * @return a {@code CertPath} initialized with the supplied list of
     *   certificates
     * @exception CertificateException if an exception occurs
     * @exception UnsupportedOperationException if the method is not supported
     * @since 1.4
     */
    public CertPath
        engineGenerateCertPath(List<? extends Certificate> certificates)
        throws CertificateException
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an iteration of the {@code CertPath} encodings supported
     * by this certificate factory, with the default encoding first. See
     * the CertPath Encodings section in the <a href=
     * "{@docRoot}/../technotes/guides/security/StandardNames.html#CertPathEncodings">
     * Java Cryptography Architecture Standard Algorithm Name Documentation</a>
     * for information about standard encoding names.
     * <p>
     * Attempts to modify the returned {@code Iterator} via its
     * {@code remove} method result in an
     * {@code UnsupportedOperationException}.
     *
     * <p> This method was added to version 1.4 of the Java 2 Platform
     * Standard Edition. In order to maintain backwards compatibility with
     * existing service providers, this method cannot be {@code abstract}
     * and by default throws an {@code UnsupportedOperationException}.
     *
     * <p>
     *  返回此证书工厂支持的{@code CertPath}编码的迭代,首先使用默认编码。请参阅<a href =中的CertPath编码部分
     * "{@docRoot}/../technotes/guides/security/StandardNames.html#CertPathEncodings">
     *  Java加密架构标准算法名称文档</a>以获取有关标准编码名称的信息。
     * <p>
     *  尝试通过其{@code remove}方法修改返回的{@code Iterator}会导致{@code UnsupportedOperationException}。
     * 
     * <p>此方法已添加到Java 2平台标准版的1.4版中。
     * 为了保持与现有服务提供程序的向后兼容性,此方法不能是{@code abstract},默认情况下会抛出{@code UnsupportedOperationException}。
     * 
     * 
     * @return an {@code Iterator} over the names of the supported
     *         {@code CertPath} encodings (as {@code String}s)
     * @exception UnsupportedOperationException if the method is not supported
     * @since 1.4
     */
    public Iterator<String> engineGetCertPathEncodings() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns a (possibly empty) collection view of the certificates read
     * from the given input stream {@code inStream}.
     *
     * <p>In order to take advantage of the specialized certificate format
     * supported by this certificate factory, each element in
     * the returned collection view can be typecast to the corresponding
     * certificate class. For example, if this certificate
     * factory implements X.509 certificates, the elements in the returned
     * collection can be typecast to the {@code X509Certificate} class.
     *
     * <p>In the case of a certificate factory for X.509 certificates,
     * {@code inStream} may contain a single DER-encoded certificate
     * in the formats described for
     * {@link CertificateFactory#generateCertificate(java.io.InputStream)
     * generateCertificate}.
     * In addition, {@code inStream} may contain a PKCS#7 certificate
     * chain. This is a PKCS#7 <i>SignedData</i> object, with the only
     * significant field being <i>certificates</i>. In particular, the
     * signature and the contents are ignored. This format allows multiple
     * certificates to be downloaded at once. If no certificates are present,
     * an empty collection is returned.
     *
     * <p>Note that if the given input stream does not support
     * {@link java.io.InputStream#mark(int) mark} and
     * {@link java.io.InputStream#reset() reset}, this method will
     * consume the entire input stream.
     *
     * <p>
     *  返回从给定输入流{@code inStream}读取的证书的(可能为空)集合视图。
     * 
     *  <p>为了利用此证书工厂支持的专门的证书格式,返回的集合视图中的每个元素可以类型转换为相应的证书类。
     * 例如,如果此证书工厂实现X.509证书,则返回的集合中的元素可以类型转换为{@code X509Certificate}类。
     * 
     *  <p>对于X.509证书的证书工厂,{@code inStream}可能包含一个单独的DER编码证书,格式为{@link CertificateFactory#generateCertificate(java.io.InputStream)generateCertificate}
     * 中所述的格式。
     * 此外,{@code inStream}可能包含PKCS#7证书链。这是一个PKCS#7 <i> SignedData </i>对象,唯一有效的字段是<i>证书</i>。特别地,签名和内容被忽略。
     * 此格式允许立即下载多个证书。如果不存在证书,则返回空集合。
     * 
     * <p>请注意,如果给定的输入流不支持{@link java.io.InputStream#mark(int)mark}和{@link java.io.InputStream#reset()reset},
     * 此方法将使用整个输入流。
     * 
     * 
     * @param inStream the input stream with the certificates.
     *
     * @return a (possibly empty) collection view of
     * java.security.cert.Certificate objects
     * initialized with the data from the input stream.
     *
     * @exception CertificateException on parsing errors.
     */
    public abstract Collection<? extends Certificate>
            engineGenerateCertificates(InputStream inStream)
            throws CertificateException;

    /**
     * Generates a certificate revocation list (CRL) object and initializes it
     * with the data read from the input stream {@code inStream}.
     *
     * <p>In order to take advantage of the specialized CRL format
     * supported by this certificate factory,
     * the returned CRL object can be typecast to the corresponding
     * CRL class. For example, if this certificate
     * factory implements X.509 CRLs, the returned CRL object
     * can be typecast to the {@code X509CRL} class.
     *
     * <p>Note that if the given input stream does not support
     * {@link java.io.InputStream#mark(int) mark} and
     * {@link java.io.InputStream#reset() reset}, this method will
     * consume the entire input stream. Otherwise, each call to this
     * method consumes one CRL and the read position of the input stream
     * is positioned to the next available byte after the inherent
     * end-of-CRL marker. If the data in the
     * input stream does not contain an inherent end-of-CRL marker (other
     * than EOF) and there is trailing data after the CRL is parsed, a
     * {@code CRLException} is thrown.
     *
     * <p>
     *  生成证书吊销列表(CRL)对象,并使用从输入流{@code inStream}读取的数据对其进行初始化。
     * 
     *  <p>为了利用此证书工厂支持的特殊CRL格式,返回的CRL对象可以类型转换到相应的CRL类。
     * 例如,如果此证书工厂实现X.509 CRL,则返回的CRL对象可以类型转换为{@code X509CRL}类。
     * 
     *  <p>请注意,如果给定的输入流不支持{@link java.io.InputStream#mark(int)mark}和{@link java.io.InputStream#reset()reset}
     * ,此方法将使用整个输入流。
     * 否则,每次调用此方法将消耗一个CRL,并且输入流的读取位置将位于CRL标记结束后的下一个可用字节。
     * 如果输入流中的数据不包含固有的CRL结束标记(除了EOF),并且在解析CRL之后存在结尾数据,则会抛出{@code CRLException}。
     * 
     * 
     * @param inStream an input stream with the CRL data.
     *
     * @return a CRL object initialized with the data
     * from the input stream.
     *
     * @exception CRLException on parsing errors.
     */
    public abstract CRL engineGenerateCRL(InputStream inStream)
        throws CRLException;

    /**
     * Returns a (possibly empty) collection view of the CRLs read
     * from the given input stream {@code inStream}.
     *
     * <p>In order to take advantage of the specialized CRL format
     * supported by this certificate factory, each element in
     * the returned collection view can be typecast to the corresponding
     * CRL class. For example, if this certificate
     * factory implements X.509 CRLs, the elements in the returned
     * collection can be typecast to the {@code X509CRL} class.
     *
     * <p>In the case of a certificate factory for X.509 CRLs,
     * {@code inStream} may contain a single DER-encoded CRL.
     * In addition, {@code inStream} may contain a PKCS#7 CRL
     * set. This is a PKCS#7 <i>SignedData</i> object, with the only
     * significant field being <i>crls</i>. In particular, the
     * signature and the contents are ignored. This format allows multiple
     * CRLs to be downloaded at once. If no CRLs are present,
     * an empty collection is returned.
     *
     * <p>Note that if the given input stream does not support
     * {@link java.io.InputStream#mark(int) mark} and
     * {@link java.io.InputStream#reset() reset}, this method will
     * consume the entire input stream.
     *
     * <p>
     *  返回从给定输入流{@code inStream}读取的CRL的(可能为空)集合视图。
     * 
     * <p>为了利用此证书工厂支持的特殊CRL格式,返回的集合视图中的每个元素都可以类型转换为相应的CRL类。
     * 例如,如果此证书工厂实现X.509 CRL,则返回的集合中的元素可以类型转换为{@code X509CRL}类。
     * 
     *  <p>对于X.509 CRL的证书工厂,{@code inStream}可能包含单个DER编码的CRL。此外,{@code inStream}可能包含PKCS#7 CRL集。
     * 
     * @param inStream the input stream with the CRLs.
     *
     * @return a (possibly empty) collection view of
     * java.security.cert.CRL objects initialized with the data from the input
     * stream.
     *
     * @exception CRLException on parsing errors.
     */
    public abstract Collection<? extends CRL> engineGenerateCRLs
            (InputStream inStream) throws CRLException;
}
