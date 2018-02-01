package com.administration.policebureau.api;

import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.CheckInEntity;
import com.administration.policebureau.bean.MessageInfoEntity;
import com.administration.policebureau.bean.MessageListEntity;


import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

public interface GetService {

    @GET("registrant")
    Observable<Response<BaseResponse<CheckInEntity>>> getCheckInList(@Header("Authorization") String token);

    @GET("message")
    Observable<Response<BaseResponse<MessageListEntity>>> getMessage(@Header("Authorization") String token);
}