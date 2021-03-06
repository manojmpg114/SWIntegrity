import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import java.util.List;

public class JavaOverflowTest {
    JavaAnalyzer jana;
    JavaIntegerOverflowVulnerability vuln;
    @Before
    public void setup() {
        jana = new JavaAnalyzer();
        vuln = new JavaIntegerOverflowVulnerability();
        jana.parse("./TestFiles\\OverFlow.java");
    }


    @Test
    public void test() {
        List<Integer> locs = vuln.run(jana);
        assertTrue(locs.size() == 3);
        assertTrue(locs.contains(21));
        assertTrue(locs.contains(23));
        assertTrue(locs.contains(20));
    }
}
