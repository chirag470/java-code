import java.util.*;


class SingletonDemo {
    public static void main(String [] a) {


      List<MyThread> l = new ArrayList<>();
      l.add(new MyThread());
      l.add(new MyThread());
      l.add(new MyThread());
      l.add(new MyThread());
      l.add(new MyThread());
      l.add(new MyThread());
      l.add(new MyThread());
      l.add(new MyThread());

      int c=3;
      for(MyThread t: l) {
        t.start();
        c--;
        if(c==0) {
          try {


          Thread.sleep(2000);
        } catch(Exception w) {

        }
        }
      }

      try {


      Thread.sleep(4000);
    } catch(Exception w) {

    }

    }



}

class MyThread extends Thread {

    public void run() {

        Singleton s= Singleton.getInstance();
    }

}

 class ASingleton {

	private static volatile ASingleton instance;
	private static Object mutex = new Object();

	private ASingleton() {
      System.out.println("Asingleton Constructor called");
	}

	public static ASingleton getInstance() {
		ASingleton result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new ASingleton();
			}
		}
      System.out.println("other branch");
		return result;
	}

}

class Singleton {

  private static  Singleton s;
  private static Object lock = new Object();
  private Singleton() {

    System.out.println("Constructor called");
  }

  public static Singleton getInstance() {
      //if(s==null) {
          synchronized (lock) {
            if(s==null) {
              s=new Singleton();
              return s;
            }

          }
      //}
        System.out.println("other branch");
      return s;
  }


}
