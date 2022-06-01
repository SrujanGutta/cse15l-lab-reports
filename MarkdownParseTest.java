import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
public class MarkdownParseTest {

    @Test
    public void snippet1(){
        MarkdownParse md = new MarkdownParse();
        ArrayList<String> snippet1Expected = new ArrayList<String>();
        snippet1Expected.add("`google.com");
        snippet1Expected.add("google.com");
        snippet1Expected.add("ucsd.edu");
        System.out.print(snippet1Expected);
        Object[] snip1 = snippet1Expected.toArray();
        try {
            assertArrayEquals(snip1, md.callingfunc("snippet1.md"));
        }
        catch (Exception e){
            System.out.print("oof");
        }
    }

    @Test
    public void snippet2(){
        MarkdownParse md = new MarkdownParse();
        ArrayList<String> snippet2Expected = new ArrayList<String>();
        snippet2Expected.add("a.com");
        snippet2Expected.add("a.com(())");
        snippet2Expected.add("example.com");
        System.out.print(snippet2Expected);
        Object[] snip2 = snippet2Expected.toArray();
        try {
            assertArrayEquals(snip2, md.callingfunc("snippet2.md"));
        }
        catch (Exception e){
            System.out.print("oof");
        }
    }

    @Test
    public void snippet3(){
        MarkdownParse md = new MarkdownParse();
        ArrayList<String> snippet3Expected = new ArrayList<String>();
        snippet3Expected.add("https://www.twitter.com");
        snippet3Expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        snippet3Expected.add("https://cse.ucsd.edu/");
        System.out.print(snippet3Expected);
        Object[] snip3 = snippet3Expected.toArray();
        try {
            assertArrayEquals(snip3, md.callingfunc("snippet3.md"));
        }
        catch (Exception e){
            System.out.print("oof");
        }
    }
}