/**
 * (c) 2016, Jörn Dinkla, http://www.dinkla.net
 *
 * see the file LICENSE in the root directory
 */
class Edge {

    final String i
    final String j

    public Edge(final String i, final String j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

/*
class EdgeX {

    final int i
    final int j

    public EdgeX(final int i, final int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
*/
