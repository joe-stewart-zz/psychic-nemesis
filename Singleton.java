class Singleton {
    private volatile static Singleton instance;

    public static Singleton getInstance() {
        if(instance == null) {
            // Synchronized Block
            synchronized (Singleton.class) {
                if(instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    private Singleton() {
        System.out.println("Private Constructor");
    }


    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
    }
}
