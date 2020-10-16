package com.example.cc.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * 这个类用于把从MainActivity中传过来的fruitList数据，传入到fruit_item.xml中
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        //构造器
        public ViewHolder(View itemView) {
            super(itemView);
            fruitImage=itemView.findViewById(R.id.fruit_image);
            fruitName=itemView.findViewById(R.id.fruit_name);
        }
    }
    //用于把要展示的数据源传进来，并赋给一个全局变量mFruitList,我们后续的操作都在这个数据源的基础上进行
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList=fruitList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载fruit_item.xml布局
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        //把加载出来的布局传到构造函数中
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }


    //到此为止，fruit_item布局中的两个变量fruitImage，fruitName都可以通过holder操作，
    // 因为这两个变量是ViewHolder类中的两个变量，而holder是ViewHolder的实例对象

    /**
     * 用于对RecycleView中的子项赋值,会在每个子项滚到屏幕内时执行，子项都存在fruit_item.xml中
     * 通过参数position得到当前项的Fruit实例，然后再使用holder给当前项赋值
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      Fruit fruit=mFruitList.get(position);
      holder.fruitImage.setImageResource(fruit.getImageId());
      holder.fruitName.setText(fruit.getName());
    }
//统计一共有多少子项
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}
