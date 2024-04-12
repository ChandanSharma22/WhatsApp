package com.ck.WhatsApp.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ck.WhatsApp.Fragments.CallsFragment;
import com.ck.WhatsApp.Fragments.ChatsFragment;
import com.ck.WhatsApp.Fragments.StatusFragment;


public class FragmentsAdapter extends FragmentStateAdapter {

    private ChatsFragment chatsFragment;
    public FragmentsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ChatsFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return 3; // Return the total number of fragments
    }



}
