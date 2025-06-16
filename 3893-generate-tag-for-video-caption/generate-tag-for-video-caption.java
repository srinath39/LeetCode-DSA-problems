class Solution {
    public String generateTag(String caption) {
        if(caption.isEmpty() || caption.isBlank()){
            return "#";
        }
        String[] arr=caption.trim().split(" ");
        StringBuilder str=new StringBuilder("#");
        int n=arr.length;
        str.append(arr[0].toLowerCase());
        outer:
        for(int i=1;i<n;i++){
            String cur=arr[i];
            for(int j=0;j<cur.length();j++){
                char c=cur.charAt(j);
                if(j==0){
                    str.append(Character.toUpperCase(c));
                }else{
                    str.append(Character.toLowerCase(c));
                }
            }
        }
        int len=str.length();
        if(len<=100){
            return str.toString();
        }
        return str.toString().substring(0,100);
    }
}