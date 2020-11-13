class EvaluatePostfixChallenge {
    public static int evaluatePostFix(String expression) {
		Stack<Integer> stack = new Stack<>(expression.length());
		for(int i = 0 ; i < expression.length(); i++){
			char character = expression.charAt(i);
			if(!Character.isDigit(character)){
				Integer x = stack.pop();
				Integer y = stack.pop();
				switch(character){
					case '+':
						stack.push(y+x);
						break;
					case '-':
						stack.push(y-x);
						break;
					case '*':
						stack.push(y*x);
						break;
					case '/':
						stack.push(y/x);
						break;
				}
			}else
				stack.push(Character.getNumbericValue(character));

		}
		return stack.pop();	

	}
}