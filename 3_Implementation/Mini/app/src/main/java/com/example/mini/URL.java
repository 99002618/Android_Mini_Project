package com.example.mini;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link URL#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class URL extends Fragment {
    Button search;
    EditText urltext;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment URL.
     */
    // TODO: Rename and change types and number of parameters
    public static URL newInstance(String param1, String param2) {
        URL fragment = new URL();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public URL() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_u_r_l, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        search = (Button) view.findViewById(R.id.btnopen);
        urltext = (EditText) view.findViewById(R.id.txturl);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urltext.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="+url));
                startActivity(intent);
            }
        });
        getParentFragmentManager().setFragmentResultListener("requestkey",this,new FragmentResultListener(){
            public void onFragmentResult(@NonNull String key,@NonNull Bundle bundle){
                String result=bundle.getString("bundleKey");
                Toast.makeText(getContext(),result,Toast.LENGTH_LONG).show();
            }
        });
    }


}