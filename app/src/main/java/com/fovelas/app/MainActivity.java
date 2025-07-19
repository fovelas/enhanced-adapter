package com.fovelas.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fovelas.enhancedadapter.OnItemClickListener;

import java.util.ArrayList;

public final class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvUser = findViewById(R.id.main_activity_rv_user);

        ArrayList<User> data = new ArrayList<>();
        data.add(new User("1", "John"));
        data.add(new User("2", "Doe"));

        UserAdapter adapter = new UserAdapter(MainActivity.this, data);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener<User>()
        {
            @Override
            public void onItemClick(
                User user,
                int position
            )
            {
                System.out.println(user.getId());
            }
        });
    }
}