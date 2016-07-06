package tianma.nestednavigation.activity;

import java.util.ArrayList;
import java.util.List;

import tianma.nestednavigation.R;
import tianma.nestednavigation.fragment.FragmentPageAdapter;
import tianma.nestednavigation.fragment.FragmentInfo;
import tianma.nestednavigation.fragment.MeFragment;
import tianma.nestednavigation.fragment.NewsFragment;
import tianma.nestednavigation.fragment.TopicsFragment;
import tianma.nestednavigation.fragment.VideoFragment;
import tianma.nestednavigation.fragment.news.AutoMobileFragment;
import tianma.nestednavigation.fragment.news.HeadlinesFragment;
import tianma.nestednavigation.fragment.news.SportsFragment;
import tianma.nestednavigation.fragment.news.TechnologyFragment;
import android.R.color;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {

	/**
	 * PagerSlidingTabStrip实例
	 */
	private PagerSlidingTabStrip tabStrip;

	/**
	 * 当前屏幕的密度
	 */
	private DisplayMetrics dm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	private void initViews() {
		dm = getResources().getDisplayMetrics();
		ViewPager pager = (ViewPager) findViewById(R.id.main_pager);
		tabStrip = (PagerSlidingTabStrip) findViewById(R.id.bottom_tabs);

		FragmentManager manager = getSupportFragmentManager();
		List<FragmentInfo> infos = new ArrayList<FragmentInfo>();
		infos.add(new FragmentInfo("话题", TopicsFragment.class));
		infos.add(new FragmentInfo("新闻", NewsFragment.class));
		infos.add(new FragmentInfo("视频", VideoFragment.class));
		infos.add(new FragmentInfo("我", MeFragment.class));

		FragmentPageAdapter adapter = new FragmentPageAdapter(manager, infos);

		pager.setAdapter(adapter);
		tabStrip.setViewPager(pager);

		configureTabStrip();

	}

	/**
	 * 对PagerSlidingTabStrip进行各项属性的配置
	 */
	private void configureTabStrip() {
		// 设置Tab是自动填充充满屏幕的
		tabStrip.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		tabStrip.setDividerColor(color.transparent);
		// 设置Tab底部线的高度
		tabStrip.setUnderlineHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 1, dm));
		// 设置Tab Indicator的高度
		tabStrip.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		tabStrip.setIndicatorHeight(0);
		// 设置Tab Indicator的颜色
		tabStrip.setIndicatorColor(Color.parseColor("#45c01a"));
		// 设置Tab标题文字大小
		tabStrip.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// 设置选中Tab文字的颜色
		tabStrip.setSelectedTabTextColor(Color.parseColor("#45c01a"));
		// 取消点击Tab时的背景色
		tabStrip.setTabBackground(0);

	}

}
