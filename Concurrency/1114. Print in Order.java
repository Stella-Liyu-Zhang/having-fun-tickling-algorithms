class Foo {
    private final Semaphore second;
    private final Semaphore third;

    public Foo() {
        second = new Semaphore(0);
        third = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.release();
    }
    // release(): This method is used to release a permit back to the semaphore, indicating that the thread has finished using the shared resource and is allowing another thread to acquire the permit. It's essential to call release() in a finally block or use a try-with-resources block to ensure that the permit is always released, even if an exception occurs.
    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}