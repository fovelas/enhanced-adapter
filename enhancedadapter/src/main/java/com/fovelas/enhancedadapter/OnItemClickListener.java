package com.fovelas.enhancedadapter;

public interface OnItemClickListener<T>
{
    void onItemClick(
        T obj,
        int position
    );
}