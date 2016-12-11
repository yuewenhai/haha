package homework4;

import java.util.ArrayList;

public class TVM implements Runnable{

	private static int numberOfTickets = 1;
	
	public synchronized void run(){
		String name = Thread.currentThread().getName();
		
		while(numberOfTickets <= 200){
				System.out.println(name + "售出No." + numberOfTickets);
				numberOfTickets++;
				try {
					wait(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		System.out.println(name + " 售罄");
	}
	
	public static void main(String[] args)
	{
		TVM tvm = new TVM();
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		for(int i = 0;i < 10;i++){
			Thread t = new Thread(tvm,"售票机" + i);
			threadList.add(t);
		}
		
		for(int i = 0;i < 10;i++){
			Thread t = threadList.get(i);
			t.start();
//			try{
//				t.join();
//			}catch(Exception e){
//				e.printStackTrace();
//			}
		}
//		while(numberOfTickets <= 200){
//			int x =(int)Math.random()*9;
//			threadList.get(x).start();
//		}
	}
}
