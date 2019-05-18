

public class satyam_ModExp {


    static int ModExp(int x, int y, int p)
    {
        if(x==0)
            return 0;
        if(y==0)
            return 1;

        long z;
        if(y%2==0)
        {
            z=ModExp(x, y/2, p);
            z=(z*z)%p;
        }

        else
        {
            z=x%p;
            z=(z*ModExp(x, y-1, p))%p;
        }

        return (int)z;
    }

    public static void main (String[]args)
    {
        int a=4, b=5, c=12;
        System.out.println("("+a+"^"+b+")%"+c+" is "+ModExp(a, b, c));
    }
}
