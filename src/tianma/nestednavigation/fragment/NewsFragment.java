package tianma.nestednavigation.fragment;

import java.util.ArrayList;
import java.util.List;

import com.astuetz.PagerSlidingTabStrip;

import tianma.nestednavigation.R;
import tianma.nestednavigation.fragment.news.AutoMobileFragment;
import tianma.nestednavigation.fragment.news.EntertainmentFragment;
import tianma.nestednavigation.fragment.news.FashionFragment;
import tianma.nestednavigation.fragment.news.HeadlinesFragment;
import tianma.nestednavigation.fragment.news.SportsFragment;
import tianma.nestednavigation.fragment.news.TechnologyFragment;
import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 新闻Fragment
 * 
 * @author tianma
 * 
 */
public class NewsFragment extends Fragment {

	private FragmentPageAdapter mPagerAdapter;
	private FragmentManager fm;
	private Context mCtx;

	private View rootView;

	/**
	 * PagerSlidingTabStrip实例
	 */
	private PagerSlidingTabStrip tabStrip;
	/**
	 * 当前屏幕的密度
	 */
	private DisplayMetrics dm;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mCtx = getActivity().getApplicationContext();
		fm = getActivity().getSupportFragmentManager();
		dm = getResources().getDisplayMetrics();

		// 初始化FragmentPagerAdapter
		List<FragmentInfo> infos = new ArrayList<FragmentInfo>();
		infos.add(new FragmentInfo("体育", SportsFragment.class));
		infos.add(new FragmentInfo("汽车", AutoMobileFragment.class));
		infos.add(new FragmentInfo("头条", HeadlinesFragment.class));
		infos.add(new FragmentInfo("科技", TechnologyFragment.class));
		infos.add(new FragmentInfo("娱乐", EntertainmentFragment.class));
		infos.add(new FragmentInfo("时尚", FashionFragment.class));
		mPagerAdapter = new FragmentPageAdapter(fm, infos);
	}

	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = LayoutInflater.from(mCtx).inflate(
					R.layout.fragment_news, null);
			ViewPager pager = (ViewPager) rootView
					.findViewById(R.id.nested_pager);
			tabStrip = (PagerSlidingTabStrip) rootView
					.findViewById(R.id.top_tabs);

			pager.setAdapter(mPagerAdapter);
			tabStrip.setViewPager(pager);
			configureTabStrip();
		}
		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}
		return rootView;
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
		tabStrip.setUnderlineHeight(0);
		// 设置Tab Indicator的高度
		tabStrip.setIndicatorHeight((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 4, dm));
		// 设置Tab Indicator的颜色
		tabStrip.setIndicatorColor(Color.parseColor("#00CDCD"));
		// 设置Tab标题文字大小
		tabStrip.setTextSize((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_SP, 16, dm));
		// 设置选中Tab文字的颜色
		tabStrip.setSelectedTabTextColor(Color.parseColor("#00CDCD"));
		// 取消点击Tab时的背景色
		tabStrip.setTabBackground(0);

	}

}
