package com.zk.base.base;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zk.base.BuildConfig;

public class BaseApplication extends Application {
    private static BaseApplication sApplication;

    public static BaseApplication getApplication() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        ARouter.getInstance().destroy();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {  // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();    // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);// 尽可能早，推荐在Application中初始化
    }
}
