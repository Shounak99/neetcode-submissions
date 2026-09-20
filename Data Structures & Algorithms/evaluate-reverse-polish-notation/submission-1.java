class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String str:tokens){
            if(str.equals("+")||str.equals("-")||str.equals("/")||str.equals("*")){
                int val1=st.pop();
                int val2=st.pop();
               
                switch(str){
                    case "+":st.push(val1+val2);
                    break;
                    case "-":st.push(val2-val1);
                    break;
                    case "*":st.push(val1*val2);
                    break;
                    case "/":st.push(val2/val1);
                }
               
            }
            else{
                int val=Integer.parseInt(str);
                st.push(val);
            }
        }
        return st.pop();
    }
}
