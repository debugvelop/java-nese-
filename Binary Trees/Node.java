import java.util.*;
import java.io.*;

public class Node extends BinaryTree{
    private int fruit;
    public Node leftBranch,rightBranch;

    public Node(int fruit){
        this.fruit=fruit;
    }

    public int getFruit(){
        return fruit;
    }
}