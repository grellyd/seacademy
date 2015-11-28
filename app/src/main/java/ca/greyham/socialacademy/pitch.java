package ca.greyham.socialacademy;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link pitch.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link pitch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pitch extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PITCH_NAME = "param1";
    private static final String PITCH_BLURB = "param2";

    private String mPitchName;
    private String mPitchBlurb;

    private OnFragmentInteractionListener mListener;

    public pitch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param pitchName The name of the pitch fragment.
     * @param pitchBlurb The blurb of the pitch.
     * @return A new instance of fragment pitch.
     */

    //TODO: set video source
    //TODO: Set video blurb

    public static pitch newInstance(String pitchName, String pitchBlurb) {
        pitch fragment = new pitch();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pitch, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

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
