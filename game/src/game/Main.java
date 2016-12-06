package game;

import java.util.Scanner;

import items.*;

public class Main {
	public static final int WIDTH = 4;
	public static final int HEIGHT = 4;
	public static final String HELLO_MSG = "Hello, you are playing in a " + WIDTH + " x " + HEIGHT
			+ " map. \nPlease type an action { go(moves foward), shoot(shoots foward), left(turns), right(turns) }.\nExample: go \nYou are in the left bottom corner facing up.\n";
	public Player player;
	public Item[] items;
	public boolean hasGold = false;
	public boolean end = false;

	public static void main(String[] parametro) {
		Main m = new Main();
		m.player = new Player(1, 1);
		m.items = new Item[4];
		m.items[0] = new Wumpus(3, 3);
		m.items[1] = new Pit(4, 2);
		m.items[2] = new Pit(2, 2);
		m.items[3] = new Gold(2, 4);
		Scanner keyboard = new Scanner(System.in);
		String input;
		System.out.print(HELLO_MSG);
		System.out.print("> ");
		while (!m.end && m.player.alive) {

			input = keyboard.next();
			if (checkInput(input)) {
				
				m.player.run(input, m);
				checkSmells(m.items, m.player);
				if (checkGold(m.items[m.items.length - 1], m.player)) m.hasGold = true;
				if (checkFinish(m)) m.end = true;
				
			} else
				System.out.print("I did not understand.\n> ");

		}
		keyboard.close();
		if (m.player.alive)
			System.out.print("WINNER");

	}

	private static boolean checkFinish(Main m) {
		if (m.hasGold && m.player.getX() == 1 && m.player.getY() == 1)
			return true;
		return false;
	}

	private static boolean checkGold(Item i, Player p) {
		// TODO Auto-generated method stub
		if (i.getX() == p.getX() && i.getY() == p.getY()) {
			System.out.print("You found the gold, now you can comeback to the starter point.\n> ");
			return true;
		}
		return false;
	}

	public static void checkSmells(Item[] enemys, Player player) {
		for (Item e : enemys) {
			if (e != null) {
				if (e.isClose(player.getX(), player.getY())) {
					e.printWarning();
				}
				if (e.getX() == player.getX() && e.getY() == player.getY() && e.killer) {
					 System.out.print("You just died.\n> ");
				}
			}
		}
	}

	public static boolean checkInput(String input) {
		if (input.equalsIgnoreCase("go") || input.equalsIgnoreCase("shoot") || input.equalsIgnoreCase("left")
				|| input.equalsIgnoreCase("right")) {
			return true;
		}
		return false;
	}

}
