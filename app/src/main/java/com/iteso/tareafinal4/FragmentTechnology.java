package com.iteso.tareafinal4;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.tareafinal4.beans.ItemProduct;

import java.util.ArrayList;
import java.util.Iterator;

public class FragmentTechnology extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ItemProduct> myDataSet = new ArrayList<ItemProduct>();

    public FragmentTechnology() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView)
                view.findViewById(R.id.fragment_technology_recycler_view);
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        ItemProduct itemProduct = new ItemProduct();
        itemProduct.setCode(0);
        itemProduct.setTitle("MacBook Pro 17");
        itemProduct.setStore("BestBuy");
        itemProduct.setLocation("Zapopan, Jalisco");
        itemProduct.setPhone("33 12345678");
        itemProduct.setImage(0);
        itemProduct.setDescription("Llevate esta Mac con un 30% de descuento para que puedas programar para XCode y Android sin tener que batallar tanto como en tu Windows");
        myDataSet.add(itemProduct);
        ItemProduct itemProduct1 = new ItemProduct();
        itemProduct1.setCode(1);
        itemProduct1.setTitle("Alienware Mod10122");
        itemProduct1.setStore("Andares");
        itemProduct1.setLocation("Zapopan, Jalisco");
        itemProduct1.setPhone("33 12345678");
        itemProduct1.setImage(1);
        itemProduct1.setDescription("Llevate esta Alienware con un 30% de descuento!!");
        myDataSet.add(itemProduct1);


        mAdapter = new AdapterProduct(getActivity(), myDataSet);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct newProduct = data.getParcelableExtra("PRODUCTO");
        int position = 0;
        Iterator<ItemProduct> iterator = myDataSet.iterator();
        while(iterator.hasNext()) {
            ItemProduct item = iterator.next();
            if(item.getCode()==newProduct.getCode()){
                myDataSet.set(position,newProduct);
                break;
            }
            position++;
        }
        mAdapter.notifyDataSetChanged();
    }
}
