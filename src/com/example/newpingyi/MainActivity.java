package com.example.newpingyi;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements
		GestureDetector.OnGestureListener, OnTouchListener {
	public ImageView imageView;
	public int mtopmargin = 670;
	public GestureDetector mGestureDetector = null;
	private float mScrollY;
	private float bottomY;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//gestureScanner = new GestureDetector(this); 
		setContentView(R.layout.activity_main);
		this.setTitle("智能家居可控窗帘(平移)");
		final Handler handler=new Handler();
		final Runnable r = new Runnable()
		{
		    public void run() 
		    {
		    	Toast.makeText(
						context,
						"StatusBarHeight:" + getStatusBarHeight()
								+ ".....TitleBarHeight:" + getTitleBarHeight(),
						Toast.LENGTH_SHORT).show();
		    	//handler.postDelayed(this, 1000);
		    }
		};
		handler.postDelayed(r, 1000);
//		tvContent = (TextView)findViewById(R.id.tvContent);
//	    tvContent.postDelayed(new Runnable() {
//	 
//	        @Override
//	        public void run() {
//	             String display = String.format("Status Bar Height = %d\nTitle Bar Height = %d", getStatusBarHeight(), getTitleBarHeight());
//	             tvContent.setText(display);
//	 
//	        }
//	    }, 2000);
		// /*String testCase = */Test.TestParams.ttt = "1111";

		// LinearLayout.LayoutParams.WRAP_CONTENT = -1;

		context = this;
		imageView = (ImageView) findViewById(R.id.imageview);
		mGestureDetector = new GestureDetector(this, new LearnGestureListener());
		mGestureDetector.setIsLongpressEnabled(false);

		// LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
		// LinearLayout.LayoutParams.WRAP_CONTENT,
		// LinearLayout.LayoutParams.WRAP_CONTENT);
		// imageView.setLayoutParams(lp);
		imageView.setLongClickable(true);
		// lp.height = 50;

		RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) imageView
				.getLayoutParams();
		mScrollY = lp.topMargin;
		// bottomY = lp.bottomMargin;
		// Toast.makeText(context, "" + bottomY, Toast.LENGTH_SHORT).show();
		imageView.setOnTouchListener(new View.OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {

				// TODO Auto-generated method stub
				// Toast.makeText(context, "" + mScrollY,
				// Toast.LENGTH_SHORT).show();
				return mGestureDetector.onTouchEvent(event);

			}
		});

	}

	class LearnGestureListener extends GestureDetector.SimpleOnGestureListener {
		@Override
		public boolean onDown(MotionEvent e) {

			return false;
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {

			return false;
		}

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			float y1 = e1.getY();
			float y2 = e2.getY();
			float temp = y2 - y1;
			mScrollY += temp;
			// bottomY += temp;
			// Toast.makeText(context, "" + temp+"....."+e1.getYPrecision(),
			// Toast.LENGTH_SHORT).show();
			RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) imageView
					.getLayoutParams();
			lp.setMargins(0, (int) mScrollY, 0, 0);
			imageView.setLayoutParams(lp);
			// LayoutParams lp = (LayoutParams) imageView.getLayoutParams();
			// if (lp.topMargin > 0 && mScrollY > 0) {
			// lp.topMargin = lp.topMargin + (int) mScrollY;
			// imageView.setLayoutParams(lp);
			//
			// } else if (lp.topMargin < mtopmargin && mScrollY < 0) {
			// lp.topMargin = lp.topMargin + (int) mScrollY;
			// imageView.setLayoutParams(lp);
			// }
			return false;
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			return false;
		}

		@Override
		public void onLongPress(MotionEvent e) {
		}

		@Override
		public void onShowPress(MotionEvent e) {
		}

	}

	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getStatusBarHeight() {
		Rect r = new Rect();
		Window w = getWindow();
		w.getDecorView().getWindowVisibleDisplayFrame(r);
		return r.top;
	}

	public int getTitleBarHeight() {
		int viewTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT)
				.getTop();
		return (viewTop - getStatusBarHeight());
	}

	@Override
	protected void onResume() {
		super.onResume();
//		Toast.makeText(
//				context,
//				"StatusBarHeight:" + getStatusBarHeight()
//						+ ".....TitleBarHeight:" + getTitleBarHeight(),
//				Toast.LENGTH_SHORT).show();
	}

//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		int width = MeasureSpec.getSize(widthMeasureSpec);
//		int height = MeasureSpec.getSize(heightMeasureSpec);
//	}
}