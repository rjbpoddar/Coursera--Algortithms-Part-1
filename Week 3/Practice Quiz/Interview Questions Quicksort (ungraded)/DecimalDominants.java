3.
Question 3
Decimal dominants.
Answer:
class DecimalDominants {
private TreeMap<Integer, Integer> counts;
private int K;
private int N;
private int[] A;

public DecimalDominants(int[] a, int k) {
A = a;
N = a.length;
K = k;

buildCounts(a);
}

private void buildCounts(int[] a) {
for (int i = 0; i < N; i++) {
if (counts.containsKey(i)) counts.put(i, counts.get(i) + 1);
else counts.put(i, 1);
if (counts.keySet().size() >= K) removeCounts();
}
}

private void removeCounts() {
for (int k : counts.keySet()) {
int c = counts.get(k);
if (c > 1) counts.put(k, c - 1);
else counts.remove(k);
}
}

public Iterable<Integer> find() {
Bag<Integer> result = new Bag<Integer>();
for (int k : counts.keySet()) {
if (count(k) > N/K) result.add(k);
}
return result;
}

private int count(int k) {
int count = 0;
for (int i = 0; i < N; i++) {
if (A[i] == k) count++;
}
return count;
}
}


}