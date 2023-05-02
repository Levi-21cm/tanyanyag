import junit.framework.TestCase;
import org.example.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class teruletTeszt {

    @Test
    public void korTerulet5sugarral(){
        assertEquals(78.5, Main.terulet(5));
    }
    @Test
    public void korterulet10sugarral(){
        assertEquals(314, Main.terulet(10));
    }
    @Test
    public void korterulet13sugarral(){
        assertEquals(530.66, Main.terulet(13));
    }
    @Test
    public void korterulet15sugarral() {
        assertEquals(706.5, Main.terulet(15));
    }
    @Test
    public void korterulet50sugarral(){
        assertEquals(7850, Main.terulet(50));
    }
}
