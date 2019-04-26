package shopping;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ToPDF extends JButton{
	private Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
	private JTable tableau ;
	private static String USER_PASSWORD = "password";
	private static String OWNER_PASSWORD = "root";
	
	public ToPDF(JTable tab) {
		
		super("PDF");
		this.tableau = tab ; 
		this.setSize(20,20);
		this.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPDF();				
			}
		});
	}
	
	private void setPDF() {
		
		try {
            Document doc = new Document(PageSize.A4.rotate());
            
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("table5.pdf"));
            writer.setEncryption(USER_PASSWORD.getBytes(),
                    OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,
                    PdfWriter.ENCRYPTION_AES_128);
            doc.open();
            PdfPTable pdfTable = new PdfPTable(tableau.getColumnCount());
            
            //adding table headers
            for (int i = 0; i < tableau.getColumnCount(); i++) {
                pdfTable.addCell(tableau.getColumnName(i) );
            }
            //extracting data from the JTable and inserting it to PdfTable
            for (int rows = 0; rows < tableau.getRowCount() - 1; rows++) {
                for (int cols = 0; cols < tableau.getColumnCount(); cols++) {
                    pdfTable.addCell(tableau.getModel().getValueAt(rows, cols).toString());

                }
            }
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(Calendar.getInstance().getTime());
            doc.add(new Paragraph("Shopping List"));
            doc.add(new Paragraph(timeStamp));
            doc.add(new Paragraph("\n"));
            doc.addCreationDate();
            doc.addCreator("ShoppingEasyList");
            doc.addTitle("Shopping list");
            doc.add(pdfTable);
            doc.close();

 System.out.println("done");
        } catch (DocumentException ex) {
//            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
	
	public static void main(String args[]){
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(new Dimension(300, 400));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Object [][] data = {
				{"pomme",50,5,250},
				{"savon",40,10,400},
				{"culottes",200,6,1200}
		};
		//les colonnes
		String titres[] = { "Produit", "prixunit","quantite","somme"};
		
		//il faut trouver un moyen pr ajouter la somme ds le tableau
		JTable tableau = new JTable(data, titres);
		
		ToPDF testPdf= new ToPDF(tableau);
		
		JPanel pan = new JPanel();
		pan.add(testPdf);
	
		
		frame.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		frame.getContentPane().add(pan, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		}
	}
