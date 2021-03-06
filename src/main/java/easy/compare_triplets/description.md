Alice and Bob each created one problem for HackerRank. A reviewer rates the two challenges, awarding points on a scale from  to  for three categories: problem clarity, originality, and difficulty.

We define the rating for Alice's challenge to be the triplet A = (a0, a1, a2), and the rating for Bob's challenge to be the triplet B = (b0, b1, b2).

Your task is to find their comparison points by comparing  with ,  with , and  with .

If ai > bi, then Alice is awarded  point.
If ai < bi, then Bob is awarded  point.
If ai == bi, then neither person receives a point.
Comparison points is the total points a person earned.

Given A and B, can you compare the two challenges and print their respective comparison points?

Input Format

The first line contains 3 space-separated integers, a0, a1, and a2, describing the respective values in triplet A. 
The second line contains 3 space-separated integers, b0, b1, and b2, describing the respective values in triplet B.


Output Format

Print two space-separated integers denoting the respective comparison points earned by Alice and Bob.

Sample Input

5 6 7
3 6 10
Sample Output
1 1 
