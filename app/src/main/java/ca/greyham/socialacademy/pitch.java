package ca.greyham.socialacademy;

import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Pitch.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Pitch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pitch extends Fragment implements YouTubePlayer.OnInitializedListener {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PITCH_COMPANY = "param1";
    private static final String PITCH_BLURB = "param2";
    private static final String PITCH_CAMPAIGN = "param3";
    private static final String PITCH_SPONSOR = "param5";
    private static final String VIDEO_URL = "param4";

    private String mPitchCompany;
    private String mPitchBlurb;
    private String mPitchCampaignName;
    private String mPitchSponsor;
    private String mVideoURL;

    private YouTubePlayer ytPlayer;


    private String vidID = "20i1zov0cj4";
    private String DEVELOPER_KEY = "AIzaSyCWqS5ve4UI0VJT61nBCy4icrsDqQzF2tI";

    private OnFragmentInteractionListener mListener;

    public Pitch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param pitchCompany The name of the Pitch fragment.
     * @param pitchBlurb The blurb of the Pitch.
     * @param pitchCampaignName
     *@param videoURL
     * @param sponsor @return A new instance of fragment Pitch.
     */

    //TODO: set video source
    //TODO: Set video blurb

    public static Pitch newInstance(String pitchCompany, String pitchBlurb, String pitchCampaignName, String pitchSponsor, String videoURL) {
        Pitch fragment = new Pitch();
        Bundle args = new Bundle();
        args.putString(PITCH_COMPANY, pitchCompany);
        args.putString(PITCH_BLURB, pitchBlurb);
        args.putString(PITCH_CAMPAIGN, pitchCampaignName);
        args.putString(PITCH_SPONSOR, pitchSponsor);
        args.putString(VIDEO_URL, videoURL);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPitchCompany = getArguments().getString(PITCH_COMPANY);
            mPitchBlurb = getArguments().getString(PITCH_BLURB);
            mPitchCampaignName = getArguments().getString(PITCH_CAMPAIGN);
            mPitchSponsor = getArguments().getString(PITCH_SPONSOR);
            mVideoURL = getArguments().getString(VIDEO_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pitch, container, false);

        TextView companyNameTV = (TextView) view.findViewById(R.id.PitchCompanyNameTextView);
        companyNameTV.setText(mPitchCompany);

        TextView campaignName = (TextView) view.findViewById(R.id.PitchCampaignNameTextView);
        campaignName.setText(mPitchCampaignName);

        TextView companyBlurb = (TextView) view.findViewById(R.id.pitchBlurb);
        companyBlurb.setText(mPitchBlurb);

        TextView sponsor = (TextView) view.findViewById(R.id.pitchSponsor);
        sponsor.setText(mPitchSponsor);

        YouTubePlayerView youTubeView = (YouTubePlayerView)
                view.findViewById(R.id.youtubeplayer);
        youTubeView.initialize(DEVELOPER_KEY, this);
        return view;
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            ytPlayer = player;
            ytPlayer.setFullscreen(false);
            ytPlayer.cueVideo(vidID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
        // TODO Auto-generated method stub
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void buttonApply_Click(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
