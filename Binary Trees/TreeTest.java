import java.util.*;
import java.io.*;

public class TreeTest{
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
        System.out.println();
        atree.showFruitIn(atree.root);
        System.out.println();
        atree.showFruitPost(atree.root);
        System.out.println();
        atree.deleteFruit(17);
        atree.deleteFruit(3);
        atree.showFruitIn(atree.root);
    }
}