class Solution {
    public static void backtrack(String num,int tar,int index,long value,long prev, String expression ,List<String>ans){
        if(index==num.length()){
            if(value==tar){
                ans.add(expression);
            }
            return;
        }

        for(int i=index;i<num.length();i++){
            if(i>index && num.charAt(index)=='0'){
                break;
            }

            long curr=Long.parseLong(num.substring(index,i+1));

        if(index==0){
            backtrack(num,tar,i+1,curr,curr,expression+curr,ans);
        }else{
            backtrack(num,tar,i+1,value+curr,curr,expression+"+"+curr,ans);
        backtrack(num,tar,i+1,value-curr,-curr,expression+"-"+curr,ans);
        backtrack(num,tar,i+1,value-prev+prev*curr,prev*curr,expression+"*"+curr,ans);
    }
        }

    }
    public List<String> addOperators(String num, int target) {
        List<String>ans=new ArrayList<>();
        backtrack(num,target,0,0,0,"",ans);
        return ans;
    }
}



/*In this problem, what we want to do is generate all possible expressions by placing +, -, or * between the digits of the given number string. 
So we use backtracking, where at every index we try taking different lengths of numbers from the string. For example, we can take one digit, two digits, 
three digits, and so on, and for every number after the first one, we try all three operators. For the first number, we directly make it the current value. 
For + we add the current number to the value, for - we subtract it, and for * we need to handle operator precedence, so we keep track of the previous number.
We remove the previous number from the current value and then add previous * current, which makes multiplication happen before addition or subtraction. 
We continue this recursively until we reach the end of the string. At that point, if our calculated value is equal to the target, we add that expression to the answer.
We also handle leading zeros by stopping when a number starts with 0, because numbers like 05 are not allowed.

Time: O(4^n × n)
Space: O(n + k × n)*/
