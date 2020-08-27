package com.bicubic.gincana.utils;

import com.bicubic.gincana.model.NearTour;
import com.bicubic.gincana.model.Signin;
import com.bicubic.gincana.model.TourDetail;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface ApiInterface {


    @Multipart
    @POST("checkLogin.php")
    Call<Signin> CheckSimpleLogin(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("doSignup.php")
    Call<Signin> CheckSimpleRegister(@PartMap Map<String, RequestBody> params);


    @Multipart
    @POST("getAllTourData.php")
    Call<NearTour> getNearestTour(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("getTourFullData.php")
    Call<TourDetail> getTourDetail(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("getTourFullData.php")
    Call<ResponseBody> getTourData(@PartMap Map<String, RequestBody> params);


}
