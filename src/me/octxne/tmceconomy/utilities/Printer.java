package me.octxne.tmceconomy.utilities;

import me.octxne.tmceconomy.core.TMCEconomy;
import me.octxne.tmceconomy.utilities.type.PrinterType;

public class Printer
{
	public static void printToConsole(String text, PrinterType type)
	{
		switch (type)
		{
		case NORMAL:
			System.out.println(TMCEconomy.getInstance().getPrefix() + " " + text);

			break;

		case WARNING:
			System.out.println(TMCEconomy.getInstance().getPrefix() + " (WARNING) " + text);

			break;

		case ERROR:
			System.out.println(TMCEconomy.getInstance().getPrefix() + " (ERROR) " + text);
		}
	}
}
