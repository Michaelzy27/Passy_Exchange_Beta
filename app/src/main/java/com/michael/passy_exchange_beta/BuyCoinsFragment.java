package com.michael.passy_exchange_beta;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuyCoinsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuyCoinsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView taskRecycler;
    TextView WelcomeText, timer;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public int hours = 23;
    public int seconds = 15;
    public int minutes = 1;

    public BuyCoinsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BuyCoinsFragment newInstance(String param1, String param2) {
        BuyCoinsFragment fragment = new BuyCoinsFragment();
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

        FragmentActivity b = getActivity();

        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {



            @Override
            public void run() {
                b.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        if (seconds < 10) {
                            timer.setText(hours + ":" + minutes + ":" + "0" + seconds);
                            if (minutes < 10) {
                                timer.setText(hours + ":0" + minutes + ":" + "0" + seconds);
                            }
                        } else if (minutes < 10) {
                            timer.setText(hours + ":0" + minutes + ":" + +seconds);
                        } else {
                            timer.setText(hours + ":" + minutes + ":" + seconds);
                        }


                        if (seconds == 0) {
//                            timer.setText(hours + ":" + minutes +":"+ seconds);

                            seconds = 59;
                            minutes = minutes - 1;

//                            if (minutes == 0) {
//
//                                timer.setText(hours + ":" + minutes +":"+ seconds);
//
//                                seconds=59;
//                                minutes = 59;
//                                hours=hours-1;
//
//                            }

                        } else {
                            seconds -= 1;
                        }

                        if (minutes == 0 && seconds == 0) {

                            timer.setText(hours + ":0" + minutes + ":0" + seconds);

                            seconds = 59;
                            minutes = 59;
                            hours = hours - 1;
                        }
                    }

                });
            }

        }, 0, 1000);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                timer.setText(hours + ":" + minutes +":"+ seconds);
//                seconds -= 1;
//
//                if(seconds == 0)
//                {
//                    timer.setText(hours + ":" + minutes +":"+ seconds);
//
//                    seconds=60;
//                    minutes=minutes-1;
//
//                }
//
//            }
//        }, 1000);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy_coins, container, false);
        timer = view.findViewById(R.id.time);

//        taskRecycler = view.findViewById(R.id.tasks_recycler);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
//        taskRecycler.setLayoutManager(layoutManager);
//        taskAdapter = new TaskAdapter(tasks);
//        taskRecycler.setAdapter(taskAdapter);
//        WelcomeText = view.findViewById(R.id.welcome_text);00
        return view;

    }

  }