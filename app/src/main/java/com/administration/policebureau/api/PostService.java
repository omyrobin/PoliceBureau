package com.administration.policebureau.api;


import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.UserEntity;

import java.util.HashMap;

import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by omyrobin on 2017/4/16.
 */

public interface PostService {

    @FormUrlEncoded
    @POST("login")
    Observable<Response<BaseResponse<UserEntity>>> registerUser(@FieldMap HashMap<String, String> map);
}
