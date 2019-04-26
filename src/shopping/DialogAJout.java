package shopping;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class DialogAJout extends JDialog {
		public DialogAJout(JFrame parent, String title, boolean modal) {
			super(parent,title,modal);
			this.setSize(200, 80);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			
		}
}
