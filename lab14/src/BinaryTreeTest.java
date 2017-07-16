import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by qibao on 2017/7/16.
 */
class BinaryTreeTest {
    @Test
    void print() {
        ArrayList<String> pre = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        ArrayList<String> in = new ArrayList<String>(Arrays.asList("B", "A", "E", "D", "F", "C"));
        BinaryTree bt = new BinaryTree(pre, in);
        BinaryTree.print(bt, null);
    }

}