import java.util.*;
import java.io.*;

public class BinTree{
    public static void main(String[] args){
        BinaryTree atree=new BinaryTree();
        atree.addFruit(new Node(2));
        atree.addFruit(new Node(3));
        atree.addFruit(new Node(7));
        atree.addFruit(new Node(5));
        atree.addFruit(new Node(11));
        atree.addFruit(new Node(17));
        atree.addFruit(new Node(13));
        atree.showFruitPre(atree.root);
        atree.showFruitIn(atree.root);
        atree.showFruitPost(atree.root);
    }
}