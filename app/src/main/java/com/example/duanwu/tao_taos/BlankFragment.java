package com.example.duanwu.tao_taos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duanwu.tao_taos.V.IView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment  implements IView {


    private List<Bean.RecentBean> lists;
    private Banner banner;
    private RecyclerView recyclerView;
    private Adapater adapater;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view=inflater.inflate(R.layout.fragment_blank, container, false);
        lists = new ArrayList<>();
        banner = view.findViewById(R.id.banner);
        List  list =new ArrayList();
        list.add(R.mipmap.a);
        list.add(R.mipmap.a2);
        list.add(R.mipmap.a3);
        banner.setImages(list);

        recyclerView = view.findViewById(R.id.rew);
        LinearLayoutManager  linearLayoutManager  =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        adapater = new Adapater(getContext(), lists);
        recyclerView.setAdapter(adapater);
        init();

        return view;
    }

    private void init() {
        IPstener  pstener=new Presterner(this);
        pstener.getImageList();
    }

    @Override
    public void showImageList(List list) {
        lists.addAll(list);
        adapater.notifyDataSetChanged();


    }
}
