package ca.greyham.socialacademy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class ProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentManager.beginTransaction();
//        Fragment newProfile = ProfileFragment.newInstance("", "");
//        fragmentTransaction.add(R.id.profileLinearLayout, newProfile, "PROFILE_ID");
//        fragmentTransaction.commit();
    }
}
