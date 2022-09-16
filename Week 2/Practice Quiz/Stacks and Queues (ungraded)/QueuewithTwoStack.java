import java.util.Stack;

class StackQueue<Item> {

private Stack<Item> input = new Stack<Item>();
private Stack<Item> output = new Stack<Item>();

public StackQueue() {

}

public int size() {
return input.size() + output.size();
}

public boolean isEmpty() {
return (size() == 0);
}

public void enqueue(Item item) {
if (item == null) {
throw new java.lang.NullPointerException();
}
input.push(item);
}

public Item dequeue() {
if (isEmpty()) {
throw new java.util.NoSuchElementException();
}

if (output.isEmpty()) {
while (!input.isEmpty()) {
output.push(input.pop());
}
}

return output.pop();
}

// unit testing
public static void main(String[] args) {
StackQueue<Integer> squeue = new StackQueue<Integer>();
int i = 0;
int N = 100;

System.out.println("Size: " + squeue.size());
squeue.enqueue(i);
while (i <= N) {
if (i % 3 == 0) {
System.out.println("Dequeue: " + squeue.dequeue());
} else {
squeue.enqueue(i);
System.out.println("Enqueue: " + i);
}
++i;
}
System.out.println("Size: " + squeue.size());
while (!squeue.isEmpty()) {
System.out.println("Dequeue: " + squeue.dequeue());
}
System.out.println("Size: " + squeue.size());
}

}