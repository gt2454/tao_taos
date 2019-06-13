package com.example.duanwu.tao_taos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class Adapater  extends RecyclerView.Adapter{
    Context  context;
    List<Bean.RecentBean> list =new ArrayList<>();

    public Adapater(Context context, List<Bean.RecentBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=null;
        RecyclerView.ViewHolder holder=null;
        if(viewType==1){
            v= LayoutInflater.from(context).inflate(R.layout.item1,parent,false);
            holder=new ViewHolder(v);
        }
        if(viewType==2){
            v= LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
            holder=new ViewHolder2(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==1){
            ViewHolder holder1= (ViewHolder) holder;
            holder1.t1.setText(list.get(position).getTitle());

            holder1.i1.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getThumbnail()).into(holder1.s1);
        }
        if(itemViewType==2){
            ViewHolder2 holder1= (ViewHolder2) holder;
            holder1.t2.setText(list.get(position).getTitle());

            holder1.i2.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getThumbnail()).into(holder1.s2);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.onItemClick(v,position);

                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView i1;
        private TextView t1;
        private final ImageView s1;

        public ViewHolder(View itemView) {
            super(itemView);
            i1 = itemView.findViewById(R.id.text1);
            t1 = itemView.findViewById(R.id.text1_1);
            s1 = itemView.findViewById(R.id.image);
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder{
        private TextView i2;
        private TextView t2;
        private final ImageView s2;

        public ViewHolder2(View itemView) {
            super(itemView);
            i2 = itemView.findViewById(R.id.text2);
            t2 = itemView.findViewById(R.id.text2_2);
            s2 = itemView.findViewById(R.id.image2);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return 1;
        }else{
            return 2;
        }
    }
 private OnItemCLickListener mListener;
 public interface OnItemCLickListener{
         void onItemClick(View v,int position);
        // void onLongClick(View v,int  position);
     }

     public void setOnItemCLickListener(OnItemCLickListener listener){
         this.mListener = listener;
     }



}
