package PenguinTrees;

public class TreeNode {
    int info;
    TreeNode left;
    TreeNode right;

    public TreeNode(int info, TreeNode left, TreeNode right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int info) {
        this.info = info;
    }

    public void insert(int info){
        if(info < this.info){
            if(this.left == null){
                this.left = new TreeNode(info);
            }else{
                this.left.insert(info);
            }
        }else{
            if(this.right == null){
                this.right = new TreeNode(info);
            }else{
                this.right.insert(info);
            }
        }
    }
}


