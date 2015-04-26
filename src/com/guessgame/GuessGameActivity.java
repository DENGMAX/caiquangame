package com.guessgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GuessGameActivity extends Activity {
	private TextView introduction;
	private Button Zhangfei;
	private Button Liubei;
	private Button Guanyu;
	private EditText peopleSelext;
	private Button begin;
	private Button gengxin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Zhangfei=(Button)findViewById(R.id.Zhangfei);
        Liubei=(Button)findViewById(R.id.Liubei);
        Guanyu=(Button)findViewById(R.id.Guanyu);
        peopleSelext=(EditText)findViewById(R.id.peopleSelext);
        begin=(Button)findViewById(R.id.begin);
        gengxin=(Button)findViewById(R.id.gengxin);
        //��
        Zhangfei.setOnClickListener(new ZhangfeiListener());
        Liubei.setOnClickListener(new LiubeiListener());
        Guanyu.setOnClickListener(new GuanyuListener());
        begin.setOnClickListener(new beginGame());
        gengxin.setOnClickListener(new GengxinListener());
        
    }
    /**
     * ��ť������
     */
    //����
	 class GengxinListener implements OnClickListener{
		 @Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(GuessGameActivity.this, Update.class);
			startActivity(intent);
		}
	 }
    class ZhangfeiListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			String select="�ŷ�";
			peopleSelext.setText(select);
			
		}
    }
	 class LiubeiListener implements OnClickListener{

				@Override
				public void onClick(View v) {
					String select="����";
					peopleSelext.setText(select);
				}
	 }
	 class GuanyuListener implements OnClickListener{

						@Override
						public void onClick(View v) {
							String select="����";
							peopleSelext.setText(select);
						}
    }
	 class beginGame implements OnClickListener{
		@Override
		public void onClick(View v) {
			Intent intent =new Intent();
			String PeoString=peopleSelext.getText().toString();
			intent.putExtra("peopleSelext", PeoString);
			intent.setClass(GuessGameActivity.this, GameUI.class);
			startActivity(intent);
			
		}
	 }
	
	 //��Ӳ˵� Ҫ��дһ������
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			menu.add(0, 1, 1, "�˳�");
			return super.onCreateOptionsMenu(menu);
		}
	    //Ϊ�˵�����Ӳ��� ҲҪ��дһ������
		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			if(item.getItemId()==1){
				finish();
			}	
		
			return super.onOptionsItemSelected(item);
		}
	 
}