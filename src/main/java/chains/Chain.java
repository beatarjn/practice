package chains;

public class Chain implements ABCMethods, DEFMethods {

    public ABCMethods a() {
        System.out.println("A");
        return this;
    }

    public ABCMethods b() {
        System.out.println("B");
        return this;
    }

    public ABCMethods c() {
        System.out.println("C");
        return this;
    }

    @Override
    public DEFMethods d() {
        System.out.println("D");
        return this;
    }

    @Override
    public DEFMethods e() {
        System.out.println("E");
        return this;
    }

    @Override
    public DEFMethods f() {
        System.out.println("F");
        return this;
    }

    @Override
    public void g() {
        System.out.println("G");
    }
}