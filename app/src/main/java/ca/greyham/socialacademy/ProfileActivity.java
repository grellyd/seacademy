package ca.greyham.socialacademy;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;

public class ProfileActivity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentManager.beginTransaction();
        ProfileFragment newProfile = ProfileFragment.newInstance("", "");
        fragmentTransaction.add(R.id.profileLinearLayout, newProfile, "PROFILE_ID");
        fragmentTransaction.commit();
    }
}
