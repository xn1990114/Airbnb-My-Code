package phone;
import java.util.*;

public class WizardDistance {
	public class Wizard{
		int ID;
		List<Wizard> neighbor;
		public Wizard(int ID){
			this.ID=ID;
			this.neighbor=new ArrayList<Wizard>();
		}
		public void addNeighbor(Wizard w){
			this.neighbor.add(w);
		}
	}
	public int calMinDistance(Wizard[] wizards,int from,int to){
		boolean[] visited=new boolean[wizards.length];
		Map<Wizard,Integer> indexMap=new HashMap<Wizard,Integer>();
		for(int i=0;i<wizards.length;i++){
			indexMap.put(wizards[i], i);
		}
		// index 0 is wizard index, index 1 is currCumulative Dis
		PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){
			public int compare(int[] i1,int[] i2){
				if(i1[1]==i2[1]){
					return i1[0]-i2[0];
				}
				return i1[1]-i2[1];
			}
		});
		int[] ori={from,0};
		pq.offer(ori);
		while(!pq.isEmpty()){
			int[] top=pq.poll();
			if(top[0]==to){
				return top[1];
			}
			Wizard w=wizards[top[0]];
			if(visited[top[0]]){
				continue;
			}
			visited[top[0]]=true;
			for(Wizard n:w.neighbor){
				int index=indexMap.get(n);
				if(!visited[index]){
					int[] toadd={index,(index-top[0])*(index-top[0])+top[1]};
					pq.offer(toadd);
				}
			}
		}
		return -1;
	}
}
