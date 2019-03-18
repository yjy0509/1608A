package com.example.week01.present;

import com.example.week01.bean.Bean;
import com.example.week01.module.IModuleInterface;
import com.example.week01.module.ModuleClass;
import com.example.week01.view.IViewInterface;

/**
 * present用来传递数据
 * 当数据传过来时通过接口回调到View
 */
public class MyPresent implements IModuleInterface {

    IViewInterface iViewInterface;
    ModuleClass moduleClass = new ModuleClass(this);

    public MyPresent(IViewInterface iViewInterface){
        this.iViewInterface = iViewInterface;
    }

    //接收到指令传递给Module层
    public void getData(String url,String baseUrl){
        moduleClass.getData(url,baseUrl);
    }

    @Override
    public void onSuccess(Bean bean) {
        iViewInterface.onSuccess(bean);
    }

    @Override
    public void onError(String string) {
        iViewInterface.onError(string);
    }
}
