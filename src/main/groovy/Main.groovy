/**
 * Created by Dinkla on 09.10.2016.
 *
 * see the file LICENSE in the root directory
 */
class Main {

    static final String IN_PATH = "familiennamen.csv"
    static final String OUT_PATH = "edges.csv"

    public static void main(String[] args) {

        def f = new File(IN_PATH)
        List<String> names = f.text.split("\n")

        def e = new EdgesParJ()
        //def e = new EdgesStreamJ()
        e.calcEdges(names)

        e.saveEdges(OUT_PATH);

    }

}
