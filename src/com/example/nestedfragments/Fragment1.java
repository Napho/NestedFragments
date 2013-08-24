package com.example.nestedfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//inflate the view for fragment 1, this view is what will be used
		//to embed the two other fragments on this page
		View v = inflater.inflate(R.layout.fragment_1_activity, container,false);
		
		//Create dynamically the fragments that will be added to the inflated view
		
		Fragment2 fragment2 = new Fragment2();
		Fragment3 fragment3 = new Fragment3();
				
		/*
		 * Using getChildFragmentManager, you get same functionality as if you
		 * called getSupportFragmentManager()
		 * 
		 * Perform the necessary transaction and commit your changes.
		 */
		FragmentManager manager = getChildFragmentManager();
		FragmentTransaction transaction = manager.beginTransaction();
		transaction.add(R.id.frag_1, fragment2);
		transaction.add(R.id.frag_2, fragment3);
		transaction.commit();
		
		//Return the embedded fragment view to the main activity		
		return v;
	}

	
}
