# Enhanced Adapter

### Prerequisites

Add this maven line to root `settings.gradle`

```
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

---

### Dependency

Lastly add this line to `build.gradle` file in app module.

```
dependencies {
    implementation 'com.github.fovelas:enhanced-adapter:1.0.0'
}
```

---

### Create Custom Adapter

```java
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
        // inflating item_user.xml file
        return ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public void onBindViewHolder(
        @NonNull EnhancedViewHolder<ItemUserBinding> holder,
        int position
    )
    {
        super.onBindViewHolder(holder, position);
        
        // Using passed ArrayList 
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
```

---

### Setting Adapter to RecyclerView

```java
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
```