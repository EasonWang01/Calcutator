package eason.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    TextView tv;
    int[] buttons;					//數字按鈕陣列
    long result;
    long result0;
    long result1;
    TextView tv8;
    int[] buttons8;					//數字按鈕陣列
    long result8;
    long result08;
    long result18;

    Button buttonC;					//按鈕物件宣告
    Button buttonJia;
    Button buttonJian;
    Button buttonCheng;
    Button buttonChu;
    Button buttonDengyu;
    Button buttonC8;					//按鈕物件宣告
    Button buttonJia8;
    Button buttonJian8;
    Button buttonCheng8;
    Button buttonChu8;
    Button buttonDengyu8;

    String str1;									//舊輸入的值
    String str2;									//新輸入的值
    String str18;									//舊輸入的值
    String str28;
    int flag=0;							//計算標志位,0第一次輸入；1加；2減；3乘；4除；5等於
    Button temp;
    int flag8=0;							//計算標志位,0第一次輸入；1加；2減；3乘；4除；5等於
    Button temp8;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();

        //清理按鈕的點擊事件監聽器
        buttonC.setOnClickListener
                (
                        new OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                str1="";
                                str2="";							//清理記錄
                                tv.setText(str1);
                                flag=0;
                            }
                        }
                );
        buttonC8.setOnClickListener
                (
                        new OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                str18="";
                                str28="";							//清理記錄
                                tv8.setText(str18);
                                flag8=0;
                            }
                        }
                );
        //監聽
        for(int i=0;i<buttons.length;i++)
        {
            temp=(Button)findViewById(buttons[i]);
            temp.setOnClickListener
                    (									//為Button加入監聽器
                            new OnClickListener()
                            {
                                public void onClick(View v)
                                {
                                    str1=tv.getText().toString().trim();
                                    str1=str1+String.valueOf(((Button)v).getText());//獲得新輸入的值
                                    System.out.println("str1"+":::"+str1);
                                    tv.setText(str1);
                                }
                            }
                    );
        }
        for(int i=0;i<buttons8.length;i++)
        {
            temp8=(Button)findViewById(buttons8[i]);
            temp8.setOnClickListener
                    (									//為Button加入監聽器
                            new OnClickListener()
                            {
                                public void onClick(View v)
                                {
                                    str18=tv8.getText().toString().trim();
                                    str18=str18+String.valueOf(((Button)v).getText());//獲得新輸入的值
                                    System.out.println("str18"+":::"+str18);
                                    tv8.setText(str18);
                                }
                            }
                    );
        }
        buttonListener(buttonJia,1);
        buttonListener(buttonJian,2);
        buttonListener(buttonCheng,3);
        buttonListener(buttonChu,4);
        buttonListener1(buttonJia8, 1);
        buttonListener1(buttonJian8, 2);
        buttonListener1(buttonCheng8, 3);
        buttonListener1(buttonChu8, 4);

        buttonDengyu.setOnClickListener
                (
                        new OnClickListener()
                        {
                            public void onClick(View v)
                            {System.out.println(str1);
                              try { result1=Long.parseLong(str1);}
                              catch (java.lang.NumberFormatException e) {
                                  Toast.makeText(v.getContext(),"數字太大",Toast.LENGTH_SHORT).show();
                              }
                                if(flag==1)
                                {
                                    result=result0+result1;
                                    System.out.println(result0+":"+result1);
                                }
                                else if(flag==2)
                                {
                                    result=result0-result1;
                                }
                                else if(flag==3)
                                {
                                    result=result0*result1;
                                }
                                else if(flag==4)
                                {
                                    result=(long)(result0/result1);
                                }
                                String str=(result+"").trim();
                                System.out.println(str);
                                tv.setText(str);
                            }
                        }
                );
        buttonDengyu8.setOnClickListener
                (
                        new OnClickListener()
                        {
                            public void onClick(View v)
                            {System.out.println(str18);
                             try  { result18=  Long.parseLong(str18);}
                             catch (java.lang.NumberFormatException e) {
                                 Toast.makeText(v.getContext(),"數字太大",Toast.LENGTH_SHORT).show();
                             }
                                if(flag8==1)
                                {
                                    result8=result08+result18;
                                    System.out.println(result08+":"+result18);
                                }
                                else if(flag8==2)
                                {
                                    result8=result08-result18;
                                }
                                else if(flag8==3)
                                {
                                    result8=result08*result18;
                                }
                                else if(flag8==4)
                                {
                                    result8=(long)(result08/result18);
                                }
                                String str8=(result8+"").trim();
                                System.out.println(str8);
                                tv8.setText(str8);
                            }
                        }
                );

    }

    //起始化按鈕
    public void initButton()
    {						//起始化控制項資源
        tv=(TextView)this.findViewById(R.id.tv);
        tv8=(TextView)this.findViewById(R.id.tv1);//取得文字框控制項物件
        str1=String.valueOf(tv.getText());str2="";    	    	//起始化運算輸入數值
        str18=String.valueOf(tv8.getText());str28="";
        buttonC=(Button)this.findViewById(R.id.ButtonC);	//獲得計算按鈕的按鈕物件
        buttonJia=(Button)this.findViewById(R.id.ButtonJia);
        buttonJian=(Button)this.findViewById(R.id.ButtonJian);
        buttonCheng=(Button)this.findViewById(R.id.ButtonCheng);
        buttonChu=(Button)this.findViewById(R.id.ButtonChu);
        buttonDengyu=(Button)this.findViewById(R.id.ButtonDengyu);
        buttonC8=(Button)this.findViewById(R.id.ButtonC1);	//獲得計算按鈕的按鈕物件
        buttonJia8=(Button)this.findViewById(R.id.ButtonJia1);
        buttonJian8=(Button)this.findViewById(R.id.ButtonJian1);
        buttonCheng8=(Button)this.findViewById(R.id.ButtonCheng1);
        buttonChu8=(Button)this.findViewById(R.id.ButtonChu1);
        buttonDengyu8=(Button)this.findViewById(R.id.ButtonDengyu1);
        buttons=new int[]
                {							//記錄數值按鈕的id
                        R.id.Button00,R.id.Button01,R.id.Button02,R.id.Button03,R.id.Button04,
                        R.id.Button05,R.id.Button06,R.id.Button07,R.id.Button08,R.id.Button09
                };
        buttons8=new int[]
                {							//記錄數值按鈕的id
                        R.id.Button001,R.id.Button011,R.id.Button021,R.id.Button031,R.id.Button041,
                        R.id.Button051,R.id.Button061,R.id.Button071,R.id.Button081,R.id.Button091
                };

    }

    //按鈕監聽
    public void buttonListener(Button button,final int id)
    {
        button.setOnClickListener
                (
                        new OnClickListener()
                        {
                            public void onClick(View v)
                            {
                                String str=tv.getText().toString().trim();
                                try {result0=  Long.parseLong(str);}
                                catch (java.lang.NumberFormatException e) {
                                    Toast.makeText(v.getContext(),"數字太大",Toast.LENGTH_SHORT).show();
                                }
                                tv.setText("");
                                flag=id;

                            }
                        }
                );
    }
    public void buttonListener1(Button button,final int id1)
    {
        button.setOnClickListener
                (
                        new OnClickListener()
                        {
                            public void onClick(View view)
                            {

                                String str8
                                        =tv8.getText().toString().trim();
                                try {result08=  Long.parseLong(str8);}
                                catch (java.lang.NumberFormatException e) {
                                    Toast.makeText(view.getContext(),"數字太大",Toast.LENGTH_SHORT).show();
                                }
                                tv8.setText("");
                                flag8=id1;
                            }
                        }
                );
    }


    }

