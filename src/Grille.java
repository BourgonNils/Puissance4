import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import jdk.nashorn.internal.runtime.Undefined;

public class Grille {
	static public final int PROFONDEUR_MAX = 2;
	static public final Character opponent ='X';
	static public final Character ally = 'O';
	static public final Character emptyCell ='_';
	
	private HashMap<Coord,Character> pions;
	
	public Grille(){
		this.pions = new HashMap();
	}
	
	public Grille(Grille gr){
		this.pions = new HashMap<>(gr.pions);
	}

	public void jouerCoup (int col){
		if (col > 6){
			return;
		}
		else{
			for (int i = 5 ; i >= 0 ; i--){ 
				if(!this.pions.containsKey(new Coord(col , i))){
					this.addPion(new Coord(col , i) , 'O');
					return;
				}
			}
		}
	}
	
	private void addPion(Coord c,Character p){
		this.pions.put(c,p);
	}
	//Need to raise exception if wrong char
	public static Grille fileToGrille(File path) throws IOException {
		Character[] charPossibles = {opponent, ally, emptyCell};
		Grille ret = new Grille();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		for (int y = 0; y < 6; y++) {
			line = br.readLine();
			for (int x = 0; x < 7; x++) {
				Character current = line.charAt(x);
				if (current == opponent || current == ally) {
					ret.addPion(new Coord(x, y), current);
				}
			}
		}
		return ret;
	}

	public boolean canPlay(int col){
		return !this.pions.containsKey(new Coord(col,0));
	}

	@Override
	public String toString(){
		String result = "";
		for (int i = 0 ; i < 6 ; i++){
			for (int j = 0 ; j < 7 ; j++){
				boolean added = false;
				for (Coord c : this.pions.keySet()){
					if (c.isEq(j,i)) {
						added = true;
						result += this.pions.get(c);
					}
				}
				if (!added){
					result += "-";
				}
			}
			result += "\n";
		}
		return result;
	}
	
	public int coupOptiv2() {
		int max = Integer.MIN_VALUE;
		int meilleur = -1;
		for (int column =0; column<7; column++) {
			if (this.canPlay(column)) {
				int val = minMax(1,new Grille(this), column);
				if(max < val) {
					max = val;
					meilleur = column;
				}
			}
		}
		
		return meilleur;
		
	}
	public static int minMax(int prof,Grille gr,int coup ) {
		Grille grille = new Grille(gr);
		grille.jouerCoup(coup);
		if(prof == grille.PROFONDEUR_MAX) {
			return grille.eval();
		}
		if(prof %2 == 0) {
			int max = Integer.MIN_VALUE;
			for (int column =0;column<7; column++) {
				if (grille.canPlay(column)) {
					max = Integer.max(Grille.minMax(prof+1, grille, column),max);
				}
			}
			return max;
		}else {
			int min = Integer.MAX_VALUE;
			for (int column =0;column<7; column++) {
				if (grille.canPlay(column)) {
					int val =Grille.minMax(prof+1, grille, column);
					min = Integer.min(val,min);
				}
			}
			return min;
		}
	}
	
	public int eval(){
		int ret = 0;
		for(Chaine c : this.getAllmyChaines()) {
			ret+=c.eval();
		}
		Grille inv = this.getReverse();
		for(Chaine c : inv.getAllmyChaines()) {
			ret-=c.eval()*0.8;
		}
		return ret;
	}
	
	public HashSet<Chaine> getAllmyChaines(){
		HashSet<Chaine> ret = new HashSet<Chaine>();
		for(int x = 0; x<7; x++) {
			for(int y = 0; y<6; y++) {
				if(this.pions.get(new Coord(x,y))== ally) {
					ret.add(this.getChainesforMyCoord(new Coord(x,y), 1,1));
					ret.add(this.getChainesforMyCoord(new Coord(x,y), 0,1));
					ret.add(this.getChainesforMyCoord(new Coord(x,y), 1,0));
					ret.add(this.getChainesforMyCoord(new Coord(x,y), 1,-1));
				}
			}
			
		}
		return ret;
	}
	public Chaine getChainesforMyCoord(Coord coord , int horizontal , int vertical){
		Chaine ret = new Chaine();
		ret.addCoord(coord, true);

		int[] signes = {1,-1};
		for(int signe :  signes) {
			int x = coord.getX();
			int y = coord.getY();
			
			while(true) {
				x+=horizontal*signe;
				y+=vertical*signe;
				if(!(x < 7 && x >= 0 && y >= 0 && y < 6)) {
					break;
				}
				Character contenuCoord =this.pions.get(new Coord(x,y));
				if (contenuCoord== ally ||contenuCoord == null){
					ret.addCoord(new Coord(x, y), contenuCoord!= null);
				}else {
					break;
				}
				
			}
		}
		return ret;
	}
	
	public Grille getReverse() {
		Grille ret = new Grille(this);
		for (Coord c : ret.pions.keySet()) {
			if (ret.pions.get(c) == ally) {
				ret.pions.put(c, opponent);
			}else {
				ret.pions.put(c, ally);
			}
		}
		return ret;
	}
}
