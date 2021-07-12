package ByteDance;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 6/13/21 4:36 AM
 */

/**
 * 给出二叉搜索树的后序遍历的数组，重建这棵树
 */
public class BD2 {

    class binTree{
        binTree(int value) {
            this.value = value;
        }
        int value;
        binTree left;
        binTree right;
    }

    public static void main(String[] args) {
        BD2 b = new BD2();
        int[] arr = {7,6,5,4,3,2,1};
        b.pl(b.reCreateBST(arr, 0, arr.length - 1));
    }

    public binTree reCreateBST (int[] arr, int left, int right) {
        if(left > right) return null;
        if(left == right) return new binTree(arr[left]);
        binTree temp = new binTree(arr[right]);
        int middle = -1;
        for(int i = left - 1; i < right; i++) {
            if(arr[i + 1] >= arr[right]) {
                middle = i;
                break;
            }
        }
        temp.left = reCreateBST(arr, left, middle);
        temp.right = reCreateBST(arr, middle + 1, right- 1);


        return temp;
    }

    public void pl (binTree b) {
        if(b.left != null) {
            System.out.println(b.value + "的左节点是" + b.left.value);
            pl(b.left);
        }
        if(b.right != null) {
            System.out.println(b.value + "的右节点是" + b.right.value);
            pl(b.right);
        }
    }
}
