package BaseAlgorithm;

import java.util.PriorityQueue;

/**
 * @author ClarenceBai
 * @version 1.0
 * @date 2020-08-01 22:26
 */
public class heapAlgorithm {

    /**
     * 堆相关操作，以 小根堆为例
     * 另:
     *     堆插入操作即为：将待插入元素放在heao的最后一位，然后进行一次MoveUp操作就行了
     *     堆删除操作即为：将待删除元素移除，并将最后一位的元素放入该位置，然后进行依次MoveDown操作就行了
     * @param args
     */
    public static void main(String[] args) {
        heapAlgorithm ha = new heapAlgorithm();
        int[] heap = {2,8,6,1,10,15,3,12,11};
        //ha.WilliamsAlgorithm(heap);
        ha.heapSort(heap);

        for (int i : heap) {
            System.out.print(i + " ");
        }


        /* JDK实现（优先队列） */


        // 根据构造函数决定优先级排序，此处为大根堆
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // offer(或者add)操作，堆容量加一，新元素放在堆数组最后一位，然后执行moveUp操作（shiftUp）
        pq.offer(1);
        pq.add(2);
        pq.add(4);
        pq.offer(3);
        // poll操作为：堆顶元素移除，堆数组最后一个元素移到对顶，堆容量减一，然后执行moveDown操作（shiftDown）
        pq.poll();

        System.out.println(pq.toString());
    }

    /**
     * 自定向下构建小根堆，依次对每一个元素进行MoveUp操作
     * @param heap
     */
    public void WilliamsAlgorithm(int[] heap){
        int len = heap.length;
        for (int i = 1; i < len; i++) {
            MoveUp(heap, i);
        }
    }

    /**
     * 自底向上构建小根堆，从第最后一个非叶子节点开始，向前依次进行MoveDown操作
     * @param heap
     */
    public void FloyAlgorithm(int[] heap) {
        int len = heap.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            MoveDown(heap, i, heap.length - 1);
        }
    }


    /**
     * 从下往上移动，较小的元素上移至合适位置
     * @param heap
     * @param index
     */
    public void MoveUp(int[] heap, int index) {
        int down = index;
        int up = (index - 1) / 2;

        while(up >= 0) {
            if(heap[up] > heap[down]) {
                int temp = heap[up];
                heap[up] = heap[down];
                heap[down] = temp;
                down = up;
                up = (up - 1) / 2;
            } else {
                break;
            }
        }
    }


    /**
     * 把index位置的元素向下移动至合适的位置，此操适合用在index为根的子堆都已经排好序的场景下，否则操作就没有意义
     * @param heap
     * @param index
     */
    public void MoveDown(int[] heap, int index, int lastIndex) {
        int up = index;
        int down = index * 2 + 1;
        while(down <= lastIndex) {
            //每次向下交换都要选取较小的一个元素进行交换，否则就破坏了原有顺序
            if(down < lastIndex && heap[down] > heap[down + 1]) down ++;

            if(heap[up] > heap[down]) {
                int temp = heap[up];
                heap[up] = heap[down];
                heap[down] = temp;
                up = down;
                down = down * 2 + 1;
            } else {
                break;
            }
        }
    }


    /**
     * 堆排序。根据小顶堆的特点，每次根节点都是最小的元素，所以，拿出根节点后，进行依次调整，就可以再得出剩余元素中最小的一个
     * 反复进行上述操作，就可以完成排序了。
     * @param heap
     */
    public void heapSort(int[] heap) {
        //堆排序一定是建立在完整的堆的基础上的
        this.FloyAlgorithm(heap);
//        this.WilliamsAlgorithm(heap);

        int len = heap.length - 1;
        for (int i = len; i > 0; i--) {
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            //lastIndex是为了声明MoveDown的范围，i以后的元素都为有序的，所以，不进行MoveDown操作
            MoveDown(heap, 0, i - 1);
        }
    }







}
