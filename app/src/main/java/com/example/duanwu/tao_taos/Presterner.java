package com.example.duanwu.tao_taos;

import com.example.duanwu.tao_taos.V.IView;

import java.util.List;

public class Presterner  implements  IPstener,IPstener.ICallback{
     private IModel  mdeol;
         private IView view;
         public    Presterner  (IView  view){
             this.view=view;
             mdeol=new Model();
         }
         @Override
         public void getImageList() {
             mdeol.mGetImageList(this);
         }

         @Override
         public void success(List<Bean.DataBean> list) {
             if(this.view!=null){
                 this.view.showImageList(list);

             }

         }

         @Override
         public void onFail(String string) {

         }
}
