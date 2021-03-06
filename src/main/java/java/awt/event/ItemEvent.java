/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.event;

import java.awt.AWTEvent;
import java.awt.ItemSelectable;

/**
 * A semantic event which indicates that an item was selected or deselected.
 * This high-level event is generated by an ItemSelectable object (such as a
 * List) when an item is selected or deselected by the user.
 * The event is passed to every <code>ItemListener</code> object which
 * registered to receive such events using the component's
 * <code>addItemListener</code> method.
 * <P>
 * The object that implements the <code>ItemListener</code> interface gets
 * this <code>ItemEvent</code> when the event occurs. The listener is
 * spared the details of processing individual mouse movements and mouse
 * clicks, and can instead process a "meaningful" (semantic) event like
 * "item selected" or "item deselected".
 * <p>
 * An unspecified behavior will be caused if the {@code id} parameter
 * of any particular {@code ItemEvent} instance is not
 * in the range from {@code ITEM_FIRST} to {@code ITEM_LAST}.
 * <p>
 * The {@code stateChange} of any {@code ItemEvent} instance takes one of the following
 * values:
 *                     <ul>
 *                     <li> {@code ItemEvent.SELECTED}
 *                     <li> {@code ItemEvent.DESELECTED}
 *                     </ul>
 * Assigning the value different from listed above will cause an unspecified behavior.
 *
 * <p>
 *  指示项目已选择或取消选择的语义事件。当用户选择或取消选择项目时,此高级事件由ItemSelectable对象(例如列表)生成。
 * 事件被传递到每个使用组件的<code> addItemListener </code>方法注册接收这些事件的每个<code> ItemListener </code>对象。
 * <P>
 *  实现<code> ItemListener </code>接口的对象在事件发生时获得此<code> ItemEvent </code>。
 * 监听器免除了处理单个鼠标移动和鼠标点击的细节,并且可以代替地处理像"选择的项目"或"取消选择的项目"的"有意义的"(语义)事件。
 * <p>
 *  如果任何特定{@code ItemEvent}实例的{@code id}参数不在{@code ITEM_FIRST}到{@code ITEM_LAST}的范围内,则会导致未指定的行为。
 * <p>
 *  任何{@code ItemEvent}实例的{@code stateChange}都会使用以下值之一：
 * <ul>
 *  <li> {@code ItemEvent.SELECTED} <li> {@code ItemEvent.DESELECTED}
 * </ul>
 *  分配与上述不同的值将导致未指定的行为。
 * 
 * 
 * @author Carl Quinn
 *
 * @see java.awt.ItemSelectable
 * @see ItemListener
 * @see <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/itemlistener.html">Tutorial: Writing an Item Listener</a>
 *
 * @since 1.1
 */
public class ItemEvent extends AWTEvent {

    /**
     * The first number in the range of ids used for item events.
     * <p>
     *  用于项目事件的ids范围中的第一个数字。
     * 
     */
    public static final int ITEM_FIRST          = 701;

    /**
     * The last number in the range of ids used for item events.
     * <p>
     *  用于项事件的ids范围中的最后一个数字。
     * 
     */
    public static final int ITEM_LAST           = 701;

    /**
     * This event id indicates that an item's state changed.
     * <p>
     *  此事件ID指示项目的状态已更改。
     * 
     */
    public static final int ITEM_STATE_CHANGED  = ITEM_FIRST; //Event.LIST_SELECT

    /**
     * This state-change value indicates that an item was selected.
     * <p>
     *  该状态变化值表示选择了项目。
     * 
     */
    public static final int SELECTED = 1;

    /**
     * This state-change-value indicates that a selected item was deselected.
     * <p>
     * 该状态变化值指示所选择的项目被取消选择。
     * 
     */
    public static final int DESELECTED  = 2;

    /**
     * The item whose selection state has changed.
     *
     * <p>
     *  选择状态已更改的项目。
     * 
     * 
     * @serial
     * @see #getItem()
     */
    Object item;

    /**
     * <code>stateChange</code> indicates whether the <code>item</code>
     * was selected or deselected.
     *
     * <p>
     *  <code> stateChange </code>指示是否选择或取消选择<code>项</code>。
     * 
     * 
     * @serial
     * @see #getStateChange()
     */
    int stateChange;

    /*
     * JDK 1.1 serialVersionUID
     * <p>
     *  JDK 1.1 serialVersionUID
     * 
     */
    private static final long serialVersionUID = -608708132447206933L;

    /**
     * Constructs an <code>ItemEvent</code> object.
     * <p> This method throws an
     * <code>IllegalArgumentException</code> if <code>source</code>
     * is <code>null</code>.
     *
     * <p>
     *  构造一个<code> ItemEvent </code>对象。
     *  <p>如果<code> source </code>是<code> null </code>,此方法会抛出<code> IllegalArgumentException </code>。
     * 
     * 
     * @param source The <code>ItemSelectable</code> object
     *               that originated the event
     * @param id           The integer that identifies the event type.
     *                     For information on allowable values, see
     *                     the class description for {@link ItemEvent}
     * @param item   An object -- the item affected by the event
     * @param stateChange  An integer that indicates whether the item was
     *               selected or deselected.
     *                     For information on allowable values, see
     *                     the class description for {@link ItemEvent}
     * @throws IllegalArgumentException if <code>source</code> is null
     * @see #getItemSelectable()
     * @see #getID()
     * @see #getStateChange()
     */
    public ItemEvent(ItemSelectable source, int id, Object item, int stateChange) {
        super(source, id);
        this.item = item;
        this.stateChange = stateChange;
    }

    /**
     * Returns the originator of the event.
     *
     * <p>
     *  返回事件的发起者。
     * 
     * 
     * @return the ItemSelectable object that originated the event.
     */
    public ItemSelectable getItemSelectable() {
        return (ItemSelectable)source;
    }

   /**
    * Returns the item affected by the event.
    *
    * <p>
    *  返回受事件影响的项目。
    * 
    * 
    * @return the item (object) that was affected by the event
    */
    public Object getItem() {
        return item;
    }

   /**
    * Returns the type of state change (selected or deselected).
    *
    * <p>
    *  返回状态更改的类型(选择或取消选择)。
    * 
    * 
    * @return an integer that indicates whether the item was selected
    *         or deselected
    *
    * @see #SELECTED
    * @see #DESELECTED
    */
    public int getStateChange() {
        return stateChange;
    }

    /**
     * Returns a parameter string identifying this item event.
     * This method is useful for event-logging and for debugging.
     *
     * <p>
     *  返回标识此项事件的参数字符串。此方法对事件记录和调试非常有用。
     * 
     * @return a string identifying the event and its attributes
     */
    public String paramString() {
        String typeStr;
        switch(id) {
          case ITEM_STATE_CHANGED:
              typeStr = "ITEM_STATE_CHANGED";
              break;
          default:
              typeStr = "unknown type";
        }

        String stateStr;
        switch(stateChange) {
          case SELECTED:
              stateStr = "SELECTED";
              break;
          case DESELECTED:
              stateStr = "DESELECTED";
              break;
          default:
              stateStr = "unknown type";
        }
        return typeStr + ",item="+item + ",stateChange="+stateStr;
    }

}
