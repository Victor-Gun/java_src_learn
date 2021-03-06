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
 * Copyright (c) 2000 World Wide Web Consortium,
 * (Massachusetts Institute of Technology, Institut National de
 * Recherche en Informatique et en Automatique, Keio University). All
 * Rights Reserved. This program is distributed under the W3C's Software
 * Intellectual Property License. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR
 * PURPOSE.
 * See W3C License http://www.w3.org/Consortium/Legal/ for more details.
 * <p>
 *  版权所有(c)2000万维网联盟,(马萨诸塞理工学院,庆应义藩大学信息自动化研究所)。版权所有。该程序根据W3C的软件知识产权许可证分发。
 * 这个程序是分发的,希望它将是有用的,但没有任何保证;甚至没有对适销性或适用于特定用途的隐含保证。有关详细信息,请参阅W3C许可证http://www.w3.org/Consortium/Legal/。
 * 
 */

package org.w3c.dom.css;

import org.w3c.dom.DOMException;

/**
 *  The <code>CSSStyleRule</code> interface represents a single rule set in a
 * CSS style sheet.
 * <p>See also the <a href='http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113'>Document Object Model (DOM) Level 2 Style Specification</a>.
 * <p>
 *  <code> CSSStyleRule </code>接口表示CSS样式表中的单个规则集。
 *  <p>另请参阅<a href='http://www.w3.org/TR/2000/REC-DOM-Level-2-Style-20001113'>文档对象模型(DOM)2级样式规范< a>。
 * 
 * 
 * @since DOM Level 2
 */
public interface CSSStyleRule extends CSSRule {
    /**
     *  The textual representation of the selector for the rule set. The
     * implementation may have stripped out insignificant whitespace while
     * parsing the selector.
     * <p>
     *  规则集的选择器的文本表示。在解析选择器时,实现可能已经剥离了无关紧要的空格。
     * 
     */
    public String getSelectorText();
    /**
     *  The textual representation of the selector for the rule set. The
     * implementation may have stripped out insignificant whitespace while
     * parsing the selector.
     * <p>
     *  规则集的选择器的文本表示。在解析选择器时,实现可能已经剥离了无关紧要的空格。
     * 
     * 
     * @exception DOMException
     *   SYNTAX_ERR: Raised if the specified CSS string value has a syntax
     *   error and is unparsable.
     *   <br>NO_MODIFICATION_ALLOWED_ERR: Raised if this rule is readonly.
     */
    public void setSelectorText(String selectorText)
                        throws DOMException;

    /**
     *  The declaration-block of this rule set.
     * <p>
     *  此规则集的声明块。
     */
    public CSSStyleDeclaration getStyle();

}
