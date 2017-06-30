# Conclusions of Algorithms

## 1. [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
It's one of the fastest prime number finding algorithms.To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:
1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
2. Initially, let p equal 2, the smallest prime number.
3. Enumerate the multiples of p by counting to n from 2p in increments of p, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
4. Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.
<pre><code>
    public static void findPrimeNumber(int n) {
        boolean[] list = new boolean[n];
        Arrays.fill(list, 1, n, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (list[i - 1]) {
                for (int j = i * i; j <= n; j += i) {
                    list[j - 1] = false;
                }
            }
        }
        ArrayList<Integer> primeNum = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (list[i]) {
                primeNum.add(i + 1);
                System.out.println((i + 1) + " ");
            }
        }
    }
</code></pre>
This algorithm produces all primes not greater than n. It includes a common optimization, which is to start enumerating the multiples of each prime i from i2. The time complexity of this algorithm is O(n log log n),[8] provided the array update is an O(1) operation, as is usually the case.

## 2. Asymptotic Analysis

### Notation
1. Big-Theta: f(n) is in Θ(g(n)) if and only if f(n) is proportional to g(n) as n approaches infinity.
2. Big-Oh: If f(n) is in O(g(n)), it means f is in a set of functions that are upper-bounded by g.
3. Big-Omega: If f(n) is in Ω(g(n)), it means f is in a set of functions that are lower-bounded by g.

### Commonly-Occurring Orders of growth
* **constant time**
* **logarithmic time** or proportional to *logN*
* **linear time** or proportional to *N*
* **quadratic/polynomial time** or proportional to *N2*
* **exponential time** or proportional to *kN*
* **factorial time** or proportional to *N!*

### Useful Formulas
* 1+2+3+4+⋯+N is in Θ(N2)
* There are N terms in the sequence 1,2,3,4,⋯,N
* 1+2+4+8+⋯+N is in Θ(N)
* There are logN terms in the sequence 1,2,4,8,⋯,N
* The number of nodes in a tree, N, is equal to kh where k is the branching factor and h is the height of the tree
* All logarithms are proportional to each other by the Change of Base formula so we can express them generally as just log.
