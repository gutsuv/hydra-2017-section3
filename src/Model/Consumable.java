package Model;
/**
 * Class: Consumable
 * @author Team Hydra
 * @version 1.0
 * Course: ITEC 3150
 * Written: January 22, 2017
 * 
 * This class sets the effects consumable items that are found in the game
 * 
 * Purpose: Contains the attributes of consumable items and their commands
 */
public class Consumable extends Item
{
	protected int healthEffect;
	protected int maxHealthEffect;

	/**
     * Method: Consumable()
     * Class constructor and file reader for consumables items
     * @param none
     * @return nothing
     */
	public Consumable(String loadedString)
	{
		// loaded from file
		// int itemID, String itemName, int healthEffect
		// int maxHealthEffect, String itemDescShort, String itemDescLong

		try
		{
			String[] splitString = loadedString.split("-_");
			itemId = Integer.parseInt(splitString[0]);
			itemName = splitString[1];
			healthEffect = Integer.parseInt(splitString[2]);
			maxHealthEffect = Integer.parseInt(splitString[3]);
			itemDescShort = splitString[4];
			itemDescLong = splitString[5];

		} 
		catch (Exception E)
		{
			System.out.println("Text Spencer Williams to fix this. I might have messed up a TextFile."
					+ "I can fix it in like 30 minutes. Include Consumable in the text message");
		}

	}
	/**
     * Method: getHealthEffect()
     * Retrieves consumable items's health effect
     * @param none
     * @return healthEffect 
     */
	public int getHealthEffect()
	{
		return healthEffect;
	}
	/**
     * Method: getMaxHealthEffect()
     * Retrieves consumable items's max health effect
     * @param none
     * @return maxHealthEffect 
     */
	public int getMaxHealthEffect()
	{
		return -maxHealthEffect;
	}

	@Override
	public void use()
	{
	}

	// code moved because I can't make an object delete itself without using outside
	// method
	@Override
	public void drop()
	{
	}
	// code moved because I can't make an object delete itself without using outside
	// method

	@Override
	/**
     * Method: examine()
     * Displays consumable items's long descriptiom
     * @param none
     * @return void
     */
	public void examine()
	{
		view.printString((healthEffect + ": " + itemDescLong), 125);
	}
	@Override
	/**
     * Method: getDisplay()
     * Retrieves consumable items's display prompt
     * @param none
     * @return itemName + "-> use, drop, examine:"
     */
	public String getDisplay()
	{
		return itemName + "-> use, drop, examine:";
	}

	@Override
	/**
     * Method: displayCommands()
     * Prints the consumable item commands
     * @param none
     * @return nothing 
     */
	public void displayCommands()
	{
		view.line(125);
		view.print(itemName);
		view.print("use:");
		view.print("drop:");
		view.print("examine:");
		view.print("exit:");
	}
}