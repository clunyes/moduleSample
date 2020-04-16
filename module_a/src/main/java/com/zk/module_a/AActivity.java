package com.zk.module_a;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.zk.base.base.BaseActivity;
import com.zk.base.constant.ARouterPath;

@Route(path = ARouterPath.MODULEA_AACTIVITY)
public class AActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        //注入传递的参数
        ARouter.getInstance().inject(this);
        Toast.makeText(getApplicationContext(), getIntent().getExtras().getString("param"), Toast.LENGTH_LONG).show();
        TextView tvA = findViewById(R.id.tv_a);
        tvA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARouterPath.MODULEB_BACTIVITY)
                        .withString("param", "我要到B页面").navigation();
            }
        });
    }
    @Override
    public String getTag() {
        return AActivity.class.getCanonicalName();
    }
}
