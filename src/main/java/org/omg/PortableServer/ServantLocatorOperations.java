/***** Lobxxx Translate Finished ******/
package org.omg.PortableServer;


/**
* org/omg/PortableServer/ServantLocatorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u45/3627/corba/src/share/classes/org/omg/PortableServer/poa.idl
* Thursday, April 30, 2015 12:42:10 PM PDT
*/


/**
	 * When the POA has the NON_RETAIN policy it uses servant 
	 * managers that are ServantLocators. Because the POA 
	 * knows that the servant returned by this servant 
	 * manager will be used only for a single request, 
	 * it can supply extra information to the servant 
	 * manager's operations and the servant manager's pair 
	 * of operations may be able to cooperate to do 
	 * something different than a ServantActivator. 
	 * When the POA uses the ServantLocator interface, 
	 * immediately after performing the operation invocation 
	 * on the servant returned by preinvoke, the POA will 
	 * invoke postinvoke on the servant manager, passing the 
	 * ObjectId value and the Servant value as parameters 
	 * (among others). This feature may be used to force 
	 * every request for objects associated with a POA to 
	 * be mediated by the servant manager.
	 * <p>
	 *  当POA具有NON_RETAIN策略时,它使用作为ServantLocator的servant管理器。
	 * 因为POA知道由此仆人管理器返回的服务人员将仅用于单个请求,所以它可以向服务方管理器的操作提供额外的信息,并且服务方管理器的操作对可能能够合作以执行与ServantActivator不同的操作。
	 * 当POA使用ServantLocator接口时,在对preinvoke返回的servant执行操作调用之后,POA将立即在servant管理器上调用postinvoke,并将ObjectId值和Serv
	 * ant值作为参数传递。
	 * 因为POA知道由此仆人管理器返回的服务人员将仅用于单个请求,所以它可以向服务方管理器的操作提供额外的信息,并且服务方管理器的操作对可能能够合作以执行与ServantActivator不同的操作。
	 * 该特征可以用于强制对与POA相关联的对象的每个请求由服务方管理器介导。
	 * 
	 */
public interface ServantLocatorOperations  extends org.omg.PortableServer.ServantManagerOperations
{

  /**
	 * This operations is used to get a servant that will be
	 * used to process the request that caused preinvoke to
	 * be called.
	 * <p>
	 * 
	 * @param oid the object id associated with object on
	 *            which the request was made. 
	 * @param adapter the reference for POA in which the
	 *                object is being activated.
	 * @param operation the operation name.
	 * @param the_cookie  an opaque value that can be set
	 *                    by the servant manager to be used
	 *                    during postinvoke.
	 * @return Servant used to process incoming request.
	 * @exception ForwardRequest to indicate to the ORB 
	 *            that it is responsible for delivering 
	 *            the current request and subsequent 
	 *            requests to the object denoted in the 
	 *            forward_reference member of the exception.
	 */
  org.omg.PortableServer.Servant preinvoke (byte[] oid, org.omg.PortableServer.POA adapter, String operation, org.omg.PortableServer.ServantLocatorPackage.CookieHolder the_cookie) throws org.omg.PortableServer.ForwardRequest;

  /**
	 * This operation is invoked whenener a servant completes
	 * a request.
	 * <p>
	 *  此操作用于获取将用于处理导致preinvoke被调用的请求的服务方。
	 * 
	 * 
	 * @param oid the object id ssociated with object on which
	 *            the request was made.
	 * @param adapter the reference for POA in which the
	 *                object was active.
	 * @param the_cookie  an opaque value that contains
	 *                    the data set by preinvoke.
	 * @param the_servant reference to the servant that is
	 *                    associated with the object.
	 */
  void postinvoke (byte[] oid, org.omg.PortableServer.POA adapter, String operation, java.lang.Object the_cookie, org.omg.PortableServer.Servant the_servant);
} // interface ServantLocatorOperations
