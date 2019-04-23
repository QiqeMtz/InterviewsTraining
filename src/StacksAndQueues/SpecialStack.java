package StacksAndQueues;

import java.util.*;

/**
 * Consider the following SpecialStack
16  --> TOP
15
29
19
18

When getMin() is called it should return 15,
which is the minimum element in the current stack.

If we do pop two times on stack, the stack becomes
29  --> TOP
19
18

When getMin() is called, it should return 18
which is the minimum in the current stack.

Stack<Integer> stack = ...

push(val)
  stack.push(val);
  checkMin()
pop()
  stack.pop();
  checkMin();
min()
  return stack.pop();

checkMin(val)
 // Push
 if(stack.isEmpty())
  stack.push(val)

  if(val < stack.peek())
    stack.push
  else
    temp = stack.pop()
    stack.push(val)
    stack.push(temp)

10

stackOriginal= 10, 2,

checkMIn(2< 10)
checkMin(11<2)
check(1<=2)


10, 2,
stackHelper = 10
stackHelper.pop()
stackHelper.push(2)

helper.push(2)
 */

class SpecialStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(30);
        stack.min();
        System.out.println(stack.min());
        stack.push(9);
        stack.push(7);
        System.out.println(stack.min());
        stack.push(0);
        stack.push(2);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }

    static class MyStack{
        Stack<Integer> numbers;
        Stack<Integer> helper;

        void push(Integer val) {
            numbers.push(val);
            if(helper.isEmpty() ||  val <= helper.peek())
                helper.push(val);
        }

        Integer pop() {
            if(!helper.isEmpty() && numbers.peek().equals(helper.peek()))
                helper.pop();

            return numbers.pop();
        }

        Integer min() {
            return helper.peek();
        }

        public MyStack() {
            this.numbers = new Stack<Integer>();
            this.helper = new Stack<Integer>();
        }

    }
}

