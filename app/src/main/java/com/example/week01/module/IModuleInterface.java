package com.example.week01.module;

import com.example.week01.bean.Bean;

/**
 * Module层的接口
 * 用于Present与Module之间的接口回调
 */
public interface IModuleInterface {
    void onSuccess(Bean bean);
    void onError(String string);
}
