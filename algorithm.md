# Algorithms Conclusions

## 1. [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes)
It's one of the fastest prime number finding algorithms.To find all the prime numbers less than or equal to a given integer n by Eratosthenes' method:
* 1. Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
* 2. Initially, let p equal 2, the smallest prime number.
* 3. Enumerate the multiples of p by counting to n from 2p in increments of p, and mark them in the list (these will be 2p, 3p, 4p, ...; the p itself should not be marked).
* 4. Find the first number greater than p in the list that is not marked. If there was no such number, stop. Otherwise, let p now equal this new number (which is the next prime), and repeat from step 3.
* 5. When the algorithm terminates, the numbers remaining not marked in the list are all the primes below n.
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
