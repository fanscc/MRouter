package com.wuba.mobile.middle.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.wuba.mis.router.apt.SampleRouteTable;
import com.wuba.mobile.annotation.Route;
import com.wuba.mobile.middle.mis.protocol.router.RouteStatus;
import com.wuba.mobile.middle.mis.protocol.router.Router;
import com.wuba.mobile.middle.mis.protocol.router.RouterCallback;
import com.wuba.mobile.middle.mis.protocol.router.table.RouteTable;

import java.util.Map;

/**
 * author : wangqiang
 * date : 2018/8/15
 * desc :
 */
@Route(path = "/im/main")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态添加路由表
        Router.handleRouteTable(new SampleRouteTable());

        this.findViewById(R.id.main_jump_to_First).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.build("/im/first").callback(new RouterCallback() {
                    @Override
                    public void callback(RouteStatus status, Uri uri, String message) {

                    }
                }).with("args", "hello ,word!").go(MainActivity.this);
            }
        });

        this.findViewById(R.id.main_jump_to_Sencond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.build("/im/second").requestCode(100).callback(new RouterCallback() {
                    @Override
                    public void callback(RouteStatus status, Uri uri, String message) {

                    }
                }).with("args", "hello ,word2!").go(MainActivity.this);
            }
        });

        this.findViewById(R.id.main_jump_to_third).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.build("/im/third").go(MainActivity.this);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 100) {
            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_LONG).show();
        }
    }
}
