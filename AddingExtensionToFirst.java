package main;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class AddingExtensionToFirst  implements ClipboardOwner{

	public static void main(String[] args)  throws UnsupportedFlavorException, IOException{

		String string = null;
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		try {
			string = (String) clipboard.getData(DataFlavor.stringFlavor);
		} catch (UnsupportedFlavorException | IOException e) {
			e.printStackTrace();
		}
		
		string = string.replaceAll("&nbsp;", " ");
		
		String cssStyle = "<style>  table, th "
				+ "{ "
				+ "border: 1px solid #e0e0e0; "
				+ "border-spacing:10px 10px; "
				+ "} "
				+ "table { "
				+ "border-collapse: collapse; "
				+ "width: 100%; "
				+ "} "
				+ "td{ "
				+ "border: 1px solid #e0e0e0; "
				+ "margin-bottom: 2dp;"
				+ "} "
				+ "th {"
				+ "text-align: left;"
				+ "} "
				+ "table tr:nth-child(odd) td {"
				+ "background-color: #EEEEEE;"
				+ "} "
				+ ""
				+ "img{"
				+ "display: inline;"
				+ "height: auto;"
				+ "max-width: 100%;"
				+ "display: block;"
				+ "margin: 0 auto;"
				+ "} "
				+ "</style>";
		string = cssStyle + string;
		
		System.out.println("Css Style Added");
		string = string  + " <br><br><br>"; 
		System.out.println("New Line  Added");
		
		// putting new data
				StringSelection selection = new StringSelection(string);
			    clipboard.setContents(selection, selection);
			    System.out.println("Copied to clibBoard!!!");

	}

	@Override
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}

}
