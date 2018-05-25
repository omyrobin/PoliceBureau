package com.administration.policebureau.http;


import android.app.ProgressDialog;
import android.content.Context;

import com.administration.policebureau.App;
import com.administration.policebureau.R;
import com.administration.policebureau.util.NetworkUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by omyrobin on 2017/01/04 15:49.
 */

public abstract class ProgressSubscriber<T> implements ProgressCancelListener, Observer<T> {


    private ProgressDialog dialogHandler;

    private Context context;

    private boolean show;

    private Disposable disposable;

    public ProgressSubscriber(Context context) {
        this.context = context;
        //TODO create dialog to show
    }

    public ProgressSubscriber(Context context, boolean show) {
        this.context = context;
        this.show = show;
        //TODO create dialog to show
        dialogHandler = new ProgressDialog(context);
        dialogHandler.setMessage(context.getString(R.string.uploading));
    }

    /**
     * 显示Dialog
     */
    public void showProgressDialog(){
        if (dialogHandler != null && show) {
            dialogHandler.show();
        }
    }

    /**
     * 隐藏Dialog
     */
    private void dismissProgressDialog(){
        if (dialogHandler != null && show) {
            dialogHandler.dismiss();
            dialogHandler=null;
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        disposable = d;
    }

    @Override
    public void onComplete() {
        dismissProgressDialog();
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (!NetworkUtil.isConnected(App.getInstance().getApplicationContext())) {
            onFailure(context.getString(R.string.network_is_not_available));
        } else if (e instanceof RuntimeException) {
            onFailure(e.getMessage());
        } else {
            onFailure(context.getString(R.string.request_failed));
        }
        dismissProgressDialog();
    }


    @Override
    public void onCancelProgress() {
        if(disposable.isDisposed()){
            disposable.dispose();
        }
    }

    protected abstract void onSuccess(T t);

    protected abstract void onFailure(String message);
}
