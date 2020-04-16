package com.zk.module_main;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.zk.base.base.BaseActivity;
import com.zk.base.constant.ARouterPath;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.d(getTag(),"onCreate");
        setContentView(R.layout.activity_main);
        TextView tv_main = findViewById(R.id.tv_main);
        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.MODULEA_AACTIVITY).navigation();
            }
        });
    }


    @Override
    public String getTag() {
        return MainActivity.class.getCanonicalName();
    }
}
