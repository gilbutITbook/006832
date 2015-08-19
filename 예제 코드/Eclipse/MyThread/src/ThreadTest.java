
public class ThreadTest {

	public static void main(String[] args) {
		ThreadTest test = new ThreadTest();
		test.startup();
		
	}

	public void startup() {
		DogThread dog = new DogThread();
		dog.start();
		
		HorseThread horse = new HorseThread();
		horse.start();
		
		
		new Thread() {
			public void run() {
				running("cow");
			}
		}.start();
		
	}
	
	
	class DogThread extends Thread {
		public void run() {
			running("dog");
			/*
			int distance = 0;
			for (int i = 0; i < 10; i++) {
				distance += (10*i);
				System.out.println("dog running : " + distance);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		}
	}
	
	class HorseThread extends Thread {
		public void run() {
			running("horse");
			
			/*
			int distance = 0;
			for (int i = 0; i < 10; i++) {
				distance += (10*i);
				System.out.println("horse running : " + distance);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			*/
		}
	}
	
	public void running(String name) {
		int distance = 0;
		for (int i = 0; i < 10; i++) {
			distance += (10*i);
			System.out.println(name + " running : " + distance);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
