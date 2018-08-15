package com.succ7.knowcar.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast统一管理工具类
 *
 * @author zhongcj
 * @time 2015-1-17 下午2:50:42
 */
public class ToastUtils {

    private ToastUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 是否显示Toast,方便调试,可以在application的onCreate函数里面初始化
     */
    public static boolean isShow = true;

    /**
     * 短时间显示Toast
     *
     * @param context 上下文
     * @param message 显示的信息(传入字符串)
     * @author zhongcj
     */
    public static void showShortToast(Context context, CharSequence message) {
        if (isShow)
            //之所以将context转化成context.getApplicationContext(),是为了避免设置了
            // <item name="android:fitsSystemWindows">true</item>主题后,显示没有了padding
            Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 短时间显示Toast
     *
     * @param context  上下文
     * @param msgResId (传入字符串的资源id)
     * @author zhongcj
     */
    public static void showShortToast(Context context, int msgResId) {
        if (isShow)
            Toast.makeText(context.getApplicationContext(), msgResId, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context 上下文
     * @param message 显示的信息(传入字符串)
     * @author zhongcj
     */
    public static void showLongToast(Context context, CharSequence message) {
        if (isShow)
            Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context  上下文
     * @param msgResId (传入字符串的资源id)
     * @author zhongcj
     */
    public static void showLongToast(Context context, int msgResId) {
        if (isShow)
            Toast.makeText(context.getApplicationContext(), msgResId, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context  上下文
     * @param message  显示的信息(传入字符串)
     * @param duration Either LENGTH_SHORT or LENGTH_LONG
     * @author zhongcj
     */
    public static void showToast(Context context, CharSequence message, int duration) {
        if (isShow)
            Toast.makeText(context.getApplicationContext(), message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context  上下文
     * @param msgResId (传入字符串的资源id)
     * @param duration Either LENGTH_SHORT or LENGTH_LONG
     * @author zhongcj
     */
    public static void showToast(Context context, int msgResId, int duration) {
        if (isShow)
            Toast.makeText(context.getApplicationContext(), msgResId, duration).show();
    }
}