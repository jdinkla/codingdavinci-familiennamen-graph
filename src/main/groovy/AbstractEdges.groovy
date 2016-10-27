/**
 * (c) 2016, Jörn Dinkla, http://www.dinkla.net
 *
 * see the file LICENSE in the root directory
 */
import org.apache.commons.lang3.StringUtils

import java.time.Instant

abstract class AbstractEdges {

    protected List<String> names
    protected List<Edge> edges;

    protected Integer[][] distanceMemo;

    public AbstractEdges() {
        names = null;
        edges = new LinkedList();
    }

    /* TODO memo for small n
    public void init(List<String> names) {
        this.names = names;
        final int n = names.size();
        //distanceMemo = new Integer[n][n];
    }
    */

    static public int distance(final String a, final String b) {
        return StringUtils.getLevenshteinDistance(a, b, 1);
    }

    abstract void calcEdges(final List<String> names);

    public void saveEdges(final String path) {
        def bufferedWriter = new BufferedWriter ( new FileWriter ( path ) );

        println "Saving ${edges.size()} edges"

        for (edge in edges) {
            final String nameI = edge.i
            final String nameJ = edge.j
            bufferedWriter.write("$nameI\t$nameJ\n")
        }

//        for (edge in edges) {
//            final String nameI = names[edge.i]
//            final String nameJ = names[edge.j]
//            bufferedWriter.write("$nameI\t$nameJ\n")
//        }

        bufferedWriter.flush()
        bufferedWriter.close()

        println "edges saved"
    }

}
