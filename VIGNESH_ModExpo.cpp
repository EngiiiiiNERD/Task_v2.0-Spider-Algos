//This algorithm is based on the formula x^y mod z = ((x mod z)^y)) mod z.
//This method is more efficient than direct application of formula since x mod z to power y can be comparitively faster to calculate 
#include<iostream>
using namespace std;

int expo(int x,unsigned int y,int z) 
{
    if(x==0)
	  return 0;
	else if(y==0)
	  return 1;
	else
	{
       int a=x%z; //calculating x mod z
	   int res=1;
	   for(int u=1;u<=y;u++) // loop for calculating (x mod z)
		 res=res*a;
	   res=res%z;  // calculating final answer
	   return res; 
    }
}
int main()
{
	int a,b,c;
	cout<<"Enter a,b and c in (a^b) % c: ";
	cin>>a>>b>>c;
	int ans=expo(a,b,c);
	cout<<"result: "<< ans;
}
