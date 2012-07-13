public class GameData {
	enum Players {USER, COMPUTER}
	public Board board;
	public GameData()
	{
		this.board=new Board(this);
	}
	public void Run()
	{
		while(true)
		{
			board.userMove();
			board.compMove();
			board.displayBoard();
			if(board.checkWinCondition())
			{
				break;
			}
		}
	}
}