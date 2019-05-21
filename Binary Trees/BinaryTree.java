import java.util.*;
import java.io.*;

public class BinaryTree extends TreeTest{
    public Node root;

    public BinaryTree(){
        this.root=null;
    }

    private int minFruit(Node root){
        int min=root.getFruit();
        while(root.leftBranch!=null){
            min=root.leftBranch.getFruit();
            root=root.leftBranch;
        }
        return min;
    }

    public void addFruit(Node fruit){
        if(root==null){
            root=fruit;
        }
        else{
            insertFruit(root,fruit);
        }
    }

    private void insertFruit(Node trunk,Node fruit){
        if(trunk.getFruit()<fruit.getFruit()){
            if(trunk.rightBranch==null){
                trunk.rightBranch=fruit;
            }
            else{
                insertFruit(trunk.rightBranch,fruit);
            }
        }
        else{
            if(trunk.leftBranch==null){
                trunk.leftBranch=fruit;
            }
            else{
                insertFruit(trunk.leftBranch,fruit);
            }
        }
    }

    public Boolean searchFruit(Node root,int query){
        boolean found=false;
        if(root!=null){
            if(root.getFruit()==query){
                found=true;
            }
            else if(root.getFruit()<query){
                searchFruit(root.rightBranch,query);
            }
            else{
                searchFruit(root.leftBranch,query);
            }
        }
        else{
            found=false;
        }
        return found;
    }

    public void deleteFruit(int query){
        root=deleteNode(root,query);
    }

    private Node deleteNode(Node root,int query){
        if(root==null){
            return root;
        }
        if(query>root.getFruit()){
            root.rightBranch=deleteNode(root.rightBranch,query);
        }
        else if(query<root.getFruit()){
            root.leftBranch=deleteNode(root.leftBranch,query);
        }
        else{
            if(root.rightBranch==null){
                return root.leftBranch;
            }
            else if(root.leftBranch==null){
                return root.rightBranch;
            }
            root.changeFruit(minFruit(root.rightBranch));
            root.rightBranch=deleteNode(root.rightBranch,root.getFruit());
        }
        return root;
    }

    public void showFruitPre(Node root){
        if(root==null){
            return;
        }
        showFruitPre(root.leftBranch);
        showFruitPre(root.rightBranch);
        System.out.print(root.getFruit()+" ");
    }

    public void showFruitIn(Node root){
        if(root==null){
            return;
        }
        showFruitIn(root.leftBranch);
        System.out.print(root.getFruit()+" ");
        showFruitIn(root.rightBranch);
    }

    public void showFruitPost(Node root){
        if(root==null){
            return;
        }
        showFruitPost(root.leftBranch);
        showFruitPost(root.rightBranch);
        System.out.print(root.getFruit()+" ");
    }
}