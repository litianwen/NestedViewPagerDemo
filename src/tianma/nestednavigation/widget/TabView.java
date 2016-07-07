package tianma.nestednavigation.widget;

import tianma.nestednavigation.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Tab栏中的View
 * 
 * @author tianma
 * 
 */
public class TabView extends LinearLayout {

	private ImageView tabImage;
	private TextView tabText;

	public TabView(Context context) {
		super(context);
		initViews(context, null);
	}

	public TabView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initViews(context, attrs);
	}

	private void initViews(Context context, AttributeSet attrs) {
		// 设置分布方式为垂直分布
		setOrientation(LinearLayout.VERTICAL);
		// 设置TabView内容对齐方式为居中
		setGravity(Gravity.CENTER);

		// 加载TabView
		LayoutInflater.from(context).inflate(R.layout.tab_view, this, true);
		tabImage = (ImageView) findViewById(R.id.tab_image);
		tabText = (TextView) findViewById(R.id.tab_text);
	}

	/**
	 * 设置Tab图标
	 */
	public void setImageResource(int resId) {
		tabImage.setImageResource(resId);
	}

	/**
	 * 设置Tab的文字
	 * 
	 * @param text
	 */
	public void setText(CharSequence text) {
		tabText.setText(text);
	}

	/**
	 * 设置字体颜色
	 * 
	 * @param color
	 */
	public void setTextColor(int color) {
		tabText.setTextColor(color);
	}

	/**
	 * 根据TextView状态(normal, selected, enabled, pressed,etc)设置字体颜色
	 * 
	 * @param colors
	 */
	public void setTextColor(ColorStateList colors) {
		tabText.setTextColor(colors);
	}

	// 覆盖setSelected方法
	@Override
	public void setSelected(boolean selected) {
		tabImage.setSelected(selected);
		tabText.setSelected(selected);
		super.setSelected(selected);
	}

}
