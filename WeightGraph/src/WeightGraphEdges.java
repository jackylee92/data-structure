public class WeightGraphEdges implements Comparable<WeightGraphEdges> {
    private int v, w, weight;
    public WeightGraphEdges(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightGraphEdges o) {
        return weight - o.weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V:"+v);
        sb.append("W:"+w);
        sb.append("Weight:"+weight);

        return sb.toString();
    }
}