package com.administration.policebureau.api;

import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.CheckInEntity;


import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

public interface GetService {

    @GET("registrant")
    Observable<Response<BaseResponse<CheckInEntity>>> getCheckInList(@Header("Bearer") String token);

}