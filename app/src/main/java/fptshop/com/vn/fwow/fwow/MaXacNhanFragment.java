package fptshop.com.vn.fwow.fwow;

import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fptshop.com.vn.fwow.R;

public class MaXacNhanFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_ma_xac_nhan_fragment, container, false);
        return view;
    }

    public static MaXacNhanFragment newInstance (String param1, String param2){
        MaXacNhanFragment fragment = new MaXacNhanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private boolean isActive = true;
    private TrangChuFragment.OnFragmentInteractionListener mListener;

    public MaXacNhanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onResume () {
        super.onResume();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
