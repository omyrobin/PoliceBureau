package com.administration.policebureau.api;

import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.CheckInEntity;
import com.administration.policebureau.bean.MessageListEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GetService {

    @GET("registrant")
    Observable<BaseResponse<CheckInEntity>> getCheckInList();

    @GET("message")
    Observable<BaseResponse<MessageListEntity>> getMessage();

    @GET("registrant")
    Observable<BaseResponse<CheckInEntity>> getCheckInById(@QueryMap HashMap<String, String> map);
}