package dev.luotianyi.blmiuifix.Hooks;

import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import dev.luotianyi.blmiuifix.XpLogging;

public class HideNavbarHook implements IXposedHookLoadPackage {
    public static String HOOKING_PACKAGE_NAME = "com.bilibili.app.in";
    public static String HOOKING_CLASS_NAME = "android.widget.FrameLayout";
    public static String HOOKING_METHOD_NAME = "onLayout";
    public static String HOOKING_LAYOUT_NAME = "com.bilibili.app.in:id/videoview_container";

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals(HOOKING_PACKAGE_NAME)) return;
        Class hookingClass = loadPackageParam.classLoader.loadClass(HOOKING_CLASS_NAME);
        XpLogging.injectClassSuccess(HOOKING_CLASS_NAME);

        XposedHelpers.findAndHookMethod(hookingClass, HOOKING_METHOD_NAME,
            /* Method Arg Types*/ boolean.class, int.class, int.class, int.class, int.class,
            getMethodHook());
    }

    private XC_MethodHook getMethodHook() {
        return new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                XpLogging.injectMethodSuccess("Method", HOOKING_METHOD_NAME);
                FrameLayout layout = (FrameLayout) param.thisObject;
                if (!getViewNameByItself(layout).equals(HOOKING_LAYOUT_NAME)) return;
                XpLogging.injectLayoutSuccess(HOOKING_LAYOUT_NAME, HOOKING_METHOD_NAME);
                doFrameLayoutChange(layout);
                super.afterHookedMethod(param);
            }
        };
    }

    private void doFrameLayoutChange(FrameLayout layout) {
        DisplayMetrics dm = layout.getContext().getResources().getDisplayMetrics();
        XpLogging.log(String.format("?????????????????? %sx%s", dm.widthPixels, dm.heightPixels));
        // ??????????????????
        //     ??? Redmi K30 Pro ??????
        //             W       H
        // ????????????    1080    2270
        // ????????????    2270    1080
        // ????????????    1080     607
        // ????????????    2400    1080    --?????? device_W > device_H ????????????
        // ????????????    1080    1417
        // ????????????    1080    2240
        int height = layout.getHeight();
        int width = layout.getWidth();
        int systemUiVisibilityFlag;
        if ((dm.widthPixels <= dm.heightPixels) && (height < (dm.heightPixels * 0.8))) {
            systemUiVisibilityFlag = View.SYSTEM_UI_FLAG_VISIBLE;
        } else {
            systemUiVisibilityFlag =
                View.SYSTEM_UI_FLAG_IMMERSIVE |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        }

        layout.setSystemUiVisibility(systemUiVisibilityFlag);
        XpLogging.log(String.format("?????? Layout ????????? %sx%s ???????????? setSystemUiVisibility(%s)", width, height, systemUiVisibilityFlag));
    }

    private String getViewNameByItself(View view) {
        try {
            return view.getResources().getResourceName(view.getId());
        } catch (Exception e) {
            return "";
        }

    }
}
