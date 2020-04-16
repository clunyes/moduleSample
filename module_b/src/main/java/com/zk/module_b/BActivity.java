package com.zk.module_b;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zk.base.base.BaseActivity;
import com.zk.base.constant.ARouterPath;

@Route(path = ARouterPath.MODULEB_BACTIVITY)
public class BActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        //注入传递的参数
        Toast.makeText(getApplicationContext(), getIntent().getExtras().getString("param"), Toast.LENGTH_LONG).show();
    }
    @Override
    public String getTag() {
        return BActivity.class.getCanonicalName();
    }
}
