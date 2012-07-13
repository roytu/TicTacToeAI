import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ai.IMinimax;

public class Board {
	enum Square {NONE, PLAYER, COMPUTER}
	GameData gameData;
	Square[] data;
	public Board(GameData gameData)
	{
		this.gameData=gameData;
		data=new Square[9];
		for(int i=0;i<9;i++)
		{
			data[i]=Square.NONE;
		}
	}
	public void userMove()
	{
		BufferedReader read;
		read=new BufferedReader(new InputStreamReader(System.in));
		
		try
		{
			data[Integer.parseInt(read.readLine())]=Square.PLAYER;
		}
		catch(IOException ioe)
		{
			System.out.println("u dubm");
		}
	}
	public void compMove()
	{
		class Minimax implements IMinimax{
			public void LoopThroughMoves()
			{
				for(int i=0;i<9;i++)
				{
					Board b=new Board(gameData);
					b.data[i]=Square.COMPUTER;
					for(int i2=0;i2<9;i2++)
					{
						Board b2=new Board(gameData);
						b2.data[i]=Square.PLAYER;
						//for(int) etc...
					}
				}
			}
		}

		
		/*
		 * create new minimax
		 * override minimax 
		 */
		
		
		/*
		 * for all squares:
		 * 		create new board
		 * 		comp move to square
		 * 		for all squares
		 * 			create new board
		 * 			player move to square
		 * 			for all squares
		 * 				create new board
		 * 				comp move to square
		 * 				...
		 *  
		 */
		data[0]=Square.COMPUTER;
	}
	public void displayBoard()
	{
		for(int i=0;i<9;i++)
		{
			switch(data[i])
			{
			case NONE:
				System.out.print(0);
				break;
			case PLAYER:
				System.out.print(1);
				break;
			case COMPUTER:
				System.out.print(2);
				break;
			}
			if(i%3==2)
			{
				System.out.println();
			}
		}
	}
	public boolean isWon(Square user)
	{
		for(int x=0;x<3;x++)
		{
			if(data[x*3]==user && data[x*3+1]==user && data[x*3+2]==user)
			{
				return true;
			}
		}
		for(int x=0;x<3;x++)
		{
			if(data[x]==user && data[x+3]==user && data[x+6]==user)
			{
				return true;
			}
		}
		if(data[0]==user && data[4]==user && data[8]==user)
		{
			return true;
		}
		if(data[2]==user && data[4]==user && data[6]==user)
		{
			return true;
		}
		return false;
	}
	public boolean checkWinCondition()
	{
		if(isWon(Square.PLAYER))
		{
			System.out.println("PLAYER WIN");
			return true;
		}
		if(isWon(Square.COMPUTER))
		{
			System.out.println("COMP WIN");
			return true;
		}
		return false;
	}
}