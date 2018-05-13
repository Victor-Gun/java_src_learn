/***** Lobxxx Translate Finished ******/
package org.omg.DynamicAny;


/**
* org/omg/DynamicAny/DynValueBoxOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u45/3627/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Thursday, April 30, 2015 12:42:08 PM PDT
*/


/**
    * DynValueBox objects support the manipulation of IDL boxed value types.
    * The DynValueBox interface can represent both null and non-null value types.
    * For a DynValueBox representing a non-null value type, the DynValueBox has a single component
    * of the boxed type. A DynValueBox representing a null value type has no components
    * and a current position of -1.
    * <p>
    *  DynValueBox对象支持对IDL盒装值类型的操作。 DynValueBox接口可以表示null和非null值类型。
    * 对于表示非空值类型的DynValueBox,DynValueBox具有盒装类型的单个组件。表示空值类型的DynValueBox没有组件,当前位置为-1。
    * 
    */
public interface DynValueBoxOperations  extends org.omg.DynamicAny.DynValueCommonOperations
{

  /**
        * Returns the boxed value as an Any.
        *
        * <p>
        *  以"Any"返回带框值。
        * 
        * 
        * @exception InvalidValue if this object represents a null value box type
        */
  org.omg.CORBA.Any get_boxed_value () throws org.omg.DynamicAny.DynAnyPackage.InvalidValue;

  /**
        * Replaces the boxed value with the specified value.
        * If the DynBoxedValue represents a null valuetype, it is converted to a non-null value.
        *
        * <p>
        *  将指定值替换为盒装值。如果DynBoxedValue表示空值类型,那么它将转换为非空值。
        * 
        * 
        * @exception TypeMismatch if this object represents a non-null value box type and the type
        *            of the parameter is not matching the current boxed value type.
        */
  void set_boxed_value (org.omg.CORBA.Any boxed) throws org.omg.DynamicAny.DynAnyPackage.TypeMismatch;

  /**
        * Returns the boxed value as a DynAny.
        *
        * <p>
        *  以DynAny形式返回加框值。
        * 
        * 
        * @exception InvalidValue if this object represents a null value box type
        */
  org.omg.DynamicAny.DynAny get_boxed_value_as_dyn_any () throws org.omg.DynamicAny.DynAnyPackage.InvalidValue;

  /**
        * Replaces the boxed value with the value contained in the parameter.
        * If the DynBoxedValue represents a null valuetype, it is converted to a non-null value.
        *
        * <p>
        *  将包装的值替换为参数中包含的值。如果DynBoxedValue表示空值类型,那么它将转换为非空值。
        * 
        * @exception TypeMismatch if this object represents a non-null value box type and the type
        *            of the parameter is not matching the current boxed value type.
        */
  void set_boxed_value_as_dyn_any (org.omg.DynamicAny.DynAny boxed) throws org.omg.DynamicAny.DynAnyPackage.TypeMismatch;
} // interface DynValueBoxOperations
