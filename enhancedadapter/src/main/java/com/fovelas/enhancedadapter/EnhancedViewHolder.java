package com.fovelas.enhancedadapter;

import android.text.TextWatcher;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/**
 * Each ViewHolder is associated with a particular item in the dataset and holds references to the views that represent the item.
 * The ViewHolder provides a convenient way to bind data to the views it holds.
 *
 * @param <T> ViewBinding
 */
public final class EnhancedViewHolder<T extends ViewBinding> extends RecyclerView.ViewHolder
{
    public final T binding;
    public TextWatcher textWatcher;
    public boolean isAttachedToWindow;

    public EnhancedViewHolder(
        T binding
    )
    {
        super(binding.getRoot());
        this.binding = binding;
        this.textWatcher = null;
        this.isAttachedToWindow = false;
    }
}