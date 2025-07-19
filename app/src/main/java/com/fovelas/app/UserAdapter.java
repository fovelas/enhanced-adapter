package com.fovelas.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.fovelas.app.databinding.ItemUserBinding;
import com.fovelas.enhancedadapter.EnhancedAdapter;
import com.fovelas.enhancedadapter.EnhancedViewHolder;
import com.fovelas.log.Log;

import java.util.ArrayList;

public final class UserAdapter extends EnhancedAdapter<User, ItemUserBinding>
{
    private static final String TAG = "UserAdapter";

    public UserAdapter(
        @NonNull Context context,
        @NonNull ArrayList<User> data
    )
    {
        super(context, data);
    }

    @Override
    public ItemUserBinding onInflateBinding(
        @NonNull ViewGroup parent,
        int viewType
    )
    {
        return ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public void onBindViewHolder(
        @NonNull EnhancedViewHolder<ItemUserBinding> holder,
        int position
    )
    {
        super.onBindViewHolder(holder, position);

        User user = data.get(position);

        try
        {
            holder.binding.userItemLyRoot.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if (onItemClickListener != null) onItemClickListener.onItemClick(user, holder.getAdapterPosition());
                }
            });
        }
        catch (Throwable t)
        {
            Log.e(TAG, t.getMessage());
        }
    }
}