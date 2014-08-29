package br.com.sorrydave.connect_dave;

import br.com.sorrydave.connect_dave.sqlite.Connection;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditFragment extends Fragment {

	public String content;
	public String website;
	public int time;
	TextView txtContent;
	TextView txtWebsite;
	TextView txtTime;
	
	MainActivity mainActivity;
	
	
    public EditFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_edit, container, false);                       
        
        
        
        
        return rootView;
    }
    
    
    

    
}
