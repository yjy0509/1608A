package com.example.week01.view;

import com.example.week01.bean.Bean;

/**
 * View层的接口
 * 用于View与Present之间的接口回调
 */

public interface IViewInterface {
    void onSuccess(Bean bean);
    void onError(String string);
}
