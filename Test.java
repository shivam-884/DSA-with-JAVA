public class Test {

    public static void merge(int b[], int c[], int a[]){
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < b.length && j < c.length){
            if(b[i] <= c[j]){
                a[k] = b[i];
                i++;
                k++;
            }else{
                a[k] = c[j];
                j++;
                k++;
            }
        }
        if(i < b.length){
            while(i < b.length){
                a[k] = b[i];
                i++;
                k++;
            }
        }

        if(j < c.length){
            while (j < c.length){
                a[k] = c[j];
                j++;
                k++;
            }
        }
    }


    public static void mergeSort(int a[]){
        if(a.length == 1){
            return;
        }

        int[] b = new int[a.length/2];
        int[] c = new int[a.length-b.length];

        for(int i=0; i<a.length/2; i++){
            b[i] = a[i];
        }

        for(int i=a.length/2; i<a.length; i++){
            c[i-(a.length/2)] = a[i];
        }

        mergeSort(b);
        mergeSort(c);
        merge(b,c,a);
    }

    public static int maximumProfit(int budget[]) {
        // Write your code here
        mergeSort(budget);
        int max = Integer.MIN_VALUE;
        int n = budget.length;
        for(int i=0; i<n; i++){
            int temp = budget[i] * (n-i);
            if(temp >= max){
                max = temp;
            }else{
                break;
            }
        }
        return max;
    }



    public static boolean checkSequence(String a, String b) {
        if(b.length()==0)
            return true;

        if(a.length() == 0)
            return false;


        if(a.charAt(0) == b.charAt(0))
            return checkSequence(a.substring(1), b.substring(1));
        else
            return checkSequence(a.substring(1), b);
    }

    public static void main(String[] args) {
        System.out.println(checkSequence("abchjsgsuohhdhyrikkknddg","coding"));
    }
}
