/**
 * (c) 2016, Jörn Dinkla, http://www.dinkla.net
 *
 * see the file LICENSE in the root directory
 */
import java.time.Instant

class EdgesSeq extends AbstractEdges {

    static final int LOG_ITER = 100

    List<String> names
    List<Edge> edges;

    public EdgesSeq() {
        edges = new LinkedList();
    }

    void calcEdges(final List<String> names) {
        this.names = names
        def t = new net.dinkla.utils.Timer(names.size())
        final int n = names.size();
        for (int i=0; i<n; i++) {
            final String nameI = names[i];
            if (i % LOG_ITER == 0) {
                println i;
                t.setCurrentWork(i)
                println "Work done ${t.percentageWorkDone}, time ${Instant.now()}, estimated finish time ${t.estimate()}"
            }
            for (int j = 0; j<n; j++) {
                if (i != j) {
                    final String nameJ = names[j]
                    final int d = distance(nameI, nameJ);
                    if (d == 1) {
                        edges.add(new Edge(nameI, nameJ));
                    }
                }
            }
        }
    }

}
