package zhipai_ganme;

import java.util.ArrayList;
import java.util.List;

public class Plays {
	public int id;
	public String name;
	public List<PKP>Pcards;
	
	public Plays(int id, String name) {
		this.id = id;
		this.name = name;
		Pcards = new ArrayList<PKP>();
	}
	
	
}
