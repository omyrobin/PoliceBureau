package com.administration.policebureau.api;

import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.CheckInEntity;
import com.administration.policebureau.bean.MessageListEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface GetService {

    @GET("registrant")
    Observable<BaseResponse<CheckInEntity>> getCheckInList();

    @GET("message")
    Observable<BaseResponse<MessageListEntity>> getMessage();

    @GET("registrant")
    Observable<BaseResponse<CheckInEntity>> getCheckInById(@QueryMap HashMap<String, String> map);

    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String  fileUrl, @Query("type") String type);
}