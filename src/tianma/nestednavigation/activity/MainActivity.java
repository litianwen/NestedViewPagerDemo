package tianma.nestednavigation.activity;

import java.util.ArrayList;
import java.util.List;

import tianma.nestednavigation.R;
import tianma.nestednavigation.fragment.FoundFragment;
import tianma.nestednavigation.fragment.MeFragment;
import tianma.nestednavigation.fragment.NewsFragment;
import tianma.nestednavigation.fragment.ReadFragment;
import tianma.nestednavigation.fragment.VideoFragment;
import tianma.nestednavigation.fragment.adapter.TabViewPagerAdapter;
import tianma.nestednavigation.widget.TabView;
import android.R.color;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity {

	/**
	 * PagerSlidingTabStrip实例
	 */
	private PagerSlidingTabStrip tabStrip;

	private List<TabView> tabViews;
	private Resources res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	private void initViews() {
		res = getResources();

		ViewPager pager = (ViewPager) findViewById(R.id.main_pager);
		tabStrip = (PagerSlidingTabStrip) findViewById(R.id.bottom_tabs);

		FragmentManager manager = getSupportFragmentManager();
		List<Class<? extends Fragment>> fragmentClasses = new ArrayList<Class<? extends Fragment>>();
		fragmentClasses.add(ReadFragment.class);
		fragmentClasses.add(NewsFragment.class);
		fragmentClasses.add(VideoFragment.class);
		fragmentClasses.add(FoundFragment.class);
		fragmentClasses.add(MeFragment.class);
		initTabViews();
		TabViewPagerAdapter adapter = new TabViewPagerAdapter(manager,
				fragmentClasses, tabViews);
		pager.setAdapter(adapter);
		tabStrip.setViewPager(pager);

		configureTabStrip();

	}

	private void initTabViews() {
		tabViews = new ArrayList<TabView>();
		tabViews.add(buildTabView("阅读", R.drawable.tab_read_selector));
		tabViews.add(buildTabView("新闻", R.drawable.tab_news_selector));
		tabViews.add(buildTabView("视频", R.drawable.tab_video_selector));
		tabViews.add(buildTabView("发现", R.drawable.tab_found_selector));
		tabViews.add(buildTabView("我", R.drawable.tab_me_selector));
	}

	private TabView buildTabView(String text, int imageResId) {
		TabView tabView = new TabView(this);
		tabView.setText(text);
		try {
			ColorStateList colors = res
					.getColorStateList(R.color.tab_text_selector);
			tabView.setTextColor(colors);
		} catch (Exception ignore) {
		}
		tabView.setImageResource(imageResId);
		return tabView;
	}

	/**
	 * 对PagerSlidingTabStrip进行各项属性的配置
	 */
	private void configureTabStrip() {
		// 设置Tab是自动填充充满屏幕的
		tabStrip.setShouldExpand(true);
		// 设置Tab的分割线是透明的
		tabStrip.setDividerColor(color.transparent);
		// 设置Tab底部线的高度 - 取消Tab底部线
		tabStrip.setUnderlineHeight(0);
		// 设置Tab Indicator的高度 - 取消 Indicator
		tabStrip.setIndicatorHeight(0);
		// 取消点击Tab时的背景Drawable
		tabStrip.setTabBackground(0);
	}

}
