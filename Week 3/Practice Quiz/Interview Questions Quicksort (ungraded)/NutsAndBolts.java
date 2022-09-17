1.
Question 1
Nuts and bolts :
Answer : 
package jobinterviewquestions;
import algs4.Bag;
import stdlib.In;
import java.util.TreeMap;
import java.util.TreeSet;
public class QuickSort {
class Nut {
private int size;
public int compare(Bolt bolt) {
if (bolt.size > this.size) return -1;
else if (bolt.size < this.size) return 1;
else return 0;
}
}

class Bolt {
private int size;
}

public void pair(Bolt[] bolts, Nut[] nuts) {
int n = nuts.length;
assert bolts.length == n;
Nut[] auxN = new Nut[n];
Bolt[] auxB = new Bolt[n]; //need TreeMap to implement
for (int i = 0; i < n; i++) {
int lo = floor(auxB, nuts[i]); //use floor api in TreeMap
int hi = ceil(auxB, nuts[i]); //use ceil api in TreeMap
int index = partition(bolts, nuts[i], lo, hi);
auxB[index] = bolts[index];
auxN[index] = nuts[i];
}

for (int i = 0; i < n; i++) {
nuts[i] = auxN[i];
}
}

private int partition(Bolt[] bolts, Nut nut, int lo, int hi) {
int l = lo;
int r = hi;
while (true) {
while (nut.compare(bolts[++l]) > 0) if (l == hi) break;
while (nut.compare(bolts[--r]) < 0) if (r == lo) break;
if (l >= r) break;
exch(bolts, l, r);
}
return l;
}

private void exch(Bolt[] bolts, int l, int r) {
Bolt tmp = bolts[l];
bolts[l] = bolts[r];
bolts[r] = tmp;
}

private int floor(Bolt[] b, Nut nut) {
return 0;
}

private int ceil(Bolt[] b, Nut nut) {
return 0;
}