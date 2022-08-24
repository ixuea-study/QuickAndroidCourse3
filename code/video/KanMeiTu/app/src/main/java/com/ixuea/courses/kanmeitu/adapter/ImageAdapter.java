package com.ixuea.courses.kanmeitu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ixuea.courses.kanmeitu.R;
import com.ixuea.courses.kanmeitu.util.ImageUtil;

import java.util.List;

/**
 * 图片adapter
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private final Context context;
    private final List<String> images;
    private final LayoutInflater inflater;
    private OnItemClickListener listener;

    public ImageAdapter(Context context, List<String> images) {
        this.context=context;
        this.images=images;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_image, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(images.get(position));

        if (listener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    /**
     * 设置点击监听器
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener=listener;
    }

    public String getData(int position) {
        return images.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }

        public void bind(String data) {
            ImageUtil.show(imageView, data);
        }
    }
}
