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
void merge(value a[], int l, int m, int r) 
{ 
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 =  r - m; 
    int L[n1], R[n2]; 
    for (i = 0; i < n1; i++) 
        L[i] = a[l + i].x; 
    for (j = 0; j < n2; j++) 
        R[j] = a[m + 1+ j].x; 
    i = 0;  
    j = 0;  
    k = l;  
	   while (i < n1 && j < n2) 
    { 
        if (L[i] <= R[j]) 
        { 
            a[k].x = L[i]; 
            i++; 
        } 
        else
        { 
            a[k].x = R[j]; 
            j++; 
        } 
        k++; 
    } 
  
      while (i < n1) 
    { 
        a[k].x = L[i]; 
        i++; 
        k++; 
    } 
      while (j < n2) 
    { 
        a[k].x= R[j]; 
        j++; 
        k++; 
    } 
} 
void Sort(value a[], int l, int r) 
{ 
    if (l < r) 
    { 
        int m = l+(r-l)/2;  
        Sort(a, l, m); 
        Sort(a, m+1, r); 
        merge(a, l, m, r); 
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
