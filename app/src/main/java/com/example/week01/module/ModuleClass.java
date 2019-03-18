package com.example.week01.module;

import com.example.week01.bean.Bean;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * module
 * 用来获取网络数据
 * 获取完网络数据通过接口回调到Present
 */
public class ModuleClass {

    private IModuleInterface iModuleInterface;

    public ModuleClass(IModuleInterface iModuleInterface){
        this.iModuleInterface = iModuleInterface;
    }

    //接收到指令开始获取网络数据
    public void getData(String url, String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);

        retrofitService.getBean(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean bean) {
                        iModuleInterface.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iModuleInterface.onError("获取数据失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
