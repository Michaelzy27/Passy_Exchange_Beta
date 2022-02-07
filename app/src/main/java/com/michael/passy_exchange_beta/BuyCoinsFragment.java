package com.michael.passy_exchange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.michael.passy_exchange.homepage.Task;
import com.michael.passy_exchange.homepage.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

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
    TaskAdapter taskAdapter;
    List<Task> tasks = new ArrayList<>();
    TextView WelcomeText;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buy_coins, container, false);

//        taskRecycler = view.findViewById(R.id.tasks_recycler);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
//        taskRecycler.setLayoutManager(layoutManager);
//        taskAdapter = new TaskAdapter(tasks);
//        taskRecycler.setAdapter(taskAdapter);
//        WelcomeText = view.findViewById(R.id.welcome_text);00

        prepareTasks();

        return view;

    }
    private void prepareTasks() {
        Task task = new Task("Stage 2 entry Task: Hotel website design","Deadline: 31/07/2020 12:00 AM",
                "Design","pending",R.drawable.ic_baseline_arrow_forward_ios_24);
        tasks.add(task);
        task = new Task("Task 0.5: Git","Deadline: 07/06/2020 12:00 AM",
                "General","closed",R.drawable.ic_baseline_arrow_forward_ios_24);
        tasks.add(task);
        task = new Task("Task 0.5: Lucid","Deadline: 07/06/2020 12:00 AM",
                "General","closed",R.drawable.ic_baseline_arrow_forward_ios_24);
        tasks.add(task);
    }

  }