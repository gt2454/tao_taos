package com.example.duanwu.tao_taos;

import java.util.List;

public interface IPstener {
     void getImageList();
         interface   ICallback{
             void  success(List<Bean.RecentBean> list);
             void onFail(String   string);
         }
}
