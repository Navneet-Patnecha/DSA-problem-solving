import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(bubbleSort(arr)));

    }
    static int[] bubbleSort(int[] arr)
    {
        int temp =0;
        boolean swap ;
        for(int i=0;i<arr.length-1;i++)
        {   swap = false;
            for(int j=1;j<arr.length-i;j++)
            {
                if(arr[j-1]>arr[j])
                {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swap = true;
                }
            }
            //what if array got sorted early and now it's running so to stop it we used this
            if(!swap)
                break;
        }
        return arr;
    }
}
