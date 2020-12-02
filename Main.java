import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
    Process coffee = new Process(new String[] {"drink coffee"});
		Process discuss = new Process(new String[] {"think", "talk"});
		Process cookie = new Process(new String[] {"eat cookie"});
		
		coffee.start();
		discuss.start();
		cookie.start();	
	}
}

class Process implements Runnable {

	  private Thread thread;
    private String[] task;
    private Random random = new Random();

    Process(String[] name) {
    	task = name;
    }

    public void start() {
    	thread = new Thread(this);
    	thread.start();
    }

    public void stop() {
    	thread = null;
    }

    public void run() {
    	int j = 0;
    	while(j < task.length) {
    		tick();
    		System.out.println(task[j]);
    		j++;
    	}
    }

    private void tick() {
    	try {
    		Thread.sleep(random.nextInt(3000));
    	}
    	catch (InterruptedException e) {} 
    }  
}
