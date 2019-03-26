import java.util.*;

public class BinaryTree extends BinTree{
    public Node root;

    public BinaryTree(){
        root=null;
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

    public static Boolean searchFruit(Node root,int query){
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
        Node trunk=root,leaf=root;
        int left=0,right=0;
        while(leaf.getFruit()!=query){
            trunk=leaf;
            if(leaf.getFruit()<query){
                leaf=leaf.rightBranch;
                right++;
            }
            else{
                leaf=leaf.leftBranch;
                left++;
            }
        }
        if(leaf.leftBranch==null&&leaf.rightBranch==null){
            if(left>right){
                trunk.leftBranch=null;
            }
            else{
                trunk.rightBranch=null;
            }
        }
        else if(leaf.leftBranch==null&&leaf.rightBranch!=null){
            if(left>right){
                trunk.leftBranch=leaf.rightBranch;
            }
            else{
                trunk.rightBranch=leaf.rightBranch;
            }
        }
        else if(leaf.leftBranch!=null&&leaf.rightBranch==null){
            if(left>right){
                trunk.leftBranch=leaf.leftBranch;
            }
            else{
                trunk.rightBranch=leaf.leftBranch;
            }
        }
        else{
            if(left>right){
                leaf.rightBranch.leftBranch=leaf.leftBranch;
                trunk.leftBranch=leaf.rightBranch;
            }
            else{
                leaf.leftBranch.rightBranch=leaf.rightBranch;
                trunk.rightBranch=leaf.leftBranch;
            }
        }
    }

    public static void showFruitPre(Node root){
        System.out.print(root.getFruit()+",");
        if(root.leftBranch!=null){
            System.out.print(root.leftBranch.getFruit()+",");
        }
        if(root.rightBranch!=null){
            System.out.println(root.rightBranch.getFruit());
        }
    }

    public static void showFruitIn(Node root){
        if(root.leftBranch!=null){
            System.out.print(root.leftBranch.getFruit()+",");
        }
        System.out.print(root.getFruit()+",");
        if(root.rightBranch!=null){
            System.out.println(root.rightBranch.getFruit());
        }
    }

    public static void showFruitPost(Node root){
        if(root.leftBranch!=null){
            System.out.print(root.leftBranch.getFruit()+",");
        }
        if(root.rightBranch!=null){
            System.out.println(root.rightBranch.getFruit());
        }
        System.out.print(root.getFruit()+",");
    }
}