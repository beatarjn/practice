package chains;

public class Runner {

    public static void main(String[] args) {
        Chain chain = new Chain();
        chain.a().b().a().c().d().f().d().g();

        System.out.println(chain);
    }
}
