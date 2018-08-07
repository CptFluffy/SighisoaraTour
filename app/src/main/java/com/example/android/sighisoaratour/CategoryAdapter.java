package com.example.android.sighisoaratour;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new OldTownFragment();
            case 1:
                return new BarsFragment();
            case 2:
                return new RestaurantsFragment();
            case 3:
                return new EventsFragment();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return  mContext.getString(R.string.old_town);
            case 1:
                return  mContext.getString(R.string.bars);
            case 2:
                return  mContext.getString(R.string.restaurants);
            case 3:
                return  mContext.getString(R.string.events);
            default:
                return null;
        }
    }
}
