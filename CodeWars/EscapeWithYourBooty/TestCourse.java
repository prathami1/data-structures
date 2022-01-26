import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class TestCourse {
    @Test
    public void BasicCourses() {
        char[][] map = new char[5][6];
        char[] line1 = {'0','0','0','0','N','0'};
        char[] line2 = {'0','0','0','0','0','0'};
        char[] line3 = {'X','0','0','0','0','0'};
        char[] line4 = {'0','0','0','0','0','0'};
        char[] line5 = {'0','0','0','0','0','0'};
        map[0] = line1;
        map[1] = line2;
        map[2] = line3;
        map[3] = line4;
        map[4] = line5;
        assertEquals(false,Course.checkCourse(map));
        
        char[][] map2 = new char[5][6];
        char[] line11 = {'0','0','0','0','0','0'};
        char[] line12 = {'0','0','0','0','0','0'};
        char[] line13 = {'X','0','0','0','0','0'};
        char[] line14 = {'0','0','0','0','0','0'};
        char[] line15 = {'0','0','N','0','0','0'};
        map2[0] = line11;
        map2[1] = line12;
        map2[2] = line13;
        map2[3] = line14;
        map2[4] = line15;
        assertEquals(false,Course.checkCourse(map2));
    }
}
