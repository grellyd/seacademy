package ca.greyham.socialacademy;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubeStandalonePlayer;


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
    private static final String PITCH_NAME = "param1";
    private static final String PITCH_BLURB = "param2";

    private String mPitchName;
    private String mPitchBlurb;
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
     * @param pitchName The name of the Pitch fragment.
     * @param pitchBlurb The blurb of the Pitch.
     * @return A new instance of fragment Pitch.
     */

    //TODO: set video source
    //TODO: Set video blurb

    public static Pitch newInstance(String pitchName, String pitchBlurb) {
        Pitch fragment = new Pitch();
        Bundle args = new Bundle();
        args.putString(PITCH_NAME, pitchName);
        args.putString(PITCH_BLURB, pitchBlurb);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPitchName = getArguments().getString(PITCH_NAME);
            mPitchBlurb = getArguments().getString(PITCH_BLURB);
        }
//        YouTubePlayerFragment youTubePlayerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById (R.id.youtubeplayer);
//
//        youTubePlayerFragment.initialize("AIzaSyCWqS5ve4UI0VJT61nBCy4icrsDqQzF2tI", new YouTubePlayer.OnInitializedListener() {
//
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
//
//                if (!wasRestored) {
//                    ytPlayer = player;
//                    ytPlayer.setFullscreen(false);
//                    ytPlayer.loadVideo(vidID);
//                    ytPlayer.play();
//                }
//
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
//                // TODO Auto-generated method stub
//
//            }
//        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pitch, container, false);
        YouTubePlayerView youTubeView = (YouTubePlayerView)
                view.findViewById(R.id.youtubeplayer);
        youTubeView.initialize(DEVELOPER_KEY, this);

//        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.youtubeplayer, youTubePlayerFragment).commit();
//
//        youTubePlayerFragment.initialize("AIzaSyCWqS5ve4UI0VJT61nBCy4icrsDqQzF2tI", new YouTubePlayer.OnInitializedListener() {
//
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
//
//                if (!wasRestored) {
//                    ytPlayer = player;
//                    ytPlayer.setFullscreen(false);
//                    ytPlayer.loadVideo(vidID);
//                    ytPlayer.play();
//                }
//
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
//                // TODO Auto-generated method stub
//
//            }
//        });

//        View rootView = inflater.inflate(R.layout.fragment_pitch, container, false);
//
//        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.youtubeplayer, youTubePlayerFragment).commit();
//
//        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {
//
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider arg0, YouTubePlayer youTubePlayer, boolean b) {
//                if (!b) {
//                    ytPlayer = youTubePlayer;
//                    ytPlayer.setFullscreen(true);
//                    ytPlayer.loadVideo("2zNSgSzhBfM");
//                    ytPlayer.play();
//                }
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
//                // TODO Auto-generated method stub
//
//            }
//        });

        return view;
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

        if (!wasRestored) {
            ytPlayer = player;
            ytPlayer.setFullscreen(false);
            ytPlayer.loadVideo(vidID);
            ytPlayer.play();
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
