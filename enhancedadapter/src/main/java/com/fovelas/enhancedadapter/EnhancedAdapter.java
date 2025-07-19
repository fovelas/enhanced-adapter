package com.fovelas.enhancedadapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.util.ArrayList;

public abstract class EnhancedAdapter<T, K extends ViewBinding> extends RecyclerView.Adapter<EnhancedViewHolder<K>>
{
    private static final String TAG = "EnhancedAdapter";

    private final Context context;
    protected final ArrayList<T> data;

    protected OnItemClickListener<T> onItemClickListener;
    protected OnItemLongClickListener<T> onItemLongClickListener;

    public EnhancedAdapter(
        @NonNull Context context,
        @NonNull ArrayList<T> data
    )
    {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public EnhancedViewHolder<K> onCreateViewHolder(
        @NonNull ViewGroup parent,
        int viewType
    )
    {
        K binding = onInflateBinding(parent, viewType);
        return new EnhancedViewHolder<>(binding);
    }

    public abstract K onInflateBinding(
        @NonNull ViewGroup parent,
        int viewType
    );

    @Override
    public void onBindViewHolder(
        @NonNull EnhancedViewHolder<K> holder,
        int position
    )
    {
    }

    @Override
    public void onViewAttachedToWindow(
        @NonNull EnhancedViewHolder<K> holder
    )
    {
        super.onViewAttachedToWindow(holder);
        holder.isAttachedToWindow = true;
    }

    @Override
    public void onViewDetachedFromWindow(
        @NonNull EnhancedViewHolder<K> holder
    )
    {
        super.onViewDetachedFromWindow(holder);
        holder.isAttachedToWindow = false;
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public ArrayList<T> getData()
    {
        return data;
    }

    protected final Context getContext()
    {
        return this.context;
    }

    protected final Resources getResources()
    {
        return getContext().getResources();
    }

    protected final Resources.Theme getTheme()
    {
        return getContext().getTheme();
    }

    public final void setOnItemClickListener(
        @NonNull OnItemClickListener<T> l
    )
    {
        this.onItemClickListener = l;
    }

    public final void setOnItemLongClickListener(
        @NonNull OnItemLongClickListener<T> l
    )
    {
        this.onItemLongClickListener = l;
    }
}
