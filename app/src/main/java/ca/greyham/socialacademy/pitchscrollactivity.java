package ca.greyham.socialacademy;

import android.os.Bundle;
import android.app.Activity;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.google.android.youtube.player.YouTubeBaseActivity;

public class PitchScrollActivity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitchscrollactivity);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        for (int i = 0; i < 10; i++) {
            fragmentManager.beginTransaction();
            Fragment newPitch = Pitch.newInstance("My Pitch_" + String.valueOf(i), "Pitch Blurb_" + String.valueOf(i));
            fragmentTransaction.add(R.id.scrollViewLayout, newPitch, "New_Pitch_" + String.valueOf(i));
            i++;
        }
        fragmentTransaction.commit();
    }

    public void OnFragmentInteractionListener()
    {
        // do nothing
    }


}
