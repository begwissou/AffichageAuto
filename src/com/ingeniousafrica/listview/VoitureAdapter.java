package com.ingeniousafrica.listview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class VoitureAdapter extends BaseAdapter {

	List<Voiture> game;

	LayoutInflater inflater;

	public VoitureAdapter(Context context,List<Voiture> game) {

		inflater = LayoutInflater.from(context);
	
		this.game = game;

	}
	
	private class ViewHolder {

		TextView marque;

		TextView fabriquant;
		TextView moteur;

		TextView model;

		}
	
	
	public int getCount() {
		// TODO Auto-generated method stub
		return game.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return game.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder;

		if(convertView == null) {

			holder = new ViewHolder();
	
			convertView = inflater.inflate(R.layout.voitureinfos, null);
	
			holder.marque = (TextView)convertView.findViewById(R.id.marque);
	
			holder.fabriquant = (TextView)convertView.findViewById(R.id.fabriquant);
			
			holder.model = (TextView)convertView.findViewById(R.id.model);
	
			holder.moteur = (TextView)convertView.findViewById(R.id.moteur);
	
			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();

		}

			holder.marque.setText(game.get(position).getMarque());
	
			holder.fabriquant.setText(game.get(position).getFabriquant());
			
			holder.model.setText(game.get(position).getModel());
	
			holder.moteur.setText(game.get(position).getMoteur());
	
			return convertView;

		}

}
