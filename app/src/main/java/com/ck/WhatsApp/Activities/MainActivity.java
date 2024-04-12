package com.ck.WhatsApp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.ck.WhatsApp.Adapters.FragmentsAdapter;

import com.ck.WhatsApp.R;
import com.ck.WhatsApp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);

        auth = FirebaseAuth.getInstance();

        FragmentsAdapter adapter = new FragmentsAdapter(this);

        viewPager2.setAdapter(adapter);


        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Chats");
                    tab.setIcon(R.drawable.comment);
                    break;
                case 1:
                    tab.setText("Status");
                    tab.setIcon(R.drawable.application);
                    break;
                case 2:
                    tab.setText("Calls");
                    tab.setIcon(R.drawable.telephone);
                    break;
            }
        }).attach();




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.setting:
                Intent intent2 = new Intent(MainActivity.this, SetupProfileActivity.class);
                startActivity(intent2);
                break;
            case R.id.logout:
                auth.signOut();
                Intent intent = new Intent(MainActivity.this , SendOtpActivity.class);
                startActivity(intent);
                break;
            case R.id.group:
                Intent intent1 = new Intent(MainActivity.this , Group_Chat_Activity.class);
                startActivity(intent1);
                break;


        }
        return true;
    }
}
