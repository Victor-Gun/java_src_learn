/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import java.awt.Dimension;
import javax.swing.plaf.UIResource;


/*
 * A subclass of <code>Dimension</code> that implements
 * <code>UIResource</code>.  UI classes that use
 * <code>Dimension</code> values for default properties
 * should use this class.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans&trade;
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * <p>
 *  实现<code> UIResource </code>的<code> Dimension </code>子类。使用<code> Dimension </code>值作为默认属性的UI类应该使用此类。
 * <p>
 *  <strong>警告：</strong>此类的序列化对象将与以后的Swing版本不兼容。当前的序列化支持适用于运行相同版本的Swing的应用程序之间的短期存储或RMI。
 * 
 * @see javax.swing.plaf.UIResource
 * @author Amy Fowler
 *
 */
public class DimensionUIResource extends Dimension implements UIResource
{
    public DimensionUIResource(int width, int height) {
        super(width, height);
    }
}
