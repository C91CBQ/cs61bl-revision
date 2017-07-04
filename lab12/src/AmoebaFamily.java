import java.util.*;
import java.util.stream.IntStream;

/**
 * An AmoebaFamily is a tree, where nodes are Amoebas, each of which can have
 * any number of children.
 */
public class AmoebaFamily implements Iterable<AmoebaFamily.Amoeba> {

    /**
     * ROOT is the root amoeba of this AmoebaFamily
     */
    public Amoeba root = null;

    /**
     * A constructor that starts an Amoeba family with an amoeba
     * @param  name the name of the first Amoeba of this AmoebaFamily
     */
    public AmoebaFamily(String name) {
        root = new Amoeba(name, null);
    }

    /**
     * Adds a new Amoeba with childName to this AmoebaFamily
     * as the youngest child of the ameoba named parentName
     * Precondition: This AmoebaFamily must contain an Amoeba named parentName.
     * @param parentName name of the parent Amoeba
     * @param childName  name of the Amoeba to add as parentName's child
     */
    public void addChild(String parentName, String childName) {
        if (root != null) {
            root.addChild(parentName, childName);
        }
    }

    /**
     * Changes the names for all Amoebas in this AmoebaFamily to use only
     * lowercase letters.
     */
    public void makeNamesLowercase() {
        // Your goal is to make this as similar as possible to addChild
        if (root != null) {
            root.setLowerCase();
        }
    }

    /**
     * Replaces the name of an amoeba named currentName with the name newName.
     * Precondition: This AmoebaFamily contains exactly one Amoeba named
     * currentName.
     */
    public void replaceName(String currentName, String newName) {
        // Your goal is to make this as similar as possible to addChild
        if (root != null) {
            root.replace(currentName, newName);
        }
    }

    /**
     * Print the names of all amoebas in the family, one on each line.
     * Later you will write print() that has more interesting formatting
     */
    public void printFlat() {
        // Your goal is to make this as similar as possible to addChild
        if (root != null) {
            root.printSingle();
        }
    }

    /**
     * Prints the name of all Amoebas in this AmoebaFamily in preorder, with
     * the oldest Amoeba printed first.
     * Members of the AmoebaFamily constructed in the main method should
     * be printed in the following sequence:
     * Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
     * Bill, Hilary, Fred, Wilma, auntie
     * This should be formated as stated in the Pretty Print section of lab.
     */
    public void print() {
        // YOUR CODE HERE
        if (root != null) {
            root.print(0);
        }
    }

    /**
     * Returns the length of the longest name in this AmoebaFamily
     */
    public int longestNameLength() {
        if (root != null) {
            return root.longestNameLength();
        }
        return 0;
    }


    public int size() {
        if (root != null) {
            return root.countSize();
        }
        return 0;
    }

    public int height() {
        return root.height() - 1;
    }

    /**
     * Returns the longest name in this AmoebaFamily
     */
    public String longestName() {
        // your goal is to make this look as similar as possible to
        // longestNameLength
        if (root != null) {
            return root.longestName();
        }
        return null;
    }

    /**
     * Returns an Iterator for this AmoebaFamily
     */
    public Iterator<Amoeba> iterator() {
        return new AmoebaIterator();
    }

    /**
     * Creates a new AmoebaFamily and prints it out
     * @param args command line arguments
     */
    public static void main(String[] args) {
        AmoebaFamily family = new AmoebaFamily("Amos McCoy");
        family.addChild("Amos McCoy", "mom/dad");
        family.addChild("Amos McCoy", "auntie");
        family.addChild("mom/dad", "me");
        family.addChild("mom/dad", "Fred");
        family.addChild("mom/dad", "Wilma");
        family.addChild("me", "Mike");
        family.addChild("me", "Homer");
        family.addChild("me", "Marge");
        family.addChild("Mike", "Bart");
        family.addChild("Mike", "Lisa");
        family.addChild("Marge", "Bill");
        family.addChild("Marge", "Hilary");
        System.out.println("Here's the family:");
        family.print();
        System.out.println(family.height());
    }

    /**
     * Ignore for lab12
     *
     * An Iterator class for the AmoebaFamily. Amoebas are enumerated in
     * preorder, with oldest children enumerated first.
     * Members of the family constructed in main method above should be
     * enumerated in the following order:
     * Amos McCoy, mom/dad, me, Mike, Bart, Lisa, Homer, Marge,
     * Bill, Hilary, Fred, Wilma
     * Complete enumeration of a family of N amoebas should take
     * O(N) operations.
     */
    public class AmoebaIterator implements Iterator<Amoeba> {

        /**
         * AmoebaIterator constructor. Sets up all of the initial information
         * for the AmoebaIterator
         */
        public AmoebaIterator() {
        }

        /**
         * Returns true if there is a next element that has not
         * been seen yet
         */
        public boolean hasNext() {
            return false;
        }

        /**
         * Returns the next element in preorder
         */
        public Amoeba next() {
            return null;
        }


    }

    /**
     * An Amoeba is a node of an AmoebaFamily
     */
    public static class Amoeba {

        /**
         * name is the name of this Amoeba
         * parent is the parent of this Amoeba
         * children contains all of the child Amoebas of this Amoeba
         */
        public String name;
        public Amoeba parent;
        public ArrayList<Amoeba> children;

        /**
         * Amoeba constructor
         * @param  name     the name for this Amoeba
         * @param  parent the parent for this Amoeba
         */
        public Amoeba(String name, Amoeba parent) {
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<Amoeba>();
        }

        /**
         * Returns a String representation of this Amoeba
         */
        public String toString() {
            return name;
        }

        /**
         * Getter method for the parent of this Amoeba
         */
        public Amoeba parent() {
            return parent;
        }

        /**
         * Adds a child to an Amoeba that matches parentName
         * @param parentName name of Amoeba to give a child to
         * @param childName  name of child Amoeba to add
         */
        public void addChild(String parentName, String childName) {
            if (name.equals(parentName)) {
                Amoeba child = new Amoeba(childName, this);
                children.add(child);
            } else {
                for (Amoeba a : children) {
                    a.addChild(parentName, childName);
                }
            }
        }

        //Add more void recursive functions below

        public void setLowerCase() {
            this.name = name.toLowerCase();
            this.children.forEach(Amoeba::setLowerCase);
        }

        public void replace(String currentName, String newName) {
            if (this.name.equals(currentName)) {
                this.name = newName;
            }
            this.children.forEach(c -> c.replace(currentName, newName));
        }

        public void printSingle() {
            System.out.println(this.name);
            this.children.forEach(Amoeba::printSingle);
        }

        public void print(int level) {
            IntStream.range(0, level).forEach(i -> System.out.print("    "));
            System.out.println(this.name);
            this.children.forEach(c -> c.print(level + 1));
        }

        /**
         * Returns the length of the longest name between this Amoeba and its
         * children
         */
        public int longestNameLength() {
            int maxLengthSeen = name.length();
            for (Amoeba a : children) {
                maxLengthSeen = Math.max(maxLengthSeen, a.longestNameLength());
            }
            return maxLengthSeen;
        }

        public String longestName() {
            int maxLengthSeen = name.length();
            String longestName = null;
            for (Amoeba a : children) {
                if (a.longestNameLength() > maxLengthSeen) {
                    maxLengthSeen = a.longestNameLength();
                    longestName = a.name;
                }
            }
            return longestName;
        }

        public int countSize() {
            return this.children.size() + 1;
        }

        public int height() {
            int maxHeight = 0;
            for (Amoeba amoeba : children) {
                maxHeight = Math.max(maxHeight, amoeba.height());
            }
            return 1 + maxHeight;
        }
    }
}
