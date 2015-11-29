package ca.greyham.socialacademy;

import android.os.Bundle;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PitchScrollActivity extends YouTubeBaseActivity {

    private final String vidID = "20i1zov0cj4";
    private List<PitchDetails> pitchDetailsList = new ArrayList<PitchDetails>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitchscrollactivity);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // TODO: Swap for server fetch
        CreateDemoData(pitchDetailsList);

        for (PitchDetails pd : pitchDetailsList) {
            fragmentManager.beginTransaction();
            Fragment newPitch = Pitch.newInstance(pd.getPitchCompany(), pd.getPitchBlurb(), pd.getPitchCampaignName(), pd.getPitchSponsor(), pd.getVideoURL());
            fragmentTransaction.add(R.id.scrollViewLayout, newPitch, pd.getId());
        }
        fragmentTransaction.commit();
    }

    public void OnFragmentInteractionListener()
    {
        // do nothing
    }

    private void CreateDemoData(List<PitchDetails> containingList) {
        for (int i = 0; i < 5; i++) {
            PitchDetails pitchDetails = new PitchDetails();
            pitchDetails.setId("PITCH_ID_" + Integer.toString(i));
            pitchDetails.setPitchCompany("PITCH COMPANY " + Integer.toString(i));
            pitchDetails.setPitchCampaignName("PITCH CAMPAIGN " + Integer.toString(i));
            pitchDetails.setPitchBlurb("PITCH BLURB " + Integer.toString(i));
            pitchDetails.setPitchSponsor("PITCH SPONSOR " + Integer.toString(i));
            pitchDetails.setVideoURL(vidID);
            containingList.add(pitchDetails);
        }
    }

}
