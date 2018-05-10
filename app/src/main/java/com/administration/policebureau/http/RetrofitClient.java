package com.administration.policebureau.http;


import com.administration.policebureau.bean.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import retrofit2.Response;

/**
 * Created by omyrobin on 2017/4/13.
 */

public class RetrofitClient {

    private static volatile RetrofitClient client;

    public static RetrofitClient client(){
        if(client == null){
            synchronized (RetrofitClient.class){
                if(client == null){
                    client = new RetrofitClient();
                }
            }
        }
        return client;
    }

    public <T> void request(Observable<BaseResponse<T>> ob, final ProgressSubscriber<T> subscriber){
        //数据预处理
        ObservableTransformer<BaseResponse<T>, T> result = ResponseHelper.transformerResult();
        ob.compose(result)
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        subscriber.showProgressDialog();
                    }
                })
                .subscribe(subscriber);
    }
}
