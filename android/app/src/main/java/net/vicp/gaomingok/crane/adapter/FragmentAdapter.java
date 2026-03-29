package net.vicp.gaomingok.crane.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return net.vicp.gaomingok.crane.ui.main.MainFragment.newInstance("index.html");
            case 1:
                return net.vicp.gaomingok.crane.ui.main.MainFragment.newInstance("crane-sim.html");
            default:
                return net.vicp.gaomingok.crane.ui.main.MainFragment.newInstance("index.html");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}