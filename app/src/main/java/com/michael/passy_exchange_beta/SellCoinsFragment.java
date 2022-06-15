package com.michael.passy_exchange_beta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

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
        sneakList.add(new SneakModel("Sneak peek #1", R.drawable.peek_1));
        sneakList.add(new SneakModel("Sneak peek #2", R.drawable.peek_2));
        sneakList.add(new SneakModel("Sneak peek #3", R.drawable.peek_3));
        sneakList.add(new SneakModel("Sneak peek #4", R.drawable.peek_4));
        sneakList.add(new SneakModel("Sneak peek #5", R.drawable.peek_5));
        sneakList.add(new SneakModel("Sneak peek #6", R.drawable.peek_6));
        sneakList.add(new SneakModel("Sneak peek #7", R.drawable.peek_7));
        sneakList.add(new SneakModel("Sneak peek #8", R.drawable.peek_8));
        sneakList.add(new SneakModel("Sneak peek #9", R.drawable.peek_9));
        sneakList.add(new SneakModel("Sneak peek #10", R.drawable.peek_10));
        sneakList.add(new SneakModel("Sneak peek #11", R.drawable.peek_11));
        sneakList.add(new SneakModel("Sneak peek #12", R.drawable.peek_12));
        sneakList.add(new SneakModel("Sneak peek #13", R.drawable.peek_13));
        sneakList.add(new SneakModel("Sneak peek #14", R.drawable.peek_14));
        sneakList.add(new SneakModel("Sneak peek #15", R.drawable.peek_15));
        sneakList.add(new SneakModel("Sneak peek #16", R.drawable.peek_16));
        sneakList.add(new SneakModel("Sneak peek #17", R.drawable.peek_17));
        sneakList.add(new SneakModel("Sneak peek #18", R.drawable.peek_18));
        sneakList.add(new SneakModel("Sneak peek #19", R.drawable.peek_19));
        sneakList.add(new SneakModel("Sneak peek #20", R.drawable.peek_20));
        sneakList.add(new SneakModel("Sneak peek #21", R.drawable.peek_21));
        sneakList.add(new SneakModel("Sneak peek #22", R.drawable.peek_22));
        sneakList.add(new SneakModel("Sneak peek #23", R.drawable.peek_23));
        sneakList.add(new SneakModel("Sneak peek #24", R.drawable.peek_24));
        sneakList.add(new SneakModel("Sneak peek #25", R.drawable.peek_25));
        sneakList.add(new SneakModel("Sneak peek #26", R.drawable.peek_26));
        sneakList.add(new SneakModel("Sneak peek #27", R.drawable.peek_27));
        sneakList.add(new SneakModel("Sneak peek #28", R.drawable.peek_28));
        sneakList.add(new SneakModel("Sneak peek #29", R.drawable.peek_29));
        sneakList.add(new SneakModel("Sneak peek #30", R.drawable.peek_30));
        sneakList.add(new SneakModel("Sneak peek #31", R.drawable.peek_31));
        sneakList.add(new SneakModel("Sneak peek #32", R.drawable.peek_32));
        sneakList.add(new SneakModel("Sneak peek #33", R.drawable.peek_33));
        sneakList.add(new SneakModel("Sneak peek #34", R.drawable.peek_34));
        sneakList.add(new SneakModel("Sneak peek #35", R.drawable.peek_35));
        sneakList.add(new SneakModel("Sneak peek #36", R.drawable.peek_36));
        sneakList.add(new SneakModel("Sneak peek #37", R.drawable.peek_37));
        sneakList.add(new SneakModel("Sneak peek #38", R.drawable.peek_38));
        sneakList.add(new SneakModel("Sneak peek #39", R.drawable.peek_39));
        sneakList.add(new SneakModel("Sneak peek #40", R.drawable.peek_40));
        sneakList.add(new SneakModel("Sneak peek #41", R.drawable.peek_41));
        sneakList.add(new SneakModel("Sneak peek #42", R.drawable.peek_42));
        sneakList.add(new SneakModel("Sneak peek #43", R.drawable.peek_43));
        sneakList.add(new SneakModel("Sneak peek #44", R.drawable.peek_44));
        sneakList.add(new SneakModel("Sneak peek #45", R.drawable.peek_45));
        sneakList.add(new SneakModel("Sneak peek #46", R.drawable.peek_46));
        sneakList.add(new SneakModel("Sneak peek #47", R.drawable.peek_47));
        sneakList.add(new SneakModel("Sneak peek #48", R.drawable.peek_48));
        sneakList.add(new SneakModel("Sneak peek #49", R.drawable.peek_49));
        sneakList.add(new SneakModel("Sneak peek #50", R.drawable.peek_50));
        sneakList.add(new SneakModel("Sneak peek #51", R.drawable.peek_51));
        sneakList.add(new SneakModel("Sneak peek #52", R.drawable.peek_52));
        sneakList.add(new SneakModel("Sneak peek #53", R.drawable.peek_53));
        sneakList.add(new SneakModel("Sneak peek #54", R.drawable.peek_54));
        sneakList.add(new SneakModel("Sneak peek #55", R.drawable.peek_55));

        return sneakList;
    }

}