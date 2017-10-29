package main;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.Toolkit;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Mian implements ClipboardOwner{
	
	public static void main(String[] args) throws UnsupportedFlavorException, IOException {
		
		String string = null;
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		try {
			string = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Past length: " +string.length());
		// got the content of clipboard 
		
		//	System.out.println(string);
		
		
		Matcher m = Pattern.compile("(?=(<sup))").matcher(string);
		List<Integer> pos = new ArrayList<Integer>();
		while (m.find())
		{
		    pos.add(m.start());
		}
		//System.out.println(pos);
		
		Matcher m2 = Pattern.compile("(?=(</sup>))").matcher(string);
		List<Integer> pos2 = new ArrayList<Integer>();
		while (m2.find())
		{
		    pos2.add(m2.start());
		}
		//System.out.println(pos2);
		
		for (int i = pos.size()-1; i >=0 ; i--) {
			
			String subString = string.substring(pos.get(i), pos2.get(i)+6);
			if (subString.length()<13 ) 
				continue;
			if (subString.contains("<sup") && subString.contains("</sup>")) {
				//System.out.println(subString+"\n");
				string = string.replace(subString, "");
			}
			
			
			
		}
		
		 string = string.replaceAll("<a[^>]*>(.*?)</a>", "$1");
		
		
		
		
		
	//	Matcher.quoteReplacement(string)
		
		// putting new data
		StringSelection selection = new StringSelection(string);
	    clipboard.setContents(selection, selection);
	    
	    System.out.println("Present length: " +string.length());
	   System.out.println("Total replace : " + pos.size());
		//System.out.println(clipboard.getData(DataFlavor.stringFlavor));
	    System.out.println("Done");

	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		// 966
		//222 065 790
	}
	
	

}
