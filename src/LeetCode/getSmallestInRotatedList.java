package LeetCode;

public class getSmallestInRotatedList {

    public static void main(String[] args) {
        int [] a = new int[]{10,20,30,40,50,60,1,2,3,4};
        System.out.println("Smallest element is : "+smallest(a,0, a.length-1));

        int [] b = new int[]{1,2,3,4,10,20,30,40,50,60};
        System.out.println("Smallest element is : "+smallest(b,0, b.length-1));

        int [] c = new int[]{50,60,1,2,3,4,10,20,30,40};
        System.out.println("Smallest element is : "+smallest(c,0, c.length-1));

        int [] d = new int[]{50,60,70,2,2,4,10,20,30,40};
        System.out.println("Smallest element is : "+smallest(d,0, d.length-1));

        /*int [] e = new int[]{3};
        System.out.println("Smallest element is : "+smallest(e,0, e.length-1));*/
    }

    public static int smallest(int [] a, int start, int end){


        int mid =  start+((end-start)/2);
        System.out.println("a[ "+mid+" ] : "+a[mid]);
        if(a[mid]>a[mid+1]){
            return a[mid+1];
        }else{
            if(a[mid]>a[end])
                return smallest(a,mid+1,end);
            else if(a[start]>a[mid])
                return smallest(a,start,mid-1);
            else
                return a[start];
        }
    }
}
