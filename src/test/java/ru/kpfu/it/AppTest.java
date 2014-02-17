package ru.kpfu.it;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static ru.kpfu.it.App.addTodo;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testAddTodo() {
        String answer;

        answer = addTodo("add Test");
        assertEquals("Correct add", "Done.", answer);
        assertEquals("Store has 1 element", 1, App.store.size());
        assertEquals("Correct title", "Test", App.store.get(1L).getTitle());

        answer = addTodo("add");
        assertEquals("Empty add", "Missing title.", answer);

        answer = addTodo("add  ");
        assertEquals("Empty add with spaces", "Missing title.", answer);
    }
}
