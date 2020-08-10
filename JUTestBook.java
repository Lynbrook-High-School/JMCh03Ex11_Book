
import java.util.Scanner;

import org.junit.*;

import student.TestCase;
import static student.testingsupport.ReflectionSupport.*;

/**
 * JUTestBook.java  08/26/16
 *
 * @author - George Peck
 * @author - Assignment - JM Ch3, Ex11 Book
 * @author - Lynbrook High School
 */
public class JUTestBook extends TestCase
{
    private final static int NUM_PAGES = 4;

    @Test
    public void testBookTest()
    {
        BookTest.main( null );

//        System.err.println( systemOut().getHistory() );

        @SuppressWarnings("resource")
        Scanner scan = new Scanner( systemOut().getHistory() );

        int outNum = 0;

        if ( scan.hasNextInt() )
        {
            outNum = scan.nextInt();
            assertEquals( "BookTest.main: expected 3 for getNumPages", 3, outNum );
        }
        else
        {
            fail( "BookTest.main: 1st output value not found or incorrect type" );
        }

        if ( scan.hasNextInt() )
        {
            outNum = scan.nextInt();
            assertEquals( "BookTest.main: expected 1 for initial getCurrentPage", 1,
                          outNum );
        }
        else
        {
            fail( "BookTest.main: 2nd output value not found or incorrect type" );
        }

        if ( scan.hasNextInt() )
        {
            outNum = scan.nextInt();
            assertEquals( "BookTest.main: expected 2 after 1st call to nextPage", 2,
                          outNum );
        }
        else
        {
            fail( "BookTest.main: 3rd output value not found or incorrect type" );
        }

        if ( scan.hasNextInt() )
        {
            outNum = scan.nextInt();
            assertEquals( "BookTest.main: expected 3 after 2nd call to nextPage", 3,
                          outNum );
        }
        else
        {
            fail( "BookTest.main: 4th output value not found or incorrect type" );
        }

        if ( scan.hasNextInt() )
        {
            outNum = scan.nextInt();
            assertEquals( "BookTest.Main: expected 3 after 3rd call to nextPage", 3,
                          outNum );
        }
        else
        {
            fail( "BookTest.main: 5th output value not found or incorrect type" );
        }
    }

    @Test
    public void testBookConstructor()
    {
        Object bk = create( "Book", NUM_PAGES);
        //Book bk = new Book( NUM_PAGES );

        assertNotNull( "Book.Book: unable to create Book", bk );
    }

    @Test
    public void testGetNumPages()
    {
        Object bk = create( "Book", NUM_PAGES);
        //Book bk = new Book( NUM_PAGES );

        int numPages = invoke(bk, int.class, "getNumPages");
        assertEquals( "Book.getNumPages: incorrect number of pages", NUM_PAGES, numPages );
    }

    @Test
    public void testGetCurrentPage()
    {
        Object bk = create( "Book", NUM_PAGES);
        //Book bk = new Book( NUM_PAGES );

        int currentPage = invoke(bk, int.class, "getCurrentPage");
        assertEquals( "Book.getCurrentPage: invalid initial current page", 1, currentPage );
    }

    @Test
    public void testNextPage()
    {
        Object bk = create( "Book", NUM_PAGES);
        //Book bk = new Book( NUM_PAGES );

        invoke(bk, void.class, "nextPage");
        int currentPage = invoke(bk, int.class, "getCurrentPage");
        assertEquals( "Book.nextPage: fail", NUM_PAGES - 2, currentPage );

        invoke(bk, void.class, "nextPage");
        currentPage = invoke(bk, int.class, "getCurrentPage");
        assertEquals( "Book.nextPage: fail after 2 calls",
            NUM_PAGES - 1, currentPage );
    }
}
