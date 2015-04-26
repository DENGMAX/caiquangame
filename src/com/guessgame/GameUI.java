package com.guessgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class GameUI extends Activity {
	private TextView showSelectPeople;
	private TextView Chuquan;
	private TextView ComputerWin;
	private TextView UsersWin;
	private Button jiadao;
	private Button shitou;
	private Button bu;
	private TextView diannaoprogress;// ��ʾ����
	private TextView wanjiaprogress;// ��ʾ����
	private ProgressBar diannaoprogressBar;
	private ProgressBar wanjiaprogressBar;
	int computerWin = 0;
	int UserWin = 0;
	int diannaoBar = 0;
	int userBar = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gameui);
		Chuquan = (TextView) findViewById(R.id.Chuquan);
		showSelectPeople = (TextView) findViewById(R.id.showSelectPeople);
		Chuquan = (TextView) findViewById(R.id.Chuquan);
		jiadao = (Button) findViewById(R.id.jiadao);
		shitou = (Button) findViewById(R.id.shitou);
		bu = (Button) findViewById(R.id.bu);
		ComputerWin = (TextView) findViewById(R.id.computerWin);
		UsersWin = (TextView) findViewById(R.id.UserWin);
		diannaoprogress = (TextView) findViewById(R.id.diannaoprogress);
		wanjiaprogress = (TextView) findViewById(R.id.wanjiaprogress);
		diannaoprogressBar = (ProgressBar) findViewById(R.id.diannaoprogressBar);
		wanjiaprogressBar = (ProgressBar) findViewById(R.id.wanjiaprogressBar);
		//
		Intent str = getIntent();
		String showPeo = str.getStringExtra("peopleSelext");
		showSelectPeople.setText("��ѡ��Ľ�ɫ�ǣ�" + showPeo);
		// �󶨼�����
		jiadao.setOnClickListener(new jiadaoListener());
		shitou.setOnClickListener(new shitouListener());
		bu.setOnClickListener(new buListener());
	}

	class jiadaoListener implements OnClickListener {// �ҳ�����
		@Override
		public void onClick(View v) {

			int result = (int) (Math.random() * 3 + 1);
			if (result == 1) {
				Chuquan.setText("�ֻ������Ǽ���,�����Ҳ�Ǽ�����ƽ��");

			} else if (result == 2) {
				computerWin++;
				diannaoprogressBar.setProgress(computerWin);
				Chuquan.setText("�ֻ�������ʯͷ,������Ǽ�����������");
				ComputerWin.setText("�ֻ�ʤ��" + computerWin);
				// �ж�˭�ȵ�20�֣�˭��Ӯ������ֹͣ��Ϸ���������еİ�ť�����ܵ�
				if (UserWin == 20 || computerWin == 20) {//�ж��Ƿ񵽴� 20�֣�����20�־ͽ���
					//����Ͳ����ð�ť����ˣ������ּ�����Ϸ
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// ���Ӯ
						Chuquan.setText("��ϲ������Ӯ��!");
					}
					if (userBar < diannaoBar) {
						// ����Ӯ
						Chuquan.setText("���ź��������ˣ�");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("���ְ���ƽ�ֲ����ף�");
					}
				}

				diannaoBar = diannaoBar + 5;
				diannaoprogressBar.setProgress(diannaoBar);
			} else if (result == 3) {
				UserWin++;
				Chuquan.setText("�ֻ������ǲ�,������Ǽ�������Ӯ��");
				UsersWin.setText("�ҷ�ʤ��" + UserWin);

				userBar = userBar + 5;
				wanjiaprogressBar.setProgress(userBar);
				// �ж�˭�ȵ�20�֣�˭��Ӯ������ֹͣ��Ϸ���������еİ�ť�����ܵ�
				if (UserWin == 20 || computerWin == 20) {//�ж��Ƿ񵽴� 20�֣�����20�־ͽ���
					//����Ͳ����ð�ť����ˣ������ּ�����Ϸ
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// ���Ӯ
						Chuquan.setText("��ϲ������Ӯ��!");
					}
					if (userBar < diannaoBar) {
						// ����Ӯ
						Chuquan.setText("���ź��������ˣ�");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("���ְ���ƽ�ֲ����ף�");
					}
				}

			}
		

		}
	}

	class shitouListener implements OnClickListener {// �ҳ�ʯͷ
		@Override
		public void onClick(View v) {
			int result = (int) (Math.random() * 3 + 1);
			if (result == 1) {
				UserWin++;
				Chuquan.setText("�ֻ������Ǽ���,�������ʯͷ����Ӯ��");
				UsersWin.setText("�ҷ�ʤ��" + UserWin);
				// �ж�˭�ȵ�20�֣�˭��Ӯ������ֹͣ��Ϸ���������еİ�ť�����ܵ�
				if (UserWin == 20 || computerWin == 20) {//�ж��Ƿ񵽴� 20�֣�����20�־ͽ���
					//����Ͳ����ð�ť����ˣ������ּ�����Ϸ
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// ���Ӯ
						Chuquan.setText("��ϲ������Ӯ��!");
					}
					if (userBar < diannaoBar) {
						// ����Ӯ
						Chuquan.setText("���ź��������ˣ�");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("���ְ���ƽ�ֲ����ף�");
					}
				}

				//

				userBar = userBar + 5;
				wanjiaprogressBar.setProgress(userBar);

			} else if (result == 2) {
				Chuquan.setText("�ֻ�������ʯͷ,�����Ҳ��ʯͷ��ƽ��");
			} else if (result == 3) {
				computerWin++;
				Chuquan.setText("�ֻ������ǲ�,�������ʯͷ��������");
				ComputerWin.setText("�ֻ�ʤ��" + computerWin);

				diannaoBar = diannaoBar + 5;
				diannaoprogressBar.setProgress(diannaoBar);
				// �ж�˭�ȵ�20�֣�˭��Ӯ������ֹͣ��Ϸ���������еİ�ť�����ܵ�
				if (UserWin == 20 || computerWin == 20) {//�ж��Ƿ񵽴� 20�֣�����20�־ͽ���
					//����Ͳ����ð�ť����ˣ������ּ�����Ϸ
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// ���Ӯ
						Chuquan.setText("��ϲ������Ӯ��!");
					}
					if (userBar < diannaoBar) {
						// ����Ӯ
						Chuquan.setText("���ź��������ˣ�");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("���ְ���ƽ�ֲ����ף�");
					}
				}

			}
			
		}
	}

	class buListener implements OnClickListener {// �ҳ���
		@Override
		public void onClick(View v) {
			int result = (int) (Math.random() * 3 + 1);
			if (result == 1) {
				computerWin++;
				Chuquan.setText("�ֻ������Ǽ���,������ǲ���������");
				ComputerWin.setText("�ֻ�ʤ��" + computerWin);
				diannaoBar = diannaoBar + 5;
				diannaoprogressBar.setProgress(diannaoBar);
				// �ж�˭�ȵ�20�֣�˭��Ӯ������ֹͣ��Ϸ���������еİ�ť�����ܵ�
				if (UserWin == 20 || computerWin == 20) {//�ж��Ƿ񵽴� 20�֣�����20�־ͽ���
					//����Ͳ����ð�ť����ˣ������ּ�����Ϸ
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// ���Ӯ
						Chuquan.setText("��ϲ������Ӯ��!");
					}
					if (userBar < diannaoBar) {
						// ����Ӯ
						Chuquan.setText("���ź��������ˣ�");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("���ְ���ƽ�ֲ����ף�");
					}
				}

			} else if (result == 2) {
				UserWin++;
				Chuquan.setText("�ֻ�������ʯͷ,������ǲ�����Ӯ��");
				UsersWin.setText("�ҷ�ʤ��" + UserWin);
				userBar = userBar + 5;
				wanjiaprogressBar.setProgress(userBar);
				// �ж�˭�ȵ�20�֣�˭��Ӯ������ֹͣ��Ϸ���������еİ�ť�����ܵ�
				if (UserWin == 20 || computerWin == 20) {//�ж��Ƿ񵽴� 20�֣�����20�־ͽ���
					//����Ͳ����ð�ť����ˣ������ּ�����Ϸ
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// ���Ӯ
						Chuquan.setText("��ϲ������Ӯ��!");
					}
					if (userBar < diannaoBar) {
						// ����Ӯ
						Chuquan.setText("���ź��������ˣ�");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("���ְ���ƽ�ֲ����ף�");
					}
				}

			} else if (result == 3) {
				Chuquan.setText("�ֻ������ǲ�,�����Ҳ�ǲ���ƽ��");
			}

			
		}

	}
}
