/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ai_for_chess;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Timer;

/**
 *
 * @author Dinal
 */
public class ItsChess 
{
    //public static Timer timer = new Timer();
    static InputStreamReader reader = new InputStreamReader (System.in);
    // Wrap the reader with a buffered reader.
    static BufferedReader buf_in = new BufferedReader (reader);
	/**
	 * @param args
	 */
    public static int turns = 0;
        
    public static void main(String[] args) throws IOException {
        
    	//gameLoop();
        
        String move = AlphaBetaSearch.alphaBetaSearch();
        byte piece = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(0)));
        byte oldX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(2)));
        byte oldY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(1)));
        byte currX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(4)));
        byte currY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(3)));
        
        AlphaBetaSearch.board.movePiece(oldY, oldX, currY, currX);
        System.out.println(AlphaBetaSearch.board);
        
        move = AlphaBetaSearch.alphaBetaSearch();
        piece = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(0)));
        oldX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(2)));
        oldY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(1)));
        currX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(4)));
        currY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(3)));
        
        
        AlphaBetaSearch.board.movePiece(oldY, oldX, currY, currX);
        System.out.println(AlphaBetaSearch.board);
        
        move = AlphaBetaSearch.alphaBetaSearch();
        piece = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(0)));
        oldX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(2)));
        oldY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(1)));
        currX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(4)));
        currY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(3)));
        
        
        AlphaBetaSearch.board.movePiece(oldY, oldX, currY, currX);
        System.out.println(AlphaBetaSearch.board);
        
        move = AlphaBetaSearch.alphaBetaSearch();
        piece = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(0)));
        oldX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(2)));
        oldY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(1)));
        currX = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(4)));
        currY = Byte.parseByte(Character.toString(AlphaBetaSearch.bestMoves[0].charAt(3)));
        
        
        AlphaBetaSearch.board.movePiece(oldY, oldX, currY, currX);
        System.out.println(AlphaBetaSearch.board);
        
    }
    
    public static String fetchOtherMove() throws MalformedURLException, IOException
    {
    	String gameID = "1";
        String head = "http://www.mrt.ac.lk/chessgame/1";
        String head2 = "http://www.mrt.ac.lk/chessgame/2";
        String test;
        boolean moveRead = false;
        String otherMove = "";
    	
        String serverText = "";
        int moveIndex;

        URL url = new URL(head);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader res = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuffer sBuffer = new StringBuffer();
        String inputLine;
        while ((inputLine = res.readLine()) != null)
        	sBuffer.append(inputLine);
        res.close();
        serverText = sBuffer.toString();
        moveIndex = serverText.indexOf(":") + 1;
        String testfas = serverText.substring(moveIndex,sBuffer.indexOf(",")).trim();
        if(testfas.equals("true"))
        {
        	moveRead = true;
        	otherMove = serverText.substring(serverText.lastIndexOf(":")+3, serverText.lastIndexOf("}")-1);
        	return otherMove;
        }
        return "";
    	
    }
    
    public static void gameLoop() throws MalformedURLException, IOException 
    {
    	//implementation
    }
}
