package br.com.sorrydave.connect_dave;

import java.util.ArrayList;
import java.util.List;

import br.com.sorrydave.connect_dave.apoio.MeuAdapter;
import br.com.sorrydave.connect_dave.sqlite.Connection;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListFragment extends Fragment {
	
	
	MainActivity mainActivity;
	ListView lv;
	MeuAdapter meuAdapter;
	
    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        mainActivity = (MainActivity)getActivity();
        
        lv = (ListView)rootView.findViewById(R.id.lstConnections);
                
        
		mainActivity.Lista = new ArrayList<Connection>();
		List<Connection> registros = mainActivity.db.getAllConnections();
		for (Connection object : registros) {
			mainActivity.Lista.add(object);
		}
				
        
        meuAdapter = new MeuAdapter(mainActivity, R.layout.item_lista, mainActivity.Lista);
    	lv.setAdapter(meuAdapter);

        
        
        return rootView;
    }
}
