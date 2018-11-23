package Week7;

import java.util.*;

public class CollectionLecture {
    public static void main(String[] args) {
        // use collection
        Collection<String> authors = new ArrayList<>();
        authors.add("Flower");
        authors.add("Nyx");
        authors.add("Jone");
        authors.add("Barker");
        System.out.println(authors);

        // use iterator - hasNext(), next(), remove().
        Iterator iterator = authors.iterator();
        while (iterator.hasNext()) {
            // System.out.println((String) iterator.next());
            String author = (String) iterator.next();
            if (author.equals("Nyx")) {
                iterator.remove();
            }
        }
        System.out.println(authors);

        // the following block do the same job as the iterator
        for (String author : authors) {
            // System.out.println(author);
            if (author.equals("Jone")) {
                authors.remove(author);
            }
        }
        System.out.println(authors);

        // Sets
        Collection inputText = authors;
        inputText.add("bbb");
        Set hashSet = new HashSet();
        String wd;
        for (Iterator i = inputText.iterator(); i.hasNext(); ) {
            wd = (String) i.next();
            hashSet.add(wd);
        }
        System.out.println(hashSet);
        System.out.println(authors);

    }
}
