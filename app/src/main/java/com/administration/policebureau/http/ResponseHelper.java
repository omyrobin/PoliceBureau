package com.administration.policebureau.http;

import com.administration.policebureau.bean.BaseResponse;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class ResponseHelper {

    public static <T> ObservableTransformer<BaseResponse<T>, T> transformerResult() {
        return new ObservableTransformer<BaseResponse<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseResponse<T>> upstream) {
                return upstream.flatMap(new Function<BaseResponse<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(BaseResponse<T> tBaseResponse) throws Exception {
                        if (tBaseResponse.getCode() == 0) {
                            return createData(tBaseResponse.getData());
                        } else {
                            return Observable.error(new RuntimeException(tBaseResponse.getMsg()));
                        }
                    }
                }).subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    private static <T> Observable<T> createData(final T data) {
        return new Observable<T>() {
            @Override
            protected void subscribeActual(Observer<? super T> observer) {
                try {
                    observer.onNext(data);
                    observer.onComplete();
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        };
    }
}