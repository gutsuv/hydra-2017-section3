import java.util.ArrayList;

public class PuzzleDebuff extends Puzzle
{
	private int itemId;
	private boolean active = false;
	
	public PuzzleDebuff(String loadedString)
	{
		// loaded from file
		// int puzzleId String name, int roomId String puzzleDesc,
		// String hint, String answer1, String answer2
		try
		{
			String[] splitString = loadedString.split("-_");
			puzzleId = Integer.parseInt(splitString[0]);
			puzzleName = splitString[1];
			//debuff = Integer.parseInt(splitString[2]);
			itemId = Integer.parseInt(splitString[3]);
			puzzleDesc = splitString[4];
			hint = splitString[5];
		}
		catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include PuzzleDebuff in the text message");
		}
	}
	
	public boolean isActive()
	{
		return active;
	}
	
	@Override
	public void initialize()
	{
		// idk
	}

	@Override
	public void attemptSolve(String answer)
	{
		solved = true;
	}
	public void printPoison()
	{
		view.line(125);
		view.printString("You drink the vial and begin to fall sick."
				+ " It was poison! Where�s the antidote?",125);
		active = true;
	}

	@Override
	public void attemptSolve(int itemId)
	{
		// no effect
	}

	@Override
	public void display()
	{
		view.line(125);
		view.print(puzzleName);
		view.printString(puzzleDesc);
		view.print("drink:");
		view.print("hint:");
		view.print("exit:");
	}
}
