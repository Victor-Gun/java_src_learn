/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.bind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * <p> Maps a package name to a XML namespace. </p>
 *
 * <h3>Usage</h3>
 * <p>
 * The XmlSchema annotation can be used with the following program
 * elements:
 * <ul>
 *   <li>package</li>
 * </ul>
 *
 * <p>
 * This is a package level annotation and follows the recommendations
 * and restrictions contained in JSR 175, section III, "Annotations".
 * Thus the usage is subject to the following constraints and
 * recommendations.
 * <ul>
 *   <li> There can only be one package declaration as noted in JSR
 *        175, section III, "Annotations". </li>
 *   <li> JSR 175 recommends package-info.java for package level
 *        annotations. JAXB Providers that follow this recommendation
 *        will allow the package level annotations to be defined in
 *        package-info.java.
 * </ul>
 * <p>
 *
 * <p><b>Example 1:</b> Customize name of XML namespace to which
 * package is mapped.</p>
 *
 * <pre>
 *    &#64;javax.xml.bind.annotation.XmlSchema (
 *      namespace = "http://www.example.com/MYPO1"
 *    )
 *
 *    &lt;!-- XML Schema fragment -->
 *    &lt;schema
 *      xmlns=...
 *      xmlns:po=....
 *      targetNamespace="http://www.example.com/MYPO1"
 *    >
 *    &lt;!-- prefixes generated by default are implementation
 *            depedenent -->
 * </pre>
 *
 * <p><b>Example 2:</b> Customize namespace prefix, namespace URI
 * mapping</p>
 *
 * <pre>
 *    // Package level annotation
 *    &#64;javax.xml.bind.annotation.XmlSchema (
 *      xmlns = {
 *        &#64;javax.xml.bind.annotation.XmlNs(prefix = "po",
 *                   namespaceURI="http://www.example.com/myPO1"),
 *
 *        &#64;javax.xml.bind.annotation.XmlNs(prefix="xs",
 *                   namespaceURI="http://www.w3.org/2001/XMLSchema")
 *      )
 *    )
 *
 *    &lt;!-- XML Schema fragment -->
 *    &lt;schema
 *        xmlns:xs="http://www.w3.org/2001/XMLSchema"
 *        xmlns:po="http://www.example.com/PO1"
 *        targetNamespace="http://www.example.com/PO1">
 *
 * </pre>
 *
 * <p><b>Example 3:</b> Customize elementFormDefault</p>
 * <pre>
 *    &#64;javax.xml.bind.annotation.XmlSchema (
 *      elementFormDefault=XmlNsForm.UNQUALIFIED
 *      ...
 *    )
 *
 *    &lt;!-- XML Schema fragment -->
 *    &lt;schema
 *        xmlns="http://www.w3.org/2001/XMLSchema"
 *        xmlns:po="http://www.example.com/PO1"
 *        elementFormDefault="unqualified">
 *
 * </pre>

 * <p>
 *  <p>将包名称映射到XML命名空间。 </p>
 * 
 *  <h3>用法</h3>
 * <p>
 *  XmlSchema注释可以与以下程序元素一起使用：
 * <ul>
 *  <li>包裹</li>
 * </ul>
 * 
 * <p>
 *  这是一个包级别的注释,并遵循JSR 175第三部分"注释"中包含的建议和限制。因此,使用受到以下约束和建议的约束。
 * <ul>
 *  <li> JSR 175第三部分"注释"中注明只能有一个包声明。 </li> <li> JSR 175建议package -info.java用于包级别注释。
 * 遵循此建议的JAXB提供程序将允许在package-info.java中定义包级别的注释。
 * </ul>
 * <p>
 * 
 *  <p> <b>示例1：</b>自定义程序包映射到的XML命名空间的名称。</p>
 * 
 * <pre>
 *  @ javax.xml.bind.annotation.XmlSchema(namespace ="http://www.example.com/MYPO1")
 * 
 * &lt;!-- XML Schema fragment -->
 *  &lt; schema xmlns = ... xmlns：po = .... targetNamespace ="http://www.example.com/MYPO1"
 * >
 *  &lt;！ - 默认生成的前缀是实现
 * depedenent -->
 * </pre>
 * 
 *  <p> <b>示例2：</b>自定义命名空间前缀,命名空间URI映射</p>
 * 
 * <pre>
 *  //包级别注释@ javax.xml.bind.annotation.XmlSchema(xmlns = {@ javax.xml.bind.annotation.XmlNs(prefix ="po",namespaceURI ="http://www.example.com/myPO1 "),。
 * 
 *  @ javax.xml.bind.annotation.XmlNs(prefix ="xs",namespaceURI ="http://www.w3.org/2001/XMLSchema")))
 * 
 * &lt;!-- XML Schema fragment -->
 * &lt; schema xmlns：xs ="http://www.w3.org/2001/XMLSchema"xmlns：po ="http://www.example.com/PO1"
 * targetNamespace="http://www.example.com/PO1">
 * 
 * </pre>
 * 
 *  <p> <b>示例3：</b>自定义elementFormDefault </p>
 * <pre>
 *  @ javax.xml.bind.annotation.XmlSchema(elementFormDefault = XmlNsForm.UNQUALIFIED ...)
 * 
 * &lt;!-- XML Schema fragment -->
 * 
 * @author Sekhar Vajjhala, Sun Microsystems, Inc.
 * @since JAXB2.0
 */

@Retention(RUNTIME) @Target(PACKAGE)
public @interface XmlSchema {

    /**
     * Customize the namespace URI, prefix associations. By default,
     * the namespace prefixes for a XML namespace are generated by a
     * JAXB Provider in an implementation dependent way.
     * <p>
     *  &lt; schema xmlns ="http://www.w3.org/2001/XMLSchema"xmlns：po ="http://www.example.com/PO1"
     * elementFormDefault="unqualified">
     * 
     * </pre>
     * 
     */
    XmlNs[]  xmlns() default {};

    /**
     * Name of the XML namespace.
     * <p>
     *  自定义命名空间的URI,前缀关联。默认情况下,XML命名空间的命名空间前缀由JAXB提供程序以实现相关方式生成。
     * 
     */
    String namespace() default "";

    /**
     * Namespace qualification for elements. By default, element
     * default attribute will be absent from the XML Schema fragment.
     * <p>
     *  XML命名空间的名称。
     * 
     */
    XmlNsForm elementFormDefault() default XmlNsForm.UNSET;

    /**
     * Namespace qualification for attributes. By default,
     * attributesFormDefault will be absent from the XML Schema fragment.
     * <p>
     *  元素的命名空间限定。默认情况下,XML模式片段中缺少元素默认属性。
     * 
     */
    XmlNsForm attributeFormDefault() default XmlNsForm.UNSET;

    /**
     * Indicates that this namespace (specified by {@link #namespace()})
     * has a schema already available exeternally, available at this location.
     *
     * <p>
     * This instructs the JAXB schema generators to simply refer to
     * the pointed schema, as opposed to generating components into the schema.
     * This schema is assumed to match what would be otherwise produced
     * by the schema generator (same element names, same type names...)
     *
     * <p>
     * This feature is intended to be used when a set of the Java classes
     * is originally generated from an existing schema, hand-written to
     * match externally defined schema, or the generated schema is modified
     * manually.
     *
     * <p>
     * Value could be any absolute URI, like <tt>http://example.org/some.xsd</tt>.
     * It is also possible to specify the empty string, to indicate
     * that the schema is externally available but the location is
     * unspecified (and thus it's the responsibility of the reader of the generate
     * schema to locate it.) Finally, the default value of this property
     * <tt>"##generate"</tt> indicates that the schema generator is going
     * to generate components for this namespace (as it did in JAXB 2.0.)
     *
     * <p>
     * Multiple {@link XmlSchema} annotations on multiple packages are allowed
     * to govern the same {@link #namespace()}. In such case, all of them
     * must have the same {@link #location()} values.
     *
     *
     * <h3>Note to implementor</h3>
     * <p>
     * More precisely, the value must be either <tt>""</tt>, <tt>"##generate"</tt>, or
     * <a href="http://www.w3.org/TR/xmlschema-2/#anyURI">
     * a valid lexical representation of <tt>xs:anyURI</tt></a> that begins
     * with <tt>&lt;scheme>:</tt>.
     *
     * <p>
     * A schema generator is expected to generate a corresponding
     * <tt>&lt;xs:import namespace="..." schemaLocation="..."/></tt> (or
     * no <tt>schemaLocation</tt> attribute at all if the empty string is specified.)
     * However, the schema generator is allowed to use a different value in
     * the <tt>schemaLocation</tt> attribute (including not generating
     * such attribute), for example so that the user can specify a local
     * copy of the resource through the command line interface.
     *
     * <p>
     *  属性的命名空间限定。默认情况下,XML Schema片段中不存在attributesFormDefault。
     * 
     * 
     * @since JAXB2.1
     */
    String location() default NO_LOCATION;

    /**
     * The default value of the {@link #location()} attribute,
     * which indicates that the schema generator will generate
     * components in this namespace.
     * <p>
     *  表示此命名空间(由{@link #namespace()}指定)具有已在外部可用的模式,在此位置可用。
     * 
     * <p>
     *  这指示JAXB模式生成器简单地引用指向的模式,而不是在模式中生成组件。假定此模式与由模式生成器生成的模式(相同的元素名称,相同的类型名称...)
     * 
     * <p>
     *  当一组Java类最初从现有模式生成,手写以匹配外部定义的模式,或手动修改生成的模式时,将使用此功能。
     * 
     * <p>
     * 值可以是任何绝对URI,例如<tt> http://example.org/some.xsd </tt>。还可以指定空字符串,以指示模式是外部可用的,但位置未指定(因此,生成模式的读者有责任定位它)。
     * 最后,此属性的默认值< tt>"## generate"</tt>表示模式生成器将为此命名空间生成组件(如在JAXB 2.0中所做的那样)。
     * 
     * <p>
     *  允许在多个包上使用多个{@link XmlSchema}注释来管理同一个{@link #namespace()}。在这种情况下,它们都必须具有相同的{@link #location()}值。
     * 
     */
    // the actual value is chosen because ## is not a valid
    // sequence in xs:anyURI.
    static final String NO_LOCATION = "##generate";
}
