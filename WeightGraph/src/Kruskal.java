import java.util.ArrayList;
import java.util.Collections;

class Kruskal {
    private WeightGraph G;
    private ArrayList<WeightGraphEdges> mst; 
    public Kruskal(WeightGraph G) {
        this.G = G;
        mst = new ArrayList<WeightGraphEdges>();

        CC1 cc = new CC1(G);
        if (cc.getCCount() > 1) return;  // 如果不是连通的图直接返回

        ArrayList<WeightGraphEdges> edges = new ArrayList<>();
        for (int v=0; v < G.V(); v++) {
            for (int w: G.adj(v)){
                // 保存同一条边只处理一次
                if (v < w)  
                    edges.add(new WeightGraphEdges(v, w, G.getWeight(v, w)));
            }
        }

        Collections.sort(edges);
    }
}