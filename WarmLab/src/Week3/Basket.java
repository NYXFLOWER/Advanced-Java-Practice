/** Basket.java
*
* Part of lab class for COM6516
* Written by Mark Stevenson mark.stevenson@sheffield.ac.uk
* Based on code written by Steve Maddock
* Last modified 19 September 2014
*
*/
package Week3;

public class Basket {
    private Item[] items;

    public Basket(Item[] it) {
        items = it;
    }

    public double total() {
        double total = 0.0;

        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    } 
		

}
