package sk.mmarcincin.monoli.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sk.mmarcincin.monoli.MainActivity;
import sk.mmarcincin.monoli.R;
import sk.mmarcincin.monoli.adapters.NovenasAdapter;
import sk.mmarcincin.monoli.interfaces.NovenaOnClickListener;
import sk.mmarcincin.monoli.models.Novena;
import sk.mmarcincin.monoli.utils.Mockdb;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NovenasListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NovenasListFragment extends Fragment implements NovenaOnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Novena> localDataSet;
    private RecyclerView recyclerView;

    public NovenasListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NovenasListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NovenasListFragment newInstance(String param1, String param2) {
        NovenasListFragment fragment = new NovenasListFragment();
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
       // DatabaseHelper databaseHelper = new DatabaseHelper(this.getContext() );
        return inflater.inflate(R.layout.fragment_novenas_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitilize();

        recyclerView = view.findViewById(R.id.novenasRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        NovenasAdapter novenasAdapter = new NovenasAdapter(localDataSet,getContext(),this);
        recyclerView.setAdapter(novenasAdapter);
        novenasAdapter.notifyDataSetChanged();
    }

    private void dataInitilize() {
        Mockdb db = new Mockdb();
        localDataSet = db.getMockNovenas(50);

    }


    @Override
    public void onNovenaClick(Novena novena) {
        ((MainActivity) getActivity()).openFragment(novena);
    }
}