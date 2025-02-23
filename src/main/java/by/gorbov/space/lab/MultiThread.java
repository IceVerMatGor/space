package by.gorbov.space.lab;

public class MultiThread {


    public static void main(String[] args) {

        for (int i = 0; i < 8; i++) {

            int finalI = i;
            Thread thread = new Thread(()->{
                for (int ii = 0; ii < 20; ii++) {
                    System.out.println("поток № "+ finalI + " " + ii);
                }
            });

            thread.start();
        }

    }


}
