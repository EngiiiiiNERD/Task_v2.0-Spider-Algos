// the algorithm used here is heap sort along with sorting when x values are equal but y values are different
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
void heap(value a[], int n, int i) 
{ 
    int large = i; 
    int l = 2*i + 1;  
    int r = 2*i + 2;   
    if (l < n && a[l].x > a[large].x) 
        large = l;  
    if (r < n && a[r].x > a[large].x) 
        large = r; 
  
     if (large != i) 
    { 
        swap(a[i],a[large]); 
        heap(a, n, large); 
    } 
}
void Sort(value a[], int n) 
{ 
 
    for (int i = n / 2 - 1; i >= 0; i--) 
        heap(a, n, i);  
    for (int i=n-1; i>=0; i--) 
    {  
        swap(a[0], a[i]);  
        heap(a, i, 0); 
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
	Sort(p,n);	
	for(int f=0;f<n;f++) 
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
