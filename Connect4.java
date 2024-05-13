import java.util.*;
class Connect4
{
static void print(char a[][],int x,int y)
{
int i,j;
for(i=0;i<y;i++)
System.out.print(" _");
System.out.println();
for(i=0;i<x;i++)
{
for(j=0;j<y;j++)
{
System.out.print("|"+a[i][j]);
}
System.out.println("|");
}
}
static boolean check(char a[][],int x,int y,char c)
{
int i,j,count=0;
boolean b=false;
ab1:for(i=0;i<x;i++)//ROW CHECK
{
for(j=0;j<y;j++)
{
if(a[i][j]==c)
{
count++;
if(count==4)
{
b=true;
break ab1;
}
}
else
count=0;
}
}
if(b==true)
return true;
count=0;
b=false;
//ROW CHECK ENDS
ab2:for(j=0;j<y;j++)//COLOUMN CHECK
{
for(i=0;i<x;i++)
{
if(a[i][j]==c)
{
count++;
if(count==4)
{
b=true;
break ab2;
}
}
else
count=0;
}
}
if(b==true)
return true;
//COLOUMN CHECK ENDS
b=false;
count=0;
int k=0;
ab3:for(i=x-4;i>0;i--)//DIAGONAL CHECK 1(left to right)
{
k=i;
j=0;
count=0;
while(true)
{
if(k>=x || j>=y)
break;
else
{
if(a[k][j]==c)
count++;
else
{
if(count==4)
{
b=true;
break ab3;
}
else
count=0;
}
}
k++;
j++;
}
}
if(b==true)
return true;
//DIAGONAL CHECK 1 ENDS
b=false;
count=0;
ab4:for(j=0;j<=y-4;j++)//DIAGONAL CHECK 2(left to right)
{
k=j;
i=0;
count=0;
while(true)
{
if(k>=y || i>=x)
break;
else
{
if(a[i][k]==c)
{
count++;
if(count==4)
{
b=true;
break ab4;
}
}
else
count=0;
}
k++;
i++;
}
}
if(b==true)
return true;
//DIAGONAL CHECK 2 ENDS
b=false;
count=0;
ab5:for(j=3;j<y;j++)//DIAGONAL CHECK 3(right to left)
{
k=j;
i=0;
count=0;
while(true)
{
if(k<0 || i>=x)
break;
else
{
if(a[i][k]==c)
{
count++;
if(count==4)
{
b=true;
break ab5;
}
}
else
count=0;
}
k--;
i++;
}
}
if(b==true)
return true;
//DIAGONAL CHECK 3 ENDS
b=false;
count=0;
ab6:for(i=x-4;i>0;i--)//DIAGONAL CHECK 4(right to left)
{
k=i;
j=y-1;
count=0;
while(true)
{
if(k>=x || j<0)
break;
else
{
if(a[k][j]==c)
{
count++;
if(count==4)
{
b=true;
break ab6;
}
}
else
count=0;
}
k++;
j--;
}
}
if(b==true)
return true;
//DIAGONAL CHECK 4 ENDS
return false;
}
public static void main(String args[])throws Exception
{
Scanner z=new Scanner(System.in);
int i,j,x=0,y=0,l,m;
System.out.println("Enter Dimensions of your grid:");
String x1="",y1="";
while(true)
{
try
{
x1=z.next();
y1=z.next();
x=Integer.parseInt(x1);
y=Integer.parseInt(y1);
}
catch(Exception e)
{
System.out.println("Invalid Input!!!");
System.out.println("Try again by entering two non-zero positive numbers");
continue;
}
if(x<4 && y<4 || x<=0 || y<=0)
{
System.out.println("Insufficient Dimensions!!!");
System.out.println("Try again and enter numbers atleast greater than or equal to 4");
continue;
}
break;
}
char a[][]=new char[x][y];
for(i=0;i<x;i++)
{
for(j=0;j<y;j++)
{
a[i][j]='_';
}
}
print(a,x,y);
i=0;
j=0;
boolean trig=false;
String p1="",p2="";
System.out.println("Both players enter their names");
p1=z.next();
p2=z.next();
System.out.println(p1+" is X");
System.out.println(p2+" is O");
String s1="",s2="",l1="",m1="";
char c=' ',d=' ';
Random r=new Random();
int t=r.nextInt(2);
if(t==0)
{
s1=p1;
c='X';
s2=p2;
d='O';
}
else
{
s1=p2;
c='O';
s2=p1;
d='X';
}
while(true)
{
System.out.println(s1+"'s turn");
while(true)
{
try
{
l1=z.next();
m1=z.next();
l=Integer.parseInt(l1)-1;
m=Integer.parseInt(m1)-1;
}
catch(Exception f1)
{
System.out.println("Invalid Input!!!");
System.out.println("Try again by entering two non-zero positive numbers greater than or equal to "+x+" and "+y+" respectively");
continue;
}
if(l<0 || l>=x || m<0 || m>=y)
{
System.out.println("Invalid Input!!!");
System.out.println("Try again by entering two non-zero positive numbers greater than or equal to "+x+" and "+y+" respectively");
continue;
}
if(a[l][m]!='_')
{
System.out.println("Position already occupied!!!");
System.out.println("Try again");
continue;
}
break;
}
a[l][m]=c;
print(a,x,y);
trig=check(a,x,y,c);
if(trig==true)
{
System.out.println(s1+" wins");
System.out.println("GAME OVER!!!");
break;
}
System.out.println(s2+"'s turn");
while(true)
{
try
{
l1=z.next();
m1=z.next();
l=Integer.parseInt(l1)-1;
m=Integer.parseInt(m1)-1;
}
catch(Exception f2)
{
System.out.println("Invalid Input!!!");
System.out.println("Try again by entering two non-zero positive numbers greater than or equal to "+x+" and "+y+" respectively");
continue;
}
if(l<0 || l>=x || m<0 || m>=y)
{
System.out.println("Invalid Input!!!");
System.out.println("Try again by entering two non-zero positive numbers greater than or equal to "+x+" and "+y+" respectively");
continue;
}
if(a[l][m]!='_')
{
System.out.println("Position already occupied!!!");
System.out.println("Try again");
continue;
}
break;
}
a[l][m]=d;
print(a,x,y);
trig=check(a,x,y,d);
if(trig==true)
{
System.out.println(s2+" wins");
System.out.println("GAME OVER!!!");
break;
}
}
}
}