package com.example.week01.module;

import com.example.week01.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * 用于获取网络数据的接口
 */
public interface RetrofitService {
    @GET
    Observable<Bean> getBean(@Url String url);
}
