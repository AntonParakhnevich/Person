package Home;

/**
 * Hello world!
 */
public class App {
    public static volatile Integer a=0;
    public static final Integer LOCK=003005340503;
    public static void main(String[] args) {
//        Group group = new Group(generateGroup());
//        group.calculate();
//        group.print();

        Thread thread = new Thread(new decremet());
        Thread thread1 = new Thread(new increment());

        thread.start();
        thread1.start();
    }

    public static class   decremet implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK){
                for (int i = 0; i <100000 ; i++) {
                    a++;
                }
                System.out.println(a);
            }
            }


    }

    public static class increment implements Runnable{

        @Override
        public void run() {
            synchronized (LOCK){
                for (int i = 0; i <100000 ; i++) {
                    a--;
                }
                System.out.println(a);
            }

        }

    }

    public static Masterable[] generateGroup(){
        Masterable[] masterables = new Masterable[9];

        for (int i = 0; i <3; i++) {
            masterables[i]= StudentFactory.createStudent(Type.FIRST);
        }
        for (int i = 3; i <6; i++) {
            masterables[i]= StudentFactory.createStudent(Type.SECOND);
        }
        for (int i = 6; i <9; i++) {
            masterables[i]= StudentFactory.createStudent(Type.THIRD);
        }
        return masterables;
    }


}
