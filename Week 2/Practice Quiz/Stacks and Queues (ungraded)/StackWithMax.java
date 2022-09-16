import java.util.Stack;
import java.util.TreeSet;

class StackWithMax&lt;Item&gt; extends Stack&lt;Item&gt; {

private TreeSet&lt;Item&gt; tree = new TreeSet&lt;Item&gt;();

public Item max() {
return tree.last();
}

public Item push(Item item) {
super.push(item);
tree.add(item);
return item;
}

public Item pop() {
Item item = super.pop();
tree.remove(item);
return item;
}

public static void main(String[] args) {

StackWithMax&lt;Integer&gt; stack = new StackWithMax&lt;Integer&gt;();
int i = 1;
int N = 100;

System.out.println("Size: " + stack.size());
while (i &lt;= N) {
if (i % 3 == 0) {
System.out.println("Max: " + stack.max());
} else {
System.out.println("Push: " + i);
stack.push(i);
}
++i;
}
System.out.println("Size: " + stack.size());
while (!stack.isEmpty()) {
System.out.println("Pop: " + stack.pop());
}
System.out.println("Size: " + stack.size());
}

}