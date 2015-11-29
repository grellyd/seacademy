package ca.greyham.socialacademy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class PitchScrollActivity extends YouTubeBaseActivity implements Pitch.OnFragmentInteractionListener {

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
            fragmentTransaction.add(R.id.scrollViewLayout, newPitch, pd.getFragmentTag());
        }
        fragmentTransaction.commit();
    }

    public void onFragmentInteraction(View v)
    {
        Intent videoRecordActivity = new Intent(PitchScrollActivity.this, VideoRecordActivity.class);
        startActivity(videoRecordActivity);
    }

    private void CreateDemoData(List<PitchDetails> containingList) {
        PitchDetails pitchDetails0 = new PitchDetails();
        pitchDetails0.setFragmentTag("Diabetes_BC");
        pitchDetails0.setPitchCompany("Diabetes British Columbia");
        pitchDetails0.setPitchCampaignName("Spring into Action");
        pitchDetails0.setPitchBlurb("PITCH_BLURB_DBC");
        pitchDetails0.setPitchSponsor("Nestle Candy Company");
        pitchDetails0.setVideoURL(vidID);
        containingList.add(pitchDetails0);

        PitchDetails pitchDetails1 = new PitchDetails();
        pitchDetails1.setFragmentTag("Diabetes_BC_TAG");
        pitchDetails1.setPitchCompany("Diabetes British Columbia");
        pitchDetails1.setPitchCampaignName("Spring into Action");
        pitchDetails1.setPitchBlurb("PITCH_BLURB_DBC");
        pitchDetails1.setPitchSponsor("Nestle Candy Company");
        pitchDetails1.setVideoURL("2udeiQ3-rJk");
        containingList.add(pitchDetails1);

        PitchDetails pitchDetails2 = new PitchDetails();
        pitchDetails2.setFragmentTag("CFB_TAG");
        pitchDetails2.setPitchCompany("The Canadian Federation of the Blind");
        pitchDetails2.setPitchCampaignName("Nov 3rd - National Awareness Day");
        pitchDetails2.setPitchBlurb("PITCH_BLURB_CFB");
        pitchDetails2.setPitchSponsor("Telus");
        pitchDetails2.setVideoURL("XEk6grcrdWE");
        containingList.add(pitchDetails2);

        for (int i = 0; i < 2; i++) {
            PitchDetails pitchDetails = new PitchDetails();
            pitchDetails.setFragmentTag("PITCH_FRAGMENT_TAG_" + Integer.toString(i));
            pitchDetails.setPitchCompany("PITCH COMPANY " + Integer.toString(i));
            pitchDetails.setPitchCampaignName("PITCH CAMPAIGN " + Integer.toString(i));
            pitchDetails.setPitchBlurb("PITCH BLURB " + Integer.toString(i));
            pitchDetails.setPitchSponsor("PITCH SPONSOR " + Integer.toString(i));
            pitchDetails.setVideoURL(vidID);
            containingList.add(pitchDetails);
        }
    }
}
