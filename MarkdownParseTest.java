import static org.junit.Assert.*;
import org.junit.*;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    public void getLinks(){
        MarkdownParse md = new MarkdownParse();
        md.getLinks();
    }
}