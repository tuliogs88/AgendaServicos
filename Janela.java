import java.awt.*;
import javax.swing.*;
public class Janela extends JFrame {

	public Janela(String titulo, Dimension tamanho) {
		
		setTitle(titulo);
		setSize(tamanho);
		centralize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		getContentPane().setLayout(null);
		
	}
	
	public void centralize() {
		
		Dimension T = Toolkit.getDefaultToolkit().getScreenSize();
		
		Dimension J = getSize();
		
		if (J.height > T.height) setSize(J.width,T.height);
		if (J.width > T.width) setSize(T.width,J.height);
		
		setLocation((T.width - J.width) /2,(T.height - J.height) /2);
		
	}
	public static void main(String[] args) {
		
		Janela jan = new Janela("Janela", new Dimension(800,600));
		jan.setVisible(true);
	}
}		
