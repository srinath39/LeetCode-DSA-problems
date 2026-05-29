class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs,(a,b)->{
            String[] arrA=a.split(" ");
            String[] arrB=b.split(" ");
            // check whether word log or digit log 
            // if word log compare lexicographically or not
            // if digit log maintain relative order 
            boolean isAdigit=isDigitLog(arrA[arrA.length-1]);
            boolean isBdigit=isDigitLog(arrB[arrB.length-1]);
            if(isAdigit && isBdigit){
                return 0;
            }
            if(isAdigit && !isBdigit){
                return 1;
            }
            if(!isAdigit && isBdigit){
                return -1;
            }
            return checkLexico(arrA,arrB);

        });
        return logs;
    }

    public int checkLexico(String[] arrA,String[] arrB){
        int n=arrA.length;
        int m=arrB.length;
        int i=1;
        int j=1;
        while(i<n && j<m){
            int val=arrA[i].compareTo(arrB[i]);
            if(val!=0){
                return val;
            }
            ++i;
            ++j;
        }
        if(j<m){
            return -1;
        }
        if(i<n){
            return 1;
        }
        return arrA[0].compareTo(arrB[0]);
    }

    public boolean isDigitLog(String str){
        return Character.isDigit(str.charAt(str.length()-1));
    }
}