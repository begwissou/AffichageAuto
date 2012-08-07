package com.ingeniousafrica.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListviewAutoActivity extends Activity {
    /** Called when the activity is first created. */
	
	private ListView maListViewPerso;
	Voiture v1 ;
	Voiture v2;
	Voiture v3 ;
	Voiture v4;
	List<Voiture> maGame = new ArrayList<Voiture>();
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       // maGame.add(new Voiture("TOYOTA", "Tyota","406", "x40002"));
       // maGame.add(new Voiture("DACIA", "Dacia","6006", "ix455555"));
        //R�cup�ration de la listview cr��e dans le fichier main.xml
        maListViewPerso = (ListView) findViewById(R.id.listviewperso);
        v1 = new Voiture("TOYOTA", "TOYOTA 406 2012","406 ", "x40002222258", String.valueOf(R.drawable.toyota));
        v2 = new Voiture("DACIA", "DACIA 6006 2011","6006", "ix455555566689", String.valueOf(R.drawable.dacia));
        
        v3 = new Voiture("VOLKSWAGEN", "VOLKSWAGEN 512 2009","512", "Y774589632020", String.valueOf(R.drawable.vols));
        v4 = new Voiture("BENZ", "BENZ 702 2012","702", "YX7820361202538", String.valueOf(R.drawable.benz));
        //Cr�ation de la ArrayList qui nous permettra de remplire la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
 
        //On d�clare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
 
        //Cr�ation d'une HashMap pour ins�rer les informations du premier item de notre listView
        map = new HashMap<String, String>();
        //on ins�re un �l�ment titre que l'on r�cup�rera dans le textView titre cr�� dans le fichier affichageitem.xml
        map.put("titre", v1.getFabriquant());
        //on ins�re un �l�ment description que l'on r�cup�rera dans le textView description cr�� dans le fichier affichageitem.xml
        map.put("description", "Voir plus les d�tails");
        //on ins�re la r�f�rence � l'image (convertit en String car normalement c'est un int) que l'on r�cup�rera dans l'imageView cr�� dans le fichier affichageitem.xml
        map.put("img", v1.getImg());
        //enfin on ajoute cette hashMap dans la arrayList
        listItem.add(map);
 
        //On refait la manip plusieurs fois avec des donn�es diff�rentes pour former les items de notre ListView
 
        map = new HashMap<String, String>();
        map.put("titre", v2.getFabriquant());
        map.put("description", "Voir plus les d�tails");
        map.put("img", v2.getImg());
        listItem.add(map);
        
        map = new HashMap<String, String>();
        map.put("titre", v3.getFabriquant());
        map.put("description", "Voir plus les d�tails");
        map.put("img", v3.getImg());
        listItem.add(map);
        
        map = new HashMap<String, String>();
        map.put("titre", v4.getFabriquant());
        map.put("description", "Voir plus les d�tails");
        map.put("img", v4.getImg());
        listItem.add(map);
 
        //Cr�ation d'un SimpleAdapter qui se chargera de mettre les items pr�sent dans notre list (listItem) dans la vue affichageitem
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.affichageitem,
               new String[] {"img", "titre", "description"}, new int[] {R.id.img, R.id.titre, R.id.description});
 
        //On attribut � notre listView l'adapter que l'on vient de cr�er
        maListViewPerso.setAdapter(mSchedule);
       
        
        //VoitureAdapter adapter = new VoitureAdapter(this, maGame);

        //maListViewPerso.setAdapter(adapter);
 
        //Enfin on met un �couteur d'�v�nement sur notre listView
        maListViewPerso.setOnItemClickListener(new OnItemClickListener() {
		
        	private String titre;

			//@SuppressWarnings("unchecked")
         	@SuppressWarnings("unchecked")
			public void onItemClick(AdapterView<?> a, View v, int position, long id) {
				/*//on r�cup�re la HashMap contenant les infos de notre item (titre, description, img)
        		HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
        		//on cr�er une boite de dialogue
        		AlertDialog.Builder adb = new AlertDialog.Builder(ListviewAutoActivity.this);
        		//on attribut un titre � notre boite de dialogue
        		adb.setTitle("S�lection Item");
        		//on ins�re un message � notre boite de dialogue, et ici on affiche le titre de l'item cliqu�
        		adb.setMessage("Votre choix : "+map.get("titre"));
        		//on indique que l'on veut le bouton ok � notre boite de dialogue
        		adb.setPositiveButton("Ok", null);
        		//on affiche la boite de dialogue
        		adb.show();*/
        		HashMap<String, String> itemAtPosition = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
				HashMap<String, String> map = itemAtPosition;
         		
         		Bundle objetbunble = new Bundle();
         		 
    			//Cela fonctionne plus ou moins comme une HashMap, on entre une clef et sa valeur en face
    			objetbunble.putString("titre", map.get("titre"));
    			titre = map.get("titre");
    			
    			if(titre.equals("TOYOTA")){
    				objetbunble.putSerializable("voiture", v1);
    	        }else if(titre.equals("DACIA")){
    	        	objetbunble.putSerializable("voiture", v2);
    	        }else if(titre.equals("VOLKSWAGEN")){
    	        	objetbunble.putSerializable("voiture", v3);
    	        }else if(titre.equals("BENZ")){
    	        	objetbunble.putSerializable("voiture", v4);
    	        }
    			
    			
         		
         		Intent monIntent2 = new Intent(ListviewAutoActivity.this, AffichageAuto.class);
         		
         		monIntent2.putExtras(objetbunble);

    			//startActivity(monIntent2);
    			startActivityForResult(monIntent2, 1);
        	}
         });
 
    }
}