package com.ingeniousafrica.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;


public class AffichageAuto extends Activity implements OnClickListener{
	
	private ListView listDetails;
	//private String titre;
	
	private Button bretour;
	
	List<Voiture> maGame = new ArrayList<Voiture>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.affichageauto);
        
        Bundle objetbunble  = this.getIntent().getExtras();
        
        maGame.add((Voiture)objetbunble.getSerializable("voiture"));
      
        listDetails = (ListView) findViewById(R.id.details);
 
        
        VoitureAdapter adapter = new VoitureAdapter(this, maGame);

        listDetails.setAdapter(adapter);
        
        bretour = (Button)findViewById(R.id.retourButton);
        
        bretour.setOnClickListener(this);
 
    }
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0 == bretour){
			//Intent monIntent2 = new Intent(AffichageAuto.this, ListviewAutoActivity.class);

			//startActivity(monIntent2);
			finish();
		}
		
	}

}
