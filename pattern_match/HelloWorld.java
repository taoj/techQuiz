public class HelloWorld{

     public static void main(String []args){
        System.out.println("Hello World");
        Solution s = new Solution();
        
        if(s.doIt("catcatgohcat", "aabaa")){
            System.out.println("yes");
        }else{
          System.out.println("no"); 
        }
     }
     
     public static void log(Object str){
         System.out.println(str.toString());
     }
}


class Solution{
    
    public boolean doIt(String src, String pattern){
        
        int countB = 0;
        for(int i = 0; i < pattern.length(); i++)
        {
            if(pattern.charAt(i) == 'b'){
                countB++;
            }
        }
        
        int length = src.length();
        for(int i = 1; i <= length; i++){
            String subStr = src.substring(0,i);
            
            StringBuilder sb = new StringBuilder(src);
            int tmp = -1;
            while((tmp = sb.indexOf(subStr)) != -1){
                
                sb.delete(tmp, tmp+i);
            }
            String bIs = gang(sb, countB);
            if(bIs == null)
                return false;
                
                
            if(test(subStr, bIs, pattern, src)){
                log("a is " + subStr);
                log("b is " + bIs);
                return true;
            }
            
        }
        return false;
        
    }
    
    String gang(StringBuilder sb, int count){
        // log("=====================");
        // log("sb is " + sb.toString());
    
        if(sb.length()%count != 0 || sb.length() == 0){
            return null;
        }
        
        
        return sb.substring(0,sb.length()/count);
        
    }
    
    boolean test(String subStr, String bIs, String pattern, String src){
        StringBuilder sb = new StringBuilder();
        int length = pattern.length();
        for(int i = 0; i <length; i++ ){
            sb.append(pattern.charAt(i) == 'a' ? subStr : bIs);
        }
        if(sb.toString().equals(src))
        {return true;}
        
        return false;
    }
    
    public void log(Object str){
         System.out.println(str.toString());
     }
    
}