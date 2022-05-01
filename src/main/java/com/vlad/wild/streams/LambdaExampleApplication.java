package com.vlad.wild.streams;

/**
 * Что выведется в 1-ом и во 2-ом случаях?
 */
public class LambdaExampleApplication {
    private int k = 10;

    public static void main(String[] args) {
        LambdaExampleApplication application = new LambdaExampleApplication();
        application.startApplication();
    }

    public void startApplication() {
        Runnable lambda = () -> System.out.println(this.k);
        lambda.run();

        Runnable anonymousClass = new Runnable() {
            private int k = 9999;

            @Override
            public void run() {
                System.out.println(this.k);
            }
        };
        anonymousClass.run();
    }
}
