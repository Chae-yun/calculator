package kr.hs.emirim.ycy6685.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{ //온클릭 2개인데 뷰.뷰 가 맞다

    Button butPlus, butMinus, butDivide, butMultiply; //임의로 참조변수의 이름을 붙임
    EditText editNum1, editNum2; //버튼이랑 얘랑 아래랑 셋다 위젯패키지
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에서 만든 아이디 등등이 R클래스에 저장이 되어있음
        //이 메서드가 레이아웃폴더 안에 액티비티 메인에서 만든 클래스파일들을 찾아서 메인메모리에 객체로 만들어주는 역할을 함
        //이렇게 메인메모리에 올려주는 걸 안드로이드에서는 인플레이션 이라고 함 (로드라고 하기도..)

        butPlus=(Button)findViewById(R.id.but_plus); //뷰가 버튼의 최상위 클래스이기 때문에 버튼으로 형변환 할 수 있다 (해야함)
        butMinus=(Button)findViewById(R.id.but_minus);
        butDivide=(Button)findViewById(R.id.but_divide);
        butMultiply=(Button)findViewById(R.id.but_multiply);

        editNum1=(EditText)findViewById(R.id.edit_num01);
        editNum2=(EditText)findViewById(R.id.edit_num02);

        textResult=(TextView)findViewById(R.id.text_result);

        butPlus.setOnClickListener(this); //butPlus 의 참조값에 감시자를 둔다?? 핸들러(this)와 연결, 이러면 온클릭이 호출됨
        butMinus.setOnClickListener(this);
        butDivide.setOnClickListener(this);
        butMultiply.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) { //인터페이스의 추상클래스를 꼭 구현해주어야함
        //이벤트가 발생된 객체의 id 값을 v가 가지고 있다, 이걸로 무슨 버튼 클릭되었는지 구별

        //2개의 EditText에 입력된 값을 반환받는다
        String num1Str=editNum1.getText().toString(); //toString 안 붙일 거면 = 뒤에 강제 형변환 해도 ㅇㅇ?
        String num2Str=editNum2.getText().toString();

        int num1=Integer.parseInt(num1Str);
        int num2=Integer.parseInt(num2Str);

        double result=0;

        switch(v.getId()){
            case R.id.but_plus:
                result=num1+num2; break;
            case R.id.but_minus:
                result=num1-num2; break;
            case R.id.but_divide:
                result=(double)num1/num2; break;
            case R.id.but_multiply:
                result=num1*num2; break;
        }

        textResult.setText("> 계산 결과 : "+result);
    }
}
//메인이 이벤트핸들러클래스도 됨