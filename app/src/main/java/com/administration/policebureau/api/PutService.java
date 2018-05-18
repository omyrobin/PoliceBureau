package com.administration.policebureau.api;

import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.MessageListEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by wubo on 2018/5/11.
 */

public interface PutService {
    @FormUrlEncoded
    @PUT("message/{id}")
    Observable<BaseResponse<MessageListEntity>> reply(@Path("id") int id, @Field("reply") String reply, @Field("status") int status);
}
