package br.com.sorrydave.connect_dave.apoio;

import java.util.List;

import br.com.sorrydave.connect_dave.R;
import br.com.sorrydave.connect_dave.sqlite.Connection;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MeuAdapter extends ArrayAdapter<Connection>{

		Context contexto;
		List<Connection> lista;
		int LayoutId;
	
	public MeuAdapter(Context context, int resource, List<Connection> objects) {
		super(context, resource, objects);
		LayoutId = resource;
		lista = objects;
		contexto = context;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View linha = convertView;
		ConnectionHolder connectionHolder;
		if(linha==null){
			LayoutInflater inflater = ((Activity)contexto).getLayoutInflater();
			linha = inflater.inflate(LayoutId, parent, false);
			connectionHolder = new ConnectionHolder();
			connectionHolder.icone = (ImageView)linha.findViewById(R.id.itemIcone);
			connectionHolder.website = (TextView)linha.findViewById(R.id.itemWebsite);
			connectionHolder.content = (TextView)linha.findViewById(R.id.itemContent);
			linha.setTag(connectionHolder);	
		}else{
			connectionHolder = (ConnectionHolder)linha.getTag();
		}
		
		Connection connection = lista.get(position);
		connectionHolder.website.setText(connection.getWebsite());
		connectionHolder.content.setText(connection.getContent());
		connectionHolder.icone.setImageResource(R.drawable.ic_launcher);
		
		return linha;
	}
	
	static class ConnectionHolder
    {
        ImageView icone;
        TextView website;
        TextView content;

    }
	

}
