package com.ixuea.courses.helloixuea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * 这是一个适配器（其实就是一个类）
 * Android中大部分列表都是通过适配器指定数据等信息
 * <p>
 * <ListAdapter.ViewHolder>：这部分是Java泛型
 * 如果大家还不明白，请学习我们的Java基础课程
 * <p>
 * 类似iOS开发中列表的委托（delegate）
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<String> strings;
    private Context context;
    private LayoutInflater inflater;

    public ListAdapter(Context context, List<String> strings) {
        this.strings = strings;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    /**
     * 根据要显示的内容创建一个ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //注意这里，一定要将parent传递到inflate方法
        return new ViewHolder(inflater.inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    /**
     * 将对应的数据显示到ViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(strings.get(position));
    }

    /**
     * 显示多少条内容
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return strings.size();
    }

    /**
     * 创建一个ViewHolder
     * <p>
     * 简单理解为这个控件显示到界面上需要的对象是ViewHolder
     * <p>
     * 为什么要ViewHolder，是因为Android是微型设备，内存和计算能力相对电脑而言较弱
     * 如果一个列表是1万条数据，那么都创建成ViewHolder是特别耗费资源的，而且也没必要
     * 手机屏幕就那么大，同时显示就几十个，所以这个控件维护了一个逻辑时，如果需要显示ViewHolder
     * 他首先会判断是否原来ViewHolder已经不显示了，如果还在显示就新创建，如果不显示了就把原来的拿过来
     * 设置上新的数据，在显示
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView text1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
        }

        public void bind(String data) {
            text1.setText(data);
        }
    }
}
