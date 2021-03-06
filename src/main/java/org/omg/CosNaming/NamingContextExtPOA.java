/***** Lobxxx Translate Finished ******/
package org.omg.CosNaming;


/**
* org/omg/CosNaming/NamingContextExtPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u45/3627/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Thursday, April 30, 2015 12:42:08 PM PDT
*/


/** 
 * <code>NamingContextExt</code> is the extension of <code>NamingContext</code>
 * which
 * contains a set of name bindings in which each name is unique and is
 * part of Interoperable Naming Service.
 * Different names can be bound to an object in the same or different
 * contexts at the same time. Using <tt>NamingContextExt</tt>, you can use
 * URL-based names to bind and resolve. <p>
 * 
 * See <a href="http://www.omg.org/technology/documents/formal/naming_service.htm">
 * CORBA COS 
 * Naming Specification.</a>
 * <p>
 *  <code> NamingContextExt </code>是<code> NamingContext </code>的扩展,它包含一组名称绑定,其中每个名称是唯一的,并且是可互操作命名服务的一部分
 * 。
 * 不同的名称可以同时绑定到相同或不同上下文中的对象。使用<tt> NamingContextExt </tt>,您可以使用基于URL的名称进行绑定和解析。 <p>。
 * 
 *  请参见<a href="http://www.omg.org/technology/documents/formal/naming_service.htm"> CORBA COS命名规范</a>。
 * 
 */
public abstract class NamingContextExtPOA extends org.omg.PortableServer.Servant
 implements org.omg.CosNaming.NamingContextExtOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("to_string", new java.lang.Integer (0));
    _methods.put ("to_name", new java.lang.Integer (1));
    _methods.put ("to_url", new java.lang.Integer (2));
    _methods.put ("resolve_str", new java.lang.Integer (3));
    _methods.put ("bind", new java.lang.Integer (4));
    _methods.put ("bind_context", new java.lang.Integer (5));
    _methods.put ("rebind", new java.lang.Integer (6));
    _methods.put ("rebind_context", new java.lang.Integer (7));
    _methods.put ("resolve", new java.lang.Integer (8));
    _methods.put ("unbind", new java.lang.Integer (9));
    _methods.put ("list", new java.lang.Integer (10));
    _methods.put ("new_context", new java.lang.Integer (11));
    _methods.put ("bind_new_context", new java.lang.Integer (12));
    _methods.put ("destroy", new java.lang.Integer (13));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  /**
 * This operation creates a stringified name from the array of Name
 * components.
 * 
 * <p>
 *  此操作从名称组件数组创建一个字符串名称。
 * 
 * 
 * @param n Name of the object <p>
 * 
 * @exception org.omg.CosNaming.NamingContextExtPackage.InvalidName
 * Indicates the name does not identify a binding.<p>
 * 
 */
       case 0:  // CosNaming/NamingContextExt/to_string
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           String $result = null;
           $result = this.to_string (n);
           out = $rh.createReply();
           out.write_string ($result);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /**
 * This operation  converts a Stringified Name into an  equivalent array
 * of Name Components. 
 * 
 * <p>
 *  此操作将字符串化名称转换为名称组件的等效数组。
 * 
 * 
 * @param sn Stringified Name of the object <p>
 * 
 * @exception org.omg.CosNaming.NamingContextExtPackage.InvalidName
 * Indicates the name does not identify a binding.<p>
 * 
 */
       case 1:  // CosNaming/NamingContextExt/to_name
       {
         try {
           String sn = org.omg.CosNaming.NamingContextExtPackage.StringNameHelper.read (in);
           org.omg.CosNaming.NameComponent $result[] = null;
           $result = this.to_name (sn);
           out = $rh.createReply();
           org.omg.CosNaming.NameHelper.write (out, $result);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /**
 * This operation creates a URL based "iiopname://" format name
 * from the Stringified Name of the object.
 * 
 * <p>
 *  此操作从对象的Stringified Name创建一个基于"iiopname：//"格式名的URL。
 * 
 * 
 * @param addr internet based address of the host machine where  Name Service is running <p>
 * @param sn Stringified Name of the object <p>
 * 
 * @exception org.omg.CosNaming.NamingContextExtPackage.InvalidName
 * Indicates the name does not identify a binding.<p>
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidAddress
 * Indicates the internet based address of the host machine is 
 * incorrect <p>
 * 
 */
       case 2:  // CosNaming/NamingContextExt/to_url
       {
         try {
           String addr = org.omg.CosNaming.NamingContextExtPackage.AddressHelper.read (in);
           String sn = org.omg.CosNaming.NamingContextExtPackage.StringNameHelper.read (in);
           String $result = null;
           $result = this.to_url (addr, sn);
           out = $rh.createReply();
           out.write_string ($result);
         } catch (org.omg.CosNaming.NamingContextExtPackage.InvalidAddress $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextExtPackage.InvalidAddressHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /**
 * This operation resolves the Stringified name into the object
 * reference. 
 * 
 * <p>
 *  此操作将Stringified名称解析为对象引用。
 * 
 * 
 * @param sn Stringified Name of the object <p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound
 * Indicates there is no object reference for the given name. <p>
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed
 * Indicates that the given compound name is incorrect <p>
 * @exception org.omg.CosNaming.NamingContextExtPackage.InvalidName
 * Indicates the name does not identify a binding.<p>
 * 
 */
       case 3:  // CosNaming/NamingContextExt/resolve_str
       {
         try {
           String sn = org.omg.CosNaming.NamingContextExtPackage.StringNameHelper.read (in);
           org.omg.CORBA.Object $result = null;
           $result = this.resolve_str (sn);
           out = $rh.createReply();
           org.omg.CORBA.ObjectHelper.write (out, $result);
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /**
 * Creates a binding of a name and an object in the naming context.
 * Naming contexts that are bound using bind do not participate in name
 * resolution when compound names are passed to be resolved. 
 * 
 * <p>
 *  在命名上下文中创建名称和对象的绑定。当通过要解析的复合名称时,使用bind绑定的命名上下文不参与名称解析。
 * 
 * 
 * @param n Name of the object <p>
 * 
 * @param obj The Object to bind with the given name<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound Indicates
 * the name does not identify a binding.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed 
 * Indicates that the implementation has given up for some reason.
 * The client, however, may be able to continue the operation
 * at the returned naming context.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidName 
 * Indicates that the name is invalid. <p>
 *
 * @exception org.omg.CosNaming.NamingContextPackage.AlreadyBound 
 * Indicates an object is already bound to the specified name.<p> 
 */
       case 4:  // CosNaming/NamingContext/bind
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           org.omg.CORBA.Object obj = org.omg.CORBA.ObjectHelper.read (in);
           this.bind (n, obj);
           out = $rh.createReply();
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.AlreadyBound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.AlreadyBoundHelper.write (out, $ex);
         }
         break;
       }


  /**
 * Names an object that is a naming context. Naming contexts that
 * are bound using bind_context() participate in name resolution 
 * when compound names are passed to be resolved.
 * 
 * <p>
 *  命名作为命名上下文的对象。当通过要解析的复合名称时,使用bind_context()绑定的命名上下文参与名称解析。
 * 
 * 
 * @param n Name of the object <p>
 * 
 * @param nc NamingContect object to bind with the given name <p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound Indicates the name does not identify a binding.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed Indicates that the implementation has
 * given up for some reason. The client, however, may be able to 
 * continue the operation at the returned naming context.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidName Indicates that the name is invalid. <p>
 *
 * @exception org.omg.CosNaming.NamingContextPackage.AlreadyBound Indicates an object is already 
 * bound to the specified name.<p>
 */
       case 5:  // CosNaming/NamingContext/bind_context
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           org.omg.CosNaming.NamingContext nc = org.omg.CosNaming.NamingContextHelper.read (in);
           this.bind_context (n, nc);
           out = $rh.createReply();
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.AlreadyBound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.AlreadyBoundHelper.write (out, $ex);
         }
         break;
       }


  /**
 * Creates a binding of a name and an object in the naming context
 * even if the name is already bound in the context. Naming contexts 
 * that are bound using rebind do not participate in name resolution 
 * when compound names are passed to be resolved.
 * 
 * <p>
 * 即使名称已在上下文中绑定,也会在命名上下文中创建名称和对象的绑定。当通过要解析的复合名称时,使用重新绑定绑定的命名上下文不参与名称解析。
 * 
 * 
 * @param  n Name of the object <p>
 * 
 * @param obj The Object to rebind with the given name <p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound Indicates the name does not identify a binding.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed Indicates that the implementation has
 * given up for some reason. The client, however, may be able to 
 * continue the operation at the returned naming context.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidName Indicates that the name is invalid. <p>
 */
       case 6:  // CosNaming/NamingContext/rebind
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           org.omg.CORBA.Object obj = org.omg.CORBA.ObjectHelper.read (in);
           this.rebind (n, obj);
           out = $rh.createReply();
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /** 
 * Creates a binding of a name and a naming context in the naming
 * context even if the name is already bound in the context. Naming 
 * contexts that are bound using rebind_context() participate in name 
 * resolution when compound names are passed to be resolved.
 * 
 * <p>
 *  即使名称已在上下文中绑定,也会在命名上下文中创建名称和命名上下文的绑定。当通过要解析的复合名称时,使用rebind_context()绑定的命名上下文将参与名称解析。
 * 
 * 
 * @param n Name of the object <p>
 * 
 * @param nc NamingContect object to rebind with the given name <p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound Indicates the name does not identify a binding.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed Indicates that the implementation has
 * given up for some reason. The client, however, may be able to 
 * continue the operation at the returned naming context.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidName Indicates that the name is invalid. <p>
 */
       case 7:  // CosNaming/NamingContext/rebind_context
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           org.omg.CosNaming.NamingContext nc = org.omg.CosNaming.NamingContextHelper.read (in);
           this.rebind_context (n, nc);
           out = $rh.createReply();
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /** 
 * The resolve operation is the process of retrieving an object
 * bound to a name in a given context. The given name must exactly 
 * match the bound name. The naming service does not return the type 
 * of the object. Clients are responsible for "narrowing" the object 
 * to the appropriate type. That is, clients typically cast the returned 
 * object from Object to a more specialized interface.
 * 
 * <p>
 *  解析操作是检索绑定到给定上下文中的名称的对象的过程。给定的名称必须与绑定的名称完全匹配。命名服务不返回对象的类型。客户端负责将对象"缩小"为适当的类型。
 * 也就是说,客户端通常将从Object返回的对象转换到更专用的接口。
 * 
 * 
 * @param n Name of the object <p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound Indicates the name does not identify a binding.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed Indicates that the implementation has
 * given up for some reason. The client, however, may be able to 
 * continue the operation at the returned naming context.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidName Indicates that the name is invalid. <p>
 */
       case 8:  // CosNaming/NamingContext/resolve
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           org.omg.CORBA.Object $result = null;
           $result = this.resolve (n);
           out = $rh.createReply();
           org.omg.CORBA.ObjectHelper.write (out, $result);
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /** 
 * The unbind operation removes a name binding from a context.
 * 
 * <p>
 *  unbind操作从上下文中删除名称绑定。
 * 
 * 
 * @param n Name of the object <p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound Indicates the name does not identify a binding.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed Indicates that the implementation has
 * given up for some reason. The client, however, may be able to 
 * continue the operation at the returned naming context.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidName Indicates that the name is invalid. <p>
 */
       case 9:  // CosNaming/NamingContext/unbind
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           this.unbind (n);
           out = $rh.createReply();
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /**
 * The list operation allows a client to iterate through a set of
 * bindings in a naming context. <p>
 * 
 * The list operation returns at most the requested number of
 * bindings in BindingList bl. 
 * <ul>
 * <li>If the naming context contains additional 
 * bindings, the list operation returns a BindingIterator with the 
 * additional bindings. 
 * <li>If the naming context does not contain additional 
 * bindings, the binding iterator is a nil object reference.
 * </ul>
 * 
 * <p>
 *  列表操作允许客户端在命名上下文中迭代一组绑定。 <p>
 * 
 *  列表操作最多只返回BindingList bl中请求的绑定数。
 * <ul>
 *  <li>如果命名上下文包含其他绑定,则列表操作将返回带有其他绑定的BindingIterator。 <li>如果命名上下文不包含其他绑定,则绑定迭代器是一个nil对象引用。
 * </ul>
 * 
 * 
 * @param how_many the maximum number of bindings to return <p>
 * 
 * @param bl the returned list of bindings <p>
 * 
 * @param bi the returned binding iterator <p>
 */
       case 10:  // CosNaming/NamingContext/list
       {
         int how_many = in.read_ulong ();
         org.omg.CosNaming.BindingListHolder bl = new org.omg.CosNaming.BindingListHolder ();
         org.omg.CosNaming.BindingIteratorHolder bi = new org.omg.CosNaming.BindingIteratorHolder ();
         this.list (how_many, bl, bi);
         out = $rh.createReply();
         org.omg.CosNaming.BindingListHelper.write (out, bl.value);
         org.omg.CosNaming.BindingIteratorHelper.write (out, bi.value);
         break;
       }


  /**
 * This operation returns a naming context implemented by the same
 * naming server as the context on which the operation was invoked. 
 * The new context is not bound to any name.
 * <p>
 * 此操作返回由与调用操作的上下文相同的命名服务器实现的命名上下文。新上下文不绑定到任何名称。
 * 
 */
       case 11:  // CosNaming/NamingContext/new_context
       {
         org.omg.CosNaming.NamingContext $result = null;
         $result = this.new_context ();
         out = $rh.createReply();
         org.omg.CosNaming.NamingContextHelper.write (out, $result);
         break;
       }


  /**
 * This operation creates a new context and binds it to the name
 * supplied as an argument. The newly-created context is implemented 
 * by the same naming server as the context in which it was bound (that 
 * is, the naming server that implements the context denoted by the 
 * name argument excluding the last component).
 * 
 * <p>
 *  此操作将创建一个新上下文并将其绑定到作为参数提供的名称。新创建的上下文由与其绑定的上下文(即,实现由除了最后一个组件之外的名称参数表示的上下文的命名服务器)相同的命名服务器实现。
 * 
 * 
 * @param n Name of the object <p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotFound Indicates the name does not identify a binding.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.AlreadyBound Indicates an object is already 
 * bound to the specified name.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.CannotProceed Indicates that the implementation has
 * given up for some reason. The client, however, may be able to 
 * continue the operation at the returned naming context.<p>
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.InvalidName Indicates that the name is invalid. <p>
 */
       case 12:  // CosNaming/NamingContext/bind_new_context
       {
         try {
           org.omg.CosNaming.NameComponent n[] = org.omg.CosNaming.NameHelper.read (in);
           org.omg.CosNaming.NamingContext $result = null;
           $result = this.bind_new_context (n);
           out = $rh.createReply();
           org.omg.CosNaming.NamingContextHelper.write (out, $result);
         } catch (org.omg.CosNaming.NamingContextPackage.NotFound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotFoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.AlreadyBound $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.AlreadyBoundHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.CannotProceed $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.CannotProceedHelper.write (out, $ex);
         } catch (org.omg.CosNaming.NamingContextPackage.InvalidName $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.InvalidNameHelper.write (out, $ex);
         }
         break;
       }


  /** 
 * The destroy operation deletes a naming context. If the naming 
 * context contains bindings, the NotEmpty exception is raised.
 * 
 * <p>
 *  destroy操作将删除命名上下文。如果命名上下文包含绑定,则会抛出NotEmpty异常。
 * 
 * @exception org.omg.CosNaming.NamingContextPackage.NotEmpty Indicates that the Naming Context contains bindings.
 */
       case 13:  // CosNaming/NamingContext/destroy
       {
         try {
           this.destroy ();
           out = $rh.createReply();
         } catch (org.omg.CosNaming.NamingContextPackage.NotEmpty $ex) {
           out = $rh.createExceptionReply ();
           org.omg.CosNaming.NamingContextPackage.NotEmptyHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:omg.org/CosNaming/NamingContextExt:1.0", 
    "IDL:omg.org/CosNaming/NamingContext:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public NamingContextExt _this() 
  {
    return NamingContextExtHelper.narrow(
    super._this_object());
  }

  public NamingContextExt _this(org.omg.CORBA.ORB orb) 
  {
    return NamingContextExtHelper.narrow(
    super._this_object(orb));
  }


} // class NamingContextExtPOA
