package ca.greyham.socialacademy;

import android.os.Bundle;

import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;

import ca.greyham.socialacademy.PitchDetails;

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
            Fragment newPitch = Pitch.newInstance(pd.getPitchCompany(), pd.getPitchBlurb(), pd.getPitchCampaignName(), pd.getPitchCompany(), pd.getVideoURL());
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
            pitchDetails.setPitchCompany("PITCH_COMPANY_" + Integer.toString(i));
            pitchDetails.setPitchCampaignName("PITCH_CAMPAIGN_" + Integer.toString(i));
            pitchDetails.setPitchBlurb("PITCH_BLURB_" + Integer.toString(i));
            pitchDetails.setSponsor("PITCH_SPONSOR_" + Integer.toString(i));
            pitchDetails.setVideoURL(vidID);
            containingList.add(pitchDetails);
        }
    }

}
