import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class myBinarySearchTreeNodeTester {
    // each test will test each of the three methods; height, depth, and size //

    @Test
    // tests with just one node, should be no height since its just the root and and the depth -1 since it DNE //
    public void test1() {
        int[] array = {1};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(array);
        assertEquals(0, test.height());
        assertEquals(-1, test.depth(0));
        assertEquals(array.length, test.size());
    }
    @Test
    // tests a "normal" array, height should be 2 and the depth for 2 should be 1 //
    public void test2() {
        int[] array = {1,2,3};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(array);
        assertEquals(2, test.height());
        assertEquals(1, test.depth(2));
        assertEquals(array.length, test.size());
    }
    @Test
    // tests another "normal" array in ascending order, height should be 4, depth of 3 should be 2 //
    public void test3() {
        int[] array = {1,2,3,4,5};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(array);
        assertEquals(4, test.height());
        assertEquals(2, test.depth(3));
        assertEquals(array.length, test.size());
    }
    @Test
    // tests the same array as above but in descending order to ensure the code makes the tree correctly, height still 4, but now 2 should have a depth of 3 //
    public void test4() {
        int[] array = {5,4,3,2,1};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(array);
        assertEquals(4, test.height());
        assertEquals(3, test.depth(2));
        assertEquals(array.length, test.size());
    }
    @Test
    // now tests with negatives and a zero, should not affect it, height is 4, depth of -2 should be 0 since its the root //
    public void test5() {
        int[] array = {-2,-1,0,1,2};
        myBinarySearchTreeNode test = new myBinarySearchTreeNode(array);
        assertEquals(4, test.height());
        assertEquals(0,test.depth(-2));
        assertEquals(array.length, test.size());
    }
}
