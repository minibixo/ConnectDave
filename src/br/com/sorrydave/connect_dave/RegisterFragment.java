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

public class RegisterFragment extends Fragment {

	public String content;
	public String website;
	public int time;
	TextView txtContent;
	TextView txtWebsite;
	TextView txtTime;
	
	MainActivity mainActivity;
	
	
    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);        
        
        txtWebsite = (TextView)rootView.findViewById(R.id.website_website);
        txtContent = (TextView)rootView.findViewById(R.id.website_content);                
        txtTime = (TextView)rootView.findViewById(R.id.website_time);
                
        Button button = (Button)rootView.findViewById(R.id.button1);
        button.setOnClickListener(tapCadastro);
        
        mainActivity = (MainActivity)getActivity(); 
        
        return rootView;
    }
    
    OnClickListener tapCadastro = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			content = txtContent.getText().toString();
	        website = txtWebsite.getText().toString();
	        time = Integer.valueOf(txtTime.getText().toString());			
			Toast.makeText(mainActivity, "Website add to your list", Toast.LENGTH_SHORT).show();
			txtContent.setText("");
			txtWebsite.setText("");
			txtTime.setText("");
			
			mainActivity.db.addConnection(new Connection(website, content, time));
			mainActivity.db.getAllConnections();
			
			
		}
	};
    
}
