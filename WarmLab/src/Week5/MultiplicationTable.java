package Week5;

public class MultiplicationTable {
    private int size;

    public MultiplicationTable(int size) {
        this.size = size;
    }

    public void dispTable() {
        // head
        System.out.format("   ");
        System.out.format("%2d  ", 1);
        for (int i = 2; i <= size; i++) {
            System.out.format("%2d  ", i);
        }
        System.out.println();
        System.out.println("---------------------------------------");

        // body
        for (int i = 1; i<= size; i++) {
            System.out.print(Integer.toString(i) + " |");
            for (int j = 1; j<= size; j++) {
                System.out.format("%2d  ", i*j);
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        MultiplicationTable table = new MultiplicationTable(9);
        table.dispTable();
    }
}
