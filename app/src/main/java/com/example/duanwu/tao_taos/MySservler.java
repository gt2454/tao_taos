package com.example.duanwu.tao_taos;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MySservler {
    String  url="http://news-at.zhihu.com/api/4/";
    @GET("news/hot ")
    Observable<Bean>  getImage();
}
