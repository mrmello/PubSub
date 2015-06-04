package pubsub;

import threads.EletronicosThread;
import threads.EsportesThread;
import threads.NegociosThread;
import threads.NovidadesInternetThread;
import threads.PoliticaThread;
import threads.ViagensThread;

public class Gerador{
	
	private EsportesThread 				esp;
	private NovidadesInternetThread     nov;
	private EletronicosThread 			ele;
	private PoliticaThread 				pol;
	private NegociosThread 				neg;
	private ViagensThread 				via;
	
	
	public Gerador(){
	
	}
	
	public void initializeThreads(){
		esp = new EsportesThread(1, 1999, 1000, 10000, 1000);
		esp.start();
		nov = new NovidadesInternetThread(2, 2999, 2000, 10000, 1000);
		nov.start();
		ele = new EletronicosThread(3, 3999, 3000, 10000, 1000);
		ele.start();
		pol = new PoliticaThread(4, 4999, 4000, 10000, 1000);
		pol.start();
		neg = new NegociosThread(5, 5999, 5000, 10000, 1000);
		neg.start();
		via = new ViagensThread(6, 6999, 6000, 10000, 1000);
		via.start();
	}
}
