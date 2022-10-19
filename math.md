```java
//nest myPow
double myPow(double x, int n) {
    if(n<0) return 1/x * myPow(1/x, -(n+1));
    if(n==0) return 1;
    if(n==2) return x*x;
    if(n%2==0) return myPow( myPow(x, n/2), 2);
    else return x*myPow( myPow(x, n/2), 2);
}
//double myPow
double myPow(double x, int n) {
    if(n==0) return 1;
    double t = myPow(x,n/2);
    if(n%2) return n<0 ? 1/x*t*t : x*t*t;
    else return t*t;
}
//double x
double myPow(double x, int n) {
    if(n==0) return 1;
    if(n<0){
        n = -n;
        x = 1/x;
    }
    return n%2==0 ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
}
//iterative one
double myPow(double x, int n) {
    if(n==0) return 1;
    if(n<0) {
        n = -n;
        x = 1/x;
    }
    double ans = 1;
    while(n>0){
        if(n&1) ans *= x;
        x *= x;
        n >>= 1;
    }
    return ans;
}
//bit operation
```
