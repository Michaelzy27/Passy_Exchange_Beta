package com.michael.passy_exchange_beta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.michael.passy_exchange_beta.Adapters.SneakPeekAdapter;
import com.michael.passy_exchange_beta.Models.SneakModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SellCoinsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellCoinsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerview;
    private LinearLayoutManager layoutManager;
    private Spinner select_bank;
    private SneakPeekAdapter sneakAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SellCoinsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TaskFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SellCoinsFragment newInstance(String param1, String param2) {
        SellCoinsFragment fragment = new SellCoinsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View root = (inflater.inflate(R.layout.fragment_sell_coins, container, false));

        //select_bank = root.findViewById(R.id.bank_spinner);
        recyclerview = root.findViewById(R.id.sneak_peeks);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.banks, R.layout.bank_dropdown_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        select_bank.setAdapter(adapter);




        sneakAdapter = new SneakPeekAdapter(list());
        recyclerview.setAdapter(sneakAdapter);

//        List<SneakModel> sneakList = new ArrayList<>();
//        sneakList.add(new SneakModel("1", R.drawable.bbg));
//        sneakList.add(new SneakModel("2", R.drawable.bbg));
//        sneakList.add(new SneakModel("3", R.drawable.bbg));
//        sneakList.add(new SneakModel("4", R.drawable.bbg));
//        sneakList.add(new SneakModel("5", R.drawable.bbg));

//        recyclerview.setAdapter(adapter);
//        recyclerview.setLayoutManager(layoutManager);
        return root;
    }

    private List<SneakModel> list() {
        List<SneakModel> sneakList = new ArrayList<>();
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots5));
        sneakList.add(new SneakModel("Sneak peek #2", R.drawable.yoots6));
        sneakList.add(new SneakModel("Sneak peek #3", R.drawable.yoots7));
        sneakList.add(new SneakModel("Sneak peek #1", R.drawable.yoots8));
        sneakList.add(new SneakModel("Sneak peek #4", R.drawable.yoots19));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots10));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots11));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots12));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots13));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots14));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots15));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots16));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.yoots4));


        return sneakList;
    }

}