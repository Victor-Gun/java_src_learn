/***** Lobxxx Translate Finished ******/
/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package java.util.spi;

import java.util.Locale;

/**
 * An abstract class for service providers that
 * provide localized time zone names for the
 * {@link java.util.TimeZone TimeZone} class.
 * The localized time zone names available from the implementations of
 * this class are also the source for the
 * {@link java.text.DateFormatSymbols#getZoneStrings()
 * DateFormatSymbols.getZoneStrings()} method.
 *
 * <p>
 *  为{@link java.util.TimeZone TimeZone}类提供本地化时区名称的服务提供程序的抽象类。
 * 可以从此类的实现中获得的本地化时区名称也是{@link java.text.DateFormatSymbols#getZoneStrings()DateFormatSymbols.getZoneStrings()}
 * 方法的源。
 *  为{@link java.util.TimeZone TimeZone}类提供本地化时区名称的服务提供程序的抽象类。
 * 
 * 
 * @since        1.6
 */
public abstract class TimeZoneNameProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     * <p>
     *  唯一构造函数。 (对于子类构造函数的调用,通常是隐式的。)
     * 
     */
    protected TimeZoneNameProvider() {
    }

    /**
     * Returns a name for the given time zone ID that's suitable for
     * presentation to the user in the specified locale. The given time
     * zone ID is "GMT" or one of the names defined using "Zone" entries
     * in the "tz database", a public domain time zone database at
     * <a href="ftp://elsie.nci.nih.gov/pub/">ftp://elsie.nci.nih.gov/pub/</a>.
     * The data of this database is contained in a file whose name starts with
     * "tzdata", and the specification of the data format is part of the zic.8
     * man page, which is contained in a file whose name starts with "tzcode".
     * <p>
     * If <code>daylight</code> is true, the method should return a name
     * appropriate for daylight saving time even if the specified time zone
     * has not observed daylight saving time in the past.
     *
     * <p>
     *  返回适合在指定区域设置中向用户显示的给定时区ID的名称。
     * 给定的时区ID是"GMT"或使用"tz数据库"中的"Zone"条目定义的名称之一,公共领域时区数据库位于<a href ="ftp://elsie.nci.nih.gov /pub/">ftp://el
     * sie.nci.nih.gov/pub/ </a>。
     *  返回适合在指定区域设置中向用户显示的给定时区ID的名称。
     * 该数据库的数据包含在名称以"tzdata"开头的文件中,数据格式的规范是zic.8手册页的一部分,zic.8手册页包含在名称以"tzcode"开头的文件中。
     * <p>
     *  如果<code> daylight </code>为true,则即使指定的时区没有遵守过去的夏令时,该方法应返回适合夏令时的名称。
     * 
     * 
     * @param ID a time zone ID string
     * @param daylight if true, return the daylight saving name.
     * @param style either {@link java.util.TimeZone#LONG TimeZone.LONG} or
     *    {@link java.util.TimeZone#SHORT TimeZone.SHORT}
     * @param locale the desired locale
     * @return the human-readable name of the given time zone in the
     *     given locale, or null if it's not available.
     * @exception IllegalArgumentException if <code>style</code> is invalid,
     *     or <code>locale</code> isn't one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @exception NullPointerException if <code>ID</code> or <code>locale</code>
     *     is null
     * @see java.util.TimeZone#getDisplayName(boolean, int, java.util.Locale)
     */
    public abstract String getDisplayName(String ID, boolean daylight, int style, Locale locale);

    /**
     * Returns a generic name for the given time zone {@code ID} that's suitable
     * for presentation to the user in the specified {@code locale}. Generic
     * time zone names are neutral from standard time and daylight saving
     * time. For example, "PT" is the short generic name of time zone ID {@code
     * America/Los_Angeles}, while its short standard time and daylight saving
     * time names are "PST" and "PDT", respectively. Refer to
     * {@link #getDisplayName(String, boolean, int, Locale) getDisplayName}
     * for valid time zone IDs.
     *
     * <p>The default implementation of this method returns {@code null}.
     *
     * <p>
     * 
     * @param ID a time zone ID string
     * @param style either {@link java.util.TimeZone#LONG TimeZone.LONG} or
     *    {@link java.util.TimeZone#SHORT TimeZone.SHORT}
     * @param locale the desired locale
     * @return the human-readable generic name of the given time zone in the
     *     given locale, or {@code null} if it's not available.
     * @exception IllegalArgumentException if <code>style</code> is invalid,
     *     or <code>locale</code> isn't one of the locales returned from
     *     {@link LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @exception NullPointerException if <code>ID</code> or <code>locale</code>
     *     is {@code null}
     * @since 1.8
     */
    public String getGenericDisplayName(String ID, int style, Locale locale) {
        return null;
    }
}
