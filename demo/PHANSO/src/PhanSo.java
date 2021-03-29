package src;
public class PhanSo {
    int t, m;

    public PhanSo()
    {
        t = 0;
        m = 1;
    }

    public PhanSo(int t1, int m1)
    {
        t = t1;
        m = m1;
    }

    public int GCD(int a, int b){
        while(b!=0)
        {
            int t=b;
            b=a%b;
            a=t;
        }
        return  a;
    }

    public PhanSo cong (PhanSo ps1)
    {
        PhanSo temp = new PhanSo();

        temp.t = t*ps1.m + m*ps1.t;
        temp.m = m*ps1.m;

        return temp;
    }

    public int compare(PhanSo ps){
        int kq=t*ps.m-m*ps.t;
        
        if(kq==0) return 0;
        if(kq>0) return 1;
        return -1;
    }
    
    @Override
    public String toString()
    {
        return t + "/" + m;
    }



}
