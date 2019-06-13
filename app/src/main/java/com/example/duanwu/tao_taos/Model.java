package com.example.duanwu.tao_taos;

import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements   IModel{
    @Override
    public void mGetImageList(final IPstener.ICallback callback) {

        Retrofit  retrofit  =new Retrofit.Builder()
                .baseUrl(MySservler.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MySservler mySservler = retrofit.create(MySservler.class);
        Observable<Bean> image = mySservler.getImage();
            image.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Bean>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(Bean bean) {
                            if(bean.getRecent().size()!=0) {
                                List<Bean.RecentBean> data = bean.getRecent();
                                callback.success(data);
                            }

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e("=========",e.getMessage());

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
}
