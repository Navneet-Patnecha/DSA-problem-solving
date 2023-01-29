import java.util.Arrays;

public class Sorted2dBinarySearch {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        int target =11;
        System.out.println(Arrays.toString(middle_column(arr,target)));

    }
    static int[] middle_column(int[][] arr , int target)
    {
       int rows = arr.length;
       int col = arr[0].length;//be cautious over here , our matrix may be empty
        if(rows==1)
        {
            return Bsearch(arr , target , 0 , 0,col-1  );


        }
        //run the loop until 2 rows are remaining
        int rstart=0;
        int rend = rows-1;
        int cmid = col/2;
             //until 2 columns remains
            while(rstart<(rend-1))
            {
                int rmid = rstart+(rend - rstart)/2;
                if(arr[rmid][cmid]==target)
                    return new int[]{rmid,rstart};
                else if(arr[rmid][cmid]<target)
                    rstart = rmid;
                else
                    rend = rmid;

            }
            //now we have two rows
        //check whether is target is in column of 2 rows
        if(arr[rstart][cmid]==target)
            return new int[]{rstart,cmid};
        if(arr[rstart+1][cmid]==target)
            return new int[]{rstart+1,cmid};

        //else , we have to search using simple binary search
        //search in 1 half
        if(target<=arr[rstart][cmid-1]){
            return Bsearch(arr,target,rstart , 0 , cmid-1);

        }

        //search in 2 half
            if(target>=arr[rstart][cmid+1]&&target<=arr[rstart][col-1]){
                return Bsearch(arr,target,rstart , cmid+1,col-1);

            }
        //search in 3 half
                if(target<=arr[rend][cmid-1]){
                    return Bsearch(arr,target,rend,0,cmid-1);

                }
        //search in 4 half
                    else{
                        return Bsearch(arr,target,rend,cmid+1,col-1);

    }


    }
    static int[] Bsearch(int[][] arr , int target , int row , int cstart , int cend )
    {
        while(cstart<=cend)
        {
            int mid = cstart+(cend-cstart)/2;
            if(arr[row][mid]==target)
                return new int[]{row,mid};
            else if(arr[row][mid]<target)
                cstart = mid+1;
            else
                cend = mid-1;


        }
        return new int[]{-1,-1};
    }
}
