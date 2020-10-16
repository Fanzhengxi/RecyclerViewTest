package com.example.cc.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Fruit> fruitList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView=findViewById(R.id.recycle_view);
        //layoutManager用于指定RecyclerView中使用的布局是线性布局
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        /**把水果数据传入到水果适配器adapter中，
        adapter是FruitAdapter的一个对象，它代表什么呢？，为什么可以直接把它作为参数传给setAdapter(adapter)
         RecylerView中就能加载数据项了呢？
        **/
        FruitAdapter adapter=new FruitAdapter(fruitList);
        //把适配器中的数据传入到RecyclerView中
        recyclerView.setAdapter(adapter);
    }

    private void initFruits() {
        //(1)把一条一条的水果数据传入到fruitList中，
        // (2)在将fruitList传给水果适配器，
        // (3)最后将适配器对象传给RecyclerView
        for (int i=0;i<2;i++){
            Fruit apple=new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana=new Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange=new Fruit("Orange",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon=new Fruit("Watermelon",R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear=new Fruit("Pear",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape=new Fruit("Grape",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple=new Fruit("Pineapple",R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry=new Fruit("Strawberry",R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry=new Fruit("Cherry",R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango=new Fruit("Mango",R.drawable.mango_pic);
            fruitList.add(mango);

        }
    }
}
