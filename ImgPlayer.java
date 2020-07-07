import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JApplet;
public class ImgPlayer extends JApplet {
	private Image img;
	public void init() {
		img = getImage(getCodeBase(),"car.jpg");
	}
	public void paint(Graphics g){
g.drawImage(img,10,10,this);  //±‡–¥paint∑Ω∑®œ‘ æÕº∆¨car.jpg
}
}
