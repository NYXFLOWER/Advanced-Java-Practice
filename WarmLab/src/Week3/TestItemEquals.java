package Week3;

public class TestItemEquals {
    public static void main(String[] args) {
        Item tv = new Item("TV", 1000);
        Item tvCopy = tv;
        Item book = new Item("Book", 200);
        Item tvSame = new Item("TV", 1000);
        Item tvChape = new Item("TV", 500);
        String string = "I am a string.";
        Item no = null;

        // for identical object
        System.out.println("tv vs tvCopy: " + tv.equals(tvCopy));

        // for different reference address
        System.out.println("tv vs tvSame: " +tv.equals(tvSame));

        // for different instance fields
        System.out.println("tv vs tvChape: " +tv.equals(tvChape));
        System.out.println("tv vs book: " +tv.equals(book));

        // for different classes
        System.out.println("tv vs string: " +tv.equals(string));

        // for null
        System.out.println("tv vs no: " +tv.equals(no));
    }
}
