package br.com.sorrydave.connect_dave;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ConfigFragment extends Fragment {

    public ConfigFragment() {
    }
    
    Button button1; 
    MainActivity mainActivity;
    int newTime = 10;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_config, container, false);
        
        mainActivity = (MainActivity)getActivity();
        
        Button btTapFive = (Button)rootView.findViewById(R.id.fiveButton);
        Button btTapTen = (Button)rootView.findViewById(R.id.tenButton);
        Button btTapQuarter = (Button)rootView.findViewById(R.id.quarterButton);
        Button btTapHalf = (Button)rootView.findViewById(R.id.halfButton);
        Button btTapHour = (Button)rootView.findViewById(R.id.hourButton);
        
        btTapFive.setOnClickListener(tapFive);
        btTapTen.setOnClickListener(tapTen);
        btTapQuarter.setOnClickListener(tapQuarter);
        btTapHalf.setOnClickListener(tapHalf);
        btTapHour.setOnClickListener(tapHour);                   

        Button btApplyChanges = (Button)rootView.findViewById(R.id.aplyConfig);        
        btApplyChanges.setOnClickListener(tapSalva);
        
        return rootView;
    }
    
  
    public void applyConfig(MainActivity ma){
    	
    	
    }
    
    
    OnClickListener tapFive = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			newTime = 5;
		}
	};
	
	OnClickListener tapHour= new OnClickListener() {		
		@Override
		public void onClick(View v) {
			newTime = 60;
		}
	};
	
	OnClickListener tapHalf = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			newTime = 30;
		}
	};
	
	OnClickListener tapQuarter = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			newTime = 15;
		}
	};
	
	OnClickListener tapTen = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			newTime = 10;
		}
	};
    
    
    OnClickListener tapSalva = new OnClickListener() {		
		@Override
		public void onClick(View v) {
			Log.v("tapSalva", "Botão Pressionado");
			applyConfig(mainActivity);
		}
	};
   
	
}

