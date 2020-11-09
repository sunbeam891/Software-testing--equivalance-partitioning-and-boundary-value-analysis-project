package swen90006.xilften;

import java.util.List;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;
//import Xilften.StreamType;
import org.junit.*;
import static org.junit.Assert.*;

public class PartitioningTests
{

    protected Xilften xilften;

    //Any method annotated with "@Before" will be executed before each test,
    //allowing the tester to set up some shared resources.
    @Before public void setUp()
    {
	xilften = new Xilften();
    }

    //Any method annotated with "@After" will be executed after each test,
    //allowing the tester to release any shared resources used in the setup.
    @After public void tearDown()
    {
    }

    //Any method annotation with "@Test" is executed as a test.
    @Test public void aTest()
    {
	//the assertEquals method used to check whether two values are
	//equal, using the equals method
	final int expected = 2;
	final int actual = 1 + 1;
	assertEquals(expected, actual);
    }

    /*@Test public void DuplicateUserTest()
	throws DuplicateUserException, InvalidUsernameException
    {
	
    boolean DuplicateUserException = false;
        String Username = "Uname";
        String password = "password";
            try{
                xilften.register(Username, password);
                xilften.register(Username, password);
            }
            catch(DuplicateUserException e){
                DuplicateUserException =  true;
                }
        assertTrue (DuplicateUserException) ;

    }*/


//-----------------------------------------------------------------------------------------------------------------------------------------------------
//First Tree

//EC1
    @Test(expected = DuplicateUserException.class) public void test1()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Uname", "password");
    	assertTrue(xilften.isUser("Uname"));
    	xilften.register("Uname", "password");
    }

//EC2
    @Test(expected = InvalidUsernameException.class) public void test2()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Una", "password");
        assertTrue(xilften.isUser("Una"));
    }

//EC3
    @Test public void test3()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Unamer", "password");
        assertTrue(xilften.isUser("Unamer"));
    }

//EC4
    @Test(expected = InvalidUsernameException.class) public void test4()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Una#", "password");
        assertTrue(xilften.isUser("Una#"));
    }

//EC5
    @Test(expected = InvalidUsernameException.class) public void test5()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Una#<!_>", "password");
        assertTrue(xilften.isUser("Una#<!_>"));
    }
//EC6 
    @Test public void test311()
    throws DuplicateUserException, InvalidUsernameException
    {
      xilften.register("0123456789","password");
      assertTrue(xilften.isUser("0123456789"));
    }
//EC7
    @Test public void test322()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Unam1", "password");
        assertTrue(xilften.isUser("Unam1"));
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Second Tree

//EC1
    @Test(expected = NoSuchUserException.class) public void test6()
	    throws NoSuchUserException, IncorrectPasswordException
    {
        Date current = new Date(28,02,2020);
        Date returnd = new Date(05,03,2020);
        xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
    }

//EC2
    @Test(expected = IncorrectPasswordException.class) public void test7()
	    throws NoSuchUserException, IncorrectPasswordException, DuplicateUserException, InvalidUsernameException
    {
        xilften.register("Uname", "password");
        Date current = new Date(28,02,2020);
        Date returnd = new Date(05,03,2020);
        xilften.rent("Uname", "password1",current, returnd , Xilften.StreamType.SD);
    }

//EC3
    @Test public void test8()
	    throws NoSuchUserException, IncorrectPasswordException, DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2019);
        Date returnd = new Date(26,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }


//EC4 
    @Test public void test9()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(28,02,2019);
        Date returnd = new Date(01,03,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC5
    @Test public void test10()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,02,2019);
        Date returnd = new Date(25,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
  
//EC6
    @Test public void test11()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.1;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(27,2,1900);//changed here
        Date returnd = new Date(7,3,1900);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC7
    @Test public void test12()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(13,02,2019);
        Date returnd = new Date(14,03,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }


//EC8
    @Test public void test13()
	    throws NoSuchUserException, IncorrectPasswordException, DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(30,04,2019);
        Date returnd = new Date(30,04,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }


//EC9 
    @Test public void test14()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(30,06,2015);
        Date returnd = new Date(01,07,2015);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC10
    @Test public void test15()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,06,2019);
        Date returnd = new Date(25,06,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
  
//EC11
    @Test public void test16()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.1;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(31,12,2019);
        Date returnd = new Date(8,01,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC12
    @Test public void test17()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(30,9,2015);
        Date returnd = new Date(29,10,2015);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
   
//EC13
    @Test public void test18()
	    throws NoSuchUserException, IncorrectPasswordException, DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(29,02,2020);
        Date returnd = new Date(29,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
   
//EC14 
    @Test public void test19()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(29,02,2008); // changed here
        Date returnd = new Date(03,03,2008);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }   

//EC15
    @Test public void test20()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(24,02,2016);
        Date returnd = new Date(02,03,2016); //changed here
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }   
   
//EC16
    @Test public void test21()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.1;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(29,02,2000);
        Date returnd = new Date(8,03,2000);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
//EC17
    @Test public void test22()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(2,2,2004);
        Date returnd = new Date(2,3,2004);//changedhere
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    } 
  //EC18
    @Test public void test23()
	    throws NoSuchUserException, IncorrectPasswordException, DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2019);
        Date returnd = new Date(26,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }


//EC19 
    @Test public void test24()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2019);
        Date returnd = new Date(27,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC20
    @Test public void test25()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,02,2019);
        Date returnd = new Date(25,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
  
//EC21
    @Test public void test26()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.1;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,02,2019);
        Date returnd = new Date(26,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC22
    @Test public void test27()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 6.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(01,02,2019);
        Date returnd = new Date(04,03,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }


//EC23
    @Test public void test28()
	    throws NoSuchUserException, IncorrectPasswordException, DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,06,2019);
        Date returnd = new Date(26,06,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }


//EC24 
    @Test public void test29()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(30,01,2019);
        Date returnd = new Date(31,01,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC25
    @Test public void test30()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,06,2019);
        Date returnd = new Date(25,06,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
  
//EC26
    @Test public void test31()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.1;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(30,11,2015);
        Date returnd = new Date(8,12,2015);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }

//EC27
    @Test public void test32()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 6.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(03,06,2019);
        Date returnd = new Date(03,07,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
   
//EC28
    @Test public void test33()
	    throws NoSuchUserException, IncorrectPasswordException, DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2020);
        Date returnd = new Date(26,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
   
//EC29
    @Test public void test34()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2020);
        Date returnd = new Date(27,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }   

//EC30
    @Test public void test35()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(27,02,2012);
        Date returnd = new Date(04,03,2012);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }   
   
//EC31
    @Test public void test36()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.1;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,02,2020);
        Date returnd = new Date(26,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
//EC32
    @Test public void test37()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 6.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(03,02,2020);
        Date returnd = new Date(03,03,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
        
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }   
    
      
    //To test that an exception is correctly throw, specify the expected exception after the @Test
    @Test(expected = java.io.IOException.class) 
    public void anExceptionTest()
	throws Throwable
    {
	throw new java.io.IOException();
    }

    //This test should fail.
    //To provide additional feedback when a test fails, an error message
    //can be included
    @Test public void aFailedTest()
    {
	//include a message for better feedback
	final int expected = 2;
	final int actual = 1 + 2;
	//Uncomment the following line to make the test fail
	//assertEquals("This is a failure", expected, actual);
    }
}
