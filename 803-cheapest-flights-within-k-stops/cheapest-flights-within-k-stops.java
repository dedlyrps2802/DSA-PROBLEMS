class Solution {

  static class Pairs implements Comparable<Pairs>{
    int id;
    int cost;
    int stops;

    Pairs(int id , int cost, int stops){
        this.id = id;
        this.cost = cost;
        this.stops = stops;
    }

    @Override
    public int compareTo(Pairs other){
        return Integer.compare(this.cost,other.cost);
    }
  }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      
     int[][] adj = new int[n][n];
     for(int[] flight: flights){
        adj[flight[0]][flight[1]] = flight[2];
     }
     
     int[] minstops = new int[n];

       Arrays.fill(minstops,Integer.MAX_VALUE);

       minstops[src] = 0;

       PriorityQueue<Pairs> pq = new PriorityQueue<>();

       pq.offer(new Pairs(src,0,0));

      while(!pq.isEmpty()){
        
        Pairs curr = pq.poll();

        if(curr.id == dst) return curr.cost;

        if(curr.stops > minstops[curr.id]) continue;
        minstops[curr.id] = curr.stops;

        if(curr.stops > k) continue;

        for(int next = 0 ; next < n ; next++){

            if(adj[curr.id][next] > 0){
                if(curr.stops <= k){
                    pq.offer(new Pairs(next,curr.cost + adj[curr.id][next], curr.stops +1));
                }
            }
        }
      }

      return -1;


    }
}