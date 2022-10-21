//displaying the application of fonts
import java.applet.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
public class ShowFonts4 extends Applet implements ItemListener
{
   Choice ch,style,size;
   String FontList[];
   String msg,msg1,mssg;
   int p;
   Font f;
   public void init()
   {
       ch=new Choice();
	   size=new Choice();
	   style=new Choice();
	   //f=new Font("Dialog",Font.PLAIN,12);
	   //setFont(f);
	   msg="";
	   msg1="";
	   mssg="Sample Font";
	  GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
	  FontList=ge.getAvailableFontFamilyNames();
	  for(int i=0;i<FontList.length;i++)
	  {	  
	   ch.add(FontList[i]);
	  }
	  for(int i=10;i<=72;i++)
	  {
	    size.add(Integer.toString(i));
	  }
	  style.add("PLAIN");
	  style.add("BOLD");
	  style.add("ITALIC");
	  add(ch);
	  add(size);
	  add(style);
	  ch.addItemListener(this);
	  size.addItemListener(this);
	  style.addItemListener(this);
	  
	  
   }
   public void itemStateChanged(ItemEvent e)
   {
			p=Integer.parseInt(size.getSelectedItem());
	   		msg=ch.getSelectedItem();
	     	msg1=style.getSelectedItem();
			if(msg1.equals("PLAIN"))
			 f=new Font(ch.getSelectedItem(),Font.PLAIN,p);
			if(msg1.equals("BOLD"))
			f=new Font(ch.getSelectedItem(),Font.BOLD,p);
			if(msg1.equals("ITALIC"))
			f=new Font(ch.getSelectedItem(),Font.ITALIC,p);
	   	    repaint();
   }
   public void paint(Graphics g)
   {
	   g.setFont(f);
	   g.drawString(mssg,80,50);
   }
   
   
}