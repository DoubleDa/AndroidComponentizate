package com.dyx.aca.co.index.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyx.aca.co.index.R;
import com.dyx.aca.lib.img.GlideUtils;
import com.dyx.aca.lib.net.model.index.IndexBean;

import java.util.List;

/**
 * Author：dayongxin
 * Function：
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.IndexViewHolder> {
    private Context m;
    private List<IndexBean.DataEntity> mDatas;
    private LayoutInflater mLayoutInflater;
    private OnItemClickListener OnItemClickListener;

    public IndexAdapter(Context m, List<IndexBean.DataEntity> mDatas) {
        this.m = m;
        this.mDatas = mDatas;
        mLayoutInflater = LayoutInflater.from(m);
    }


    @Override
    public IndexViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.co_index_item_index, parent, false);
        return new IndexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IndexViewHolder holder, final int position) {
        GlideUtils.displayImgDefault(m, mDatas.get(position).getAuthor().getAvatar_url(), holder.ivAvatar);
        holder.tvLoginname.setText(mDatas.get(position).getAuthor().getLoginname());
        holder.tvTitle.setText(mDatas.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (OnItemClickListener != null) {
                    OnItemClickListener.onItemClick(mDatas.get(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class IndexViewHolder extends RecyclerView.ViewHolder {
        ImageView ivAvatar;
        TextView tvLoginname;
        TextView tvTitle;

        public IndexViewHolder(View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvLoginname = itemView.findViewById(R.id.tv_loginname);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String id);
    }

    public void setOnItemClickListener(IndexAdapter.OnItemClickListener onItemClickListener) {
        OnItemClickListener = onItemClickListener;
    }
}
