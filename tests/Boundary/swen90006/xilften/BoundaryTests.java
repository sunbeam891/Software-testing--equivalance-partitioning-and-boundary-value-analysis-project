package swen90006.xilften;

import java.util.List;
import java.util.ArrayList;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;

import org.junit.*;
import static org.junit.Assert.*;

//By extending PartitioningTests, we inherit tests from the script
public class BoundaryTests
    extends PartitioningTests
{
//-----------------------------------------------------------------------------------------------------------------------------------------------------
//First Tree
// Additional Tests containing OFF points

// Off point for EC1   
    @Test(expected = DuplicateUserException.class) public void Btest00()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Uname1", "password");
    	assertTrue(xilften.isUser("Uname1"));
    	xilften.register("Uname1", "password");
    }
    
// On point for EC2 
    @Test public void Btest0()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Unam", "password");
    	assertTrue(xilften.isUser("Unam"));
    }
// Off point for EC2     
    @Test(expected = InvalidUsernameException.class) public void Btest1()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("U", "password");
    	assertTrue(xilften.isUser("U"));
    }

// On point for EC2 
    @Test(expected = InvalidUsernameException.class) public void Btest2()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("", "password");
        assertTrue(xilften.isUser(""));
    }


    @Test(expected = InvalidUsernameException.class) public void Btest3()
    	throws DuplicateUserException, InvalidUsernameException
    {
        
    	xilften.register("Un1", "password");
        assertTrue(xilften.isUser("Un1"));
    }
    
    @Test public void userChar_5()
    throws DuplicateUserException, InvalidUsernameException
    {
      xilften.register("username123abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOPQRSTUVW","password");
      assertTrue(xilften.isUser("username123abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOPQRSTUVW"));
    }
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Second Tree
// Additional Tests containing OFF points
//SD
// Off point for EC4
    @Test public void Btest4()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2019);
        Date returnd = new Date(28,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC5
    @Test public void Btest5()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(20,02,2019);
        Date returnd = new Date(26,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// On point for EC6
    @Test public void Btest6()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(01,02,2019);
        Date returnd = new Date(01,03,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC9
    @Test public void Btest7()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,06,2019);
        Date returnd = new Date(28,06,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC10
    @Test public void Btest8()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,06,2019);
        Date returnd = new Date(24,06,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// On point for EC11
    @Test public void Btest9()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(03,06,2019);
        Date returnd = new Date(01,07,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC4
    @Test public void Btest10()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2020);
        Date returnd = new Date(28,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC15
    @Test public void Btest11()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 4.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,02,2020);
        Date returnd = new Date(24,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// On point for EC16
    @Test public void Btest12()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(03,02,2020);
        Date returnd = new Date(02,03,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.SD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }


//-----------------------------------------------------------------------------------------------------------------------------------------------------
// HD
// Off point for EC19  
    @Test public void Btest13()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(24,02,2100);
        Date returnd = new Date(26,02,2100);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC20
    @Test public void Btest14()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,02,2019);
        Date returnd = new Date(22,02,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// On point for EC21
    @Test public void Btest15()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 6.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(01,02,2019);
        Date returnd = new Date(01,03,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC24
    @Test public void Btest16()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,06,2100);
        Date returnd = new Date(29,06,2100);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC25
    @Test public void Btest17()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,06,2019);
        Date returnd = new Date(24,06,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// On point for EC26
    @Test public void Btest18()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 6.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(03,06,2019);
        Date returnd = new Date(01,07,2019);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC29
    @Test public void Btest19()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(26,02,2020);
        Date returnd = new Date(28,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// Off point for EC30
    @Test public void Btest20()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 5.0;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(18,02,2020);
        Date returnd = new Date(24,02,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }
// On point for EC31
    @Test public void Btest21()
	    throws NoSuchUserException, IncorrectPasswordException , DuplicateUserException, InvalidUsernameException
    {
        final double COST;
        final double expected = 6.5;
    
        xilften.register("Uname", "password");
        assertTrue(xilften.isUser("Uname"));
    
        Date current = new Date(03,02,2020);
        Date returnd = new Date(02,03,2020);
	
        COST= xilften.rent("Uname", "password",current, returnd , Xilften.StreamType.HD);
	
        assertEquals("This is a failure", expected, COST, 0.000);
    }



}
