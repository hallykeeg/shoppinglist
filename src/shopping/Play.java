package shopping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Play{

private static String price;
private static String produit;
private static String categorie;
static Element nomProduit ;


	public static void main(String[] args){
		print("running...");
		Document document;
		
		String agent="Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0";
		String url = "https://www.ebay.com/itm/100-NIB-ADIDAS-PHARRELL-PW-TENNIS-HU-HOLI-SZ-10-LOW-TOP-Gradient-Sun-Yellow/192895550333?_trkparms=aid%3D111001%26algo%3DREC.SEED%26ao%3D1%26asc%3D20180816085401%26meid%3Dc5f934ee606d45e9806902a5537f711f%26pid%3D100970%26rk%3D5%26rkt%3D11%26sd%3D223494207148%26itm%3D192895550333&_trksid=p2481888.c100970.m5481&_trkparms=pageci%3Aa5ccf152-67d4-11e9-aa92-74dbd180511e%7Cparentrq%3A57b860c316a0a88aef68f95effff4831%7Ciid%3A1";
		try {
			//Get Document object after parsing the html from given url.
			//			document = Jsoup.connect("https://www.amazon.com/").get();
			//
			//			String title = document.title(); //Get title
			//			print("  Title: " + title); //Print title.
			//			Elements titles = document.getElementsByClass("priceBlockBuyingPriceString");
			//			print(titles.text());
			//document  = Jsoup.connect("https://www.amazon.com/dp/B0797D6FPP?aaxitk=eYQACKh3Ydp360-S5pibwQ&pd_rd_i=B0797D6FPP&pf_rd_p=3fade48a-e699-4c96-bf08-bb772ac0e242&hsa_cr_id=5688934780001&sb-ci-n=asinImage&sb-ci-v=https%3A%2F%2Fimages-na.ssl-images-amazon.com%2Fimages%2FI%2F71MgEWOyczL.jpg&sb-ci-a=B0797D6FPP").get().html();
			document =Jsoup.connect(url).userAgent(agent).maxBodySize(Integer.MAX_VALUE).timeout(10 * 10000).get();
			
			try {
				 nomProduit = document.getElementById("itemTitle");
			} catch (Exception e) {
				
			}
			
			
			
			String prixConv;
			try {
				Element conv = document.getElementById("convbinPrice");
				prixConv=conv.text();
				price  = prixConv;
				print(prixConv);
				price = prixConv;
			}catch(NullPointerException exep) {
				try {
					Elements prix = document.getElementsByAttributeValue("itemprop","price");
					
					price = prix.text();
					
					print(price);
					
				}catch (Exception exce) {
					
				}
				
			}
			try {
				
				produit = nomProduit.text();
				
				print(produit);
				
			} catch (Exception ecccc) {
			}
			
			
			try {
				Elements cat  =document.getElementsByAttributeValue("_sp", "p2047675.l2706");
				
				Element c = cat.first();
				
				categorie = c.text();
				
				print(categorie);
				
			}catch (Exception e) {
				
			}
			




			//			Document doc = Jsoup.parse(document);

			//			Element prix = doc.getElementById("data-asin-price");
			//			System.out.print(document);

		} catch (IOException e) {
			e.printStackTrace();
		}
		print("done");
		
	}
	

	public static void print(String string) {
		System.out.println(string);
	}
}






