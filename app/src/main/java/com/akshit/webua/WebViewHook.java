package com.akshit.webua;

import android.webkit.WebSettings;
import de.robv.android.xposed.*;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class WebViewHook implements IXposedHookLoadPackage {
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        XposedHelpers.findAndHookMethod(WebSettings.class, "setUserAgentString", String.class, new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) {
                String ua = "Mozilla/5.0 (Linux; Android 13; LSPosedCustom) AppleWebKit/537.36 Chrome/114.0.0.0 Mobile Safari/537.36";
                param.args[0] = ua;
                return null;
            }
        });
    }
}