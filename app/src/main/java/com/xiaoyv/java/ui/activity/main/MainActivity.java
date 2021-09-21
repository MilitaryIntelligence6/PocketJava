package com.xiaoyv.java.ui.activity.main;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xiaoyv.java.R;
import com.xiaoyv.java.base.BaseFragmentActivity;
import com.xiaoyv.java.ui.activity.main.callback.LoadFileCallBack;

import java.io.File;


/**
 * 主页
 *
 * @author 王怀玉
 * @since 2020/2/8
 */
public class MainActivity
        extends BaseFragmentActivity<MainFragment>
        implements LoadFileCallBack {

    public static void start() {
        ActivityUtils.startActivity(MainActivity.class);
    }

    @Override
    protected void createPresenter(MainFragment fragment) {
        new MainPresenter(fragment);
    }

    @Override
    protected MainFragment createFragment() {
        return MainFragment.newInstance();
    }

    @Override
    public void onBackPressed() {
        if (!fragment.onBackPressed()) {
            doubleClickToExit();
        }
    }

    private boolean isExit = false;

    private void doubleClickToExit() {
        if (!isExit) {
            isExit = true;
            ToastUtils.showShort(getString(R.string.tips_twice_again));
            new Handler(getMainLooper()) {
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    isExit = false;
                }
            }.sendEmptyMessageDelayed(0, 2000);
        } else {
            ActivityUtils.finishAllActivities(true);
            AppUtils.exitApp();
        }
    }

    @Override
    public void load(String fileName) {
        fragment.getEditorFragment().getmTextEditor().open(fileName);
    }

    @Override
    public void load(File file) {
        fragment.getEditorFragment().getmTextEditor().open(file);
    }
}
