import java.util.*;

public class InfixToPostfix{

public static int inputprecedence(char c){
    if(c == '+' || c == '-'){ 
    	return 1;
    }
    if(c == '*' || c == '/'){
     return 3;
    }
    if(c == '^'){
     return 6;
    }
    if(c == '(') {
    	return 9;
    }
    if(c == ')'){
    	return 0;
    }  
    return 7;

}
public static int stackprecedence(char c){
    if(c == '+' || c == '-') {
    	return 2;
    }
    if(c == '*' || c == '/'){
     return 4;
    }
    if(c == '^'){
     return 5;
    }
    if(c == '('){
     return 0;
    }
    return 8;

}
public static int rank( char c){
    if(inputprecedence(c)==7) return 1;
    return -1;
}
public static String PostFix(String string){
    Stack <Character> stack = new Stack<>();
    String polish="";
    int rank= 0;

    stack.push('(');
    for(int i=0;i<string.length();i++){
        if(stack.isEmpty()){
            return "Invalid String";
        }
        while(stackprecedence(stack.peek()) > inputprecedence(string.charAt(i))){
            char temp = stack.pop();
            polish += temp;
            rank += rank(temp);
            if(rank< 1){
                return "Invalid String";
            }
        }
        if(stackprecedence(stack.peek()) != inputprecedence(string.charAt(i))){
            stack.push(string.charAt(i));
        }
        else stack.pop();
    }
    return polish;

}


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String : ");
        String string= new String(sc.next());
        System.out.println("Ans = " + PostFix(string));
    }
}