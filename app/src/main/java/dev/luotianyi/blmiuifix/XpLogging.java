package dev.luotianyi.blmiuifix;

import android.util.Log;

import de.robv.android.xposed.XposedBridge;

public class XpLogging {
    public static void log(String content) {
        XposedBridge.log(String.format("[BLMIUI Fix] %s", content));
        Log.w("XpLogging", content);
    }

    public static void injectClassSuccess(String classname) {
        log(String.format("成功注入 Class：%s", classname));
    }

    public static void injectMethodSuccess(String classname, String method) {
        log(String.format("成功注入 Method：%s#[%s]", classname, method));
    }

    public static void injectLayoutSuccess(String layout, String method) {
        log(String.format("成功注入 Layout：%s#[%s]", layout, method));
    }
}
