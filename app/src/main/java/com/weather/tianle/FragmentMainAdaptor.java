package com.weather.tianle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/27.
 */
public class FragmentMainAdaptor extends FragmentStatePagerAdapter {

    Weather[] weathers;
    public FragmentMainAdaptor(FragmentManager fm) {
        super(fm);
    }

    public Weather[] getWeathers() {
        return weathers;
    }

    public void setWeathers(Weather[] weathers) {
        this.weathers = weathers;
    }

    @Override
    public int getCount() {
        return weathers==null ? 0 :weathers.length;
    }

    @Override
    public Fragment getItem(int arg0) {
        return BlankFragment.newInstance(weathers[arg0]);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }
}
