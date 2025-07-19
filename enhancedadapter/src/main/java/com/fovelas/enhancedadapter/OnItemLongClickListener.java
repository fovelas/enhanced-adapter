package com.fovelas.enhancedadapter;

public interface OnItemLongClickListener<T>
{
    void onItemLongClick(
        T obj,
        int position
    );
}