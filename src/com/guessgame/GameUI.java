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
	private TextView diannaoprogress;// 显示作用
	private TextView wanjiaprogress;// 显示作用
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
		showSelectPeople.setText("你选择的角色是：" + showPeo);
		// 绑定监听器
		jiadao.setOnClickListener(new jiadaoListener());
		shitou.setOnClickListener(new shitouListener());
		bu.setOnClickListener(new buListener());
	}

	class jiadaoListener implements OnClickListener {// 我出剪刀
		@Override
		public void onClick(View v) {

			int result = (int) (Math.random() * 3 + 1);
			if (result == 1) {
				Chuquan.setText("手机出的是剪刀,你出的也是剪刀，平局");

			} else if (result == 2) {
				computerWin++;
				diannaoprogressBar.setProgress(computerWin);
				Chuquan.setText("手机出的是石头,你出的是剪刀，你输了");
				ComputerWin.setText("手机胜：" + computerWin);
				// 判断谁先到20局，谁就赢，并且停止游戏，就是所有的按钮都不能点
				if (UserWin == 20 || computerWin == 20) {//判断是否到达 20局，到达20局就进入
					//进入就不能让按钮点击了，否则又继续游戏
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// 玩家赢
						Chuquan.setText("恭喜您，您赢了!");
					}
					if (userBar < diannaoBar) {
						// 电脑赢
						Chuquan.setText("很遗憾，您输了！");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("高手啊！平局不容易！");
					}
				}

				diannaoBar = diannaoBar + 5;
				diannaoprogressBar.setProgress(diannaoBar);
			} else if (result == 3) {
				UserWin++;
				Chuquan.setText("手机出的是布,你出的是剪刀，你赢了");
				UsersWin.setText("我方胜：" + UserWin);

				userBar = userBar + 5;
				wanjiaprogressBar.setProgress(userBar);
				// 判断谁先到20局，谁就赢，并且停止游戏，就是所有的按钮都不能点
				if (UserWin == 20 || computerWin == 20) {//判断是否到达 20局，到达20局就进入
					//进入就不能让按钮点击了，否则又继续游戏
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// 玩家赢
						Chuquan.setText("恭喜您，您赢了!");
					}
					if (userBar < diannaoBar) {
						// 电脑赢
						Chuquan.setText("很遗憾，您输了！");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("高手啊！平局不容易！");
					}
				}

			}
		

		}
	}

	class shitouListener implements OnClickListener {// 我出石头
		@Override
		public void onClick(View v) {
			int result = (int) (Math.random() * 3 + 1);
			if (result == 1) {
				UserWin++;
				Chuquan.setText("手机出的是剪刀,你出的是石头，你赢了");
				UsersWin.setText("我方胜：" + UserWin);
				// 判断谁先到20局，谁就赢，并且停止游戏，就是所有的按钮都不能点
				if (UserWin == 20 || computerWin == 20) {//判断是否到达 20局，到达20局就进入
					//进入就不能让按钮点击了，否则又继续游戏
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// 玩家赢
						Chuquan.setText("恭喜您，您赢了!");
					}
					if (userBar < diannaoBar) {
						// 电脑赢
						Chuquan.setText("很遗憾，您输了！");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("高手啊！平局不容易！");
					}
				}

				//

				userBar = userBar + 5;
				wanjiaprogressBar.setProgress(userBar);

			} else if (result == 2) {
				Chuquan.setText("手机出的是石头,你出的也是石头，平局");
			} else if (result == 3) {
				computerWin++;
				Chuquan.setText("手机出的是布,你出的是石头，你输了");
				ComputerWin.setText("手机胜：" + computerWin);

				diannaoBar = diannaoBar + 5;
				diannaoprogressBar.setProgress(diannaoBar);
				// 判断谁先到20局，谁就赢，并且停止游戏，就是所有的按钮都不能点
				if (UserWin == 20 || computerWin == 20) {//判断是否到达 20局，到达20局就进入
					//进入就不能让按钮点击了，否则又继续游戏
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// 玩家赢
						Chuquan.setText("恭喜您，您赢了!");
					}
					if (userBar < diannaoBar) {
						// 电脑赢
						Chuquan.setText("很遗憾，您输了！");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("高手啊！平局不容易！");
					}
				}

			}
			
		}
	}

	class buListener implements OnClickListener {// 我出布
		@Override
		public void onClick(View v) {
			int result = (int) (Math.random() * 3 + 1);
			if (result == 1) {
				computerWin++;
				Chuquan.setText("手机出的是剪刀,你出的是布，你输了");
				ComputerWin.setText("手机胜：" + computerWin);
				diannaoBar = diannaoBar + 5;
				diannaoprogressBar.setProgress(diannaoBar);
				// 判断谁先到20局，谁就赢，并且停止游戏，就是所有的按钮都不能点
				if (UserWin == 20 || computerWin == 20) {//判断是否到达 20局，到达20局就进入
					//进入就不能让按钮点击了，否则又继续游戏
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// 玩家赢
						Chuquan.setText("恭喜您，您赢了!");
					}
					if (userBar < diannaoBar) {
						// 电脑赢
						Chuquan.setText("很遗憾，您输了！");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("高手啊！平局不容易！");
					}
				}

			} else if (result == 2) {
				UserWin++;
				Chuquan.setText("手机出的是石头,你出的是布，你赢了");
				UsersWin.setText("我方胜：" + UserWin);
				userBar = userBar + 5;
				wanjiaprogressBar.setProgress(userBar);
				// 判断谁先到20局，谁就赢，并且停止游戏，就是所有的按钮都不能点
				if (UserWin == 20 || computerWin == 20) {//判断是否到达 20局，到达20局就进入
					//进入就不能让按钮点击了，否则又继续游戏
					jiadao.setClickable(false);
					shitou.setClickable(false);
					bu.setClickable(false);
					if (userBar > diannaoBar) {
						// 玩家赢
						Chuquan.setText("恭喜您，您赢了!");
					}
					if (userBar < diannaoBar) {
						// 电脑赢
						Chuquan.setText("很遗憾，您输了！");
					}
					if(userBar==diannaoBar){
						Chuquan.setText("高手啊！平局不容易！");
					}
				}

			} else if (result == 3) {
				Chuquan.setText("手机出的是布,你出的也是布，平局");
			}

			
		}

	}
}
