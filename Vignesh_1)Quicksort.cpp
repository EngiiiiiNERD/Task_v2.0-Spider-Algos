// the algorithm used here is quick sort along with sorting when x values are equal but y values are different
#include<iostream>
using namespace std;
struct value
{
    int x;
	int y;	
		void accept()
		{
			cout<<"Enter first element: ";
			cin>>x;
			cout<<"Enter second element: ";
			cin>>y;
		}
		void display()
		{
			cout<<"X: "<< x;
			cout<<" Y: "<< y;
		}
};
int swap(value &p ,value &q)
{
	int s=p.x;
	p.x=q.x;
    q.x=s;
    int g=p.y;
	p.y=q.y;
    q.y=g;
    return 0;
}
int partition(value q[], int a, int b) 
{ 
    int d = q[b].x; 
    int i = a-1 ; 
  
    for (int j = a; j <= b - 1; j++) { 
        if (q[j].x <= d) { 
            i++; 
         if(i>=0 && j>=0)   
         swap(q[i],q[j]); 
        } 
    } 
    swap(q[i + 1], q[b]); 
    return (i + 1); 
} 
void Sort(value A[], int a, int b) 
{ ;
    if (a < b) 
	{ 
        int  p = partition(A,a,b);
        Sort(A,a,p-1); 
        Sort(A,p + 1,b);
          
   }
}
int main()
{
	value p[100];
	int n;
	cout<<"Enter number of ordered pairs: ";
	cin>>n;
	for(int t=0;t<n;t++)
	{
		cout<<endl<<"Enter values for "<< t+1 <<"th element: ";
		p[t].accept();
   }
	Sort(p,0,n-1);	
	for(int f=0;f<n;f++) // sorting if x elements are equal
	{
		if(p[f].x==p[f+1].x)
			if(p[f].y>p[f+1].y)
			 swap(p[f],p[f+1]);
	}
    for(int z=0;z<n;z++)
    {
    	cout<<endl<<z+1<<"th element: ";
		p[z].display();
    }
}
