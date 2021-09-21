package com.xiaoyv.java.ui.activity.main.callback;

import java.io.File;

/**
 * @author Military Intelligence 6 root
 * @version 1.0.0
 * @ClassName LoadFileInterface
 * @Description TODO
 * @CreateTime 2021年09月20日 21:28:00
 */
public interface LoadFileCallBack {

    /**
     * project fragment 中点击文件, 展示到 editor 里;
     */
    void load(String fileName);

    void load(File file);
}
