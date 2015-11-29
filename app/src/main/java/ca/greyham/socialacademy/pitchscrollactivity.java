package ca.greyham.socialacademy;

import android.os.Bundle;
import android.app.Activity;

import android.app.Fragment;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class pitchscrollactivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
//    SectionsPagerAdapter mSectionsPagerAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
//    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitchscrollactivity);
//        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        // Set up the ViewPager with the sections adapter.
//        mViewPager = (ViewPager) findViewById(R.id.pager);
//        mViewPager.setAdapter(mSectionsPagerAdapter);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        for (int i = 0; i < 5; i++) {
            fragmentManager.beginTransaction();
            Fragment newPitch = Pitch.newInstance("My Pitch_" + String.valueOf(i), "Pitch Blurb_" + String.valueOf(i));
            fragmentTransaction.add(R.id.scrollViewLayout, newPitch, "New_Pitch_" + String.valueOf(i));
            i++;
        }
        fragmentTransaction.commit();
//        fragmentManager.beginTransaction();
//        Fragment newPitch = Pitch.newInstance("My Pitch", "Pitch Blurb");
//        fragmentTransaction.add(R.id.scrollView, newPitch, "New_Pitch");
//        fragmentTransaction.commit();
    }

    public void OnFragmentInteractionListener()
    {
        // do nothing
    }

//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public pitch getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            return pitch.newInstance("Pitch Name", "Blurb");
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            // TODO:
//            return 3;
//        }
//
//    }


}
