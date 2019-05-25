// Algorithm for modular Exponentiation.
// one of the shortest method for modular exponentiation.

#include<iostream>
using namespace std;
int mod(int x,int n,int m) 
{ int y;
  if(n==0) return 1;
  else if(n%2==0) { y=mod(x,n/2,m); return (y*y)%m;} // using recursion.
  else return((x%m)*mod(x,n-1,m))%m;
}
int main()
{
	int a,b,c;
	cout<<"Enter a,b,c ";
	cin>>a>>b>>c;
	int result=mod(a,b,c);
	cout<<"value is "<< result;
}
