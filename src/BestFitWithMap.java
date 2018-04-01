
import java.util.*;
public class BestFitWithMap{
    static Scanner sc=new Scanner(System.in);
    static int mn,next=0;
    static int memory[],processb[];
    static HashMap<Integer, Integer> processId_size = new HashMap<>();
    static HashMap<Integer, Integer> processId_index = new HashMap<>();

    static int processId = 1;
    public static void main(String str[]){
        System.out.print("Enter total number of memory blocks:\t");
        mn=sc.nextInt();
        System.out.println("Enter memory block size");
        create(mn);
        System.out.println("ALLOCATION: ------Enter any number less than 0 to quit-------");
        int p=1;
        while(p>0){
            System.out.print("Enter process size for processId:\t");
            p = sc.nextInt();
            if(p>0){
                allocate(p);
            }
        }

        stats();

        System.out.println("DEALLOCATION: -----Enter any number less than 0 to quit -------");
        p=1;
        while(p>0){
            System.out.print("Enter processId:\t");
            p = sc.nextInt();
            if(p>0){
                deallocate(p);
            }
        }

        stats();

    }
    static void create(int n){
        int i;
        memory=new int[mn];
        processb=new int[mn];
        for(i=0;i<mn;i++){
            System.out.print("-->\t");
            memory[i]=sc.nextInt();
            processb[i] = memory[i];
        }
    }

    static void deallocate(int processId){
        Integer process_size = processId_size.get(processId);
        Integer process_index = processId_index.get(processId);
        System.out.println(process_size);
        System.out.println(process_index);

        if(process_size != null && process_index != null){
            processb[process_index] += process_size;
            processId_index.remove(process_index);
            processId_size.remove(process_index);
            System.out.println("Best Fit:\tprocessId "+processId+" with the size of "+process_size+"-->"+memory[process_index]+" freed with "+processb[process_index]+" left");
        }
    }
    static void allocate(int p){
        int min_delta_index = -1;
        for(int index = 0; index < memory.length; index++){
            if(p <= processb[index]){
                if(min_delta_index == -1 || processb[index] < processb[min_delta_index]){
                    min_delta_index = index;
                }
            }
        }
        if(min_delta_index == -1){
            System.out.println("Best Fit:\tprocessId "+processId+" with the size of "+p+" cannot be placed.");
        }else{
            processb[min_delta_index] = processb[min_delta_index] - p;
            processId_size.put(processId, p);
            processId_index.put(processId, min_delta_index);
            System.out.println("Best Fit:\tprocessId "+processId+" with the size of "+p+"-->"+memory[min_delta_index]+" with "+processb[min_delta_index]+" left");
            processId++;

        }

        // if(!isFullb()){
        //     int i,min=5000,index=-1;
        //     for(i=0;i<mn;i++){
        //         if(min>(memory[i]-p) && (memory[i]-p)>=0 && processb[i]==0){
        //             min=memory[i]-p;
        //             index=i;
        //         }
        //     }
        //     if(index==-1)
        //         System.out.println("Best Fit:\tprocess "+p+" cannot be placed.");
        //     else{
        //         processb[index]=p;
        //         System.out.println("Best Fit:\tprocess "+p+"-->"+memory[index]);
        //     }
        // }
    }

    static public void stats(){
        int totalSize = 0;
        System.out.println();
        System.out.println("Status ");
        for (int i = 0; i < memory.length; i++) {
            int remainingSpace = memory[i]-processb[i];
            System.out.println("Best Fit: "+i+"  remaining space --> "+remainingSpace);
            totalSize+=remainingSpace;
        }
        System.out.println(" Free space : "+totalSize);
    }

}
