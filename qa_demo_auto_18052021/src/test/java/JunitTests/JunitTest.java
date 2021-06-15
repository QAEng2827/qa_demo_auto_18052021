package JunitTests;

import org.junit.*;

public class JunitTest {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After class");
    }
    @Before
    public void before(){
        System.out.println("Before ");
    }
    @After
    public void after(){
        System.out.println("After ");
    }

    @Test
    public void test(){
        System.out.println("Test");
        Assert.assertEquals("Expected val: ", "expected res","аctual res");
    }
    @Test (timeout = 1000)
    public void test1(){
        System.out.println("Test1");
    }

}
