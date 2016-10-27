/**
 * (c) 2016, Jörn Dinkla, http://www.dinkla.net
 *
 * see the file LICENSE in the root directory
 */

import net.dinkla.utils.Timer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EdgesParJ extends AbstractEdges {

    static final long LOG_ITER = 1000;
    private long i;

    static public Optional<Edge> op(String nameI, String nameJ) {
        final int d = distance(nameI, nameJ);
        if (d == 1) {
            return Optional.of(new Edge(nameI, nameJ));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void calcEdges(List<String> names) {
        this.names = names;
        final long n = names.size();
        net.dinkla.utils.Timer t = new Timer(n);
        i = 0;
        Stream<Optional<Edge>> es =
            names.parallelStream()
                    // debug .limit(3 * 1000)
                    .flatMap(nameI -> {

                if (i % LOG_ITER == 0) {
                    System.out.println(i);
                    t.setCurrentWork(i);
                    System.out.println(t.getMsg());
                }
                synchronized (this) {
                    i++;
                }

                return names.stream().map(nameJ -> {
                    return op(nameI, nameJ);
                });
            });
        edges = es
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
