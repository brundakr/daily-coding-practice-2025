package org.example.week2.day11.morning;

public class SingletonDBConn {

    private static SingletonDBConn instance;

    //Constructor is private so other classes cant create an object of this class
    private SingletonDBConn() {
        System.out.println("SingletonDBConn constructor");
    }

    public static synchronized SingletonDBConn getInstance() {
        if(instance == null) {
            instance = new SingletonDBConn();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Querying " + sql);
    }

}
 class mainClass{
    public static void main(String[] args) {
        SingletonDBConn db1 = SingletonDBConn.getInstance();
        SingletonDBConn db2 = SingletonDBConn.getInstance();

        db1.query("select * from user");
        db2.query("select * from role");
    }
}
