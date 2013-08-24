package com.example.nestedfragments;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {


	/*
	 * Define the ViewPager and a list to hold the
	 * a list of fragments that it will show
	 */
	ViewPager viewpager;
	List<Fragment> fragments;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
               
        fragments = getfragments();
        
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        viewpager.setAdapter(adapter);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public List<Fragment> getfragments()
    {
    	List<Fragment> fragment = new ArrayList<Fragment>();
    	/*
    	 * Add the two fragments that make up the ViewPager
    	 */
    	fragment.add(new Fragment1());
    	fragment.add(new Fragment3());
    	
    	return fragment;
    }
    
    /*
     * you can use FragmentStatePagerAdapter or FragmentPagerAdapter, 
     * the difference is that the former saves memory by destroying
     * pages that are no longer being used and the latter doesn't
     */
    private class ViewPagerAdapter extends FragmentStatePagerAdapter
    {

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			// TODO Auto-generated method stub
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return fragments.size();
		}

		@Override
		public void setPrimaryItem(ViewGroup container, int position,
				Object object) {
			
			super.setPrimaryItem(container, position, object);
			
		}

		@Override
		public CharSequence getPageTitle(int position) {
			if(position == 0)
			{
				return "First Page";
			}
		  if(position == 1)
		  {
				return "Second Page";
		  }else
		  return null;
		}
		
    	
    }
    
}
