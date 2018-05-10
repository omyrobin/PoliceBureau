package com.administration.policebureau.api;


import com.administration.policebureau.bean.BaseResponse;
import com.administration.policebureau.bean.UserEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by omyrobin on 2017/4/16.
 */

public interface PostService {

    @FormUrlEncoded
    @POST("login")
    Observable<BaseResponse<UserEntity>> registerUser(@FieldMap HashMap<String, String> map);
}
